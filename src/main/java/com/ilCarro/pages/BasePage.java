package com.ilCarro.pages;

import java.time.Duration;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

  public static WebDriver driver;

  public BasePage(WebDriver driver) {
    this.driver = driver;
    PageFactory.initElements(driver, this);
  }

  public void launchBrowser() {
    System.err.close();
    driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
  }

  public void openURL() {
    driver.get("https://ilcarro.web.app");
  }

  public void quit() {
    driver.quit();
  }

  public boolean isElementDisplayed(WebElement element) {
    return element.isDisplayed();
  }

  public void click(WebElement element) {
    element.click();
  }

  public void clickWithJSExecutor(WebElement element, int x, int y) {

    JavascriptExecutor js = (JavascriptExecutor) driver;
    js.executeScript("window.scrollBy(" + x + "," + y + ")");
    click(element);
  }

  public void type(WebElement element, String text) {
    if (text != null) {
      click(element);
      element.clear();
      element.sendKeys(text);
    }
  }

  public void clickWithRectangle(WebElement element, int i, int j) {
    Rectangle rectangle = element.getRect();
    int offSetX = rectangle.getWidth() / i;
    int offSetY = rectangle.getHeight() / j;
    Actions actions = new Actions(driver);
    actions.moveToElement(element).perform();
    actions.moveByOffset(-offSetX, -offSetY).click().perform();
  }

  public void pause(int millis) {
    try {
      Thread.sleep(millis);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
  }
}
