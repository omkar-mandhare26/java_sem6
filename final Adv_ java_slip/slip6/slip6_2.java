import java.io.*;
import javax.servlet.http.*;
import javax.servlet.*;

public class slip6_2 extends HttpServlet
{
	static int i=1;
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
	{
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();

		String k=String.valueOf(i);
		Cookie c=new Cookie("visit",k);
		res.addCookie(c);
		int j=Integer.parseInt(c.getValue());
		if(j==1)
		{
			out.println("Welcome");
		}
		else
		{
			out.println("You visited "+i+" times");
		}
		i++;
	}
}
		