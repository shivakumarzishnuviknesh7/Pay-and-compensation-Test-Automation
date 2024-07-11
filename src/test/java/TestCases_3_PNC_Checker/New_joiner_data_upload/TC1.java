package TestCases_3_PNC_Checker.New_joiner_data_upload;

import Custom_Utilities.Base_PNC_Login;
import ExcelUtils.Excel_Utility_Checker;
import Pages_Checker.PNC_home_page;
import Custom_Utilities.upload_data_for_checker_role.New_Joiner_data_adding;
import Custom_Utilities.upload_data_for_checker_role.New_joiner_form;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;

public class TC1 extends Base_PNC_Login {

    @Test(priority = 1)
    public void TC1() throws InterruptedException, IOException {

        PNC_home_page PNC_home_page_calls = new PNC_home_page(driver);
        New_joiner_form New_joiner_form_calls = new New_joiner_form(driver);
        New_Joiner_data_adding New_Joiner_data_adding_calls = new New_Joiner_data_adding(driver);

        String sheet = "New_Joiner_data_upload";
        String test_case_number = "TC1";
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
        String data_email = (String) data.get(9);


        //clicking change role icon
        PNC_home_page_calls.Click_On_The_Change_Role_Icon();

        //selection country,paygroup and legal entity
        PNC_home_page_calls.Select_The_Particular_CCBU_And_Paygroup(role, country, Legal_entities, pay);

        PNC_home_page_calls.Loader_Wait2();

        //menu transaction and new joiner form selection
        PNC_home_page_calls.Select_The_Transaction_Tab(menu_selection);

        //new joiner form selection
        PNC_home_page_calls.Select_Form(menu_selection, form_selection);

        New_joiner_form_calls.clicking_the_add_new_item();
        //Thread.sleep(7000);
        New_Joiner_data_adding_calls.month_selecting();
        New_Joiner_data_adding_calls.Select_The_Processing_Month(processing_period);
        New_Joiner_data_adding_calls.value_adding(data_one,data_email);
        PNC_home_page_calls.Loader_Wait2();
        New_Joiner_data_adding_calls.clicking_save();

    }
    @Test(priority = 2)
    public void TC2() throws InterruptedException, IOException {

        PNC_home_page PNC_home_page_calls = new PNC_home_page(driver);
        New_joiner_form New_joiner_form_calls = new New_joiner_form(driver);
        New_Joiner_data_adding New_Joiner_data_adding_calls = new New_Joiner_data_adding(driver);

        String sheet = "New_Joiner_data_upload";
        String test_case_number = "TC2";
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
        String data_email = (String) data.get(9);

        Thread.sleep(7000);
        New_joiner_form_calls.clicking_the_add_new_item();
        Thread.sleep(7000);
        New_Joiner_data_adding_calls.month_selecting();
        New_Joiner_data_adding_calls.Select_The_Processing_Month(processing_period);
        New_Joiner_data_adding_calls.value_adding(data_one,data_email);
        PNC_home_page_calls.Loader_Wait2();
        New_Joiner_data_adding_calls.clicking_save();

    }

    @Test(priority = 3)
    public void TC3() throws InterruptedException, IOException {

        PNC_home_page PNC_home_page_calls = new PNC_home_page(driver);
        New_joiner_form New_joiner_form_calls = new New_joiner_form(driver);
        New_Joiner_data_adding New_Joiner_data_adding_calls = new New_Joiner_data_adding(driver);

        String sheet = "New_Joiner_data_upload";
        String test_case_number = "TC3";
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
        String data_email = (String) data.get(9);

        Thread.sleep(7000);
        New_joiner_form_calls.clicking_the_add_new_item();
        Thread.sleep(7000);
        New_Joiner_data_adding_calls.month_selecting();
        New_Joiner_data_adding_calls.Select_The_Processing_Month(processing_period);
        New_Joiner_data_adding_calls.value_adding(data_one,data_email);
        PNC_home_page_calls.Loader_Wait2();
        New_Joiner_data_adding_calls.clicking_save();

    }

    @Test(priority = 4)
    public void TC4() throws InterruptedException, IOException {

        PNC_home_page PNC_home_page_calls = new PNC_home_page(driver);
        New_joiner_form New_joiner_form_calls = new New_joiner_form(driver);
        New_Joiner_data_adding New_Joiner_data_adding_calls = new New_Joiner_data_adding(driver);

        String sheet = "New_Joiner_data_upload";
        String test_case_number = "TC4";
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
        String data_email = (String) data.get(9);

        Thread.sleep(7000);
        New_joiner_form_calls.clicking_the_add_new_item();
        Thread.sleep(7000);
        New_Joiner_data_adding_calls.month_selecting();
        New_Joiner_data_adding_calls.Select_The_Processing_Month(processing_period);
        New_Joiner_data_adding_calls.value_adding(data_one,data_email);
        PNC_home_page_calls.Loader_Wait2();
        New_Joiner_data_adding_calls.clicking_save();

    }

    @Test(priority = 5)
    public void TC5() throws InterruptedException, IOException {

        PNC_home_page PNC_home_page_calls = new PNC_home_page(driver);
        New_joiner_form New_joiner_form_calls = new New_joiner_form(driver);
        New_Joiner_data_adding New_Joiner_data_adding_calls = new New_Joiner_data_adding(driver);

        String sheet = "New_Joiner_data_upload";
        String test_case_number = "TC5";
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
        String data_email = (String) data.get(9);

        Thread.sleep(7000);
        New_joiner_form_calls.clicking_the_add_new_item();
        Thread.sleep(7000);
        New_Joiner_data_adding_calls.month_selecting();
        New_Joiner_data_adding_calls.Select_The_Processing_Month(processing_period);
        New_Joiner_data_adding_calls.value_adding(data_one,data_email);
        PNC_home_page_calls.Loader_Wait2();
        New_Joiner_data_adding_calls.clicking_save();

    }

    @Test(priority = 6)
    public void TC6() throws InterruptedException, IOException {

        PNC_home_page PNC_home_page_calls = new PNC_home_page(driver);
        New_joiner_form New_joiner_form_calls = new New_joiner_form(driver);
        New_Joiner_data_adding New_Joiner_data_adding_calls = new New_Joiner_data_adding(driver);

        String sheet = "New_Joiner_data_upload";
        String test_case_number = "TC6";
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
        String data_email = (String) data.get(9);

        Thread.sleep(7000);
        New_joiner_form_calls.clicking_the_add_new_item();
        Thread.sleep(7000);
        New_Joiner_data_adding_calls.month_selecting();
        New_Joiner_data_adding_calls.Select_The_Processing_Month(processing_period);
        New_Joiner_data_adding_calls.value_adding(data_one,data_email);
        PNC_home_page_calls.Loader_Wait2();
        New_Joiner_data_adding_calls.clicking_save();

    }

    @Test(priority = 7)
    public void TC7() throws InterruptedException, IOException {

        PNC_home_page PNC_home_page_calls = new PNC_home_page(driver);
        New_joiner_form New_joiner_form_calls = new New_joiner_form(driver);
        New_Joiner_data_adding New_Joiner_data_adding_calls = new New_Joiner_data_adding(driver);

        String sheet = "New_Joiner_data_upload";
        String test_case_number = "TC7";
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
        String data_email = (String) data.get(9);

        Thread.sleep(7000);
        New_joiner_form_calls.clicking_the_add_new_item();
        Thread.sleep(7000);
        New_Joiner_data_adding_calls.month_selecting();
        New_Joiner_data_adding_calls.Select_The_Processing_Month(processing_period);
        New_Joiner_data_adding_calls.value_adding(data_one,data_email);
        PNC_home_page_calls.Loader_Wait2();
        New_Joiner_data_adding_calls.clicking_save();

    }

    @Test(priority = 8)
    public void TC8() throws InterruptedException, IOException {

        PNC_home_page PNC_home_page_calls = new PNC_home_page(driver);
        New_joiner_form New_joiner_form_calls = new New_joiner_form(driver);
        New_Joiner_data_adding New_Joiner_data_adding_calls = new New_Joiner_data_adding(driver);

        String sheet = "New_Joiner_data_upload";
        String test_case_number = "TC8";
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
        String data_email = (String) data.get(9);

        Thread.sleep(7000);
        New_joiner_form_calls.clicking_the_add_new_item();
        Thread.sleep(7000);
        New_Joiner_data_adding_calls.month_selecting();
        New_Joiner_data_adding_calls.Select_The_Processing_Month(processing_period);
        New_Joiner_data_adding_calls.value_adding(data_one,data_email);
        PNC_home_page_calls.Loader_Wait2();
        New_Joiner_data_adding_calls.clicking_save();

    }

    @Test(priority = 9)
    public void TC9() throws InterruptedException, IOException {

        PNC_home_page PNC_home_page_calls = new PNC_home_page(driver);
        New_joiner_form New_joiner_form_calls = new New_joiner_form(driver);
        New_Joiner_data_adding New_Joiner_data_adding_calls = new New_Joiner_data_adding(driver);

        String sheet = "New_Joiner_data_upload";
        String test_case_number = "TC9";
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
        String data_email = (String) data.get(9);

        Thread.sleep(7000);
        New_joiner_form_calls.clicking_the_add_new_item();
        Thread.sleep(7000);
        New_Joiner_data_adding_calls.month_selecting();
        New_Joiner_data_adding_calls.Select_The_Processing_Month(processing_period);
        New_Joiner_data_adding_calls.value_adding(data_one,data_email);
        PNC_home_page_calls.Loader_Wait2();
        New_Joiner_data_adding_calls.clicking_save();

    }

    @Test(priority = 10)
    public void TC10() throws InterruptedException, IOException {

        PNC_home_page PNC_home_page_calls = new PNC_home_page(driver);
        New_joiner_form New_joiner_form_calls = new New_joiner_form(driver);
        New_Joiner_data_adding New_Joiner_data_adding_calls = new New_Joiner_data_adding(driver);

        String sheet = "New_Joiner_data_upload";
        String test_case_number = "TC10";
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
        String data_email = (String) data.get(9);

        Thread.sleep(7000);
        New_joiner_form_calls.clicking_the_add_new_item();
        Thread.sleep(7000);
        New_Joiner_data_adding_calls.month_selecting();
        New_Joiner_data_adding_calls.Select_The_Processing_Month(processing_period);
        New_Joiner_data_adding_calls.value_adding(data_one,data_email);
        PNC_home_page_calls.Loader_Wait2();
        New_Joiner_data_adding_calls.clicking_save();

    }

    @Test(priority = 11)
    public void TC11() throws InterruptedException, IOException {

        PNC_home_page PNC_home_page_calls = new PNC_home_page(driver);
        New_joiner_form New_joiner_form_calls = new New_joiner_form(driver);
        New_Joiner_data_adding New_Joiner_data_adding_calls = new New_Joiner_data_adding(driver);

        String sheet = "New_Joiner_data_upload";
        String test_case_number = "TC11";
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
        String data_email = (String) data.get(9);

        Thread.sleep(7000);
        New_joiner_form_calls.clicking_the_add_new_item();
        Thread.sleep(7000);
        New_Joiner_data_adding_calls.month_selecting();
        New_Joiner_data_adding_calls.Select_The_Processing_Month(processing_period);
        New_Joiner_data_adding_calls.value_adding(data_one,data_email);
        PNC_home_page_calls.Loader_Wait2();
        New_Joiner_data_adding_calls.clicking_save();

    }

    @Test(priority = 12)
    public void TC12() throws InterruptedException, IOException {

        PNC_home_page PNC_home_page_calls = new PNC_home_page(driver);
        New_joiner_form New_joiner_form_calls = new New_joiner_form(driver);
        New_Joiner_data_adding New_Joiner_data_adding_calls = new New_Joiner_data_adding(driver);

        String sheet = "New_Joiner_data_upload";
        String test_case_number = "TC12";
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
        String data_email = (String) data.get(9);

        Thread.sleep(7000);
        New_joiner_form_calls.clicking_the_add_new_item();
        Thread.sleep(7000);
        New_Joiner_data_adding_calls.month_selecting();
        New_Joiner_data_adding_calls.Select_The_Processing_Month(processing_period);
        New_Joiner_data_adding_calls.value_adding(data_one,data_email);
        PNC_home_page_calls.Loader_Wait2();
        New_Joiner_data_adding_calls.clicking_save();

    }

    @Test(priority = 13)
    public void TC13() throws InterruptedException, IOException {

        PNC_home_page PNC_home_page_calls = new PNC_home_page(driver);
        New_joiner_form New_joiner_form_calls = new New_joiner_form(driver);
        New_Joiner_data_adding New_Joiner_data_adding_calls = new New_Joiner_data_adding(driver);

        String sheet = "New_Joiner_data_upload";
        String test_case_number = "TC13";
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
        String data_email = (String) data.get(9);

        Thread.sleep(7000);
        New_joiner_form_calls.clicking_the_add_new_item();
        Thread.sleep(7000);
        New_Joiner_data_adding_calls.month_selecting();
        New_Joiner_data_adding_calls.Select_The_Processing_Month(processing_period);
        New_Joiner_data_adding_calls.value_adding(data_one,data_email);
        PNC_home_page_calls.Loader_Wait2();
        New_Joiner_data_adding_calls.clicking_save();

    }
}
