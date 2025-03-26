<%
	String un = request.getParameter("un");

	session.setAttribute("user",un);

	response.sendRedirect("pass.html");
%>