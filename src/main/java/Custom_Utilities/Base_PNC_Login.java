package Custom_Utilities;

import Pages_Checker.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

public class Base_PNC_Login {

    public WebDriver driver;


    public Custom_Utilities.Pages_Client_Reviewer.PNC_Home_Page PNC_home_page;
    public Custom_Utilities.Pages_Client_Reviewer.PNC_ReviewControl PNC_reviewcontrol;
    public Custom_Utilities.Pages_Client_Reviewer.PNC_Transaction PNC_transaction;

    public Pages_Checker.PNC_home_page PNC_home_page_calls;
    public Pages_Checker.PNC_New_Joiner_Form PNC_New_Joiner_Form_calls;
    public Pages_Checker.PNC_Edit_Page PNC_Edit_Page_calls;

    public Pages_Checker.PNC_Master_Form PNC_Master_Form_calls;

    public Pages_Checker.PNC_Bank_form PNC_Bank_form_calls;

    public Pages_Checker.PNC_Time_and_Attendance_Page PNC_Time_and_Attendance_Page_calls;


    @BeforeClass
    public void PNC_Login() throws InterruptedException, AWTException {


        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);

        File file = new File(System.getProperty("user.dir") + File.separator + "src" + File.separator + "test" + File.separator + "java" + File.separator + "resources" + File.separator + "id_password_companyName.properties");

        FileInputStream fis = null;
        try {
            fis = new FileInputStream(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Properties prop = new Properties();
        try {
            prop.load(fis);
        } catch (Exception e) {
            e.printStackTrace();
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));

        String loginPassword = prop.getProperty("passcode");
        String loginId = prop.getProperty("id");
        String companyname = prop.getProperty("companyName");
        String url = prop.getProperty("url_feature_uat");

        driver.get(url);
        driver.manage().window().maximize();

        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(50));
        WebElement load_wait = driver.findElement(By.xpath("//legend[@id=\"heading\"]"));
        wait1.until(ExpectedConditions.visibilityOf(load_wait));


        WebElement companyNamePNC = driver.findElement(By.xpath("//input[@placeholder='Company Name']"));
        companyNamePNC.sendKeys(companyname);

        WebElement username = driver.findElement(By.xpath("//input[@placeholder='User Id']"));
        username.sendKeys(loginId);

        WebElement password = driver.findElement(By.xpath("//input[@placeholder='Password']"));
        password.sendKeys(loginPassword);

        WebElement login = driver.findElement(By.xpath("//button[text()='Login']"));
        login.click();

//        password.sendKeys(loginPassword);
//
//        WebElement captcha = driver.findElement(By.xpath("(//div[@role=\"presentation\"])[1]"));
//        wait1.until(ExpectedConditions.visibilityOf(captcha));
//        captcha.click();
//
//        password.sendKeys(loginPassword);
//        login.click();

        PNC_home_page = new Custom_Utilities.Pages_Client_Reviewer.PNC_Home_Page(driver);
        PNC_transaction = new Custom_Utilities.Pages_Client_Reviewer.PNC_Transaction(driver);
        PNC_reviewcontrol = new Custom_Utilities.Pages_Client_Reviewer.PNC_ReviewControl(driver);

        PNC_home_page_calls = new Pages_Checker.PNC_home_page(driver);
        PNC_New_Joiner_Form_calls = new Pages_Checker.PNC_New_Joiner_Form(driver);
        PNC_Edit_Page_calls = new Pages_Checker.PNC_Edit_Page(driver);
        PNC_Master_Form_calls = new Pages_Checker.PNC_Master_Form(driver);
        PNC_Bank_form_calls = new Pages_Checker.PNC_Bank_form(driver);
        PNC_Time_and_Attendance_Page_calls = new Pages_Checker.PNC_Time_and_Attendance_Page(driver);

    }

    @AfterClass
    public void Browser_Closing() {
      //  driver.close();
    }
}

