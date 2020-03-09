package checker;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.List;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class checker2 extends Thread {
	boolean OutServer = false;
	private ServerSocket server;
	int ServerPort = 8764;
	win2 w;
	board3 bd3;
	
	public static boolean myturn2 = true;
	public static boolean redwon2=false;
	public static boolean yellowwon2=false;
	int color;
	
	String strbuf = new String();
	

	public void run() {
		
		Socket socket;
		java.io.BufferedInputStream in;
		strbuf = "Server started!";
		w.sockettext.setText(strbuf);
		System.out.println("Server started!");
		ArrayList<Integer> command = new ArrayList();
		while (!OutServer) {
			socket = null;
			try {
				synchronized (server) {
					socket = server.accept();//一直监听客户端的请求
				}
				System.out.println("connected : InetAddress = " + socket.getInetAddress());
				strbuf += "connected : InetAddress = " + socket.getInetAddress();
				w.sockettext.setText(strbuf);
				
				// TimeOut時間读取数据时阻塞链路的超时时间
				socket.setSoTimeout(1000);//1秒

				in = new java.io.BufferedInputStream(socket.getInputStream());
				byte[] b = new byte[1024];
				String data = "";
				int length;
				while ((length = in.read(b)) > 0) {
					data += new String(b, 0, length);
					strbuf += data;
					w.sockettext.setText(strbuf);
				}

				String[] A = data.split(",");
				command.clear();
				for (String token : A) {//for(int i=0;i<A.length;i++)
					System.out.println(token);
					command.add(Integer.parseInt(token));
				}
				//color=command.get(0);
				
				if(!myturn2&&command.get(0)!=w.mycolor) {
					w.b.jump(command.get(0),command.get(2), command.get(3), command.get(command.size() - 2),command.get(command.size() - 1));
					myturn2=true;
				}
				
				System.out.println("value:" + data);
				//-----------------------------------------
				DataOutputStream out;
				out = new DataOutputStream(socket.getOutputStream());
				out.writeUTF("test"); // have to insert the string
				out.close();
				out=null;
				//-----------------------------------------
				in.close();
				in = null;
				socket.close();

			} catch (java.io.IOException e) {
				System.out.println("Socketconnect error !");
				System.out.println("IOException :" + e.toString());
			}
		}

	}

	public checker2() {
		try {
			server = new ServerSocket(ServerPort);

		} catch (java.io.IOException e) {
			System.out.println("Socket startup error!");
			System.out.println("IOException :" + e.toString());
		}
	}

	public static void main(String[] args) {
		checker2 c = new checker2();
		c.w = new win2(c);
		c.w.setSize(1000, 1000);
		c.w.setLayout(new FlowLayout());

		c.w.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
				super.windowClosing(e);
			}

		});

		c.w.setVisible(true);

	}

}