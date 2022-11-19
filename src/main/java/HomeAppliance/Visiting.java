package HomeAppliance;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;

public class Visiting implements Runnable,Appliance
{
	File file=new File("E:\\ConsoleApplication\\Sharp\\Entrydetails.doc");
	FileOutputStream fos=null;
	ObjectOutputStream oos=null;
	FileInputStream fis=null;
	ObjectInputStream ois=null;
	ArrayList<CustomerDetails>details=null;//new ArrayList<CustomerDetails>();
	public void Entrywrite() throws IOException
	{
		fos=new FileOutputStream(file);
		oos=new ObjectOutputStream(fos);
		oos.writeObject(details);
		oos.close();
		fos.close();
	}
	public void Entryread() throws IOException, ClassNotFoundException
	{
		fis=new FileInputStream(file);
		ois=new ObjectInputStream(fis);
		details=(ArrayList<CustomerDetails>)ois.readObject();
		ois.close();
		fis.close();
	}
	File file1=new File("E:\\ConsoleApplication\\Sharp\\BillingDetails.doc");
	FileOutputStream fos1=null;
	ObjectOutputStream oos1=null;
	FileInputStream fis1=null;
	ObjectInputStream ois1=null;
	public void Billwrite() throws IOException
	{
		fos1=new FileOutputStream(file1);
		oos1=new ObjectOutputStream(fos1);
		oos1.writeObject(billing);
		oos1.close();
		fos1.close();
	}
	public void Billread() throws IOException, ClassNotFoundException
	{
		fis1=new FileInputStream(file1);
		ois1=new ObjectInputStream(fis1);
		billing=(Vector<SystemBilling>)ois1.readObject();
		ois1.close();
		fis1.close();
	}
	Vector<SystemBilling>billing=null;//new Vector<SystemBilling>();
	Scanner scan=new Scanner(System.in);
	public Visiting()
	{
//		try {
//			fos1=new FileOutputStream(file1);
//			oos1=new ObjectOutputStream(fos1);
//			oos1.writeObject(billing);
//			oos1.close();
//			fos1.close();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
	}

	@Override
	public String CustomerEntry(CustomerDetails customer) 
	{
		try {
				Entryread();
				details.add(customer);
				Entrywrite();
			} catch (ClassNotFoundException |IOException e) 
		{
				// TODO Auto-generated catch block
				e.printStackTrace();
			
		} 	
		return customer.getCustomerName()+"has Added Successfully";
	}

	@Override
	public void EntryCustomerList() 
	{
		try {
			Entryread();
			Iterator<CustomerDetails>it=details.iterator();
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
	public void Fridge(String needs) 
	{
		try
		{
			System.out.println(needs+"welcome to Sharptronics which type you want\n SingleDoor\n DoubleDoor");
			if(needs.equalsIgnoreCase("LG"))
			{
				String type=scan.next();
				switch(type)
				{
				case "SingleDoor":
					System.out.println("Model:GL-D221ABED\n Features:Moist N Fresh\r\n"
							+ "Toughened Glass with Frame\r\n"
							+ "Works Without Stabilizer\r\n"
							+ "Fast Ice Making\n Litter:215L\n Price:26099\n Discount:31%\n OfferPrice:17990");
					buy();
					break;
				case "DoubleDoor":
					System.out.println("Model:GL-N412SDSY\n Feature:2 Star Double Door Refrigerator\r\n"
							+ "Smart Home Inverter Connect\r\n"
							+ "DC Inverter Technology\r\n"
							+ "Trimless tempered Glass Refrigerator Shelf\r\n"
							+ "Stabilizer Free Operation\n Litters:408L\n price:53499\n Discout:21%\n offerPrice:42490");
					buy();
					break;
					default:
						throw new SharptronicsException();
						//System.out.println(type+"this model not Exist");
						
				}
			}
			else if(needs.equalsIgnoreCase("SAMSUNG"))
			{
				String type=scan.next();
				switch(type)
				{
				case "SingleDoor":
					System.out.println("Model:RR21A2F2XNV\n Feature:Auto Express Cooling\r\n"
							+ "Fast Ice Making\r\n"
							+ "Energy Saving with Eco Mode\n Litters:198L\n Price:21990\n Discount:24%\n OfferPrice:16990 ");
					buy();
					break;
				case"DoubleDoor":
					System.out.println("Model:RT28T3453UT\n Feature:Works longer for less\r\n"
							+ "Evenly cools all over\r\n"
							+ "Voltage protection\n Litters:253L\n Price:31990\n Discount:21%\n OfferPrice:25190");
					buy();
					break;
				default:
					throw new SharptronicsException();
					//System.out.println(type+"this model not Exist");
					
				}
			}
			else if(needs.equalsIgnoreCase("WHIRLPOOL"))
			{
				String type=scan.next();
				switch(type)
				{
				case"SingleDoor":
					System.out.println("Model:IMPRO PRM 5S INV SAPPHIRE MULIA\n Feature:Laminar Airflow for uniform cooling, Intellisense Inverter Technology, Removable Anti Bacterial Gasket, Insulated Capillary Technology, Stabilizer free operation\n Litters:205L\n Price:24750\n Discount:30%\n OfferPrice:17290");
					buy();
					break;
				case"DoubleDoor":
					System.out.println("Model:NEO DF 258 ROY Arctic Steel\n Feature:Explore cooling that stays locked-in with the 6TH SENSE DeepFreeze Technology\r\n"
							+ "Up to 12 Days of Garden Freshness, Uniform Cooling with Freshflow Airtower\r\n"
							+ "Prevention of Up to 99 percent Bacteria With Microblock Technology\r\n"
							+ "Effective Anti-Odor Action with Active Deo, Optimum Moisture Retention with Honeycomb Crisper Cover Design\r\n"
							+ "Up to 40 percent Faster bottle Cooling, Cooling Retention after Power Cuts with Chilling Gel\r\n"
							+ "Toughened Glass Shelves, Stabilizer Free Operation (130V-300V)\n Litters:245L\n Price:31350\n Discount:27%\n OfferPrice:22990");
					buy();
					break;
				default:
					throw new SharptronicsException();
					//System.out.println(type+"this model not Exist");
				}
				
			}
			else if(needs.equalsIgnoreCase("GODREJ"))
			{
				String type=scan.next();
				switch(type)
				{
				case"SingleDoor":
					System.out.println("Model:EDGEPRO 225D 43 TDI\n Feature:Type. Direct Cool Refrigerators.\r\n"
							+ "Capacity. 210 L.\r\n"
							+ "Star Rating. ...\r\n"
							+ "Height x Width x Depth (mm) 1342 X 577 X 667.\r\n"
							+ "Color. Ray Purple.\r\n"
							+ "Weight (Kg) 40.1 kg.\n Litters:210L\n Price:24000\n Discount:9%\n OfferPrice:21756");
					buy();
					break;
				case"DoubleDoor":
					System.out.println("Model: RT EONVIBE 366B 25 HCIT ST RH\n Feature:350 L : Good for families of 3-5 members\r\n"
							+ "Inverter\r\n"
							+ "2 Star : For Energy savings up to 20%\r\n"
							+ "Frost Free : Auto fridge defrost to stop ice-build up\r\n"
							+ "Convertible: Offers you more space for all the food you need to store\n Litters:350L\n Price:44585\n Discount:23%\n OfferPrice:33990");
					buy();
					break;
				default:
					throw new SharptronicsException();
					//System.out.println(type+"this model not Exist");
				}
				
			}
		}
		catch(SharptronicsException exe)
		{
			System.out.println(exe+"Oops sorry this model not Exist");
			System.out.println("Are Intrest to Buy singelDoor or DoubleDoor say yes or No");
			String ans=scan.next();
			if(ans.equalsIgnoreCase("Yes"))
			{
				Fridge(needs);
			}
			else if(ans.equalsIgnoreCase("no"))
			{
				System.out.println("Thank you");
			}
		    
		}
	}

	@Override
	public void WashingMachine(String needs) 
	{
		try
		{
			System.out.println(needs+"welcome to Sharptronics which type you want\n FrontLoad\n TopLoad");
			if(needs.equalsIgnoreCase("LG"))
			{
				String type=scan.next();
				switch(type)
				{
				case"FrontLoad":
					System.out.println("Model:FHM1207SDL\n Feature:Fully Automatic Front Load Washing Machines have Great Wash Quality with very less running cost\r\n"
							+ "1200 rpm : Higher the spin speed, lower the drying time\r\n"
							+ "Number of wash programs - 10\r\n"
							+ "5 Star Rating\r\n"
							+ "7 kg\n Price:41990\n Discount:26%\n OfferPrice:30990");
					buy();
					break;
				case"TopLoad":
					System.out.println("Model:T65SKSF4Z\n Feature:700 rpm : Higher the spin speed, lower the drying time\r\n"
							+ "5 Star Rating\r\n"
							+ "6.5 kg\r\n"
							+ "\n price:18490\n Discount:5%\n OfferPrice:17490");
					buy();
					break;
				default:
					throw new SharptronicsException();
				}
			}
			else if(needs.equalsIgnoreCase("SAMSUNG"))
			{
				String type=scan.next();
				switch(type)
				{
				case"FrontLoad":
					System.out.println("Model:WW80T504DAB1TL\n Feature:1400 rpm : Higher the spin speed, lower the drying time\r\n"
							+ "5 Star Rating\r\n"
							+ "8 kg\n Price:44900\n Discount:15%\n OfferPrice:37790");
					buy();
					break;
				case"TopLoad":
					System.out.println("Model:WA65A4002VS/TL\n Feature:680 rpm : Higher the spin speed, lower the drying time\r\n"
							+ "3 Star Rating\r\n"
							+ "6.5 kg\n Price:16800\n Discount:14%\n OfferPrice:14290");
					buy();
					break;
				default:
					throw new SharptronicsException();
				}
			}
			else if(needs.equalsIgnoreCase("IFB"))
			{
				String type=scan.next();
				switch(type)
				{
				case"FrontLoad":
					System.out.println("Model:SENATOR PLUS SXS 8014\n Feature:1400 RPM : Higher the spin speed, lower the drying time\r\n"
							+ "5 Star Rating\r\n"
							+ "8 kg\n Price:43190\n Discount:12%\n Offerprice:37990");
					buy();
					break;
				case"TopLoad":
					System.out.println("Model:TL-REW Aqua\n Feature:720 rpm : Higher the spin speed, lower the drying time\r\n"
							+ "5 Star Rating\r\n"
							+ "6.5 kg\n Price:19290\n Discount:10%\n OfferPrice:17290");
					buy();
					break;
				default:
					throw new SharptronicsException();
				}
			}
		}
		catch(SharptronicsException exe)
		{
			System.out.println(exe+"Oops sorry this model not Exist");
			System.out.println("Are Intrest to Buy FrontLoad or TopLoad say yes or No");
			String ans=scan.next();
			if(ans.equalsIgnoreCase("Yes"))
			{
				WashingMachine(needs);
			}
			else if(ans.equalsIgnoreCase("no"))
			{
				System.out.println("Thank you");
			}
		}
	}

	@Override
	public void Television(String needs) 
	{
		try
		{
			System.out.println(needs+"welcome to Sharptronics which size you want\n 32\n 43\n 55");
			if(needs.equalsIgnoreCase("LG"))
			{
				int size=scan.nextInt();
				switch(size)
				{
				case 32:
					System.out.println("Model:32LQ576BPSA\n Feature:Supported Apps: Netflix|Prime Video|Disney+Hotstar|Youtube\r\n"
							+ "Operating System: WebOS\r\n"
							+ "Resolution: HD Ready 1366 x 768 Pixels\r\n"
							+ "Sound Output: 10 W\r\n"
							+ "Refresh Rate: 60 Hz\n price:23990\n Discount:33%\n OfferPrice:15990");
					buy();
					break;
				case 43:
					System.out.println("Model:43UQ7500PSF\n Feature:Supported Apps: Netflix|Prime Video|Disney+Hotstar|Youtube\r\n"
							+ "Operating System: WebOS\r\n"
							+ "Resolution: Ultra HD (4K) 3840 x 2160 Pixels\r\n"
							+ "Sound Output: 20 W\r\n"
							+ "Refresh Rate: 60 Hz\r\n"
							+ "\n Price:49990\n Discount:38%\n OfferPrice:30990");
					buy();
					break;
				case 55:
					System.out.println("Model:55UQ8020PSB\n Feature:Supported Apps: Netflix|Prime Video|Disney+Hotstar|Youtube\r\n"
							+ "Operating System: WebOS\r\n"
							+ "Resolution: Ultra HD (4K) 3840 x 2160 Pixels\r\n"
							+ "Sound Output: 20 W\r\n"
							+ "Refresh Rate: 60 Hz\n Price:84990\n Discount:39%\n OfferPrice:51490");
					buy();
					break;
					default:
						throw new SharptronicsException();
				}
				
			}
			else if(needs.equalsIgnoreCase("SAMSUNG"))
			{
				int size=scan.nextInt();
				switch(size)
				{
				case 32:
					System.out.println("Model:UA32T4380AKXXL\n feature:Operating System: Tizen\r\n"
							+ "Resolution: HD Ready 1366 x 768 Pixels\r\n"
							+ "Sound Output: 20 W\r\n"
							+ "Refresh Rate: 50 Hz\n Price:19900\n Discount:28%\n OfferPrice:13490");
					buy();
					break;
					default:
						throw new SharptronicsException();
				}
			}
			else if(needs.equalsIgnoreCase("SONY"))
			{
				int size=scan.nextInt();
				switch(size)
				{
				case 32:
					System.out.println("Model:KD-32W820K\n Feature:Operating System: Google TV\r\n"
							+ "Resolution: HD Ready 1366 x 768 Pixels\r\n"
							+ "Sound Output: 20 W\r\n"
							+ "Refresh Rate: 60 Hz\n Price:34990\n Discount:28%\n OfferPrice:24999");
					buy();
					break;
				case 55:
					System.out.println("Model:KD-55X8000H\n Feature:Operating System: Android (Google Assistant & Chromecast in-built)\r\n"
							+ "Resolution: Ultra HD (4K) 3840 x 2160 Pixels\r\n"
							+ "Sound Output: 20 W\r\n"
							+ "Refresh Rate: 50 Hz\n Price:106990\n Discount:28%\n OfferPrice:75999");
					buy();
					break;
					default:
						throw new SharptronicsException();
				}
			}
		}
		catch(SharptronicsException exe)
		{
			System.out.println(exe+"Oops sorry this model no Stock");
			System.out.println("Are Intrest to Buy 32inch 43ich 55inch say yes or No");
			String ans=scan.next();
			if(ans.equalsIgnoreCase("Yes"))
			{
				WashingMachine(needs);
			}
			else if(ans.equalsIgnoreCase("no"))
			{
				System.out.println("Thank you");
			}
		}

		
	}

	@Override
	public void Billing(SystemBilling bill) 
	{
		try {
			Billread();
			billing.add(bill);
			System.out.println(bill.getCustomerName()+" "+"has Billed");
			System.out.println("Thank you for Purchasing");
			Billwrite();
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return;
	}

	@Override
	public void BillingCustomerList() 
	{
		try {
			Billread();
			Iterator<SystemBilling>obj=billing.iterator();
			while(obj.hasNext())
			{
				System.out.println(obj.next());
			}
			Billwrite();
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
	}

	@Override
	public void DeleteCustomer(String name) 
	{
		System.out.println("which field Data you want to delete\n CustomerDetails\n SystemBilling");
		String delete=scan.next();
		try {
			Entryread();
			if(delete.equalsIgnoreCase("CustomerDetails"))
			{
				try {
					Entryread();
					List<CustomerDetails>list=new LinkedList<CustomerDetails>();
					list.addAll(details);
					try
					{
						for(int index=0;index<list.size();index++)
						{
							if(list.get(index).getCustomerName().equalsIgnoreCase(name))
							{
							details.remove(list.get(index));
							System.out.println(name+"has been Deleted successfully");
							Entrywrite();
							return;
							}
						}
						throw new SharptronicsException();
					}
					catch(SharptronicsException exe)
					{
						System.out.println(exe+name+"has not matching place enter register name");
						for(CustomerDetails cus:details)
						{
							System.out.println(cus.getCustomerName());
						}
						System.out.println("which name you want to delete");
						DeleteCustomer(scan.next());
					}
					System.out.println(name+"has deleted");

				} catch (ClassNotFoundException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

		} catch (ClassNotFoundException | IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			Billread();
			 if(delete.equalsIgnoreCase("SystemBilling"))
				{
					List<SystemBilling>list=new Vector<SystemBilling>();
					list.addAll(billing);
					try
					{
						for(int index=0;index<list.size();index++)
						{
							if(list.get(index).getCustomerName().equalsIgnoreCase(name))
							{
							billing.remove(list.get(index));
							System.out.println(name+"has been Deleted successfully");
							Billwrite();
							return;
							}
						}
						throw new SharptronicsException();
					}
					catch(SharptronicsException exe)
					{
						System.out.println(exe+name+"has not matching place enter register name");
						for(SystemBilling sys:billing)
						{
							System.out.println(sys.getCustomerName());
						}
						System.out.println("which name you want to delete");
						DeleteCustomer(scan.next());
					}
					System.out.println(name+"has deleted");

				}

		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  	}

	@Override
	public void UpdateBillingDetails(String name) 
	{
		try {
			Billread();
			SystemBilling bill=null;
			for(SystemBilling sys:billing)
			{
				if(sys.getCustomerName().equalsIgnoreCase(name))
				{
					bill=sys;
					break;
				}
			}
			if(bill!=null)
			{
				try
				{
					System.out.println(name+"which Field you want to Update");
					String field=scan.next();
					switch(field)
					{
					case "CustomerName":
						System.out.println("Enter new Name");
						String name1=scan.next();
						bill.setCustomerName(name1);
						break;
					case "MobileNumber":
						System.out.println("Enter your new MobileNumber");
						long m1=scan.nextLong();
						bill.setMobileNumber(m1);
						break;
					case "CustomerAdvisor":
						System.out.println("Enter your New AdvisorName");
						String ad=scan.next();
						bill.setCustomerAdvisor(ad);
						break;
					case "Brand":
						System.out.println("Enter your new Selectoin Brand");
						String br=scan.next();
						bill.setBrand(br);
						break;
					case "Model":
						System.out.println("Enter your new selectoin Model");
						String mo=scan.next();
						bill.setBrand(mo);
						break;
					case "Quantity":
						System.out.println("Enter your new Quantity");
						int qu=scan.nextInt();
						bill.setQuantity(qu);
						break;
					case "Price":
						System.out.println("Enter your new Price");
						double pr=scan.nextDouble();
						bill.setPrice(pr);
						break;
						default:
							throw new SharptronicsException();
					}
					System.out.println(field+"has been Updated");
					Billwrite();
					return;
				}
				catch(SharptronicsException | InputMismatchException exe)
				{
					Scanner scan=new Scanner(System.in);
					System.out.println(name+"your Field is wrong Enter Correct value\n CustomerName\n MobileNumber\n CustomerAdvisor\n Brand\n Model\n Quantity\n Price");
					System.out.println(name+"which Field you want to update");
					String field=scan.next();
					switch(field)
					{
					case "CustomerName":
						System.out.println("Enter new Name");
						String name1=scan.next();
						bill.setCustomerName(name1);
						break;
					case "MobileNumber":
						System.out.println("Enter your new MobileNumber");
						long m1=scan.nextLong();
						bill.setMobileNumber(m1);
						break;
					case "CustomerAdvisor":
						System.out.println("Enter your New AdvisorName");
						String ad=scan.next();
						bill.setCustomerAdvisor(ad);
						break;
					case "Brand":
						System.out.println("Enter your new Selectoin Brand");
						String br=scan.next();
						bill.setBrand(br);
						break;
					case "Model":
						System.out.println("Enter your new selectoin Model");
						String mo=scan.next();
						bill.setBrand(mo);
						break;
					case "Quantity":
						System.out.println("Enter your new Quantity");
						int qu=scan.nextInt();
						bill.setQuantity(qu);
						break;
					case "Price":
						System.out.println("Enter your new Price");
						double pr=scan.nextDouble();
						bill.setPrice(pr);
						break;
						default:
							System.out.println("Maximum choice is over");
					}
					System.out.println(field+"has been Updated");
					Billwrite();
					return;
				}
			}
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void buy()
	{
		try {
			Billread();
			System.out.println("If you want to buy say Yes or No");
			String buying=scan.next();
			try
			{
			if(buying.equalsIgnoreCase("Yes"))
			{
					System.out.println("Enter CustomerName\n MOblieNumber\n CustomerAdvisor\n Brand\n Model\n Quantity\n Price");
					SystemBilling bill=new SystemBilling(scan.next(), scan.nextLong(), scan.next(), scan.next(), scan.next(), scan.nextInt(), scan.nextDouble());	
				    Billing(bill);
				    Billwrite();
				    return;
				}
				else if(buying.equalsIgnoreCase("No"))
				{
					System.out.println("Thank you");
					return;
				}
			throw new SharptronicsException();
			}
			catch(SharptronicsException exe)
			{
				System.out.println(exe+"Enter correct Datas");
				buy();
			}

		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	synchronized public void run() 
	{
		System.out.println("Welcome to Sharpronics"+" "+Thread.currentThread().getName());
		do
		{
			System.out.println("which process you want\n 1.CustmoerEntry\n 2.Fridge\n 3.WashingMachine\n 4.Television\n 5.EntryCustomerList\n 6.Billing\n 7.BillingCustomerList\n 8.DeleteCustomer\n 9.UpdateBillingDetails\n 10.Sorting\n 11.Exit");
			int menu=scan.nextInt();
			switch(menu)
			{
			case 1:
				System.out.println("place Enter Customer Details");
				System.out.println("Enter CustomerName,CustomerMOblieNumber,CustomerAdvisor,CustomerNeeds,CustomerExpectPrice");
				CustomerDetails cus=new CustomerDetails(scan.next(), scan.nextLong(), scan.next(), scan.next(),scan.nextDouble());
				System.out.println(CustomerEntry(cus));
				break;
			case 2:
				System.out.println("which company you want\n LG\n SAMSUNG\n WHIRLPOOL\n GODREj ");
				String company=scan.next();
				Fridge(company);		
				break;
			case 3:
				System.out.println("which company you want\n LG\n SAMSUNG\n IFB ");
				String company1=scan.next();
				WashingMachine(company1);
				break;
			case 4:
				System.out.println("which company you want\n LG\n SAMSUNG\n SONY ");
				String company2=scan.next();
				Television(company2);
				break;
			case 5:
				System.out.println("Entry customer Listed");
				EntryCustomerList();
				break;
			case 6:
				System.out.println("Enter CustomerName\n MOblieNumber\n CustomerAdvisor\n Brand-LG,SAMSUNG,SONY,WHIRLPOOL,GODREJ,IFB\n Model-LG\rSingleDoor-\n Quantity\n Price");
				SystemBilling bill=new SystemBilling(scan.next(), scan.nextLong(), scan.next(), scan.next(), scan.next(), scan.nextInt(), scan.nextDouble());
				Billing(bill);
			   break;
			case 7:
				System.out.println("Billing Customer Listed");
				BillingCustomerList();
				break;
			case 8:
				System.out.println("which Customer you want delete enter register name");
				String name=scan.next();
				DeleteCustomer(name);
				break;
			case 9:
				System.out.println("which customer Bill you want to Update");
				String update=scan.next();
				UpdateBillingDetails(update);
				break;
			case 10:
				Sorting();
				break;
			case 11:
				if(menu==10)
				{
					System.out.println("Thank you");
					return;
				}
			}
			
		}
		while(true);	
	}

	@Override
	public void Sorting() 
	{
		System.out.println("whitch Data you want to sort\n CustomerDetails\n SystemBilling");
		String sort=scan.next();
		switch(sort)
		{
		case"CustomerDetails":
			try {
				Entryread();
				Collections.sort(details);
				Entrywrite();
				break;
			} catch (ClassNotFoundException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		case"SystemBilling":
			try {
				Billread();
				Collections.sort(billing);
				Billwrite();
			} catch (ClassNotFoundException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}
}
