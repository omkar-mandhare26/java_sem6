


JSP FILE:
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
int num = Integer.parseInt(request.getParameter("num"));
int sum=0
for(int i=1;i<num;i++)
{
	if(num%i==0)
	{
		sum=sum+i;
	}
}

if(sum == num)
{
out.println("\nPerfect Number");
}
else
{
out.println("Not Perfect");
}
%>
