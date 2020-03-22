// 运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制。它应该支持以下操作： 获取数据 get 和 写入数据 put 。

// 获取数据 get(key) - 如果密钥 (key) 存在于缓存中，则获取密钥的值（总是正数），否则返回 -1。
// 写入数据 put(key, value) - 如果密钥不存在，则写入其数据值。当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。

// 进阶:

// 你是否可以在 O(1) 时间复杂度内完成这两种操作？

// 示例:

// LRUCache cache = new LRUCache( 2 /* 缓存容量 */ );

// cache.put(1, 1);
// cache.put(2, 2);
// cache.get(1);       // 返回  1
// cache.put(3, 3);    // 该操作会使得密钥 2 作废
// cache.get(2);       // 返回 -1 (未找到)
// cache.put(4, 4);    // 该操作会使得密钥 1 作废
// cache.get(1);       // 返回 -1 (未找到)
// cache.get(3);       // 返回  3
// cache.get(4);       // 返回  4

/**
 * @property {number} key
 * @property {number} value
 * @property {ListNode} prev
 * @property {ListNode} next
 */
class ListNode {
  constructor(key, value) {
    this.key = key;
    this.value = value;
    this.prev = null;
    this.next = null;
  }
}

/**
 * @property {number} capacity
 * @property {Map<number, ListNode>} hashMap
 * @property {ListNode} head
 * @property {ListNode} tail
 */
class LRUCache {
  constructor(capacity) {
    this.capacity = capacity;
    this.hashMap = new Map();
    // 初始化链表为 head <-> tail
    this.head = new ListNode();
    this.tail = new ListNode();
    this.head.next = this.tail;
    this.head.prev = this.tail;
    this.tail.next = this.head;
    this.tail.prev = this.head;
  }

  /**
   * O(1)
   * @param {number} key
   * @return {number}
   */
  moveToTail(key) {
    // # 先将哈希表key指向的节点拎出来，为了简洁起名node
    // #      hashmap[key]                               hashmap[key]
    // #           |                                          |
    // #           V              -->                         V
    // # prev <-> node <-> next         pre <-> next   ...   node
    const node = this.hashMap.get(key);
    node.prev.next = node.next;
    node.next.prev = node.prev;
    // # 之后将node插入到尾节点前
    // #                 hashmap[key]                 hashmap[key]
    // #                      |                            |
    // #                      V        -->                 V
    // # prev <-> tail  ...  node                prev <-> node <-> tail
    node.prev = this.tail.prev;
    node.next = this.tail;
    this.tail.prev.next = node;
    this.tail.prev = node;
  }

  /**
   * @param {number} key
   * @return {number}
   */
  get(key) {
    if (this.hashMap.has(key)) {
      // # 如果已经在链表中了久把它移到末尾（变成最新访问的）
      this.moveToTail(key);
      return this.hashMap.get(key).value;
    }
    return -1;
  }

  /**
   * @param {number} key
   * @param {number} value
   * @return {void}
   */
  put(key, value) {
    if (this.hashMap.has(key)) {
      // # 如果key本身已经在哈希表中了就不需要在链表中加入新的节点
      // # 但是需要更新字典该值对应节点的value
      this.hashMap.get(key).value = value;
      // # 之后将该节点移到末尾
      this.moveToTail(key);
      return;
    }
    if (this.hashMap.size === this.capacity) {
      // # 去掉哈希表对应项
      this.hashMap.delete(this.head.next.key);
      // # 去掉最久没有被访问过的节点，即头节点之后的节点
      this.head.next = this.head.next.next;
      this.head.next.prev = this.head;
    }

    // # 如果不在的话就插入到尾节点前
    const newNode = new ListNode(key, value);
    this.hashMap.set(key, newNode);
    newNode.prev = this.tail.prev;
    newNode.next = this.tail;
    this.tail.prev.next = newNode;
    this.tail.prev = newNode;
  }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * var obj = new LRUCache(capacity)
 * var param_1 = obj.get(key)
 * obj.put(key,value)
 */

module.exports.LRUCache = LRUCache;
