import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class Communication extends Thread {

	private DatagramSocket ds;
	//private DatagramPacket packet;
	private InetAddress groupDirection;
	
	
	public Communication() {
		System.setProperty("java.net.preferIPv4Stack", "true");
		
		try {
			ds = new DatagramSocket();
			//packet = null;
			groupDirection = InetAddress.getByName("239.1.2.2");
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		
	}
	
	public void run() {
		
	}
	
	public void sendMessage(String message) {
		
		try {
			byte [] buf = message.getBytes();
			DatagramPacket packet = new DatagramPacket(buf, buf.length, groupDirection, 7000);
			ds.send(packet);
		} catch (IOException e) {
			e.printStackTrace();
		}
		//ds.close();
		
	}
	
	public void receiveMessage() {
		
	}
	
	
	//-----------//
}
