package ch5.rmi;

import javax.naming.*;

/**
 * Created with IntelliJ IDEA.
 * User: Cwind
 * Date: 6/23/2015
 * Email: billchen01@163.com
 */
public class ShowBindings {
    public static void main(String[] args){
        try{
            Context namingContext = new InitialContext();
            NamingEnumeration<NameClassPair> e = namingContext.list("rmi://127.0.0.1:6600/");
            while (e.hasMore()) {
                System.out.println(e.next().getName());
            }
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }
}
