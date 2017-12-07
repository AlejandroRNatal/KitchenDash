import java.util.List;

public abstract class Person
{
	private String name;
	
	public Person(String name)
	{
		this.name = name; 
	}
	
	public Person()
	{
		this("Max");
	}
	
	public double getProfit()
	{
		return 0;
	}
	public String getName()
	{
		return this.name;
	}
	
	public  void approach(Customer c, Counter turns)
	{
		
	}

	public void approach(List<Customer> customers) {
		// TODO Auto-generated method stub
		
	}

	public int disappointments() {
		// TODO Auto-generated method stub
		return 0;
	}
}
