package Custom_Utilities.base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportNg {
    public static ExtentReports getReportObject(){
        String path = System.getProperty("user.dir")+"\\PNC_Checker.html";
        ExtentSparkReporter reporter = new ExtentSparkReporter(path);
        reporter.config().setReportName("result");
        reporter.config().setDocumentTitle("title");

        ExtentReports extent = new ExtentReports();
        extent.attachReporter(reporter);
        extent.setSystemInfo("Tester","zishnu viknesh");
        //extent.createTest(path);
        return extent;

    }
}
