package com.selenium.framework;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;

public class listeners implements ITestListener {

    Base baseobj = new Base();

    public void onTestStart(ITestResult result) {

    }

    public void onTestSuccess(ITestResult result) {


    }

    public void onTestFailure(ITestResult result) {
        try {
            baseobj.getScreenShot();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void onTestSkipped(ITestResult result) {

    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    public void onStart(ITestContext context) {

    }

    public void onFinish(ITestContext context) {

    }
}
