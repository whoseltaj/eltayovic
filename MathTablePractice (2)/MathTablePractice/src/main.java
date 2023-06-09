import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import view.LoginGUI;
import view.StudentMainGUI;

public class main {

	public static void main(String[] args) throws IOException {
		
//		
//		File file = new File("tests.txt");
//		if(!file.exists())
//		{
//			file.createNewFile();
//		}
//		File file2 = new File("students.txt");
//		if(!file2.exists())
//		{
//			file2.createNewFile();
//		}
//		File file3 = new File("parents.txt");
//		if(!file3.exists())
//		{
//			file3.createNewFile();
//		}
//		File file4 = new File("arrangement.txt");
//		if(!file4.exists())
//		{
//			file4.createNewFile();
//		}
//		
//		
//		FileWriter fr = new FileWriter("students.txt",false);
//		fr.append("1,Ruslan,Karimov,11,11,");
//		fr.append("\n2,Eltac,Haqverdiyev,33,33,");
//		FileWriter fr2 = new FileWriter("parents.txt",false);
//		fr2.append("1,22,22");
//		fr.close();
//		fr2.close();
		
		// TODO Auto-generated method stub
		LoginGUI gui = new LoginGUI();
		gui.setVisible(true);

	}

}
