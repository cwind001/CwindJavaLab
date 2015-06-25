package ch9.security;

import java.applet.Applet;
import java.awt.*;

/**
 * Created with IntelliJ IDEA.
 * User: Cwind
 * Date: 2015/6/25
 * Email: billchen01@163.com
 */
public class VerifierTest extends Applet {

    public static void main(String[] args){
        System.out.println("1 + 2 == " +fun());
    }

    public static int fun(){
        int m;
        int n;
        n = 1;
        m = 2;
        int r = m + n;
        return r;
    }

    public void paint(Graphics g){
        g.drawString("1 + 2 == " + fun(), 20, 20);
    }
}
