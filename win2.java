package checker;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GraphicsConfiguration;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.Label;
import java.awt.List;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JOptionPane;
import javax.swing.text.html.ListView;

public class win2 extends Frame {
	checker2 app;
	board3 b;
	Button btn;
	TextField txt_ip;
	TextField txt_port;
	List list_color;
	TextArea sockettext = new TextArea();
	Label label_ip;
	Label label_port;
	Button btnStart;
	Button btnStop;
	String mcolor = "RED";
	HashMap mapcolor = new HashMap();
	static int mycolor;
	SocketClient2 sc;

	void init() {
		mapcolor.put("RED", 3);//新增元素
		mapcolor.put("YELLOW",2);
		mapcolor.put("GREEN",4);



		txt_ip = new TextField(10);
		txt_ip.setText("127.0.0.1");
		txt_port = new TextField(10);
		txt_port.setText("8764");

		list_color = new List();
		list_color.add("RED");
		list_color.add("YELLOW");
		list_color.add("GREEN");
		list_color.select(0);
		list_color.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				mcolor = e.getActionCommand();
				mycolor = (int) mapcolor.get(mcolor);
				System.out.println(mycolor);
				System.out.println("mycolor"+mycolor);


			}
		});
		btnStart = new Button();
		btnStart.setSize(100, 50);
		btnStart.setLabel("start server");
		btnStart.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				sc.port = Integer.parseInt(txt_port.getText());
				sc.address=(txt_ip.getText());
				app.start();

			}
		});

		btnStop = new Button();
		btnStop.setSize(100, 50);
		btnStop.setLabel("stop server");
		btnStop.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				app.OutServer = true;
			}
		});

		label_ip = new Label();
		label_ip.setText("ip:");
		label_port = new Label();
		label_port.setText("client port:");
	}

	public win2(checker2 app) throws HeadlessException {
		this.app = app;
		init();
		b = new board3();
		b.setBounds(0, 0, 1000, 700);

		setLayout(new BorderLayout());
		add(label_ip);
		add(txt_ip);
		add(label_port);
		add(txt_port);
		add(btnStart);
		add(btnStop);
		add(list_color);
		add(b);
		add(sockettext);
	}

	public static void showmessage(String s) {
		// TODO Auto-generated method stub
		
		JOptionPane.showMessageDialog(null, s);//JOptionPane.showMessageDialog(null,物件)
	}}