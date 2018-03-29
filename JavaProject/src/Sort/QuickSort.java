package Sort;

//import java.util.Arrays;

/**
 * ��������
 * 
 * @author wuhd
 * @since 2018/03/29 11:37
 */
public class QuickSort {

	public static void main(String[] args) {
		int[] array = new int[] { 1, 2, 3, 4, 5, 5, 4, 3, 2, 1 };
		// Arrays.sort(array);
		quickSort(array, 0, array.length - 1);
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}

	}

	/**
	 * ���������طֽ��
	 * 
	 * @param array ����������
	 * 
	 * @param startIndex ��ʼλ��
	 * 
	 * @param endIndex ����λ��
	 * 
	 * @return �ֽ��
	 */
	private static int boundary(int[] array, int startIndex, int endIndex) {
		int standard = array[startIndex]; // �����׼
		int leftIndex = startIndex; // ��ָ��
		int rightIndex = endIndex; // ��ָ��

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
	 * ����ĺ����㷨
	 * 
	 * @param array ����������
	 * 
	 * @param startIndex ��ʼλ��
	 * 
	 * @param endIndex ����λ��
	 */
	public static void quickSort(int[] array, int startIndex, int endIndex) {
		if (startIndex >= endIndex) {
			return;
		}

		int boundary = boundary(array, startIndex, endIndex);

		quickSort(array, startIndex, boundary - 1);
		quickSort(array, boundary + 1, endIndex);
	}
}
