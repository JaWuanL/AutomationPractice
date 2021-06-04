package ControlExtensions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Textbox extends ControlExtension {

	public Textbox(WebElement mappedElement, WebDriver driver) {
		super(mappedElement, driver);
	}

	public void setValue(String value) {
		mappedElement.sendKeys(value);

		String text = getValue();
		
		if(!text.equals(value)) {
			throw new RuntimeException(new Exception("The textbox could not be set to the value '" + value + "'"));
		}
	}

	public String getValue() {
		String text = mappedElement.getAttribute("value");
		
		return text;
	}	
}
