package StepDefinitions;

import Pages.DialogContent;
import Pages.LeftNav;
import io.cucumber.java.en.And;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Map;

public class TransferSteps {

    LeftNav ln = new LeftNav();
    DialogContent dc = new DialogContent();

    @And("Click on the Element in LeftNav")
    public void clickTransferFunds(DataTable dt){
        List<String> keys = dt.asList(String.class);

        for(String key : keys){
            WebElement el = ln.getWebElement(key);
            ln.myClick(el);
        }
    }

    @When("User enters transfer information")
    public void userEnterTransferInformation(DataTable dt){
        Map<String, String> transferData = dt.asMap();

        String sender = transferData.get("senderAccount");
        String receiver = transferData.get("receiverAccount");
        String amount = transferData.get("amount");

        System.out.println("Transfer Məlumatları : ");
        System.out.println("Sender index: " + sender);
        System.out.println("Receiver index: " + receiver);
        System.out.println("Amount: '" + amount + "'");

        if (amount != null && !amount.isEmpty()) {
            dc.enterAmount(amount);
        } else {
            dc.clearAmountField();
        }
        if (sender != null && !sender.isEmpty()) {
            dc.selectSenderAccountByIndex(Integer.parseInt(sender));
        }
        if (receiver != null && !receiver.isEmpty()) {
            dc.selectReceiverAccountByIndex(Integer.parseInt(receiver));
        }

    }

    @And("User confirms transfer")
    public void userConfirmsTransfer(){
        dc.myClick(dc.transfer);
    }

    @Then("Result message should be displayed")
    public void resultMessageDisplayed(DataTable dt){
        List<String> messages = dt.asList(String.class);

        for (String msg : messages){
            dc.verifyMessageContainsText(msg);
        }
    }
}
