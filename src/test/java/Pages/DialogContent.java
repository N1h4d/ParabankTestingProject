package Pages;

import Utilities.GWD;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;
import java.util.logging.XMLFormatter;

public class DialogContent extends ParentPage {

    public DialogContent() {
        PageFactory.initElements(GWD.getDriver(), this);
    }

    @FindBy(xpath = "//*[@id='customer.firstName']")
    public WebElement firstName;

    @FindBy(xpath = "//*[@id='customer.lastName']")
    public WebElement lastName;

    @FindBy(xpath = "//*[@id='customer.address.street']")
    public WebElement adress;

    @FindBy(xpath = "//input[@id='customer.address.city']")
    public WebElement city;

    @FindBy(xpath = "//input[@id='customer.address.state']")
    public WebElement state;

    @FindBy(xpath = "//input[@id='customer.address.zipCode']")
    public WebElement zipCode;

    @FindBy(xpath = "//input[@id='customer.phoneNumber']")
    public WebElement phone;

    @FindBy(xpath = "//input[@id='customer.ssn']")
    public WebElement ssn;

    @FindBy(xpath = "//input[@id='customer.username']")
    public WebElement username;

    @FindBy(xpath = "//input[@id='customer.password']")
    public WebElement password;

    @FindBy(xpath = "//input[@id='repeatedPassword']")
    public WebElement confirmPassword;

    @FindBy(xpath = "//input[@class='button' and @value='Register']")
    public WebElement confirmRegister;

    @FindBy(xpath = "//*/form/select[@id='type']")
    public WebElement accountTypeDropdown;

    @FindBy(xpath = "//input[@value='Open New Account']")
    public WebElement btnNewAccount;

    public By btnNewAccountLocator = By.xpath("//input[@value='Open New Account']");

    @FindBy(xpath = "(//*/form/p/b)[2]")
    public WebElement minimumBalance;

    @FindBy(xpath = "//div[@id='rightPanel']")
    public WebElement messageBoxDC;


    @FindBy(xpath = "//select[@id='fromAccountId']")
    private WebElement senderDropdown;

    @FindBy(xpath = "//select[@id='toAccountId']")
    private WebElement receiverDropdown;

    @FindBy(xpath = "//input[@id='amount']")
    private WebElement amountField;

    @FindBy(xpath = "//div/input[@class='button']")
    public WebElement transfer;

    @FindBy(xpath = "(//div[@id='showResult']/p)[1]")
    public WebElement transferText;

    @FindBy(xpath = "//*[@id='accountTable']/tbody/tr[1]/td[1]/a")
    public WebElement firstAccount;

    @FindBy(xpath = "//*[@id='transactionTable']/tbody/tr[1]/td[2]/a")
    public WebElement transaction;

    @FindBy(xpath = "//*[@id='rightPanel']/table/tbody/tr[1]/td[2]")
    public WebElement transactionID;

    @FindBy(xpath = "//input[@id='transactionId']")
    public WebElement transactionIdInput;

    @FindBy(xpath = "//button[@id='transactionId']")
    public WebElement findTransactionsButton;


    public void selectSenderAccountByIndex(int index) {
        wait.until(ExpectedConditions.elementToBeClickable(senderDropdown));
        Select select = new Select(senderDropdown);
        try {
            Thread.sleep(3000);
            select.selectByIndex(index);
        } catch (Exception e) {

        }
    }

    public void selectReceiverAccountByIndex(int index) {
        wait.until(ExpectedConditions.elementToBeClickable(receiverDropdown));
        WebDriverWait wait = new WebDriverWait(GWD.getDriver(), Duration.ofSeconds(10));
        Select select = new Select(receiverDropdown);
        try {
            Thread.sleep(3000);
            select.selectByIndex(index);
        } catch (Exception e) {

        }
    }

    public void enterAmount(String amount) {
        wait.until(ExpectedConditions.visibilityOf(amountField));
        amountField.clear();
        amountField.sendKeys(amount);
    }

    public void clearAmountField() {
        wait.until(ExpectedConditions.visibilityOf(amountField));
        amountField.clear();
    }

    public WebElement getWebElement(String key) {
        switch (key.trim()) {
            case "senderAccount":
                return accountTypeDropdown;
            case "receiverAccount":
                return btnNewAccount;
            case "minimumBalance":
                return minimumBalance;
            case "messageBoxDC":
                return messageBoxDC;
            default:
                return null;
            // Register burada olacaq
        }
    }

    public void waitUntilTextContains(WebElement element, String expected){
        // Web-de bezen elementler(icersindeki text-ler) gec yuklendiyi ucun
        // MessageBox sistemi ucun elave gozleme yeri teyin edirik ki
        // Assert etmezden evvel element icindeki textin varligini gore bilek
        wait.until(ExpectedConditions.visibilityOf(element));
        wait.until(ExpectedConditions.textToBePresentInElement(element,expected));
    }

    public void verifyMessageContainsText(String expectedText){ // resuable
        waitUntilTextContains(messageBoxDC,expectedText);

        wait.until(ExpectedConditions.visibilityOf(messageBoxDC));
        String actualText = messageBoxDC.getText().toLowerCase();

        Assert.assertTrue(actualText.contains(expectedText.toLowerCase()),
                "Expected text not found : " + expectedText);
    }
}
