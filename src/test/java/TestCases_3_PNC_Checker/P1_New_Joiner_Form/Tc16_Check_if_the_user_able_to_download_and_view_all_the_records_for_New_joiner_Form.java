package TestCases_3_PNC_Checker.P1_New_Joiner_Form;

import Custom_Utilities.Base_PNC_Login;
import Custom_Utilities.base.Download_utility;
import ExcelUtils.Excel_Utility_Checker;
import Pages_Checker.PNC_New_Joiner_Form;
import Pages_Checker.PNC_home_page;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

public class Tc16_Check_if_the_user_able_to_download_and_view_all_the_records_for_New_joiner_Form extends Base_PNC_Login {

    @Test
    public void Tc16_Check_if_the_user_able_to_download_and_view_all_the_records_for_New_joiner_Form() throws InterruptedException, IOException, AWTException {

        PNC_home_page PNC_home_page_calls = new PNC_home_page(driver);
        PNC_New_Joiner_Form PNC_New_Joiner_Form_calls = new PNC_New_Joiner_Form(driver);
        Download_utility Download_utility_calls = new Download_utility(driver);



        String sheet = "New_Joiner_Form";
        String test_case_number = "Tc16_Check_if_the_user_able_to_download_and_view_all_the_records_for_New_joiner_Form";
        Excel_Utility_Checker datas = new Excel_Utility_Checker();
        ArrayList data = datas.getData(test_case_number, sheet);

        String role = (String) data.get(1);
        String country = (String) data.get(2);
        String Legal_entities = (String) data.get(3);//Regression Test 1.0_Egypt_Regression Test 1.0_Jan2023_New joiner
        String pay = (String) data.get(4);
        String menu_selection = (String) data.get(5);
        String form_selection = (String) data.get(6);
        String processing_period = (String) data.get(7);
        String Download_File_name = (String) data.get(15);
        String Folder_name = (String) data.get(16);
        String File_Rename  = (String) data.get(17);
        String file_extension  = (String) data.get(18);


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

        PNC_New_Joiner_Form_calls.Download_Click();
        PNC_New_Joiner_Form_calls.Select_All_Check_Box_Click();
        PNC_New_Joiner_Form_calls.Download_Button_Click();
        Download_utility_calls.File_Download_Check(Download_File_name,Folder_name,File_Rename,file_extension);

    }

}

