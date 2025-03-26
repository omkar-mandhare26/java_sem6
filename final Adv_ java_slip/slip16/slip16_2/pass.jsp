<%
	String pass = request.getParameter("pass");
	String un = session.getAttribute("user").toString();

	if(un.equals(pass))
		response.sendRedirect("success.html");
	else
		response.sendRedirect("fail.html");
%>

	