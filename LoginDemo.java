package qna;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class LoginDemo extends JFrame implements ActionListener {
    JPanel panel;
    JLabel user_label, password_label, message;
    JTextField userName_text;
    JPasswordField password_text;
    JButton submit, cancel;
   
    static Boolean flag = false ;
    LoginDemo() {
        user_label = new JLabel();
        user_label.setText("User Name :");
        userName_text = new JTextField();
        password_label = new JLabel();
        password_label.setText("Password :");
        password_text = new JPasswordField();
        submit = new JButton("SUBMIT");
        panel = new JPanel(new GridLayout(9,3));
        panel.add(user_label);
        panel.add(userName_text);
        panel.add(password_label);
        panel.add(password_text);
        message = new JLabel();
        panel.add(message);
        panel.add(submit);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        submit.addActionListener(this);
        add(panel, BorderLayout.CENTER);
        setTitle("Please Login Here !");
        setLocation(370, 200);
        setSize(300,250);
   }
    public Boolean LoginProcedure(){
     
        while (flag == false){
            setVisible(true);
        }
        setVisible(false);
        return true;
    }
   
    public static void main(String[] args){
        new LoginDemo();
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        String userName = userName_text.getText();
        String password = password_text.getText();
        if (userName_text.getText().equals("yashraj") && password_text.getText().equals("12345")) {
            JOptionPane.showMessageDialog(panel, "Login Successful", "Welcome",JOptionPane.INFORMATION_MESSAGE);
            flag = true;
        } 
        else{
            JOptionPane.showMessageDialog(panel, "InCorrect Username or Password", "Error 404",JOptionPane.WARNING_MESSAGE);
        }
    }
}
