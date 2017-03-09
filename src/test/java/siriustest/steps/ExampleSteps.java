package siriustest.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class ExampleSteps {

    private double a;
    private double b;

    @Then("^i get \"([^\"]*)\"$")
    public void iGet(double arg0) throws Throwable {
        Assert.assertEquals(a + b, arg0, 0.00001);
    }

    @Given("^first val \"([^\"]*)\" and second val \"([^\"]*)\"$")
    public void firstValAndSecondVal(double _a, double _b) throws Throwable {
        this.a = _a;
        this.b = _b;
    }

    @When("^i sum values$")
    public void iSumValues() throws Throwable {
    }
}
