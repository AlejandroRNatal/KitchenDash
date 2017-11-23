package people;
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
	}
	
	//Maybe the approach should be abstracted to another class
	@Override
	public void approach()
	{
		sort(customers);
	}
}
