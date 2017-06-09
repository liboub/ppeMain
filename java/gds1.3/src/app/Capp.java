
package app;

import IHM.CIHMApp;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Capp {
 
    	public static void main(String[] args){
            
                SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				CIHMApp fenetre = new CIHMApp();
				fenetre.setVisible(true);
			}
		});
	}
}