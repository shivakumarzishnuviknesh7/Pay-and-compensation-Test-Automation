package TestCases_3_PNC_Checker.P2_Bank_Form;

import Pages_Checker.PNC_Bank_form;
import Pages_Checker.PNC_home_page;
import Custom_Utilities.Base_PNC_Login;
import ExcelUtils.Excel_Utility_Checker;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;

public class Tc40_Verify_if_the_user_can_able_to_delete_the_all_the_records_using_the_Bulk_delete_button_in_the_Bank_Form extends Base_PNC_Login {


    @Test
    public void Tc40_Verify_if_the_user_can_able_to_delete_the_all_the_records_using_the_Bulk_delete_button_in_the_Bank_Form() throws InterruptedException, IOException {

        PNC_home_page PNC_home_page_calls = new PNC_home_page(driver);
        PNC_Bank_form PNC_Bank_form_calls = new PNC_Bank_form(driver);


        String sheet = "Bank_Form";
        String test_case_number = "Tc40_Verify_if_the_user_can_able_to_delete_the_all_the_records_using_the_Bulk_delete_button_in_the_Bank_Form";

        Excel_Utility_Checker datas = new Excel_Utility_Checker();
        ArrayList data = datas.getData(test_case_number, sheet);

        String role = (String) data.get(1);
        String country = (String) data.get(2);
        String Legal_entities = (String) data.get(3);
        String pay = (String) data.get(4);
        String menu_selection = (String) data.get(5);
        String form_selection = (String) data.get(6);
        String Toaster_message = (String) data.get(11);


        //clicking change role icon
        PNC_home_page_calls.Click_On_The_Change_Role_Icon();

        //selection country,paygroup and legal entity
        PNC_home_page_calls.Select_The_Particular_CCBU_And_Paygroup(role, country, Legal_entities, pay);

        //menu transaction and new joiner form selection
        PNC_home_page_calls.Select_The_Transaction_Tab(menu_selection);

        //new joiner form selection
        PNC_home_page_calls.Select_Form(menu_selection, form_selection);


        /*
         *About this test case
         *The System should show the Pop-up message as Records deleted Successfully.
         * Test Type - Positive
         */


        //clicking the bulk delete button
        PNC_Bank_form_calls.Bulk_Delete_Click(Toaster_message);

        driver.close();

    }
}