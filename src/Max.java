
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Max extends Person
{
	//private Queue<Person> q;
	private int disappointedCustomers;
	private double profit;
	
	public Max()
	{
		super("Max");
		this.profit = 0;
		this.disappointedCustomers = 0;
	}
	
	
	public void approach( List<Customer> customers, int TURNS_TAKEN)
	{
		//does the MAX PROFIT APPROACH
		//Iterate over customers
		for(Customer c: customers)
		{
			//If customer's turn, add to queue
			if(c.turn() == TURNS_TAKEN)
				//q.add(c);
			
			//if Customer's patience hits 0
			if(c.patience() == 0)
			{
				//Remove him from list
				addDisappointments();
			}
			
			else
				c.decrementPatience();
		}
		
		
	}
	
	public double profit()
	{
		return this.profit;
	}
	
	private void addProfit(double p)
	{
		this.profit += p;
	}
	
	public int disappointments()
	{
		return this.disappointedCustomers;
	}
	
	private void addDisappointments()
	{
		this.disappointedCustomers++;
	}

}
