package page_objects.abh_restaurant;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import page_objects.PageBase;

import java.util.List;

public class Restaurant extends PageBase {
    final static private String PAGE_URL_REGEX = "\\/restaurant\\d*";
    final static private String RESERVATION_FORM_CSS = "form.reservation-form";
    final static private String CONFIRM_RESERVATION_CSS = "/html/body/div[2]/div[1]/div[2]/div/div[2]/div[2]/div[1]/p[2]/span";
    final static private String FIND_BUTTON_XPATH = "/html/body/div[2]/div[1]/div[2]/div/div[2]/div[2]/div[1]/form/button";
    /*final static private String PERSON_SELECT_CSS = "select#ember826.ember-view";
    final static private String DATE_INPUT_CSS = "input#ember827.ember-text-field.ember-view";
    final static private String TIME_INPUT_CSS = "input#ember828.ember-text-field.ember-view";
    final static private String FIND_BUTTON_CSS = "button.reservation-form-button";*/

    public Restaurant(WebDriver driver) {
        super(driver, PAGE_URL_REGEX);
        initElements();
    }

    @FindBy(css = RESERVATION_FORM_CSS)
    private WebElement reservationForm;

    public WebElement getReservationForm() {
        return reservationForm;
    }

    @FindBy(xpath = CONFIRM_RESERVATION_CSS)
    private WebElement confirmReservation;

    public WebElement getConfirmReservation() {
        return confirmReservation;
    }


    /*@FindBy(css = PERSON_SELECT_CSS)
    private WebElement selectPerson;
    @FindBy(css = DATE_INPUT_CSS)
    private WebElement inputDate;
    @FindBy(css = TIME_INPUT_CSS)
    private WebElement inputTime;
    @FindBy(css = FIND_BUTTON_CSS)
    private WebElement buttonFind;*/

    /*public WebElement getPersonCount(){
        return selectPerson;
    }
    public WebElement getInputDate(){
        return inputDate;
    }
    public WebElement getInputTime(){
        return inputTime;
    }
    public WebElement getButtonFind(){
        return buttonFind;
    }*/

    public void waitForElement(){
        WebDriverWait wait = new WebDriverWait(getDriver(), 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(CONFIRM_RESERVATION_CSS)));
    }
    public void waitForElementInvisibility(){
        WebDriverWait wait = new WebDriverWait(getDriver(), 30);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(CONFIRM_RESERVATION_CSS)));
    }
    /*public void waitForElement2(){
        WebDriverWait wait = new WebDriverWait(getDriver(), 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(FIND_BUTTON_XPATH)));
    }*/

    public ReservationDetails reserveRestaurant(){
        Select dropdown = new Select(getReservationForm().findElements(By.xpath("*")).get(0));
        dropdown.selectByIndex(1);
        getReservationForm().findElements(By.xpath("*")).get(1).sendKeys("2019-10-24");
        getReservationForm().findElements(By.xpath("*")).get(2).sendKeys("10:00");
        //waitForElement1();
        getReservationForm().findElements(By.xpath("*")).get(3).click();
        waitForElement();
        getConfirmReservation().click();
        getConfirmReservation().click();
        waitForElementInvisibility();
        /*getReservationForm().get(1).sendKeys("10/08/2019");
        getReservationForm().get(2).sendKeys("08:00 PM");
        getReservationForm().get(3).click();*/
        //return new Restaurant(getDriver());
        return new ReservationDetails(getDriver());
    }

}