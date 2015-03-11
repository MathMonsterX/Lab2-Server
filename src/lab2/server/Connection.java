/*
 * Name: Sheyla Trudo
 * Course: CSCE 320
 * Semester: Spring 2015
 * Language: Java
 * IDE: Netbeans 8.0.2
 * Date: 3/9/2015
 * 
 * Sources Consulted:
 *      Dr. George Hauser
 * 
 * Revision History:
Commits on Mar 9, 2015
    Final Fixes 
    The lab for now has been completed. I changed minor items regarding the
    view. Eventually I would like to handle the error that the Clients get
    when I close out of the server with the Clients still running.

    Garbage Characters 
    Removed the unknown array characters from the server messages.

    Editing Controller and Server Start Button 
    Setting up the Controller and Connection classes and each of their
    separate functions. Also added a start button to allow the server to
    begin.

    Connection Class 
    Setting up the connection class. This class will handle individual
    connections to the server.

    Server Functions 
    Attempt to set up server functions in the program.
 *
 */
package lab2.server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sheyla
 */
public class Connection implements Runnable {
    private Socket socket;
    private InputStream in;
    private OutputStream out;
    private ServerController controller;
    private boolean connected;
    
    /**
     * The constructor for the Connection object.
     */
    public Connection(){}
    
    /**
     * The constructor for the Connection object.
     * @param socket    The socket used for the connection.
     * @param in        The input stream used for the socket. Receives incoming messages.
     * @param out       The output stream used for the socket. Used to write outgoing messages.
     * @param controller    The controller used to send messages to each of the clients.
     */
    public Connection( Socket socket, InputStream in, OutputStream out, ServerController controller ){
	this.socket = socket;
        this.in = in;
        this.out = out;
        this.controller = controller;
        connected = true;
        
        Thread worker = new Thread( this ) ;
        worker.start() ;  // calls run() in the new Thread
    }
    
    /**
     * Used to send messages to an individual connection.
     * @param message   the message to be sent to the connected client. 
     */
    public void sendMessage( String message )
    {
        try {
            out.write( message.getBytes() );
        } catch (IOException ex) {
            Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Listens for new messages from the client. 
     * Sends the messages to associated the controller.
     * When a client disconnects an exception is thrown and the client is 
     * disconnected from the server.
     */
    @Override
    public void run() {
        while(connected){
            byte [] buff = new byte[500] ;
            try{
                int len = in.read(buff);
                String message = new String( buff, 0, len );
                controller.sendMessage( message );
            }catch( Exception e )
            { 
                connected = false; controller.dropConnection( this ); 
            }
        }
        
    }
    
    /**
     * Returns the socket's InetAddress.
     * @return  The InetAddress
     */
    public InetAddress getInetAddress()
    {
        return socket.getInetAddress();
    }

    
}
