c++ priority_queue 源码分析

首先优先队列是用堆来构造的。
所以，优先队列其实并不能叫队列，它的完整定义应该是这样的：优先队列是用堆来构造，包装成队列的适配器。
-------------------------------------------------------------------------------------------------------
标准库stl_queue.h中的priority_queue的源码如下

stl_queue.h

template <typename _Tp, typename _Sequence = vector<_Tp>,
          typename _Compare = less<typename _Sequence::value_type>>
class priority_queue
{
public:
    typedef typename _Sequence::value_type value_type;
    typedef typename _Sequence::reference reference;
    typedef typename _Sequence::const_reference const_reference;
    typedef typename _Sequence::size_type size_type;
    typedef _Sequence container_type;

protected:
    //  See queue::c for notes on these names.
    _Sequence c;
    _Compare comp;
}
模板参数中，_Sequence默认是vector<_Tp>，也就是说priority_queue默认以vector作为容器，但是支持任意有push_back，pop_back，front成员函数，并且提供随机迭代器的容器.
成员函数只有序列c和比较函数comp。

从类的模板参数可以看出来，如果想要自定义优先级，那么就必须把第二个模板参数显示地写出来，即std::priority_queue<int, std::vector<int>, std::greater<int>>

public:
    explicit priority_queue(const _Compare &__x,
                            const _Sequence &__s)
        : c(__s), comp(__x)
    {
        std::make_heap(c.begin(), c.end(), comp);
    }

    explicit priority_queue(const _Compare &__x = _Compare(),
                            _Sequence &&__s = _Sequence())
        : c(std::move(__s)), comp(__x)
    {
        std::make_heap(c.begin(), c.end(), comp);
    }
    
    template <typename _InputIterator>
    priority_queue(_InputIterator __first, _InputIterator __last,
                   const _Compare &__x,
                   const _Sequence &__s)
        : c(__s), comp(__x)
    {
        c.insert(c.end(), __first, __last);
        std::make_heap(c.begin(), c.end(), comp);
    }
    
    template <typename _InputIterator>
    priority_queue(_InputIterator __first, _InputIterator __last,
                   const _Compare &__x = _Compare(),
                   _Sequence &&__s = _Sequence())
        : c(std::move(__s)), comp(__x)
    {
        c.insert(c.end(), __first, __last);
        std::make_heap(c.begin(), c.end(), comp);
    }
可以看到，priority_queue的构造函数就是在构造一个堆（大顶堆）

