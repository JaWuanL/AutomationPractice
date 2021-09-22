package controlExtensions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ReactTableCell {
	
	private WebElement _mappedElement;
	public ReactTableCell(WebElement mappedElement, WebDriver driver) {
		_mappedElement = mappedElement;
	}

	public String getValue() {
		return _mappedElement.getText();
	}
}
