package controlExtensions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DropdownList extends ControlExtension {

	protected DropdownList(WebElement mappedElement, WebDriver driver) {
		super(mappedElement, driver);
	}

	public void select(String value) {
		getMappedElementAsSelect().selectByVisibleText(value);
		
		String selectedValue = getSelectedValue();
		if(selectedValue != value) {
			throw new RuntimeException(new Exception("The value '"+value+"' was not selected, '"+selectedValue+"' was selected instead."));
		}
	}	
	
	public String getSelectedValue() {
		WebElement firstSelectedOption = getMappedElementAsSelect().getFirstSelectedOption();
		
		if(firstSelectedOption == null) {
			return null;
		}
		
		return firstSelectedOption.getText();
	}
	
	private Select getMappedElementAsSelect() {
		return new Select(mappedElement);
	}
}
