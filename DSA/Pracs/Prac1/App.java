import java.util.*;
import java.io.*;

public class App {

	public static void main(String[] args) {
		FileInputStream FIS = null;
		InputStreamReader ISR;
		BufferedReader br;
		String line;
		int linenum;
		int[] values = new int[7001];
		
		try{
			FIS = new FileInputStream("C:/Users/Jawagar/Downloads/RandomNames7000(2).csv");
			ISR = new InputStreamReader(FIS);
			br = new BufferedReader(ISR);
			line = br.readLine();
			linenum = 0;
			
				while(line != null) {
					
					String[] data = line.split(",");
					values[linenum] = Integer.parseInt(data[0]);
					line = br.readLine();
					linenum++;
					}
				Sorts.bubbleSort(values);
				Sorts.selectionSort(values);
				Sorts.insertionSort(values);
				processLine(values);
				
				FIS.close();
		}catch(IOException e) {
			if(FIS != null) {
				try {
					FIS.close();
				}catch(IOException e2) {
					
				}
			System.out.println("Error in file reading: " + e.getMessage());
			}
		}
    }
	
	public static void processLine(int[] array) {
		
		
		
		FileOutputStream filestream = null;
    	PrintWriter pw;
		
		
	try {	
		
		
		
		filestream = new FileOutputStream("C:/Users/Jawagar/Desktop/Sorts.csv");
    	pw = new PrintWriter(filestream);
    	
    	for(int i = 1; i<array.length; i++) {
    		pw.println("ID"+i+":" + "," + array[i]);
    	}
    	
    	pw.close();
		
		
		System.out.println("File writing done!" );

	}catch(IOException e) {
		if(filestream != null) {
	    	try {
	    		filestream.close();
	    	}catch(IOException e1) {
	    		
	    	}
		System.out.println("Error in file processing: " + e.getMessage());
	}
	}
		
	}

}

