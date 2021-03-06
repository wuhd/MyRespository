package Sort;

//import java.util.Arrays;

/**
	排序方法	时间复杂度						空间复杂度	稳定性	复杂性
			平均情况	最坏情况	最好情况
	快速排序	O(nlog2n)	O(n2)	O(nlog2n)	O(log2n)	不稳定	较复杂
 */
public class QuickSort implements SortAble{

	public static void main(String[] args) {
		int[] array = new int[] { 1, 2, 3, 4, 5, 5, 4, 3, 2, 1 };
		// Arrays.sort(array);
		quickSort(array, 0, array.length - 1);
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}

	}

	/**
	 * 交换并返回分界点
	 * 
	 * @param array 待排序数组
	 * 
	 * @param startIndex 开始位置
	 * 
	 * @param endIndex 结束位置
	 * 
	 * @return 分界点
	 */
	private static int boundary(int[] array, int startIndex, int endIndex) {
		int standard = array[startIndex]; // 定义标准
		int leftIndex = startIndex; // 左指针
		int rightIndex = endIndex; // 右指针

		while (leftIndex < rightIndex) {
			while (leftIndex < rightIndex && array[rightIndex] >= standard) {
				rightIndex--;
			}
			array[leftIndex] = array[rightIndex];

			while (leftIndex < rightIndex && array[leftIndex] <= standard) {
				leftIndex++;
			}
			array[rightIndex] = array[leftIndex];
		}

		array[leftIndex] = standard;
		return leftIndex;
	}

	/**
	 * 排序的核心算法
	 * 
	 * @param array 待排序数组
	 * 
	 * @param startIndex 开始位置
	 * 
	 * @param endIndex 结束位置
	 */
	public static void quickSort(int[] array, int startIndex, int endIndex) {
		if (startIndex >= endIndex) {
			return;
		}

		int boundary = boundary(array, startIndex, endIndex);

		quickSort(array, startIndex, boundary - 1);
		quickSort(array, boundary + 1, endIndex);
	}

	public int[] sort(int[] array) {
		if(array == null)
			return null;
		quickSort(array, 0, array.length - 1);
		return array;
	}
}
