package VirtualKey;
import java.util.*;
import java.io.*;
import java.lang.*;

public class ViewFile 
{
	public static void readf(String filename)
	{
		try
		{
			InputStream in= new FileInputStream("C:\\Users\\Lakshmi\\LockedMe\\Directory"+"//"+filename);
			char ch;
			int s=0;
			int i=in.available();
			while(s<i)
			{
				ch=(char)in.read();
				System.out.print(ch);
				s++;
			}
		}
		catch(Exception e)
		{
			System.out.println("Please check the filename");
		}
	}
	
		public static void main(String args[])
		{
			String str;
			Scanner sc=new Scanner(System.in);
			ViewFile v =new ViewFile();
			System.out.println("Enter the file name::");
			str=sc.next();
			v.readf(str);
			
			
		}
	
}
