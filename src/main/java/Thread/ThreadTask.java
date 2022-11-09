package Thread;

import java.util.Arrays;

public class ThreadTask extends Thread
{
	synchronized public void run(int array[])
	{
		binarysearch(array, 0, array.length, 60);
		maximumnumber(array);
		fibonacci(array);
	}
	public int binarysearch(int array[],int low,int high,int key)
	{
		Arrays.sort(array);
		if(low<high)
		{
			int mid=(high+low)/2;
			if(array[mid]==key)
				return mid;
			else if(array[mid]>key)
				return binarysearch(array,low,mid,key);
			else if(array[mid]<key)
				return binarysearch(array,mid+1, high, key);
		}
		return -1;
	}
	 public void maximumnumber(int array[])
	{
		 int max=0;
		 int max1=0;
		 for(int maximumnumber=0;maximumnumber<array.length;maximumnumber++)
		 {
			 if(array[maximumnumber]>max)
			 {
				 max=array[maximumnumber];
			 }
			 if((array[maximumnumber]!=max)&&(array[maximumnumber]>max1))
			 {
				 max1=array[maximumnumber];
				  
			 }
		 }
		System.out.println(max);
		System.out.println(max1);
		 
	}
	 public void fibonacci(int array[])
	 {
		 int first=array[0];
		 int second=array[1];
		 int third=first+second;
		 
		 for(int fib=2;fib<array.length;fib++)
		 {
			third+=array[fib];
		 }
		 System.out.println(third);
		
	 }

}
