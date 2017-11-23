
public class Order
{
	private int time_to_process;
	private double cost;
	private boolean done;
	
	public Order(int time,  int cost)
	{
		this.time_to_process = time;
		this.cost = cost;
		this.done = false;
		
	}
	
	public int time_remaining()
	{
		return this.time_to_process;
	}
	
	public double cost()
	{
		return this.cost;
	}
	
	public boolean state()
	{
		return this.done;
	}
	
	private void  processedOrder()
	{
		this.done = true;
	}
	
	private void decrement_time()
	{
		if(time_remaining()> 0 )
			this.time_to_process--;
		else{
			System.out.println("Already passed time remaining!");
		}
	}

}
