
<font color='blue'>
<% 
String no = request.getParameter("no");
String words[]={"Zero","One","Two","Three","Four", "Five","Six","Seven","Eight","Nine"};
for(int i=0;i<no.length();i++)
{
	out.print(words[no.charAt(i)-'0']+"");
}
%>
</font>