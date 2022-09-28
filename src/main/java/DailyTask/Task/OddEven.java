package DailyTask.Task;

import java.util.Scanner;

public class OddEven {
	public int odd(int arr[])
	{
		for(int i=1;i<arr.length;i+=2)
		{
			System.out.print(i+" ");;
		}
		return 0;
	}
	public int even(int arr[])
	{
		for(int i=2;i<arr.length;i+=2)
		{
			System.out.print(i+" ");;
		}
		return 0;
	}

	public static void main(String[] args) {
		int array[]=new int[10];
		Scanner scan=new Scanner(System.in);
		for(int i=0;i<array.length;i++)
		{
			System.out.println("enter the values");
			array[i]=scan.nextInt();
		}
		OddEven obj=new OddEven();
		obj.odd(array);
		obj.even(array);

	}

}
