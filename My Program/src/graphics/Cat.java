package graphics;
//HAI THERE!!!
//cats are cool
//ikr
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;

public class Cat {
	BufferedImage sprite;
	String name;
	int x;
	int y;

	public Cat(String name, String imageLocation, int locationX, int locationY) {
		this.name = name;
		int width = 150;
		int height = 200;
		x = locationX;
		y = locationY;
		sprite = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		// "/images/cats/long cat.jpg"
		URL url = getClass().getResource(imageLocation);
		try {
			BufferedImage original = ImageIO.read(url);
			//draw the image file into a scaled version on sprite canvas
			Graphics2D g = (Graphics2D) sprite.getGraphics();
			int w = original.getWidth();
			int h = original.getWidth();
			// what to draw, where to start (x,y),
			// width of canvas (relative to start),
			// height of canvas (relative to start),
			// where to start from original (x,y)
			// width of original, height
			// null
			g.drawImage(original, 0, 0, width, height, 0, 0, w, h, null);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public BufferedImage getImage() {
		return sprite;
	}

	public String getName() {
		return name;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void moveUp() {
		y--;
	}

	public void moveDown() {
		y++;
	}

	public void moveRight() {
		x++;
	}

	public void moveLeft() {
		x--;
	}
}
