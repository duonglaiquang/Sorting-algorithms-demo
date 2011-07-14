/**
 * Sorts by swapping the next unsorted item into the correct position in the sorted subarray. The correct position is determined using binary search instead of linear search. The time complexity is in <var>O</var>(<var>n</var><sup>3</sup>).
 */
class InsertionSort1 extends SortAlgorithm {
	
	public void sort(SortArray array) {
		array.setInactive(0, array.length());
		for (int i = 0; i < array.length(); i++) {
			array.setActive(i);
			int index = binarySearch(array, i, 0, i);
			for (int j = i; j - 1 >= index; j--)
				array.swap(j, j - 1);
		}
		array.setDone(0, array.length());
	}
	
	
	public String getName() {
		return "Insertion sort (binary search)";
	}
	
	
	private static int binarySearch(SortArray array, int index, int start, int end) {
		while (start != end) {
			int mid = (start + end) / 2;
			int temp = array.compare(index, mid);
			if (temp < 0)
				end = mid;
			else if (temp > 0)
				start = mid + 1;
			else
				return mid;
		}
		return start;
	}
	
	
}