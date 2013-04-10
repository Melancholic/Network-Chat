/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package clientchat;
import java.io.*;
/**
 *
 * @author sosnov
 */
public class Message implements Serializable{
    private String Login;
    private String  Message;
    private String[] Users;
    public Message(String login, String message){
        this.Login=login;
        this.Message=message;
    }
    public  Message(String login, String message, String[] users){
        this.Login=login;
        this.Message=message;
        this.Users=users;
    }
    public String getLogin(){
        return this.Login;
    }
    public String getMessage(){
        return this.Message;
    }
    public String[] getUsers(){
        return this.Users;
    }   
    
}