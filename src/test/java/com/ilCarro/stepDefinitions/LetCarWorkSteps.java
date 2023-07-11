package com.ilCarro.stepDefinitions;

import static com.ilCarro.pages.BasePage.driver;

import com.ilCarro.pages.HomePage;
import com.ilCarro.pages.LetCarWorkPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class LetCarWorkSteps {

  @And("User clicks on Let the car work link")
  public void click_let_car_work_link() {
    new HomePage(driver).clickOnLetCarWorkLink();
  }

  @And("User enters valid data car")
  public void enter_valid_data_car() {
    new LetCarWorkPage(driver).enterDataCar("Tel Aviv", "BMW", "Cabrio",
        2023, "Petrol", 4, "8",
        "1256", 200);
  }

  @And("User clicks on Submit button")
  public void click_on_Submit_button() {
    new LetCarWorkPage(driver).clickOnSubmitButton();
  }

  @Then("User verifies positive message")
  public void verify_positive_message() {
    new LetCarWorkPage(driver).isPositiveMessageDisplayed();
  }

}
