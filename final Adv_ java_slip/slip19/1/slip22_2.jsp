<%
String name=request.getParameter("t1");
java.util.Date d=new java.util.Date();
int hr=d.getHours();
if(hr<12)
{
	out.println("Good Morning:"+name);
}	
if(hr>12 && hr<16)
{
	out.println("Good Afternoon:"+name);
}
if(hr>16)
{
	out.println("Good Evening:"+name);
}
%>
