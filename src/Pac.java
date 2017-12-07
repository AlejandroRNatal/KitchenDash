
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Pac extends Person
{
	//private ArrayList<Customer> customers;
	private double profit;
	private int disappointedCustomers;
	private Queue<Customer> waitq;
	private ArrayList<Customer> waiting;
	private ArrayList<Customer> served;
	//private ArrayList<Customer> finished;
	public Pac()
	{
		super("Pac");
		this.profit = 0;
		this.disappointedCustomers = 0;
		this.waitq = new LinkedList<>();
		this.waiting = new ArrayList<Customer>();
		this.served = new ArrayList<>();
	}
	
	private void swap(Customer a , Customer b)
	{
		Customer temp = a;
		a = b;
		b = temp;
	}
	
	private void addToQueue(ArrayList<Customer> list)
	{
		if(list != null)
			for(Customer c: list)
			{
				if(!waitq.contains(c))
					waitq.add(c);
			}
		else{
			System.out.println("List not Initiallized");
		}
	}
	
	private void sort(ArrayList<Customer> list)
	{
		//Verifies time and sorts by shortest time going first
		for(int i = 0; i < list.size(); i++)
		{
			for(int j = i +1 ; j < list.size() -1 ; j++)
			{
				if(list.get(j).order().timeRemaining() < list.get(i).order().timeRemaining())
				{
					swap(list.get(j),list.get(i));
				}
			}
		}
		
	}
	
	//Shortest Job First
	//Maybe the approach should be abstracted to another class
	public void approach(Customer c,Counter TURNS_TAKEN)
	{
		
		if(c != null && (!waiting.contains(c) || !waitq.contains(c)||!served.contains(c)))
		{
			//THIS SHOULD NOT WORK LIKE THIS
			//BECAUSE IT GIVES PRIORITY TO TURN AND NOT FOOD TIME
//			if(c.turn() == TURNS_TAKEN.count() )
//			{
//				addProfit(c.getProfit());
//				served.add(c);
//				c.order().processedOrder();//This will cause concurrency problems
//			}
//			
//			else{
				waiting.add(c);
//			}
			
			if(!waiting.isEmpty())
			{
				//Sort it here
				sort(waiting);
			}
		}
		//Should verify if there were any changes to waiting vs the q
		addToQueue(waiting);
		
		if(!waitq.equals(null))
		{
			//Concurrency problem here, we need to use iterators
			for(Customer d: waitq)
			{
				if(d.order().timeRemaining() == 0)
				{
					//Remove from list
					addProfit(d.order().cost());
					d.order().processedOrder();
					served.add(waitq.remove());
					
					
				}
				//The sum of the disappointments and served array list size = total customers
				if(d.patience() == 0)
				{
					waitq.remove(d);
					addDisappointments();
				}
				else{
					
					d.decrementPatience();
					d.order().decrementTime();
				}
			}
			
		}
		
		//sort(customers);
		//customers.sort(arg0);
	}
	

	public double getProfit()
	{
		return this.profit;
	}
	
	public void addProfit(double p)
	{
		this.profit += p;
	}
	
	public int disappointments()
	{
		return this.disappointedCustomers;
	}
	
	public void addDisappointments()
	{
		this.disappointedCustomers++;
	}

}
