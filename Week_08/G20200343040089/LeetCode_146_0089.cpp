//	Implement LRU using doubly linked list and hash table
class DLinkedNode {
public:
    int key;
    int value;
    DLinkedNode *next;
    DLinkedNode *prev;
    DLinkedNode(int key = -1, int value = -1) {
        this->key = key;
        this->value = value;
        next = nullptr;
        prev = nullptr;
    }
};
class DLinkedList {
public:
    DLinkedNode *head;
    DLinkedNode *tail;
    DLinkedList() {
        head = new DLinkedNode();
        tail = new DLinkedNode();

        head->next = tail;
        tail->prev = head;
    }
    void addNode(DLinkedNode *node) {
        //  Always add the new node right after head.
        node->prev = head;
        node->next = head->next;

        head->next->prev = node;
        head->next = node;
    }
    void removeNode(DLinkedNode *node) {
        //  Remove an existing node from the linked list.
        DLinkedNode *prev = node->prev;
        DLinkedNode *next = node->next;

        prev->next = next;
        next->prev = prev;
    }
    void moveToHead(DLinkedNode *node) {
        //  Move certain node in between to the head
        removeNode(node);
        addNode(node);
    }
    DLinkedNode *popTail(void) {
        //  Pop the current tail
        DLinkedNode *node = tail->prev;
        removeNode(node);
        return node;
    }
    ~DLinkedList() {
        DLinkedNode *node;
        while (head->next != nullptr) {
            node = head;
            head = head->next;

            node->next = nullptr;
            node->prev = nullptr;
            delete node;
        }
    }
};
class LRUCache {
public:
    LRUCache(int capacity) {
        this->size = 0;
        this->capacity = capacity;

        dList = new DLinkedList();
        cache = unordered_map<int, DLinkedNode*>();
    }
    
    int get(int key) {
        if (cache.find(key) == cache.end()) return -1;
        DLinkedNode *node = cache[key];

        //  move the accessed node to the head
        dList->moveToHead(node);

        return node->value;
    }
    
    void put(int key, int value) {
        if (cache.find(key) == cache.end()) {
            DLinkedNode *newNode = new DLinkedNode();
            newNode->key = key;
            newNode->value = value;
            
            cache[key] = newNode;
            dList->addNode(newNode);
            
            ++size;
            if (size > capacity) {
                //  pop the tail
                DLinkedNode *tail = dList->popTail();
                cache.erase(tail->key);
                tail->next = nullptr;
                tail->prev = nullptr;
                delete tail;
                --size;
            }
        } else {
            DLinkedNode *node = cache[key];
            //  update the value;
            node->value = value;
            dList->moveToHead(node);
        }
    }
    ~LRUCache() {
        delete dList;
    }
private:
    DLinkedList *dList;
    unordered_map<int, DLinkedNode*> cache;
    int size;
    int capacity;
};