package Sort;

public class ShellSort implements SortAble {
	// 希尔排序的核心模块
	private void core(int[] array) {
		int arrayLength = array.length;
		int step = arrayLength / 2;
		do {
			for (int i = 0; i < step; i++) {
				insert(array, i, step);
			}
			step /= 2;
		} while (step > 0);
	}

	// 希尔排序的直接插入排序
	private void insert(int[] array, int offset, int step) {
		int arrayLength = array.length;
		int groupCount = arrayLength / step
				+ (arrayLength % step > offset ? 1 : 0);
		for (int i = 1; i < groupCount; i++) {
			int nextIndex = offset + step * i;
			int waitInsert = array[nextIndex];

			while (nextIndex - step >= 0
					&& waitInsert < array[nextIndex - step]) {
				array[nextIndex] = array[nextIndex - step];
				nextIndex -= step;
			}

			array[nextIndex] = waitInsert;
		}
	}

	public int[] sort(int[] array) {
		if (array == null) {
			return null;
		}
		core(array);
		return array;
	}
}
