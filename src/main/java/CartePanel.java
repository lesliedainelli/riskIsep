package main.java;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

//public class InterfaceCarte extends JFrame {
	
	
	
	import java.awt.Graphics;
	import java.awt.Image;
	import javax.swing.JPanel;
	 
	public class CartePanel extends JPanel {
	     
	    protected Image buffer;    
	     
	    public Image getBuffer() {
			return buffer;
		}

		public CartePanel(Image buffer){
	        this.buffer = buffer;
	       // this.setVisible(true);
	    }  
	         
	    public void paintComponent(Graphics g) {
	      
	    	super.paintComponent(g);
	    	 g.drawImage(buffer,0,0,null);
	    	 ArrayList <DrawIdJoueur> list = Partie.getInstance().getDrawIdJoueurList();
	    	 for (DrawIdJoueur d : list){
	    		 g.drawString(d.getIdJoueur(), d.getMilieu_x(),d.getMilieu_y());
	    	 }
	     }
	    

	 
		
	}
