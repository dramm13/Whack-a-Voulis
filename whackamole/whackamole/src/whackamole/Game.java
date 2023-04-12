package whackamole;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;


public class Game extends JPanel implements Runnable, MouseListener{
	private BufferedImage back;
	private ImageIcon bg, mole;
	private boolean draw;
	private int mx, my;
	private long time, timer;
	
	public Game() {
		back=null;
		this.addMouseListener(this);
		bg = new ImageIcon("bg.png");
		mole = new ImageIcon("mole.png");
		draw = true;
		mx = 200;
		my = 200;
		time = System.currentTimeMillis();
		
	}
	
	
	public void run() {
		try {
			while(true) {
				Thread.currentThread().sleep(5);
				repaint();
			}
		}
		catch(Exception e) {}
	}
	
	public void paint (Graphics g)
	{
		Graphics2D twoDgraph = (Graphics2D)g;
	//take a snap shop of the current screen and same it as an image
	//that is the exact same width and height as the current screen
		if (back==null) {
			back =(BufferedImage) (createImage(getWidth(), getHeight()));
				}

	//create a graphics reference to the back ground image
	//we will draw all changes on the background image
		Graphics g2d = back.createGraphics();
		
		//this clears the old image, like an EtchASketch. If you see the old image when we learn motion, you deleted this line.
		g2d.clearRect(0, 0, getSize().width, getSize().height); 
		
		timer = (System.currentTimeMillis()-time)/1000;
		
		//START CODING GRAPHICS HERE
		g2d.drawImage(bg.getImage(), 0,0, 1000, 1000, this);
		g2d.drawImage(mole.getImage(), mx, my, 200, 200, this);
		g2d.setColor(Color.red);
		g2d.drawString(String.valueOf(timer), 100,100);
		
			//g2d.drawImage(mole.getImage(), 100,100, 200, 200, this);
		
System.out.print(mx);
		//This line tells the program to draw everything above. If you delete this, nothing will show up.
		twoDgraph.drawImage(back, 0, 0, null);
	}

	public int getRandomNumber() {
	    return (int) ((Math.random() * (500 - 100)) + 100);
	}
	public void move() {
		mx = getRandomNumber();
		my = getRandomNumber();
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getX()<mx+200&&e.getX()>mx&&e.getY()<my+200&&e.getY()>my) {
			System.out.print("hit");
			move();
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
		
	
	
	}
}


