/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scangui;

import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.UIManager;

/**
 *
 * @author Jena
 */
public class ScanGUI {

    /**
     * @param args the command line arguments
     */
    	public static void main(String[] args) {
            try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
		}

		JFrame j = new JFrame();
		j.setTitle("GUI");
                try {
			j.setIconImage(ImageIO.read(GUI.class.getResource("GUI.png")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		j.add(new GUI());
		j.pack();
		j.setVisible(true);


	}
}
