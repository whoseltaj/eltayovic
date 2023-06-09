package dataAccess.abstracts;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ResultRepository {
	
	public static int getRange() throws NumberFormatException, IOException
	{
		File file = new File("..\\MathTablePractice\\src\\files\\arrangements.txt");
		BufferedReader br = new BufferedReader(new FileReader(file));
		String s ="";
		int range = 10;
		while((s=br.readLine())!=null)
		{
			System.out.println(s);
			range = Integer.parseInt(s);
		}
		return range;
		
	}
	
	public static void setRange(int range) throws NumberFormatException, IOException
	{
		File file = new File("..\\MathTablePractice\\src\\files\\arrangements.txt");
		FileWriter fr = new FileWriter(file);
		System.out.println(range);
		String rangeStr = Integer.toString(range);
		fr.write(rangeStr);
		
		fr.close();
	}
	

}
