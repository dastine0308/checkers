package checker;

import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataOutputStream;

public class SocketClient {
	public static String address;//�ۤv�q���W����
	public static int port=8765;
	
	win w;
	String strbuf = new String();

	//ip�����A���ݪ�ip�Aport�����A���ݶ}�Ҫ�port
	void init(String ip, int port) {
		this.port = port;
		address = ip;
	}

	public SocketClient(String ijstring) {
		//�M���A���ݶi��s�u
		Socket client = new Socket();
		InetSocketAddress isa = new InetSocketAddress(this.address, this.port);
		try {
			
		  	  
			client.connect(isa, 1000);
		
			
			DataOutputStream out = new DataOutputStream(client.getOutputStream());
			out.write(ijstring.getBytes());
			out.flush();
			out.close();
			out = null;
			System.out.println("Send From Client");

			client.close();
			client = null;
			 
		} catch (java.io.IOException e) {
			System.out.println("Socket�s�u�����D !");
			System.out.println("IOException :" + e.toString());
		}
	}

	
}