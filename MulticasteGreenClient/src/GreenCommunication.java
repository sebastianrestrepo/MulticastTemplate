import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Observable;

public class GreenCommunication extends Observable implements Runnable {

	private MulticastSocket ms;
	private DatagramSocket ds;
	private DatagramPacket packet;
	private InetAddress groupDirection;
	
	
	public GreenCommunication() {
		System.setProperty("java.net.preferIPv4Stack", "true");
		
		try {
			//The client joins the group
			ms = new MulticastSocket(7000);
			ds = new DatagramSocket();
			packet = null;
			groupDirection = InetAddress.getByName("239.1.2.2");
			ms.joinGroup(groupDirection);
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void run() {
		
		while(true) {
			try {
				receiveMessage();
				Thread.sleep(66);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public void sendMessage(String message) {
		
	}
	
	public void receiveMessage() {
		
		//Receive the data
		byte [] buf = new byte[1000];
		DatagramPacket receivePack = new DatagramPacket(buf, buf.length);
		try {
			ms.receive(receivePack);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//Obtains the message
		String msg = new String(receivePack.getData(), 0, receivePack.getLength());
		
		  System.out.println("Se recibió mensaje: " + msg + "--------------------" );
		//Notify the Observer
		setChanged();
		notifyObservers(msg);
		clearChanged();
		
	}
	
}
