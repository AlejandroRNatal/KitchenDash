
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Max extends Person
{
	private Queue<Person> q;
	private int dispappointedCustomers;
	
	public Max()
	{
		super("Max");
	}
	
	
	public int approach(List<Customer> customers, int TURNS_TAKEN)
	{
		//does the FIFO approach
		// sort here
		int disappointedCustomers = 0;
		
		sort(customers);
		//Iterate over customers
		for(Customer c: customers)
		{
			//If customer's turn, add to queue
			if(c.turn() == TURNS_TAKEN)
				q.add(c);
			
				//add to queue
			if(c.patience() == 0)
			{
				//Remove him from list
				disappointedCustomers++;
			}
			
			else
				c.decrementPatience();
		}
		
		return disappointedCustomers;
	}
	
	public void sort(List<Customer> cs)
	{
		
	}
}
