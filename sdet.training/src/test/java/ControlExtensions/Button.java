package ControlExtensions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Button extends ControlExtension implements IButton {

	public Button(WebElement mappedElement, WebDriver driver) {
		super(mappedElement, driver);
	}

	public void click() {
		mappedElement.click();		
	}

	public void doubleClick() {
		Actions actions = new Actions(driver);
		actions.doubleClick(mappedElement).perform();		
	}

	public void rightClick() {
		Actions actions = new Actions(driver);
		actions.contextClick(mappedElement).perform();			
	}
}
