
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;

import java.util.Scanner;


public class Main
{
	//THIS ALL CAN BE MOVED TO THE KITCHEN CLASS
	private Counter Turns;
	private ArrayList<Customer> customers;
//	private Stack<Customer> stack;
//	private Queue<Customer> q;
//	private Queue<Person> pq;
	private ResultWriter results;
	private OrderParser op;
//	private Iterator<Customer> iter;
	
	private Max max;
	private Mat mat;
	private Pat pat;
	private Pac pac;
	//private String file;
	
	public Main(String Filename)
	{
		
		
		max = new Max();
		mat = new Mat();
		pat = new Pat();
		pac = new Pac();
		
		//file = new File(Filename);
		//op = new OrderParser(Filename);
		customers = parse(Filename);
		//results = new ResultWriter(Filename);
		
		

		//iter = customers.iterator();
		Turns = new Counter();
		
	}
	

	//MAYBE TRYING TO PROCESS THEM
	//ALL AT THE SAME TIME IS A BAD IDEA
	//WE NEED TO RETHINK HOW TO DO THIS
	private void kitchenLogic() throws IOException
	{
		ArrayList<Person> managers = new ArrayList<>();
		//While we still have orders
		managers.add(mat);
		managers.add(max);
		managers.add(pac);
		managers.add(pat);
		
		for(Customer c : this.customers)//this is wrong, should work until we have 0 unprocessed
		{
			//Customer c= iter.next();
			//Do our kitchen stuff
			//WE NEED TO USE AN ITERATOR TO SAFELY REMOVE customers from the list
			System.out.println("Customer:" + c.getName() +"," + "Patience:"+ c.patience() +"\n"
								+ "\tOrder:" + c.order().cost() + ","+"Time:" + c.order().timeRemaining()+"\n\n");
			for(Person p: managers)
			{
				System.out.println("Turn" + Turns.count());
				System.out.println("Manager:" + p.getName() + "\n"+
									"\tProfit:" + p.getProfit() + "," + "Disappointments:" + p.disappointments() +"\n\n");
				p.approach(c,Turns);
			}
//			max.approach(c,Turns);
//			mat.approach(c,Turns);
			//pq = pat.approach(pq, c,Turns);
			//pac.approach(c,Turns);
			
//			if(c.order().state())
//				iter.remove();
			
			Turns.addCount();

		}
		
		if(managers.equals(null))
		{
			System.out.println("Managers are null!");
		}
		//this.results.writeResults(managers);

//		try{
//			//if(this.results != null)
//			//	this.results.close();
//		}
//		catch(IOException e)
//		{
//			e.printStackTrace();
//		}
	}
	
	public static ArrayList<Customer> parse(String file)
	{
		String line = "";
		String separator = ",";
		BufferedReader br = null;
		
		ArrayList<Customer>customers = new ArrayList<>();
		//Path pathToFile = Paths.get(file);
		try{
			//BufferedReader br = Files.newBufferedReader(pathToFile ,StandardCharsets.US_ASCII);
			br = new BufferedReader(new FileReader(file));
			while((line = br.readLine())!= null)
			{
				line = line.replaceAll("[$]*", "");
				String[] custs = line.split(separator);
				
				for(int  i = 0; i < custs.length; i ++)
				{
					custs[i] = custs[i].trim();
				}
				//Justify why we're using Object Data Types
				int time = Integer.parseInt(custs[2]);
				double cost = Double.parseDouble(custs[3]);
				int turn = Integer.parseInt(custs[0]);
				int patience = Integer.parseInt(custs[4]);
				
				Order order = new Order(time,cost);
				Customer c = new Customer(custs[1],turn,patience,order);
				customers.add(c);
			}
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}finally
		{
			if(br != null)
			{
				try{
					br.close();
				}catch(IOException e){
					e.printStackTrace();
				}
			}
		}
		return customers;
	}
	
	public static void main(String[] args)
	{
		//STILLS DOESN'T KNOW HOW TO TRAVERSE A DIR TO FIND THE FILE
		System.out.println("Provide a file to process!");
		
		//Scanner scan = new Scanner(System.in);
		//String filename = scan.nextLine();
		/**
		 * CASE INPUT FILE READ > 1
		 * 
		 * create multiple main instances!
		 * all with each corresponding filename!
		 * 
		 */
//		while(filename.equals("") || filename.equals(" "))
//		{
//			System.out.println("Filename must not be null");
//			filename = "";
//			filename = scan.nextLine();
//		}
		
		Main main = new Main("src/input.cvs");
		
		try {
			main.kitchenLogic();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//scan.close();
	}
}
