package DDTest.DDTest;



import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class FileReader {

	
	public static Iterator<String[]> details(String filename) {
		List<String[]> data= new ArrayList<String[]>();
		String testRow;
		try {
			BufferedReader br= new BufferedReader(new java.io.FileReader(filename));
			
			while((testRow= br.readLine())!=null) {
				
				String[] line= testRow.split(",");
				
				data.add(line);
				
			}
			
		}catch(FileNotFoundException e) {
			System.out.println("ERROR: file not found "+filename);
		}catch(IOException e) {
			System.out.println("ERROR: file not found "+filename);
		}
		return data.iterator();
		
	}
}
