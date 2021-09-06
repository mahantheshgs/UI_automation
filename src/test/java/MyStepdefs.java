import com.blaze.sclc.common.WebDriverUtilities;
import com.blaze.sclc.pages.*;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MyStepdefs {

    HomePage homepage = new HomePage(WebDriverUtilities.driver());
    WelcomePage welcome = new WelcomePage(WebDriverUtilities.driver());
    LoginPage loginPage = new LoginPage(WebDriverUtilities.driver());
    Registration registration = new Registration((WebDriverUtilities.driver()));
    Dashboard dashboard = new Dashboard(WebDriverUtilities.driver());
    FlightsPage flightsPage = new FlightsPage(WebDriverUtilities.driver());
    BookingDetailsPage bookingDetailsPage = new BookingDetailsPage(WebDriverUtilities.driver());
    By unknownPage = By.xpath("//div[contains(text(),'Page Expired')]");


    @Given("launch the Blaze UI Portal")
    public void launchTheBlazeUIPortal() {
        homepage.LaunchSite();

    }

    @Then("go to {string} Page")
    public void goToPage(String linkName) throws Throwable {
        switch (linkName.toUpperCase()) {

            case "HOME":
                welcome.clickHome();
                Thread.sleep(500);
                break;
            case "BLAZEDEMO":
                loginPage.clicklinkBack2WelcomePage();
                break;
            case "REGISTER":
                loginPage.clickRegister();
                Thread.sleep(500);
                break;
            default:
                System.out.println("element not clickable");
        }

    }

    @When("user clicks on {string} link")
    public void userClicksOnLink(String arg0) {
    }

    @Then("Registration Page should be displayed")
    public void registrationPageShouldBeDisplayed() {
    }

    @When("user enters the below mandatory fields")
    public void userEntersTheBelowMandatoryFields(DataTable formData) {
        List<List<String>> formfieldValues = formData.raw();
        registration.fillFormData().get(0).sendKeys(formfieldValues.get(0).get(1));
        registration.fillFormData().get(0).sendKeys(formfieldValues.get(0).get(2));
        registration.fillFormData().get(0).sendKeys(formfieldValues.get(0).get(3));
        registration.fillFormData().get(0).sendKeys(formfieldValues.get(0).get(4));
    }

    @And("clicks on {string} button")
    public WebElement clicksOnButton(String button) throws Throwable {
        switch (button.toUpperCase()) {
            case "REGISTRATION":
                registration.clickRegisterButton();
                Thread.sleep(500);
                registration.getUnknownPage();
                break;
            case "FIND FLIGHTS":
                welcome.clickFindFlights();
                Thread.sleep(500);
                break;
            case "CHOOSE THIS FLIGHT":
                flightsPage.chooseFlight();
                Thread.sleep(500);
                break;
            case "PURCHASE FLIGHT":
                bookingDetailsPage.clickPurchage();
                Thread.sleep(500);
                break;

            default:
                System.out.println("Page not found or unknown page");

        }
        return null;
    }

    @Then("verify the successful Registration")
    public void verifyTheSuccessfulRegistration() {
        try {
            registration.clickRegisterButton();
            Thread.sleep(500);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        assertEquals("You are logged in!", dashboard.getConfirmationMessage());

    }


    @Then("will navigate to Flights page")
    public void willNavigateToFlightsPage() {

    }

    @And("will navigate to Booking Details page")
    public void willNavigateToReservationPage() {
        assertTrue("Navigated to Flight booking page succesfully",
                bookingDetailsPage.getBookingDetailsPage().contains("reserved"));

    }

    @Then("verify the booking confirmation")
    public void verifyTheBookingConfirmation() {
        String confMessage=bookingDetailsPage.getBookingConfirmation();
        assertEquals("Thank you for your purchase today!", confMessage);

    }

    @When("user selects the {string} and {string} cities")
    public void userSelectsfromAndToCities(String from, String to) throws Throwable {

        Select select = new Select(welcome.fromCityDropDwon());
        try {
            select.selectByVisibleText(from);


            Select select1 = new Select(welcome.toCityDropDwon());
            try {
                select.selectByVisibleText(to);

            } finally {
                System.out.println("");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}