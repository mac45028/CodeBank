package data_interface;

public interface Queue {

	public int size();

	public Object dequeue();

	public boolean enqueue(Object e);
	
	public Object peek();

	public boolean isEmpty();

	
}
