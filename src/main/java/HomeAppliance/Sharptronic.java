package HomeAppliance;

public class Sharptronic 
{

	public static void main(String[] args) 
	{
		Visiting visit=new Visiting();
		Thread th1=new Thread(visit,"Thivinkanth");
		Thread th2=new Thread(visit,"Pradeep");
		Thread th3=new Thread(visit,"Thilak");
		Thread th4=new Thread(visit,"Vishnu");
		Thread th5=new Thread(visit,"Manojkumar");
		
		th1.start();
		th2.start();
		th3.start();
		th4.start();
		th5.start();
		

	}

}
