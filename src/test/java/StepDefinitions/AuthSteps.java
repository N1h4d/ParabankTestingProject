package StepDefinitions;

import Pages.DialogContent;
import Pages.LeftNav;
import Utilities.AuthHelper;
import Utilities.GWD;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;

public class AuthSteps {

    LeftNav ln = new LeftNav();
    DialogContent dc = new DialogContent();

    @Given("Navigate to Parabank")
    public void navigateToParabank() {
        GWD.getDriver().get("https://parabank.parasoft.com");
    }


    @And("User is logged in")
    public void userRegistersAndLogsIn() {
        AuthHelper.registerLogoutLogin();
    }

    @And("User has at least 2 accounts")
    public void userHasTwoAccounts() {
        ln.myClick(ln.openNewAccount);
        dc.mySelectByText(dc.accountTypeDropdown, "CHECKING");
        dc.smartClick(dc.btnNewAccountLocator);
    }
}
