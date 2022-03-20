package test;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class TCPClient {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Socket s = new Socket("127.0.0.1",8888);
		OutputStream os = s.getOutputStream();
		os.write("ÄãºÃ·þÎñÆ÷".getBytes());
		
		s.close();
		os.close();
	}

}
