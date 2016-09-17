package queue_based;

import data_interface.PriorityQueue;

/*
 * Maximum Binary Heap implementation using array
 * 
 * This Data structure can be modified into Minimum Heap 
 * 
 * by changing the '<' to '>' in GreaterThan Method return formula
 *
 */
public class BinaryHeap implements PriorityQueue {

	Object[] elementdata;
	int size = 0;

	public BinaryHeap() {
		elementdata = new Object[10];
	}

	public BinaryHeap(Object[] array) {
		elementdata = array.clone();
		size = array.length;
		// we can create a Binary Heap by keep fixing down the child node
		// from bottom up. By doing so, each child nodes will be small Binary
		// Heap and it will become Binary Heap at the end.
		for (int i = size - 1; i >= 0; i--)
			fixdown(i);
	}

	public BinaryHeap(int cap) {
		if (cap > 0)
			elementdata = new Object[cap];
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public Object dequeue() {

		if (size < 1)
			return null;
		int max = (int) peek();

		elementdata[0] = elementdata[--size];

		elementdata[size] = null;

		if (size > 1)
			fixdown(0);

		return max;
	}

	// re-adjust the parent node position to conform with Max Heap
	// @param i = index of wrongly inserted parent node to adjust
	private void fixdown(int i) {

		int left_child;
		// keep changing the dubious node till the base height
		// that is doing until the next left-child node is still existed
		while ((left_child = 2 * i + 1) < size) {
			// right-child node is existed and it is greater than left-child
			// node
			// we have to consider the right-child node instead
			if (left_child + 1 < size
					&& greaterThan(left_child + 1, left_child))
				left_child++;
			// if the parent node is now greater than child node, then stop
			if (!greaterThan(left_child, i))
				break;
			// else swap the data of parent node with that of child node
			swap(i, left_child);
			// also swap the index of parent node
			i = left_child;
		}

	}

	private void EnsureCapacity(int j) {

		if (elementdata.length < j) {
			Object[] new_arr = new Object[size * 2];

			for (int i = 0; i < size; i++) {
				new_arr[i] = elementdata[i];
			}

			elementdata = new_arr;
		}
	}

	@Override
	public boolean enqueue(Object e) {

		if (e != null) {
			EnsureCapacity(size + 1);

			elementdata[size] = e;

			fixup(size++);

		}
		return false;
	}

	private void fixup(int i) {

		while (i > 0) {
			int parent_idx = (i - 1) / 2;
			if (greaterThan(i, parent_idx)) {
				swap(i, parent_idx);
				i = parent_idx;
			} else
				break;
		}

	}

	@SuppressWarnings("unchecked")
	private boolean greaterThan(int i, int parent_idx) {		
		Comparable<Object> child_value = (Comparable<Object>) elementdata[i];
		return child_value.compareTo(elementdata[parent_idx]) > 0;
	}

	private void swap(int i, int parent_idx) {

		Object tmp = elementdata[parent_idx];
		elementdata[parent_idx] = elementdata[i];
		elementdata[i] = tmp;
	}

	@Override
	public Object peek() {

		if (size > 0) {
			return elementdata[0];
		}
		return null;
	}

	@Override
	public boolean isEmpty() {

		return size == 0;
	}

}
