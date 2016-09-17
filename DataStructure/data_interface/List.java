package data_interface;

public interface List {
	
	public int size();

	public boolean remove(Object e);
	
	public boolean add(int index, Object e);

	public boolean add(Object e);

	public boolean contains(Object e);
	
	public Object get(int index);
	
	public boolean set(int index, Object e);

	public boolean isEmpty();

	
}
