package Custom_Utilities.Pages_Client_Reviewer;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.google.common.io.Files;

public class PNC_ReviewControl {
    public WebDriver driver;

    public PNC_ReviewControl(WebDriver driver) {
        this.driver = driver;
    }

    public void loader_wait() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement heading_check = driver.findElement(By.xpath("(//img[@src='https://payncomp-cdn.neeyamo.com/Images/fffinalLoader75.gif'])[1]"));
        wait.until(ExpectedConditions.invisibilityOf(heading_check));

    }


    public void ReviewControl_Click(String menuselect, String formselect) throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        loader_wait();
        Thread.sleep(3000);
        By Select_Menu = By.xpath("//div//h3[text()='" + menuselect + "']");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(Select_Menu));
        driver.findElement(Select_Menu).click();

        By Select_Form = By.xpath("//ul[@id='" + menuselect + "']//a[text()='" + formselect + "']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(Select_Form));
        driver.findElement(Select_Form).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()=' " + formselect + " ']")));
        Assert.assertTrue(driver.findElement(By.xpath("//div[text()=' " + formselect + " ']"))
                .isDisplayed(), "Intelligent Input Control");
    }

    public void Processing_Click(String dateyr) throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(70));
        By Processing_period_click = By.xpath("//select[@name='processingmonthSelected']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(Processing_period_click));
        driver.findElement(Processing_period_click).click();
        By Click_On_Processing = By.xpath("//select[@name='processingmonthSelected']//option[text()=' " + dateyr + "']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(Click_On_Processing));
        wait.until(ExpectedConditions.elementToBeClickable(Click_On_Processing));
        driver.findElement(Click_On_Processing).click();
        loader_wait();

        By Click_On_Search = By.xpath("//div//button[text()='Search']");
        driver.findElement(Click_On_Search).click();
        loader_wait();
      //  driver.findElement(Click_On_Search).click();

    }
    public void Click_On_Search_Button() {
    	  loader_wait();
    	 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

         WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(70));
         By Click_On_Search = By.xpath("//div//button[text()='Search']");
         wait.until(ExpectedConditions.visibilityOfElementLocated(Click_On_Search));
         driver.findElement(Click_On_Search).click();
    	
    }

    public void Approved_Record_click(String menudata) throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        Thread.sleep(2000);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        By Approval_click = By.xpath("//div[@class='form-group']//tbody//tr//td[text()='" + menudata + "']//parent::tr//td[2]//a");
        Thread.sleep(2000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(Approval_click));
        driver.findElement(Approval_click).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div//label[text()='From Date:']")));
        Assert.assertTrue(driver.findElement(By.xpath("//div//label[text()='From Date:']"))
                .isDisplayed(), "From Date:");


    }


    public void From_date(String fromdate) throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        Thread.sleep(2000);
        By from_click = By.xpath("//input[@name='startDate']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(from_click));
        wait.until(ExpectedConditions.elementToBeClickable(from_click));
        driver.findElement(from_click).click();
        Thread.sleep(1000);
        driver.findElement(from_click).sendKeys(fromdate);


    }

    public void To_date(String todate) throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        By to_click = By.xpath("//input[@name='endDate']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(to_click));
        driver.findElement(to_click).click();
        driver.findElement(to_click).sendKeys(todate);

        By search_click = By.xpath("//input[@value='Search']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(search_click));
        driver.findElement(search_click).click();

    }

    public void approvedrecords() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        By approvedclk = By.xpath("//div[@class='form-group']//tbody//tr//td[text()='New joiner']//parent::tr//td[2]//a");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='form-group']//tbody//tr//td[text()='New joiner']//parent::tr//td[2]//a")));
        driver.findElement(approvedclk).click();
    }

    public void Rejected_records_click() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        By Click_On_Rejected_Records = By.xpath("//div[@class='form-group']//tbody//tr//td[text()='New joiner']//parent::tr//td[3]//a");
        wait.until(ExpectedConditions.visibilityOfElementLocated(Click_On_Rejected_Records));
        driver.findElement(Click_On_Rejected_Records).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//th//span[text()='RejectReasonMasterID']")));
        Assert.assertTrue(driver.findElement(By.xpath("//th//span[text()='RejectReasonMasterID']"))
                .isDisplayed(), "RejectReasonMasterID");

    }

    public void Waiting_For_Approval_Click() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        By Waiting_Records_click = By.xpath("//div[@class='form-group']//tbody//tr//td[text()='New joiner']//parent::tr//td[4]//a");
        wait.until(ExpectedConditions.visibilityOfElementLocated(Waiting_Records_click));
        driver.findElement(Waiting_Records_click).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div//label[text()='From Date:']")));
        Assert.assertTrue(driver.findElement(By.xpath("//div//label[text()='From Date:']"))
                .isDisplayed(), "From Date:");
    }

    public void singoffclick() throws InterruptedException {
   
      driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        By signoff_Click = By.xpath("//button[text()='Sign Off']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(signoff_Click));
        wait.until(ExpectedConditions.elementToBeClickable(signoff_Click));
        driver.findElement(signoff_Click).click();
        loader_wait();
        Assert.assertTrue(driver.findElement(By.xpath("//button[text()=' YES ']"))
                .isDisplayed(), "Failed To Load Alert Message");
    }
              
    
    public void changeWaitTime(int time) {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
    	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));
    	wait = new WebDriverWait(driver, Duration.ofSeconds(time));
    	}

    public void yesclick() throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        By yes_click = By.xpath(" //button[text()=' YES ']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(yes_click));
        wait.until(ExpectedConditions.elementToBeClickable(yes_click));
        driver.findElement(yes_click).click();
        loader_wait();
        /*
       // wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div//span[contains(text(),'Please be sure about closing all Inputs and no further Inputs can be made.')]")));
        Assert.assertTrue(driver
                .findElement(By.xpath("//div//span[contains(text(),'Please be sure about closing all Inputs and no further Inputs can be made.')]"))
                .isDisplayed(),"Test Failed");

*/
        By YESclick = By.xpath("//div//button[text()=' YES ']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(YESclick));
        wait.until(ExpectedConditions.elementToBeClickable(yes_click));
        driver.findElement(YESclick).click();
        


    }

    public void Multisheet_Download() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        Actions action = new Actions(driver);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement multidownload =driver.findElement(By.xpath("//div//button[text()='MultiSheet Download']")); 
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)", "");
  	  action.moveToElement(multidownload).click(multidownload).build().perform();
       // wait.until(ExpectedConditions.visibilityOfElementLocated(multidownload));
      //  driver.findElement(multidownload).click();


    }
    public void ReviewControl_Download_File( ) throws IOException {
    	Actions action = new Actions(driver);
    	
         WebElement download= driver.findElement(By.xpath("//div//input[@value='Download']"));
         JavascriptExecutor js = (JavascriptExecutor) driver;
          js.executeScript("window.scrollBy(0,500)", "");
    	  action.moveToElement(download).click(download).build().perform();
    	  
    	  By Click_SelectAll = By.xpath("//div//h5[text()='Select all ']//parent::div//input[@type='checkbox'][1]");
    	  driver.findElement(Click_SelectAll).click();
    	  
    	//  String downloadFilepath = System.getProperty("user.dir") + "\\DownloadFile";
   

    	  By Click_Download = By.xpath("//div//button[text()='Download']");
    	  driver.findElement(Click_Download).click();
    	  
    }
    
    public void Intellient_Input_Control_Download_File() throws InterruptedException {
    	 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    	 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(70));
    	WebElement Table_data= driver.findElement(By.xpath("//table//tr//td"));
    	 wait.until(ExpectedConditions.visibilityOfAllElements(Table_data));
    	
    	
    	//Thread.sleep(3000);
         Actions action = new Actions(driver);
    	
        WebElement download= driver.findElement(By.xpath("//div//button[text()='Download']"));
       
        JavascriptExecutor js = (JavascriptExecutor) driver;
         js.executeScript("window.scrollBy(0,500)", "");
   	  action.moveToElement(download).click(download).build().perform();
    	
    }
    	  
     public void Download_File_Validation(String file_name, String File_Rename,String Excel_Type) throws IOException {
    	   
    	    	   String file_location =System.getProperty("user.home") +File.separator+"Downloads"+File.separator+""+file_name+".xlsx";
    	  
    	        	 File f1 = new File(System.getProperty("user.home") +File.separator+"Downloads"+File.separator+"");     
  	         	   f1.mkdirs();  
    	   
    	        long waitTillSeconds = 20000;
  	         	boolean fileDownloaded = false;
          
                File file_path= new File(file_location);  
  	    	//File[] total_files= file_path.listFiles();
		        long waitTillTime = Instant.now().toEpochMilli() + waitTillSeconds;
  		
  	           while (Instant.now().toEpochMilli() < waitTillTime) {
  		               if(file_path.exists()){
	                    break;
			}else {
				Assert.assertTrue(file_path.exists(),"Test Failed- File is not downloaded");
			}
  		}
  	         DateTimeFormatter dtf = DateTimeFormatter.ofPattern("_yyyy_MM_dd      HH_mm_ss");  
    	      LocalDateTime now = LocalDateTime.now();  
    	     String s = (dtf.format(now));
    	     System.out.println(s);
  	    	 Files.move(file_path, new File(System.getProperty("user.home") +File.separator+"Downloads"+File.separator+"ClientReviewer_folder"+File.separator+""+file_name+""+(File_Rename)+""+s+"."+Excel_Type+""));
  	         //      file_path.delete();
  	    	
  	    	
    	  }



    public void Toaster_message(String Pop_up) throws InterruptedException {

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@id='toast-container'])[1]")));
        String Actual_message = driver.findElement(By.xpath("(//div[@id='toast-container'])[1]")).getText();
        System.out.println(Actual_message);
       // WebElement POP_up = driver.findElement(By.xpath("//div//div[text()='"+Pop_up+"']"));

        Assert.assertEquals(Actual_message,Pop_up,"Test Failed - Value not matched");
      //  Thread.sleep(4000);
       // return Actual_message;


    }
     public void revoke() throws InterruptedException {
    	 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
    	 By revoke=By.xpath("//button[text()='Revoke']");
     	By Yes=By.xpath("//button[text()=' YES ']");
     	wait.until(ExpectedConditions.visibilityOf(driver.findElement(revoke)));
     	changeWaitTime(3);
     	try {
     		Actions action = new Actions(driver);
     		 action.moveToElement(driver.findElement(revoke)).click(driver.findElement(revoke)).build().perform();
     		 Assert.assertTrue(driver.findElement(By.xpath("//button[text()=' YES ']")).isDisplayed(), "Failed To Load Alert Message");
     		 wait.until(ExpectedConditions.visibilityOf(driver.findElement(Yes)));
     		driver.findElement(Yes).click();
     		// wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[contains(text(),'done revoke')]"))));
     		// Assert.assertTrue(driver.findElement(By.xpath("//div[contains(text(),'done revoke')]")).isDisplayed(), "Failed To get revoke pop up message");
     	//	popupwait();
     		 }
     		catch(Exception e) {
     		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
     		 Assert.fail("Revoke  button Not available");
     		}
     	     changeWaitTime(60);
     	     }
    	 
     
public void popupwait() {
   By popup=By.xpath("//div[@class='overlay-container']/div/div");
   WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));
 wait.until(ExpectedConditions.invisibilityOf(driver.findElement(popup)));
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

public void signoff_Revoke(String roles, String countries, String legal_entity, String Paygroups) throws InterruptedException {
	
              Click_On_The_Change_Role_Icon();
              
              Select_The_Particular_CCBU_And_Paygroup(roles, countries, legal_entity, Paygroups);
          
               }

public void Signoff() {
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
    
	  By sign = By.xpath("//button[text()='Sign Off']");
	 By Yes = By.xpath("//button[text()=' YES ']");
	 By alertmessage=By.xpath("//span[text()='Are you sure to SignOff.. There are records waiting for approval!']");
	  By popup=By.xpath("//div[@id='toast-container']/div");
changeWaitTime(2);
	 try {
	 Actions action = new Actions(driver);
	  action.moveToElement(driver.findElement(sign)).click(driver.findElement(sign)).build().perform();
	 changeWaitTime(3);
	  try {
	  wait.until(ExpectedConditions.visibilityOf(driver.findElement(alertmessage)));
	  String text=driver.findElement(alertmessage).getText();
	  System.out.println(text);
	  if(text.equals("Are you sure to SignOff.. There are records waiting for approval!") ) {
	  wait.until(ExpectedConditions.visibilityOf(driver.findElement(Yes)));
	  driver.findElement(Yes).click();
	  wait.until(ExpectedConditions.visibilityOf(driver.findElement(Yes)));
	  driver.findElement(Yes).click();}}
catch(Exception e) {
	  wait.until(ExpectedConditions.visibilityOf(driver.findElement(Yes)));
	 driver.findElement(Yes).click();
	  }
	  loader_wait();
changeWaitTime(100);
	  wait.until(ExpectedConditions.visibilityOf(driver.findElement(popup)));
List<WebElement> toastermessage=driver.findElements(By.xpath("//div[@id='toast-container']/div"));
if(toastermessage.size()>0) {
	 String message= driver.findElement(By.xpath("(//div[@id='toast-container'])[1]")).getText();
	System.out.println(message);
	 if(message.contains("Data Signed Off")) {
	 Assert.assertTrue(true);
	 }
	 else {
		 Assert.assertFalse(true,"Failed:-actual Pop up message not equals");
	 }
	 }
	 
else {
Assert.fail("Failed:-pop up message not shown");
}
	  popupwait();
	  } 
	 catch (Exception e) {
	 Assert.fail("Failed:-Sign off button not visible");
	 }
	  changeWaitTime(60);
	  
}


}



