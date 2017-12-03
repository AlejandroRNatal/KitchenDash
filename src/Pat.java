
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class Pat extends Person
{
	private Queue<Person> patsQueue;
	private double profit;
	private int disappointedCustomers;
	
	public Pat()
	{
		super("Pat");
		this.profit = 0;
		this.disappointedCustomers = 0;
		patsQueue = new LinkedList<Person>();
		
	}
	
	//Refactor this to return a queue
	/*
	public void approach(Queue<Customer> q,List<Customer> customers, Counter TURNS_TAKEN)
	{
		for(Customer c: customers)
		{
			if(c.patience() == 0)
			{
				customers.remove(c);
				addDisappointments();
			}
			
			if(c.turn() == TURNS_TAKEN.count())
				q.add(c);
		}
	}
	*/
	
	public void approach(Customer cust, Counter TURNS_TAKEN)
	{
		if(cust.turn() == TURNS_TAKEN.count())
		{
			patsQueue.add(cust);	
		}
		
		if(cust.patience() <= 0)
		{
			addDisappointments();
			//We should remove him from main list
		}
		
		if(cust.order().state())
			addProfit(cust.order().cost());
		
		return ;
	}
	/*
	 * @return the profit associated to Pat's method
	 */
	
	public double profit()
	{
		return this.profit;
	}
	//tuturuu
	private void addProfit(double p)
	{
		this.profit += p;
	}
	
	/*
	 * @return the number of disappointed customers Pat has had
	 */
	public int disappointments()
	{
		return this.disappointedCustomers;
	}
	
	private void addDisappointments()
	{
		this.disappointedCustomers++;
	}

	public Queue<Person> approach(Queue<Person> pq, Customer c, Counter turns) {
		// TODO Auto-generated method stub
		return null;
	}

}
