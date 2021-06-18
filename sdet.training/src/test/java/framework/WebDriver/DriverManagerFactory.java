package framework.WebDriver;

public class DriverManagerFactory {
	public static DriverManager getManager(String driverType) {
		
		if(driverType.equals(DriverTypes.chrome)) {
			return new ChromeDriverManager();
		}
		if(driverType.equals(DriverTypes.edge)) {
			return new EdgeDriverManager();
		}
		
		throw new RuntimeException(new Exception(driverType + " is not a supported driverType."));
	}
}
