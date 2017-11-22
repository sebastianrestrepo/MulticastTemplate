import processing.core.PApplet;

public class MainAppMulticastServer extends PApplet {

	/*
	 * Multicast Server Example by Sebastián Restrepo
	 */
	
	private Communication c;
	
	public static void main(String[] args) {
		PApplet.main("MainAppMulticastServer");
	}
	
	@Override
	public void settings() {
		size(400, 400);
	}
	
	public void setup() {
		c = new Communication();
		c.start();
	}

	public void draw() {
		background(255);
		fill(0);
		text(mouseX + ", " + mouseY, mouseX, mouseY);
		text("CLICK ON THE SCREEN TO SEND", width/2-95, height-30);
	}
	
	public void mouseClicked() {
		String message = mouseX + "," + mouseY;
		c.sendMessage(message);
		System.out.println("Mensaje enviado :)");
	}
	
}
