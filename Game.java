import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints; 
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Game extends JPanel{
	
	Ball ball = new Ball(this);
	Racquet player1 = new Racquet(this);
	Racquet comp = new Racquet(this);
	
	public Game(){
		addKeyListener(new KeyListener(){
			public void keyTyped(KeyEvent e){
			}
			public void keyReleased(KeyEvent e){
				player1.keyReleased(e);
			}
			public void keyPressed(KeyEvent e){
				player1.keyPressed(e);
			}
		});
		setFocusable(true);
	}
	
	private void move(){
		ball.move();
		player1.move();
		comp.move(ball.getY());
	}
	
	public void paint(Graphics g){
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		ball.paint(g2d);
		player1.paint(g2d, 1);
		comp.paint(g2d, 2);
	}
	
	public void gameOver(){
		JOptionPane.showMessageDialog(this, "Game Over", "Game Over", JOptionPane.YES_NO_OPTION);
		System.exit(ABORT);
	} 
	
	public static void main(String[] args) throws InterruptedException{
		JFrame frame = new JFrame("My Pong");
		Game game = new Game();
		frame.add(game);
		frame.setSize(300, 400);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		while(true){
			game.move();
			game.repaint();
			Thread.sleep(10);
		}
	}
}