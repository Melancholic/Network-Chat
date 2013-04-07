/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

/**
 *
 * @author sosnov
 */
import java.io.*;
import java.net.*;
import Interactive.*;
public class Client {
    public static void main(String[] args) throws IOException{
        Interactive.Window Window=new Interactive.Window(600,400);
        Interactive.Terminal.println("Welcome to client!");
        Interactive.Window.println("Welcome to client!");
        Socket ServerSkt = null;
        BufferedReader Input;
        PrintWriter Output;
        String UserStr;
        String ServerStr;
        if (args.length== 0){
            Interactive.Terminal.println("Unknow parametr, use: client hostname");
            Interactive.Window.println("Unknow parametr, use: client hostname");
            System.exit(-1);
        }
        Interactive.Terminal.println("Connecting to "+args[0]+"...");
        Interactive.Window.println("Connecting to "+args[0]+"...");
        ServerSkt=new Socket(args[0],Interactive.Terminal.RequestNumPort());
        Input=new BufferedReader(new InputStreamReader(ServerSkt.getInputStream()));
        Output=new PrintWriter(ServerSkt.getOutputStream(),true);
       // System.out.println(Window.InputStr.nextLine());
        //while((UserStr=Interactive.Terminal.getStrWithKey())!=null){
        String UserStrPred="";
        while(true){
            System.out.println(Interactive.Window.PanelStr);
            if(!Window.PanelStr.equals("")){
                
                UserStr=Window.PanelStr;              
                Output.println(UserStr);
                UserStrPred=UserStr;
                Window.PanelStr="";
                ServerStr=Input.readLine();
                Interactive.Terminal.println("Server resp: "+ServerStr);
                Interactive.Window.println("Server resp: "+ServerStr);
                if(UserStr.equalsIgnoreCase("close")||UserStr.equalsIgnoreCase("exit")){
                    break;
                }
            }
        }
        System.out.println("aaa");
        Output.close();
        Input.close();
        ServerSkt.close();
    }
    
}
    