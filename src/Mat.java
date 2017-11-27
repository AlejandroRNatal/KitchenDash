

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Mat extends Person
{
	//private Stack<Person> stack;
	private double profit;
	private int disappointedCustomers;

	public Mat()
	{
		super("Mat");
		//stack = new Stack<>();
		this.profit = 0;
		this.disappointedCustomers = 0;
	}
	
	//Dumbass, cant remove them from the list if we havent even
	//processed their order
	public void approach(Stack<Customer> stack,List<Customer> customers, int TURNS_TAKEN)
	{
		//Should run while list has customers
//		for(Customer c: customers)
//		{
//			if(c.patience() == 0)
//			{
//				//remove from list
//				addDisappointments();
//			}
//			if(c.turn() == TURNS_TAKEN)
//				stack.add(c);
//			
//			else{
//				c.decrementPatience();
//			}
//		}
		List<Customer> cop = new ArrayList<>(customers);
		

			for(int i = 0 ; i < cop.size(); i++)
			{
				if(cop.get(i).turn() == TURNS_TAKEN)
				{
					stack.add(customers.get(i));
				}

			}
		

		
		
		
		
	}

//	private Person lastPerson()
//	{
//		return this.stack.pop();
//	}
	
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


