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

import java.util.ArrayList;

/**
 *
 * @author Sheyla
 */
public class ServerModel {

    ServerController controller;
    ArrayList<Connection> connections = new ArrayList();
    
    /**
     * Add a connection to the ArrayList that stores each Connection to the server.
     * @param connection    The connection to be added.
     */
    public void addConnection( Connection connection ){ connections.add(connection); }

    /**
     * Removes a specified connection from the ArrayList that stores each Connection to the server.
     * @param connection    The connection to be removed from the ArrayList.
     */
    public void removeConnection( Connection connection )
    { 
        controller.view.logMessage(  connection.getInetAddress().toString() + " has disconnected." );
        connections.remove( connection ); 
    }

    /**
     * Sets the Controller for the ServerModel.
     * @param controller    The controller for the model.
     */
    public void setController( ServerController controller ){ this.controller = controller; }
    
    /**
     * Receives a message and sends it to the each stored connection to handle.
     * @param message   The message to send to each connection.
     */
    public void sendMessageToAll( String message )
    {
        for( Connection c:connections )
        {
            c.sendMessage( message );
        }
    }
    
}