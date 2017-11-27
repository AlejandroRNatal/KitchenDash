import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Writer;
import java.util.List;

public class ResultWriter
{
	private FileOutputStream fop = null;
	private File file;
	
	private String content;
	
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
			
			System.out.println("Done");
		}catch(IOException e)
		{
			e.printStackTrace();
			
		}finally{
			try{
				if(fop != null)
					fop.close();
			}catch(IOException e)
			{
				e.printStackTrace();
			}
		}
	}

}
