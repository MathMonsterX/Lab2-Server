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
    View Set Up and MVC Set Up 
    Designed the Server View and set up the connections between the MVC
    components.

Commits on Mar 7, 2015
    Initializing Classes 
    Created the necessary classes for the server application.
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
