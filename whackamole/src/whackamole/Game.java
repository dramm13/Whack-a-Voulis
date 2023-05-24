package whackamole;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;


public class Game extends JPanel implements Runnable, MouseListener, MouseMotionListener{
	private BufferedImage back;
	private ImageIcon bg, mole;
	private boolean draw;
	private int mx, my;
	private long time, timer;
	private int clickCount;

	public Game() {
		back=null;
		new Thread(this).start();	
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
		bg = new ImageIcon("grass.png");
		mole = new ImageIcon("mole.png");
		draw = true;
		mx = 200;
		my = 200;
		time = System.currentTimeMillis();
		clickCount = 0;

		
	}
	public void restart() {
		back=null;
		new Thread(this).start();	
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
		bg = new ImageIcon("grass.png");
		mole = new ImageIcon("mole.png");
		draw = true;
		mx = 200;
		my = 200;
		time = System.currentTimeMillis();
		clickCount = 0;

		
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
		
		
		//START CODING GRAPHICS HERE
		
		g2d.drawImage(bg.getImage(), 0,0, 1000, 1000, this);
		g2d.drawImage(mole.getImage(), mx, my, 100, 100, this);
		
		//grid
				Color BROWN = new Color(101,67,33);
				g2d.setColor(BROWN);
				g2d.fillRect(130,  0,  10,  8000);
				g2d.fillRect(260,  0,  10,  8000);
				g2d.fillRect(380,  0,  10,  8000);
				g2d.fillRect(510,  0,  10,  8000);
				g2d.fillRect(640,  0,  10,  8000);
				g2d.fillRect(0,  200,  8000, 10  );
				g2d.fillRect(0,  330,  8000, 10  );
				g2d.fillRect(0,  460,  8000, 10  );
				
				
				
				
				
				
		Color LIGHTBLUE = new Color(135,206,235);
		g2d.setColor(LIGHTBLUE);
		g2d.fillRect(0,  80,  1000,  25);

		
		
		g2d.setColor(Color.black);
		g2d.fillRect(50,  87,  69,  15);
		twoDgraph.drawImage(back, 0, 0, null);
		
		g2d.setColor(Color.white);
		g2d.fillRect(0,  0,  6777,  80);
	
		
		
		
		twoDgraph.drawImage(back, 0, 0, null);
		gameTimer(g2d);

		
			//g2d.drawImage(mole.getImage(), 100,100, 200, 200, this);
		Color LIGHTBROWN = new Color(135,108,25);
		g2d.setColor(LIGHTBROWN);
		g2d.setFont(new Font ("Times", Font.BOLD, 60));
		g2d.drawString("WHACK THE VOULIS!�",60, 60);
		Color LIGHTBROWN2 = new Color(175,108,25);
		g2d.setColor(LIGHTBROWN2);
		g2d.setFont(new Font ("Times", Font.BOLD, 60));
		g2d.drawString("WHACK THE VOULIS!�",57, 58);
		
		
		Color white = new Color(255,255,255);
		g2d.setColor(white);
		g2d.setFont(new Font ("Times", Font.BOLD, 12));
		g2d.drawString("score =",52, 100);
		g2d.drawString("Clicks= " + clickCount, 180, 100);

		
		Color BLACK = new Color(0,0,0);
		g2d.setColor(BLACK);
		//test
		
		
		
System.out.print(mx);
		//This line tells the program to draw everything above. If you delete this, nothing will show up.
		twoDgraph.drawImage(back, 0, 0, null);
	}

	private void gameTimer(Graphics g2d) {
		timer = (System.currentTimeMillis() - time) / 1000;
		g2d.setColor(Color.RED);
		g2d.setFont(new Font("Times", Font.BOLD, 40));
		g2d.drawString(String.valueOf("Time: " + timer), 500, 100);

		if(timer == 20) {
			timeOver(g2d);
		
		} else if (timer > 21) {
			restart();
		}
	}

	private void timeOver(Graphics g2d) {
		g2d.drawString("Hey you ran out of time, sorry :(", 50, 200);

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
		clickCount++;

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


	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}		
}




