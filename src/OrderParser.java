import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class OrderParser 
{
	private File file;
	
	/**
	 * @param String name, the name of the file 
	 * 	
	 * @return the directory containing the file
	 */
	private String getFile(String name)
	{
		//Will return the directory of the wanted file
		return name;
	}
	
	/**
	 * @param String fileDir,
	 * 			 the directory of the file to process
	 * @return parsed Orders to be manipulated
	 */
	public String parse(String fileDir)
	{
		//Will return the processed CSV line(row, whatever)
		String line = "";
		String csvSplitBy= ",";
		
		try(BufferedReader br = new BufferedReader(new FileReader(fileDir)))
		{
			
			while((line = br.readLine()) != null)
			{
				String [] order = line.split(csvSplitBy);
			}
			
		}catch(IOException e)
		{
			e.printStackTrace();
		}
		return null;
	}

}
