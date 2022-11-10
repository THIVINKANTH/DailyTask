package ConsoleProject1;

import java.util.Arrays;
import java.util.Scanner;

public class Connection implements ZealousAcademyActions
{
	ZealousAcademy academy[]=new ZealousAcademy[7];
	Scanner scan=new Scanner(System.in);
	public Connection()
	{
		academy[0]=new ZealousAcademy("Thivinkanth","JavaFullStack","Manojkumar", 5, 1.30, 30000.00);
		academy[1]=new ZealousAcademy("Pradeep","CoreJava","Manojkumar", 4, 2.0, 10000.0);
		academy[2]=new ZealousAcademy("Thilak","PHP","Aarthi", 7, 1.15, 15000.90);
		academy[3]=new ZealousAcademy("Vishnu","C#","Razak", 3, 1.00, 12000.0);
		academy[4]=new ZealousAcademy("Ganesh","JavaWebDevelopment","Annamalai", 5, 1.0, 15500.0);
		academy[5]=new ZealousAcademy("Manojkumar","PythonFullStack", "Raseetha", 4, 1.45, 30000.0);
		academy[6]=new ZealousAcademy("vasan", "UI", "thivinkanth", 3, 1.45, 30000.50);
	}

	public static void main(String[] args) 
	{
		Connection connect=new Connection();
		do
		{
			System.out.println("which process you want\n 1.Addnewstudentdetails\n 2.List\n 3.Update\n 4.Search\n 5.Sort\n 6.Delete\n 7.Exit");
			int menu=connect.scan.nextInt();
			switch(menu)
			{
			case 1:
				System.out.println("Enter StudentName,Techmology,Incharge,MemberCount,ClassTimig,CoursePrice");
				ZealousAcademy z1=new ZealousAcademy(connect.scan.next(), connect.scan.next(),connect.scan.next(),connect.scan.nextInt(), connect.scan.nextDouble(),connect.scan.nextDouble());
				System.out.println(connect.Addnewstudentdetails(z1));
				break;
			case 2:
				System.out.println("your vale is listed");
				connect.Listallstudentdetails();
				break;
			case 3:
				System.out.println("which student name you want update");
				String stud=connect.scan.next();
				connect.Updatestudentdetails(stud);
				break;
			case 4:
				System.out.println("search based on technology");
				System.out.println("which technology you want to search");
				String tech1=connect.scan.next();
				connect.Searchstudentdetails(tech1);
				break;
			case 5:
				connect.Sortstudentdetails();
				break;
			case 6:
				System.out.println("which name you want to delete in academic");
				String nm=connect.scan.next();
				connect.Deletestudentdetails(nm);
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

	@Override
	public String Addnewstudentdetails(ZealousAcademy zealous) 
	{
		try
		{
			for(int index=0;index<academy.length;index++)
			{
				if(academy[index]==null)
				{
					academy[index]=zealous;
					return zealous.getStudentName()+"has name is add successfully";
				}
			}
			throw new ZealousAcademyException();
		}
		catch(ZealousAcademyException exe)
		{
			System.out.println(exe+"memory is full, so if you need any one data is deleted");
			for(ZealousAcademy zea:academy)
			{
				System.out.println(zea.getStudentName());
			}
			System.out.println("which name you want delete");
			Deletestudentdetails(scan.next());
			Addnewstudentdetails(zealous);
		}
		
		return zealous.getStudentName()+"has name is added successfully";
	}

	@Override
	public void Listallstudentdetails() 
	{
		for(ZealousAcademy zea:academy)
		{
			System.out.println(zea);
		}
		
	}

	@Override
	public void Updatestudentdetails(String name) 
	{
			for(int index=0;index<academy.length;index++)
			{
				if(academy[index].getStudentName().equalsIgnoreCase(name));
				{
					System.out.println(name+"which field you want to update");
					System.out.println(academy[index]);
					String field=scan.next();
					switch(field)
					{
					case "studentName":
						System.out.println("Enter your new student name");
						String newstud=scan.next();
						academy[index].setStudentName(newstud);
						break;
					case "studentTechnology":
						System.out.println("Enter your new Technology");
						String tech=scan.next();
						academy[index].setStudentTechnology(tech);
						break;
					case "studentIncharge":
						System.out.println("Enter your new InchargeName");
						String Incharge=scan.next();
						academy[index].setStudentIncharge(Incharge);
						break;
					case "studentMemberscount":
						System.out.println("Enter your new members count");
						int count=scan.nextInt();
						academy[index].setStudentMemberscount(count);
						break;
					case "studentClasstiming":
						System.out.println("Enter your new class Timing");
						double time=scan.nextDouble();
						academy[index].setStudentClasstiming(time);
						break;
					case "studentCourseprice":
						System.out.println("Enter your new course price");
						double price=scan.nextDouble();
						academy[index].setStudentCourseprice(price);
						break;
					}
					System.out.println(field+"has been updated");
					return;
				}
			}
	}

	@Override
	public void Searchstudentdetails(String technology) 
	{
		try
		{
			System.out.println("i have trying to search for technology"+"  "+technology);
			for(int index=0;index<academy.length;index++)
			{
				if(academy[index].getStudentTechnology().equalsIgnoreCase(technology))
				{
					System.out.println(academy[index]);
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
	}

	@Override
	public void Sortstudentdetails()
	{
		ZealousAcademy zealous=null;
		System.out.println("based on what filed you want sort");
		String field=scan.next();
		for(int index=0;index<academy.length;index++)
		{
			for(int pos=index+1;pos<academy.length;pos++)
			{
				if(field.equalsIgnoreCase("StudentName"))
				{
					if(academy[index].getStudentName().compareTo(academy[pos].getStudentName())>0)
					{
						zealous=academy[index];
						academy[index]=academy[pos];
						academy[pos]=zealous;
						System.out.println(zealous.getStudentName());
					}
					
				}
				
				else if(field.equalsIgnoreCase("studentMembersCount"))
				{
					if(academy[index].getStudentMemberscount()>=academy[pos].getStudentMemberscount())
					{
						zealous=academy[index];
						academy[index]=academy[pos];
						academy[pos]=zealous;
					}
				}
				else if(field.equalsIgnoreCase("studentCourseprice"))
				{
					if(academy[index].getStudentCourseprice()>=academy[pos].getStudentCourseprice())
					{
						zealous=academy[index];
						academy[index]=academy[pos];
						academy[pos]=zealous;
					}
				}
				else if(field.equalsIgnoreCase("studentTechnology"))
				{
					if(academy[index].getStudentTechnology().compareTo(academy[pos].getStudentTechnology())>0)
					{
						zealous=academy[index];
						academy[index]=academy[pos];
						academy[pos]=zealous;
					}
				}
				else if(field.equalsIgnoreCase("studentIncharge"))
				{
					if(academy[index].getStudentIncharge().compareTo(academy[pos].getStudentIncharge())>0)
					{
						zealous=academy[index];
						academy[index]=academy[pos];
						academy[pos]=zealous;
					}
				}
			}
		}
	}
	@Override
	public void Deletestudentdetails(String name) 
	{
		try
		{
			for(int index=0;index<academy.length;index++)
			{
				if(academy[index].getStudentName().equalsIgnoreCase(name))
				{
					academy[index]=null;
					System.out.println(name+"has been deleted successfully");
					return;
				}
			}
			throw new ZealousAcademyException();
		}
		catch(ZealousAcademyException exe)
		{
			System.out.println(exe+"name is not matching.place enter matching values are");
			for(ZealousAcademy zea:academy)
			{
				System.out.println(zea.getStudentName());
			}
			System.out.println("whitch name you want delete");
			Deletestudentdetails(scan.next());
			
		}
		System.out.println(name+"has deleted");
	}

}
