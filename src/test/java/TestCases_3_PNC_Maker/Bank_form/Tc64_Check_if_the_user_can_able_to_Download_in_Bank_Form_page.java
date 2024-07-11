package TestCases_3_PNC_Maker.Bank_form;

import Custom_Utilities.Base_PNC_Login;
import Custom_Utilities.base.Download_utility;
import ExcelUtils.Excel_Utility_Checker;
import Pages_maker.PNC_bank_form_page;
import Pages_maker.PNC_home_page;
import Pages_maker.PNC_time_and_attendance_page;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

public class Tc64_Check_if_the_user_can_able_to_Download_in_Bank_Form_page extends Base_PNC_Login {
    @Test
    public void Tc64_Check_if_the_user_can_able_to_Download_in_Bank_Form_page() throws InterruptedException, IOException, AWTException {

        PNC_home_page PNC_home_page_calls = new PNC_home_page(driver);
        PNC_bank_form_page PNC_bank_form_page_calls = new PNC_bank_form_page(driver);
        Download_utility Download_utility_calls = new Download_utility(driver);


        String sheet = "Maker_role";
        String test_case_number = "Tc64_Check_if_the_user_can_able_to_Download_in_Bank_Form_page";
        Excel_Utility_Checker datas = new Excel_Utility_Checker();
        ArrayList data = datas.getData(test_case_number, sheet);

        String role = (String) data.get(1);
        String country = (String) data.get(2);
        String Legal_entities = (String) data.get(3);
        String pay = (String) data.get(4);
        String menu_selection = (String) data.get(5);
        String form_selection = (String) data.get(6);
        String processing_period = (String) data.get(7);

        String Download_File_name = (String) data.get(8);
        String Folder_name = (String) data.get(9);
        String File_Rename = (String) data.get(10);
        String file_extension = (String) data.get(11);

        //clicking change role icon
        PNC_home_page_calls.Click_On_The_Change_Role_Icon();

        //selection country,paygroup and legal entity
        PNC_home_page_calls.Select_The_Particular_CCBU_And_Paygroup(role,country,Legal_entities,pay);

        /*
         *About this test case
         *file download checking
         * Test Type - Positive
         */

        //menu transaction and new joiner form selection
        PNC_home_page_calls.Select_The_Transaction_Tab(menu_selection);

        //new joiner form selection
        PNC_home_page_calls.Select_Form(menu_selection,form_selection);

        // processing month selection
        PNC_bank_form_page_calls.Select_Input_Received_In_Month(processing_period);

        PNC_bank_form_page_calls.Download_Click();

        PNC_bank_form_page_calls.Select_All_Check_Box_Click();

        PNC_bank_form_page_calls.Download_Button_Click();

        Download_utility_calls.File_Download_Check(Download_File_name,Folder_name,File_Rename,file_extension);

    }


}
