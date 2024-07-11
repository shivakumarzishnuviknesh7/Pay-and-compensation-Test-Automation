package TestCases_3_PNC_Checker.Suite_Run;

import Custom_Utilities.Base_PNC_Login;
import ExcelUtils.Excel_Utility_Checker;
import Pages_Checker.*;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;


public class New_joiner_suite extends Base_PNC_Login {

    @Test(priority = 1)
    public void Tc1_Check_if_the_user_able_to_select_the_Role_as_Checker_for_Particular_CCBU_and_Paygroup_using_the_Change_Role_Icon() throws InterruptedException, IOException {

        Data_Excel_Upload Data_Excel_Upload_calls = new Data_Excel_Upload(driver);

        Data_Excel_Upload_calls.data_upload_New_joiner_form_current_processing_month();
        Data_Excel_Upload_calls.data_upload_New_joiner_form_future_processing_month();
        Data_Excel_Upload_calls.data_upload_New_joiner_form_pre_future_processing_month();



        Exception e = new Exception();
        e.fillInStackTrace();
        String methodName = e.getStackTrace()[0].getMethodName();
        String sheet = "New_Joiner_Form";
        String test_case_number = methodName;

        Excel_Utility_Checker datas = new Excel_Utility_Checker();
        ArrayList data = datas.getData(test_case_number, sheet);

        String role = (String) data.get(1);
        String country = (String) data.get(2);
        String Legal_entities = (String) data.get(3);
        String pay = (String) data.get(4);

        /*
         *About this test case
         *User should be able to Change the Checker role for Particular CCBU using the "Change Role" Icon.
         * Test Type - Positive
         */

        //clicking change role icon
        PNC_home_page_calls.Click_On_The_Change_Role_Icon();

        //selection country,paygroup and legal entity
        PNC_home_page_calls.Select_The_Particular_CCBU_And_Paygroup(role, country, Legal_entities, pay);

    }

    @Test(priority = 2)
    public void Tc2_Verify_if_the_user_can_able_to_edit_the_record_which_is_updated_by_Maker_in_the_New_Joiner_Form() throws InterruptedException, IOException {

        Exception e = new Exception();
        e.fillInStackTrace();
        String methodName = e.getStackTrace()[0].getMethodName();
        String sheet = "New_Joiner_Form";
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
        //String value = (String) data.get(9);
        String name = (String) data.get(12);
        String email = (String) data.get(13);
        String Toaster_message = (String) data.get(14);

        /*
         *About this test case
         *User should be able to add new employees' data in the New Joiner Form. The system should show the Pop-up message as "Record submitted successfully".
         * Test Type - Positive
         */

        //menu transaction and new joiner form selection
        PNC_home_page_calls.Select_The_Transaction_Tab(menu_selection);

        //new joiner form selection
        PNC_home_page_calls.Select_Form(menu_selection, form_selection);

        //processing month selection
        PNC_New_Joiner_Form_calls.Select_The_Processing_Month(processing_period);

        //clicking an edit icon for single record
        PNC_New_Joiner_Form_calls.Click_On_The_Edit_Icon_Under_The_Action_Field(data_one);

        //editing the name of the selected record
        PNC_Edit_Page_calls.New_Joiner_Editing_Name(name, email, Toaster_message);

        //processing month selection
        PNC_New_Joiner_Form_calls.Select_The_Processing_Month(processing_period);

        //assert check
        PNC_New_Joiner_Form_calls.Record_Approved_Check(data_one);
    }

    @Test(priority = 3)
    public void Tc3_Verify_if_the_user_can_able_to_Delete_Single_the_record_which_is_updated_by_Maker_in_the_New_Joiner_Form() throws InterruptedException, IOException {




        Exception e = new Exception();
        e.fillInStackTrace();
        String methodName = e.getStackTrace()[0].getMethodName();
        String sheet = "New_Joiner_Form";
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
        String Toaster_message = (String) data.get(14);



        /*
         *About this test case
         *User should be able to add new employees' data in the New Joiner Form. The system should show the Pop-up message as "Record Deleted successfully".
         * Test Type - Positive
         */

        //processing month selection
        PNC_New_Joiner_Form_calls.Select_The_Processing_Month(processing_period);

        //delete an record
        PNC_New_Joiner_Form_calls.Click_On_The_Cross_Symbol_Icon_Under_The_Action_Field(data_one, Toaster_message);

        //check record deleted
        PNC_New_Joiner_Form_calls.Record_Deleted_Check(data_one);
    }


    @Test(priority = 4)
    public void Tc4_Verify_if_the_user_is_able_to_approve_the_single_record_using_the_Approve_button_in_New_Joiner_form() throws InterruptedException, IOException {




        Exception e = new Exception();
        e.fillInStackTrace();
        String methodName = e.getStackTrace()[0].getMethodName();
        String sheet = "New_Joiner_Form";
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


        /*
         *About this test case
         *User should be able to approve the single record using the Approve button in New Joiner form.
         * The system should show the Pop-up Message as " Record Approved Successfully".
         * Test Type - Positive
         */

        //processing month selection
        PNC_New_Joiner_Form_calls.Select_The_Processing_Month(processing_period);

        //selecting single record
        PNC_New_Joiner_Form_calls.Select_The_Particular_Record(data_one);

        //clicking approve button
        PNC_New_Joiner_Form_calls.Approve_Click();

        Thread.sleep(6000);

        //processing month selection
        PNC_New_Joiner_Form_calls.Select_The_Processing_Month(processing_period);

        Thread.sleep(3000);

        //check record approved or not
        PNC_New_Joiner_Form_calls.Record_Approved_Check(data_one);

    }

    @Test(priority = 5)
    public void Tc5_Verify_if_the_user_is_able_to_approve_the_single_record_using_the_Approve_button_for_Future_Prcessing_period_in_New_Joiner_form() throws InterruptedException, IOException {




        Exception e = new Exception();
        e.fillInStackTrace();
        String methodName = e.getStackTrace()[0].getMethodName();
        String sheet = "New_Joiner_Form";
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


        /*
         *About this test case
         *User should be able to approve the single record using the Approve button for Future Processing period in New Joiner form. The system should show the Pop-up
         *Message as " Record Approved Successfully".
         * Test Type - Positive
         */

        //processing month selection
        PNC_New_Joiner_Form_calls.Select_The_Processing_Month(processing_period);

        //selecting single record
        PNC_New_Joiner_Form_calls.Select_The_Particular_Record(data_one);

        //clicking approve button
        PNC_New_Joiner_Form_calls.Approve_Click();

        Thread.sleep(6000);

        //processing month selection
        PNC_New_Joiner_Form_calls.Select_The_Processing_Month(processing_period);

        //check record approved or not
        PNC_New_Joiner_Form_calls.Record_Approved_Check(data_one);
    }

    @Test(priority = 6)
    public void Tc6_Check_if_the_user_can_approve_the_records_without_selecting_the_records_in_the_New_Joiner_Form() throws InterruptedException, IOException {

        Exception e = new Exception();
        e.fillInStackTrace();
        String methodName = e.getStackTrace()[0].getMethodName();
        String sheet = "New_Joiner_Form";
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
        String Toaster_message = (String) data.get(14);


        /*
         *About this test case
         *The System should show the error toast message such as " Please select any records to approve".
         * Test Type - Negative
         */

        //processing month selection
        PNC_New_Joiner_Form_calls.Select_The_Processing_Month(processing_period);

        //clicking approve button without any records
        PNC_New_Joiner_Form_calls.Approve_Click_Without_Record_Selecting(Toaster_message);
    }

    @Test(priority = 7)
    public void Tc8_Check_if_the_user_can_approve_all_the_records_which_is_already_approved_in_the_New_Joiner_Form() throws InterruptedException, IOException {

        Exception e = new Exception();
        e.fillInStackTrace();
        String methodName = e.getStackTrace()[0].getMethodName();
        String sheet = "New_Joiner_Form";
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
        String Toaster_message = (String) data.get(14);


        /*
         *About this test case
         *The System should show the error toast message such as " No records  available to approve".
         * Test Type - Negative
         */

        //processing month selection
        PNC_New_Joiner_Form_calls.Select_The_Processing_Month(processing_period);

        //Approve all button click without selecting records
        PNC_New_Joiner_Form_calls.Approve_All_Without_Selecting_Record(Toaster_message);

    }

    @Test(priority = 8)
    public void Tc9_Verify_if_the_user_is_able_to_reject_the_All_records_using_the_reject_button_in_the_New_Joiner_form() throws InterruptedException, IOException {

        Exception e = new Exception();
        e.fillInStackTrace();
        String methodName = e.getStackTrace()[0].getMethodName();
        String sheet = "New_Joiner_Form";
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
        String Toaster_message = (String) data.get(14);



        /*
         *About this test case
         * The notification display like Recod Rejected successfully
         * Test Type - Positive
         */

        //processing month selection
        PNC_New_Joiner_Form_calls.Select_The_Processing_Month(processing_period);

        //selecting reason for reject for ALL record
        PNC_New_Joiner_Form_calls.Reject_Reason_For_All(reject_Reason_type);

        //clicking select all check box
        PNC_New_Joiner_Form_calls.Select_All_Check_Box();

        //clicking the reject button
        PNC_New_Joiner_Form_calls.Reject_Click(Toaster_message);
    }


    @Test(priority = 9)
    public void Tc10_Verify_if_the_user_is_able_to_reject_the_two_employee_records_using_the_reject_button_in_the_New_Joiner_form() throws InterruptedException, IOException {

        Exception e = new Exception();
        e.fillInStackTrace();
        String methodName = e.getStackTrace()[0].getMethodName();
        String sheet = "New_Joiner_Form";
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
        String reason = (String) data.get(9);
        Object data_two = data.get(10);
        String Toaster_message = (String) data.get(14);


        /*
         *About this test case
         * The notification display like Recod Rejected successfully
         * Test Type - Positive
         */

        //processing month selection
        PNC_New_Joiner_Form_calls.Select_The_Processing_Month(processing_period);

        //two record and with reject reason
        PNC_New_Joiner_Form_calls.Select_Two_Record_And_Two_Reason(data_one, data_two, reason);

        //clicking the reject button
        PNC_New_Joiner_Form_calls.Reject_Click(Toaster_message);
    }

    @Test(priority = 10)
    public void Tc11_Check_if_the_user_able_to_Delete_all_the_records_using_the_Bulk_delete_button_which_is_Approved_by_Checker_in_New_Joiner_Form() throws InterruptedException, IOException {

        Exception e = new Exception();
        e.fillInStackTrace();
        String methodName = e.getStackTrace()[0].getMethodName();
        String sheet = "New_Joiner_Form";
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
        Object data_two = data.get(9);
        String Toaster_message = (String) data.get(14);


        /*
         *About this test case
         *User can't able to delete all the records which is already approved by checker. System should show the pop up as " Record Deleted Successfully".
         * Test Type - Negative
         */

        //processing month selection
        PNC_New_Joiner_Form_calls.Select_The_Processing_Month(processing_period);

        //clicking bulk delete button
        PNC_New_Joiner_Form_calls.Bulk_Delete(Toaster_message);
    }


    @Test(priority = 11)
    public void Tc12_Verify_if_the_user_is_able_to_reject_the_records_using_the_Reject_button_in_the_New_joiner_Form() throws InterruptedException, IOException {

        Exception e = new Exception();
        e.fillInStackTrace();
        String methodName = e.getStackTrace()[0].getMethodName();
        String sheet = "New_Joiner_Form";
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
        String Toaster_message = (String) data.get(14);


        /*
         *About this test case
         *The System should show the error toast message such as " Records rejected Successfully".
         * Test Type - positive
         */

        //processing month selection
        PNC_New_Joiner_Form_calls.Select_The_Processing_Month(processing_period);

        //selecting reason for reject for record
        PNC_New_Joiner_Form_calls.Single_Record_Selecting_Check_Box(data_one, reject_Reason_type);

        //selecting the single record check box
        PNC_New_Joiner_Form_calls.Single_Record_Selecting_Check_Box(data_one);

        //clicking the reject button
        PNC_New_Joiner_Form_calls.Reject_Click(Toaster_message);

        //checking the record is rejected or not
        PNC_New_Joiner_Form_calls.Record_Reject_Check(data_one);

    }


    @Test(priority = 12)
    public void Tc13_Check_if_the_user_is_able_to_reject_the_Record_without_selecting_the_Reject_Reason_in_the_New_Joiner_Form() throws InterruptedException, IOException {

        Exception e = new Exception();
        e.fillInStackTrace();
        String methodName = e.getStackTrace()[0].getMethodName();
        String sheet = "New_Joiner_Form";
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
        String Toaster_message = (String) data.get(14);



        /*
         *About this test case
         *The system should show the Pop-up Message as "Please select Reject Reason".
         * Test Type - negative
         */

        //processing month selection
        PNC_New_Joiner_Form_calls.Select_The_Processing_Month(processing_period);

        //selecting single record in checkbox  without selecting reject reason
        PNC_New_Joiner_Form_calls.Single_Record_Selecting_Check_Box(data_one);

        //clciking reject without giving reject reason
        PNC_New_Joiner_Form_calls.Reject_Button_Click(Toaster_message);

    }


    @Test(priority = 13)
    public void Tc14_Check_if_the_user_can_able_to_Reject_the_records_without_selecting_the_any_records_in_the_New_Joiner_Form() throws InterruptedException, IOException {

        Exception e = new Exception();
        e.fillInStackTrace();
        String methodName = e.getStackTrace()[0].getMethodName();
        String sheet = "New_Joiner_Form";
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
        String Toaster_message = (String) data.get(14);


        /*
         *About this test case
         *The System should show the Pop-up Message as "Please select at least one check box or reject reason".
         * Test Type - negative
         */

        //processing month selection
        PNC_New_Joiner_Form_calls.Select_The_Processing_Month(processing_period);

        //clciking reject without giving reject reason
        PNC_New_Joiner_Form_calls.Reject_Button_Click_Without_Reject_Reason(Toaster_message);

    }


    @Test(priority = 14)
    public void Tc7_Verify_if_the_user_is_able_to_approve_the_All_records_using_the_Approve_All_button_in_the_New_Joiner_form() throws InterruptedException, IOException {

        Exception e = new Exception();
        e.fillInStackTrace();
        String methodName = e.getStackTrace()[0].getMethodName();
        String sheet = "New_Joiner_Form";
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


        /*
         *About this test case
         *User should be able to approve the All record using the Approve All button in the New Joiner form. The system should show the Pop-up Message as " You have
         * approved x records! We'll take care of processing this and send you a notification when ready. Feel free to move out of this page".
         * Test Type - positive
         */

        //processing month selection
        PNC_New_Joiner_Form_calls.Select_The_Processing_Month(processing_period);

        //select all records and approve all button click
        PNC_New_Joiner_Form_calls.Clicking_Approve_All();
    }

    @Test(priority = 15)
    public void Tc15_Verify_if_the_user_can_able_to_delete_the_all_the_records_using_the_Bulk_delete_button_in_the_New_joiner_Form() throws InterruptedException, IOException {

        Exception e = new Exception();
        e.fillInStackTrace();
        String methodName = e.getStackTrace()[0].getMethodName();
        String sheet = "New_Joiner_Form";
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
        String Toaster_message = (String) data.get(14);


        /*
         *About this test case
         *The System should show the Pop-up message as Records deleted Successfully.
         * Test Type - positive
         */

        //processing month selection
        PNC_New_Joiner_Form_calls.Select_The_Processing_Month(processing_period);

        //clicking the bulk delete button
        PNC_New_Joiner_Form_calls.Bulk_Delete(Toaster_message);

    }

    @Test(priority = 16)
    public void Tc42_Check_if_the_user_approve_from_checker_it_should_visible_in_Master_form() throws InterruptedException, IOException {

        Exception e = new Exception();
        e.fillInStackTrace();
        String methodName = e.getStackTrace()[0].getMethodName();
        String sheet = "New_Joiner_Form";
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
        String form_selection_two = (String) data.get(11);


        /*
         *About this test case
         *The employee ID '1030' should display in the 'Master Form'
         * Test Type - positive
         */



        //scroll up
        PNC_home_page_calls.Scroll();

        //menu transaction and new joiner form selection
        PNC_home_page_calls.Select_Form(menu_selection, form_selection_two);

        //checking the data in master form
        PNC_Master_Form_calls.Data_Check(data_one);


    }


    @Test(priority = 17)
    public void Tc43_Check_the_Logoff_button_on_checker() throws InterruptedException, IOException {

        /*
         *About this test case
         *The user should go to 'Login' page in Payncomp
         * Test Type - positive
         */

        //logging out actions
        PNC_home_page_calls.Clicking_Log_Off();


    }

}
