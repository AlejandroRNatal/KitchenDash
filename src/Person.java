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
	
	public String getName()
	{
		return this.name;
	}
	
	public  void approach()
	{
		
	}

	public void approach(List<Customer> customers) {
		// TODO Auto-generated method stub
		
	}
}
