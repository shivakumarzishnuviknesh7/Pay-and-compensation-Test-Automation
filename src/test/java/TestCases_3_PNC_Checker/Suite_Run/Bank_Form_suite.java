package TestCases_3_PNC_Checker.Suite_Run;

import Custom_Utilities.Base_PNC_Login;
import ExcelUtils.Excel_Utility_Checker;
import Pages_Checker.Data_Excel_Upload;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;

public class Bank_Form_suite extends Base_PNC_Login {


    @Test(priority = 1)
    public void Tc30_Verify_if_the_user_can_able_to_edit_the_record_which_is_updated_by_Maker_in_the_Bank_Form() throws InterruptedException, IOException {

        Data_Excel_Upload Data_Excel_Upload_calls = new Data_Excel_Upload(driver);
        Data_Excel_Upload_calls.data_upload_Bank_form_current_processing_month();

        Exception e = new Exception();
        e.fillInStackTrace();
        String methodName = e.getStackTrace()[0].getMethodName();
        String sheet = "Bank_Form";
        String test_case_number = methodName;

        Excel_Utility_Checker datas = new Excel_Utility_Checker();
        ArrayList data = datas.getData(test_case_number, sheet);

        String role = (String) data.get(1);
        String country = (String) data.get(2);
        String Legal_entities = (String) data.get(3);
        String pay = (String) data.get(4);
        String menu_selection = (String) data.get(5);
        String form_selection = (String) data.get(6);
        String processing_period = (String) data.get(7);
        String data_one = (String) data.get(8);
        String Edit_name = (String) data.get(10);
        String Toaster_message = (String) data.get(11);

        /*
         *About this test case
         *User should be able to add new employees' data in theBank Form. The system should show the Pop-up message as "Record submitted successfully".
         * Test Type - positive
         */

        //clicking change role icon
        PNC_home_page_calls.Click_On_The_Change_Role_Icon();

        //selection country,paygroup and legal entity
        PNC_home_page_calls.Select_The_Particular_CCBU_And_Paygroup(role, country, Legal_entities, pay);

        //menu transaction and new joiner form selection
        PNC_home_page_calls.Select_The_Transaction_Tab(menu_selection);

        //new joiner form selection
        PNC_home_page_calls.Select_Form(menu_selection, form_selection);

        //select the input received in month
        PNC_Bank_form_calls.Select_Input_Received_In_Month(processing_period);

        //selecting single record to edit
        PNC_Bank_form_calls.Click_On_The_Edit_Icon_Under_The_Action_Field(data_one);

        //editing the name of the record
        PNC_Edit_Page_calls.Bank_Editing_Name(Edit_name, Toaster_message);

        //checking the record which is been edited
        PNC_Bank_form_calls.Changes_Check(data_one);
    }

    @Test(priority = 2)
    public void Tc31_Verify_if_the_user_can_able_to_Delete_Single_the_record_which_is_updated_by_Maker_in_the_Bank_Form() throws InterruptedException, IOException {

        Exception e = new Exception();
        e.fillInStackTrace();
        String methodName = e.getStackTrace()[0].getMethodName();
        String sheet = "Bank_Form";
        String test_case_number = methodName;

        Excel_Utility_Checker datas = new Excel_Utility_Checker();
        ArrayList data = datas.getData(test_case_number, sheet);

        String role = (String) data.get(1);
        String country = (String) data.get(2);
        String Legal_entities = (String) data.get(3);
        String pay = (String) data.get(4);
        String menu_selection = (String) data.get(5);
        String form_selection = (String) data.get(6);
        String processing_period = (String) data.get(7);
        String data_one = (String) data.get(8);
        String Toaster_message = (String) data.get(11);



        /*
         *About this test case
         *User should be able to delete  employee data in theBank Form. The system should show the Pop-up message as "Record Deleted successfully".
         * Test Type - positive
         */

        //select the input received in month
        PNC_Bank_form_calls.Select_Input_Received_In_Month(processing_period);

        //to delete a record
        PNC_Bank_form_calls.Click_On_The_Cross_Symbol_Icon_Under_The_Action_Field(data_one, Toaster_message);

    }

    @Test(priority = 3)
    public void Tc32_Verify_if_the_user_is_able_to_approve_the_single_record_using_the_Approve_button_in_Bank_Form() throws InterruptedException, IOException {

        Exception e = new Exception();
        e.fillInStackTrace();
        String methodName = e.getStackTrace()[0].getMethodName();
        String sheet = "Bank_Form";
        String test_case_number = methodName;


        Excel_Utility_Checker datas = new Excel_Utility_Checker();
        ArrayList data = datas.getData(test_case_number, sheet);

        String role = (String) data.get(1);
        String country = (String) data.get(2);
        String Legal_entities = (String) data.get(3);
        String pay = (String) data.get(4);
        String menu_selection = (String) data.get(5);
        String form_selection = (String) data.get(6);
        String processing_period = (String) data.get(7);
        String data_one = (String) data.get(8);
        String Toaster_message = (String) data.get(11);

        /*
         *About this test case
         *User should be able to approve the single record using the Approve button inBank Form.
         * The system should show the Pop-up Message as " Record Approves Successfully".
         * Test Type - positive
         */


        //select the input received in month
        PNC_Bank_form_calls.Select_Input_Received_In_Month(processing_period);

        //selecting single record in check box to approve
        PNC_Bank_form_calls.Select_The_Particular_Record(data_one);

        //clicking approve button to approve the selected record
        PNC_Bank_form_calls.Approve_Click(Toaster_message);

        //checking the record which is been approved
        PNC_Bank_form_calls.Changes_Check(data_one);
    }

    @Test(priority = 4)
    public void Tc33_Check_if_the_user_can_approve_the_records_without_selecting_the_records_in_the_Bank_Form() throws InterruptedException, IOException {

        Exception e = new Exception();
        e.fillInStackTrace();
        String methodName = e.getStackTrace()[0].getMethodName();
        String sheet = "Bank_Form";
        String test_case_number = methodName;


        Excel_Utility_Checker datas = new Excel_Utility_Checker();
        ArrayList data = datas.getData(test_case_number, sheet);

        String role = (String) data.get(1);
        String country = (String) data.get(2);
        String Legal_entities = (String) data.get(3);
        String pay = (String) data.get(4);
        String menu_selection = (String) data.get(5);
        String form_selection = (String) data.get(6);
        String processing_period = (String) data.get(7);
        String Toaster_message = (String) data.get(11);

        /*
         *About this test case
         *The System should show the error toast message such as " Please select any records to approve".
         * Test Type - negative
         */

        //select the input received in month
        PNC_Bank_form_calls.Select_Input_Received_In_Month(processing_period);

        //clicking approve button
        PNC_Bank_form_calls.Approve_Click_Without_Record_Selecting(Toaster_message);
    }

    @Test(priority = 5)
    public void Tc37_Verify_if_the_user_is_able_to_reject_the_records_using_the_Reject_button_in_theBank_Form() throws InterruptedException, IOException {

        Exception e = new Exception();
        e.fillInStackTrace();
        String methodName = e.getStackTrace()[0].getMethodName();
        String sheet = "Bank_Form";
        String test_case_number = methodName;


        Excel_Utility_Checker datas = new Excel_Utility_Checker();
        ArrayList data = datas.getData(test_case_number, sheet);

        String role = (String) data.get(1);
        String country = (String) data.get(2);
        String Legal_entities = (String) data.get(3);
        String pay = (String) data.get(4);
        String menu_selection = (String) data.get(5);
        String form_selection = (String) data.get(6);
        String processing_period = (String) data.get(7);
        String data_one = (String) data.get(8);
        String reject_Reason_type = (String) data.get(9);
        String Toaster_message = (String) data.get(11);
        /*
         *About this test case
         *The System should show the error toast message such as " Records rejected Successfully".
         * Test Type - positive
         */

        //select the input received in month
        PNC_Bank_form_calls.Select_Input_Received_In_Month(processing_period);

        //single record selecting check box
        PNC_Bank_form_calls.Single_Record_Selecting_Check_Box(data_one);

        //selecting reject reason
        PNC_Bank_form_calls.Single_Record_Selecting_Check_Box(data_one, reject_Reason_type);

        //click reject button
        PNC_Bank_form_calls.Reject_Click(Toaster_message);
    }


    @Test(priority = 6)
    public void Tc38_Check_if_the_user_is_able_to_reject_the_Record_without_selecting_the_Reject_Reason_in_the_Bank_Form() throws InterruptedException, IOException {

        Exception e = new Exception();
        e.fillInStackTrace();
        String methodName = e.getStackTrace()[0].getMethodName();
        String sheet = "Bank_Form";
        String test_case_number = methodName;


        Excel_Utility_Checker datas = new Excel_Utility_Checker();
        ArrayList data = datas.getData(test_case_number, sheet);

        String role = (String) data.get(1);
        String country = (String) data.get(2);
        String Legal_entities = (String) data.get(3);
        String pay = (String) data.get(4);
        String menu_selection = (String) data.get(5);
        String form_selection = (String) data.get(6);
        String processing_period = (String) data.get(7);
        String data_one = (String) data.get(8);
        String toaster_message = (String) data.get(11);

        /*
         *About this test case
         *The system should show the Pop-up Message as "Please select Reject Reason".
         * Test Type - positive
         */

        //select the input received in month
        PNC_Bank_form_calls.Select_Input_Received_In_Month(processing_period);

        //single record selecting check box
        PNC_Bank_form_calls.Single_Record_Selecting_Check_Box(data_one);

        //click reject button without selecting record
        PNC_Bank_form_calls.Reject_Button_Click(toaster_message);
    }


    @Test(priority = 7)
    public void Tc39_Check_if_the_user_can_able_to_Reject_the_records_without_selecting_the_any_records_in_the_Bank_Form() throws InterruptedException, IOException {

        Exception e = new Exception();
        e.fillInStackTrace();
        String methodName = e.getStackTrace()[0].getMethodName();
        String sheet = "Bank_Form";
        String test_case_number = methodName;


        Excel_Utility_Checker datas = new Excel_Utility_Checker();
        ArrayList data = datas.getData(test_case_number, sheet);

        String role = (String) data.get(1);
        String country = (String) data.get(2);
        String Legal_entities = (String) data.get(3);
        String pay = (String) data.get(4);
        String menu_selection = (String) data.get(5);
        String form_selection = (String) data.get(6);
        String processing_period = (String) data.get(7);
        String Toaster_message = (String) data.get(11);

        /*
         *About this test case
         *The System should show the Pop-up Message as "Please select at least one check box or reject reason".
         * Test Type - Negative
         */

        //select the input received in month
        PNC_Bank_form_calls.Select_Input_Received_In_Month(processing_period);

        //click reject button without selecting record
        PNC_Bank_form_calls.Reject_Button_Click_Without_Record(Toaster_message);
    }

    @Test(priority = 8)
    public void Tc34_Verify_if_the_user_is_able_to_approve_the_All_records_using_the_Approve_All_button_in_the_Bank_Form() throws InterruptedException, IOException {

        Exception e = new Exception();
        e.fillInStackTrace();
        String methodName = e.getStackTrace()[0].getMethodName();
        String sheet = "Bank_Form";
        String test_case_number = methodName;

        Excel_Utility_Checker datas = new Excel_Utility_Checker();
        ArrayList data = datas.getData(test_case_number, sheet);

        String role = (String) data.get(1);
        String country = (String) data.get(2);
        String Legal_entities = (String) data.get(3);
        String pay = (String) data.get(4);
        String menu_selection = (String) data.get(5);
        String form_selection = (String) data.get(6);
        String processing_period = (String) data.get(7);

        /*
         *About this test case
         *User should be able to approve the All record using the Approve All button in theBank Form. The system should show the Pop-up Message as " You have
         * approved x records! We'll take care of processing this and send you a notification when ready. Feel free to move out of this page".
         * Test Type - positive
         */
        //select the input received in month
        PNC_Bank_form_calls.Select_Input_Received_In_Month(processing_period);

        //clicking select all check box
        PNC_Bank_form_calls.Clicking_Approve_All_Button();

        //toaster invisible wait
        PNC_Bank_form_calls.toaster_Invisible();

    }


    @Test(priority = 9)
    public void Tc40_Verify_if_the_user_can_able_to_delete_the_all_the_records_using_the_Bulk_delete_button_in_the_Bank_Form() throws InterruptedException, IOException {

        //toaster invisible wait
        PNC_Bank_form_calls.toaster_Invisible();

        Data_Excel_Upload Data_Excel_Upload_calls = new Data_Excel_Upload(driver);
        Data_Excel_Upload_calls.data_upload_Bank_form_current_processing_month();

        Exception e = new Exception();
        e.fillInStackTrace();
        String methodName = e.getStackTrace()[0].getMethodName();
        String sheet = "Bank_Form";
        String test_case_number = methodName;


        Excel_Utility_Checker datas = new Excel_Utility_Checker();
        ArrayList data = datas.getData(test_case_number, sheet);

        String role = (String) data.get(1);
        String country = (String) data.get(2);
        String Legal_entities = (String) data.get(3);
        String pay = (String) data.get(4);
        String menu_selection = (String) data.get(5);
        String form_selection = (String) data.get(6);
        String processing_period = (String) data.get(7);
        String data_one = (String) data.get(8);
        String Edit_name = (String) data.get(10);
        String Toaster_message = (String) data.get(11);


        /*
         *About this test case
         *The System should show the Pop-up message as Records deleted Successfully.
         * Test Type - Positive
         */


        //clicking change role icon
        PNC_home_page_calls.Click_On_The_Change_Role_Icon();

        //selection country,paygroup and legal entity
        PNC_home_page_calls.Select_The_Particular_CCBU_And_Paygroup(role, country, Legal_entities, pay);

        //menu transaction and new joiner form selection
        PNC_home_page_calls.Select_The_Transaction_Tab(menu_selection);

        //new joiner form selection
        PNC_home_page_calls.Select_Form(menu_selection, form_selection);

        //select the input received in month
        PNC_Bank_form_calls.Select_Input_Received_In_Month(processing_period);

        //clicking the bulk delete button
        PNC_Bank_form_calls.Bulk_Delete(Toaster_message);
    }

    @Test(priority = 10)
    public void Tc35_Check_if_the_user_able_to_Delete_all_the_records_using_the_Bulk_delete_button_which_is_Approved_by_Checked_in_Bank_Form() throws InterruptedException, IOException {

        Exception e = new Exception();
        e.fillInStackTrace();
        String methodName = e.getStackTrace()[0].getMethodName();
        String sheet = "Bank_Form";
        String test_case_number = methodName;


        Excel_Utility_Checker datas = new Excel_Utility_Checker();
        ArrayList data = datas.getData(test_case_number, sheet);

        String role = (String) data.get(1);
        String country = (String) data.get(2);
        String Legal_entities = (String) data.get(3);
        String pay = (String) data.get(4);
        String menu_selection = (String) data.get(5);
        String form_selection = (String) data.get(6);
        String processing_period = (String) data.get(7);
        String Toaster_message = (String) data.get(11);

        /*
         *About this test case
         *User can't able to delete all the records which is already approved by checker. System should show the pop up as " Record Deleted Successfully".
         * Test Type - negative
         */

        //select the input received in month
        PNC_Bank_form_calls.Select_Input_Received_In_Month(processing_period);

        //click on bulk delete button
        PNC_Bank_form_calls.Bulk_Delete(Toaster_message);
    }


    @Test(priority = 11)
    public void Tc36_Check_if_the_user_can_approve_all_the_records_which_is_already_approved_in_the_Bank_Form() throws InterruptedException, IOException {

        Exception e = new Exception();
        e.fillInStackTrace();
        String methodName = e.getStackTrace()[0].getMethodName();
        String sheet = "Bank_Form";
        String test_case_number = methodName;


        Excel_Utility_Checker datas = new Excel_Utility_Checker();
        ArrayList data = datas.getData(test_case_number, sheet);

        String role = (String) data.get(1);
        String country = (String) data.get(2);
        String Legal_entities = (String) data.get(3);
        String pay = (String) data.get(4);
        String menu_selection = (String) data.get(5);
        String form_selection = (String) data.get(6);
        String processing_period = (String) data.get(7);
        String toaster_message = (String) data.get(11);

        /*
         *About this test case
         *The System should show the error toast message such as " No records  available to approve".
         * Test Type - negative
         */

        //select the input received in month
        PNC_Bank_form_calls.Select_Input_Received_In_Month(processing_period);

        //approve all without selecting record
        PNC_Bank_form_calls.Approve_All_Record_Without_Selecting(toaster_message);

    }


}
