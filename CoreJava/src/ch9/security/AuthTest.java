package ch9.security;

import javax.security.auth.Subject;
import javax.security.auth.login.LoginContext;
import javax.security.auth.login.LoginException;
import java.security.PrivilegedAction;

/**
 * Created with IntelliJ IDEA.
 * User: Cwind
 * Date: 7/31/2015
 * Email: billchen01@163.com
 */
public class AuthTest {

    public static void main(String[] args) {
        try{
            System.setSecurityManager(new SecurityManager());
            LoginContext context = new LoginContext("Login1");
            context.login();
            System.out.println("Authentication successful.");
            Subject subject = context.getSubject();
            System.out.println("subject=" + subject);
            PrivilegedAction<String> action = new SysPropAction("user.home");
            Object result = Subject.doAsPrivileged(subject, action, null);
            System.out.println(result);
            context.logout();

        } catch (LoginException e) {
            e.printStackTrace();
        }
    }
}
