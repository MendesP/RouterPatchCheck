//Class implements the Singleton Design Pattern. Only one instance of the class can be created.

import java.util.ArrayList;

public class RouterList {
	private static RouterList instance;
	private ArrayList<Router> listOfRouters;
	
	public static RouterList getInstance(){
		if(instance == null){
			instance = new RouterList();
			instance.listOfRouters = new ArrayList<>();
		}
		return instance;
	}
	
	public ArrayList<Router> getListOfRouters(){
		return listOfRouters;
	}
	public void setListOfRouters(ArrayList<Router> listOfRouters){
		this.listOfRouters = listOfRouters;
	}
	
	
	//Check if the router IP is unique in the list of routers
			public boolean hostNameUnique(Router aRouter){
				int count=0;
				for (Router router : listOfRouters){
					if(router.getHostName().toLowerCase().equals(aRouter.getHostName().toLowerCase())){
						count++;
					}
				}
				if(count == 1)
					return true;
				else
					return false;
			}
	
	//Check if the router IP is unique in the list of routers
	public boolean ipUnique(Router aRouter){
		int count=0;
		for (Router router : listOfRouters){
			if(router.getIP().equals(aRouter.getIP())){
				count++;
			}
		}
		if(count == 1)
			return true;
		else
			return false;
	}
}