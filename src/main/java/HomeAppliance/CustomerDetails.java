package HomeAppliance;

import java.io.Serializable;
import java.util.Comparator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDetails implements Comparable<CustomerDetails>,Serializable
{
	private String CustomerName;
	private long MoblieNumber;
	private String CustomerAdvisor;
	private String CustomerNeeds;
	private double CustomerExpectPrice;
	@Override
	public int compareTo(CustomerDetails o) 
	{
		return this.CustomerName.compareTo(o.CustomerName);
	}
	
}
