学习笔记

````c#
// 二维数组周围8个邻居
int[][] dirs = {
    new int[] {-1, -1 },
    new int[] { 0, -1 },
    new int[] { 1, -1 },
    new int[] {-1, 0 },
    new int[] { 1, 0 },
    new int[] {-1, 1 },
    new int[] { 0, 1 },
    new int[] { 1, 1 }
};
// 也可写出如下，用两层循环实现上面到二维数组
int neighbors[3] = {0, 1, -1};
for (int i = 0; i < 3; i++) {
    for (int j = 0; j < 3; j++) {
        // 0 -> neighbors[i] 
        // 1 -> neighbors[j]
    }
}
````