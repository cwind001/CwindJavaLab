package ch5.rmi;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.rmi.RMISecurityManager;
import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: Cwind
 * Date: 2015/6/23
 * Email: billchen01@163.com
 */
public class WarehouseClient {
    public static void main(String[] args){
        System.setProperty("java.security.policy", "E:\\SourceCode\\Github\\CwindJavaLab\\CoreJava\\src\\ch5\\rmi\\client.policy");
        System.setSecurityManager(new RMISecurityManager());

        String url ="rmi://127.0.0.1:6600/warehouse";
        Context namingContext = null;
        try {
            namingContext = new InitialContext();
            Warehouse centralWarehouse = (Warehouse) namingContext.lookup(url);
            JFrame frame = new WarehouseClientFrame(centralWarehouse);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        } catch (NamingException e) {
            e.printStackTrace();
        }

    }
}

class WarehouseClientFrame extends JFrame{

    private Warehouse warehouse;
    private JTextField age;
    private JRadioButton male;
    private JRadioButton female;
    private ArrayList<JCheckBox> hobbies;
    private JTextArea result;

    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 300;

    public WarehouseClientFrame(Warehouse warehouse) throws HeadlessException {
        this.warehouse = warehouse;
        setTitle("warehouseClient");
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0,2));

        panel.add(new JLabel("Age: "));
        age = new JTextField(4);
        age.setText("20");
        panel.add(age);

        female = new JRadioButton("Female", true);
        male = new JRadioButton("Male", true);
        ButtonGroup group = new ButtonGroup();
        panel.add(female);
        group.add(female);
        panel.add(male);
        group.add(male);

        panel.add(new JLabel("Hobbies: "));
        hobbies = new ArrayList<JCheckBox>();
        for(String h : new String[] {"Gardening", "Beauty", "Computers", "Household", "Sports"}){
            JCheckBox checkBox = new JCheckBox(h);
            hobbies.add(checkBox);
            panel.add(checkBox);
        }

        result = new JTextArea(4, 40);
        result.setEditable(false);

        JPanel buttonPanel = new JPanel();
        JButton submitButton = new JButton("Submit");
        buttonPanel.add(submitButton);
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                callWarehouse();
            }
        });

        add(panel, BorderLayout.NORTH);
        add(result, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    private void callWarehouse(){
        try{
            ArrayList<String> selected = new ArrayList<String>();
            for(JCheckBox checkBox : hobbies){
                if(checkBox.isSelected()){
                    selected.add(checkBox.getText());
                }
            }
            Customer c = new Customer(Integer.parseInt(age.getText()), (male.isSelected()?1:0) + (female.isSelected()?2:0),
                    selected.toArray(new String[selected.size()]));

            ArrayList<Product> recommendations = warehouse.find(c);
            result.setText(c+"\n");
            for(Product p : recommendations){
                String t = p.getDescription() + "\n";
                result.append(t);
            }

        }catch (Exception e){
            e.printStackTrace();
            result.setText("Exception: " + e.getMessage());
        }
    }
}