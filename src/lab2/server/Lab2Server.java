/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2.server;

import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

/**
 *
 * @author Sheyla
 */
public class Lab2Server {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        JFrame frame = new JFrame("Messaging Server");
        
        ServerView view = new ServerView();
        ServerController controller = new ServerController();
        ServerModel model = new ServerModel();
        
        controller.setView( view );
        controller.setModel( model );
        view.setController( controller );
        model.setController( controller );
        
        frame.add( view );
        frame.setDefaultCloseOperation( EXIT_ON_CLOSE );
        frame.pack();
        frame.setVisible( true );
    }
    
}
