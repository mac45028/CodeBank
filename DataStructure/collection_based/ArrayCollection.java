package collection_based;
import data_interface.Collection;


public class ArrayCollection implements Collection{
	
	private Object []elementdata;
	private int size = 0;
	
	public ArrayCollection(){
		elementdata = new Object[10];
	}
	
	public ArrayCollection(Object []reference){
		if(reference!=null){
			elementdata = reference;
			size = reference.length;
		}
		else{
			elementdata = new Object[10];
		}
	}
	
	public ArrayCollection(int s){
		if(s>0)	elementdata = new Object[s];
		else elementdata = new Object[10];
	}
	

	@Override
	public int size() {
		return this.size;	
	}
	
	private int indexOf(Object e){
		if(e==null) return -1;
		for(int i=0;i<size;i++){
			if(elementdata[i].equals(e)){
				return i;
			}
		}
		return -1;
	}

	@Override
	public boolean remove(Object e) {
		// TODO Auto-generated method stub
		if(size==0)return true;
		
		int i = indexOf(e);
		
		if(i!=-1){
			elementdata[i]=elementdata[--size];
			return true;
		}
		
		//since element does not exist, return false
		return false;
	}
	
	private void EnsureCapacity(int j) {
		// TODO Auto-generated method stub
		if(elementdata.length<j)
		{
			Object []new_arr = new Object[size * 2];
			
			for(int i=0;i<size;i++)
			{
				new_arr[i] = elementdata[i];
			}
			
			elementdata=new_arr;
		}
	}

	@Override
	public boolean add(Object e) {
		
		if(e==null) return false;
		
		EnsureCapacity(size+1);
		
		elementdata[size++]=e;
		
		return true;
	}

	@Override
	public boolean contains(Object e) {
		int idx = indexOf(e);
		return idx!=-1;
	}

	@Override
	public boolean isEmpty() {
		
		return size!=0;
	}
	
	public Object[] to_array(){
		Object []array = new Object[size];
		for(int i=0;i<size;i++){
			array[i] = elementdata[i];
		}
		return array;
	}

}
