package controlExtensions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ReactTableRow {

	private WebElement _mappedElement;
	private WebDriver _driver;

	public ReactTableRow(WebElement mappedElement, WebDriver driver) {
		_mappedElement = mappedElement;
		_driver = driver;
	}

	public ReactTableCell cell(int cellIndex) {
		List<WebElement> cellElements = _mappedElement.findElements(By.cssSelector("div[role='gridcell']"));
		WebElement selectedCellElement = cellElements.get(cellIndex);
		
		ReactTableCell cell = new ReactTableCell(selectedCellElement, _driver);
		
		return cell;
	}
}
