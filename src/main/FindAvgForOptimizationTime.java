package main;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableColumn;



public class FindAvgForOptimizationTime {

	
	
	private static double time;
	private static BufferedWriter file;
	private static BufferedWriter file2;
	private static BufferedWriter file3;
	private static BufferedWriter file4;
	private static BufferedWriter file5;
	private static BufferedWriter file6;
	private static BufferedWriter file7;
	private static BufferedWriter file8;
	private static BufferedWriter file9;
	private static BufferedWriter file10;
	private static String[] priorityG = {"0", "25", "50", "75", "100"};
	private static String[] probabilityG = {"0", "50", "100"};
	private static String[] consequenceG = {"0", "25", "50", "75", "100"};
	
//	private static String[] epriorityG = {"0", "25", "50", "75", "100"};
//	private static String[] eprobabilityG = {"0", "50", "100"};
//	private static String[] econsequenceG = {"0", "25", "50", "75", "100"};
	

	private static File fileName;
	private static File fileName2;
	private static File fileName3;
	private static File fileName4;
	private static File fileName5;
	private static File fileName6;
	private static File fileName7;
	private static File fileName8;
	private static File fileName9;
	private static File fileName10;
	
	public static void main(String[] args) throws Exception {

		readFile();
	
	}
	
	public static void readFile() throws Exception{		
		createFile();
		FileWriter fw = new FileWriter(fileName.getAbsoluteFile());
		file = new BufferedWriter(fw);
		
		createFile2();
		FileWriter fw2 = new FileWriter(fileName2.getAbsoluteFile());
		file2= new BufferedWriter(fw2);
		
		createFile3();
		FileWriter fw3 = new FileWriter(fileName3.getAbsoluteFile());
		file3= new BufferedWriter(fw3);
		
		createFile4();
		FileWriter fw4 = new FileWriter(fileName4.getAbsoluteFile());
		file4= new BufferedWriter(fw4);
		
		createFile5();
		FileWriter fw5 = new FileWriter(fileName5.getAbsoluteFile());
		file5= new BufferedWriter(fw5);
		
		createFile6();
		FileWriter fw6 = new FileWriter(fileName6.getAbsoluteFile());
		file6= new BufferedWriter(fw6);
		
		createFile7();
		FileWriter fw7 = new FileWriter(fileName7.getAbsoluteFile());
		file7= new BufferedWriter(fw7);
		
		createFile8();
		FileWriter fw8 = new FileWriter(fileName8.getAbsoluteFile());
		file8= new BufferedWriter(fw8);
		
		createFile9();
		FileWriter fw9 = new FileWriter(fileName9.getAbsoluteFile());
		file9= new BufferedWriter(fw9);
		
		createFile10();
		FileWriter fw10 = new FileWriter(fileName10.getAbsoluteFile());
		file10= new BufferedWriter(fw10);
		String choice = null;
		
		
		
		int i=0;
		double mins[] = new double [6];
		double avgs[] = new double [6];
		double maxs[] = new double [6];
		int count=0;
		try {
		    BufferedReader in = new BufferedReader(new FileReader("C:\\Experiments\\files\\RS\\test2 time.txt"));
		    String str;
		    
		    while ((str = in.readLine()) != null){
//		    	if (i==1000)
//		    		break;
		    	String line = str;
		    	String[] details = line.split("\t");
		    	if (details[0].isEmpty() ){
		    		//file.write("\r"); 		
		    		continue;
		    	}
		    	if (details[0].contains("It ") ){
		    		file.write("\r");
		    		file2.write("\r");
		    		file3.write("\r");
		    		file4.write("\r");
		    		file5.write("\r");
		    		file6.write("\r");
		    		file7.write("\r");
		    		file8.write("\r");
		    		file9.write("\r");
		    		file10.write("\r");
		    		i++;
		    		count=0;
		    		continue;
		    	}
		    	if(details[0].contains("is 200000" )){
		    		choice = "10";

		    		continue;
		    	}
		    	else if(details[0].contains("is 120000" )){
		    		choice = "6";
		    		continue;
		    	}else if(details[0].contains("is 140000" )){
		    		choice = "7";

		    		continue;
		    	}else if(details[0].contains("is 160000" )){
		    		choice = "8";

		    		continue;
		    	}else if(details[0].contains("is 180000" )){
		    		choice = "9";

		    		continue;
		    	}else if (details[0].contains("is 20000" )){
		    		choice = "1";

		    		continue;
		    	} else if(details[0].contains("is 40000" )){
		    		choice = "2";

		    		continue;
		    	}else if(details[0].contains("is 60000" )){
		    		choice = "3";

		    		continue;
		    	}else if(details[0].contains("is 80000" )){
		    		choice = "4";

		    		continue;
		    	}else if(details[0].contains("is 100000" )){
		    		choice = "5";

		    		continue; 
		    	}else if(details[0].contains("is 200000" )){
		    		choice = "10";
		    	
		    		continue;
		    	}
		    		
		    	double min=1, max=0, avg=0, total =0;
		    	for (int j=0; j<1; j++){
		    		if (min> Double.parseDouble(details[j]))
		    			min = Double.parseDouble(details[j]);
		    			
		    		
		    		if (max< Double.parseDouble(details[j]))
		    			max = Double.parseDouble(details[j]); 	
		    		
		    		
		    		total +=Double.parseDouble(details[j]);
		    		
		    	}
		    	avg = total;
		    	DecimalFormat f = new DecimalFormat("##.00000");
				
		    	switch (choice) {
					case "1": file.write(f.format(avg) + "\t"); 
						file.flush();
						break;
					case "2": file2.write(f.format(avg) + "\t"); 
					file2.flush();
					break;
					case "3": file3.write(f.format(avg) + "\t"); 
					file3.flush();
					break;
					case "4": file4.write(f.format(avg) + "\t"); 
					file4.flush();
					break;
					case "5": file5.write(f.format(avg) + "\t"); 
					file5.flush();
					break;
					case "6": file6.write(f.format(avg) + "\t"); 
					file6.flush();
					break;
					case "7": file7.write(f.format(avg) + "\t"); 
					file7.flush();
					break;
					case "8": file8.write(f.format(avg) + "\t"); 
					file8.flush();
					break;
					case "9": file9.write(f.format(avg) + "\t"); 
					file9.flush();
					break;
					case "10": file10.write(f.format(avg) + "\t"); 
					file10.flush();
					break;
		    	}
		    	
		    	
				
		    	System.out.println(i);
		    	
		    	switch (count){
		    	case 0:
		    		mins[0]=min;
		    		avgs[0]= avg;
		    		maxs[0]=max;
		    		break;
		    	case 1:
		    		mins[1]= min;
		    		avgs[1]= avg;
		    		maxs[1]=max;
		    		break;
		    	case 2:
		    		mins[2]=min;
		    		avgs[2]= avg;
		    		maxs[2]=max;
		    		break;
		    	case 3:
		    		mins[3]=min;
		    		avgs[3]= avg;
		    		maxs[3]=max;
		    		break;
		    	case 4:
		    		mins[4]=min;
		    		avgs[4]= avg;
		    		maxs[4]=max;
		    		break;
		    	
		    	
		    	}
  
		    	count++;
		    }
		    in.close();
		} catch (IOException e) {
		}
		
	}
	
	public static void createFile() throws Exception{
		fileName = new File("C:\\Experiments\\files\\RS\\avg\\avg2time_1.txt");
		
		// if file does not exists, then create it
		if (!fileName.exists()) {
			fileName.createNewFile();
		}
	}
	
	public static void createFile2() throws Exception{
		fileName2 = new File("C:\\Experiments\\files\\RS\\avg\\avg2time_2.txt");
		
		// if file does not exists, then create it
		if (!fileName2.exists()) {
			fileName2.createNewFile();
		}
	}
	
	public static void createFile3() throws Exception{
		fileName3 = new File("C:\\Experiments\\files\\RS\\avg\\avg2time_3.txt");
		
		// if file does not exists, then create it
		if (!fileName3.exists()) {
			fileName3.createNewFile();
		}
	}
	
	public static void createFile4() throws Exception{
		fileName4 = new File("C:\\Experiments\\files\\RS\\avg\\avg2time_4.txt");
		
		// if file does not exists, then create it
		if (!fileName4.exists()) {
			fileName4.createNewFile();
		}
	}
	
	public static void createFile5() throws Exception{
		fileName5 = new File("C:\\Experiments\\files\\RS\\avg\\avg2time_5.txt");
		
		// if file does not exists, then create it
		if (!fileName5.exists()) {
			fileName5.createNewFile();
		}
	}
	
	public static void createFile6() throws Exception{
		fileName6 = new File("C:\\Experiments\\files\\RS\\avg\\avg2time_6.txt");
		
		// if file does not exists, then create it
		if (!fileName6.exists()) {
			fileName6.createNewFile();
		}
	}
	
	public static void createFile7() throws Exception{
		fileName7 = new File("C:\\Experiments\\files\\RS\\avg\\avg2time_7.txt");
		
		// if file does not exists, then create it
		if (!fileName7.exists()) {
			fileName7.createNewFile();
		}
	}
	
	public static void createFile8() throws Exception{
		fileName8 = new File("C:\\Experiments\\files\\RS\\avg\\avg2time_8.txt");
		
		// if file does not exists, then create it
		if (!fileName8.exists()) {
			fileName8.createNewFile();
		}
	}
	
	public static void createFile9() throws Exception{
		fileName9 = new File("C:\\Experiments\\files\\RS\\avg\\avg2time_9.txt");
		
		// if file does not exists, then create it
		if (!fileName9.exists()) {
			fileName9.createNewFile();
		}
	}
	
	public static void createFile10() throws Exception{
		fileName10 = new File("C:\\Experiments\\files\\RS\\avg\\avg2time_10.txt");
		
		// if file does not exists, then create it
		if (!fileName10.exists()) {
			fileName10.createNewFile();
		}
	}
	
	

}
