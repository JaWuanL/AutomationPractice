package controlExtensions;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DatePicker extends ControlExtension implements IDatePicker {

	public DatePicker(WebElement mappedElement, WebDriver driver) {
		super(mappedElement, driver);
	}

	public void setValue(String value) {
		JavascriptExecutor javascriptExecutor = (JavascriptExecutor)driver;		

		javascriptExecutor.executeScript("(arguments[0]).value = '" +value+ "'", mappedElement);       
	}

	public String getValue() {
		return mappedElement.getAttribute("value");
	}
}
