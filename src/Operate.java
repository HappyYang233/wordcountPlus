import java.io.*;
import java.util.regex.Pattern;

public class Operate {
	private File file1;
	public File getFile1() {
		return file1;
	}
	public void setFile1(File file1) {
		this.file1 = file1;
	}
	private File file2;

	public File getFile2() {
		return file2;
	}
	public void setFile2(File file2) {
		this.file2 = file2;
	}
	private BufferedReader buf;
	private Writer write;
	public Operate() throws IOException {
		
		this.file2= new File("result.txt");
		
	}
	public String getChar() throws IOException
	{
		this.buf=new BufferedReader(new InputStreamReader(new FileInputStream(this.file1)));
		String str=null;
		String temp=null;
		int num=0; 
		while((temp=buf.readLine())!=null)
		{
			char[] c= temp.toCharArray();
			num+=c.length;
		}
		str="字符数为："+num;
		return str;
	}
	public String getWord() throws IOException
	{
		this.buf=new BufferedReader(new InputStreamReader(new FileInputStream(this.file1)));
		String str="";
		String temp=null;
		Pattern p = Pattern.compile(" |,");
		int num=0;
		while((temp=buf.readLine())!=null)
		{
			
			String[] str2 =p.split(temp);
			num+=str2.length;
			for(String val:str2)
			{
				System.out.println(val);
			}
		
		}
		str="单词数"+num;
		
		return str ;
	}
	public String getLine() throws IOException
	{
		this.buf=new BufferedReader(new InputStreamReader(new FileInputStream(this.file1)));
		String str=null;
		String temp=null;
		int num=0;
		while((temp=buf.readLine())!=null)
		{
			num++;
		}
		str="行数为:"+num;
		return str;
	}
	public void output(StringBuffer buf) throws IOException
	{
		this.write=new FileWriter(this.file2);
		this.write.write(buf.toString());
		this.write.close();
	}
}
