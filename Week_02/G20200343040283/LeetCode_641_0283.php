<?php

/**
 * 双端队列
 *
 * Class MyCircularDeque
 * Author: WenTianGang
 * Date: 2020/3/22 11:39 下午
 */
class MyCircularDeque {

    protected $maxCount = 0;
    protected $count = 0;
    protected $head = null;
    protected $tail = null;

    /**
     * Initialize your data structure here. Set the size of the deque to be k.
     * @param Integer $k
     */
    function __construct($k) {
        $this->maxCount = $k;
    }

    /**
     * Adds an item at the front of Deque. Return true if the operation is successful.
     * @param Integer $value
     * @return Boolean
     */
    function insertFront($value) {
        // 队列已经满了
        if ($this->isFull()) {
            return false;
        }

        if ($this->head == null) {
            $node = new Node($value, null);
            $this->head = $node;
            $this->tail =  $node;
        } else {
            $node = new Node($value, $this->head);
            $this->head = $node;
        }

        $this->count ++;
        return true;
    }

    /**
     * Adds an item at the rear of Deque. Return true if the operation is successful.
     * @param Integer $value
     * @return Boolean
     */
    function insertLast($value) {
        // 队列已经满了
        if ($this->isFull()) {
            return false;
        }

        if ($this->head == null) {
            $this->head = $this->tail = new Node($value, null);
        } else {
            $node = new Node($value, null);
            $this->tail->next = $node;
            $this->tail = $this->tail->next;
        }
        $this->count ++;
        return true;
    }

    /**
     * 从双端队列头部删除一个元素。 如果操作成功返回 true。
     *
     * Deletes an item from the front of Deque. Return true if the operation is successful.
     * @return Boolean
     */
    function deleteFront() {
        if ($this->isEmpty()) return false;
        $this->head = $this->head->next;
        if ($this->head == null) {
            $this->tail = null;
        }
        $this->count --;
        return true;
    }

    /**
     * 尾部删除一个元素
     *
     * Deletes an item from the rear of Deque. Return true if the operation is successful.
     * @return Boolean
     */
    function deleteLast() {

        if ($this->isEmpty()) return false;

        if ($this->count == 1) {
            $this->head = null;
            $this->tail = null;
        } else {
            $tail = $this->head;
            while ($tail->next->next != null) {
                $tail = $tail->next;
            }
            $tail->next = null;
            $this->tail = $tail;
        }

        $this->count --;
        return true;
    }

    /**
     * Get the front item from the deque.
     * @return Integer
     */
    function getFront() {
        if ($this->head == null) return -1;
        return $this->head->val;
    }

    /**
     * Get the last item from the deque.
     * @return Integer
     */
    function getRear() {
        if ($this->tail == null) return -1;
        return $this->tail->val;
    }

    /**
     * Checks whether the circular deque is empty or not.
     * @return Boolean
     */
    function isEmpty() {
        return $this->count == 0 ? true : false;
    }

    /**
     * Checks whether the circular deque is full or not.
     * @return Boolean
     */
    function isFull() {
        return $this->count >= $this->maxCount;
    }
}


class Node {
    public $val;
    public $next;
    public function __construct($val = null, $next = null)
    {
        $this->val = $val;
        $this->next = $next;
    }
}