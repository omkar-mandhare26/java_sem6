import java.io.*;
import java.net.*;

class Client
{
	public static void main(String args[]) 	throws Exception
	{
		Socket s = new Socket("localhost",7080);

		DataInputStream fromServer = new DataInputStream(
						s.getInputStream());

		System.out.println("Server Date & Time:"+fromServer.readLine());
	}
}