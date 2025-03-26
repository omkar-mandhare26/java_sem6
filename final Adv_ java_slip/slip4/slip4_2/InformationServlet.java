import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;

public class InformationServlet extends HttpServlet
{
	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws IOException, ServletException
	{
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<h3>Request Information</h3><br>");
		out.println("Method: " + request.getMethod()+"<br>");
		out.println("Protocol: " + request.getProtocol()+"<br>");
		out.println("PathInfo: " + request.getPathInfo()+"<br>");
		out.println("Remote Address: " + request.getRemoteAddr()+"<br>");
		out.println("Remote Host: " + request.getRemoteHost()+"<br>");
		out.println("Remote User: " + request.getRemoteUser()+"<br>");
	                	out.println("<h3>Server Information</h3><br>");
    		out.println("getServerName(): " + request.getServerName()+"<br>");
    		out.println("getServerPort(): " + request.getServerPort()+"<br>");
    		
      		}
    	}
}
