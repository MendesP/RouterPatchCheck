import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CSVReader {
	private String filePath;
	private RouterList routerList;
	
	// set the filepath in the constructor
	public CSVReader(String filePath){
		this.filePath = filePath;
		routerList = RouterList.getInstance();
	}
	
	public RouterList getRouterList(){
		
		BufferedReader br = null;
		
		try{
			br = new BufferedReader(new FileReader(filePath));
			String line = "";
			String headerLine = br.readLine(); //skip first line (header)
			
			//Read file line by line till EOF and skip empty lines
			while ((line = br.readLine()) != null && line != ""){
				String[] routerString = line.split(",");
				Router aRouter = new Router();
				
				// Set router properties
				aRouter.setHostName(routerString[0]);
				aRouter.setIP(routerString[1]);
				aRouter.setPatched(routerString[2]);
				aRouter.setOsVersion(routerString[3]);
				//Check if there are notes for the router
				if(routerString.length == 5)
					aRouter.setNotes(routerString[4]);
				else
					aRouter.setNotes("");
				routerList.getListOfRouters().add(aRouter);
			}
			br.close();
		}
		catch (FileNotFoundException e){
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return routerList;
	}
}