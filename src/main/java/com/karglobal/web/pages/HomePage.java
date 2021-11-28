package com.karglobal.web.pages;

import com.karglobal.web.core.utils.BrowserUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HomePage {

    @FindBy(how = How.XPATH, using = "//a[@href='https://work.traderev.com/']")
    private WebElement careersLink;

    final static Logger logger = Logger.getLogger(CareersPage.class);
    private WorkWithTradeRevPage workWithTradeRevPage;

    public WorkWithTradeRevPage navigateToWorkWithTradeRev() {
        BrowserUtils.waitForElement(careersLink).click();
        BrowserUtils.getDriver().switchTo().window(BrowserUtils.getWindowHandles().get(1));
        return workWithTradeRevPage;
    }
}
