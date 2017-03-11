package siriustest.steps;

import cucumber.api.java.en.When;

public class UserActionSteps {

    @When("^user waits for timeout \"([^\"]*)\"$")
    public void userWaitsForTimeout(int timeout) throws Throwable {
        Thread.sleep( timeout * 1000 );
    }
}