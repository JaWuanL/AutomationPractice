package controlExtensions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RadioButtonGroup extends ControlExtension {

	public RadioButtonGroup(WebElement mappedElement, WebDriver driver) {
		super(mappedElement, driver);
	}

	public void select(String value) {
	
		WebElement desiredRadioButtonLabel = mappedElement.findElement(By.xpath(".//input[@value='" + value + "']/../label"));
		
		desiredRadioButtonLabel.click();			
		
		String selectedRadioButtonLabel = getValue();
		
		if(!value.equals(selectedRadioButtonLabel)) {
			throw new RuntimeException(new Exception("Could not set the Radio Button Group value to '" + value + "'"));
		}
	}	

	public String getValue() {
		
		List<WebElement> radioButtons = mappedElement.findElements(By.cssSelector("div[id=genterWrapper] input"));

		String selectedLabel= null;
		
		for(WebElement radioButton:radioButtons) {
			if(!radioButton.isSelected()) {
				continue;
			}
			
			selectedLabel = radioButton.getAttribute("value");	
		}
	
		return selectedLabel;
	}	
}
