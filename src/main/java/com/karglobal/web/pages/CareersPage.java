package com.karglobal.web.pages;

import com.karglobal.web.core.utils.BrowserUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

import java.util.List;

public class CareersPage {

    @FindBy(how = How.XPATH, using = "//*[text()='Location']")
    private WebElement filterByLocation;

    @FindBy(how = How.XPATH, using = "//*[text()='Team']")
    private WebElement filterByTeam;

    @FindBy(how = How.XPATH, using = "//span[@class='sort-by-team posting-category small-category-label']")
    private List<WebElement>  postingCategoryTeam;

    @FindBy(how = How.XPATH, using = "//span[@class='sort-by-location posting-category small-category-label']")
    private List<WebElement> postingCategoryLocation;

    final static Logger logger = Logger.getLogger(CareersPage.class);

    public void validateJobsSearchByCityAndTeam(String location, String team) {
       try{
           filterByLocation.click();
           selectFilterByText(location).click();
           filterByTeam.click();
           selectFilterByText(team).click();
           validateJobResults(location, postingCategoryLocation);
           validateJobResults(team, postingCategoryTeam);
           numOfPositionsAvailable(location, team);

       } catch (Exception e){
          e.printStackTrace();
       }
    }

    public void validateJobSearchByCity(String location) {
        try{
            filterByLocation.click();
            selectFilterByText(location).click();
            validateJobResults(location, postingCategoryLocation);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public WebElement selectFilterByText(String text){
        return BrowserUtils.getDriver().findElement(By.xpath("//*[text()='"+ text + "']"));
    }

    public void validateJobResults(String text, List<WebElement> elements) {
        for (WebElement element : elements)
            if (element.getText().toUpperCase().contains(text.toUpperCase())) {
                logger.info("\n [" + text + "] available in the Search results \n");
            } else {
                logger.error("\n Mismatch!!! looked for [" + text + "] found :  [" + element.getText() + "] in the Search results \n");
                Assert.assertEquals(element.getText(), text, "Mismatch");
            };
    }

    public void numOfPositionsAvailable(String location, String team){
        logger.info("\n Total ["+ team +"] Positions available at ["+ location +"] is ["+ postingCategoryLocation.size()+"] \n");
    }
}
