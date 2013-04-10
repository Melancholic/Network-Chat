/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package serverchat;

/**
 *
 * @author sosnov
 */
import clientchat.Message;
import java.io.*;
import java.net.*;
import java.util.*;
public class ServerChat {
    static private final int Port=3229; 
    static  ArrayList<ThreadClient> listClients = new ArrayList<>();

    static String InputData, OutputData;
    public static void main(String[] args) throws IOException{
        System.out.println("Server runnig");
        ServerSocket ServerSkt =null;
        Socket ClientSkt= null;   
        try{
            ServerSkt = new ServerSocket(Port);
        }catch(IOException e){
            System.out.println("uncorrect port: "+Port);
            System.exit(-1);
        }
        try{
            while(true){
                ClientSkt=null;
                System.out.println("Waiting a client...");
                while(ClientSkt==null){
                    ClientSkt=ServerSkt.accept();
                }
                listClients.add(new ThreadClient(ClientSkt));
                System.out.println("New Client Connected");  
            }
        }catch(IOException e){
            System.out.println("Can`t accept");
            System.exit(-1);
        }
        ClientSkt.close();
        ServerSkt.accept();
    }
    static void SendMsg(Message Msg) throws IOException{
        for(int i=0;i<ServerChat.listClients.size();++i){
            ServerChat.listClients.get(i).Send(Msg);
        }  
    }
       
    }

