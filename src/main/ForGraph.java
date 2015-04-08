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



public class ForGraph {

	
	
	private static double time;
	private static BufferedWriter file;
	private static BufferedWriter file2;
	private static BufferedWriter file3;
	
	private static String[] priorityG = {"0", "25", "50", "75", "100"};
	private static String[] probabilityG = {"0", "50", "100"};
	private static String[] consequenceG = {"0", "25", "50", "75", "100"};
	
//	private static String[] epriorityG = {"0", "25", "50", "75", "100"};
//	private static String[] eprobabilityG = {"0", "50", "100"};
//	private static String[] econsequenceG = {"0", "25", "50", "75", "100"};
	

	private static File fileName;
	private static File fileName2;
	private static File fileName3;
	
	
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
		
		createFile2();
		FileWriter fw3 = new FileWriter(fileName3.getAbsoluteFile());
		file2= new BufferedWriter(fw3);
		
		int i=0;
		double mins[] = new double [6];
		double avgs[] = new double [6];
		double maxs[] = new double [6];
		int count=0;
		try {
		    BufferedReader in = new BufferedReader(new FileReader("C:\\Personal\\practice\\files\\min38.txt"));
		    String str;
		    
		    while ((str = in.readLine()) != null){
//		    	if (i==1000)
//		    		break;
		    	String line = str;
		    	String[] details = line.split("\t");
		    	if (details[0].isEmpty() ){
		    		file.write("\r"); 
		    		
		    		continue;
		    	}
		    	if (details[0].contains("It")){
		    		file.write("It is "+ i + "\r");		    		
		    		count=0;
		    		continue;
		    	}		    	
		    	
		    	file.write(details[0] + "\t" );
		    	
		    	
		    	
		    	count++;
		    }
		    in.close();
		} catch (IOException e) {
		}
		
	}
	
	public static void createFile() throws Exception{
		fileName = new File("C:\\Personal\\practice\\files\\graph38 min.txt");

		// if file does not exists, then create it
		if (!fileName.exists()) {
			fileName.createNewFile();
		}
	}
	
	public static void createFile2() throws Exception{
		fileName2= new File("C:\\Personal\\practice\\files\\graph38 avg.txt");
		

		// if file does not exists, then create it
		if (!fileName2.exists()) {
			fileName2.createNewFile();
		}
	}
	
	public static void createFile3() throws Exception{
		fileName3= new File("C:\\Personal\\practice\\files\\graph38 max.txt");
		

		// if file does not exists, then create it
		if (!fileName3.exists()) {
			fileName3.createNewFile();
		}
	}
	
	//Algorithm name
	public static String algoName(int i){
		switch (i){
		case 0:
			return "AVM";
		case 1:
			return "GA";
		case 2:
			return "(1+1)EA";
		case 3:
			return "RS";
		case 4:
			return "HC";
		case 5:
			return "Greedy";
		}
		return "error";
		
	}
	

}
