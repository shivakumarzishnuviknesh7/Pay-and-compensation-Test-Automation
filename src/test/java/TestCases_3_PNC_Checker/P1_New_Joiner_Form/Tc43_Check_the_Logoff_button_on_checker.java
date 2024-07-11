package TestCases_3_PNC_Checker.P1_New_Joiner_Form;

import Pages_Checker.PNC_home_page;
import Custom_Utilities.Base_PNC_Login;
import ExcelUtils.Excel_Utility_Checker;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;

public class Tc43_Check_the_Logoff_button_on_checker extends Base_PNC_Login {


    @Test
    public void Tc43_Check_the_Logoff_button_on_checker() throws InterruptedException, IOException {

        PNC_home_page PNC_home_page_calls = new PNC_home_page(driver);

        String sheet = "New_Joiner_Form";
        String test_case_number = "Tc43_Check_the_Logoff_button_on_checker";

        Excel_Utility_Checker datas = new Excel_Utility_Checker();
        ArrayList data = datas.getData(test_case_number, sheet);


        /*
         *About this test case
         *The user should go to 'Login' page in Payncomp
         * Test Type - positive
         */

        //logging out actions
        PNC_home_page_calls.Clicking_Log_Off();
        driver.close();

    }

}