package queue_based;

import collection_based.ArrayCollection;
import data_interface.Queue;

public class ArrayQueue extends ArrayCollection implements Queue{
	
	Object []queue_data;
	int size=0;
	
	public ArrayQueue(){
		queue_data = new Object[10];
	}
	
	public ArrayQueue(int cap){
		if(cap>0) queue_data = new Object[cap];
		else queue_data = new Object[10];
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}

	@Override
	public Object dequeue() {
		// TODO Auto-generated method stub
		
		if(size==0) return null;
		
		Object answer = queue_data[0];
		
		for(int i=1;i<size;i++){
			queue_data[i-1]=queue_data[i];
		}
		
		size--;
		
		return answer;
	}

	@Override
	public boolean enqueue(Object e) {
		// TODO Auto-generated method stub
		if(e==null) return false;
		
		EnsureCapacity(size+1);
		
		queue_data[size++]=e;
		
		return true;
	}
	
	private void EnsureCapacity(int j) {
		// TODO Auto-generated method stub
		if(queue_data.length<j)
		{
			Object []new_arr = new Object[size * 2];
			
			for(int i=0;i<size;i++)
			{
				new_arr[i] = queue_data[i];
			}
			
			queue_data=new_arr;
		}
	}

	@Override
	public Object peek() {
		// TODO Auto-generated method stub
		if(size==0)return null;
		
		return queue_data[0];
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return size==0;
	}


	
	

}
