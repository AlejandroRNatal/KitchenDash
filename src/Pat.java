
import java.util.List;
import java.util.Queue;


public class Pat extends Person
{
	//private Queue<Person> patsQueue;
	private double profit;
	private int disappointedCustomers;
	
	public Pat()
	{
		super("Pat");
		this.profit = 0;
		this.disappointedCustomers = 0;
		//patsQueue = new Queue<>();
	}
	
	
	public void approach(Queue<Customer> q,List<Customer> customers, int TURNS_TAKEN)
	{
		for(Customer c: customers)
		{
			if(c.patience() == 0)
			{
				customers.remove(c);
				addDisappointments();
			}
			
			if(c.turn() == TURNS_TAKEN)
				q.add(c);
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
