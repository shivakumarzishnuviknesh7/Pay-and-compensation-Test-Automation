package Custom_Utilities.upload_data_for_checker_role;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class New_joiner_form {

    public WebDriver driver;

    public New_joiner_form(WebDriver driver) {
        this.driver = driver;
    }

    public void clicking_the_add_new_item(){

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));

        WebElement add_new_item_button = driver.findElement(By.xpath("//a[text()='Add New Item' and @type=\"button\"]"));
        wait.until(ExpectedConditions.visibilityOf(add_new_item_button));
        add_new_item_button.click();
    }

}
