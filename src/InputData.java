import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class InputData {
	private BufferedReader buf;
	public InputData() {
		buf= new BufferedReader(new InputStreamReader(System.in));
	}
	public boolean smallCheck(String[] str)
	{
		boolean flag=false;
		for(int i=0;i<str.length-1;i++)
		{
			if(str[i].contains("-")&&str[i].length()!=2)
			{
				flag=true;
				System.out.println("不存在"+str[i]+"命令");
				break;
			}
		}
		return flag;
	}
	public String getString(String infor)
	{
		System.out.println(infor);
		String str= null;
		try {
			str=buf.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return str;
	}
	public String[] getCommand(String infor,String err,Operate oper)
	{
		String str[]= null;
		boolean flag=true;
		Pattern p = Pattern.compile(" ");
		Pattern p1 = Pattern.compile("[lwco]");
		Matcher ma =null;
		while(flag)
		{
			str= p.split(getString(infor));
			for(String val:str)
			{
				System.out.println(val);
			}
			if(smallCheck(str))
			 {
				 System.out.println("请重新输入");
			 }
			else if(str.length>=2)
			{
				
			
				 if(str[str.length-1].indexOf("-")==1)
				{
					System.out.println(err);
				}
				 
				else
				if(str[str.length-2].indexOf("-o")==-1)//倒数第二位不-o,不指定输出文件
				{
					int count=0;
					for(int i=0;i<str.length-1;i++)
					{
						ma= p1.matcher(str[i]);
						
						if(str[i].contains("-"))
						{
							
							if(ma.find())
							{
								count++;
							}
						}
						
					}
					if(count==(str.length-1))
						{
							flag=false;
							oper.setFile1(new File(str[str.length-1]));
						}
					
					else
						System.out.println("存在错误指令,请按要求输入");
				}
				else //指定输出文件
				{
					int count=0;
					for(int i=0;i<str.length-1;i++)
					{
						ma= p1.matcher(str[i]);
						
						if(str[i].contains("-"))
						{
							
							if(ma.find())
							{
								count++;
							}
						}
						
					}
					if(count==(str.length-2))
						{
						flag=false;
						oper.setFile1(new File(str[str.length-3]));
						}
					else
						System.out.println("存在错误指令,请按要求输入");
					
				}
			
					
				}	
			else
			{
				System.out.println(err);
			}
		}
		return str;
	}
	
}
