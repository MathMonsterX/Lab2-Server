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
    Garbage Characters 
    Removed the unknown array characters from the server messages.

    Begin Testing 
    So far initial tests have been relatively successful.  The clients are
    able to connect to the server and send messages to each other. Minor
    editing within the displayed text. Some errors: A repetitive text is
    displayed on the client views if the server is closed out of during
    connection. Also the server still needs to display client messages.

    Editing Controller and Server Start Button 
    Setting up the Controller and Connection classes and each of their
    separate functions. Also added a start button to allow the server to
    begin.

    Connection Class 
    Setting up the connection class. This class will handle individual
    connections to the server.

    Server Functions 
    Attempt to set up server functions in the program.

    View Set Up and MVC Set Up 
    Designed the Server View and set up the connections between the MVC
    components.

Commits on Mar 7, 2015
    Server Model Set Up 
    Copied and pasted the psuedocode into the Server Model. Working on
    making it into Java code. Moved one the send Message method to the
    controller because it seemed more like a controller action.

    Initializing Classes Part 2

 */
package lab2.server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
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
    
    /**
     * Sets the view that the controller references. 
     * @param view
     */
    public void setView( ServerView view ){ this.view = view; }

    /**
     *Sets the model that the controller references.
     * @param model
     */
    public void setModel( ServerModel model ){ this.model = model; }
        
    /**
     * Receives a string known as a message. 
     * Sends a message string to the model. 
     * Also tells the view to log the same message.
     * @param message   The message to be sent to the model and the view.
     */
    public void sendMessage( String message )
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

    /**
     * Starts a new thread to listen for incoming server connections.
     */
    public void startServer() {
        Thread worker = new Thread( this );
        worker.start();
    }

    /**
     * The method that tells the model that a connection needs to be removed.
     * @param c The connection to be removed from the server connection list.
     */
    public void dropConnection( Connection c ) {
        model.removeConnection(c);
    }
    
}


