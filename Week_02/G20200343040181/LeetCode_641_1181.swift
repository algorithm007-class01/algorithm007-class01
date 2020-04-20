class MyCircularDeque {

  var buffer: [Int]
  var first: Int
  var last: Int
  var usedSpace: Int

  /** Initialize your data structure here. Set the size of the deque to be k. */
  init(_ k: Int) {
    self.buffer = Array(repeating: 0, count: k)
    self.first = 0
    self.last = buffer.count - 1
    self.usedSpace = 0
  }

  /** Adds an item at the front of Deque. Return true if the operation is successful. */
  func insertFront(_ value: Int) -> Bool {
    if isFull() {
      return false
    }
    first = decr(first)
    buffer[first] = value
    usedSpace += 1
    return true
  }

  /** Adds an item at the rear of Deque. Return true if the operation is successful. */
  func insertLast(_ value: Int) -> Bool {
    if isFull() {
      return false
    }
    last = incr(last)
    buffer[last] = value
    usedSpace += 1
    return true
  }

  /** Deletes an item from the front of Deque. Return true if the operation is successful. */
  func deleteFront() -> Bool {
    if isEmpty() {
      return false
    }
    first = incr(first)
    usedSpace -= 1
    return true
  }

  /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
  func deleteLast() -> Bool {
    if isEmpty() {
      return false
    }
    last = decr(last)
    usedSpace -= 1
    return true
  }

  /** Get the front item from the deque. */
  func getFront() -> Int {
    return isEmpty() ? -1 : buffer[first]
  }

  /** Get the last item from the deque. */
  func getRear() -> Int {
    return isEmpty() ? -1 : buffer[last]
  }

  /** Checks whether the circular deque is empty or not. */
  func isEmpty() -> Bool {
    return usedSpace == 0
  }

  /** Checks whether the circular deque is full or not. */
  func isFull() -> Bool {
    return usedSpace == buffer.count
  }

  /** Increments value and wraps on buffer size */
  func incr(_ value: Int) -> Int {
    return (value + 1) % buffer.count
  }

  /** Decrements value and wraps on buffer size */
  func decr(_ value: Int) -> Int {
    return value > 0 ? value - 1 : buffer.count - 1
  }
}
