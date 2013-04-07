
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Interactive;

/**
 *
 * @author sosnov
 */
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Interactive{
    static public class Terminal{
        static private Scanner Data;
        public  static int RequestNumPort(){
            Scanner Data=new Scanner(System.in);
            int Port;
            System.out.print("Input port: ");
            try{
                Port=Data.nextInt();
            }catch(InputMismatchException e){
                System.out.println("Incorrect port. Please, input number port( ex: 3353) ");
                Port=RequestNumPort();
            }
            return Port;
        }
        public static String getStrWithKey(){
            String Str;
            Scanner Data=new Scanner(System.in);
            Str=Data.nextLine();
            return Str;
        }
        public static void println(String Str){
            System.out.println(Str);
        }
        public static void print (String Str){
            System.out.print(Str);
        }
    }
    static public class Window extends JFrame{
        static String RetStr(String Str){
            return Str;
        }
       // static public Scanner InputStr=new Scanner("test");
        static public String PanelStr="";
       static  public class Panel extends JPanel{
           static public TextArea Tout, Tin;
           static public JButton Bsubm;
           static public ActionListener listener=new ActionListener(){                 
                @Override
                public void actionPerformed(ActionEvent event){
                   PanelStr=Panel.Tin.getText(); 
                   Panel.Tin.setText("");
                   // System.out.println(InputStr.nextLine());                    
                }
            };
        }
        public Window(int w, int h){
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
       
        }
         public static void println (String Str){
            //Panel.Tout.setCaretPosition(Panel.Tout.getText().length()+1);
           // Panel.Tout.insert(Str+"\n",Panel.Tout.getCaretPosition());
             Panel.Tout.append(Str+"\n");
        }

    }
}
