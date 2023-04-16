import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.example.ExtentReportsManager;


public class TestListeners implements ITestListener {
    private static ExtentReports extentReports = ExtentReportsManager.createInstance();

    private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();

    public void onTestStart(ITestResult iTestResult) {
        ExtentTest test = extentReports.createTest(iTestResult.getMethod().getMethodName());
        extentTest.set(test);
    }

    public void onTestSuccess(ITestResult iTestResult) {
        extentTest.get().log(Status.PASS, MarkupHelper.createLabel(iTestResult.getName() + " Test Case PASSED", ExtentColor.GREEN));
    }

    public void onTestFailure(ITestResult iTestResult) {
        extentTest.get().log(Status.FAIL, MarkupHelper.createLabel(iTestResult.getName() + " Test Case FAILED", ExtentColor.RED));
        extentTest.get().fail(iTestResult.getThrowable());
    }

    public void onTestSkipped(ITestResult iTestResult) {
        extentTest.get().log(Status.SKIP, MarkupHelper.createLabel(iTestResult.getName() + " Test Case SKIPPED", ExtentColor.ORANGE));
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
        // ignore this
    }

    public void onStart(ITestContext iTestContext) {
        // ignore this
    }

    public void onFinish(ITestContext iTestContext) {
        extentReports.flush();
    }
}
