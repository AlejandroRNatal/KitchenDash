
import java.util.ArrayList;
import java.util.List;

public class Pac extends Person
{
	//private ArrayList<Customer> customers;
	private int profit;
	private int disappointedCustomers;
	
	public Pac(){
		super("Pac");
		this.profit = 0;
		this.disappointedCustomers = 0;
	}
	
	private void sort(ArrayList<Customer> list)
	{
		//Verifies time and sorts by shortest time going first
//		for(int i = 0 ; i < list.size(); i++)
//		{
//			for(int l = i ; l < list.size();l++)
//			{
//				if(list.get(i).patience()> list.get(l).patience())
//				{
//					int temp = list.get(l).patience();
//					
//				}
//			}
//		}
	}
	
	//Maybe the approach should be abstracted to another class
	public void approach(ArrayList<Customer> li,Counter TURNS_TAKEN)
	{
		//sort(customers);
		//customers.sort(arg0);
	}
	
	public int profit()
	{
		return this.profit;
	}
	
	private void addProfit(int p)
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
