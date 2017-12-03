
public class Counter {
	
	private int count;
	
	public Counter()
	{
		this.count = 0;
	}
	
	public void addCount()
	{
		this.count++;
	}
	
	
	/**
	 * 
	 * @return the number of turns transpired
	 */
	public int count()
	{
		return this.count;
	}
}
