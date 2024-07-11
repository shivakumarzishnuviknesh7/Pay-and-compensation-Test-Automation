package TestCases_3_PNC_Checker.Time_and_Attendance;

import Pages_Checker.PNC_Time_and_Attendance_Page;
import Pages_Checker.PNC_home_page;
import Custom_Utilities.Base_PNC_Login;
import ExcelUtils.Excel_Utility_Checker;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;

public class Tc19_Verify_if_the_user_is_able_to_approve_the_single_record_using_the_Approve_button_in_Time_and_Attendance extends Base_PNC_Login {
    @Test
    public void Tc19_Verify_if_the_user_is_able_to_approve_the_single_record_using_the_Approve_button_in_Time_and_Attendance() throws InterruptedException, IOException {


        PNC_home_page PNC_home_page_calls = new PNC_home_page(driver);
        PNC_Time_and_Attendance_Page PNC_Time_and_Attendance_Page_calls = new PNC_Time_and_Attendance_Page(driver);

        String sheet = "Time_And_Attendance_Form";
        String test_case_number = "Tc19_Verify_if_the_user_is_able_to_approve_the_single_record_using_the_Approve_button_in_Time_and_Attendance";

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

        for (Object d : data) {
            System.out.println((String) (d));
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
        PNC_Time_and_Attendance_Page_calls.Select_The_Processing_Month(processing_period);

        /*
         *About this test case
         *User should be able to approve the single record using the Approve button inTime and Attendance. The system should show the Pop-up Message as " Record
         *Approves Successfully".
         * Test Type - Positive
         */


        //selecting single record
        PNC_Time_and_Attendance_Page_calls.Select_The_Particular_Record(data_one);

        //clicking approve button
        PNC_Time_and_Attendance_Page_calls.Approve_Click();

        //processing month selection
        PNC_Time_and_Attendance_Page_calls.Select_The_Processing_Month(processing_period);

        //record approved check
        PNC_Time_and_Attendance_Page_calls.Record_Approved_Check(data_one);

        driver.close();


    }
}
