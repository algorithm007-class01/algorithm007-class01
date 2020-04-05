学习笔记
week03
树Tree
二叉树
前序遍历：根-左-右
中序遍历：左-根-右
后续遍历：左-右-根
代码示例：public class TreeNode {
        public int val;
        public com.lester.work.SolutionTree.TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }
   二叉搜索树
        1.若左子树不空，则左子树上所有结点的值均小于它的根结点的值；
    2.若右子树不空，则右子树上所有结点的值均大于或等于它的根结点的值
    3.左、右子树也分别为二叉排序树
    
        左子树都比节点小，右子树都比节点大，递归定义
   完全二叉树
            1.完全二叉树是一种特殊的二叉树
        2.所有叶子节点都出现在 k 或者 k-1 层，而且从 1 到 k-1 层必须达到最大节点数
        3.第 k 层可以不是满的，但是第 k 层的所有节点必须集中在最左边。 需要注意的是不要把完全二叉树和“满二叉树”搞混了，完全二叉树不要求所有树都有左右子树，但它要求：
        a:任何一个节点不能只有左子树没有右子树
        b:叶子节点出现在最后一层或者倒数第二层，不能再往上
        二叉平衡树
            1.平衡二叉树要么是一棵空树
        2.要么保证左右子树的高度之差不大于 1
        3.子树也必须是一颗平衡二叉树
堆Heap
            可以迅速的找到一个堆中的最小值或最大值的数据结构
                大顶堆：根节点最大
                小顶堆：根节点最小
            常见API
                find-max:O(1)
                delete-max:O(logN)
                    HeapifyDown:将堆尾元素替换到顶部，然后依次向下调整结构。
                insert:O(logN)或O(1)
                    HeapifyUp:新元素一律先插到堆的尾部，然后依次向上调整结构。
            常见堆
                二叉堆：通过完全二叉树来实现
                    1.是一棵完全树
        2.树中的任一节点值总是大于等于子节点的值
                    二叉堆一般都是通过数组来实现的，假设第一个元素在数组中的索引为0的话，则父节点和子节点会有以下位置关系：
        a：索引为i的左孩子索引为2*i+1
        b：索引为i的右孩子索引为2*i+2
        c：索引为i的父节点索引为floor((i-1)/2)
                斐波那契堆
            代码
                堆的实现
        import java.util.Arrays;
        import java.util.NoSuchElementException;


        public class BinaryHeap {
            private static final int d = 2;
            private int[] heap;
            private int heapSize;
            /**
             * This will initialize our heap with default size.
             */
            public BinaryHeap(int capacity) {
                heapSize = 0;
                heap = new int[capacity + 1];
                Arrays.fill(heap, -1);
            }
            public boolean isEmpty() {
                return heapSize == 0;
            }
            public boolean isFull() {
                return heapSize == heap.length;
            }
            private int parent(int i) {
                return (i - 1) / d;
            }
            private int kthChild(int i, int k) {
                return d * i + k;
            }
            /**
             * Inserts new element in to heap
             * Complexity: O(log N)
             * As worst case scenario, we need to traverse till the root
             */
            public void insert(int x) {
                if (isFull()) {
                    throw new NoSuchElementException("Heap is full, No space to insert new element");
                }
                heap[heapSize] = x;
                heapSize ++;
                heapifyUp(heapSize - 1);
            }

            /**
             * Deletes element at index x
             * Complexity: O(log N)
             */
            public int delete(int x) {
                if (isEmpty()) {
                    throw new NoSuchElementException("Heap is empty, No element to delete");
                }
                int maxElement = heap[x];
                heap[x] = heap[heapSize - 1];
                heapSize--;
                heapifyDown(x);
                return maxElement;
            }
            /**
             * Maintains the heap property while inserting an element.
             */
            private void heapifyUp(int i) {
                int insertValue = heap[i];
                while (i > 0 && insertValue > heap[parent(i)]) {
                    heap[i] = heap[parent(i)];
                    i = parent(i);
                }
                heap[i] = insertValue;
            }

            /**
             * Maintains the heap property while deleting an element.
             */
            private void heapifyDown(int i) {
                int child;
                int temp = heap[i];
                while (kthChild(i, 1) < heapSize) {
                    child = maxChild(i);
                    if (temp >= heap[child]) {
                        break;
                    }
                    heap[i] = heap[child];
                    i = child;
                }
                heap[i] = temp;
            }
            private int maxChild(int i) {
                int leftChild = kthChild(i, 1);
                int rightChild = kthChild(i, 2);
                return heap[leftChild] > heap[rightChild] ? leftChild : rightChild;
            }
            /**
             * Prints all elements of the heap
             */
            public void printHeap() {
                System.out.print("nHeap = ");
                for (int i = 0; i < heapSize; i++)
                    System.out.print(heap[i] + " ");
                System.out.println();
            }
            /**
             * This method returns the max element of the heap.
             * complexity: O(1)
             */
            public int findMax() {
                if (isEmpty())
                    throw new NoSuchElementException("Heap is empty.");
                return heap[0];
            }
            public static void main(String[] args) {
                BinaryHeap maxHeap = new BinaryHeap(10);
                maxHeap.insert(10);
                maxHeap.insert(4);
                maxHeap.insert(9);
                maxHeap.insert(1);
                maxHeap.insert(7);
                maxHeap.insert(5);
                maxHeap.insert(3);
                maxHeap.printHeap();
                maxHeap.delete(5);
                maxHeap.printHeap();
                maxHeap.delete(2);
                maxHeap.printHeap();
            }
        }
