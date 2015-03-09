/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2.server;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 *
 * @author Sheyla
 */
public class Connection {
    
    Connection( Socket socket, InputStream in, OutputStream out, this ){
	while(true){
            byte [] buff = new byte[500] ;
            in.read(buff) ;
            buff.getBytes();
            
            this.sendMessage( message );
        }
    }
    
}
