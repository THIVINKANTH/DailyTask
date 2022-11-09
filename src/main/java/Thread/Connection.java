package Thread;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Connection 
{
	public static void main(String[] args) 
	{
		int array[]= {10,30,80,20,70,60,50,40};
		ThreadTask obj=new ThreadTask();
		obj.start();
		Scanner scan=new Scanner(System.in);
		do {
			System.out.println("which process you want\n 1.Binary Search\n 2.Two Maximum Number\n 3.Fibonacci Series\n 4.Exit");
			int menu=scan.nextInt();
			switch(menu)
			{
			case 1:
				try
				{
				System.out.println("enter the array value");
				int key=scan.nextInt();
				System.out.println(key+"founded by index of"+obj.binarysearch(array,0,array.length,key));
//				throw new InputMismatchException();
				}
				catch(InputMismatchException exe)
				{
				System.out.println(exe+"Enter only numeric values values\n Array values are"+Arrays.toString(array));
				Scanner scan1=new Scanner(System.in);
				int key=scan1.nextInt();
				System.out.println(key+"founded by index of"+obj.binarysearch(array,0,array.length,key));
				}
				break;
			case 2:
				System.out.println("Array MaximumNumber is");
				obj.maximumnumber(array);
				break;
			case 3:
				System.out.println("Fibonacci Series values are");
				obj.fibonacci(array);
				break;
			case 4:
				if(menu==4)
				System.out.println("Thank you");
				return;
			}
		}
		while(true);		
	}
}
