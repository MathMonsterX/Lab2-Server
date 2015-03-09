/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
    
    void addConnection( Connection connection ){ connections.add(connection); }
    void removeConnection( Connection connection ){ connections.remove( connection ); }
    void setController( ServerController controller ){ this.controller = controller; }
    
    void sendMessageToAll( String message )
    {
        for( Connection c:connections )
        {
            c.sendMessage( message );
        }
    }
    
}