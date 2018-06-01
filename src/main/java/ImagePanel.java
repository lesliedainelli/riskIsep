package main.java;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

//public class InterfaceCarte extends JFrame {
	
	
	
	import java.awt.Graphics;
	import java.awt.Image;
	import javax.swing.JPanel;
	 
	public class ImagePanel extends JPanel {
	     
	    protected Image buffer;    
	     
	    public Image getBuffer() {
			return buffer;
		}

		public ImagePanel(Image buffer){
	        this.buffer = buffer;
	    }  
	         
	    public void paintComponent(Graphics g) {
	       g.drawImage(buffer,0,0,null);
	     }
	 
		
	}
