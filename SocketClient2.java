
package checker;

import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataOutputStream;

public class SocketClient2{
	public static String address = "127.0.0.1";//自己電腦上執行
	public static int port = 8765;
	

	//ip為伺服器端的ip，port為伺服器端開啟的port
	void init(String ip, int port) {
		this.port = port;
		address = ip;
	}

	public SocketClient2(String ijstring) {
	
		//和伺服器端進行連線
		Socket client = new Socket();
		InetSocketAddress isa = new InetSocketAddress(this.address, this.port);
		try {
			
			  
			client.connect(isa, 10000);
			
			
			DataOutputStream out = new DataOutputStream(client.getOutputStream());
			out.write(ijstring.getBytes());
			out.flush();
			out.close();
			out = null;
			System.out.println("Send From Client");

			
			client.close();
			client = null;
			 
		} catch (java.io.IOException e) {
			System.out.println("Socket連線有問題 !");
			System.out.println("IOException :" + e.toString());
		}
	}

	
	
}
	