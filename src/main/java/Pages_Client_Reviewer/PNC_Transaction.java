package Custom_Utilities.Pages_Client_Reviewer;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.google.common.io.Files;

import lombok.val;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class PNC_Transaction {

    public WebDriver driver;

    public PNC_Transaction(WebDriver driver) {
        this.driver = driver;
    }


    /*  public void loader_wait(){
          WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
          WebElement heading_check = driver.findElement(By.xpath("(//img[@src='https://payncomp-cdn.neeyamo.com/Images/fffinalLoader75.gif'])[3]"));
          wait.until(ExpectedConditions.invisibilityOf(heading_check));

      }
      */
    public void loader_wait() {
        /*     * This method is used to make wait until the loader image gets disappear     */
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        List<WebElement> heading_check = driver.findElements(By.xpath("//img[@src=\"https://payncomp-cdn.neeyamo.com/Images/fffinalLoader75.gif\"]"));
        wait.until(ExpectedConditions.invisibilityOfAllElements(heading_check));
    }


    public void Transaction_Click(String Transactionfield, String form) throws InterruptedException {
        loader_wait();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        loader_wait();
        By Option_Clicking = By.xpath("//div[@id='menuControlItemCommon']//h3[text()='" + Transactionfield + "']");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(Option_Clicking));
        Thread.sleep(2000);
        driver.findElement(Option_Clicking).click();
        loader_wait();
        Thread.sleep(2000);
        By form_selection = By.xpath("//div[@id='menuControlItemCommon']//h3[text()='" + Transactionfield + "']//parent::div//li//a[text()='" + form + "']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(form_selection));
        driver.findElement(form_selection).click();
    }

    public void ProcessingPeriod_click(String monthyrselect) throws InterruptedException {
        loader_wait();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        By processing_click = By.xpath("//select[@name='processingmonthSelected']//option[text()=' " + monthyrselect + " ']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(processing_click));
        wait.until(ExpectedConditions.elementToBeClickable(processing_click));
        driver.findElement(processing_click).click();
        // loader_wait();
        Thread.sleep(3000);

        By search_click = By.xpath("//button[text()='Search']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(search_click));
        wait.until(ExpectedConditions.elementToBeClickable(search_click));
        driver.findElement(search_click).click();

    }

    public void Id_Search(String Employee_Id) throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        By data = By.xpath("//input[@id='ID']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(data));
        driver.findElement(data).sendKeys(Employee_Id);

        //  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='\"+Employee_Id+\"']")));
        Assert.assertTrue(driver.findElement(By.xpath("//span[text()='" + Employee_Id + "']"))
                .isDisplayed(), "display");

    }

    public void Edit_Click(String id) throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        By edit_click = By.xpath("//div[@id=\"content_Proxy\"]//app-checkerlist//table//tbody//span[text()='" + id + "']//parent::th//parent::tr//td[14]//a[1]");
        wait.until(ExpectedConditions.visibilityOfElementLocated(edit_click));
        driver.findElement(edit_click).click();

    }


    public void Edit_data(String editdata) throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        Assert.assertTrue(driver.findElement(By.xpath("//h3//span[text()='Details']"))
                .isDisplayed(), "Details");

        By senddata = By.xpath("//input[@id='field1']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(senddata));
        driver.findElement(senddata).click();
        driver.findElement(senddata).clear();
        driver.findElement(senddata).sendKeys(editdata);

    }

    public void Edit_data_Search(String editdata) {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        By Searchdata = By.xpath("//input[@id='Name']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(Searchdata));
        driver.findElement(Searchdata).click();
        driver.findElement(Searchdata).clear();
        driver.findElement(Searchdata).sendKeys(editdata);

    }

    public void check_display_records() {

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        By displayrecords = By.xpath("//div//h3[@class='panel-title']//div//span");
        //   wait.until(ExpectedConditions.visibilityOfElementLocated(displayrecords));
        String recordscount = driver.findElement(displayrecords).getText();

        if (recordscount.contains("Displaying 1 of")) {
            Assert.assertTrue(true);
        } else {
            Assert.assertFalse(true);
        }
    }

    public void Edit_data_bankform(String editbankdata) throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        Assert.assertTrue(driver.findElement(By.xpath("//h3//span[text()='Bank Form']"))
                .isDisplayed(), "Details");

        By senddata = By.xpath("//input[@id='field1']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(senddata));
        driver.findElement(senddata).click();
        driver.findElement(senddata).clear();
        driver.findElement(senddata).sendKeys(editbankdata);
    }

    public void Edit_data_bankform_search(String editbankdata) {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        By bankeditdatasearch = By.xpath("//input[@id='Employee Name']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(bankeditdatasearch));
        driver.findElement(bankeditdatasearch).click();
        driver.findElement(bankeditdatasearch).clear();
        driver.findElement(bankeditdatasearch).sendKeys(editbankdata);

    }

    public void bank_check_display_records() {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        By datasearch = By.xpath("//div//h3[@class='panel-title']//div//span");
        wait.until(ExpectedConditions.visibilityOfElementLocated(datasearch));
        String recordscount = driver.findElement(datasearch).getText();

        if (recordscount.contains("Displaying 1 of")) {
            Assert.assertTrue(true);
        } else {
            Assert.assertFalse(true);
        }

    }

    public void Save_And_Approve_Click() throws InterruptedException {

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        By saveclk = By.xpath("//button[text()='Save & Approve']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(saveclk));
        driver.findElement(saveclk).click();

        Assert.assertTrue(driver
                .findElement(By.xpath(" //span[text()='Are you sure you want to approve record?']"))
                .isDisplayed(), "Are you sure you want to approve record?");
    }

    public void Alert_Click() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        By popclk = By.xpath(" //button[text()=' YES ']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(popclk));
        driver.findElement(popclk).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()=' Record Submitted Successfully ']")));
        Assert.assertTrue(driver
                .findElement(By.xpath("//div[text()=' Record Submitted Successfully ']"))
                .isDisplayed(), "displayed");

    }

    public void Bankclk() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        By bankclick = By.xpath("//ul[@id=\"Transaction\"]//a[text()='Bank Form']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(bankclick));
        driver.findElement(bankclick).click();
    }

    public void Bank_Id_Search(String EmployeeId) {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        By data = By.xpath("//input[@id='EmployeeID']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(data));
        driver.findElement(data).sendKeys(EmployeeId);
        Assert.assertTrue(driver.findElement(By.xpath("//span[text()='" + EmployeeId + "']"))
                .isDisplayed(), "123655");


    }

    public void Bank_input_Received_Select(String Date_year) throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        By Inputselect = By.xpath("//select[@name='processingForSelected']//option[text()=' " + Date_year + "']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(Inputselect));
        driver.findElement(Inputselect).click();

        By searchclick = By.xpath("//div//button[text()='Search']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchclick));
        driver.findElement(searchclick).click();

    }

    public void Time_And_Attendance_EmployeeID_Search(String EmployeeId) throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        By data = By.xpath("//input[@id='EmployeeID']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(data));
        driver.findElement(data).sendKeys(EmployeeId);

        Assert.assertTrue(driver.findElement(By.xpath("//span[text()='" + EmployeeId + "']"))
                .isDisplayed(), "11111");


    }

    public void Edit_data_Time_And_Attendance(String editbankdata) throws InterruptedException {

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        Assert.assertTrue(driver.findElement(By.xpath("//div//div[text()=' Time and Attendance ']"))
                .isDisplayed(), "Details");

        By senddata = By.xpath("//input[@id='field1']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(senddata));
        driver.findElement(senddata).click();
        driver.findElement(senddata).clear();
        driver.findElement(senddata).sendKeys(editbankdata);
    }

    public void Edit_data_Time_And_Attendance_Search(String editbankdata) {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        By bank_editdata_search = By.xpath("//input[@id='Leave Encashment Days']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(bank_editdata_search));
        driver.findElement(bank_editdata_search).click();
        driver.findElement(bank_editdata_search).clear();
        driver.findElement(bank_editdata_search).sendKeys(editbankdata);


    }

    public void Check_Time_and_Attendance_Record_Display() {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        By datasearch = By.xpath("//div//h3[@class='panel-title']//div//span");
        wait.until(ExpectedConditions.visibilityOfElementLocated(datasearch));
        String recordscount = driver.findElement(datasearch).getText();

        if (recordscount.contains("Displaying 1 of")) {
            Assert.assertTrue(true);
        } else {
            Assert.assertFalse(true);
        }


    }

    public void Transaction_Download_File() throws IOException, InterruptedException {
        Actions action = new Actions(driver);

        WebElement download = driver.findElement(By.xpath("//div//input[@value='Download']"));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)", "");

        action.moveToElement(download).click(download).build().perform();

        Thread.sleep(2000);
        By Click_SelectAll = By.xpath("//div//h5[text()='Select all ']//parent::div//input[@type='checkbox'][1]");
        driver.findElement(Click_SelectAll).click();

        //  String downloadFilepath = System.getProperty("user.dir") + "\\DownloadFile";


        By Click_Download = By.xpath("//div//button[text()='Download']");
        action.sendKeys(Keys.PAGE_DOWN).build().perform();
        driver.findElement(Click_Download).click();

    }

    public void download_file() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(70));
        WebElement Table_data = driver.findElement(By.xpath("//table//tr//td"));
        wait.until(ExpectedConditions.visibilityOfAllElements(Table_data));


        //Thread.sleep(3000);
        Actions action = new Actions(driver);

        WebElement download = driver.findElement(By.xpath("//div//button[text()='Download']"));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)", "");
        action.moveToElement(download).click(download).build().perform();

    }

    public void Download_File_Validation(String file_name, String File_Rename, String Extension, String Folder_Name) throws IOException {

        String file_location = System.getProperty("user.home") + File.separator + "Downloads" + File.separator + "" + file_name + ".xlsx";

        File f1 = new File(System.getProperty("user.home") + File.separator + "Downloads" + File.separator + "" + Folder_Name + "");
        f1.mkdirs();

        long waitTillSeconds = 20000;
        boolean fileDownloaded = false;

        File file_path = new File(file_location);
        //File[] total_files= file_path.listFiles();
        long waitTillTime = Instant.now().toEpochMilli() + waitTillSeconds;

        while (Instant.now().toEpochMilli() < waitTillTime) {
            if (file_path.exists()) {
                break;
            } else {
                Assert.assertTrue(file_path.exists(), "Test Failed- File is not downloaded");
            }
        }
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("_yyyy_MM_dd    HH_mm_ss");
        LocalDateTime now = LocalDateTime.now();
        String s = (dtf.format(now));
        System.out.println(s);
        Files.move(file_path, new File(System.getProperty("user.home") + File.separator + "Downloads" + File.separator + "ClientReviewer_folder" + File.separator + "" + file_name + "" + (File_Rename) + "" + s + "." + Extension + ""));
        //      file_path.delete();
    }
}

//String home = System.getProperty("user.home");
//   File file_location = new File(home+"/Downloads/" ); 
   
    
    
 	  
    

