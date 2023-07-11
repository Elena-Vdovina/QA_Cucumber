package com.ilCarro.pages;

import java.util.List;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class LetCarWorkPage extends BasePage {

  public LetCarWorkPage(WebDriver driver) {
    super(driver);
  }

  @FindBy(id = "fuel")
  WebElement fuelField;

  public LetCarWorkPage select(String text) {
    Select select = new Select(fuelField);
    select.selectByVisibleText(text);
    List<WebElement> options = select.getOptions();
    System.out.println(select.getFirstSelectedOption().getText() + " is first");
    for (int i = 0; i < options.size(); i++) {
      System.out.println(options.get(i).getText());
    }
    return this;
  }

  @FindBy(id = "pickUpPlace")
  WebElement placeField;
  @FindBy(id = "make")
  WebElement makeField;
  @FindBy(id = "model")
  WebElement modelField;
  @FindBy(id = "year")
  WebElement yearField;
  @FindBy(id = "seats")
  WebElement seatsField;
  @FindBy(id = "class")
  WebElement classField;
  @FindBy(id = "serialNumber")
  WebElement serialField;
  @FindBy(id = "price")
  WebElement priceField;

  public LetCarWorkPage enterDataCar(String location, String manufacture, String model, int year,
      String fuel, int seats, String carClass, String regNumber, int price) {
    type(placeField, location);
    pause(1000);
    placeField.sendKeys(Keys.DOWN);
    placeField.sendKeys(Keys.ENTER);
    type(makeField, manufacture);
    type(modelField, model);
    type(yearField, String.valueOf(year));
    select(fuel);
    type(seatsField, String.valueOf(seats));
    type(classField, carClass);
    type(serialField, regNumber);
    type(priceField, String.valueOf(price));
    return this;
  }

  @FindBy(css = "[type='submit']")
  WebElement submitButton;

  public LetCarWorkPage clickOnSubmitButton() {
    clickWithJSExecutor(submitButton, 0, 600);
    return this;
  }

  @FindBy(xpath = "//h1[.='Car added']")
  WebElement carAdding;

  public LetCarWorkPage isPositiveMessageDisplayed() {
    assert isElementDisplayed(carAdding);
    return this;
  }
}
