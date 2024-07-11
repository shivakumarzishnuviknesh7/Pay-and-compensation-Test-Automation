package TestCases_3_PNC_Checker.P1_New_Joiner_Form;


import Pages_Checker.PNC_New_Joiner_Form;
import Pages_Checker.PNC_home_page;
import Custom_Utilities.Base_PNC_Login;
import ExcelUtils.Excel_Utility_Checker;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;

public class Tc3_Verify_if_the_user_can_able_to_Delete_Single_the_record_which_is_updated_by_Maker_in_the_New_Joiner_Form extends Base_PNC_Login {


    @Test
    public void Tc3_Verify_if_the_user_can_able_to_Delete_Single_the_record_which_is_updated_by_Maker_in_the_New_Joiner_Form() throws InterruptedException, IOException {

        PNC_home_page PNC_home_page_calls = new PNC_home_page(driver);
        PNC_New_Joiner_Form PNC_New_Joiner_Form_calls = new PNC_New_Joiner_Form(driver);


        String sheet = "New_Joiner_Form";
        String test_case_number = "Tc3_Verify_if_the_user_can_able_to_Delete_Single_the_record_which_is_updated_by_Maker_in_the_New_Joiner_Form";
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


        //clicking change role icon
        PNC_home_page_calls.Click_On_The_Change_Role_Icon();

        //selection country,paygroup and legal entity
        PNC_home_page_calls.Select_The_Particular_CCBU_And_Paygroup(role, country, Legal_entities, pay);

        //menu transaction and new joiner form selection
        PNC_home_page_calls.Select_The_Transaction_Tab(menu_selection);

        //new joiner form selection
        PNC_home_page_calls.Select_Form(menu_selection, form_selection);

        //processing month selection
        PNC_New_Joiner_Form_calls.Select_The_Processing_Month(processing_period);


        /*
         *About this test case
         *User should be able to add new employees' data in the New Joiner Form. The system should show the Pop-up message as "Record Deleted successfully".
         * Test Type - Positive
         */


        //delete an record
        PNC_New_Joiner_Form_calls.Click_On_The_Cross_Symbol_Icon_Under_The_Action_Field(data_one,Toaster_message);

        //check record deleted
        PNC_New_Joiner_Form_calls.Record_Deleted_Check(data_one);

        driver.close();


    }

}