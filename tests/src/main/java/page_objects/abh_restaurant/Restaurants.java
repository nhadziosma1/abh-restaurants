package page_objects.abh_restaurant;

import org.openqa.selenium.WebDriver;
import page_objects.PageBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Restaurants extends PageBase {
    final static private String PAGE_URL_REGEX = "\\/restaurants\\d*";
    final static private String RESERVE_BUTTON_CSS = "div.restaurant-tile";


    public Restaurants(WebDriver driver) {
        super(driver, PAGE_URL_REGEX);
        initElements();
    }

    @FindBy(css = RESERVE_BUTTON_CSS)
    private WebElement reserveRestaurant;

    public WebElement getReserveRestaurant(){
        return reserveRestaurant;
    }

    public Restaurant clickOnFirst(){
        getReserveRestaurant().click();
        return new Restaurant(getDriver());
    }


}
