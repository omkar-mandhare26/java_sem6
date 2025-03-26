import java.io.*;
import java.net.*;
public class TheChatClient{
public static void main(String args[]){

	InetAddress remote=null;
	Socket cs=null;
	BufferedReader keyboard=null;
	BufferedReader fromServer=null;
	PrintWriter toServer=null;
	try{
	remote= InetAddress.getByName(null);
		try{
		cs= new Socket(remote,7878);
		System.out.println("Connected:"+cs);
			try{
			fromServer= new BufferedReader(
					new InputStreamReader(
						cs.getInputStream()));
			toServer= new PrintWriter(
					new BufferedWriter(
						new OutputStreamWriter(
						cs.getOutputStream())),true);
			keyboard= new BufferedReader(
					new InputStreamReader(System.in));

			String request, response;
			
			while(true){
				response=keyboard.readLine();
				toServer.println(response);
				if(response.equals("END"))
					 break;
				request=fromServer.readLine();
				if(request.equals("END"))
					break;
				System.out.println("Server:"+request);
				}
			}catch(IOException i1){
			System.out.println(i1);
			}finally{
			try{ cs.close();}catch(IOException i2){}
			}
		}catch(IOException i3){
		System.out.println(i3);
		}
	   }catch(UnknownHostException i5){
	    System.out.println(i5);
	   }
       }
}


