package VirtualKey;
import java.util.*;
import java.io.File;


public class LockedMe extends ViewFile{
	
	public static void file_names()//Display Name of files in Ascending Order
	{
		try
		{
		  File[] files = new File("C:\\Users\\Lakshmi\\LockedMe\\Directory").listFiles();
		  List<String> fsort = new ArrayList<String>();
		  if(files==null)
		  {
			  System.out.println("Directory is empty!!");
		  }
		  else
		  {
		  System.out.println(" ~~~List of Files~~~ ");
		  for (File filename : files)
	        {
			  fsort.add(filename.getName());
			  Collections.sort(fsort);             //used to sort the filenames
	        }
			  Iterator it1 = fsort.iterator();
				while(it1.hasNext())
				{
					System.out.println(it1.next());
				}
	        }
		}
		catch(Exception e)
		{
			System.out.println("Please check the File!!");
			return;
		}
	}
					//Business Level Operations
	
	public static void file_opr() //Method for File operations
	{
		try
		{
		System.out.println("                                ");
		System.out.println("  ~~~File Handling Operations~~~ ");
		int op1;
		System.out.println("1  Add New File");
		System.out.println("2  Delete an Existing File");
		System.out.println("3  Search for a File");
		System.out.println("4  Return to Mainmenu");
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Your Choice: ");
		op1=sc.nextInt();
		switch(op1)
		{
		case 1: add_file();
				break;
				
		case 2: delete_file();
				break;
				
		case 3:	search_file();
				break;
				
		case 4: return;
				
		default: System.out.println("Enter a valid Option 1,2 or 3");
		}
		}
		catch(Exception e)
		{
			System.out.println("%% Please Enter a valid Opertaion %%");
			file_opr();
		}
		
	}

	public static void add_file()  //Method to create a new file
	{
		try
		{
			Scanner sc=new Scanner(System.in);
			String fname;
			String fpath="C:\\Users\\Lakshmi\\LockedMe\\Directory";
			System.out.println("Enter the name of the new file with filetype: ");
			fname=sc.nextLine();
			File f =new File(fpath,fname);
			if(f.exists())
			{
				System.out.println("The filename already exists");
				add_file();
			}
			else
			{
				f.createNewFile();
				System.out.println("File "+ f + " Created successfully");
				file_opr();
			}
		}
		catch(Exception e)
		{
			System.out.println("%% Failed to create  file %%");
			file_opr();
		}	
	}
	
	public static void delete_file() // Method to delete an existing file 
	{
		try{
			String fname;
			Scanner sc=new Scanner(System.in);
			file_names();
			System.out.println("                                ");
			System.out.println("Enter the filename to be deleted: ");
			fname=sc.next();
			String fpath="C:\\Users\\Lakshmi\\LockedMe\\Directory";
			File f = new File(fpath,fname);
			if(f.exists())
			{
				f.delete();
				System.out.println("File deleted Successfully!!");
				file_opr();
			}
			else
			{
				System.out.println("File Not Found!!");
				System.out.println("                                ");
				file_opr();
			}	
		}
		catch(Exception e)
		{
			System.out.println("%% Please Enter a valid Filename %%");	
		}
	}
	
	public static void search_file()  //Method to search for an Existing file
	{
		  try
		  {
		  String sfile;
		  File d = new File("C:\\Users\\Lakshmi\\LockedMe\\Directory");
		  System.out.println("Enter the name of the file to be searched: ");
		  Scanner sc=new Scanner(System.in);
		  sfile=sc.nextLine();
		  String[] l = d.list();
		  {
			  int tag=0;
			  for(int i=0;i<l.length;i++)
			  {
				  String filename = l[i];
	                if (filename.equals(sfile)) //checks for Case-sensitive
	                {
	                    System.out.println(filename + " found at location "+d);
	                    tag=1;
	                    readf(filename);       //Inherit the method of Another Class ViewFile
	                    System.out.println("                                ");
	                    file_opr();
	                }
			  }
			  if(tag==0)
			  {
				  System.out.println("File does not exist in Directory!!"); 
				  file_opr();
			  }
		  }	  
		  }
		  catch (Exception e)
		  {
			  System.out.println("File does not exist in Directory!!"); 
			  file_opr();
		  }
	}
	
	public static void main(String[] args)   //Welcome Screen
	{
		try{
		int op;
		do
		{
		LockedMe P =new LockedMe();
		System.out.println("                                ");
		System.out.println("----------- LockedMe.com -----------");
		System.out.println("     Developer - Sreelakshmi C S ");
		System.out.println("----------------------------------");
		System.out.println("                                ");
		
		 ArrayList<String> opr = new ArrayList<String>();
	    	opr.add("1  Display Files");
	        opr.add("2  File Operations");
	        opr.add("3  Close application");
	        System.out.println("Main Operations Menu");
	        Iterator it1 = opr.iterator();
			while(it1.hasNext())
			{
				System.out.println(it1.next());
			}	
		
		System.out.println("                                ");
		Scanner sc=new Scanner(System.in);
		System.out.println("Select the operation to be performed: ");
		op=sc.nextInt();
		switch(op)
		{
		case 1: file_names();
				break;
					
		case 2: file_opr();
				break;
					
		case 3: System.out.println("Thank You for using the application!!!"); 
				return;		
				
		default: System.out.println("%% Please Enter a valid Option 1,2 or 3 %%");	
		}
		}while(op!=3);
		}
		catch(Exception e)
		{
			System.out.println("Please Enter a valid Option!!!");
			main(args);
		}
	}

}