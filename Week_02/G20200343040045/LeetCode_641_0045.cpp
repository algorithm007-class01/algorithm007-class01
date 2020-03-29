/**
 * 题目描述：设计一个循环双端队列
 * 使用数组进行实现,使用双指针，用余数处理下标，能达到循环使用空间的作用，类似循环链表
 * 使用front记录队列头部数据，初始位置在数组末尾，使用rear记录队列尾部数据，初始位置在数组起始
 * 在队列头加一个数据时，front前移，时间复杂度为O(1)
 * 在队列头删除一个数据事front后移，使用余数处理防止越界，特殊情况下为front在数组前，rear在数组后，此操作时间复杂度为O(1)
*/

#include <vector>
#include <iostream>

using namespace std;

class MyCircularDeque
{
private:
    vector<int> data;
    int cnt;
    int k;
    int front;
    int rear;

public:
    //    构造函数
    MyCircularDeque(int k) : data(k, 0), cnt(0), k(k), front(k - 1), rear(0)
    {
    }

    // 将一个元素添加到双端队列头部, 如果操作成功返回 true
    bool insertFront(int value)
    {
        if (cnt == k)
        {
            return false;
        }
        data[front] = value;
        // 使用余数处理，使front一直在0~(k-1)的范围内
        front = (front - 1 + k) % k;
        ++cnt;

        return true;
    }

    // 将一个元素添加到双端队列尾部，如果操作成功返回 true
    bool insertLast(int value)
    {
        if (cnt == k)
        {
            return false;
        }
        data[rear] = value;
        // 使用余数处理，使rear一直在0-(K-1)的范围内
        rear = (rear + 1) % k;
        ++cnt;

        return true;
    }

    // 从双端队列头部删除一个元素, 如果操作成功返回 true
    bool deleteFront()
    {
        if (cnt == 0)
        {
            return false;
        }
        front = (front + 1) % k;
        --cnt;

        return true;
    }

    // 从双端队列尾部删除一个元素, 如果操作成功返回 true
    bool deleteLast()
    {
        if (cnt == 0)
        {
            return false;
        }
        rear = (rear - 1 + k) % k;
        --cnt;

        return true;
    }

    // 从双端队列头部获得一个元素,如果双端队列为空，返回 -1
    int getFront()
    {
        if (cnt == 0)
        {
            return -1;
        }
        return data[(front + 1) % k];
    }

    // 获得双端队列的最后一个元素, 如果双端队列为空，返回 -1
    int getRear()
    {
        if (cnt == 0)
        {
            return -1;
        }
        return data[(rear - 1 + k) % k];
    }

    // 检查双端队列是否为空
    bool isEmpty()
    {
        return cnt == 0;
    }

    // 检查双端队列是否满了
    bool isFull()
    {
        return cnt == k;
    }
};