package TestCases_3_PNC_Checker.P1_New_Joiner_Form;

import Pages_Checker.PNC_home_page;
import Custom_Utilities.Base_PNC_Login;
import ExcelUtils.Excel_Utility_Checker;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;

public class Tc1_Check_if_the_user_able_to_select_the_Role_as_Checker_for_Particular_CCBU_and_Paygroup_using_the_Change_Role_Icon extends Base_PNC_Login {

    @Test
    public void Tc1_Check_if_the_user_able_to_select_the_Role_as_Checker_for_Particular_CCBU_and_Paygroup_using_the_Change_Role_Icon() throws InterruptedException, IOException {

        PNC_home_page PNC_home_page_calls = new PNC_home_page(driver);
        String sheet = "New_Joiner_Form";
        String test_case_number = "Tc1_Check_if_the_user_able_to_select_the_Role_as_Checker_for_Particular_CCBU_and_Paygroup_using_the_Change_Role_Icon";
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

        //driver.close();

    }
}
