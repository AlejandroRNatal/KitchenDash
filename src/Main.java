
import java.io.File;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Main
{
	//THIS ALL CAN BE MOVED TO THE KITCHEN CLASS
	private int TURN_COUNTER = 0;
	private ArrayList<Customer> customers ;
	private Stack<Customer> stack;
	private Queue<Customer> q;
	private Queue<Customer> pq;
	private ResultWriter results;
	private OrderParser op;
	
	private Max max;
	private Mat mat;
	private Pat pat;
	private Pac pac;
	private File file;
	
	public Main(String Filename)
	{
		results = new ResultWriter();
		
		max = new Max();
		mat = new Mat();
		pat = new Pat();
		pac = new Pac();
		file = new File(Filename);
		op = new OrderParser(file);
		customers = op.parse();
		
	}
	

	
	private void kitchenLogic()
	{
		//While we still have orders
		while(!customers.isEmpty())
		{
			//Do our kitchen stuff
			max.approach(customers,turns());
			mat.approach(stack,customers,turns());
			pat.approach(q,customers,turns());
			pac.approach(customers,turns());
			
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
	public int turns()
	{
		return TURN_COUNTER;
	}
	
	public static void main(String[] args)
	{
		System.out.println("Provide a file to process!");
		
		Scanner scan = new Scanner(System.in);
		String filename = scan.nextLine();
		while(filename.equals("") || filename.equals(" "))
		{
			filename = scan.nextLine();
		}
		
		Main main = new Main(filename);
		
		main.kitchenLogic();
		
		scan.close();
	}
}
