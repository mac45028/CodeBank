package stack_based;

public class ArrayStack implements data_interface.Stack{
	
	int size = 0;
	Object[] stack_data;

	public ArrayStack()
	{
		stack_data = new Object[10];
	}
	
	public ArrayStack(int cap)
	{
		if(cap>0){
			stack_data = new Object[cap];
		}
		else{
			stack_data = new Object[10];
		}
	}
	
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}

	@Override
	public boolean push(Object e) {
		// TODO Auto-generated method stub
		
		EnsureCapacity(size+1);
		
		if(e!=null)
		{
			stack_data[size++]=e;
			return true;
		}
		
		return false;
	}

	private void EnsureCapacity(int j) {
		// TODO Auto-generated method stub
		if(stack_data.length<j)
		{
			Object []new_arr = new Object[size * 2];
			
			for(int i=0;i<size;i++)
			{
				new_arr[i] = stack_data[i];
			}
			
			stack_data=new_arr;
		}
	}

	@Override
	public Object pop() {
		// TODO Auto-generated method stub
		if(size==0) return null;
		
		return stack_data[--size];
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return size==0;
	}

}
