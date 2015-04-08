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



public class FindMin {

	
	
	private static double time;
	private static BufferedWriter file;
	private static BufferedWriter file2;
	private static String[] priorityG = {"0", "25", "50", "75", "100"};
	private static String[] probabilityG = {"0", "50", "100"};
	private static String[] consequenceG = {"0", "25", "50", "75", "100"};
	
//	private static String[] epriorityG = {"0", "25", "50", "75", "100"};
//	private static String[] eprobabilityG = {"0", "50", "100"};
//	private static String[] econsequenceG = {"0", "25", "50", "75", "100"};
	

	private static File fileName;
	private static File fileName2;
	
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
		
		int i=0;
		double mins[] = new double [6];
		double avgs[] = new double [6];
		double maxs[] = new double [6];
		int count=0;
		try {
		    BufferedReader in = new BufferedReader(new FileReader("C:\\Personal\\practice\\files\\test200.txt"));
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
		    		//file.write("It is "+ i + "\r");
		    		if (i !=0){
		    			int bestmin =0, bestavg = 1, bestMax =1;
		    			double minValue = mins[0];
		    			double avgValue = avgs[0];
		    			double maxValue = maxs[0];
		    			
		    			for (int k=0;k<5;k++){
		    				if (minValue>(mins[k+1])){
		    					bestmin = k+1;
		    					minValue = mins[k+1];
		    				}
		    				if (avgValue>avgs[k+1]){
		    					bestavg = k+1;
		    					avgValue = avgs[k+1];
		    				}
		    				if (maxValue>maxs[k+1]){
		    					bestMax = k+1;
		    					maxValue = maxs[k+1];
		    				}
		    				
		    			}
		    			String minAlgo = algoName(bestmin);
		    			String avgAlgo = algoName(bestavg);
		    			String maxAlgo = algoName(bestMax);
		    			file2.write("Min: " + minAlgo + "\t"); 	
		    			//.write("Avg: " + avgAlgo + "\t" + "\t" + "\t" + "\t" + "\t" + "\t"); 	
		    			//file2.write("Max: " + maxAlgo + "\r"); 	
		    			file2.flush();
		    		}
		    		i++;
		    		count=0;
		    		continue;
		    	}
		    	double min=1, max=0, avg=0, total =0;
		    	for (int j=0; j<10; j++){
		    		if (min> Double.parseDouble(details[j]))
		    			min = Double.parseDouble(details[j]);
		    			
		    		
		    		if (max< Double.parseDouble(details[j]))
		    			max = Double.parseDouble(details[j]); 	
		    		
		    		
		    		total +=Double.parseDouble(details[j]);
		    		
		    	}
		    	avg = total/10;
		    	DecimalFormat f = new DecimalFormat("##.00000");
				
				
				file.write(f.format(min) + "\t"); 
				file.flush();
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
		    	case 5:
		    		mins[5]=min;
		    		avgs[5]= avg;
		    		maxs[5]=max;
		    		break;
		    	
		    	}
  
		    	count++;
		    }
		    in.close();
		} catch (IOException e) {
		}
		
	}
	
	public static void createFile() throws Exception{
		fileName = new File("C:\\Personal\\practice\\files\\min200.txt");
		

		// if file does not exists, then create it
		if (!fileName.exists()) {
			fileName.createNewFile();
		}
	}
	
	public static void createFile2() throws Exception{
		fileName2= new File("C:\\Personal\\practice\\files\\minAlgo200.txt");
		

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
