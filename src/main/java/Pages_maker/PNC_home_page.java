package Pages_maker;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class PNC_home_page  {
    public WebDriver driver;

    public PNC_home_page(WebDriver driver) {
        this.driver = driver;
    }


    public void Click_On_The_Change_Role_Icon() throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement role_change = driver.findElement(By.xpath("//input[@title='Role Change']"));
        wait.until(ExpectedConditions.visibilityOf(role_change));
        role_change.click();

    }


    public void Select_The_Transaction_Tab(String menu) throws InterruptedException {
        //implict wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement Option_Clicking = driver.findElement(By.xpath("//div[@id='menuControlItemCommon']//h3[text()='" + menu + "']"));
        wait.until(ExpectedConditions.visibilityOf(Option_Clicking));
        Thread.sleep(2000);
        Option_Clicking.click();

    }

    public void Select_Form(String menu, String form) {

        if (driver.findElement(By.xpath("(//img[@src='https://payncomp-cdn.neeyamo.com/Images/fffinalLoader75.gif'])[2]")).isDisplayed()) {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

            //loading wait
            WebElement heading_check = driver.findElement(By.xpath("(//img[@src='https://payncomp-cdn.neeyamo.com/Images/fffinalLoader75.gif'])[2]"));
            wait.until(ExpectedConditions.invisibilityOf(heading_check));

            WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(30));
            WebElement form_selection = driver.findElement(By.xpath("//div[@id='menuControlItemCommon']//h3[text()='" + menu + "']//parent::div//li//a[text()='" + form + "']"));
            wait1.until(ExpectedConditions.visibilityOf(form_selection));
            form_selection.click();

            Loader_Wait2();

            Assert.assertTrue(driver.findElement(By.xpath("//div//div[text()=' " + form + " ']")).isDisplayed());
        } else {

            WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(30));
            WebElement form_selection = driver.findElement(By.xpath("//div[@id='menuControlItemCommon']//h3[text()='" + menu + "']//parent::div//li//a[text()='" + form + "']"));
            wait1.until(ExpectedConditions.visibilityOf(form_selection));
            form_selection.click();

            Loader_Wait2();

            Assert.assertTrue(driver.findElement(By.xpath("//div//div[text()=' " + form + " ']")).isDisplayed());
        }
    }




    public void Scroll() throws InterruptedException {
        //with this we can scroll down
        Actions act = new Actions(driver);
        act.sendKeys(Keys.PAGE_UP).build().perform();
        Thread.sleep(2000);

    }

    public void Loader_Wait2() {

        /*
         * This method is used to make wait until the loader image gets disappear
         */

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        List<WebElement> heading_check = driver.findElements(By.xpath("//img[@src=\"https://payncomp-cdn.neeyamo.com/Images/fffinalLoader75.gif\"]"));
        wait.until(ExpectedConditions.invisibilityOfAllElements(heading_check));
    }
    /*
     *
     * changes
     *
     */

    public void Select_The_Particular_CCBU_And_Paygroup(String roles, String countries, String legal_entity, String Paygroups) throws InterruptedException {
        //implict wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));

        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(40));

        WebElement role_select_checker = driver.findElement(By.xpath("//li[text()=' " + roles + " ']"));
        wait1.until(ExpectedConditions.visibilityOf(role_select_checker));
        role_select_checker.click();

        By country_legal_entity_paygroup_name = By.xpath("//div[@class='tab-pane fade in']//parent::div[attribute::*[contains(local-name(),'_ngcontent')]][not(@hidden)]//td[text()=' " + countries + "']//parent::tr//td[text()=' " + legal_entity + " ']//parent::tr//a[text()=' " + Paygroups + "']");
        driver.findElement(country_legal_entity_paygroup_name).click();

        Loader_Wait2();

        Assert.assertTrue(driver
                .findElement(By.xpath("//span[text()=' " + countries + ":: " + legal_entity + "::" + Paygroups + "::']"))
                .isDisplayed());


        Assert.assertTrue(driver
                .findElement(By.xpath("//div[text()=' " + roles + " ']"))
                .isDisplayed(), " '+roles+' ");


    }

    public void Page_Up() throws InterruptedException {

        /*
         * This method is used to give page up
         */

        Thread.sleep(2000);
        Actions act = new Actions(driver);
        act.sendKeys(Keys.PAGE_UP).build().perform();

    }


}
