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
		System.out.println("��ѡ��һ��ָ�\n -l ��������  \n -w ���ص����� \n -c �����ַ��� "
				+ "��������ָ������������Ҫ���ҵ��ļ���"
				+ " \n ���� -o ָ��������ݵ�ָ���ļ�" );
		InputData inputdata = new InputData();
		Operate oper = new Operate();
		String[] str =inputdata.getCommand("�밴Ҫ����������", "��δ����Ҫ�����ļ���",oper);
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
		System.out.println("�����ɹ�");
		
	}
}
