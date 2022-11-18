package ConsoleProject1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;
import java.util.Vector;

public class ZealousAcademyCollectoin implements Runnable,ZealousAcademyActions 
{
	File file=new File("E:\\ConsoleApplication\\ZealousStuddentDeatails\\Zealous.doc");
	FileOutputStream fos=null;
	ObjectOutputStream oos=null;
	FileInputStream fis=null;
	ObjectInputStream ois=null;
	ArrayList<ZealousAcademy>academy=null;
	public void affect() throws IOException
	{
		fos=new FileOutputStream(file);
		oos=new ObjectOutputStream(fos);
		oos.writeObject(academy);
		oos.close();
		fos.close();
	}
	public void fetch() throws IOException, ClassNotFoundException
	{
		fis=new FileInputStream(file);
		ois=new ObjectInputStream(fis);
		academy=(ArrayList<ZealousAcademy>)ois.readObject();
		ois.close();
		fis.close();
	}
//	LinkedList<ZealousAcademy>academy=new LinkedList<ZealousAcademy>();
	Scanner scan=new Scanner(System.in);
	public ZealousAcademyCollectoin()
	{
//		try {
//			fos=new FileOutputStream(file);
//			oos=new ObjectOutputStream(fos);
//			oos.writeObject(academy);
//			oos.close();
//			fos.close();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
//		academy.add(new ZealousAcademy("Thivinkanth","JavaFullStack","Manojkumar", 5, 2.30, 30000.50));
//		academy.add(new ZealousAcademy("Pradeep","CoreJava","Manojkumar", 4, 2.0, 10000.0));
//		academy.add(new ZealousAcademy("Thilak","PHP","Aarthi", 7, 1.15, 15000.90));
//		academy.add(new ZealousAcademy("Vishnu","C#","Razak", 3, 1.00, 12000.0));
//		academy.add(new ZealousAcademy("Ganesh","JavaWebDevelopment","Annamalai", 5, 1.0, 15500.0));
//		academy.add(new ZealousAcademy("Manojkumar","PythonFullStack", "Raseetha", 4, 1.45, 30000.0));
	}

	@Override
	public String Addnewstudentdetails(ZealousAcademy zealous) 
	{
		try {
			fetch();
			academy.add(zealous);
			affect();
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return zealous.getStudentName()+"has name is added successfully";
	}

	@Override
	public void Listallstudentdetails()
	{
		try {
			fetch();
			Iterator<ZealousAcademy>it=academy.iterator();
			while(it.hasNext())
			{
				System.out.println(it.next());
			}
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void Updatestudentdetails(String name) 
	{
		try {
			fetch();
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
					System.out.println(field+" "+"has been updated");
					//academy.add(ac);
					affect();
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
					System.out.println(field+" "+"has been updated");
					//academy.add(ac);
					affect();
					return;
				}
			}
			else
			{
				System.out.println("it is not matching");
			}
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
	}

	@Override
	public void Searchstudentdetails(String technology) 
	{
		try {
			fetch();
			List<ZealousAcademy>temp= new Vector<ZealousAcademy>();
			temp.addAll(academy);
			try
			{
				System.out.println("i have trying to search for technology"+"  "+technology);
				for(int index=0;index<temp.size();index++)
				{
					if(temp.get(index).getStudentTechnology().equalsIgnoreCase(technology))
					{
						System.out.println(temp.get(index));
						return;
					}
				}
				throw  new ZealousAcademyException();
			}
			catch(ZealousAcademyException exe)
			{
				System.out.println(exe+"Technology is not matching,available Technologys are");
				for(ZealousAcademy zea:academy)
				{
					System.out.println(zea.getStudentTechnology());
				}
				System.out.println("which Technology you want ");
				Searchstudentdetails(scan.next());
			}
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void Sortstudentdetails() 
	{
		try {
			fetch();
			Collections.sort(academy);
			affect();
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void Deletestudentdetails(String name) 
	{
		try {
			fetch();
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
						affect();
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

		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
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
