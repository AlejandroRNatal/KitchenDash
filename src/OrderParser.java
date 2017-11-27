import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class OrderParser 
{
	private File file;
	private String line;
	private String splitter;
	
	public OrderParser(File file)
	{
		this(file, "", ",");
	}
	
	public OrderParser(File file, String line, String splitter)
	{
		this.file = file;
		this.line = line;
		this.splitter = splitter;
	}
	
	/**
	 * @param String name, the name of the file 
	 * 	
	 * @return the directory containing the file
	 */
	public File getFile()
	{
		return this.file;
	}
	
	public ArrayList<Customer> parse()
	{
		ArrayList<Customer> customers = new ArrayList<>();
		try(BufferedReader br = new BufferedReader(new FileReader(getFile())))
		{
		
			while((line = br.readLine()) != null)
			{
				
				String [] customer = line.split(this.splitter);
				
				//Justify why we're using Object Data Types
				int time = Integer.parseInt(customer[2]);
				double cost = Double.parseDouble(customer[3]);
				int turn = Integer.parseInt(customer[0]);
				int patience = Integer.parseInt(customer[4]);
				
				Order order = new Order(time,cost);
				Customer c = new Customer(customer[1],turn,patience,order);
				customers.add(c);
			}
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		return customers;
		
	}
	
	/**
	 * @param String fileDir,
	 * 			 the directory of the file to process
	 * @return parsed customers to be manipulated
	 */
	//ASSUMES THERE ARE 5 FIELDS!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
	public static ArrayList<Customer> parse(String fileDir)
	{
		//Will return the processed CSV line(row, whatever)
		String line = "";
		String csvSplitBy= ",";
		ArrayList<Customer> customers = new ArrayList<>();
		
		try(BufferedReader br = new BufferedReader(new FileReader(fileDir)))
		{
			
			while((line = br.readLine()) != null)
			{
				
				String [] customer = line.split(csvSplitBy);
				
				//Justify why we're using Object Data Types
				int time = Integer.parseInt(customer[2]);
				double cost = Double.parseDouble(customer[3]);
				int turn = Integer.parseInt(customer[0]);
				int patience = Integer.parseInt(customer[4]);
				
				Order order = new Order(time,cost);
				Customer c = new Customer(customer[1],turn,patience,order);
				customers.add(c);
			}
			
		}catch(IOException e)
		{
			e.printStackTrace();
		}
		return customers;
	}

}
