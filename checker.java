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

public class checker extends Thread {
	boolean OutServer = false;
	private ServerSocket server;
	int ServerPort = 876;
	win w;
	board bd;
	//int color;

	public static boolean myturn = true;
	public static boolean redwon=false;
	public static boolean yellowwon=false;
	public static boolean greenwon=false;
	

	
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
					System.out.println("等待連線......");
					socket = server.accept();// 监听客户端的请求
				}
				System.out.println("connected : InetAddress = " + socket.getInetAddress());
				strbuf += "connected : InetAddress = " + socket.getInetAddress();
				w.sockettext.setText(strbuf);
				// TimeOut時間读取数据时阻塞链路的超时时间
				socket.setSoTimeout(1000);

				in = new java.io.BufferedInputStream(socket.getInputStream());// 接收傳進來的資料，所以是Input
				byte[] b = new byte[1024];
				String data = "";
				int length;
				while ((length = in.read(b)) > 0) {
					data += new String(b, 0, length);
					strbuf += data;
					w.sockettext.setText(strbuf);
				}

				String[] A = data.split(",");// 分割
				command.clear();
				for (String token : A) {// for(int i=0;i<A.length;i++)
					System.out.println(token);
					command.add(Integer.parseInt(token));
				}

				//color=command.get(0);
				
				if (command.get(0) != w.mycolor) {
						w.b.jump(command.get(0),command.get(2), command.get(3), command.get(command.size() - 2),
								command.get(command.size() - 1));
						myturn = true;
					}

				System.out.println("value:" + data);

//-----------------------------------------

//DataOutputStream:把各種基本資料型態，如 int, double...等的 "值" 輸出
				DataOutputStream out;
				out = new DataOutputStream(socket.getOutputStream());// 將資料編寫並送出
				out.writeUTF("test"); // have to insert the string
				out.close();
				out = null;
//-----------------------------------------
				in.close();
				in = null;
				socket.close();// 關閉連線

			} catch (java.io.IOException e) {
				System.out.println("Socketconnect error !");
				System.out.println("IOException :" + e.toString());
			}
		}

	}

	public checker() {
		try {
			server = new ServerSocket(ServerPort);

		} catch (java.io.IOException e) {
			System.out.println("Socket startup error!");
			System.out.println("IOException :" + e.toString());
		}
	}

	public static void main(String[] args) {
		checker c = new checker();
		c.w = new win(c);
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