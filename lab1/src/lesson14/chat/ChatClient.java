package lesson14.chat;

import java.io.*;
import java.net.*;
import java.awt.*;
import java.applet.*;
import java.awt.event.*;

public class ChatClient extends Frame implements Runnable, ActionListener{
	private String nickname = null; //�г���
	private String servAddr = null; //���� �ּ�
	private int servPort = 0; //���� ��Ʈ
	private boolean flag = false;
	private Socket socket = null; //Ŭ���̾�Ʈ ����
	private BufferedReader br = null; //�Է� ��Ʈ��
	private BufferedWriter bw = null; //��� ��Ʈ��
	private TextField tf1 = new TextField();
	private TextArea ta1 = new TextArea();
	
	public ChatClient(String nickname, String servAddr, int servPort)
                                                     throws IOException{
		this.nickname = nickname;
		this.servAddr = servAddr;
		this.servPort = servPort;
		this.initGraphics(); //�׷����۾��� �̺�Ʈ ��� �ʱ�ȭ
		this.initNetwork(); //���� ������ ��Ʈ�� �۾� �ʱ�ȭ�� ������ ����
		new Thread(this).start();
	}
	public void initGraphics(){
		this.tf1.setBackground(Color.orange);
		this.ta1.setBackground(Color.yellow);
		this.add("North", tf1);
		this.add("Center", ta1);
		this.tf1.addActionListener(this);
		this.addWindowListener(
			new WindowAdapter(){
				public void windowClosing(WindowEvent e){
					System.exit(0);
					stop();
				}
			}
		);
	}
	//���ϰ� ����� ��Ʈ�� �ʱ�ȭ
	public void initNetwork() throws IOException{
		this.socket = new Socket(servAddr, servPort);
		bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
		br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		this.sendMessage("[" + nickname + "]:���� �����߽��ϴ�.");
	}
	public void actionPerformed(ActionEvent e){
		String msg = tf1.getText();
		if(!msg.equals("")){
			this.sendMessage("[" + nickname + "]:" + msg);
			tf1.setText("");
		}
	}
	
	public void run(){
		try{
			while(!flag){
				String msg = br.readLine();
				if(msg != null && !msg.equals("")){
					this.ta1.append( msg +"\n");
				}else{
					flag = true;
				}
			}
			br.close();
			bw.close();
			socket.close();
		}catch(IOException e){e.printStackTrace();}
	}
	public void stop(){
		this.sendMessage("");
		this.flag = true;
	}
	public void sendMessage(String msg){
		try{
			this.bw.write(msg + "\n");
			this.bw.flush();
		}catch(IOException e){e.printStackTrace();}
	}
} 