package framework;

import java.util.HashMap;

public class Settings {

	public String browserType;
	public String baseUrl;
	public long implicitTimeout;
	public long scriptTimeout;
	
	public static Settings getSettings() {
		String file = "config.properties";
		Settings settings = new Settings();
		HashMap<String,String> configFileProperties = null;
		
		try {
			configFileProperties = new ConfigurationProvider().getPropertiesFromResourceFile(file);
		} catch (Exception e) {
			throw new RuntimeException(new Exception("There was a problem reading reading the file " + file + ": " + e.getMessage()));
		}

		settings.browserType = configFileProperties.get("BrowserType");
		settings.baseUrl = configFileProperties.get("Url");
		settings.implicitTimeout = Long.parseLong(configFileProperties.get("ImplicitTimeout"));
		settings.scriptTimeout = Long.parseLong(configFileProperties.get("ScriptTimeout"));
		
		return settings;
	}
}