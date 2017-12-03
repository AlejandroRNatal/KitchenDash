
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Main
{
	//THIS ALL CAN BE MOVED TO THE KITCHEN CLASS
	private Counter Turns;
	private ArrayList<Customer> customers ;
	private Stack<Customer> stack;
	private Queue<Customer> q;
	private Queue<Person> pq;
	private ResultWriter results;
	private OrderParser op;
	private Iterator<Customer> iter;
	
	private Max max;
	private Mat mat;
	private Pat pat;
	private Pac pac;
	private File file;
	
	public Main(String Filename)
	{
		
		
		max = new Max();
		mat = new Mat();
		pat = new Pat();
		pac = new Pac();
		
		file = new File(Filename);
		results = new ResultWriter(Filename);
		
		op = new OrderParser(file);
		customers = op.parse();
		iter = customers.iterator();
		Turns = new Counter();
		
	}
	

	//MAYBE TRYING TO PROCESS THEM
	//ALL AT THE SAME TIME IS A BAD IDEA
	//WE NEED TO RETHINK HOW TO DO THIS
	private void kitchenLogic()
	{
		//While we still have orders
		while(iter.hasNext())
		{
			Customer c= iter.next();
			//Do our kitchen stuff
			//WE NEED TO USE AN ITERATOR TO SAFELY REMOVE customers from the list

			max.approach(c,Turns);
			mat.approach(c,Turns);
			pq = pat.approach(pq, c,Turns);
			pac.approach(c,Turns);
			
			if(c.order().state())
				iter.remove();
			
			Turns.addCount();

		}
		//Write Results here
		this.results.write("");
		
	}
	
	public static void main(String[] args)
	{
		//STILLS DOESN'T KNOW HOW TO TRAVERSE A DIR TO FIND THE FILE
		System.out.println("Provide a file to process!");
		
		Scanner scan = new Scanner(System.in);
		String filename = scan.nextLine();
		while(filename.equals("") || filename.equals(" "))
		{
			System.out.println("Filename must not be null");
			filename = scan.nextLine();
		}
		
		Main main = new Main(filename);
		
		main.kitchenLogic();
		
		scan.close();
	}
}
