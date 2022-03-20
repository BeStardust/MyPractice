package test;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		ServerSocket ss = new ServerSocket(8888);
		Socket s = ss.accept();
		InputStream is = s.getInputStream();
		byte[] bytes = new byte[1024];
		int len = 0;
		while((len = is.read(bytes))!=-1) {
			System.out.println(new String(bytes));
		}
		System.out.println(new String(bytes,0,len));
		
		ss.close();
		is.close();
		
	}

}
