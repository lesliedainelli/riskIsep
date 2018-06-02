package main.java;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class InterfaceCarte extends JFrame implements MouseListener {

	public  int sourisX;
	public  int sourisY;

	BufferedImage image = null;
	
	
	public BufferedImage getImage() {
		return image;
	}


	/** Constructeur priv� */
    private InterfaceCarte()
    {}
 
    /** Instance unique pr�-initialis�e */
    private static InterfaceCarte INSTANCE = new InterfaceCarte();
     
    /** Point d'acc�s pour l'instance unique du singleton */
    public static InterfaceCarte getInstance()
    {   return INSTANCE;
    }

		
	public void init() {
		//this.setSize(1600, 800);
		try {
			//image = ImageIO.read(new File("src\\main\\resources\\carte.png"));
			image = ImageIO.read(new File("/Users/lesliedainelli/Documents/workspace/risk/src/main/resources/carte.png"));
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		JPanel pan = new ImagePanel(image);
		JeuPanel panJeu = new JeuPanel();
		//JPanel panJeu = new ImagePanel(image);
		//this.getContentPane().add(pan, BorderLayout.WEST);
		//this.setSize(1200, 900);
		//this.setSize(image.getWidth(), image.getHeight());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		//panContenu.add(panJeu, BorderLayout.EAST);
		
		this.add(pan);
		this.add(panJeu, BorderLayout.EAST);
		
		
		this.setSize(1600, 800);
		this.setVisible(true);
		addMouseListener(this);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		sourisX = e.getX()- 8;
		sourisY = e.getY()- 30;
		System.out.println("X:" + sourisX + " " + "Y:" + sourisY);
		
		Partie.getInstance().getTerritoireSelected(sourisX, sourisY);
	}

	
		
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	public  int getSourisX() {
		return sourisX;
	}
	
	public int getSourisY() {
		return sourisY;
	}

}



