import java.util.ArrayList;

public class Main
{
	private int TURN_COUNTER = 0;
	private ArrayList<Order> orders ;
	private ResultWriter results;
	
	public Main()
	{
		results = new ResultWriter();
		orders = new ArrayList<>();
	}
	
	public static void main(String[] args)
	{
		
	}
	
	public void kitchenLogic()
	{
		//While we still have orders
		while(!orders.isEmpty())
		{
			//Do our kitchen stuff
			incrementTurn();
			
		}
		
	}
	
	private void incrementTurn()
	{
		TURN_COUNTER++;
	}
	
	/**
	 * 
	 * @return the number of turns transpired
	 */
	private int turns()
	{
		return TURN_COUNTER;
	}
}
