package TestCases_3_PNC_Client_Reviewer_Download;

import Custom_Utilities.Base_PNC_Login;
import Custom_Utilities.base.Download_Utility_Client_Reviewer;
import ExcelUtils.Excel_Utility_Download;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;

public class Download_Suite_Client_Reviewer_Bugfix extends Base_PNC_Login {


    @Test(priority = 1)
    public void TC04_Verify_if_the_user_able_to_download_the_New_Joiner_Records_form_in_the_Client_Reviewer_Role_Bugfix() throws InterruptedException, IOException {
        Download_Utility_Client_Reviewer download_utility = new Download_Utility_Client_Reviewer(driver);

        String testcase_name = new Exception()
                .getStackTrace()[0]
                .getMethodName();
        System.out.println(testcase_name);


        String sheet = "Client_Reviewer_Bugfix";
        String test_case_number = testcase_name;

        Excel_Utility_Download datas = new Excel_Utility_Download();
        ArrayList data = datas.getData(test_case_number, sheet);

        String role = (String) data.get(1);
        String country = (String) data.get(2);
        String Legal_entity = (String) data.get(3);
        String paygroup = (String) data.get(4);
        String Transaction = (String) data.get(5);
        String Newjoiner = (String) data.get(6);
        String ProcessingPeriod = (String) data.get(7);
        String file_name = (String) data.get(8);
        String File_Rename = (String) data.get(9);
        String Extension = (String) data.get(10);
        String Folder_Name = (String) data.get(11);

        //Select change role icon
        PNC_home_page.Click_On_The_Change_Role_Icon();

        //selection country,paygroup and legal entity
        PNC_home_page.Select_The_Particular_CCBU_And_Paygroup(role, country, Legal_entity, paygroup);

        //Select menu and form
        PNC_transaction.Transaction_Click(Transaction, Newjoiner);

        //Select processing period(current month)
        PNC_transaction.ProcessingPeriod_click(ProcessingPeriod);

        //click on download file for new joiner in client reviewer(current month)
        PNC_transaction.Transaction_Download_File();

        //download file validation for new joiner in client reviewer
        download_utility.Download_File_Validation(file_name, File_Rename, Extension, Folder_Name);


    }


    @Test(priority = 2)
    public void TC05_Verify_if_the_user_able_to_download_the_New_Joiner_Records_form_for_Future_Processing_period_in_the_Client_Reviewer_Role_Bugfix() throws InterruptedException, IOException {


        Download_Utility_Client_Reviewer download_utility = new Download_Utility_Client_Reviewer(driver);
        String testcase_name = new Exception()
                .getStackTrace()[0]
                .getMethodName();
        System.out.println(testcase_name);


        String sheet = "Client_Reviewer_Bugfix";
        String test_case_number = testcase_name;

        Excel_Utility_Download datas = new Excel_Utility_Download();
        ArrayList data = datas.getData(test_case_number, sheet);

        String role = (String) data.get(1);
        String country = (String) data.get(2);
        String Legal_entity = (String) data.get(3);
        String paygroup = (String) data.get(4);
        String Transaction = (String) data.get(5);
        String Newjoiner = (String) data.get(6);
        String ProcessingPeriod = (String) data.get(7);
        String file_name = (String) data.get(8);
        String File_Rename = (String) data.get(9);
        String Extension = (String) data.get(10);
        String Folder_Name = (String) data.get(11);

        //Select change role icon
        PNC_home_page.Click_On_The_Change_Role_Icon();

        //selection country,paygroup and legal entity
        PNC_home_page.Select_The_Particular_CCBU_And_Paygroup(role, country, Legal_entity, paygroup);

        //Select menu and form
        PNC_transaction.Transaction_Click(Transaction, Newjoiner);

        //Select processing period
        PNC_transaction.ProcessingPeriod_click(ProcessingPeriod);

        //Click on download file
        PNC_transaction.Transaction_Download_File();

        //download file valodation
        download_utility.Download_File_Validation(file_name, File_Rename, Extension, Folder_Name);


    }


    @Test(priority = 3)
    public void TC08_Verify_if_the_user_able_to_download_the_Time_and_Attendance_in_the_Client_Reviewer_Role_Bugfix() throws InterruptedException, IOException {
        Download_Utility_Client_Reviewer download_utility = new Download_Utility_Client_Reviewer(driver);

        String testcase_name = new Exception()
                .getStackTrace()[0]
                .getMethodName();
        System.out.println(testcase_name);


        String sheet = "Client_Reviewer_Bugfix";
        String test_case_number = testcase_name;

        Excel_Utility_Download datas = new Excel_Utility_Download();
        ArrayList data = datas.getData(test_case_number, sheet);

        String role = (String) data.get(1);
        String country = (String) data.get(2);
        String Legal_entity = (String) data.get(3);
        String paygroup = (String) data.get(4);
        String Transaction = (String) data.get(5);
        String Newjoiner = (String) data.get(6);
        String ProcessingPeriod = (String) data.get(7);
        String file_name = (String) data.get(8);
        String File_Rename = (String) data.get(9);
        String Extension = (String) data.get(10);
        String Folder_Name = (String) data.get(11);


        //Select change role icon
        PNC_home_page.Click_On_The_Change_Role_Icon();

        //selection country,paygroup and legal entity
        PNC_home_page.Select_The_Particular_CCBU_And_Paygroup(role, country, Legal_entity, paygroup);

        //select menu and form
        PNC_transaction.Transaction_Click(Transaction, Newjoiner);

        //select processing period
        PNC_transaction.ProcessingPeriod_click(ProcessingPeriod);

        //click on download file
        PNC_transaction.Transaction_Download_File();

        //download file validation
        download_utility.Download_File_Validation(file_name, File_Rename, Extension, Folder_Name);


    }

    @Test(priority = 4)
    public void TC09_Verify_if_the_user_able_to_download_the_Time_and_Attendance_for_Future_Processing_Period_in_the_Client_Reviewer_Role_Bugfix() throws InterruptedException, IOException {
        Download_Utility_Client_Reviewer download_utility = new Download_Utility_Client_Reviewer(driver);


        String testcase_name = new Exception()
                .getStackTrace()[0]
                .getMethodName();
        System.out.println(testcase_name);


        String sheet = "Client_Reviewer_Bugfix";
        String test_case_number = testcase_name;

        Excel_Utility_Download datas = new Excel_Utility_Download();
        ArrayList data = datas.getData(test_case_number, sheet);

        String role = (String) data.get(1);
        String country = (String) data.get(2);
        String Legal_entity = (String) data.get(3);
        String paygroup = (String) data.get(4);
        String Transaction = (String) data.get(5);
        String Newjoiner = (String) data.get(6);
        String ProcessingPeriod = (String) data.get(7);
        String file_name = (String) data.get(8);
        String File_Rename = (String) data.get(9);
        String Extension = (String) data.get(10);
        String Folder_Name = (String) data.get(11);

        //Select change role icon
        PNC_home_page.Click_On_The_Change_Role_Icon();

        //selection country,paygroup and legal entity
        PNC_home_page.Select_The_Particular_CCBU_And_Paygroup(role, country, Legal_entity, paygroup);

        //Select menu and form
        PNC_transaction.Transaction_Click(Transaction, Newjoiner);

        //Select processing period
        PNC_transaction.ProcessingPeriod_click(ProcessingPeriod);

        //click on download file
        PNC_transaction.Transaction_Download_File();

        //download file validation
        download_utility.Download_File_Validation(file_name, File_Rename, Extension, Folder_Name);


    }

    @Test(priority = 5)
    public void TC11_Verify_if_the_user_able_to_download_the_Bank_Form_in_the_Client_Reviewer_Role_Bugfix() throws InterruptedException, IOException {
        Download_Utility_Client_Reviewer download_utility = new Download_Utility_Client_Reviewer(driver);


        String testcase_name = new Exception()
                .getStackTrace()[0]
                .getMethodName();
        System.out.println(testcase_name);


        String sheet = "Client_Reviewer_Bugfix";
        String test_case_number = testcase_name;

        Excel_Utility_Download datas = new Excel_Utility_Download();
        ArrayList data = datas.getData(test_case_number, sheet);

        String role = (String) data.get(1);
        String country = (String) data.get(2);
        String Legal_entity = (String) data.get(3);
        String paygroup = (String) data.get(4);
        String Transaction = (String) data.get(5);
        String Newjoiner = (String) data.get(6);
        String file_name = (String) data.get(8);
        String File_Rename = (String) data.get(9);
        String Extension = (String) data.get(10);
        String Folder_Name = (String) data.get(11);

        //Select change role icon
        PNC_home_page.Click_On_The_Change_Role_Icon();

        //selection country,paygroup and legal entity
        PNC_home_page.Select_The_Particular_CCBU_And_Paygroup(role, country, Legal_entity, paygroup);

        //select menu and form
        PNC_transaction.Transaction_Click(Transaction, Newjoiner);

        //click on download file
        PNC_transaction.Transaction_Download_File();

        //download file validation
        download_utility.Download_File_Validation(file_name, File_Rename, Extension, Folder_Name);


    }


    @Test(priority = 6)
    public void TC15_Verify_if_the_user_able_to_Download_the_Approved_records_for_New_Joiner_form_in_the_Intelligent_Input_Control_Tab_Bugfix() throws InterruptedException, IOException {

        Download_Utility_Client_Reviewer download_utility = new Download_Utility_Client_Reviewer(driver);

        String testcase_name = new Exception()
                .getStackTrace()[0]
                .getMethodName();
        System.out.println(testcase_name);


        String sheet = "Client_Reviewer_Bugfix";
        String test_case_number = testcase_name;

        Excel_Utility_Download datas = new Excel_Utility_Download();
        ArrayList data = datas.getData(test_case_number, sheet);

        String role = (String) data.get(1);
        String country = (String) data.get(2);
        String Legal_entity = (String) data.get(3);
        String paygroup = (String) data.get(4);
        String reviewcontrol = (String) data.get(5);
        String IntelligentInput = (String) data.get(6);
        String processingClick = (String) data.get(7);
        String NewJoiner = (String) data.get(14);
        String fromdate = (String) data.get(12);
        String todate = (String) data.get(13);
        String file_name = (String) data.get(8);
        String File_Rename = (String) data.get(9);
        String Extension = (String) data.get(10);
        String Folder_Name = (String) data.get(11);

        //click change role icon
        PNC_home_page.Click_On_The_Change_Role_Icon();

        //selection country,paygroup and legal entity
        PNC_home_page.Select_The_Particular_CCBU_And_Paygroup(role, country, Legal_entity, paygroup);

        //select reviewcontrol Form
        PNC_reviewcontrol.ReviewControl_Click(reviewcontrol, IntelligentInput);

        //Select processing period
        PNC_reviewcontrol.Processing_Click(processingClick);

        //this method used to select newjoiner
        PNC_reviewcontrol.Approved_Record_click(NewJoiner);

        //Select  from date
        PNC_reviewcontrol.From_date(fromdate);

        //Select to date
        PNC_reviewcontrol.To_date(todate);

        //Select Intellient input control download file
        PNC_reviewcontrol.Intellient_Input_Control_Download_File();

        //download file validation
        download_utility.Download_File_Validation(file_name, File_Rename, Extension, Folder_Name);

    }


    @Test(priority = 7)
    public void TC18_Check_if_the_User_able_to_click_the_Multisheet_Download_Button_Before_Generate_the_Data_Bugfix() throws InterruptedException, IOException {


        Download_Utility_Client_Reviewer download_utility = new Download_Utility_Client_Reviewer(driver);
        String testcase_name = new Exception()
                .getStackTrace()[0]
                .getMethodName();
        System.out.println(testcase_name);


        String sheet = "Client_Reviewer_Bugfix";
        String test_case_number = testcase_name;

        Excel_Utility_Download datas = new Excel_Utility_Download();
        ArrayList data = datas.getData(test_case_number, sheet);

        String role = (String) data.get(1);
        String country = (String) data.get(2);
        String Legal_entity = (String) data.get(3);
        String paygroup = (String) data.get(4);
        String Transaction = (String) data.get(5);
        String Newjoiner = (String) data.get(6);
        String ProcessingPeriod = (String) data.get(7);
        String file_name = (String) data.get(8);
        String File_Rename = (String) data.get(9);
        String Extension = (String) data.get(10);
        String Folder_Name = (String) data.get(11);

        //Select Change role icon
        PNC_home_page.Click_On_The_Change_Role_Icon();

        //selection country,paygroup and legal entity
        PNC_home_page.Select_The_Particular_CCBU_And_Paygroup(role, country, Legal_entity, paygroup);

        //Select Transaction form
        PNC_transaction.Transaction_Click(Transaction, Newjoiner);

        //Select processing period
        PNC_reviewcontrol.Processing_Click(ProcessingPeriod);

        //Select multisheet download
        PNC_reviewcontrol.Multisheet_Download();

        //download file check
        download_utility.Download_File_Validation(file_name, File_Rename, Extension, Folder_Name);


    }

    @Test(priority = 8)
    public void TC19_Check_if_the_User_able_to_select_the_particular_Processing_Period_Processing_For_PayRun_Type_and_Click_the_Multisheet_Download_Bugfix() throws InterruptedException, IOException {

        Download_Utility_Client_Reviewer download_utility = new Download_Utility_Client_Reviewer(driver);


        String testcase_name = new Exception()
                .getStackTrace()[0]
                .getMethodName();
        System.out.println(testcase_name);


        String sheet = "Client_Reviewer_Bugfix";
        String test_case_number = testcase_name;
        Excel_Utility_Download datas = new Excel_Utility_Download();
        ArrayList data = datas.getData(test_case_number, sheet);

        String role = (String) data.get(1);
        String country = (String) data.get(2);
        String Legal_entity = (String) data.get(3);
        String paygroup = (String) data.get(4);
        String Transaction = (String) data.get(5);
        String Newjoiner = (String) data.get(6);
        String ProcessingPeriod = (String) data.get(7);
        String file_name = (String) data.get(8);
        String File_Rename = (String) data.get(9);
        String Extension = (String) data.get(10);
        String Folder_Name = (String) data.get(11);

        PNC_transaction.loader_wait();

        //Select Change role icon
        PNC_home_page.Click_On_The_Change_Role_Icon();

        //selection country,paygroup and legal entity
        PNC_home_page.Select_The_Particular_CCBU_And_Paygroup(role, country, Legal_entity, paygroup);

        //Select Transaction Form
        PNC_transaction.Transaction_Click(Transaction, Newjoiner);

        //Select processing Period
        PNC_reviewcontrol.Processing_Click(ProcessingPeriod);

        //Select multisheet download
        PNC_reviewcontrol.Multisheet_Download();

        //Download utility
        download_utility.Download_File_Validation(file_name, File_Rename, Extension, Folder_Name);


    }


}
