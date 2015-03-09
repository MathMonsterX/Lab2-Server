/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2.server;

import java.io.InputStream;
import java.io.OutputStream;
import static java.lang.System.out;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Sheyla
 */
public class ServerModel implements Runnable{

    ServerController controller;
    
    public void setController( ServerController controller ){ this.controller = controller; }
    
}