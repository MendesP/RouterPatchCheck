import java.util.ArrayList;

public class routerPatchCheck {

	public static void main(String[] args) {
		
		String csvFilePath = "";
	    if(args.length > 0)
	    	csvFilePath = args[0]; //Get the file path from command line
		
		
		CSVReader csvReader = new CSVReader(csvFilePath);
		RouterList routerList = csvReader.getRouterList();
		
		for (Router aRouter : routerList.getListOfRouters()){
			if(!aRouter.isPatched() && aRouter.osVersionIsValid() && routerList.hostNameUnique(aRouter) && routerList.ipUnique(aRouter)){
				System.out.printf("%s (%s), OS version %s ", aRouter.getHostName(), aRouter.getIP(), aRouter.getOsVersion());
				if(!aRouter.getNotes().equals("")){
					System.out.printf(" [%s]", aRouter.getNotes());
				}
				System.out.println();
			}
		}
	}
}