package Custom_Utilities.base;

import com.google.common.io.Files;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.io.File;
import java.io.IOException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Download_Utility_Client_Reviewer {



    public WebDriver driver;

    public Download_Utility_Client_Reviewer(WebDriver driver) {
        this.driver = driver;
    }

    public void Download_File_Validation(String file_name, String File_Rename, String Extension, String Folder_Name) throws IOException {

        String file_location = System.getProperty("user.home") + File.separator + "Downloads" + File.separator + "" + file_name + ".xlsx";

        File f1 = new File(System.getProperty("user.home") + File.separator + "Downloads" + File.separator + "" + Folder_Name + "");
        f1.mkdirs();

        long waitTillSeconds = 20000;
        boolean fileDownloaded = false;

        File file_path = new File(file_location);
        long waitTillTime = Instant.now().toEpochMilli() + waitTillSeconds;

        while (Instant.now().toEpochMilli() < waitTillTime) {
            if (file_path.exists()) {
                Assert.assertTrue(file_path.exists(), "Test Failed - File not Found");
                break;
            }

        }
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("_yyyy_MM_dd    HH_mm_ss");
        LocalDateTime now = LocalDateTime.now();
        String s = (dtf.format(now));
        System.out.println(s);
        Files.move(file_path, new File(System.getProperty("user.home") + File.separator + "Downloads" + File.separator + "" + Folder_Name + "" + File.separator + "" + File_Rename + "" + s + "." + Extension + ""));
    }


}
