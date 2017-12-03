
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
	/*
	 * @return the customers turn
	 */
	public int turn()
	{
		return this.turn;
	}
	
	/*
	 * @return the customers patience level
	 */
	public int patience()
	{
		return this.patience;
	}
	
	public void decrementPatience()
	{
		this.patience--;
	}
	
	/*
	 * @return the customers associated order
	 */
	public Order order()
	{
		return this.order;
	}
	
	
	
}
