/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package clientchat;

/**
 *
 * @author sosnov
 */
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
public class Window extends JFrame{
           static public String PanelStr="";
           static public class Panel extends JPanel{
           static public TextArea Tout, Tin;
           static public JButton Bsubm;
           static  String LoginUsr="user";
           static public ActionListener listener=new ActionListener(){                 
                @Override
                public void actionPerformed(ActionEvent event){
                   if (!Panel.Tin.getText().isEmpty()){
                        try {
                            ClientChat.Output.writeObject(new Message(LoginUsr,Panel.Tin.getText()));
                        } catch (IOException ex) {
                            System.out.print("nen");
                        }
                   }
                   Panel.Tin.setText("");                    
                }
            };
        }
        public Window(int w, int h, String login){            
            super("Client For Chat");
            setSize(w,h);
            setLocation(100,100);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setVisible(true);
            setLayout(null);
            Panel.Tout=new TextArea(" ");
            Panel.Tin=new TextArea(" ",0,0);
            Panel.Bsubm=new JButton("Submit!");
            Panel.Tout.setBounds(5,5,w-20,h-100-20);
            Panel.Tout.setEditable(false);
            Panel.Tin.setBounds(5,h-120,w-150,100-20);
            Panel.Bsubm.setBounds(w-150+5, h-120+15, (w-(w-150+5))-25, 80-20);           
            add(Panel.Tout);
            add(Panel.Tin);
            add(Panel.Bsubm);
            Panel.Bsubm.addActionListener(Panel.listener);      
            Panel.LoginUsr=login;
        }
         public static void println (String Str){
             Panel.Tout.append(Str+"\n");
        }
        public static void println (Message MsgStr){
             Panel.Tout.append("["+MsgStr.getLogin()+"] "+MsgStr.getMessage()+"\n");
        }
}



