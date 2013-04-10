/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package clientchat;

/**
 *
 * @author sosnov
 */
import java.io.*;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;
public class ClientChat {
        public static   ObjectInputStream Input;
        public static ObjectOutputStream Output;
    static private final int Port=3229; 
    static private final String  ServerIP="localhost"; 
    public static void main(String[] args) throws IOException{
        if(args.length==0){
            System.out.println("Use: client username");
            System.exit(1);
        }
    Window Window=new Window(600,400, args[0]);
        Window.println("Welcome to client!");
        Socket ServerSkt = null;
        String UserStr;
        Window.println("Connecting to server..");
        ServerSkt=new Socket(ServerIP,Port);
        Output=new ObjectOutputStream(ServerSkt.getOutputStream());  
        Input=new ObjectInputStream(ServerSkt.getInputStream());      
        Window.println("Ok!");
        while(true){
            System.out.println(Window.PanelStr);     
                UserStr=Window.PanelStr;              
                Window.PanelStr="";
            try {
                Window.println((Message)Input.readObject());
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ClientChat.class.getName()).log(Level.SEVERE, null, ex);
            }
                if(UserStr.equalsIgnoreCase("close")||UserStr.equalsIgnoreCase("exit")){
                   break;
                }
        }
        Output.close();
        Input.close();
        ServerSkt.close();
        
    }
    
}
    
