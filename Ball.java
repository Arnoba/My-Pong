import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Ball{
	int x = 150;
	int y = 200;
	int xa = 1;
	int ya = 1;
	private Game game;
	private static final int DIAMETER = 30;
	
	public Ball(Game game){
		this.game = game;
	}
	
	void move(){
		if(y + ya < 0)
			ya = 2;
		if(y + ya > game.getHeight()-DIAMETER)
			ya = -2;
		if(x + xa < 0)
			game.gameOver();
		if(x + xa > game.getWidth()-DIAMETER)
			game.gameOver();
		if(playercollision()){
			xa = 2;
			x = DIAMETER;
			System.out.println("player: " + game.player1.getX());
			System.out.println("comp" + game.comp.getX());
		}
		if(compcollision()){
			xa = -1;
			x = game.getWidth()-10 - DIAMETER;
		}
			
		x = x + xa;
		y = y + ya;
	}
	private boolean playercollision(){
		return game.player1.getBounds(1).intersects(this.getBounds()); //Checks to see if racquets bound intersects with the ball
	}
	private boolean compcollision(){
		return game.comp.getBounds(2).intersects(this.getBounds());
	}
	
	public void paint(Graphics2D g){
		g.fillOval(x, y, DIAMETER, DIAMETER);
	}
	
	public Rectangle getBounds(){
		return new Rectangle(x,y,DIAMETER, DIAMETER);
	}
	public int getX(){
		return x;
	}
	public int getY(){
		return y;
	}
}