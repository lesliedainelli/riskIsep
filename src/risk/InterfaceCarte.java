package risk;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Image;
import java.awt.Robot;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class InterfaceCarte extends JFrame implements MouseListener {

	public static int sourisX;
	public static int sourisY;

	public InterfaceCarte() {
		
		

		Image image = null;
		try {
			image = ImageIO.read(new File("/Users/lesliedainelli/Documents/workspace/risk/ressources/carte.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JPanel pan = new ImagePanel(image);
		JPanel panJeu = new jeuPanel();

		this.setSize(1000, 900);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.getContentPane().add(pan);
		this.getContentPane().add(panJeu);
		addMouseListener(this);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		sourisX = e.getX();
		sourisY = e.getY();
		
		Robot robot = null;
		try {
			robot = new Robot();
		} catch (AWTException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	    Color color = robot.getPixelColor(sourisX, sourisY);

	    System.out.println("Red   = " + color.getRed());
	    System.out.println("Green = " + color.getGreen());
	    System.out.println("Blue  = " + color.getBlue());
	    
	    
		System.out.println("X:" + sourisX + " " + "Y:" + sourisY);
		

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

	public static  int getSourisX() {
		return sourisX;
	}

	public void setSourisX(int sourisX) {
		this.sourisX = sourisX;
	}

	public static int getSourisY() {
		return sourisY;
	}

	public void setSourisY(int sourisY) {
		this.sourisY = sourisY;
	}

}



