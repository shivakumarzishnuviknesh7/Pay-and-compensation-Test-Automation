package TestCases_3_PNC_Checker.P1_New_Joiner_Form;


import Pages_Checker.PNC_New_Joiner_Form;
import Pages_Checker.PNC_home_page;
import Custom_Utilities.Base_PNC_Login;
import ExcelUtils.Excel_Utility_Checker;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;

public class Tc4_Verify_if_the_user_is_able_to_approve_the_single_record_using_the_Approve_button_in_New_Joiner_form extends Base_PNC_Login {


    @Test
    public void Tc4_Verify_if_the_user_is_able_to_approve_the_single_record_using_the_Approve_button_in_New_Joiner_form() throws InterruptedException, IOException {

        PNC_home_page PNC_home_page_calls = new PNC_home_page(driver);
        PNC_New_Joiner_Form PNC_New_Joiner_Form_calls = new PNC_New_Joiner_Form(driver);


        String sheet = "New_Joiner_Form";
        String test_case_number = "Tc4_Verify_if_the_user_is_able_to_approve_the_single_record_using_the_Approve_button_in_New_Joiner_form";
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

        for (Object d:data){
            System.out.println((String)(d));
        }

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

        //selecting single record
        PNC_New_Joiner_Form_calls.Select_The_Particular_Record(data_one);

        /*
         *About this test case
         *User should be able to approve the single record using the Approve button in New Joiner form.
         * The system should show the Pop-up Message as " Record Approved Successfully".
         * Test Type - Positive
         */

        //clicking approve button
        PNC_New_Joiner_Form_calls.Approve_Click();

        Thread.sleep(6000);

        //processing month selection
        PNC_New_Joiner_Form_calls.Select_The_Processing_Month(processing_period);

        //check record approved or not
        PNC_New_Joiner_Form_calls.Record_Approved_Check(data_one);

        driver.close();


    }

}