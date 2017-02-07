/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaCore.logging;

/**
 *
 * @author ywu
 */
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.logging.*;
import javax.swing.*;

public class LoggingImageViewer {

    public static void main(String[] args) {

        if (System.getProperty("java.util.logging.config.class") == null && System.getProperty("java.util.logging.config.file") == null) {

            try {

                Logger.getLogger("com.horstmann.corejava").setLevel(Level.ALL);

                final int LOG_ROTATION_COUNT = 10;

                Handler handler = new FileHandler("%h/LoggingImageViewer.log", 0, LOG_ROTATION_COUNT);
            } 
            catch (IOException e) {

                Logger.getLogger("com.horstmann.corejava").log(Level.SEVERE, "Can't create log file handler", e);
            }
        }
        
        EventQueue.invokeLater(new Runnable() {
        
            public void run() {
            
                Handler windowHandler = new WindowHandler();
                
                windowHandler.setLevel(Level.ALL);
                Logger.getLogger("com.horstmann.corejava").addHandler(windowHandler);
                
                JFrame frame = new ImageViewerFrame();
                
                frame.setTitle("LogingImageViewer");
                
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                
                Logger.getLogger("com.horstmann.corejava").fine("Showing frame");
                
                frame.setVisible(true);
            }
        });
    }
}

class ImageViewerFrame extends JFrame {

    private static final int DEFAULT_WIDTH = 300;
    
    private static final int DEFAULT_HEIGHT = 400;
    
    private JLabel label;
    
    private static Logger logger = Logger.getLogger("com.horstmann.corejava");
    
    public ImageViewerFrame() {
    
        logger.entering("ImageViewerFrame", "<init>");
        
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        
        
    }
}

public class LoggingImageViewer {

}
