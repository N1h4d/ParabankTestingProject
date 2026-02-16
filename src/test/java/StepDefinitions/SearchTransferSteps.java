package StepDefinitions;

import Pages.DialogContent;
import Pages.LeftNav;
import Utilities.AuthHelper;
import Utilities.GWD;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class SearchTransferSteps {

    LeftNav ln = new LeftNav();
    DialogContent dc = new DialogContent();
    private String transactionId;

    @Given("User has completed a transfer")
    public void userHasCompletedTransfer(){
        GWD.getDriver().get("arabank.parasoft.com/parabank/");
        AuthHelper.login();
        dc.myClick(dc.firstAccount);
        dc.myClick(dc.transaction);
        transactionId=dc.transactionID.getText().trim();
    }

    @When("User searches transfer by transaction ID")
    public void userSearchTransferById(){
        ln.myClick(ln.findTransactions);
        dc.mySendKeys(dc.transactionIdInput,transactionId);
        dc.myClick(dc.findTransactionsButton);
    }

    @Then("Transfer record should be displayed")
    public void tranferRecordDisplayed(){

    }
}
