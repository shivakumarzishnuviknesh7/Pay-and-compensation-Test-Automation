package Pages_Checker;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.Duration;
import java.util.List;

import static org.testng.AssertJUnit.assertEquals;

public class PNC_Time_and_Attendance_Page {

    public WebDriver driver;

    public PNC_Time_and_Attendance_Page(WebDriver driver) {
        this.driver = driver;
    }


    public void Search_Employee_Id(String id) throws InterruptedException {

        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement id_Text_field = driver.findElement(By.xpath("//input[@id='EmployeeID']"));
        wait1.until(ExpectedConditions.visibilityOf(id_Text_field));
        id_Text_field.sendKeys(id);

        Thread.sleep(2000);
    }


    public void Loader_Wait() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        List<WebElement> heading_check = driver.findElements(By.xpath("//img[@src=\"https://payncomp-cdn.neeyamo.com/Images/fffinalLoader75.gif\"]"));
        wait.until(ExpectedConditions.invisibilityOfAllElements(heading_check));

    }


    public void Select_The_Processing_Month(String month_year_selection) throws InterruptedException {

        //implict wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));


        Loader_Wait();

        Thread.sleep(2500);
        //Explicit wait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        WebElement processing_Period_Selection = driver.findElement(By.xpath("//select[@name='processingmonthSelected']//option[text()=' " + month_year_selection + " ']"));
        wait.until(ExpectedConditions.visibilityOf(processing_Period_Selection));
        processing_Period_Selection.click();

        Thread.sleep(2500);

        WebElement search_Button = driver.findElement(By.xpath("//button[text()='Search']"));
        wait.until(ExpectedConditions.visibilityOf(search_Button));
        wait.until(ExpectedConditions.elementToBeClickable(search_Button));
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,-350);", search_Button);
        search_Button.click();

        Loader_Wait();

    }

    public void Click_On_The_Edit_Icon_Under_The_Action_Field(String id) throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));

        WebElement id_Text_field = driver.findElement(By.xpath("//div[@class='divgrid']//input[@id='EmployeeID']"));
        wait.until(ExpectedConditions.visibilityOf(id_Text_field));
        id_Text_field.sendKeys(id);

        WebElement id_selection_edit = driver.findElement(By.xpath("//div[@id='content_Proxy']//app-checkerlist//table//tbody//th//span[text()='" + id + "']//parent::th//parent::tr//td[14]/a[1]"));
        wait.until(ExpectedConditions.visibilityOf(id_selection_edit));
        id_selection_edit.click();

    }

    public void Search_Employee(String data) throws InterruptedException {

        Thread.sleep(2000);

        //Explicit wait
        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(30));

        WebElement record_search = driver.findElement(By.xpath("//div[@class='divgrid']//input[@id='EmployeeID']"));
        wait1.until(ExpectedConditions.visibilityOf(record_search));
        record_search.sendKeys(data);
    }

    public void Record_Approved_Check(String data) throws InterruptedException {
        Search_Employee(data);

        Assert.assertTrue(driver
                .findElement(By.xpath("//div[@id='content_Proxy']//app-checkerlist//table//tbody//th//span[text()='" + data + "']//parent::th//parent::tr//td[8]//span"))
                .isDisplayed(), "Checker Approved(Regression_Tester_1.0)");

    }

    public void Click_On_The_Cross_Symbol_Icon_Under_The_Action_Field(String id, String message) throws InterruptedException {

        //implict wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        Search_Employee(id);
        Thread.sleep(1000);

        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(20));

        WebElement id_selection_delete = driver.findElement(By.xpath("//div[@id='content_Proxy']//app-checkerlist//table//tbody//th//span[text()='" + id + "']//parent::th//parent::tr//td[14]/a[2]"));
        wait1.until(ExpectedConditions.visibilityOf(id_selection_delete));
        id_selection_delete.click();

        Thread.sleep(2000);

        driver.switchTo().alert().getText();
        String text = driver.switchTo().alert().getText();

        driver.switchTo().alert().accept();
        Assert.assertEquals(text, message);

    }

    public void Select_The_Particular_Record(String record) throws InterruptedException {

        //implict wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        Search_Employee(record);


        //Explicit wait
        Thread.sleep(2000);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        WebElement selecting_single_record = driver.findElement(By.xpath("//div[@id='content_Proxy']//app-checkerlist//table//tbody//th//span[text()='" + record + "']//parent::th//parent::tr//td[13]//input"));
        wait.until(ExpectedConditions.visibilityOf(selecting_single_record));
        wait.until(ExpectedConditions.elementToBeClickable(selecting_single_record));
        selecting_single_record.click();

    }

    public void Approve_Click() throws InterruptedException {

        //Explicit wait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement approve_Button = driver.findElement(By.xpath("//input[@name='Approved']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", approve_Button);
        wait.until(ExpectedConditions.visibilityOf(approve_Button));

        Thread.sleep(1500);
        approve_Button.click();

        Thread.sleep(1500);

        WebElement approve_Button_Alert_Box_Yes_Clicking = driver.findElement(By.xpath("//button[text()=' YES ']"));
        wait.until(ExpectedConditions.visibilityOf(approve_Button_Alert_Box_Yes_Clicking));
        approve_Button_Alert_Box_Yes_Clicking.click();

        Loader_Wait();

    }

    public void Approve_Click_Without_Record_Selecting(String message) throws InterruptedException {

        //implict wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        //Explicit wait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement approve_Button = driver.findElement(By.xpath("//input[@name='Approved']"));
        //with this we can scroll down
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", approve_Button);
        Page_Down();
        wait.until(ExpectedConditions.visibilityOf((approve_Button)));
        Thread.sleep(1500);
        approve_Button.click();

        driver.switchTo().alert().getText();
        String text = driver.switchTo().alert().getText();

        driver.switchTo().alert().accept();
        Assert.assertEquals(text, message);

    }

    public void Clicking_Approve_All() throws InterruptedException {


        //implict wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement select_all_checkbox = driver.findElement(By.xpath("//div[@class='divgrid']//tr//th[14]//input"));
        wait.until(ExpectedConditions.visibilityOf(select_all_checkbox));

        By check_boxes = By.xpath("//input[@name='checkboxselected']//parent::td");
        String selected_records = String.valueOf(driver.findElements(check_boxes).size());

        select_all_checkbox.click();

        WebElement approve_all_button = driver.findElement(By.xpath("//input[@name='ApproveAll']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", approve_all_button);
        wait.until(ExpectedConditions.visibilityOf(approve_all_button));
        approve_all_button.click();

        Thread.sleep(2000);

        By alert_yes = By.xpath("//button[text()=' YES ']");
        driver.findElement(alert_yes).click();
        Loader_Wait();

        By toaster_message = By.xpath("//div[@id='toast-container']//div//div");
        String toaster_message_data = driver.findElement(toaster_message).getAttribute("aria-label");
        System.out.println(toaster_message_data);
        String Actual_Toaster_Text = driver.findElement(toaster_message).getText();
        String Expected_Toaster_Text = "You have approved " + selected_records + " records! We'll take care of processing this and send you a notification when ready. Feel free to move out of this page";

        //You have approved 2 records! We'll take care of processing this and send you a notification when ready. Feel free to move out of this page
        String[] array1 = toaster_message_data.split("approved");
        String number_in_toaster_message = array1[1].split("records!")[0];

        number_in_toaster_message = number_in_toaster_message.trim();

        System.out.println(number_in_toaster_message);

        System.out.println(selected_records);

        assertEquals(selected_records, number_in_toaster_message);

        Assert.assertEquals(Actual_Toaster_Text, Expected_Toaster_Text);

        System.out.println("last answer ");
        System.out.println(selected_records);
        System.out.println(number_in_toaster_message);


    }

    public void Bulk_Delete(String message) throws InterruptedException {

        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(20));

        WebElement bulk_delete_button = driver.findElement(By.xpath("//input[@name='BulkDelete']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", bulk_delete_button);
        wait1.until(ExpectedConditions.visibilityOf(bulk_delete_button));
        bulk_delete_button.click();

        WebElement alert_yes_button = driver.findElement(By.xpath("//button[text()=' YES ']"));
        wait1.until(ExpectedConditions.visibilityOf(alert_yes_button));
        alert_yes_button.click();

        Loader_Wait();

        //assert for toaster
        WebElement toaster_message = driver.findElement(By.xpath("//div[@id='toast-container']//div//div"));
        wait1.until(ExpectedConditions.visibilityOf(toaster_message));
        String a = toaster_message.getText();
        Assert.assertEquals(a, message);

    }

    public void Approve_All_Without_Selecting_Record(String message) throws InterruptedException {
        Thread.sleep(2000);

        //Explicit wait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        WebElement approve_Buttons = driver.findElement(By.xpath(" //input[@name='ApproveAll']//parent::div//child::input[3]"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", approve_Buttons);
        wait.until(ExpectedConditions.visibilityOf(approve_Buttons));
        approve_Buttons.click();


        Thread.sleep(1500);
        //Explicit wait
        WebElement alert_yes = driver.findElement(By.xpath("//button[text()= ' YES ']"));
        wait.until(ExpectedConditions.visibilityOf(alert_yes));
        alert_yes.click();

        Loader_Wait();

        WebElement toaster_message = driver.findElement(By.xpath("(//div[@id='toast-container'])[1]"));
        wait.until(ExpectedConditions.visibilityOf(toaster_message));
        String a = toaster_message.getText();
        String b = message;
        Assert.assertEquals(a, b);


    }

    public void Single_Record_Selecting_Check_Box(String one_record) throws InterruptedException {

        Search_Employee(one_record);

        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(30));

        WebElement one_record_selecting_check_box = driver.findElement(By.xpath("//div[@id='content_Proxy']//app-checkerlist//table//tbody//th//span[text()='" + one_record + "']//parent::th//parent::tr//td[13]//input"));
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

    public void Reject_Click(String message) throws InterruptedException {

        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(20));

        WebElement reject_button = driver.findElement(By.xpath("//input[@name='Rejected']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", reject_button);
        wait1.until(ExpectedConditions.visibilityOf(reject_button));
        reject_button.click();

        Thread.sleep(1500);

        WebElement alert_no = driver.findElement(By.xpath("//button[text()=' NO ']"));
        wait1.until(ExpectedConditions.visibilityOf(alert_no));
        alert_no.click();

        Thread.sleep(1000);

        reject_button.click();

        WebElement alert_yes = driver.findElement(By.xpath("//button[text()=' YES ']"));
        wait1.until(ExpectedConditions.visibilityOf(alert_yes));
        alert_yes.click();

        Loader_Wait();

        WebElement toaster_message = driver.findElement(By.xpath("//div[@id='toast-container']//div//div"));
        wait1.until(ExpectedConditions.visibilityOf(toaster_message));
        String a = toaster_message.getText();
        Assert.assertEquals(a, message);

    }

    public void Reject_Button_Click(String message) throws InterruptedException {

        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement reject_button = driver.findElement(By.xpath("//input[@name='Rejected']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", reject_button);
        wait1.until(ExpectedConditions.visibilityOf(reject_button));
        reject_button.click();

        driver.switchTo().alert().getText();
        String text = driver.switchTo().alert().getText();

        driver.switchTo().alert().accept();
        Assert.assertEquals(text, message);


    }

    public void Reject_Button_Click_Without_Selecting_Any_Thing(String message) throws InterruptedException {

        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement reject_button = driver.findElement(By.xpath("//input[@name='Rejected']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", reject_button);
        wait1.until(ExpectedConditions.visibilityOf(reject_button));
        reject_button.click();

        driver.switchTo().alert().getText();
        String text = driver.switchTo().alert().getText();

        driver.switchTo().alert().accept();
        Assert.assertEquals(text, message);

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


        //Regression Test 1.0_Egypt_Regression Test 1.0_Jan2023_New joiner


        String[] a = ProcessingPeriod.split("/");
        String month = a[0];
        String year = a[1];
        String monthandyear = "" + month + "" + year + "";
        System.out.println(monthandyear);

        String file_name = "" + legalEntity + "_" + Country + "_" + legalEntity + "_" + monthandyear + "_" + FormSelection + "" + fileExtension + "";
        System.out.println(file_name);

        String folder_name = System.getProperty("user.home") + "\\Downloads";
        Path folder_created = Paths.get(System.getProperty("user.home") + "\\Downloads\\test_cases_downloaded_file_time_and_attendance");

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
            File filess = new File(System.getProperty("user.home") + "\\Downloads\\test_cases_downloaded_file_time_and_attendance");
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

        File file_count = new File(System.getProperty("user.home") + "\\Downloads\\test_cases_downloaded_file_time_and_attendance");
        System.out.println(file_count.list().length);
        int number = file_count.list().length;
        //int number = num + 1;


        File fi = new File(System.getProperty("user.home") + "\\Downloads\\test_cases_downloaded_file_time_and_attendance\\file.xlsx");
        if (fi.exists()) {
            Path temp = Files.move
                    (Paths.get(System.getProperty("user.home") + "\\Downloads\\" + file_name + ""),
                            Paths.get(System.getProperty("user.home") + "\\Downloads\\test_cases_downloaded_file_time_and_attendance\\file " + number + ".xlsx"));

        } else {
            Path temp = Files.move
                    (Paths.get(System.getProperty("user.home") + "\\Downloads\\" + file_name + ""),
                            Paths.get(System.getProperty("user.home") + "\\Downloads\\test_cases_downloaded_file_time_and_attendance\\file.xlsx"), StandardCopyOption.REPLACE_EXISTING);
        }


    }


}
