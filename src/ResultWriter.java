import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class ResultWriter
{
	private FileOutputStream fop = null;
	private File file;
	
	private String content;
	
	public void write(String name) throws IllegalArgumentException
	{
		if(name == null)
		{
			throw new IllegalArgumentException("The name to write for file cannot be null!");
		}
	
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
