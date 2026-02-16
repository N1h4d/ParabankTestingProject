package Pages;

import Utilities.GWD;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeftNav extends ParentPage {

    public LeftNav() {
        PageFactory.initElements(GWD.getDriver(),this);
    }

    @FindBy(xpath = "//input[@name='username']")
    public WebElement username;

    @FindBy(xpath = "//input[@name='password']")
    public WebElement password;

    @FindBy(xpath = "//input[@value='Log In']")
    public WebElement btnLogin;

    @FindBy(xpath = "//a[text()='Log Out']")
    public WebElement btnLogout;

    @FindBy(xpath = "//a[text()='Register']")
    public WebElement btnRegister;

    @FindBy(xpath = "//a[text()='Bill Pay']")
    public WebElement billPay;

    @FindBy(xpath = "(//div[@id='leftPanel']/ul/li/a)[1]")
    public WebElement openNewAccount;

    @FindBy(xpath = "//*[@id='leftPanel']/ul/li[3]/a")
    public WebElement transferFunds;

    @FindBy(xpath = "//*[@id='leftPanel']/ul/li[5]/a")
    public WebElement findTransactions;

    public WebElement getWebElement(String key){
        switch (key.trim()){ // toLowerCase veya ignoreCase elave etmek
            // daha mentiqi olacaq real layihelerde
            case "transferFunds" : return transferFunds;
            case "btnRegister" : return btnRegister;
            case "btnLogout" : return btnLogout;
            case "btnLogin" : return btnLogin;
            default:return null;
        }
    }







}
