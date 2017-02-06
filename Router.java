
public class Router {
	// private properties declaration;
	private String hostName;
	private String ip;
	private boolean patched;
	private String osVersion;
	private String notes; 
	
	// get and set methods
	public String getHostName(){ return hostName; }
	public void setHostName(String hostName){ this.hostName = hostName;}
	
	public String getIP(){return ip;}
	public void setIP(String ip){this.ip = ip;}
	
	public boolean isPatched(){return patched;}
	public void setPatched(String patched){
		if(patched.toLowerCase().equals("yes") || patched.toLowerCase().equals("y")){
			this.patched = true;
		}
		else if(patched.toLowerCase().equals("no") || patched.toLowerCase().equals("n")){
			this.patched = false;
		}
	}
	
	public String getOsVersion(){ return osVersion; }
	public void setOsVersion(String osVersion){ this.osVersion = osVersion;}
	
	public String getNotes(){ return notes; }
	public void setNotes(String notes){ this.notes = notes;}
	
	
	//Checks if the OS version is 12 or above
	public boolean osVersionIsValid() {
		if(osVersion != null){
			String[] osVersionSplit = osVersion.split("\\.");
			if(osVersionSplit != null && Integer.parseInt(osVersionSplit[0]) >= 12)
				return true;
			else
				return false;
		}
		return false;// If there is no data regarding the OS version, it is assumed that OS version is not valid (router must not be patched)
	}
}
