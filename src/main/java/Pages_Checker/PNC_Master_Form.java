package Pages_Checker;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import javax.swing.*;
import java.time.Duration;
import java.util.List;

public class PNC_Master_Form {

    public WebDriver driver;

    public PNC_Master_Form(WebDriver driver) {
        this.driver = driver;
    }

    public void Loader_Wait() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        List<WebElement> loader_waiting = driver.findElements(By.xpath("//img[@src='https://payncomp-cdn.neeyamo.com/Images/fffinalLoader75.gif']"));
        wait.until(ExpectedConditions.invisibilityOfAllElements(loader_waiting));

    }

    public void Data_Check(String data) throws InterruptedException {

        //implict wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(30));

        WebElement all_button = driver.findElement(By.xpath("//button[text()='All']"));
        wait1.until(ExpectedConditions.visibilityOf(all_button));
        all_button.click();

        Loader_Wait();

        WebElement data_passing = driver.findElement(By.xpath("//input[@name='internalRefNo']"));
        wait1.until(ExpectedConditions.visibilityOf(data_passing));
        data_passing.click();
        data_passing.clear();
        data_passing.sendKeys(data);

        WebElement search_button = driver.findElement(By.xpath("//button[@title='Search']"));
        wait1.until(ExpectedConditions.visibilityOf(search_button));
        search_button.click();

        WebElement search = driver.findElement(By.xpath("//input[@id='EmployeeID']"));
        wait1.until(ExpectedConditions.visibilityOf(search));
        search.click();
        search.clear();
        search.sendKeys(data);

        Actions act = new Actions(driver);
        //search.sendKeys(Keys.BACK_SPACE);


        Assert.assertTrue(driver
                .findElement(By.xpath("//span[text()='" + data + "']"))
                .isDisplayed());


        By records_check = By.xpath("//div//h3[@class='panel-title']//div//span");

        String records = driver.findElement(records_check).getText();

        if (records.contains("Displaying 1 ")) {
            Assert.assertTrue(true);
        } else {
            System.out.println("test failed because record not showing in master form");
            Assert.assertFalse(true);
        }
    }

}
