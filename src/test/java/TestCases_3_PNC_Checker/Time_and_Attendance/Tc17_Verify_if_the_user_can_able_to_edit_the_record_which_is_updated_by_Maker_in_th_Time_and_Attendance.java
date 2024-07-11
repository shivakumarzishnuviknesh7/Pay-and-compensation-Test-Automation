package TestCases_3_PNC_Checker.Time_and_Attendance;

import Pages_Checker.PNC_Edit_Page;
import Pages_Checker.PNC_Time_and_Attendance_Page;
import Pages_Checker.PNC_home_page;
import Custom_Utilities.Base_PNC_Login;
import ExcelUtils.Excel_Utility_Checker;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;

public class Tc17_Verify_if_the_user_can_able_to_edit_the_record_which_is_updated_by_Maker_in_th_Time_and_Attendance extends Base_PNC_Login {

    @Test
    public void Tc17_Verify_if_the_user_can_able_to_edit_the_record_which_is_updated_by_Maker_in_th_Time_and_Attendance() throws InterruptedException, IOException {


        PNC_home_page PNC_home_page_calls = new PNC_home_page(driver);
        PNC_Time_and_Attendance_Page PNC_Time_and_Attendance_Page_calls = new PNC_Time_and_Attendance_Page(driver);
        PNC_Edit_Page PNC_Edit_Page_calls = new PNC_Edit_Page(driver);

        String sheet = "Time_And_Attendance_Form";
        String test_case_number = "Tc17_Verify_if_the_user_can_able_to_edit_the_record_which_is_updated_by_Maker_in_th_Time_and_Attendance";

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
        String Leave_Enhancement_days = (String) data.get(10);
        String Toaster_message = (String) data.get(11);

        //clicking change role icon
        PNC_home_page_calls.Click_On_The_Change_Role_Icon();

        //selection country,paygroup and legal entity
        PNC_home_page_calls.Select_The_Particular_CCBU_And_Paygroup(role, country, Legal_entities, pay);

        /*
         *About this test case
         *User should be able to add new employees' data in theTime and Attendance. The system should show the Pop-up message as "Record submitted successfully".
         * Test Type - Positive
         */

        //menu transaction and new joiner form selection
        PNC_home_page_calls.Select_The_Transaction_Tab(menu_selection);

        //new joiner form selection
        PNC_home_page_calls.Select_Form(menu_selection, form_selection);

        //processing month selection
        PNC_Time_and_Attendance_Page_calls.Select_The_Processing_Month(processing_period);

        //selecting record to edit
        PNC_Time_and_Attendance_Page_calls.Click_On_The_Edit_Icon_Under_The_Action_Field(data_one);

        //editing the name of the selected record
        PNC_Edit_Page_calls.Time_Attendance_Edit(Leave_Enhancement_days, Toaster_message);

        //processing month selection
        PNC_Time_and_Attendance_Page_calls.Select_The_Processing_Month(processing_period);

        //record approved check
        PNC_Time_and_Attendance_Page_calls.Record_Approved_Check(data_one);

        driver.close();


    }
}
