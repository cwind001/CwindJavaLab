package ch9.security;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created with IntelliJ IDEA.
 * User: Cwind
 * Date: 6/24/2015
 * Email: billchen01@163.com
 */
public class ClassLoaderTest {
    public static void main(String[] args){
        JFrame frame = new ClassLoaderFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}

class ClassLoaderFrame extends JFrame{
    private JTextField keyField = new JTextField("3", 4);
    private JTextField nameField = new JTextField(30);
    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 200;

    public ClassLoaderFrame() {
        setTitle("ClassLoaderTest");
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        setLayout(new GridBagLayout());
        add(new JLabel("Class"), new GBC(0, 0).setAnchor(GBC.EAST));
        add(nameField, new GBC(1, 0).setWeight(100, 0).setAnchor(GBC.WEST));
        add(new JLabel("Key"), new GBC(0,1).setWeight(100, 0).setAnchor(GBC.EAST));
        add(keyField, new GBC(1,1).setWeight(100, 0).setAnchor(GBC.WEST));
        JButton loadButton = new JButton("Load");
        add(loadButton, new GBC(0,2,2,1));
        loadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                runClass(nameField.getText(), keyField.getText());
            }
        });
        pack();
    }

    public void runClass(String name, String key){
        try{
            ClassLoader loader = new CryptoClassLoader(Integer.parseInt(key));
            Class c = loader.loadClass(name);
            String[] args = new String[]{};
            Method m =c.getMethod("main", args.getClass());
            m.invoke(null, (Object) args);
        } catch (Throwable e) {
            JOptionPane.showMessageDialog(this, e);
        }
    }
}

class CryptoClassLoader extends ClassLoader{
    private int key;

    public CryptoClassLoader(int key) {
        this.key = key;
    }

    protected Class findClass(String name) throws ClassNotFoundException {
        byte[] classBytes = null;
        try{
            classBytes = loadClassBytes(name);
        } catch (IOException e) {
            throw new ClassNotFoundException();
        }
        Class cl = defineClass(name, classBytes, 0, classBytes.length);
        if(cl==null){
            throw new ClassNotFoundException(name);
        }
        return cl;
    }

    private byte[] loadClassBytes(String name) throws IOException {
        String cname = name.replace('.', '/') + ".caesar";
        FileInputStream in = null;
        in = new FileInputStream(cname);
        try{
            ByteArrayOutputStream buffer = new ByteArrayOutputStream();
            int ch;
            while ((ch=in.read())!=-1){
                byte b = (byte) (ch-key);
                buffer.write(b);
            }
            in.close();
            return buffer.toByteArray();
        }finally {
            in.close();
        }
    }
}
