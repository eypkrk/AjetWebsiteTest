import org.openqa.selenium.WebDriver;

public class LoginButton extends BasePage{
    Variables variables;
    public LoginButton(WebDriver driver) {
        super(driver);
        variables = new Variables();
    }

    public void loginPage(){
        waits("css",variables.loginButton);
        find("css",variables.loginButton);
        click("css",variables.loginButton);
        screenSchot(find("css",variables.loginButton.concat(" span")).getText());
        waits("css",variables.wantMember);
        find("css",variables.wantMember);
        click("css",variables.wantMember);
        waits("xpath","//div[@class='p-32 w-full']/p[1]");
        scroll(400);
        screenSchot(find("xpath","//div[@class='p-32 w-full']/p[1]").getText());
        waits("css",variables.memberName);
        click("css",variables.memberName);
        waits("css",variables.memberLastName);
        click("css",variables.memberLastName);
        sendText("css",variables.memberLastName,"Karakoyun");
        System.out.println(find("xpath","//div[1]/div[1]/div[@class='text-xs p-error mt-5']").getText());
        sendText("css",variables.memberName,"Aliye");
        waits("css",variables.memberBirth);
        sendText("css",variables.memberBirth,"15.02.1920");
        waits("xpath",variables.memberGender);
        click("xpath",variables.memberGender);
        waits("css",variables.memberPhone);
        sendText("css",variables.memberPhone,"5552223311");
        scroll(600);
        waits("css",variables.memberMail);
        sendText("css",variables.memberMail,"deneme@hotmail.com");
        waits("css",variables.memberPassword);
        sendText("css",variables.memberPassword,"Deneme.123");
        click("css",variables.showPassword);
        screenSchot(find("css","p[class='aj-font text-2xl text-secondary-500 font-semibold']").getText());
        scroll(1000);
        waits("css",variables.acceptMemberRules);
        click("css",variables.acceptMemberRules);
        waits("css",variables.acceptCookie);
        click("css",variables.acceptCookie);
        waits("clickcss",variables.signUp);
        click("css",variables.signUp);
        waits("clickcss",variables.signIn);
        click("css",variables.signIn);
        waits("clickcss",variables.closeScreen);
        click("css",variables.closeScreen);
        waits("clickcss",variables.signIn);
        click("css",variables.signIn);
        waits("css",variables.signInMeberPhone);
        sendText("css",variables.signInMeberPhone,"5552223344");
        waits("css",variables.singInPassword);
        sendText("css",variables.singInPassword,"deneme123");
        waits("css",variables.seePassword);
        click("css",variables.seePassword);
        click("xpath",variables.rememberMe);
        screenSchot(find("css","p[class='aj-font-secondary text-xl font-medium']").getText());
        click("css",variables.signInButton);
        waits("css",variables.forgetPassword);
        click("css",variables.forgetPassword);
        waits("css",variables.forgetPasswordMail);
        sendText("css",variables.forgetPasswordMail,"deneme@hotmail.com");
        waits("css",variables.sendMail);
        click("css",variables.sendMail);
        screenSchot(find("css","div[class='aj-font text-secondary-500 text-2xl font-semibold']").getText());        //waits("clickcss",variables.closeScreen);
        //click("css",variables.closeScreen);
        //waits("clickcss",variables.signUp);
        //click("css",variables.signUp);

    }
}
