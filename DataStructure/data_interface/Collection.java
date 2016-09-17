package data_interface;
public interface Collection {
	
	public int size();

	public boolean remove(Object e);

	public boolean add(Object e);

	public boolean contains(Object e);

	public boolean isEmpty();

	public Object[] to_array();
	
}
