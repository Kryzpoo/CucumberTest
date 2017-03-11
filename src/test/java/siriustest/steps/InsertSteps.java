package siriustest.steps;

import cucumber.api.java.en.When;
import org.openqa.selenium.interactions.Actions;
import siriustest.manage.TestManager;

public class InsertSteps {

    private Actions inputExecutor = TestManager.getInputExecutor();

    // TODO: 11.03.2017 Найти способ избавитьься от sleep()
    @When("^user inserts \"([^\"]*)\" into field \\(Touch\\)$")
    public void userInsertsIntoFieldTouch(String text) throws Throwable {
        Thread.sleep(1000);
        inputExecutor.sendKeys( text );
        inputExecutor.build().perform();
    }

    @When("^user inserts \"([^\"]*)\" into field \\(FDK\\)$")
    public void userInsertsIntoFieldFDK(String text) throws Throwable {
        Thread.sleep(1000);
        inputExecutor.sendKeys( text );
        inputExecutor.build().perform();
    }
}
