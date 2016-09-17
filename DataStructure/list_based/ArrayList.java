package list_based;

import data_interface.List;

public class ArrayList implements List {

	Object[] list_data;
	int size = 0;

	public ArrayList() {
		list_data = new Object[10];
	}

	public ArrayList(int cap) {
		if (cap > 0) {
			list_data = new Object[cap];
		} else {
			list_data = new Object[10];
		}
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}

	private int indexOf(Object e) {
		for (int i = 0; i < size; i++) {
			if (list_data[i].equals(e))
				return i;
		}
		return -1;
	}

	@Override
	public boolean remove(Object e) {
		// TODO Auto-generated method stub
		if (e==null)
			return false;

		int index = indexOf(e);
		
		if(index==-1) return false;

		for (int i = index + 1; i < size; i++) {
			list_data[i - 1] = list_data[i];
		}

		--size;

		return true;
	}

	@Override
	public boolean add(Object e) {
		// TODO Auto-generated method stub
		return add(size, e);
	}

	private void EnsureCapacity(int j) {
		// TODO Auto-generated method stub
		if (list_data.length < j) {
			Object[] new_arr = new Object[size * 2];

			for (int i = 0; i < size; i++) {
				new_arr[i] = list_data[i];
			}

			list_data = new_arr;
		}
	}

	@Override
	public boolean add(int index, Object e) {
		// TODO Auto-generated method stub
		if (e==null)
			return false;

		EnsureCapacity(size + 1);

		list_data[size++] = e;

		return true;
	}

	@Override
	public boolean contains(Object e) {
		// TODO Auto-generated method stub
		if (e==null)
			return false;
		return indexOf(e) != -1;
	}

	@Override
	public Object get(int index) {
		// TODO Auto-generated method stub
		if (index > -1 && index < size)
			return list_data[index];
		return null;
	}

	@Override
	public boolean set(int index, Object e) {
		// TODO Auto-generated method stub
		if (e==null)
			return false;

		if (index > -1 && index < size) {
			list_data[index] = e;
			return true;
		}

		return false;

	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return size == 0;
	}

}
