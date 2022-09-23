package DailyTask.Task;

import java.util.Scanner;

public class Sample {

	public static void main(String[] args) {
		String name[]= new String[10];
		Scanner obj=new Scanner(System.in);
		for(int i=0;i<name.length;i++)
		{
			System.out.println("enter your name");
			name[i]=obj.nextLine();
		}
		for(String a:name)
		{
		 System.out.println(a);	
		}
		Sample obj1=new Sample();
		obj1.Display();
	}
	public void Display()
	{
		String name[]=new String[10];
		Scanner scan=new Scanner(System.in);
		for(int i=0;i<name.length;i+=2)
		{
			System.out.println("enter your name");
			name[i]=scan.nextLine();
		}
		for(int i=0;i<name.length;i++)
		{
			System.out.println(name[i]);
		}
		System.out.println("i want to print without null");
		for(int i=0;i<name.length;i++)
		{
			if(name[i]!=null)
			{
				System.out.println(name[i]);
			}
		}

	}

}
