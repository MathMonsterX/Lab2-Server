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
    
    sendMessage( message )
	for all connections
	write message to out
        
        public void setView( ServerView view ){ this.view = view; }
        public void setModel( ServerModel model ){ this.model = model; }
        
        
        void acceptingConnections(){ 
	serverSocket = new ServerSocket( 54321, 10, InetAddress.getLocalHost() );
	
        while(true){
            Socket socket;
            try {
                socket = serverSocket.accept();
                InputStream in = socket.getInputStream(); 
                OutputStream Stream out = socket.getOutputStream();
                model.addConnection(new Connection( socket, in, out, this ));
                serverSocket.close();} 
            catch (IOException ex) {
                Logger.getLogger(ServerController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    
    
    void getMessages(){
	while( true )
	get message from server
	model.sendMessage();
    }
    
    @Override
    public void run() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}


