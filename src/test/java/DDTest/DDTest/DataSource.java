package DDTest.DDTest;

import java.io.IOException;
import java.util.Iterator;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataSource {
	@Test (dataProvider="getdata")
	public void account(String name,String phone,String email,String county,String day,String month,String year,String password,String confirm) throws IOException, InterruptedException {
		String [] data= {name,phone,email,county,day,month,year,password,confirm};
		Registration.data(data);
	}
	@DataProvider
	public Iterator<String[]> getdata() throws IOException{
		String location="/home/rachael/eclipse-workspace/DDTest/account.csv";
		 return FileReader.details(location);	
	}

}
