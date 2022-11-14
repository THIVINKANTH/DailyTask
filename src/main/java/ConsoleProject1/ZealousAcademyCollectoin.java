package ConsoleProject1;

import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;
import java.util.Vector;

public class ZealousAcademyCollectoin implements Runnable,ZealousAcademyActions 
{
	List<ZealousAcademy>academy=new LinkedList<ZealousAcademy>();
	Scanner scan=new Scanner(System.in);
	public ZealousAcademyCollectoin()
	{
		academy.add(new ZealousAcademy("Thivinkanth","JavaFullStacj","Manojkumar", 5, 2.30, 30000.50));
		academy.add(new ZealousAcademy("Pradeep","CoreJava","Manojkumar", 4, 2.0, 10000.0));
		academy.add(new ZealousAcademy("Thilak","PHP","Aarthi", 7, 1.15, 15000.90));
		academy.add(new ZealousAcademy("Vishnu","C#","Razak", 3, 1.00, 12000.0));
		academy.add(new ZealousAcademy("Ganesh","JavaWebDevelopment","Annamalai", 5, 1.0, 15500.0));
		academy.add(new ZealousAcademy("Manojkumar","PythonFullStack", "Raseetha", 4, 1.45, 30000.0));
	}

	@Override
	public String Addnewstudentdetails(ZealousAcademy zealous) 
	{
		academy.add(zealous);
		return zealous.getStudentName()+"has name is added successfully";
	}

	@Override
	public void Listallstudentdetails()
	{
		Iterator<ZealousAcademy>it=academy.iterator();
		while(it.hasNext())
		{
			System.out.println(it.next());
		}
		
	}

	@Override
	public void Updatestudentdetails(String name) 
	{
	ZealousAcademy ac=null;
	for(ZealousAcademy temp:academy)
	{
		if(temp.getStudentName().equalsIgnoreCase(name))
		{
			ac=temp;
			break;
		}
	}
	if(ac!=null)
	{
		try
		{
			System.out.println(name+"which field you want to update");
			//System.out.println(academy[index]);
			String field=scan.next();
			switch(field)
			{
			case "studentName":
				System.out.println("Enter your new student name");
				String newstud=scan.next();
				ac.setStudentName(newstud);
				break;
			case "studentTechnology":
				System.out.println("Enter your new Technology");
				String tech=scan.next();
				ac.setStudentTechnology(tech);
				break;
			case "studentIncharge":
				System.out.println("Enter your new InchargeName");
				String Incharge=scan.next();
				ac.setStudentIncharge(Incharge);
				break;
			case "studentMemberscount":
				System.out.println("Enter your new members count");
				int count=scan.nextInt();
				ac.setStudentMemberscount(count);
				break;
			case "studentClasstiming":
				System.out.println("Enter your new class Timing");
				double time=scan.nextDouble();
				ac.setStudentClasstiming(time);
				break;
			case "studentCourseprice":
				System.out.println("Enter your new course price");
				double price=scan.nextDouble();
				ac.setStudentCourseprice(price);
				break;
				default:
					throw new ZealousAcademyException();
			}
			System.out.println(field+"has been updated");
			academy.add(ac);
			return;
		}
		catch(ZealousAcademyException |InputMismatchException exe)
		{
			Scanner scan=new Scanner(System.in);
			System.out.println(name+"your field name is wrong,place enter correct value\n studentName\n studentTechnology\n studentIncharge\n studentMemberscount\n studentClasstiming\n studentCourseprice");
			System.out.println(name+"which field you want to update");
			//System.out.println(academy[index]);
			String field=scan.next();
			switch(field)
			{
			case "studentName":
				System.out.println("Enter your new student name");
				String newstud=scan.next();
				ac.setStudentName(name);
				break;
			case "studentTechnology":
				System.out.println("Enter your new Technology");
				String tech=scan.next();
				ac.setStudentTechnology(tech);
				break;
			case "studentIncharge":
				System.out.println("Enter your new InchargeName");
				String Incharge=scan.next();
				ac.setStudentIncharge(Incharge);
				break;
			case "studentMemberscount":
				System.out.println("Enter your new members count");
				int count=scan.nextInt();
				ac.setStudentMemberscount(count);
				break;
			case "studentClasstiming":
				System.out.println("Enter your new class Timing");
				double time=scan.nextDouble();
				ac.setStudentClasstiming(time);
				break;
			case "studentCourseprice":
				System.out.println("Enter your new course price");
				double price=scan.nextDouble();
				ac.setStudentCourseprice(price);
				break;
				default:
					System.out.println("Maximum choice is over");
			}
			System.out.println(field+"has been updated");
			academy.add(ac);
			return;
		}
	}
	else
	{
		System.out.println("it is not matching");
	}
		
	}

	@Override
	public void Searchstudentdetails(String technology) 
	{
		
		
	}

	@Override
	public void Sortstudentdetails() 
	{
		
		
	}

	@Override
	public void Deletestudentdetails(String name) 
	{
		List<ZealousAcademy>temp= new Vector<ZealousAcademy>();
		temp.addAll(academy);
		try
		{
			for(int index=0;index<temp.size();index++)
			{
				if(temp.get(index).getStudentName().equalsIgnoreCase(name))
				{
					academy.remove(temp.get(index));
					System.out.println(name+" "+"has been Deleted Successfully");
					return;
				}
			}
			throw new ZealousAcademyException();
		}
		catch(ZealousAcademyException exe)
		{
			System.out.println(exe+"name is  not matching,place matching values are");
			for(ZealousAcademy zea:academy)
			{
				System.out.println(zea.getStudentName());
			}
			System.out.println("Enter which name you want delete");
			Deletestudentdetails(scan.next());
		}
		System.out.println(name+"has deleted");
		
	}

	@Override
	synchronized public void run() 
	{
		System.out.println("Welcome to ZealousAcademy"+" "+Thread.currentThread().getName());
		do
		{
			System.out.println("which process you want\n 1.Addnewstudentdetails\n 2.List\n 3.Update\n 4.Search\n 5.Sort\n 6.Delete\n 7.Exit");
			int menu=scan.nextInt();
			switch(menu)
			{
			case 1:
				System.out.println("Enter StudentName,Techmology,Incharge,MemberCount,ClassTimig,CoursePrice");
				ZealousAcademy z1=new ZealousAcademy(scan.next(),scan.next(),scan.next(),scan.nextInt(),scan.nextDouble(),scan.nextDouble());
				System.out.println(Addnewstudentdetails(z1));
				break;
			case 2:
				System.out.println("your vale is listed");
				Listallstudentdetails();
				break;
			case 3:
				System.out.println("which student name you want update");
				String stud=scan.next();
				Updatestudentdetails(stud);
				break;
			case 4:
				System.out.println("search based on technology");
				System.out.println("which technology you want to search");
				String tech1=scan.next();
				Searchstudentdetails(tech1);
				break;
			case 5:
				Sortstudentdetails();
				break;
			case 6:
				System.out.println("which name you want to delete in academic");
				String nm=scan.next();
				Deletestudentdetails(nm);
			case 7:
				if(menu==7)
				{
					System.out.println("Thank You");
					return;
				}
			//default:return ;
			}
		}
		while(true);
		
	}

}
