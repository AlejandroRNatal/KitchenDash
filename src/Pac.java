
import java.util.ArrayList;

public class Pac extends Person
{
	private ArrayList<Customer> customers;
	
	public Pac(){
		super("Pac");
	}
	
	private void sort(ArrayList<Customer> list)
	{
		//Verifies time and sorts by shortest time going first
		for(int i = 0 ; i < list.size(); i++)
		{
			for(int l = i ; l < list.size();l++)
			{
				if(list.get(i).patience()> list.get(l).patience())
				{
					int temp = list.get(l).patience();
					
				}
			}
		}
	}
	
	//Maybe the approach should be abstracted to another class
	@Override
	public void approach()
	{
		//sort(customers);
		//customers.sort(arg0);
	}
	

}
