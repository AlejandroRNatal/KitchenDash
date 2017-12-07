import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class ResultWriter
{
	private Writer writer;
	private FileOutputStream fop = null;
	private File file;
	
	private String content;
	
	public ResultWriter(String filename)
	{
		//WILL NOT CLOSE FILE OBJECT UNLESS WRITE IS CALLED
		try {
			this.writer = new FileWriter(outputFilename(filename));
			this.file = new File(outputFilename(filename));
			this.fop = new FileOutputStream(outputFilename(filename));
		} catch ( IOException e) {

			e.printStackTrace();
		}
	}
	

	private String outputFilename(String f)
	{
		StringBuilder str_b = new StringBuilder();
		
		String[] preFormat = f.split(".");
		
		String out = "out";
		
		for(int i = 0; i < preFormat.length ; i ++)
		{
			str_b.append(preFormat[i]);
			if(i == preFormat.length - 1)
			{
				str_b.append(out);
				break;
			}
		}
		
		return str_b.toString();
		
	}

	/*
	 * @param the string we wish to format
	 * @return csv-formatted string
	 */
	private static String csvFormat(String str)
	{
		String result = str;
		if(result.contains("\""))
			result = result.replace("\"", "\"\"");
		
		return result;
	}
	
	public static void writeLine(Writer w, List<String> v , char separ, char customQ) throws IOException
	{
		boolean first =  true;
		if(separ == ' ')
			separ = ',';
		
		
		StringBuilder str_b = new StringBuilder();
		for(String c: v)
		{
			if(!first)
				str_b.append(separ);
			if(customQ == ' ')
				str_b.append(csvFormat(c));
			else
				str_b.append(customQ).append(csvFormat(c)).append(customQ);
			
			first = false;
				
		}
		str_b.append("\n");
		w.append(str_b.toString());
		
	}
	
	public void writeResults(ArrayList<Person> people)
	{
		List<String> results = new ArrayList<>();
		if(people.equals(null)| people.isEmpty())
			System.out.println("People Array List is null in write results method!");
		
		for(Person p: people)
		{
			System.out.println(p.getName() +"'s approach profit:" + p.getProfit());
			System.out.println(p.getName()+"'s approach number of disappointed customers:"+ p.disappointments());
			results.add(p.getName() +"'s approach profit:" + p.getProfit());
			results.add(p.getName()+"'s approach number of disappointed customers:"+ p.disappointments());
			
		}
		try {
			writeLine(this.writer,results,' ', ' ');
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Wrote to file, do not forget to close after finishing with it!");
	}
	
	public void close() throws IOException
	{
		if(fop != null)
			this.fop.close();
		if(writer != null)
			this.writer.close();
		
		System.out.println("Successfully Closed ResultWriter");
	}
	
	public void write(String name) throws IllegalArgumentException
	{
		if(name == null)
			throw new IllegalArgumentException("The name to write for file cannot be null!");
		
	
		try{
			file = new File(name);
			fop = new FileOutputStream(file);
			
			if(!file.exists())
				file.createNewFile();
			byte[] contentInBytes = content.getBytes();
			
			fop.write(contentInBytes);
			fop.flush();
			fop.close();
			
			System.out.println("Done writing file:" + name);
		}
		catch(IOException e)
		{
			e.printStackTrace();
			
		}
			finally
			{
				try
				{
					if(fop != null)
						fop.close();
				}
				catch(IOException e)
				{
					e.printStackTrace();
				}
			}
	}

}
