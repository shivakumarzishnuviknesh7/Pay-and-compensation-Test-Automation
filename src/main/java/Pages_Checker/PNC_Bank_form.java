package Pages_Checker;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.List;
import java.io.File;
import java.io.IOException;


import static org.testng.AssertJUnit.assertEquals;

public class PNC_Bank_form {

    public WebDriver driver;

    public PNC_Bank_form(WebDriver driver) {
        this.driver = driver;
    }

    public void Loader_Wait() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        List<WebElement> heading_check = driver.findElements(By.xpath("//img[@src='https://payncomp-cdn.neeyamo.com/Images/fffinalLoader75.gif']"));
        wait.until(ExpectedConditions.invisibilityOfAllElements(heading_check));

    }

    public void Search_Employee_Id(String id) throws InterruptedException {
        //implict wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement id_Text_field = driver.findElement(By.xpath("//input[@id='EmployeeID']"));
        wait1.until(ExpectedConditions.visibilityOf(id_Text_field));
        id_Text_field.sendKeys(id);

        Thread.sleep(2000);
    }


    public void Click_On_The_Edit_Icon_Under_The_Action_Field(String id) throws InterruptedException {

        Search_Employee_Id(id);

        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(50));
        WebElement id_selection_edit = driver.findElement(By.xpath("//div[@id='content_Proxy']//app-checkerlist//table//tbody//th//span[text()='" + id + "']//parent::th//parent::tr//td[13]/a[1]"));
        wait1.until(ExpectedConditions.visibilityOf(id_selection_edit));
        id_selection_edit.click();

        Thread.sleep(2000);
    }

    public void Click_On_The_Cross_Symbol_Icon_Under_The_Action_Field(String id, String Expected_message) throws InterruptedException {

        Search_Employee_Id(id);

        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(20));

        WebElement id_selection_delete = driver.findElement(By.xpath("//div[@id='content_Proxy']//app-checkerlist//table//tbody//th//span[text()='" + id + "']//parent::th//parent::tr//td[13]/a[2]"));
        wait1.until(ExpectedConditions.visibilityOf(id_selection_delete));
        id_selection_delete.click();

        Thread.sleep(2000);

        driver.switchTo().alert().getText();
        String text = driver.switchTo().alert().getText();


        driver.switchTo().alert().accept();
        Assert.assertEquals(text, "Are you sure you want to delete the record?");


        //assert for toaster
        WebElement toaster_message = driver.findElement(By.xpath("//div[@id='toast-container']//div//div"));
        wait1.until(ExpectedConditions.visibilityOf(toaster_message));
        String a = toaster_message.getText();
        System.out.println(a);
        Assert.assertEquals(a, Expected_message);
        Loader_Wait();

    }

    public void Select_The_Particular_Record(String record) throws InterruptedException {
        Search_Employee_Id(record);

        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement selecting_single_record = driver.findElement(By.xpath("//div[@id='content_Proxy']//app-checkerlist//table//tbody//th//span[text()='" + record + "']//parent::th//parent::tr//td[12]//input"));
        wait1.until(ExpectedConditions.visibilityOf(selecting_single_record));
        selecting_single_record.click();

    }

    public void Approve_Click(String Expected_message) throws InterruptedException {


        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(50));
        WebElement approve_Button = driver.findElement(By.xpath("//input[@name='Approved']"));

        //with this we can scroll down
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", approve_Button);

        wait1.until(ExpectedConditions.visibilityOf(approve_Button));
        approve_Button.click();

        Thread.sleep(2000);


        WebElement approve_Button_Alert_Box_Yes_Clicking = driver.findElement(By.xpath("//button[text()=' YES ']"));
        wait1.until(ExpectedConditions.visibilityOf(approve_Button_Alert_Box_Yes_Clicking));
        approve_Button_Alert_Box_Yes_Clicking.click();

        //assert for toaster
        WebElement toaster_message = driver.findElement(By.xpath("//div[@id='toast-container']//div//div"));
        wait1.until(ExpectedConditions.visibilityOf(toaster_message));
        String a = toaster_message.getText();
        System.out.println(a);
        Assert.assertEquals(a, Expected_message);

        Loader_Wait();

    }

    public void Approve_Click_Without_Record_Selecting(String message) throws InterruptedException {

        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement approve_Button = driver.findElement(By.xpath("//input[@name='Approved']"));

        //with this we can scroll down
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", approve_Button);

        wait1.until(ExpectedConditions.visibilityOf(approve_Button));
        approve_Button.click();
        driver.switchTo().alert().getText();
        String text = driver.switchTo().alert().getText();

        driver.switchTo().alert().accept();
        Assert.assertEquals(text, message);
    }

    public void Bulk_Delete(String Expected_message) throws InterruptedException {
        Thread.sleep(2000);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //Explicit wait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement bulkdelete = driver.findElement(By.xpath("//input[@name='BulkDelete']"));

        //with this we can scroll down
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", bulkdelete);

        wait.until(ExpectedConditions.visibilityOf(bulkdelete));
        bulkdelete.click();

        Thread.sleep(2000);

        WebElement alert_yes_button = driver.findElement(By.xpath("//button[text()=' YES ']"));
        wait.until(ExpectedConditions.visibilityOf(alert_yes_button));
        alert_yes_button.click();

        //assert for toaster
        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(50));
        WebElement toaster_message = driver.findElement(By.xpath("//div[@id='toast-container']//div//div"));
        wait1.until(ExpectedConditions.visibilityOf(toaster_message));
        String a = toaster_message.getText();

        Assert.assertEquals(a, Expected_message);
        Loader_Wait();
    }

    public void Bulk_Delete_Click(String Expected_message) throws InterruptedException {


        //implict wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement bulk_delete_button = driver.findElement(By.xpath("//input[@name='BulkDelete']"));

        //with this we can scroll down
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", bulk_delete_button);

        wait1.until(ExpectedConditions.visibilityOf(bulk_delete_button));
        bulk_delete_button.click();

        Thread.sleep(2000);
        WebElement alert_yes_button = driver.findElement(By.xpath("//button[text()=' YES ']"));

        wait1.until(ExpectedConditions.visibilityOf(alert_yes_button));
        alert_yes_button.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement toaster_message = driver.findElement(By.xpath("//div[@id='toast-container']//div//div"));
        wait.until(ExpectedConditions.visibilityOf(toaster_message));
        String a = toaster_message.getText();
        Loader_Wait();


        //assert for toaster
        Assert.assertEquals(a, Expected_message);


    }

    public void Single_Record_Selecting_Check_Box(String one_record) throws InterruptedException {
        Search_Employee_Id(one_record);

        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement one_record_selecting_check_box = driver.findElement(By.xpath("//div[@id='content_Proxy']//app-checkerlist//table//tbody//th//span[text()='" + one_record + "']//parent::th//parent::tr//td[12]//input"));
        wait1.until(ExpectedConditions.visibilityOf(one_record_selecting_check_box));
        one_record_selecting_check_box.click();

    }

    public void Single_Record_Selecting_Check_Box(String record_selected, String reject_reason) throws InterruptedException {
        Thread.sleep(2000);

        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement single_record = driver.findElement(By.xpath("//div[@id='content_Proxy']//app-checkerlist//table//tbody//th//span[text()='" + record_selected + "']//parent::th//parent::tr//td[12]//option[text()= ' " + reject_reason + " ']"));
        wait1.until(ExpectedConditions.visibilityOf(single_record));
        single_record.click();

    }

    public void Reject_Click(String Expected_message) throws InterruptedException {
        //implict wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));


        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement reject_button = driver.findElement(By.xpath("//input[@name='Rejected']"));

        //with this we can scroll down
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", reject_button);

        wait1.until(ExpectedConditions.visibilityOf(reject_button));

        reject_button.click();


        WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement alert_no = driver.findElement(By.xpath("//button[text()=' NO ']"));
        wait2.until(ExpectedConditions.visibilityOf(alert_no));

        alert_no.click();


        reject_button.click();

        WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement alert_yes = driver.findElement(By.xpath("//button[text()=' YES ']"));
        wait3.until(ExpectedConditions.visibilityOf(alert_yes));

        alert_yes.click();
        WebDriverWait wait5 = new WebDriverWait(driver, Duration.ofSeconds(50));
        WebElement toaster_message = driver.findElement(By.xpath("//div[@id='toast-container']//div//div"));
        wait5.until(ExpectedConditions.visibilityOf(toaster_message));
        String a = toaster_message.getText();

        Loader_Wait();

        //assert for toaster
        Assert.assertEquals(a, Expected_message);
    }

    public void Reject_Button_Click(String message) throws InterruptedException {
        //implict wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));


        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(50));
        WebElement reject_button = driver.findElement(By.xpath("//input[@name='Rejected']"));

        //with this we can scroll down
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", reject_button);

        wait1.until(ExpectedConditions.visibilityOf(reject_button));
        reject_button.click();

        driver.switchTo().alert().getText();
        String text = driver.switchTo().alert().getText();


        driver.switchTo().alert().accept();
        Assert.assertEquals(text, message);


    }

    public void Changes_Check(String data) {
        //Explicit wait
        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement record_search = driver.findElement(By.xpath("//div[@class='divgrid']//input[@id='EmployeeID']"));
        wait1.until(ExpectedConditions.visibilityOf(record_search));
        record_search.sendKeys(data);

        Assert.assertTrue(driver
                .findElement(By.xpath("//div[@id='content_Proxy']//app-checkerlist//table//tbody//th//span[text()='" + data + "']//parent::th//parent::tr//td[1]//span"))
                .isDisplayed(), "Checker Approved(SubashG_Maker)");

    }

    public void Select_Input_Received_In_Month(String month_year_selection) throws InterruptedException {
        //implict wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        //Thread.sleep(7000);

        //Explicit wait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement processing_Period_Selection = driver.findElement(By.xpath("//select[@name='processingForSelected']//option[text()=' " + month_year_selection + " ']"));
        wait.until(ExpectedConditions.visibilityOf(processing_Period_Selection));
        processing_Period_Selection.click();
        Thread.sleep(5000);

        WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement search_Button = driver.findElement(By.xpath("//button[text()='Search']"));
        wait2.until(ExpectedConditions.visibilityOf(search_Button));

        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,-350);", search_Button);

        search_Button.click();
        Loader_Wait();


    }

    public void Approve_All_Record_Without_Selecting(String message) throws InterruptedException {


        //implict wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));


        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement approve_all_button = driver.findElement(By.xpath("//input[@name='ApproveAll']"));

        //with this we can scroll down
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", approve_all_button);

        wait1.until(ExpectedConditions.visibilityOf(approve_all_button));
        approve_all_button.click();


        WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement alert_yes_button = driver.findElement(By.xpath("//button[text()=' YES ']"));

        wait2.until(ExpectedConditions.visibilityOf(alert_yes_button));
        alert_yes_button.click();
        Loader_Wait();

        Thread.sleep(1000);


        Assert.assertTrue(driver.findElement(By.xpath("(//div[@id='toast-container'])[1]")).isDisplayed(), " No records  available to approve ");

        Assert.assertEquals(driver.findElement(By.xpath("(//div[@id='toast-container'])[1]")).getText(), message);

    }

    public void Reject_Button_Click_Without_Record(String message) throws InterruptedException {
        //implict wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));


        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement reject_button = driver.findElement(By.xpath("//input[@name='Rejected']"));

        //with this we can scroll down
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", reject_button);

        wait1.until(ExpectedConditions.visibilityOf(reject_button));
        reject_button.click();

        driver.switchTo().alert().getText();
        String text = driver.switchTo().alert().getText();

        driver.switchTo().alert().accept();
        Assert.assertEquals(text, message);
    }

    public void Clicking_Approve_All_Button() throws InterruptedException {


        //implict wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement select_all_checkbox = driver.findElement(By.xpath("//div[@class='divgrid']//tr//th[13]//input"));
        wait.until(ExpectedConditions.visibilityOf(select_all_checkbox));


        By check_boxes = By.xpath("//input[@name='checkboxselected']//parent::td");
        String selected_records = String.valueOf(driver.findElements(check_boxes).size());

        select_all_checkbox.click();

        //Explicit wait

        WebElement approve_all_button = driver.findElement(By.xpath("//input[@name='ApproveAll']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", approve_all_button);
        wait.until(ExpectedConditions.visibilityOf(approve_all_button));
        approve_all_button.click();

        WebElement alert_yes = driver.findElement(By.xpath("//button[text()=' YES ']"));
        wait.until(ExpectedConditions.visibilityOf(alert_yes));
        alert_yes.click();

        By toaster_message = By.xpath("//div[@id='toast-container']//div//div");
        String toaster_message_data = driver.findElement(toaster_message).getAttribute("aria-label");
        System.out.println(toaster_message_data);

        //You have approved 2 records! We'll take care of processing this and send you a notification when ready. Feel free to move out of this page
        String[] array1 = toaster_message_data.split("approved");
        String number_in_toaster_message = array1[1].split("records!")[0];

        number_in_toaster_message = number_in_toaster_message.trim();

        System.out.println(number_in_toaster_message);

        System.out.println(selected_records);

        assertEquals(selected_records, number_in_toaster_message);


        System.out.println("last answer ");
        System.out.println(selected_records);
        System.out.println(number_in_toaster_message);
        toaster_Invisible();


    }
    public void toaster_Invisible(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement toaster_invisible = driver.findElement(By.xpath("//div[@id='toast-container']//div//div"));
        wait.until(ExpectedConditions.invisibilityOf(toaster_invisible));
    }

    public void Page_Down() {

        /*
         * This method is used to give page down to view the navigation bar
         */

        //JavascriptExecutor js = (JavascriptExecutor) driver;
        //js.executeScript("Scroll(0, -250);");

        Actions act = new Actions(driver);
        act.sendKeys(Keys.PAGE_DOWN).build().perform();

    }

    public void Download_Click() throws InterruptedException {
        Thread.sleep(2000);
        Page_Down();

        Thread.sleep(2500);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement download_click = driver.findElement(By.xpath("//input[@type='button' and @value='Download']"));
        wait.until(ExpectedConditions.visibilityOf(download_click));
        download_click.click();

    }

    public void Select_All_Check_Box_Click() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement select_all_check_box_click = driver.findElement(By.xpath("(//h5[text()='Select all ']//parent::div//input[@type='checkbox'])[1]"));
        wait.until(ExpectedConditions.visibilityOf(select_all_check_box_click));
        select_all_check_box_click.click();
    }

    public void Download_Button_Click() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement download_button_click = driver.findElement(By.xpath("//button[text()='Download']"));
        wait.until(ExpectedConditions.visibilityOf(download_button_click));
        download_button_click.click();
    }

    public void File_Dowload_Check(String legalEntity, String Country, String FormSelection, String ProcessingPeriod, String fileExtension) throws InterruptedException, IOException {


        String[] a = ProcessingPeriod.split("/");
        String month = a[0];
        String year = a[1];
        String monthandyear = "" + month + "" + year + "";
        String text = "One Time";
        System.out.println(monthandyear);

        String file_name = "" + legalEntity + "_" + Country + "_" + legalEntity + "_" + text + "_" + FormSelection + "" + fileExtension + "";
        System.out.println(file_name);

        String folder_name = System.getProperty("user.home") + "\\Downloads";
        Path folder_created = Paths.get(System.getProperty("user.home") + "\\Downloads\\test_cases_downloaded_file_Bank_Form");

        File f = new File(System.getProperty("user.home") + "\\Downloads\\" + file_name + "");
        long start = System.currentTimeMillis();
        long end = start + 30 * 1000;
        while (System.currentTimeMillis() < end) {
            if (f.exists()) {
                break;
            } else {

            }
        }

        if (Files.exists(folder_created)) {
            System.out.println("folder already exist");
        } else {
            File filess = new File(System.getProperty("user.home") + "\\Downloads\\test_cases_downloaded_file_Bank_Form");
            Boolean folder_creation = filess.mkdir();
            System.out.println(folder_creation);
        }


        File[] listOfFiles;
        String file_Name;
        boolean file_dowladed = false;

        while (true) {
            listOfFiles = new File(folder_name).listFiles();
            for (File file : listOfFiles) {
                file_Name = file.getName();

                if (file_Name.equals(file_name)
                        && file_Name.contains(fileExtension.toLowerCase())
                        && !file_Name.contains("crdownload")) {
                    file_dowladed = true;
                    break;
                }
            }
            if (file_dowladed)
                break;
            break;
        }
        Assert.assertTrue(file_dowladed, "Test case failed - file is not downloaded");

        File file_count = new File(System.getProperty("user.home") + "\\Downloads\\test_cases_downloaded_file_Bank_Form");
        System.out.println(file_count.list().length);
        int number = file_count.list().length;
        //int number = num + 1;


        File fi = new File(System.getProperty("user.home") + "\\Downloads\\test_cases_downloaded_file_Bank_Form\\file.xlsx");
        if (fi.exists()) {
            Path temp = Files.move
                    (Paths.get(System.getProperty("user.home") + "\\Downloads\\" + file_name + ""),
                            Paths.get(System.getProperty("user.home") + "\\Downloads\\test_cases_downloaded_file_Bank_Form\\file " + number + ".xlsx"));

        } else {
            Path temp = Files.move
                    (Paths.get(System.getProperty("user.home") + "\\Downloads\\" + file_name + ""),
                            Paths.get(System.getProperty("user.home") + "\\Downloads\\test_cases_downloaded_file_Bank_Form\\file.xlsx"));
        }


    }


}
