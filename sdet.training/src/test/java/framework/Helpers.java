package framework;

import java.net.URL;
import java.util.Set;

import org.openqa.selenium.WebDriver;

public class Helpers {
	public static String getSegment(String expression, String seperator, int indexToGet) {
		if(expression == null || expression == "") {
			return null;
		}

		String[] segments = expression.split(seperator);
		int segmentLength = segments.length;

		if(segmentLength < indexToGet - 1) {
			throw new RuntimeException(new Exception("Cannot get index for segment " + indexToGet + " because segment count is " + segmentLength));
		}

		return segments[indexToGet];
	}

	public static <T> T getLastElement(final Iterable<T> elements) {
		T lastElement = null;

		for (T element : elements) {
			lastElement = element;
		}

		return lastElement;
	}

	public static void switchToNewWindow(WebDriver driver) {
		Set<String> windowHandles = driver.getWindowHandles();

		String newWindowName = Helpers.getLastElement(windowHandles);
		
		driver.switchTo().window(newWindowName);		
	}	
	
	public static String getFileFromResources(String fileName) {
		URL fileUrl = ClassLoader.getSystemResource(fileName);
		
		if(fileUrl == null) {
			throw new RuntimeException(fileName + " is invalid.");
		}
		
		String filePath = fileUrl.getFile();
		
		if(filePath == null) {
			throw new RuntimeException("Could not get file path for " + fileUrl);
		}
		
		return filePath;
	}
}
