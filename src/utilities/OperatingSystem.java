package utilities;

public class OperatingSystem {
	public String getOS() {
		String os = System.getProperty("os.name");
		String osName = os.toLowerCase();
		
		if (osName.contains("mac")) {
			os = "macos";
		}else if(osName.contains("windows")) {
			os = "windows";
		}else {
			os = "linux";
		}
		return os;
		
	}
}