package TestCases_3_PNC_Maker_Download;

import Custom_Utilities.Base_PNC_Login;
import Custom_Utilities.base.Download_utility;
import ExcelUtils.Excel_Utility_Download;
import Pages_maker.PNC_New_joiner_form;
import Pages_maker.PNC_bank_form_page;
import Pages_maker.PNC_home_page;
import Pages_maker.PNC_time_and_attendance_page;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

public class Download_suite_Maker_Bugfix extends Base_PNC_Login {


    @Test(priority = 1)
    public void tc18_Check_if_the_user_can_able_to_Download_the_New_joiner_form_Bugfix() throws InterruptedException, IOException, AWTException {

        Exception e = new Exception();
        e.fillInStackTrace();
        String methodName = e.getStackTrace()[0].getMethodName();

        PNC_home_page PNC_home_page_calls = new PNC_home_page(driver);
        PNC_New_joiner_form PNC_New_joiner_form_calls = new PNC_New_joiner_form(driver);
        Download_utility Download_utility_calls = new Download_utility(driver);

        String sheet = "Maker";
        String test_case_number = methodName;

        Excel_Utility_Download datas = new Excel_Utility_Download();
        ArrayList data = datas.getData(test_case_number, sheet);

        String role = (String) data.get(1);
        String country = (String) data.get(2);
        String Legal_entities = (String) data.get(3);
        String pay = (String) data.get(4);
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
        PNC_home_page_calls.Select_The_Particular_CCBU_And_Paygroup(role, country, Legal_entities, pay);

        // menu transaction and new joiner form selection
        PNC_home_page_calls.Select_The_Transaction_Tab(menu_selection);

        // new joiner form selection
        PNC_home_page_calls.Select_Form(menu_selection, form_selection);

        // processing month selection
        PNC_New_joiner_form_calls.Select_The_Processing_Month(processing_period);

        //Download Icon click New_joiner in  Maker
        PNC_New_joiner_form_calls.Download_Click();

        //clicking the select all check box New_joiner in  Maker
        PNC_New_joiner_form_calls.Select_All_Check_Box_Click();

        //clicking the download button which shows in the popup New_joiner in  Maker
        PNC_New_joiner_form_calls.Download_Button_Click();

        //Download file check New_joiner in  Maker
        Download_utility_calls.File_Download_Check(Download_File_name,Folder_name,File_Rename,file_extension);

    }

    @Test(priority = 2)
    public void tc64_Check_if_the_user_can_able_to_Download_in_Bank_Form_page_Bugfix() throws InterruptedException, IOException, AWTException {

        PNC_home_page PNC_home_page_calls = new PNC_home_page(driver);
        PNC_bank_form_page PNC_bank_form_page_calls = new PNC_bank_form_page(driver);
        Download_utility Download_utility_calls = new Download_utility(driver);

        Exception e = new Exception();
        e.fillInStackTrace();
        String methodName = e.getStackTrace()[0].getMethodName();

        String sheet = "Maker";
        String test_case_number = methodName;

        Excel_Utility_Download datas = new Excel_Utility_Download();
        ArrayList data = datas.getData(test_case_number, sheet);

        String role = (String) data.get(1);
        String country = (String) data.get(2);
        String Legal_entities = (String) data.get(3);
        String pay = (String) data.get(4);
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
        PNC_bank_form_page_calls.Select_Input_Received_In_Month(processing_period);

        //Download Icon click Bank_Form in  Maker
        PNC_bank_form_page_calls.Download_Click();

        //clicking the select all check box Bank_Form in  Maker
        PNC_bank_form_page_calls.Select_All_Check_Box_Click();

        //clicking the download button which shows in the popup Bank_Form in  Maker
        PNC_bank_form_page_calls.Download_Button_Click();

        //Download file check Bank_Form in  Maker
        Download_utility_calls.File_Download_Check(Download_File_name,Folder_name,File_Rename,file_extension);

    }

    @Test(priority = 3)
    public void tc41_Check_if_the_user_can_able_to_Download_in_Business_Form_Time_and_Attendance_page_Bugfix()
            throws InterruptedException, IOException, AWTException {

        PNC_home_page PNC_home_page_calls = new PNC_home_page(driver);
        PNC_time_and_attendance_page PNC_time_and_attendance_page_calls = new PNC_time_and_attendance_page(driver);
        Download_utility Download_utility_calls = new Download_utility(driver);

        Exception e = new Exception();
        e.fillInStackTrace();
        String methodName = e.getStackTrace()[0].getMethodName();

        String sheet = "Maker";
        String test_case_number = methodName;

        Excel_Utility_Download datas = new Excel_Utility_Download();
        ArrayList data = datas.getData(test_case_number, sheet);

        String role = (String) data.get(1);
        String country = (String) data.get(2);
        String Legal_entities = (String) data.get(3);
        String pay = (String) data.get(4);
        String menu_selection = (String) data.get(5);
        String form_selection = (String) data.get(6);
        String processing_period = (String) data.get(7);

        String Download_File_name = (String) data.get(8);
        String Folder_name = (String) data.get(9);
        String File_Rename = (String) data.get(10);
        String file_extension = (String) data.get(11);



        // menu transaction and new joiner form selection
        PNC_home_page_calls.Select_The_Transaction_Tab(menu_selection);

        PNC_home_page_calls.Page_Up();

        // new joiner form selection
        PNC_home_page_calls.Select_Form(menu_selection, form_selection);

        // processing month selection
        PNC_time_and_attendance_page_calls.Select_The_Processing_Month(processing_period);

        //Download Icon click Time_and_Attendance in  Maker
        PNC_time_and_attendance_page_calls.Download_Click();

        //clicking the select all check box Time_and_Attendance in  Maker
        PNC_time_and_attendance_page_calls.Select_All_Check_Box_Click();

        //clicking the download button which shows in the popup Time_and_Attendance in  Maker
        PNC_time_and_attendance_page_calls.Download_Button_Click();

        //Download file check Time_and_Attendance in  Maker
        Download_utility_calls.File_Download_Check(Download_File_name,Folder_name,File_Rename,file_extension);



    }

}
