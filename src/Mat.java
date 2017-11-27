

import java.util.Stack;

public class Mat extends Person{
	
	private Stack<Person> lastComeFirstServed;

	public Mat()
	{
		super("Mat");
	}
	
	@Override
	public void approach()
	{
		lastComeFirstServed = new Stack<>();
		
	}

	private Person lastPerson()
	{
		return this.lastComeFirstServed.pop();
	}
}


