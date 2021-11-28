package com.karglobal.web.pages;

import com.karglobal.web.core.utils.BrowserUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class WorkWithTradeRevPage {

    @FindBy(how = How.CSS, using = "a.job-links__button.job-links__button--ca")
    private WebElement seeOpenOpportunities;

    private WorkDayCareersPage workDayCareersPage;

    public WorkDayCareersPage navigateToKarGlobalCarrersPage() {
        BrowserUtils.waitForElement(seeOpenOpportunities).click();
        BrowserUtils.getDriver().switchTo().window(BrowserUtils.getWindowHandles().get(2));
        return workDayCareersPage;
    }

}

