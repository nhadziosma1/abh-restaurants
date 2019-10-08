package page_objects.abh_restaurant;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import page_objects.PageBase;

public class ReservationDetails extends PageBase {

    final static private String COMPLETE_RESERVATION = "h1.confirm-reservation-title";
    final static private String PAGE_URL_REGEX = "\\/reservation-details\\d*";

    public ReservationDetails(WebDriver driver) {
        super(driver, PAGE_URL_REGEX);
        initElements();
    }

    @FindBy(css = COMPLETE_RESERVATION)
    private WebElement completeReservation;

    public WebElement getCompleteReservation(){
        return completeReservation;
    }

    public Boolean checkTitle(String titleText){
        return titleText.equals(getCompleteReservation().getText());
    }
}
