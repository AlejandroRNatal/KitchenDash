import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class OrderParser 
{
	private String file = " ";
	private String line = " ";
	private String splitter = " ";
	
	public OrderParser(String file)
	{
		this(file, "", ",");
	}
	
	public OrderParser(String file, String line, String splitter)
	{
		this.file = "src\\input.csv";
		this.line = line;
		this.splitter = splitter;
	}
	
	/**
	 * @param String name, the name of the file 
	 * 	
	 * @return the directory containing the file
	 */
	public String getFile()
	{
		return this.file;
	}
	
//	public ArrayList<Customer> parse()
//	{
//		ArrayList<Customer> customers = new ArrayList<>();
//		 Path pathToFile = Paths.get(getFile()); 
//		 System.out.println(pathToFile);
//		
//		try
//		{
//			System.out.println("Im inside Try in parse() !");
//			if(!pathToFile.equals(null))
//			{
//			BufferedReader br = Files.newBufferedReader(pathToFile , StandardCharsets.US_ASCII);
//			String [] customer = null;
//			System.out.println("Buffered file's state:" + br.readLine().equals(null) + "\n");
//			System.out.println("Line before while loop:" + line);
//			while((line = br.readLine()) != null)
//			{
//				System.out.println("Im Inside while loop after try in parse()");
//				line = line.replaceAll("[$]*", "");
//				customer = line.split(this.splitter);
//				//System.out.println(customer);
//			
//				
//				
//				for(int i = 0 ; i < customer.length; i++)
//				{
//					System.out.println("Customer Attributes with index i:" + customer[i]);
//					customer[i] = customer[i].trim();
//					System.out.println("Customer Attributes with index i:" + customer[i]);
//				}
//				
//				//Justify why we're using Object Data Types
//				int time = Integer.parseInt(customer[2]);
//				double cost = Double.parseDouble(customer[3]);
//				int turn = Integer.parseInt(customer[0]);
//				int patience = Integer.parseInt(customer[4]);
//				
//				Order order = new Order(time,cost);
//				Customer c = new Customer(customer[1],turn,patience,order);
//				customers.add(c);
//				//line = br.readLine();
//			}
//			
//			}
//		}
//		catch(IOException e)
//		{
//			e.printStackTrace();
//		}
//		return customers;
//		
//	}
	
	/**
	 * @param String fileDir,
	 * 			 the directory of the file to process
	 * @return parsed customers to be manipulated
	 */
	//ASSUMES THERE ARE 5 FIELDS!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
//	public static ArrayList<Customer> parse(String fileDir)
//	{
//		//Will return the processed CSV line(row, whatever)
//		//We need to ignore special characters to be ignored
//		Path pathToFile = Paths.get(fileDir);
//		String line = "";
//		String csvSplitBy= ",";
//		ArrayList<Customer> customers = new ArrayList<>();
//		
//		try
//		{
//			BufferedReader br = Files.newBufferedReader(pathToFile , StandardCharsets.US_ASCII);
//			String [] customer;
//			while((line = br.readLine()) != null)
//			{
//				line = line.replaceAll("[$]*", "");
//				customer = line.split(csvSplitBy);
//				
//				for(int i = 0 ; i < customer.length; i++)
//					customer[i] = customer[i].trim();
//				
//				//Justify why we're using Object Data Types
//				int time = Integer.parseInt(customer[2]);
//				double cost = Double.parseDouble(customer[3]);
//				int turn = Integer.parseInt(customer[0]);
//				int patience = Integer.parseInt(customer[4]);
//				
//				Order order = new Order(time,cost);
//				Customer c = new Customer(customer[1],turn,patience,order);
//				customers.add(c);
//			}
//			
//		}catch(IOException e)
//		{
//			e.printStackTrace();
//		}
//		return customers;
//	}

}
