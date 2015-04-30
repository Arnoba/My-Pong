import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

public class Racquet{
	int x = 0;
	int ya = 0;
	int y = 0;
	int width = 10;
	int height = 60;
	
	private Game game;
	
	public Racquet(Game game){
		this.game = game;
	}
	
	public void move(){
		if(y + ya > 0 && y + ya < game.getHeight()-height)
			y = y + ya;
	}
	public void move(int y){
		this.y = y;
	}
	
	public void paint(Graphics2D g, int player){
		if(player == 1)
			x = 10;
			g.fillRect(x, y, width, height);
		if(player == 2)
			x = game.getWidth()-20;
			g.fillRect(x, y, width, height);
	}
	
	public void keyReleased(KeyEvent e){
		ya = 0;
	}
	public void keyPressed(KeyEvent e){
		if(e.getKeyCode() == KeyEvent.VK_UP)
			ya = -2;
		if(e.getKeyCode() == KeyEvent.VK_DOWN)
			ya = 2;
	}
	public Rectangle getBounds(int player){	
		if(player == 1)
			return new Rectangle(10,y, width, height);
		else
			return new Rectangle(game.getWidth()-10,y, width, height);
	}
	public int getTopY(){
		return y;
	}
	public int getX(){
		return this.x;
	}
}