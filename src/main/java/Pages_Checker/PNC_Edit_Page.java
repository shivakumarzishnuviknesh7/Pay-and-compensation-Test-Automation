package Pages_Checker;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class PNC_Edit_Page {
    public WebDriver driver;

    public PNC_Edit_Page(WebDriver driver) {
        this.driver = driver;
    }

    public void Loader_Wait() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(500));
        List<WebElement> heading_check = driver.findElements(By.xpath("//img[@src=\"https://payncomp-cdn.neeyamo.com/Images/fffinalLoader75.gif\"]"));
        wait.until(ExpectedConditions.invisibilityOfAllElements(heading_check));

    }


    public void Bank_Editing_Name(String name, String Expected_message) throws InterruptedException {
        Loader_Wait();
        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(60));

        WebElement name_Field_To_Pass_Value = driver.findElement(By.xpath("//input[@id='field1']"));
        wait1.until(ExpectedConditions.visibilityOf(name_Field_To_Pass_Value));
        name_Field_To_Pass_Value.clear();

        String a = driver.findElement(By.xpath("//span[text()='Bank Form']")).getText();
        String b = "Bank Form";
        Assert.assertEquals(a, b);


        name_Field_To_Pass_Value.sendKeys(name);

        WebElement clicking_Save_After_Editing = driver.findElement(By.xpath("//button[text()='Save & Approve']"));
        wait1.until(ExpectedConditions.visibilityOf(clicking_Save_After_Editing));
        clicking_Save_After_Editing.click();


        WebElement getClicking_Save_After_Editing_yes = driver.findElement(By.xpath("//button[text()=' YES ']"));
        wait1.until(ExpectedConditions.visibilityOf(getClicking_Save_After_Editing_yes));
        getClicking_Save_After_Editing_yes.click();

        //assert for toaster
        WebElement toaster_message = driver.findElement(By.xpath("//div[@id='toast-container']//div//div"));
        wait1.until(ExpectedConditions.visibilityOf(toaster_message));
        String aa = toaster_message.getText();
        Assert.assertEquals(aa, Expected_message);

    }

    public void Time_Attendance_Edit(String data, String Expected_message) throws InterruptedException {

        //implict wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));

        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(50));

        if (driver.findElement(By.xpath("//input[@id='field1']")).isDisplayed()) {



            By name_Field_To_Pass_Value = By.xpath("//input[@id='field1']");
            driver.findElement(name_Field_To_Pass_Value).clear();

            String a = driver.findElement(By.xpath("//span[text()='Details']")).getText();
            String b = "Details";
            Assert.assertEquals(a, b);

            WebElement Leave_Enhancement_days = driver.findElement(By.xpath("//input[@id='field1']"));
            wait1.until(ExpectedConditions.visibilityOf(Leave_Enhancement_days));
            Leave_Enhancement_days.sendKeys(data);

            WebElement clicking_Save_After_Editing = driver.findElement(By.xpath("//button[text()='Save & Approve']"));
            wait1.until(ExpectedConditions.visibilityOf(clicking_Save_After_Editing));
            clicking_Save_After_Editing.click();

            WebElement getClicking_Save_After_Editing_yes = driver.findElement(By.xpath("//button[text()=' YES ']"));
            wait1.until(ExpectedConditions.visibilityOf(getClicking_Save_After_Editing_yes));
            getClicking_Save_After_Editing_yes.click();

        } else {
            driver.switchTo().alert().accept();
            System.out.println("give different month");
            Assert.assertTrue(false);
        }

        //assert for toaster
        WebElement toaster_message = driver.findElement(By.xpath("//div[@id='toast-container']//div//div"));
        wait1.until(ExpectedConditions.visibilityOf(toaster_message));
        String aa = toaster_message.getText();
        Assert.assertEquals(aa, Expected_message);

    }

    /*
     * changes
     */

    public void New_Joiner_Editing_Name(String Name, String Email,String Expected_message) throws InterruptedException {

        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(30));

        WebElement name_Field_To_Pass_Value = driver.findElement(By.xpath("//input[@id='field1']"));
        wait1.until(ExpectedConditions.visibilityOf(name_Field_To_Pass_Value));
        name_Field_To_Pass_Value.clear();

        String a = driver.findElement(By.xpath("//span[text()='Details']")).getText();
        String b = "Details";
        Assert.assertEquals(a,b);

        name_Field_To_Pass_Value.sendKeys(Name);

        //e-mail edit
        WebElement email_change = driver.findElement(By.xpath("//input[@id='field2']"));
        wait1.until(ExpectedConditions.visibilityOf(email_change));
        email_change.clear();
        email_change.sendKeys(Email);

        WebElement Employment_status_type = driver.findElement(By.xpath("//select[@id='field6']//option[text()='Active ']"));
        wait1.until(ExpectedConditions.visibilityOf(Employment_status_type));
        Employment_status_type.click();

        WebElement clicking_Save_After_Editing = driver.findElement(By.xpath("//button[text()='Save & Approve']"));
        wait1.until(ExpectedConditions.visibilityOf(clicking_Save_After_Editing));
        clicking_Save_After_Editing.click();

        WebElement getClicking_Save_After_Editing_yes = driver.findElement(By.xpath("//button[text()=' YES ']"));
        wait1.until(ExpectedConditions.visibilityOf(getClicking_Save_After_Editing_yes));
        getClicking_Save_After_Editing_yes.click();

        //assert for toaster
        WebElement toaster_message = driver.findElement(By.xpath("//div[@id='toast-container']//div//div"));
        wait1.until(ExpectedConditions.visibilityOf(toaster_message));
        String aa = toaster_message.getText();
        Assert.assertEquals(aa, Expected_message);


    }


}
