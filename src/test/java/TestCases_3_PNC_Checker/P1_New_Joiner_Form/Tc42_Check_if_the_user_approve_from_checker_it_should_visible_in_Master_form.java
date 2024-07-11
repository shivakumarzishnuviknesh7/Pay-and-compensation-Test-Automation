package TestCases_3_PNC_Checker.P1_New_Joiner_Form;

import Custom_Utilities.Base_PNC_Login;
import ExcelUtils.Excel_Utility_Checker;
import Pages_Checker.PNC_Master_Form;
import Pages_Checker.PNC_New_Joiner_Form;
import Pages_Checker.PNC_home_page;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;

public class Tc42_Check_if_the_user_approve_from_checker_it_should_visible_in_Master_form extends Base_PNC_Login {


    @Test
    public void Tc42_Check_if_the_user_approve_from_checker_it_should_visible_in_Master_form() throws InterruptedException, IOException {

        PNC_home_page PNC_home_page_calls = new PNC_home_page(driver);
        PNC_New_Joiner_Form PNC_New_Joiner_Form_calls = new PNC_New_Joiner_Form(driver);
        PNC_Master_Form PNC_Master_Form_calls = new PNC_Master_Form(driver);


        String sheet = "New_Joiner_Form";
        String test_case_number = "Tc42_Check_if_the_user_approve_from_checker_it_should_visible_in_Master_form";


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


        //clicking change role icon
        PNC_home_page_calls.Click_On_The_Change_Role_Icon();

        //selection country,paygroup and legal entity
        PNC_home_page_calls.Select_The_Particular_CCBU_And_Paygroup(role, country, Legal_entities, pay);

        //menu transaction and new joiner form selection
        PNC_home_page_calls.Select_The_Transaction_Tab(menu_selection);


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

}