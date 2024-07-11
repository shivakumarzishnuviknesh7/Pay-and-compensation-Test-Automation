package Pages_Checker;

import ExcelUtils.Excel_Utility_Checker;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;


public class Data_Excel_Upload {

    public WebDriver driver;

    public Data_Excel_Upload(org.openqa.selenium.WebDriver driver) {
        this.driver = driver;
    }

    /*
     * new joiner
     * */
    public String current_processing_month = "New joiner form current processing month data upload.xlsx";
    public String future_processing_month = "New joiner form future processing month data upload.xlsx";
    public String pre_future_processing_months = "New joiner form pre future month data upload.xlsx";

    //Bank
    public String current_processing_month_Bank = "Regression Test 1.0_Egypt_NE-RT1.0_Bank Form.xlsx";

    //time and attendance
    public String current_processing_month_time_and_attendance = "Regression Test 1.0_Egypt_NE-RT1.0_Time and Attendance.xlsx";

@Test
    public void data_upload_New_joiner_form_current_processing_month() throws InterruptedException, IOException {

        PNC_home_page PNC_home_page_calls = new PNC_home_page(driver);
        File_Upload File_Upload_calls = new File_Upload(driver);


        Exception e = new Exception();
        e.fillInStackTrace();
        String methodName = e.getStackTrace()[0].getMethodName();

        String sheet = "data_upload_sheet";
        String test_case_number = methodName;

        Excel_Utility_Checker datas = new Excel_Utility_Checker();
        ArrayList data = datas.getData(test_case_number, sheet);

        String role = (String) data.get(1);
        String country = (String) data.get(2);
        String Legal_entities = (String) data.get(3);
        String pay = (String) data.get(4);
        String menu_selection = (String) data.get(5);
        String form_selection = (String) data.get(6);
        String processing_period_current = (String) data.get(7);
        String template = (String) data.get(8);


        //clicking change role icon
        PNC_home_page_calls.Click_On_The_Change_Role_Icon();

        //selection country,paygroup and legal entity
        PNC_home_page_calls.Select_The_Particular_CCBU_And_Paygroup(role, country, Legal_entities, pay);

        //menu transaction and new joiner form selection
        PNC_home_page_calls.Select_The_Transaction_Tab(menu_selection);

        //new joiner form selection
        PNC_home_page_calls.Select_Form_data_Upload(menu_selection, form_selection);

        //new joiner data adding current_processing_month

        File_Upload_calls.Template_Name(template);

        File_Upload_calls.Processing_period_New_Joiner(processing_period_current);

        File_Upload_calls.Attach_file_upload(current_processing_month);

        File_Upload_calls.Upload_Click();

        File_Upload_calls.Loader_Wait2();
    }


    public void data_upload_New_joiner_form_future_processing_month() throws InterruptedException, IOException {

        PNC_home_page PNC_home_page_calls = new PNC_home_page(driver);
        File_Upload File_Upload_calls = new File_Upload(driver);

        Exception e = new Exception();
        e.fillInStackTrace();
        String methodName = e.getStackTrace()[0].getMethodName();

        String sheet = "data_upload_sheet";
        String test_case_number = methodName;

        Excel_Utility_Checker datas = new Excel_Utility_Checker();
        ArrayList data = datas.getData(test_case_number, sheet);

        String role = (String) data.get(1);
        String country = (String) data.get(2);
        String Legal_entities = (String) data.get(3);
        String pay = (String) data.get(4);
        String menu_selection = (String) data.get(5);
        String form_selection = (String) data.get(6);
        String processing_period_current = (String) data.get(7);
        String template = (String) data.get(8);


        //clicking change role icon
        PNC_home_page_calls.Click_On_The_Change_Role_Icon();

        //selection country,paygroup and legal entity
        PNC_home_page_calls.Select_The_Particular_CCBU_And_Paygroup(role, country, Legal_entities, pay);

        //menu transaction and new joiner form selection
        PNC_home_page_calls.Select_The_Transaction_Tab(menu_selection);

        //new joiner form selection
        PNC_home_page_calls.Select_Form_data_Upload(menu_selection, form_selection);

        //new joiner data future_processing_month

        File_Upload_calls.Template_Name(template);

        File_Upload_calls.Processing_period_New_Joiner(processing_period_current);

        File_Upload_calls.Attach_file_upload(future_processing_month);

        File_Upload_calls.Upload_Click();

        File_Upload_calls.Loader_Wait2();
    }

    public void data_upload_New_joiner_form_pre_future_processing_month() throws InterruptedException, IOException {

        PNC_home_page PNC_home_page_calls = new PNC_home_page(driver);
        File_Upload File_Upload_calls = new File_Upload(driver);

        Exception e = new Exception();
        e.fillInStackTrace();
        String methodName = e.getStackTrace()[0].getMethodName();

        String sheet = "data_upload_sheet";
        String test_case_number = methodName;

        Excel_Utility_Checker datas = new Excel_Utility_Checker();
        ArrayList data = datas.getData(test_case_number, sheet);

        String role = (String) data.get(1);
        String country = (String) data.get(2);
        String Legal_entities = (String) data.get(3);
        String pay = (String) data.get(4);
        String menu_selection = (String) data.get(5);
        String form_selection = (String) data.get(6);
        String processing_period_current = (String) data.get(7);
        String template = (String) data.get(8);


        //clicking change role icon
        PNC_home_page_calls.Click_On_The_Change_Role_Icon();

        //selection country,paygroup and legal entity
        PNC_home_page_calls.Select_The_Particular_CCBU_And_Paygroup(role, country, Legal_entities, pay);

        //menu transaction and new joiner form selection
        PNC_home_page_calls.Select_The_Transaction_Tab(menu_selection);

        //new joiner form selection
        PNC_home_page_calls.Select_Form_data_Upload(menu_selection, form_selection);


        //new joiner data pre future month

        File_Upload_calls.Template_Name(template);

        File_Upload_calls.Processing_period_New_Joiner(processing_period_current);

        File_Upload_calls.Attach_file_upload(pre_future_processing_months);

        File_Upload_calls.Upload_Click();

        File_Upload_calls.Loader_Wait2();
    }





    /*
     *
     * Bank
     *
     * */
    @Test

    public void data_upload_Bank_form_current_processing_month() throws InterruptedException, IOException {

        PNC_home_page PNC_home_page_calls = new PNC_home_page(driver);
        File_Upload File_Upload_calls = new File_Upload(driver);


        Exception e = new Exception();
        e.fillInStackTrace();
        String methodName = e.getStackTrace()[0].getMethodName();

        String sheet = "data_upload_sheet";
        String test_case_number = methodName;

        Excel_Utility_Checker datas = new Excel_Utility_Checker();
        ArrayList data = datas.getData(test_case_number, sheet);

        String role = (String) data.get(1);
        String country = (String) data.get(2);
        String Legal_entities = (String) data.get(3);
        String pay = (String) data.get(4);
        String menu_selection = (String) data.get(5);
        String form_selection = (String) data.get(6);
        String processing_period_current = (String) data.get(7);
        String template = (String) data.get(8);


        //clicking change role icon
        PNC_home_page_calls.Click_On_The_Change_Role_Icon();

        //selection country,paygroup and legal entity
        PNC_home_page_calls.Select_The_Particular_CCBU_And_Paygroup(role, country, Legal_entities, pay);

        //menu transaction and new joiner form selection
        PNC_home_page_calls.Select_The_Transaction_Tab(menu_selection);

        //new joiner form selection
        PNC_home_page_calls.Select_Form_data_Upload(menu_selection, form_selection);

        //new joiner data adding current_processing_month
        File_Upload_calls.Template_Name(template);

        //File_Upload_calls.Processing_period_New_Joiner(processing_period_current);

        File_Upload_calls.Attach_file_upload(current_processing_month_Bank);

        File_Upload_calls.Upload_Click();

        File_Upload_calls.Loader_Wait2();
    }

    /*
     *
     * Time and attendance
     *
     * */


    public void data_upload_Time_And_Attendance_form_current_processing_month() throws InterruptedException, IOException {

        PNC_home_page PNC_home_page_calls = new PNC_home_page(driver);
        File_Upload File_Upload_calls = new File_Upload(driver);


        Exception e = new Exception();
        e.fillInStackTrace();
        String methodName = e.getStackTrace()[0].getMethodName();

        String sheet = "data_upload_sheet";
        String test_case_number = methodName;

        Excel_Utility_Checker datas = new Excel_Utility_Checker();
        ArrayList data = datas.getData(test_case_number, sheet);

        String role = (String) data.get(1);
        String country = (String) data.get(2);
        String Legal_entities = (String) data.get(3);
        String pay = (String) data.get(4);
        String menu_selection = (String) data.get(5);
        String form_selection = (String) data.get(6);
        String processing_period_current = (String) data.get(7);
        String template = (String) data.get(8);

        //clicking change role icon
        PNC_home_page_calls.Click_On_The_Change_Role_Icon();

        //selection country,paygroup and legal entity
        PNC_home_page_calls.Select_The_Particular_CCBU_And_Paygroup(role, country, Legal_entities, pay);

        //menu transaction and new joiner form selection
        PNC_home_page_calls.Select_The_Transaction_Tab(menu_selection);

        //new joiner form selection
        PNC_home_page_calls.Select_Form_data_Upload(menu_selection, form_selection);

        //new joiner data adding current_processing_month

        File_Upload_calls.Template_Name(template);

        File_Upload_calls.Processing_period_New_Joiner(processing_period_current);

        File_Upload_calls.Attach_file_upload(current_processing_month_time_and_attendance);

        File_Upload_calls.Upload_Click();

        File_Upload_calls.Loader_Wait2();
    }


    public void data_upload_Time_And_Attendance_form_future_processing_month() throws InterruptedException, IOException {

        PNC_home_page PNC_home_page_calls = new PNC_home_page(driver);
        File_Upload File_Upload_calls = new File_Upload(driver);

        Exception e = new Exception();
        e.fillInStackTrace();
        String methodName = e.getStackTrace()[0].getMethodName();

        String sheet = "data_upload_sheet";
        String test_case_number = methodName;

        Excel_Utility_Checker datas = new Excel_Utility_Checker();
        ArrayList data = datas.getData(test_case_number, sheet);

        String role = (String) data.get(1);
        String country = (String) data.get(2);
        String Legal_entities = (String) data.get(3);
        String pay = (String) data.get(4);
        String menu_selection = (String) data.get(5);
        String form_selection = (String) data.get(6);
        String processing_period_current = (String) data.get(7);
        String template = (String) data.get(8);


        //clicking change role icon
        PNC_home_page_calls.Click_On_The_Change_Role_Icon();

        //selection country,paygroup and legal entity
        PNC_home_page_calls.Select_The_Particular_CCBU_And_Paygroup(role, country, Legal_entities, pay);

        //menu transaction and new joiner form selection
        PNC_home_page_calls.Select_The_Transaction_Tab(menu_selection);

        //new joiner form selection
        PNC_home_page_calls.Select_Form_data_Upload(menu_selection, form_selection);

        //new joiner data future_processing_month

        File_Upload_calls.Template_Name(template);

        File_Upload_calls.Processing_period_New_Joiner(processing_period_current);

        File_Upload_calls.Attach_file_upload(current_processing_month_time_and_attendance);

        File_Upload_calls.Upload_Click();

        File_Upload_calls.Loader_Wait2();
    }


}

