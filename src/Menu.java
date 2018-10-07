import java.io.File;
import java.io.IOException;

public class Menu {
	public Menu() throws IOException{
		while(true)
		{
			this.show();
		}
		
	}
	public void show() throws IOException
	{
		System.out.println("请选择一下指令：\n -l 返回行数  \n -w 返回单词数 \n -c 返回字符数 "
				+ "以上三个指令输入后需跟上要查找的文件名"
				+ " \n 输入 -o 指定输出数据到指定文件" );
		InputData inputdata = new InputData();
		Operate oper = new Operate();
		String[] str =inputdata.getCommand("请按要求输入命令", "您未输入要查找文件名",oper);
		StringBuffer buf= new StringBuffer();
		for(int i=0;i<str.length-1;i++)
		{
			switch (str[i])
			{
			case "-l" :
				buf.append(oper.getLine()+"\n");
				break;
			case "-w":
				buf.append(oper.getWord()+"\n");break;
			case "-c":
				buf.append(oper.getChar()+"\n");break;
			case "-o":
				oper.setFile2(new File(str[str.length-1]));break;
			default :
				break;
			}
		}
		oper.output(buf);
		System.out.println("操作成功");
		
	}
}
