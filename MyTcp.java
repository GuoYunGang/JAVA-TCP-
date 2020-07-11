package server_1;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;


public class MyTcp {

	private ServerSocket server;	//���÷������׽���
	private Socket client;		//���ÿͻ����׽���
	
	//���ӿͻ��˺���
	void getServer()
	{
		try {
			server = new ServerSocket(1100);	//���������� �˿�Ϊ1100
			System.out.println("�����������ɹ������ڵȴ�����......");
			client = server.accept();	//���÷����������Կͻ��˽�������			
			System.out.println("�ͻ������ӳɹ���ipΪ��" + client.getInetAddress());	//���ؿͻ���IP		
			getClientMessage();		//������Ϣ����ͽ��պ���
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	void getClientMessage()
	{
		try {
			while (true) {
				InputStream is = client.getInputStream();	//��ȡ���ͻ��˵�������
				byte[] b = new byte[1024];	//�����ֽ�����
				int len = is.read(b);	//������Ϣ�Ĵ������Զ����Ƶ���ʽ������Ҫ�Զ����Ƶ���ʽ�������ݵĶ�ȡ
				String data = new String(b, 0,len);
				System.out.println("�ͻ��˷�����Ϣ��" + data);
				
				//���巢�͸��ͻ��˵������
				OutputStream put = client.getOutputStream();
				String putText = "���Ѿ��յ�����ӭ�㣡";
				put.write(putText.getBytes());	//���������Ϣ�Զ����Ƶ���ʽ����д��
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		try {
			//�жϿͻ����ֽ������ǿգ���رտͻ���
			if (server != null) {
				server.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyTcp myTcp = new MyTcp();	//���ø������ɶ���
		myTcp.getServer();	//���÷���
	}

}
