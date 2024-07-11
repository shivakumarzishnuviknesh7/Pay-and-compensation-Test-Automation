package TestCases_3_PNC_Checker.P1_New_Joiner_Form;

import Pages_Checker.PNC_Edit_Page;
import Pages_Checker.PNC_New_Joiner_Form;
import Pages_Checker.PNC_home_page;
import Custom_Utilities.Base_PNC_Login;
import ExcelUtils.Excel_Utility_Checker;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;

public class Tc2_Verify_if_the_user_can_able_to_edit_the_record_which_is_updated_by_Maker_in_the_New_Joiner_Form extends Base_PNC_Login {


    @Test
    public void Tc2_Verify_if_the_user_can_able_to_edit_the_record_which_is_updated_by_Maker_in_the_New_Joiner_Form() throws InterruptedException, IOException {

        PNC_home_page PNC_home_page_calls = new PNC_home_page(driver);
        PNC_New_Joiner_Form PNC_New_Joiner_Form_calls = new PNC_New_Joiner_Form(driver);
        PNC_Edit_Page PNC_Edit_Page_calls = new PNC_Edit_Page(driver);


        String sheet = "New_Joiner_Form";
        String test_case_number = "Tc2_Verify_if_the_user_can_able_to_edit_the_record_which_is_updated_by_Maker_in_the_New_Joiner_Form";
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
        String name = (String) data.get(12);
        String email = (String) data.get(13);
        String Toaster_message = (String) data.get(14);



        //clicking change role icon
        PNC_home_page_calls.Click_On_The_Change_Role_Icon();

        //selection country,paygroup and legal entity
        PNC_home_page_calls.Select_The_Particular_CCBU_And_Paygroup(role, country, Legal_entities, pay);

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
        PNC_Edit_Page_calls.New_Joiner_Editing_Name(name,email,Toaster_message);

        //processing month selection
        PNC_New_Joiner_Form_calls.Select_The_Processing_Month(processing_period);

        //assert check
        PNC_New_Joiner_Form_calls.Record_Approved_Check(data_one);

        driver.close();


    }

}