import java.util.Arrays;
import java.util.Random;

import list_based.ArrayList;

import tree_based.BinarySearchTree;


public class Data_tester {
	
	private static class test_data implements Comparable<test_data>{
		int value=-1;
		String data=null;
		test_data(int val,String str){
			value=val;
			data=str;
		}
		@Override
		public int compareTo(test_data o) {
			Comparable<Integer> this_val =  this.value;
			return this_val.compareTo((Integer)o.value);
		}
	}
	
	public static void main(String[] args) 
	{
		Random rd = new Random();
		Integer []test = new Integer[100];
		
		test_data []test2 = new test_data[100];
		
		for(int i=0;i<100;i++){
			int tmp = Math.abs(rd.nextInt());
			test[i] = i;
			test2[i] = new test_data(tmp,Integer.toString(tmp));
		}
		
	}

}
