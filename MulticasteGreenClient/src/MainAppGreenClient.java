import java.util.Observable;
import java.util.Observer;

import processing.core.PApplet;

public class MainAppGreenClient extends PApplet implements Observer{

	/*
	 * Multicast Client Example using Observer by Sebastián Restrepo
	 */
	
	private GreenCommunication c;
	private int x, y;
	private String mouse;
	
	public static void main(String[] args) {
		PApplet.main("MainAppGreenClient");

	}
	
	@Override
	public void settings() {
		size(400, 400);
	}
	
	@Override
	public void setup() {
		c = new GreenCommunication();
		new Thread(c).start();
		x = width/2;
		y = height/2;
		c.addObserver(this);
	}
	
	@Override
	public void draw() {
		background(255);
		fill(31, 255, 121, 98);
		ellipse(x, y, 50, 50);
	}

	@Override
	public void update(Observable o, Object arg) {
	        mouse = (String) arg;

	        String[] temp = mouse.split(",");
	        
	        System.out.println("[Green received a message] mouseX: " + temp[0] + ", mouseY: " + temp[1]);
	        x = Integer.parseInt(temp[0]);
	        y = Integer.parseInt(temp[1]);
	
	}

}
