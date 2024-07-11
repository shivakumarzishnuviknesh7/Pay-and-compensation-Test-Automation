package TestCases_3_PNC_Checker.P1_New_Joiner_Form;

import Pages_Checker.PNC_New_Joiner_Form;
import Pages_Checker.PNC_home_page;
import Custom_Utilities.Base_PNC_Login;
import ExcelUtils.Excel_Utility_Checker;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;

public class Tc7_Verify_if_the_user_is_able_to_approve_the_All_records_using_the_Approve_All_button_in_the_New_Joiner_form extends Base_PNC_Login {


    @Test
    public void Tc7_Verify_if_the_user_is_able_to_approve_the_All_records_using_the_Approve_All_button_in_the_New_Joiner_form() throws InterruptedException, IOException {

        PNC_home_page PNC_home_page_calls = new PNC_home_page(driver);
        PNC_New_Joiner_Form PNC_New_Joiner_Form_calls = new PNC_New_Joiner_Form(driver);


        String sheet = "Sheet1";
        String test_case_number = "Tc7_Verify_if_the_user_is_able_to_approve_the_All_records_using_the_Approve_All_button_in_the_New_Joiner_form";

        Excel_Utility_Checker datas = new Excel_Utility_Checker();
        ArrayList data = datas.getData(test_case_number, sheet);

        String role = (String) data.get(1);
        String country = (String) data.get(2);
        String Legal_entities = (String) data.get(3);
        String pay = (String) data.get(4);
        String menu_selection = (String) data.get(5);
        String form_selection = (String) data.get(6);
        String processing_period = (String) data.get(7);

        //clicking change role icon
        PNC_home_page_calls.Click_On_The_Change_Role_Icon();

        //selection country,paygroup and legal entity
        PNC_home_page_calls.Select_The_Particular_CCBU_And_Paygroup(role, country, Legal_entities, pay);

        //menu transaction and new joiner form selection
        PNC_home_page_calls.Select_The_Transaction_Tab(menu_selection);

        //new joiner form selection
        PNC_home_page_calls.Select_Form(menu_selection,form_selection);
        //processing month selection
        PNC_New_Joiner_Form_calls.Select_The_Processing_Month(processing_period);

        /*
         *About this test case
         *User should be able to approve the All record using the Approve All button in the New Joiner form. The system should show the Pop-up Message as " You have
         * approved x records! We'll take care of processing this and send you a notification when ready. Feel free to move out of this page".
         * Test Type - positive
         */


        //select all records and approve all button click
        PNC_New_Joiner_Form_calls.Clicking_Approve_All();



    }
}