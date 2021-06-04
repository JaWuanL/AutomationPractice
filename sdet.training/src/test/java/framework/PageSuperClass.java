package framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class PageSuperClass {
	protected WebDriver driver;
	protected String baseUrl;
	private ControlExtensionFactory _controlExtensionFactory;

	protected PageSuperClass(WebDriver driver, String baseUrl) {
		this.driver = driver;
		this.baseUrl = baseUrl;

		_controlExtensionFactory = new ControlExtensionFactory(driver, driver);

		PageFactory.initElements(driver, this);
	}

	public void navigate(String relativeUrl) {
		driver.navigate().to(baseUrl + relativeUrl);
	}

	protected WebElement waitForElementVisible(By locator, int seconds) {
		WebDriverWait wait = new WebDriverWait(driver, seconds);
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

		return element;
	}

	public ControlExtensionFactory getControlExtensionFactory() {
		return _controlExtensionFactory;
	}
}
