import java.io.*;
import java.net.*;
import java.util.*;

class Server{
	public static void main(String args[])
	throws Exception{
		ServerSocket ss = new ServerSocket(7080);
		
		while(true)
		{
			Socket s = ss.accept();

			DataOutputStream toClient = new DataOutputStream(
							s.getOutputStream());

			Date d = new Date();
			toClient.writeBytes(d+"\n");
		}
	}
}
