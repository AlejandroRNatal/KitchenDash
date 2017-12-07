

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Mat extends Person
{
	private ArrayList<Customer> notInRest;
	private ArrayList<Customer> served;
	private Stack<Customer> stack;
	private double profit;
	private int disappointedCustomers;

	public Mat()
	{
		super("Mat");
		this.notInRest = new ArrayList<>();
		this.served = new ArrayList<>();
		this.stack = new Stack<>();
		this.profit = 0;
		this.disappointedCustomers = 0;
	}
	
	//Dumbass, cant remove them from the list if we havent even
	//processed their order
	public void approach(Customer cust, Counter TURNS_TAKEN)
	{
		//Maybe my order of negations is wrong and need some reworking
		if( (!served.contains(cust)|| !notInRest.contains(cust) || !stack.contains(cust)))
		{
//			if(cust.turn() == TURNS_TAKEN.count())
//			{
				notInRest.add(cust);
//			}
		}
		
		else
		{
			if(!notInRest.isEmpty())
			{
				ArrayList<Customer> toRemove = new ArrayList<>();
				for(Customer c: notInRest)
				{
					if(c.turn() == TURNS_TAKEN.count())
					{
						toRemove.add(c);
						stack.add(c);
						
					}
				}
				
				for(Customer c: toRemove)
				{
					notInRest.remove(c);
				}
			}
			
			if(!stack.isEmpty())
			{
				if(stack.peek().order().timeRemaining() == 0)
				{
					addProfit(stack.peek().order().cost());		
					served.add(stack.pop());
					
				}
				
				for(Customer c: stack)
				{
					if(c.patience() == 0)
					{
						stack.remove(c);
						addDisappointments();
					}
					
					else
					{	
						c.decrementPatience();
						
						if(c.equals(stack.peek()))
						{
							c.order().decrementTime();
						}
						
					}//End Else
				}//End For
				
				
			}//End Queue is Empty- If
			
		}
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
//		List<Customer> cop = new ArrayList<>(customers);
		

//			for(int i = 0 ; i < cop.size(); i++)
//			{
//				if(cop.get(i).turn() == TURNS_TAKEN.count())
//				{
//					stack.add(customers.get(i));
//				}
//
//			}
//		
//		for(Customer cust: cop)
//		{
//		
//
//			if(stack.size() > 0)
//			{
//				if(stack.peek().order().timeRemaining() <= 0)
//				{
//					stack.peek().order().processedOrder();
//				}
//				
//
//				
//				if(stack.peek().order().state())
//				{
//					addProfit(stack.pop().order().cost());
//				}
//			}
//			
//			else
//			{
//				if(cust.turn() == TURNS_TAKEN.count())
//				{
//					stack.add(cust);	
//				}
//				
//				if(cust.patience() <= 0)
//				{
//					addDisappointments();
//					//We should remove him from main list
//				}
//				
//				if(stack.peek() != null)
//						cust.order().decrementTime();
//					
//				
//				else{
//					cust.decrementPatience();
//				}
//				
//				//WE INCREMENT THE TURN COUNTER HERE
//				//MIGHT WANT TO CREATE A LOCAL COPY AND MANIPULATE THAT
//				TURNS_TAKEN.addCount();
//			}
//			
//		}
//			return ;
//		
//		
		
	}

	private Person lastPerson()
	{
		return this.stack.pop();
	}
	
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


