import java.net.*;

class slip11_1
{
		
public static void main(String args[]) throws UnknownHostException
{
	InetAddress i = InetAddress.getLocalHost();
		
	System.out.println("IP Address:"+i.getHostAddress());
	System.out.println("Host Name:"+i.getHostName());
	}
}
