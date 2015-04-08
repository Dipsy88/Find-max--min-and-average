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
import java.util.List;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableColumn;



public class FindVarghaAndWhitney {

	private static double time;
	private static BufferedWriter file;
	private static BufferedWriter file2;
	private static String[] priorityG = {"0", "25", "50", "75", "100"};
	private static String[] probabilityG = {"0", "50", "100"};
	private static String[] consequenceG = {"0", "25", "50", "75", "100"};

	private static File fileName;
	private static File fileName2;
	
	public static void main(String[] args) throws Exception {	
		readFileVargha();
		readMannU();
	}
	
	public static void readFileVargha() throws Exception{		
		createFile();
		FileWriter fw = new FileWriter(fileName.getAbsoluteFile(), true);
		file = new BufferedWriter(fw);
		int countLower=0, countEqual =0, countHigher =0;
		try {
		    BufferedReader in = new BufferedReader(new FileReader("C:\\UiO\\Thesis\\Experiments\\RQ1\\Artificial\\test_38_1.txt"));
		    String str;
		    
		    while ((str = in.readLine()) != null){
//		    	if (i==1000)
//		    		break;
		    	String line = str;
		    	String[] details = line.split(" ");
		    	if (details[0].isEmpty() ){
		    		file.write("\r"); 
		    		
		    		continue;
		    	} 
		    	if (Double.parseDouble(details[1])<0.5){
		    		countLower++;
		    	} else if (Double.parseDouble(details[1])==0.5){
		    		countEqual++;
		    	} else if (Double.parseDouble(details[1])>0.5){
		    		countHigher++;
		    	} 

		    }
		    file.write("A is less than B " + countLower + "\t"); 
		    file.write("A is equal to B " + countEqual + "\t"); 
		    file.write("A is higher than B " + countHigher + "\n"); 
			file.flush();

		    in.close();
		} catch (IOException e) {
		}		
	}
	
	public static void readMannU() throws Exception{		
		createFile();
		FileWriter fw = new FileWriter(fileName.getAbsoluteFile(), true);
		file = new BufferedWriter(fw);
		int countLower=0, countEqual =0, countHigher =0, counter=0;
		List<Integer> arl = new ArrayList<Integer>();
		try {
		    BufferedReader in = new BufferedReader(new FileReader("C:\\UiO\\Thesis\\Experiments\\RQ1\\Artificial\\test_38_2.txt"));
		    String str;
		    
		    while ((str = in.readLine()) != null){
//		    	if (i==1000)
//		    		break;
		    	String line = str;
		    	String[] details = line.split(" ");
		    	if (line.contains("p-value ") ){
		    		counter++;
		    		
		    		if (Double.parseDouble(details[5])<0.05){
		    			arl.add(counter);
		    			countLower++;
		    		//	System.out.println(counter);
			    	} else if (Double.parseDouble(details[5])==0.05){
			    		countEqual++;
			    	} else if (Double.parseDouble(details[5])>0.05){
			    		countHigher++;
			    	} 
		    		
		    	}
		    }
		    file.write("\n");
		    file.write("read A is less than B " + countLower + "\t"); 
		    file.write("readA is equal to B " + countEqual + "\t"); 
		    file.write("read A is higher than B " + countHigher + "\n"); 
			file.flush();

		    in.close();
		} catch (IOException e) {
		}		
		int countLower2= 0,countEqual2 =0, countHigher2=0;
		try {
		    BufferedReader in = new BufferedReader(new FileReader("C:\\UiO\\Thesis\\Experiments\\RQ1\\Artificial\\test_38_1.txt"));
		    String str;
		    int count=0;
		    while ((str = in.readLine()) != null){
//		    	if (i==1000)
//		    		break;
		    	count++;
		    	String line = str;
		    	String[] details = line.split(" ");
		    	if (details[0].isEmpty() ){
		    		file.write("\r"); 
		    		
		    		continue;
		    	} 
		    	
		    	if (arl.contains(count)){
		    		//System.out.println(count);
		    		if (Double.parseDouble(details[1])<0.5){
			    		countLower2++;
			    	} else if (Double.parseDouble(details[1])==0.5){
			    		countEqual2++;
			    	} else if (Double.parseDouble(details[1])>0.5){
			    		countHigher2++;
			    	} 
		    	
		    	}
		    	

		    }
		    file.write("read and both A is less than B " + countLower2 + "\t"); 
		    file.write("read and both A is equal to B " + countEqual2 + "\t"); 
		    file.write("read and both A is higher than B " + countHigher2 + "\n"); 
			file.flush();

		    in.close();
		} catch (IOException e) {
		}		
		
	}
	
	public static void createFile() throws Exception{
		fileName = new File("C:\\UiO\\Thesis\\Experiments\\RQ1\\Artificial\\avg1.txt");
		

		// if file does not exists, then create it
		if (!fileName.exists()) {
			fileName.createNewFile();
		}
	}
	
	public static void createFile2() throws Exception{
		fileName2= new File("C:\\Experiments\\files\\avg\\avgAlgo1.txt");
		

		// if file does not exists, then create it
		if (!fileName2.exists()) {
			fileName2.createNewFile();
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
