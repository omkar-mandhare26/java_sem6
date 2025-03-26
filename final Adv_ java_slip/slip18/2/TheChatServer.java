import java.io.*;
import java.net.*;
public class TheChatServer{

public static void main(String args[]){

	BufferedReader keyboard=null;
	BufferedReader fromClient =null;
	PrintWriter toClient=null;
	ServerSocket ss=null;
	Socket s=null;
	try{
	ss= new ServerSocket(7878);
	System.out.println("Server started:"+ss);
		try{
		s= ss.accept();
		System.out.println("Connected :"+s);
			try{
			fromClient = new BufferedReader(
					new InputStreamReader(
						s.getInputStream()));
			toClient  = new PrintWriter(
					new BufferedWriter(
					   new OutputStreamWriter(
						s.getOutputStream())),true);
			keyboard  = new BufferedReader(
					new InputStreamReader( System.in));

			String request, response;
			
			while(true){
				request=fromClient.readLine();
				if(request.equals("END"))
					break;
				System.out.println("client:"+request);
				response=keyboard.readLine();
				toClient.println(response);
				if(response.equals("END"))
					 break;
				}
			}catch(IOException i1){
			System.out.println(i1);
			}finally{
			try{ s.close();}catch(IOException i2){}
			}
		}catch(IOException i3){
		System.out.println(i3);
		}finally{
		try{ ss.close();}catch(IOException i4){}
		}
	   }catch(IOException i5){
	    System.out.println(i5);
	   }
       }
}

		

					
					