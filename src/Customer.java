
public class Customer extends Person
{
	private int patience;
	private Order order;
	private int turn;
	
	public Customer(String name,int turn, int patience, Order order)
	{
		super(name);
		this.turn = turn;
		this.patience = patience;
		this.order = order;
	}
	
	public int turn()
	{
		return this.turn;
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
