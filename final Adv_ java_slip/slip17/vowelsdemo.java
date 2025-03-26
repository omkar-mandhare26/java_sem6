import java.lang.*;
import java.util.*;
class vowels extends Thread
{
	String s1;
	vowels(String s)
	{
		s1=s;
		start();
	}
	public void run() throws InterruptedException
	{
		System.out.println("Vowels are ");
		for(int i=0;i<s1.length();i++)
		{
			char ch=s1.charAt(i);
			if(ch=='a'||ch=='e'||ch=='o'||ch=='i'||ch=='u'||ch=='A'||ch=='E'||ch=='I'||ch=='O'||ch=='U')
			System.out.print(" "+ch);
		}
		Thread.sleep(1000);
	}
}
class vowelsdemo
{
	public static void main(String args[]) throws InterruptedException
	{
		Scanner sn=new Scanner(System.in);
		System.out.println("Enter a string: ");
		String str1=sn.next();
		
		vowels v1=new vowels(str1);
	}
}