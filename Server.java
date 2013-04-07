/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;
/**
 *
 * @author sosnov
 */
import java.io.*;
import java.net.*;
import Interactive.*;
public class Server {
    static String InputData, OutputData;
    public static void main(String[] args) throws IOException{
        Interactive.Terminal.println("Server runnig");
        BufferedReader Input;
        PrintWriter Output;
        ServerSocket ServerSkt =null;
        Socket ClientSkt= null;
        int Port;
        Port= Interactive.Terminal.RequestNumPort();
        try{
            ServerSkt = new ServerSocket(Port);
        }catch(IOException e){
            Interactive.Terminal.println("uncorrect port: "+Port);
            System.exit(-1);
        }
        try{
            Interactive.Terminal.println("Waiting a client...");
            ClientSkt=ServerSkt.accept();
            Interactive.Terminal.println("Client Connected");
        }catch(IOException e){
            Interactive.Terminal.println("Can`t accept");
            System.exit(-1);
        }
        Input=new BufferedReader(new InputStreamReader (ClientSkt.getInputStream()));
        Output=new PrintWriter(ClientSkt.getOutputStream(),true);
        Interactive.Terminal.println("Waiting message for client...");
        while((InputData=Input.readLine())!=null){
            if(InputData.equalsIgnoreCase("exit")) break;
            Output.println("Server responded::: "+InputData);
            Interactive.Terminal.println(InputData);
        }
        Output.close();
        Input.close();
        ClientSkt.close();
        ServerSkt.accept();
    }
}
