/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2.server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sheyla
 */
public class Connection implements Runnable {
    private Socket socket;
    InputStream in;
    OutputStream out;
    ServerController controller;
    
    public Connection(){}
    
    public Connection( Socket socket, InputStream in, OutputStream out, ServerController controller ){
	this.socket = socket;
        this.in = in;
        this.out = out;
        this.controller = controller;
        
        Thread worker = new Thread( this ) ;
        worker.start() ;  // calls run() in the new Thread
    }
    
    void sendMessage( String message )
    {
        try {
            out.write( message.getBytes() );
        } catch (IOException ex) {
            Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void run() {
        while(true){
            byte [] buff = new byte[500] ;
            try{
                int len = in.read(buff);
                String message = new String( buff, 0, len );
                message.trim();
                controller.sendMessage( message );
            }catch( Exception e ){}
        }
    }

    
}
