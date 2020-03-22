//leetcode_641_0109.cpp
//实现双端队列

#include <iostream>
#include <vector>
#include <string.h>

class MyCircularDeque {
public:
	int* m_pData;
	int m_nMaxSize;
	int m_nElemCnt;
public:
	/** Initialize your data structure here. Set the size of the deque to be k. */
	MyCircularDeque(int k)
		:m_nMaxSize(k),
		m_nElemCnt(0)
	{
		m_pData = new int[k];
		memset(m_pData, 0, sizeof(int) * k);
	}

	/** Adds an item at the front of Deque. Return true if the operation is successful. */
	bool insertFront(int value) {
		if(m_nMaxSize <= m_nElemCnt)
		{
			return false;
		}
		memcpy(((char*)m_pData + 4), (char*)(m_pData), sizeof(int) * m_nElemCnt);
		m_pData[0] = value;
		m_nElemCnt++;
		return true;
	}

	/** Adds an item at the rear of Deque. Return true if the operation is successful. */
	bool insertLast(int value) {
		if(m_nMaxSize <= m_nElemCnt)
		{
			return false;
		}
		m_pData[m_nElemCnt] = value;
		m_nElemCnt++;
		return true;
	}

	/** Deletes an item from the front of Deque. Return true if the operation is successful. */
	bool deleteFront() {
		if(m_nElemCnt == 0)
		{
			return false;
		} 
		//m_vec_int.insert(m_vec_int.begin(), m_vec_int.begin() + 1, m_vec_int.end());
		memcpy((char*)m_pData, ((char*)m_pData + 4), sizeof(int) * (m_nElemCnt - 1));
		m_nElemCnt--;
		return true;
	}

	/** Deletes an item from the rear of Deque. Return true if the operation is successful. */
	bool deleteLast() {
		if(m_nElemCnt == 0)
		{
			return false;
		}
		m_pData[m_nElemCnt - 1] = 0; 
		m_nElemCnt--;
		return true;
	}

	/** Get the front item from the deque. */
	int getFront() {
		if(m_nElemCnt == 0)
		{
			return -1;
		} 
		return m_pData[0];
	}

	/** Get the last item from the deque. */
	int getRear() {
		if(m_nElemCnt == 0)
		{
			return -1;
		}
		return m_pData[m_nElemCnt - 1];
	}

	/** Checks whether the circular deque is empty or not. */
	bool isEmpty() {
		return !m_nElemCnt;
	}

	/** Checks whether the circular deque is full or not. */
	bool isFull() {
		return (m_nElemCnt == m_nMaxSize);
	}
};

int main(void)
{
	MyCircularDeque circularDeque(3); // 设置容量大小为3
	bool b = circularDeque.insertLast(1);			        // 返回 true
	if(b)
		std::cout<<"true"<<std::endl;
	else
		std::cout<<"false"<<std::endl;
	b = circularDeque.insertLast(2);			        // 返回 true
	if(b)
		std::cout<<"true"<<std::endl;
	else
		std::cout<<"false"<<std::endl;

	b = circularDeque.insertFront(3);			        // 返回 true
	if(b)
		std::cout<<"true"<<std::endl;
	else
		std::cout<<"false"<<std::endl;
	b = circularDeque.insertFront(4);			        // 已经满了，返回 false
	if(b)
		std::cout<<"true"<<std::endl;
	else
		std::cout<<"false"<<std::endl;

	int n = circularDeque.getRear();  				// 返回 2
	std::cout << "Rear= "<< n << std::endl;

	b = circularDeque.isFull();				        // 返回 true
	if(b)
		std::cout<<"true"<<std::endl;
	else
		std::cout<<"false"<<std::endl;

	b = circularDeque.deleteLast();			        // 返回 true
	if(b)
		std::cout<<"true"<<std::endl;
	else
		std::cout<<"false"<<std::endl;

	b = circularDeque.insertFront(4);			        // 返回 true
	if(b)
		std::cout<<"true"<<std::endl;
	else
		std::cout<<"false"<<std::endl;
	n = circularDeque.getFront();				// 返回 4
	std::cout << "Front= "<< n << std::endl;

	char ar;
	std::cin>>ar;
	return 0;
}