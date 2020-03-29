# 学习笔记

### **C++ deque(GUN 2.9)**

```
    底层是一个数组，数组内放的是指向buffer的指针
    最开始放入的buffer指针应该是位于底层数组的中间的，为了两边都有空间进行两端扩充
    需要向两端扩展的时候，就申请buffer内存，然后将新加buffer的地址插入底层数组的首元素之前或者尾元素之后
    buffer才是真正存放数据的地方，一块buffer的大小是固定的
    
    当底层数组满的时候，会进行扩充，即新申请一个底层数组，将老的底层数据中的buffer的指针copy到新数组中，同样为了两边都有空间进行buffer扩充，copy要copy到新底层数组的中间


    deque的迭代器
        四根指针
            1.cur: 当前访问的元素在当前buffer中的地址
            2.first: 当前访问的buffer的首地址
            3.last: 当前访问的buffer的尾元素地址的后一个地址
            4.node: 当前访问的buffer在底层数组中的地址(底层数组中存放的是b所有uffer的地址)
        
        start iterator
            cur: 整个deque首元素的地址，应该在底层数组首元素所指向的buffer中的第一个元素
            first: 底层数组首元素所指向的buffer的首元素地址
            last: 底层数组首元素所指向的buffer的尾元素地址的后一个地址
            node: 底层数组首元素地址
        
        finish iterator
            cur: 整个deque尾元素后一个元素的地址(前闭后开)，应该在底层数组尾元素所指向的buffer中第一个空元素
            first: 底层数组尾元素所指向的buffer的首元素地址
            last: 底层数组尾元素所指向的buffer的尾元素地址的后一个地址
            node: 底层数组尾元素地址

    源码
    deque
        // 看一个类的时候，需要先观察其data部分
        /*
            如果n不为0，传回n，表示buffer_size由使用者自定义
            如果n为0，表示buffer_size使用预设值，那么
                如果sz=sizeof(value_type)小于512字节，传回512/sz
                如果sz不小于512，则传回1，即一个buffer只存放一个元素
            inline size_t __deque_buf_size(size_t n, size_t sz) {
                return n != 0 ? n : (sz<512 ? size_t(512/sz) : size_t(1));
            }
        */
        template<class T, class Alloc=alloc, size_t Bufsiz=0>
        class deque {
        public:
            typedef T value_type;
            typedef __deque_iterator<T, T&, T*, Bufsiz> iterator;
        protected:
            typedef pointer* map_pointer; // T**
        protected:
            // data部分，首先重点关注
            // 总共data大小是2个iterator(每个iterator中4根指针)，1个指针，1个size_type(4字节，unsigned long)
            iterator start;
            iterator finish;
            // 指向底层数组首元素的指针，因为底层数组内存放的是指针，所以是指向指针的指针
            map_pointer map;
            // 底层数组的大小
            size_type map_size;
        public:
            iterator begin() { return start; }
            iterator end() { return finish; }
            size_type size() const { return finish - start; }
        ...
        };

    deque iterator
        template<clas T, class Ref, class Ptr, size_t Bufsiz>
        struct __deque_iterator {
            typedef random_access_iterators_tag iterator_category; // 1
            typedef T value_type; // 2
            typedef Ptr pointer // 3
            typedef Ref reference; // 4
            typedef ptrdiff_t difference_type; // 5
            typedef size_t size_type;
            typedef T** map_pointer;
            typedef __deque_iterator self;

            // 数据部分
            T* cur;
            T* first;
            T* last;
            map_pointer node;
        }


    deque<T>::insert()
        // 在position处安插一个元素，其值为x
        iterator insert(iterator position, const value_type& x) {
            if(position.cur == start.cur) { // 如果安插点是deque的最前端交给push_front()做
                push_front(x);
                return start;
            } else if(position.cur == finish.cur) { // 如果安插点是deque的最尾端交给push_back()做
                push_back(x);
                iterator tmp = finish;
                --tmp;
                return finish;                
            } else {
                return insert_aux(position, x);
            }
        }

        template<class T, class Alloc, size_t Bufsiz>
        typename deque<T, Alloc, Bufsiz>::iterator
        deque<T, Alloc, Bufsiz>::insert_aux(iterator pos, const value_type& x) {
            difference_type index = pos - start; // 安插点之前的元素个数
            value_type x_copy = x;
            if (index < size() / 2) {   // 如果安插点之前的元素个数较少
                push_front(front());    // 在最前端加入与第一元素同值的元素
                ...
                copy(front2, pos1, front1); // 元素搬移
            } else {    // 安插点之后的元素个数较少
                push_back(back());  // 在尾端加入与最末元素同值的元素
                ...
                copy_backward(pos, back2, back1);   // 元素搬移
            }
            // 上面进行元素搬移之后，安插点的位置就空出来了，就可以设定新值了
            *pos = x_copy;  // 在安插点上设定新值
            return pos;
        }

    deque如何模拟连续空间(全都是deque iterators的功劳)
        reference operator[] (size_type n) {
            return start[difference_type(n)];
        }

        reference front() {
            // 因为finish指向的是最后一个元素后面的位置，所以需要倒退一格
            iterator tmp = finish;
            --tmp;
            return *tmp;
        }
        size_type size() const {
            // 操作符重载operator-，看两个迭代器中间有多少个buffer，把缓冲区个数*一个缓冲区里面的元素个数
            return finish - start;
        }
        bool empty() {
            return finish == start;
        }

        reference operator* () const {
            return *cur;
        }
        pointer operator->() const {
            return &(operator*());
        }

        difference_type operator - (const self& x) const {  // 当前元素就是-操作符的左操作数，x元素是右操作数
            //        一个buffer的大小            buffer的数量(去掉当前元素所在buffer以及x元素所在buffer，所以要再减1)
            return difference_type(buffer_size()) * (node - x.node - 1) + (last - cur) + (x.cur- x.first);
            //                                                    当前元素所在buffer的元素量   x元素所在buffer的元素量
            //                                                      操作: 当前元素 - x元素
        }
        
        self& operator ++ () {
            ++cur;  // 切换至下一个元素
            if(cur == last) {   // 如果抵达缓冲区的尾端 
                set_ndoe(node + 1); // 就跳至下一个节点（缓冲区）
                cur = first;    // 的起点
            }
            return *this;
        }
        self& operator ++ (int) {
            self tmp = *this;
            // ！！！复写后++的时候调用前++
            ++*this;
            return tmp;
        }

        self& operator -- () {
            if(cur == first) {   // 如果抵达缓冲区的起头
                set_ndoe(node - 1); // 就跳至上一个节点（缓冲区）
                cur = last;    // 的末端(上一个缓冲区最后一个元素的后面一个位置)
            }
            --cur;  // 往前移一个元素（即末尾元素）
            return *this;
        }
        self& operator -- (int) {
            self tmp = *this;
            --*this;
            return tmp;
        }

        void set_node(map_pointer new_node) {
            node = new_node;
            first = *new_node;
            last = first + difference_type(buffer_size());
        }

        self& operator += (difference_type n) {
            difference_type offset = n + (cur - first);
            if(offset >= 0 && offset < difference_type(buffer_size())) {
                // 目标位置和当前元素在同一缓冲区内
                cur += n;
            } else {
                // 目标位置和当前元素怒不在同一缓冲区内
                // +=负数不是很懂???
                difference_type node_offset = offset > 0 ? offset / difference_type(buffer_size()) : -difference_type((-offset - 1) / buffer_size()) - 1;
                // 切换至目标位置所在的缓冲区
                set_node(node + node_offset);
                // 切换至目标元素
                cur = first + (offset - node_offset * difference_type(buffer_size));
            }
            return *this;
        }

        self operator + (difference_type n) const {
            self tmp = *this;
            return tmp += n;
        }

        self& operator -= (difference_type n) {
            return *this += -n;
        }

        self operator - (difference_type n) const {
            self tmp = *this;
            return tmp -= n;
        }
        
        reference operator[] (difference_type n) const {
            return *(*this + n);
        }
```

### **C++ hashtable(GUN 2.9)**

```
   对object计算出一个数值（ID），用这个数值（ID）对存储空间的大小（bucket数量，可以理解为数组的长度）取余，然后将该object放到对应编号的bucket里(数组中这个余数索引的位置)
    如果对两个object计算出来的ID相同，那就会落到相同的位置上，就发生了冲突，解决冲突最常见的办法就是链地址法，即bucket(数组)中存放一个指针，指针指向一个链表，发生冲突的元素都加到这个链表的尾部
    如果链表很长，搜索速度就很慢，这时候就需要将其打散(rehashing)，如果所有bucket里面所放的全部元素数量要等于bucket的数量，就要进行打散，打散时将bucket数量进行增加
    通常业界都会使用素数来作为bucket的数量，GUN中一开始bucket的数量就是53，当要扩容的时候，就选53倍数附近的素数，53的2倍是106，106附近的素数是97，所以53个bucket就扩充成97个bucket，这些素数在GUN中是写死的
    然后用原本所存的所有的object ID对扩容后的bucket数量取余，余数就是这些object的新位置，原有的所有元素都有进行重新计算
    这样打散之后，较长的链表就会变短

    bucket的数量永远大于元素的数量
    当元素数量等于bucket数量时就要进行bucket扩充，4.9扩充到多少和2.9不大一样（2.9是写死的一些素数，4.9是计算出来）

    源码
        // 这里key和value和前面红黑树一样
        // HashFcn(仿函数) 计算object ID的仿函数
        // ExtractKey(仿函数) 如何从Value中取出Key，hashtable中存的元素是key和value的结合体，你插入元素的时候也需要将key和data的结合起来，可能结合成一个pair，所以你要告诉它怎么从这个结合体中取出key，和红黑树中的KeyofValue仿函数一样
        // EqualKey(仿函数) 怎么判断两个key相等
        template<class Value, class Key, class HashFcn, class ExtractKey, class EqualKey, class Alloc=alloc>
        class hashtable {
        public:
            typedef HashFcn hasher;
            typedef EqualKey key_equal;
            typedef size_t size_type;
        private:
            // hashtable本身所存的数据区域（在32位计算机(指针4字节，64位计算机指针8字节)，总共大小19个字节，需要调整为4字节对齐，所以调整为20个字节）
            // 用上面那三个仿函数(class)，创建了三个函数对象，仿函数对象中没有data，所以大小为0，由于编译器的原因做出来大小是1
            hasher hash;
            key_equal equals;
            ExtractKey get_key;
            // 复合类
            // __hashtable_node就是链表中的一个节点
            typedef __hashtable_node<Value> node;
            // vector中每个元素存的是指向__hashtable_node的指针，即指向链表的指针
            // vector本身里面有三个指针，所以vector的大小是三个指针的大小
            vector<node*, Alloc> buckets;
            // 目前hashtable中总共有多少元素，unsigned int，4个字节
            size_type num_elements;
        public:
            // 返回bucket的数量
            size_type bucket_count() const {return buckets.size();}
        };

        tempalte<class Value>
        // 链表的节点
        struct __hashtable_node {
            __hashtable_node* next;
            Value val;
        };

        // hashtable的迭代器
        // 迭代器++，当走到一条链表的末尾的时候，它需要能回到vector中，然后进入下一个bucket继续++
        template<class Value, class Key, class HashFcn, class ExtractKey, class EqualKey, class Alloc>
        struct __hashtable_iterator {
            ...
            // 指向链表中的某个节点，即指向hashtable中的一个元素
            node* cur;
            // 指向hashtable本身的指针，即指向vector的指针(buckets)
            hashtable *ht;
        };

        // 调用hashtable
        // key是字符串，value和key相同，value就是key，key就是value
        hashtable<const char*, const char*, hash<const char*>, identity<const char*>, eqstr, alloc> ht(50, hash<const char*>(), eqstr());
        ht.insert_unique("kiwi");
        ht.insert_unique("plum");
        ht.insert_unique("apple");

        // 比较两个c string是否相等，有strcmp()可以用，但它传回-1、0、1，不是传回bool，所以必须封装一层
        struct eqstr {
            bool operator() (const char* s1, const char* s2) const {
                return strcmp(s1, s2) == 0;
            }
        };



    hash-function，hash-code(hash-function的返回)
        // 泛化
        template<class Key>
        struct hash {};

        // 特化
        // __STL_TEMPLATE_NULL就是template<>的别名
        __STL_TEMPLATE_NULL struct hash<char> {
            size_t operator() (char x) const {return x;}
        };
        __STL_TEMPLATE_NULL struct hash<short> {
            size_t operator() (short x) const {return x;}
        };
        __STL_TEMPLATE_NULL struct hash<unsigned short> {
            size_t operator() (unsigned short x) const {return x;}
        };
        __STL_TEMPLATE_NULL struct hash<int> {
            size_t operator() (int x) const {return x;}
        };
        __STL_TEMPLATE_NULL struct hash<unsigned int> {
            size_t operator() (unsigned int x) const {return x;}
        };
        __STL_TEMPLATE_NULL struct hash<long> {
            size_t operator() (long x) const {return x;}
        };
        __STL_TEMPLATE_NULL struct hash<unsigned long> {
            size_t operator() (unsigned long x) const {return x;}
        };
        
        
        inline size_t __stl_hash_string(const char* s) {
            unsigned long h = 0;
            // 本例若s指向"abc"，计算得h为 5*(5*'a'+'b')+'c'
            for( ; *s; s++)
                h = 5 * h + *s;

            return size_t(h);
        }
        
        __STL_TEMPLATE_NULL struct hash<char*> {
            size_t operator() (char* s) const {return __stl_hash_string(s);}
        };
        __STL_TEMPLATE_NULL struct hash<const char*> {
            size_t operator() (const char* s) const {return __stl_hash_string(s);}
        };
        // 标准库没有提供现成的hash<std::string>，即没有提供c++标准库的string的hash function
        // 如果标准库中没有提供你所定义类型的hash function，你就需要按照上面的这种形式写出一个特化的版本，至于传入一个东西，hash function里面传出来什么就是你要设计的
        // 你自定义类型中的数据也不外乎是浮点数，整数，字符串这些类型，既然对于这些基本类型都有hash function，可以这么设计，将自定义类型中的每个数据元素都用现有的hash funciton计算出其hash code，然后将这些元素的hash code加起来的和作为这个自定义类型的hash code

        // hash function 的目的，就是希望根据元素值算出一个hash code（一个可进行模运算(%)的值），使得元素经hash code映射之后的能够"够杂够乱够随机"的被放置于hashtable内。越是杂乱，越不容易产生碰撞
    
    取模运算(modules运算)
        // find函数、count函数、operator++函数，最后都会调用这个函数计算一个object需要放到哪个bucket里
        // 决定一个元素要落到哪个bucket中的计算函数
        size_type bkt_num_key(const key_type& key, size_t n) const {
            // 这个hash不是上面的struct hash(struct hash只是标准库针对基本类型的hash function的实现，有些自定义类型需要自己实现hash function)
            // 而是class hashtable中的hasher hash(这里的hash是外部传给class hashtable的HashFcn)
            return hash(key) % n;
        }
```
