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
import java.util.Arrays;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableColumn;



public class CompareValues {

	
	
	private static double time;
	private static BufferedWriter file;
	private static BufferedWriter file2;
	private static String[] priorityG = {"0", "25", "50", "75", "100"};
	private static String[] probabilityG = {"0", "50", "100"};
	private static String[] consequenceG = {"0", "25", "50", "75", "100"};
	private static Double[] nums= {0.055218267,	0.038966533,	0.058469867,	0.026326667,	0.023639733,	0.017198267,	0.0201208,
		0.015903467,	0.012780933,	0.0110172,	0.004880933,	0.011540933,	0.029176133,	0.005244133,	0.0047168,	0.007742533,
		0.0096024,	0.004804667,	0.004432,	0.004811067};
	
	private static Double[] nums2= {0.298671067,	0.389779733,	0.433076133,	0.429501867,	0.453087067,	0.4553016,	0.468699333,
		0.472280933,	0.466144267,	0.478770933,	0.4638424,	0.481509467,	0.4844628,	0.481717733,	0.482629067,	0.4809708,
		0.479743067,	0.490684667,	0.488316,	0.491351733};

	
	private static Double[] nums3= {0.022364667,	0.023578133,	0.020748533,	0.0173488,	0.0139452,	0.013456933,	0.012594133,
		0.011736133,	0.014405067,	0.014235467};
	

	private static Double[] nums4 = {0.43135,	0.476553733,	0.502160533,	0.4853784,	0.501968933,	0.499627733,	0.508146667,
		0.5074632,	0.499333867,	0.5097524,	0.493433467,	0.5098244,	0.510993067,	0.507241867,	0.507100667,	0.504429467,
		0.502185467,	0.5122028,	0.509340267,	0.511698133};
	
	
	private static Double[] nums5= {0.119790267,	0.048849733,	0.0522956,	0.020949067,	0.049243067,	0.107444667,	0.153091467,
		0.019441867,	0.109046933,	0.064404533,	0.083574933,	0.03725,	0.0689132,	0.042914267,	0.0223956,	0.057551067,
		0.0395268,	0.1083732,	0.059491333,	0.0793588};

	
	
	
	
//	private static String[] epriorityG = {"0", "25", "50", "75", "100"};
//	private static String[] eprobabilityG = {"0", "50", "100"};
//	private static String[] econsequenceG = {"0", "25", "50", "75", "100"};
	

	private static File fileName;
	private static File fileName2;
	
	public static void main(String[] args) throws Exception {
		
		
		readFile();
		
		
	}
	
	public static void readFile() throws Exception{		
		
		
		Arrays.sort(nums);
		Arrays.sort(nums3);
		Arrays.sort(nums2);
		Arrays.sort(nums5);
		Arrays.sort(nums4);
		for (int i=0;i<20 ;i++){
			System.out.println(i+1  + "  is "  + nums4[i]);
			
		}
	
		
	}
	
	public static void createFile() throws Exception{
		fileName = new File("C:\\Personal\\practice\\files\\avg2000.txt");
		

		// if file does not exists, then create it
		if (!fileName.exists()) {
			fileName.createNewFile();
		}
	}
	
	public static void createFile2() throws Exception{
		fileName2= new File("C:\\Personal\\practice\\files\\avgAlgo2000.txt");
		

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
