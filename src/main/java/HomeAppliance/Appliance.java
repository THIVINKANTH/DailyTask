package HomeAppliance;

public interface Appliance 
{
	public String CustomerEntry(CustomerDetails customer);
	public void EntryCustomerList();
	public void Fridge(String needs);
	public void WashingMachine(String needs);
	public void Television(String needs);
	public void Billing(SystemBilling bill);
	public void BillingCustomerList();
	public void DeleteCustomer(String name);
	public void UpdateBillingDetails(String name);
	public void Sorting();

}
