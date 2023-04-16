package org.example;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReportsManager {
    private static ExtentReports extent;

    public static ExtentReports getInstance() {
        if (extent == null) {
            String reportName = "My Test Report";
            String reportPath = "path/to/report.html";

            ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(reportPath);
            htmlReporter.config().setReportName(reportName);

            extent = new ExtentReports();
            extent.attachReporter(htmlReporter);
        }

        return extent;
    }

    public static void flush() {
        if (extent != null) {
            extent.flush();
        }
    }

    public static ExtentReports createInstance() {
        return null;
    }
}
