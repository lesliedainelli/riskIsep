package main.java;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
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

	private JPanel pan;
	private JeuPanel panJeu;
		
	public void init() {
		try {
			//image = ImageIO.read(new File("src\\main\\resources\\carte.png"));
			image = ImageIO.read(new File("/Users/lesliedainelli/Documents/workspace/risk/src/main/resources/carte.png"));
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		pan = new CartePanel(image);
		panJeu = new JeuPanel();
		JPanel pMessage = new JPanel();
		pMessage.setPreferredSize(new Dimension(400, 50));
		pMessage.setBorder(BorderFactory.createTitledBorder("Message"));
		//pMessage.setLayout(new GridBagLayout());
	//	addItem(pMessage, new JLabel("Veuillez saisir un nombre blablabla"), 0, 0, 1, 1, GridBagConstraints.CENTER);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.add(pan);
		this.add(panJeu, BorderLayout.EAST);
		//this.add(pMessage, BorderLayout.SOUTH);
		
		this.setSize(1600, 800);
		this.setVisible(true);
		addMouseListener(this);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		sourisX = e.getX()- 8;
		sourisY = e.getY()- 30;
		System.out.println("X:" + sourisX + " " + "Y:" + sourisY);
		Partie.getInstance().setSourisX(sourisX);
		Partie.getInstance().setSourisY(sourisY);
		Territoire t = Partie.getInstance().getTerritoireSelected();
		panJeu.getLabelTerrSelct().setText(t.getNom());
		panJeu.getLabelNbSoldat().setText(t.getArmee().getNbSoldat().toString());
		panJeu.getLabelNbCavalier().setText(t.getArmee().getNbCavalier().toString());
		panJeu.getLabelNbCanon().setText(t.getArmee().getNbCanon().toString());
/*		panJeu.getLabelAppartJoueurId().setText(t.getJoueurProp().getId().toString());
		panJeu.getLabelAppartJoueurNom().setText(t.getJoueurProp().getNom());*/
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



