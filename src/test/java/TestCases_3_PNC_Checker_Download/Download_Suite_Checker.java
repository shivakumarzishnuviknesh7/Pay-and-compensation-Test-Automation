package TestCases_3_PNC_Checker_Download;

import Custom_Utilities.Base_PNC_Login;
import Custom_Utilities.base.Download_utility;
import ExcelUtils.Excel_Utility_Download;
import Pages_Checker.PNC_Bank_form;
import Pages_Checker.PNC_New_Joiner_Form;
import Pages_Checker.PNC_Time_and_Attendance_Page;
import Pages_Checker.PNC_home_page;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

public class Download_Suite_Checker extends Base_PNC_Login {

    @Test(priority = 1)
    public void tc16_Check_if_the_user_able_to_download_and_view_all_the_records_for_New_joiner_Form() throws InterruptedException, IOException, AWTException {

        Exception e = new Exception();
        e.fillInStackTrace();
        String methodName = e.getStackTrace()[0].getMethodName();

        PNC_home_page PNC_home_page_calls = new PNC_home_page(driver);
        PNC_New_Joiner_Form PNC_New_Joiner_Form_calls = new PNC_New_Joiner_Form(driver);
        Download_utility Download_utility_calls = new Download_utility(driver);

        String sheet = "Checker";
        String test_case_number = methodName;

        Excel_Utility_Download datas = new Excel_Utility_Download();
        ArrayList data = datas.getData(test_case_number, sheet);

        String role = (String) data.get(1);
        String country = (String) data.get(2);
        String Legal_entity = (String) data.get(3);
        String pay_group = (String) data.get(4);
        String menu_selection = (String) data.get(5);
        String form_selection = (String) data.get(6);
        String processing_period = (String) data.get(7);

        String Download_File_name = (String) data.get(8);
        String Folder_name = (String) data.get(9);
        String File_Rename = (String) data.get(10);
        String file_extension = (String) data.get(11);

        // clicking change role icon
        PNC_home_page_calls.Click_On_The_Change_Role_Icon();

        // selection country, paygroup and legal entity
        PNC_home_page_calls.Select_The_Particular_CCBU_And_Paygroup(role, country, Legal_entity, pay_group);

        // menu transaction and new joiner form selection
        PNC_home_page_calls.Select_The_Transaction_Tab(menu_selection);

        // new joiner form selection
        PNC_home_page_calls.Select_Form(menu_selection, form_selection);

        // processing month selection
        PNC_New_Joiner_Form_calls.Select_The_Processing_Month(processing_period);

        //Download Icon click New_Joiner_Form in Checker
        PNC_New_Joiner_Form_calls.Download_Click();

        //clicking the select all check box New_Joiner_Form in Checker
        PNC_New_Joiner_Form_calls.Select_All_Check_Box_Click();

        //clicking the download button which shows in the popup New_Joiner_Form in Checker
        PNC_New_Joiner_Form_calls.Download_Button_Click();

        //Download file check New_Joiner_Form in Checker
        Download_utility_calls.File_Download_Check(Download_File_name, Folder_name, File_Rename,  file_extension);

    }

    @Test(priority = 2)
    public void tc41_Check_if_the_user_able_to_download_and_view_all_the_records_for_Bank_Form() throws InterruptedException, IOException, AWTException {

        Exception e = new Exception();
        e.fillInStackTrace();
        String methodName = e.getStackTrace()[0].getMethodName();

        PNC_home_page PNC_home_page_calls = new PNC_home_page(driver);
        PNC_Bank_form PNC_Bank_form_calls = new PNC_Bank_form(driver);
        Download_utility Download_utility_calls = new Download_utility(driver);

        String sheet = "Checker";
        String test_case_number = methodName;

        Excel_Utility_Download datas = new Excel_Utility_Download();
        ArrayList data = datas.getData(test_case_number, sheet);

        //String role = (String) data.get(1);
        //String country = (String) data.get(2);
        //String Legal_entities = (String) data.get(3);
        //String pay = (String) data.get(4);
        String menu_selection = (String) data.get(5);
        String form_selection = (String) data.get(6);
        String processing_period = (String) data.get(7);
        String Download_File_name = (String) data.get(8);
        String Folder_name = (String) data.get(9);
        String File_Rename = (String) data.get(10);
        String file_extension = (String) data.get(11);


        // new joiner form selection
        PNC_home_page_calls.Select_Form(menu_selection, form_selection);

        // processing month selection
        PNC_Bank_form_calls.Select_Input_Received_In_Month(processing_period);

        //Download Icon click Bank_Form in  Checker
        PNC_Bank_form_calls.Download_Click();

        //clicking the select all check box Bank_Form in  Checker
        PNC_Bank_form_calls.Select_All_Check_Box_Click();

        //clicking the download button which shows in the popup Bank_Form in  Checker
        PNC_Bank_form_calls.Download_Button_Click();

        //Download file check Bank_Form in  Checker
        Download_utility_calls.File_Download_Check(Download_File_name, Folder_name, File_Rename, file_extension);

    }

    @Test(priority = 3)
    public void tc29_Check_if_the_user_able_to_download_and_view_all_the_records_for_Time_and_Attendance() throws InterruptedException, IOException, AWTException {


        Exception e = new Exception();
        e.fillInStackTrace();
        String methodName = e.getStackTrace()[0].getMethodName();

        PNC_home_page PNC_home_page_calls = new PNC_home_page(driver);
        PNC_Time_and_Attendance_Page PNC_Time_and_Attendance_Page_calls = new PNC_Time_and_Attendance_Page(driver);
        Download_utility Download_utility_calls = new Download_utility(driver);

        String sheet = "Checker";
        String test_case_number = methodName;

        Excel_Utility_Download datas = new Excel_Utility_Download();
        ArrayList data = datas.getData(test_case_number, sheet);

        //String role = (String) data.get(1);
        //String country = (String) data.get(2);
        //String Legal_entities = (String) data.get(3);
        //String pay = (String) data.get(4);
        String menu_selection = (String) data.get(5);
        String form_selection = (String) data.get(6);
        String processing_period = (String) data.get(7);
        String Download_File_name = (String) data.get(8);
        String Folder_name = (String) data.get(9);
        String File_Rename = (String) data.get(10);
        String file_extension = (String) data.get(11);


        // menu transaction and new joiner form selection
        PNC_home_page_calls.Select_The_Transaction_Tab(menu_selection);

        //page up is used to go up
        PNC_home_page_calls.Page_Up();

        // new joiner form selection
        PNC_home_page_calls.Select_Form(menu_selection, form_selection);

        // processing month selection
        PNC_Time_and_Attendance_Page_calls.Select_The_Processing_Month(processing_period);

        //Download Icon click Time_And_Attendance_Form in  Checker
        PNC_Time_and_Attendance_Page_calls.Download_Click();

        //clicking the select all check box Time_And_Attendance_Form in  Checker
        PNC_Time_and_Attendance_Page_calls.Select_All_Check_Box_Click();

        //clicking the download button which shows in the popup Time_And_Attendance_Form in  Checker
        PNC_Time_and_Attendance_Page_calls.Download_Button_Click();

        //Download file check Time_And_Attendance_Form in  Checker
        Download_utility_calls.File_Download_Check(Download_File_name, Folder_name, File_Rename, file_extension);


    }


}
