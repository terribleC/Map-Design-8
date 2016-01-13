package graphics;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;

public class MyWindow extends JFrame implements KeyListener {
	int width = 2000;
	int height = 2000;
	Cat cat;
	BufferedImage landscape;
	boolean touched;
	Cat cat2;

	public static void main(String[] args) {
		new MyWindow();
	}

	public MyWindow() {
		cat = new Cat("CAT", "/images/cats/long cat.jpg", 700, 200);
		cat2 = new Cat("CatBlack", "/images/cats/tacnol.jpg", 200, 200);
		touched = false;
		landscape = new BufferedImage(width, height,
				BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2 = (Graphics2D) landscape.getGraphics();
		paintLandscape(g2);
		setVisible(true);
		setSize(width, height);// units in pixels
		setLocation(200, 150);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// static constant references for special close operation
		addKeyListener(this);
	}

	public void paint(Graphics g) {
		// Graphics is bad
		// Graphics2D is better
		BufferedImage image = new BufferedImage(width, height,
				BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2 = (Graphics2D) image.getGraphics();
		g2.setColor(Color.white);
		g2.fillRect(0, 0, width, height);
		g2.drawImage(cat.getImage(), cat.getX(), cat.getY(), null);
		if(Math.abs(cat.getX()-cat2.getY()) + Math.abs(cat.getY()-cat2.getY()) < 50){
			touched = true;
		}
		if(!touched){
			g2.drawImage(cat2.getImage(), cat2.getX(), cat2.getY(), null);
		}else{
			g2.drawImage(cat2.getImage(),(int)Math.random()*(1500)+100,(int)Math.random()*(1500),null);
			touched = !touched;
		}
		// g2.setColor(Color.cyan);
		// g2.fillOval(50, 100, 200, 100);
		// g2.setColor(Color.red);
		// g2.drawOval(50, 100, 200, 100);
		// // x,y,width,height,startDeg,lengthDeg
		// g2.drawArc(50, 300, 200, 100, 90, 180);
		// //String,x,y
		// g2.drawString("Strings are drawn like this ", 200, 50);
		// //lines: startX,startY,endx,endY
		// g2.drawLine(150,300,width,height);

		// draw bufferedImage on canvas
		g.drawImage(image, 0, 0, null);
	}

	public void paintLandscape(Graphics g2) {
		for (int i = 0; i < 100000; i++) {
			Color d = new Color(i % 55, i % 255, i % 155);
			g2.setColor(d);
			g2.drawArc(i, i, width, height, i, 100000 - i);
		}

		int squareD = 2;
		int margin = 1;
		for (int x = 0; x < width; x += squareD + margin) {
			for (int y = 0; y < height; y += squareD + margin) {
				Color c = new Color(x % 255, x * y % 255, y % 255);
				g2.setColor(c);
				g2.fillRect(x, y, squareD, squareD);
			}
		}
	}

	public void keyPressed(KeyEvent arg0) {
		int key = arg0.getKeyCode();
		if (key == KeyEvent.VK_UP) {
			cat.moveUp();
		} else if (key == KeyEvent.VK_DOWN) {
			cat.moveDown();
		} else if (key == KeyEvent.VK_RIGHT) {
			cat.moveRight();
		} else if (key == KeyEvent.VK_LEFT) {
			cat.moveLeft();
		} 
		repaint();
	}

	public void keyReleased(KeyEvent arg0) {

	}

	public void keyTyped(KeyEvent arg0) {

	}
}
