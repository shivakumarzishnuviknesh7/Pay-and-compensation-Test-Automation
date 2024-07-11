package TestCases_3_PNC_Checker.P2_Bank_Form;

import Pages_Checker.PNC_Bank_form;
import Pages_Checker.PNC_home_page;
import Custom_Utilities.Base_PNC_Login;
import ExcelUtils.Excel_Utility_Checker;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;

public class Tc34_Verify_if_the_user_is_able_to_approve_the_All_records_using_the_Approve_All_button_in_the_Bank_Form extends Base_PNC_Login {


    @Test
    public void Tc34_Verify_if_the_user_is_able_to_approve_the_All_records_using_the_Approve_All_button_in_the_Bank_Form() throws InterruptedException, IOException {

        PNC_home_page PNC_home_page_calls = new PNC_home_page(driver);
        PNC_Bank_form PNC_Bank_form_calls = new PNC_Bank_form(driver);


        String sheet = "Bank_Form";
        String test_case_number = "Tc34_Verify_if_the_user_is_able_to_approve_the_All_records_using_the_Approve_All_button_in_the_Bank_Form";

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
        PNC_home_page_calls.Select_Form(menu_selection, form_selection);

        //select the input received in month
        PNC_Bank_form_calls.Select_Input_Received_In_Month(processing_period);

        /*
         *About this test case
         *User should be able to approve the All record using the Approve All button in theBank Form. The system should show the Pop-up Message as " You have
         * approved x records! We'll take care of processing this and send you a notification when ready. Feel free to move out of this page".
         * Test Type - positive
         */

        //clicking select all check box
        PNC_Bank_form_calls.Clicking_Approve_All_Button();

        driver.close();
    }
}