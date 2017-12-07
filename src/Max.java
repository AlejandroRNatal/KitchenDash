
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Max extends Person
{
	private Queue<Customer> q;
	private ArrayList<Customer> notInRestaurant;
	private ArrayList<Customer> served;
	private int disappointedCustomers;
	private double profit;
	
	public Max()
	{
		super("Max");
		this.profit = 0;
		this.disappointedCustomers = 0;
		this.q = new LinkedList<Customer>();
		this.served = new ArrayList<>(); //Used to make sure we don't process duplicates
		this.notInRestaurant = new ArrayList<>();
	}
	
	//My Sorting may be wrong, so check this when debugging
	private void sort(ArrayList<Customer> list)
	{
		for(int i = 0 ;i < list.size() ; i++)
		{
			for(int j = 0 ; j < i ; j++)
			{
				if(list.get(i).order().cost() < list.get(j).order().cost())
				{
					swap(list.get(i) , list.get(j));
				}
			}
		}
	}
	private void swap(Customer a, Customer b)
	{
		Customer temp = a;
		a = b;
		b = temp;
		
	}

	//MAX-PROFIT FIRST
	public void approach(Customer cust, Counter TURNS_TAKEN)
	{
		if(!cust.equals(null) && (!served.contains(cust)|| !notInRestaurant.contains(cust) || !q.contains(cust)))
		{
			if(cust.turn() == TURNS_TAKEN.count())
			{
				this.q.add(cust);
			}
			
			else
			{
				notInRestaurant.add(cust);
				sort(notInRestaurant);
			}

				
	
		}
		
		else
		{
			if(!notInRestaurant.isEmpty())
			{
				ArrayList<Customer> toRemove = new ArrayList<>();
				for(Customer c: notInRestaurant)
				{
						q.add(c);	
				}
				
				for(Customer c: toRemove)
				{
					notInRestaurant.remove(c);
				}
			}
			
			if(!q.isEmpty())
			{
				if(q.peek().order().timeRemaining() == 0)
				{
					addProfit(q.peek().order().cost());		
					served.add(q.remove());
					
				}
//				if(q.peek().patience() == 0)
//				{
//					q.remove();
//					addDisappointments();
//				}
				
				for(Customer c: q)
				{
					if(c.patience() == 0)
					{
						q.remove(c);
						addDisappointments();
					}
					
					else
					{	
						c.decrementPatience();
						
						if(c.equals(q.peek()))
						{
							c.order().decrementTime();
						}
						
					}//End Else
				}//End For
				
				
			}//End Queue is Empty- If
			
		}
	}
	/*
	public void approach( List<Customer> customers, Counter TURNS_TAKEN)
	{
		//does the MAX PROFIT APPROACH
		//Iterate over customers
		for(Customer c: customers)
		{
			//If customer's turn, add to queue
			if(c.turn() == TURNS_TAKEN.count())
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
	*/
	public double getProfit()
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
