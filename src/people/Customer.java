package people;
import defaultpackage.Order;

public class Customer extends Person
{
	private int patience;
	private Order order;
	
	public Customer(String name, int patience, Order order)
	{
		super(name);
		this.patience = patience;
		this.order = order;
	}
	
	public int patience()
	{
		return this.patience;
	}
	
	public void decrementPatience()
	{
		this.patience--;
	}
	
	public Order order()
	{
		return this.order;
	}
	
	
	
}
