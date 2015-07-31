package ch9.security;

import java.security.PrivilegedAction;

/**
 * Created with IntelliJ IDEA.
 * User: Cwind
 * Date: 7/31/2015
 * Email: billchen01@163.com
 */
public class SysPropAction implements PrivilegedAction{

    private String propertyName;

    public SysPropAction(String propertyName){
        this.propertyName = propertyName;
    }

    @Override
    public Object run() {
        return System.getProperty(propertyName);
    }
}
