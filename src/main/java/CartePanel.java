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
		
		
	     
	    private Image buffer;    
	    private ArrayList <DrawIdJoueur> list = Partie.getInstance().getDrawIdJoueurList();
	     
	    public Image getBuffer() {
			return buffer;
		}
	    
/*	*//** Constructeur prive *//*
	private CartePanel() {
	}

	*//** Instance unique pre-initialisee *//*
	private static CartePanel INSTANCE = new CartePanel();

	*//** Point d'acces pour l'instance unique du singleton *//*
	public static CartePanel getInstance() {
		return INSTANCE;
	}*/

		public CartePanel(Image buffer){
	        this.buffer = buffer;
	       // this.setVisible(true);
	    }  
	         
	    public void paintComponent(Graphics g) {
	      
	    	super.paintComponent(g);
	    	 g.drawImage(buffer,0,0,null);
	    	 for (DrawIdJoueur d : list){
	    		 g.drawString(d.getIdJoueur(), d.getMilieu_x(),d.getMilieu_y());
	    	 }
	     }

		public ArrayList<DrawIdJoueur> getList() {
			return list;
		}

		public void setList(ArrayList<DrawIdJoueur> list) {
			this.list = list;
		}
	    

	 
		
	}
