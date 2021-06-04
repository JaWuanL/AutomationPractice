package ControlExtensions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ReactTable {

	private WebElement _mappedElement;
	private WebDriver _driver;
	private By rowSelector = By.cssSelector(".rt-tbody [role='row']");

	public ReactTable(WebElement mappedElement, WebDriver driver) {
		_mappedElement = mappedElement;
		_driver = driver;
	}

	public ReactTableRow row(int ordinalRow) {
		int rowIndex = ordinalRow - 1;
		List<WebElement> rowElements = getRowElements();	
		WebElement selectedRowElement = rowElements.get(rowIndex);

		ReactTableRow row = new ReactTableRow(selectedRowElement, _driver);

		return row;
	}

	public int findRowByCellValue(String valueToFind, int cellIndex) {

		for(int ordinalRow = 1;ordinalRow <= getRowCount(); ordinalRow++) {
			String cellValue = row(ordinalRow).cell(cellIndex).getValue();

			if(cellValue.equals(valueToFind)) {
				return ordinalRow;
			}
		}

		return 0;
	}

	public int getRowCount() {
		return getRowElements().size();
	}

	private List<WebElement> getRowElements() {
		return _mappedElement.findElements(rowSelector);		
	}	


}
