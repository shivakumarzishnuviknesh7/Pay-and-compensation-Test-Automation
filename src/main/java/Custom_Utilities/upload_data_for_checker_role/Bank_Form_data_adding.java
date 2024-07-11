package Custom_Utilities.upload_data_for_checker_role;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Bank_Form_data_adding {

    public WebDriver driver;

    public Bank_Form_data_adding(WebDriver driver) {
        this.driver = driver;
    }

    public void month_selecting() {
        //driver.switchTo().alert().accept();
    }

    public void Loader_Wait(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement heading_check = driver.findElement(By.xpath("(//img[@src='https://payncomp-cdn.neeyamo.com/Images/fffinalLoader75.gif'])[2]"));
        wait.until(ExpectedConditions.invisibilityOf(heading_check));

    }

    public void Loader_Wait2() {

        /*
         * This method is used to make wait until the loader image gets disappear
         */

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        List<WebElement> heading_check = driver.findElements(By.xpath("//img[@src=\"https://payncomp-cdn.neeyamo.com/Images/fffinalLoader75.gif\"]"));
        wait.until(ExpectedConditions.invisibilityOfAllElements(heading_check));
    }

    public void Select_The_Processing_Month(String month_year_selection) throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        //implict wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        Loader_Wait();
        //Explicit wait
        WebElement processing_Period_Selection = driver.findElement(By.xpath("//select[@name='processingmonthSelected']//option[text()=' " + month_year_selection+"']"));
        wait.until(ExpectedConditions.visibilityOf(processing_Period_Selection));
        processing_Period_Selection.click();

        Loader_Wait();

    }

    public void value_adding(String data,String mail){

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        WebElement ID = driver.findElement(By.xpath("//input[@id=\"primaryfield\"]"));
        wait.until(ExpectedConditions.visibilityOf(ID));
        ID.sendKeys(data);

    }

    public void clicking_save(){

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        WebElement save = driver.findElement(By.xpath("//button[@type=\"button\" and text()='Save']"));
        wait.until(ExpectedConditions.visibilityOf(save));
        save.click();

    }


}
