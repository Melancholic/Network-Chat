/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package serverchat;

import clientchat.Message;
import java.io.*;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sosnov
 */



public class ThreadClient extends Thread{
    private Message Msg;
    private Socket ClientSkt;
    ObjectInputStream  Input;
    ObjectOutputStream Output;
    public ThreadClient(Socket clientsSkt) throws IOException{
        super("New Thread");
        this.ClientSkt= clientsSkt;
        this.start();
    }
    @Override
    public void run() {
        try {
               System.out.println(this.Input);
        InputStream in = this.ClientSkt.getInputStream();
        this.Input=new ObjectInputStream(in); 
        System.out.println(this.Input);
        OutputStream out = this.ClientSkt.getOutputStream();
        this.Output=new ObjectOutputStream(out);
        System.out.println("Waiting message for client...");
        Message InputStr;
            try {
                while((InputStr=(Message)this.Input.readObject())!=null){
                    if(InputStr.getMessage().equalsIgnoreCase("exit")) break;      
                            ServerChat.SendMsg(InputStr);
                            

                }
            } catch (ClassNotFoundException ex) {
                System.out.println("err1");
                
                ex.printStackTrace();
            }
                } catch (IOException e) {
                    System.out.println("err");
            Logger.getLogger(ThreadClient.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public void Send(Message a) throws IOException{
        this.Output.writeObject(a);
    }
    
}
