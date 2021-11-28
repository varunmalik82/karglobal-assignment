package com.karglobal.web;

import com.karglobal.web.core.utils.BrowserUtils;
import com.karglobal.web.pages.CareersPage;
import com.karglobal.web.pages.HomePage;
import com.karglobal.web.pages.WorkDayCareersPage;
import com.karglobal.web.pages.WorkWithTradeRevPage;
import org.openqa.selenium.support.PageFactory;
import java.util.Objects;

public class PageObjectManager {
    private static HomePage homePage;
    private static CareersPage careersPage;
    private static WorkDayCareersPage workDayCareersPage;
    private static WorkWithTradeRevPage workWithTradeRevPage;

    public static synchronized HomePage getHomePageInstance(){
        return Objects.nonNull(homePage) ? homePage : PageFactory.initElements(BrowserUtils.getDriver(), HomePage.class);
    }

    public static synchronized CareersPage getCareersPageInstance(){
        return Objects.nonNull(careersPage) ? careersPage : PageFactory.initElements(BrowserUtils.getDriver(), CareersPage.class);
    }

    public static synchronized WorkDayCareersPage getWorkDayCareersPageInstance(){
        return Objects.nonNull(workDayCareersPage) ? workDayCareersPage : PageFactory.initElements(BrowserUtils.getDriver(), WorkDayCareersPage.class);
    }

    public static synchronized WorkWithTradeRevPage getWorkWithTradeRevPageInstance(){
        return Objects.nonNull(workWithTradeRevPage) ? workWithTradeRevPage : PageFactory.initElements(BrowserUtils.getDriver(), WorkWithTradeRevPage.class);
    }
}
