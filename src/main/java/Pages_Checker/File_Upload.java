package Pages_Checker;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;
import java.util.List;
import java.util.Properties;

public class File_Upload {
    public WebDriver driver;
    public Properties prop;

    public File_Upload(WebDriver driver) {
        this.driver = driver;
    }

    public void Attach_file_upload(String filename) {

        /*
         * This method is used to upload the file in the file upload field
         */

        WebElement Attach_file_upload = driver.findElement(By.xpath("//input[@name='filepath']"));
        String file_path = System.getProperty("user.dir") + File.separator + "Checker_Files_Upload" + File.separator+ filename;

        File file = new File(file_path);
        Attach_file_upload.sendKeys(file.getAbsolutePath());


    }

    public void Template_Name(String template){
        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(30));

        WebElement Template_Name = driver.findElement(By.xpath("//select[@name='templatename']//option[text()='"+template+"']"));
        wait1.until(ExpectedConditions.visibilityOf(Template_Name));
        wait1.until(ExpectedConditions.elementToBeClickable(Template_Name));
        Template_Name.click();

    }

    public void Processing_period_New_Joiner( String month_year_selection){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        WebElement processing_Period_Selection = driver.findElement(By.xpath("//select[@name='processingmonthSelected']//option[text()=' " + month_year_selection + "']"));
        wait.until(ExpectedConditions.visibilityOf(processing_Period_Selection));
        processing_Period_Selection.click();

    }

    public void Upload_Click(){
        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(30));

        WebElement Template_Name = driver.findElement(By.xpath("//button[@type='button' and text()='Upload']"));
        wait1.until(ExpectedConditions.visibilityOf(Template_Name));
        wait1.until(ExpectedConditions.elementToBeClickable(Template_Name));
        Template_Name.click();
    }
    public void toaster_Invisible(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement toaster_invisible = driver.findElement(By.xpath("//div[@id='toast-container']//div//div"));
        wait.until(ExpectedConditions.invisibilityOf(toaster_invisible));
    }

    public void Loader_Wait2() {

        /*
         * This method is used to make wait until the loader image gets disappear
         */

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        List<WebElement> heading_check = driver.findElements(By.xpath("//img[@src=\"https://payncomp-cdn.neeyamo.com/Images/fffinalLoader75.gif\"]"));
        wait.until(ExpectedConditions.invisibilityOfAllElements(heading_check));
    }


}
