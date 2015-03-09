/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2.server;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Sheyla
 */
public class ServerController {
    ServerModel model;
    ServerView view;
    
    ServerSocket serverSocket;
    
        sendMessage( message )
1.	for all connections
1.	write message to out
        
        public void setView( ServerView view ){ this.view = view; }
        public void setModel( ServerModel model ){ this.model = model; }
        
        
        void acceptingConnections(){ 
	serverSocket = new ServerSocket();
	
        while(true){
            Socket socket = serverSocket.accept();
            InputStream in = socket.getInputStream(); 
            OutputStream Stream out = socket.getOutputStream();
            controller.addConnection(new Connection( socket, in, out, this ));
            serverSocket.close();
        }
    }
    
    
    Connection( Socket socket, InputStream in, OutputStream out, this ){
	while(true){
            byte [] buff = new byte[500] ;
            in.read(buff) ;
            
	this.sendMessage (message )
        }
    }
Thread 2:
1.	while( true )
1.	get message from server
2.	display message to user

    @Override
    public void run() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

}
