package set_based;
import data_interface.set;
import collection_based.ArrayCollection;
import data_interface.Collection;

//Inheritance Idea
// Override the Add method by checking duplication before adding items

//public class ArraySet extends ArrayCollection{
//	
//	public Set(){
//		
//	super();
//	
//	}
//	
//	public boolean add(Object e)
//	{
//		if(super.contains(e)) return false;
//		
//		super.add(e);
//		
//		return true;
//		
//	}
//	
//}


//Composition Idea
// incorporate ArrayCollection inside Set DataStructure
// and call the Collection Method for set functionality

public class ArraySet implements set{
	
	private Collection set_data;
	
	public ArraySet(){
		set_data = new ArrayCollection();
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return set_data.size();
	}

	@Override
	public boolean remove(Object e) {
		// TODO Auto-generated method stub
		return set_data.remove(e);
	}

	@Override
	public boolean add(Object e) {
		// TODO Auto-generated method stub
		if(e==null) return false;
		
		if(!set_data.contains(e))
		{
			set_data.add(e);
			return true;
		}
		
		return false;
	}

	@Override
	public boolean contains(Object e) {
		// TODO Auto-generated method stub
		return set_data.contains(e);
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return set_data.isEmpty();
	}

	@Override
	public Object[] to_array() {
		// TODO Auto-generated method stub
		return set_data.to_array();
	}
	
}
