import java.util.ArrayList;

public class Main
{
	private static int TURN_COUNTER = 0;
	private static ArrayList<Order> orders ;
	private ResultWriter results;
	private static Max max;
	
	public Main()
	{
		results = new ResultWriter();
		orders = new ArrayList<>();
		max = new Max();
	}
	
	public static void main(String[] args)
	{
		kitchenLogic();
	}
	
	private static void kitchenLogic()
	{
		//While we still have orders
		while(!orders.isEmpty())
		{
			//Do our kitchen stuff
			incrementTurn();
			max.approach();
			
		}
		
	}
	
	private static void incrementTurn()
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
