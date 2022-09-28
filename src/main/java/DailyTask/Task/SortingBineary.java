package DailyTask.Task;

import java.util.Arrays;

public class SortingBineary {
	public void display(int arr[])
	{
		System.out.println("befor sorting"+Arrays.toString(arr));
		for(int i=0;i<arr.length;i++)
		{
			for(int j=0;j<arr.length;j++)
			{
				if(arr[i]<arr[j])
				{
					arr[i]^=arr[j];
					arr[j]^=arr[i];
					arr[i]^=arr[j];
				}
			}
		}
		
	}
	public int dis(int arr1[],int low,int high,int key)
	{
		if(low<high)
		{
			int mid=(high+low)/2;
			if(arr1[mid]==key)
			{
				return mid;
			}
			else if(arr1[mid]>key)
			{
				return dis(arr1,low,mid,key);
			}
			else if(arr1[mid]<key)
			{
				return dis(arr1,mid+1,high,key);
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		int array[]= {10,30,50,20,40,70,80,60,100,90};
		SortingBineary obj=new SortingBineary();
		obj.display(array);
		System.out.println("after sorting"+Arrays.toString(array));
		int key=70;
		System.out.println(key+"founded by index of"+obj.dis(array,0,array.length,key));
	}

}
