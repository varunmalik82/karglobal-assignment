package com.karglobal.web.pages;

import com.karglobal.web.core.utils.BrowserUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

public class WorkDayCareersPage {

    @FindBy(how = How.XPATH, using = "//button[@data-automation-id='navigationItem-Search for Jobs']")
    private WebElement pageTitle;

    public void validateCanadianJobsSite(String title, String url) {
        try {
            Assert.assertEquals(pageTitle.getText(), title);
            Assert.assertEquals(url, BrowserUtils.getDriver().getCurrentUrl());
        } catch(Exception e){
            e.printStackTrace();
        }
    }
}
