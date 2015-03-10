/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2.server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sheyla
 */
public class ServerController implements Runnable{
    
    ServerModel model;
    ServerView view;
    
    ServerSocket serverSocket;
    
    public void setView( ServerView view ){ this.view = view; }
    public void setModel( ServerModel model ){ this.model = model; }
        
    void sendMessage( String message )
    { 
            model.sendMessageToAll(message);
            view.logMessage(message);
    }
        
    
    @Override
    public void run() {
        while(true){
            Socket socket;
            try {
                serverSocket = new ServerSocket( 54321 );
                socket = serverSocket.accept();
                InputStream in = socket.getInputStream(); 
                OutputStream out = socket.getOutputStream();
                model.addConnection( new Connection( socket, in, out, this ) );
                view.logMessage(  socket.getInetAddress() + " has established a connection" );
                serverSocket.close(); 
            }catch (IOException ex) {
                Logger.getLogger(ServerController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    void startServer() {
        Thread worker = new Thread( this );
        worker.start();
    }
    
}


