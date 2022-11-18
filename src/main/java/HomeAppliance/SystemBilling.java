package HomeAppliance;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SystemBilling implements Comparable<SystemBilling>,Serializable
{
	private String CustomerName;
	private long MobileNumber;
	private String CustomerAdvisor;
	private String Brand;
	private String Model;
	private int Quantity;
	private double Price;
	@Override
	public int compareTo(SystemBilling o) 
	{
		return this.CustomerName.compareTo(o.CustomerName);
	}

}
