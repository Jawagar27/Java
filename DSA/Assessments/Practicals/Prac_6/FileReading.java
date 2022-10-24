import java.util.*;
import java.io.*;
public class FileReading {
   

   
public static DSA_Graph processline( DSA_Graph graph, String pfilename){
        //to read the files
   Scanner input = new Scanner(System.in);
    int selection;

    FileInputStream FIS = null;
    InputStreamReader ISR;
    BufferedReader Br;
    int linenum;
    String Line;


    try {			FIS = new FileInputStream(pfilename);
        ISR = new InputStreamReader(FIS);
        Br = new BufferedReader(ISR);
        linenum = 0;
        Line = Br.readLine();

        while(Line != null) {

            linenum++;
            String[] values = Line.split(" ");
            graph.addEdge(values[0], values[1]);
            Line = Br.readLine();

        }
        FIS.close();
    }catch(IOException e) {

        if(FIS != null) {
            try {
                FIS.close();
            }catch(Exception e2) {

            }
        }
        System.out.println("Error in file IO: " + e.getMessage());
    } 
    
    return graph;

}
}
