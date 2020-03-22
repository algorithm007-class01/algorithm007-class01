
//旋转数组
public class Solution {
	public static void main(int[] args) {
		//暴力解法
		//使用额外数组
		//使用环状替换
	}

	/**
	 * 暴力解法
	 * @param  arr [description]
	 * @param  k   [description]
	 * @return     [description]
	 */
	public int[] rotateArray(int[] arr, int k) {
		int size = arr.length;
		int previous, temp;
		for (int i = 0; i < k; i++) {
			previous = arr[size - 1];
			for (int j = 0; j < size; j++) {
				tem = arr[j];
				arr[j] = previous;
				previous = tmp;
			}
		}
		return arr;
	}

	/**
	 * 使用额外数组
	 * @param arr [description]
	 * @param k   [description]
	 */
	public void rotateArray1(int[]  arr, int k) {
		int[] a = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			a[(i + k) % arr.length] = arr[i];
		}

		for (int i = 0;  i < arr.length; i++) {
			arr[i] = a[i];
		}
	}
}