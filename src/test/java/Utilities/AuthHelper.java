package Utilities;

import Pages.DialogContent;
import Pages.LeftNav;
import org.apache.commons.lang3.RandomStringUtils;

public class AuthHelper {
    public static String lastUserName;
    public static String lastPassword;

    public static String registerLogoutLogin(){
        lastUserName = RandomStringUtils.randomAlphanumeric(10);
        lastPassword = RandomStringUtils.randomAlphanumeric(10);
        String baseData = RandomStringUtils.randomAlphanumeric(8);

        LeftNav ln = new LeftNav();
        DialogContent dc = new DialogContent();

        ln.myClick(ln.btnRegister);

        dc.mySendKeys(dc.firstName,baseData);
        dc.mySendKeys(dc.lastName,baseData);
        dc.mySendKeys(dc.adress,baseData);
        dc.mySendKeys(dc.city,baseData);
        dc.mySendKeys(dc.state,baseData);
        dc.mySendKeys(dc.zipCode,"10000");
        dc.mySendKeys(dc.phone,"0501234567");
        dc.mySendKeys(dc.ssn,"12345");


        dc.mySendKeys(dc.username,lastUserName);
        dc.mySendKeys(dc.password,lastPassword);
        dc.mySendKeys(dc.confirmPassword,lastPassword);

        dc.myClick(dc.confirmRegister);
        ln.myClick(ln.btnLogout);

        ln.mySendKeys(ln.username,lastUserName);
        ln.mySendKeys(ln.password,lastPassword);
        ln.myClick(ln.btnLogin);
        System.out.print("Username : ");
        System.out.println(lastUserName);
        System.out.print("Password : ");
        System.out.println(lastPassword);
        return lastUserName;
    }

    public static void login(){
        LeftNav ln = new LeftNav();
        DialogContent dc = new DialogContent();

        ln.mySendKeys(ln.username,lastUserName);
        ln.mySendKeys(ln.password,lastPassword);
        ln.myClick(ln.btnLogin);
    }
}
