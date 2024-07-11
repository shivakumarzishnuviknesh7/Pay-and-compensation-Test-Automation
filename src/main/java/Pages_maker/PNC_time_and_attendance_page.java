package Pages_maker;

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

public class PNC_time_and_attendance_page {


    public WebDriver driver;

    public PNC_time_and_attendance_page(WebDriver driver) {
        this.driver = driver;
    }

    public void Loader_Wait() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        List<WebElement> heading_check = driver.findElements(By.xpath("(//img[@src='https://payncomp-cdn.neeyamo.com/Images/fffinalLoader75.gif'])[2]"));
        wait.until(ExpectedConditions.invisibilityOfAllElements(heading_check));

    }

    public void Search() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        WebElement search_Button = driver.findElement(By.xpath("//button[text()='Search']"));
        wait.until(ExpectedConditions.visibilityOf(search_Button));

        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,-350);", search_Button);

        Thread.sleep(2000);
        search_Button.click();


    }

    public void Welcome() {
        WebElement welcome = driver.findElement(By.xpath("//span[text()=' Welcome']"));
        welcome.click();
    }


    public void Select_The_Processing_Month(String month_year_selection) throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        //implict wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        Loader_Wait();

        WebElement processing_Period_Selection = driver.findElement(By.xpath("//select[@name='processingmonthSelected']//option[text()=' " + month_year_selection + " ']"));
        wait.until(ExpectedConditions.visibilityOf(processing_Period_Selection));
        processing_Period_Selection.click();

        Welcome();
        Search();
        Loader_Wait();


    }
    public void Page_Down() {

        /*
         * This method is used to give page down to view the navigation bar
         */


        Actions act = new Actions(driver);
        act.sendKeys(Keys.PAGE_DOWN).build().perform();

    }


    public void Download_Click() throws InterruptedException {
        Thread.sleep(2000);

        Page_Down();

        Thread.sleep(2500);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement download_click = driver.findElement(By.xpath("//button[@id='download' and @type='button']"));
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
        WebElement download_button_click = driver.findElement(By.xpath("(//button[text()='Download'])[2]"));
        wait.until(ExpectedConditions.visibilityOf(download_button_click));
        download_button_click.click();
    }

    public void File_Dowload_Check(String legalEntity, String Country, String FormSelection, String ProcessingPeriod, String fileExtension) throws InterruptedException, IOException {


        //Regression Test 1.0_Egypt_Regression Test 1.0_Jan2023_New joiner

        //Thread.sleep(4500);

        String[] a = ProcessingPeriod.split("/");
        String month = a[0];
        String year = a[1];
        String monthandyear = "" + month + "" + year + "";
        System.out.println(monthandyear);

        String file_name = "" + legalEntity + "_" + Country + "_" + legalEntity + "_" + monthandyear + "_" + FormSelection + "" + fileExtension + "";
        System.out.println(file_name);

        String folder_name = System.getProperty("user.home") + "\\Downloads";
        Path folder_created = Paths.get(System.getProperty("user.home") + "\\Downloads\\test_cases_Maker_downloaded_file_Time_and_attendancer");

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
            File filess = new File(System.getProperty("user.home") + "\\Downloads\\test_cases_Maker_downloaded_file_Time_and_attendancer");
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

        File file_count = new File(System.getProperty("user.home") + "\\Downloads\\test_cases_Maker_downloaded_file_Time_and_attendancer");
        System.out.println(file_count.list().length);
        int number = file_count.list().length;
        //int number = num + 1;


        File fi = new File(System.getProperty("user.home") + "\\Downloads\\test_cases_Maker_downloaded_file_Time_and_attendancer\\file.xlsx");
        if (fi.exists()) {
            Path temp = Files.move
                    (Paths.get(System.getProperty("user.home") + "\\Downloads\\" + file_name + ""),
                            Paths.get(System.getProperty("user.home") + "\\Downloads\\test_cases_Maker_downloaded_file_Time_and_attendancer\\file " + number + ".xlsx"));

        } else {
            Path temp = Files.move
                    (Paths.get(System.getProperty("user.home") + "\\Downloads\\" + file_name + ""),
                            Paths.get(System.getProperty("user.home") + "\\Downloads\\test_cases_Maker_downloaded_file_Time_and_attendancer\\file.xlsx"), StandardCopyOption.REPLACE_EXISTING);
        }


    }


}
