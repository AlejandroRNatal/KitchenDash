
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class Pat extends Person
{
	private Queue<Customer> patsQueue;
	private ArrayList<Customer> served;
	private ArrayList<Customer> waiting;
	private double profit;
	private int disappointedCustomers;
	
	public Pat()
	{
		super("Pat");
		this.profit = 0;
		this.disappointedCustomers = 0;
		patsQueue = new LinkedList<Customer>();
		served = new ArrayList<>();
		waiting = new ArrayList<>();
		
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
		if(!cust.equals(null)&& (!served.contains(cust)|| !waiting.contains(cust) || !patsQueue.contains(cust) ))
		{
			if(cust.turn() == TURNS_TAKEN.count())
			{
				patsQueue.add(cust);
			}else{
				waiting.add(cust);
			}
		}
		
		else
		{
			//To see if we add someone to the queue
			//THIS MEANS CUSTOMER HAS YET TO ARRIVE TO RESTAURANT
			if(!waiting.isEmpty())
			{
				ArrayList<Customer> toRemove = new ArrayList<>();
				for(Customer c: waiting)
				{
					if(c.turn() == TURNS_TAKEN.count())
					{
						// Might have a problem here if we add them unnecessarily twice
						toRemove.add(c);
						//c.order().processedOrder();
						patsQueue.add(c);
					}
				}
				
				//Might need to check if results in nullpointer
				for(Customer c: toRemove)
					waiting.remove(c);
			}
			//IF THERE ARE CUSTOMERS IN LINE-UP
			if(!patsQueue.isEmpty())
			{
				for(Customer c: patsQueue)
				{
					if(patsQueue.peek().order().timeRemaining() == 0)
					{
						served.add(c);
						double price = patsQueue.remove().order().cost();
						addProfit(price);
						
					}
					if(c.patience() == 0)
					{
						//Remove method may not push all the other elements down how I want them to
						//And result in a bunch of null values
						patsQueue.remove(c);
						addDisappointments();
					}
					
					else
					{
						c.decrementPatience();
						//Because only the top order has been atended
						if(c.equals(patsQueue.peek()))
							c.order().decrementTime();
					}
					
				}//End For
				
			}//End If
		}
		
	}
	
//	public void approach(Customer cust, Counter TURNS_TAKEN)
//	{
//		if(patsQueue.size() > 0)
//		{
//			if(patsQueue.peek().order().timeRemaining() <= 0)
//			{
//				patsQueue.peek().order().processedOrder();
//			}
//			
//
//			
//			if(patsQueue.peek().order().state())
//			{
//				addProfit(patsQueue.remove().order().cost());
//			}
//		}
//		
//		else
//		{
//			if(cust.turn() == TURNS_TAKEN.count())
//			{
//				patsQueue.add(cust);	
//			}
//			
//			if(cust.patience() <= 0)
//			{
//				addDisappointments();
//				//We should remove him from main list
//			}
//			
//			if(patsQueue.peek() != null)
//				for(Customer c : patsQueue)
//				{
//					c.order().decrementTime();
//				}
//			
//			else{
//				cust.decrementPatience();
//			}
//			
//			//WE INCREMENT THE TURN COUNTER HERE
//			//MIGHT WANT TO CREATE A LOCAL COPY AND MANIPULATE THAT
//			//TURNS_TAKEN.addCount();
//		}
//		return ;
//	}
	/*
	 * @return the profit associated to Pat's method
	 */

	public double getProfit()
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

//	public Queue<Person> approach(Queue<Person> pq, Customer c, Counter turns) {
//		// TODO Auto-generated method stub
//		return null;
//	}

}
