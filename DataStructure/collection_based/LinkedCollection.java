package collection_based;
import data_interface.Collection;


public class LinkedCollection implements Collection{

	private static class LinkedNode{
		Object data;
		LinkedNode next;

		private LinkedNode(Object e,LinkedNode n){
			data = e;
			next = n;
		}
	}
	
	private int size = 0;
	private LinkedNode header = new LinkedNode(null,null);
	
	public LinkedCollection(Object e){
		header.next = new LinkedNode(e,null);
		size++;
	}
	
	public LinkedCollection() {
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean remove(Object e) 
	{
		LinkedNode current = header;
		
		while(current.next != null)
		{
			
			if(current.next.data.equals(e))
			{
				current.next=current.next.next;
				size--;
				return true;
			}
		}
		
		return false;
	}

	@Override
	public boolean add(Object e) 
	{
		header.next = new LinkedNode(e,header.next);
		
		size++;
		
		return true;
	}

	@Override
	public boolean contains(Object e) 
	{
		LinkedNode current = header;
		
		while(current.next!=null)
		{
			if(current.next.data.equals(e)) return true;
			
			current.next = current.next.next;
		}
		
		return false;
	}

	@Override
	public boolean isEmpty() 
	{
		return size!=0;
	}

	@Override
	public Object[] to_array() {
		if(size==0) return null;
		
		Object []array = new Object[size];
		
		LinkedNode current = header.next;
		
		int idx=0;
		
		while(current!=null){
			array[idx++]=current.data;
		}
		
		return array;
	}

}
