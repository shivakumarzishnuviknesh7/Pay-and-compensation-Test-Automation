package Custom_Utilities.Pages_Client_Reviewer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class PNC_Home_Page {
    public WebDriver driver;

    public PNC_Home_Page(WebDriver driver) {
        this.driver = driver;
    }

    public void Select_The_Particular_CCBU_And_Paygroup(String roles, String countries, String legal_entity, String Paygroups) throws InterruptedException {

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));
        By role_select_checker = By.xpath("//li[text()=' " + roles + " ']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(role_select_checker));
        driver.findElement(role_select_checker).click();

        By country_legal_entity_paygroup_name = By.xpath("//div[@class='tab-pane fade in']//parent::div[attribute::*[contains(local-name(),'_ngcontent')]][not(@hidden)]//td[text()=' " + countries + "']//parent::tr//td[text()=' " + legal_entity + " ']//parent::tr//a[text()=' " + Paygroups + "']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(country_legal_entity_paygroup_name));
        driver.findElement(country_legal_entity_paygroup_name).click();

       // wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()=' \" + countries + \":: \" + legal_entity + \"::\" + Paygroups + \"::']")));
        Assert.assertTrue(driver
                .findElement(By.xpath("//span[text()=' " + countries + ":: " + legal_entity + "::" + Paygroups + "::']"))
                .isDisplayed(), "Role change successfully");


        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()=' \"+roles+\" ']")));
        Assert.assertTrue(driver
                .findElement(By.xpath("//div[text()=' "+roles+" ']"))
                .isDisplayed(), " '+roles+' ");



    }

    public void Click_On_The_Change_Role_Icon() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement role_change = driver.findElement(By.xpath("//input[@title='Role Change']"));
        wait.until(ExpectedConditions.visibilityOf(role_change));
        role_change.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h5[text()='Change Role']")));
        Assert.assertTrue(driver.findElement(By.xpath("//h5[text()='Change Role']"))
            .isDisplayed(),"Change Role");

    }






}
