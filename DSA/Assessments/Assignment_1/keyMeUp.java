
import java.io.*;
import java.util.*;
public class keyMeUp {
    /* Comp 1002 Assignment 1
     * Author - Jawagar Prabaharan
     * Curtin id - 20944793
     * keyMeUp code */
    public static void main(String[] args) {
       DSA_Graph graph = new DSA_Graph();
        if (args.length == 0){
            //this must provide usage info
            usage_info();


        } else if (args.length == 1){
            if (args[0].equals("-i")){
                //here the menu if it was to be in interactive mode
                interactive_mode_menu(graph);
            }else{
                throw new IllegalArgumentException("Error in the command line argument!");
            }
        } else if (args.length == 4) {
            if (args[0].equals("-s")){
                //here the menu  if it was on silent mode
                String keyfile = args[1];
                String strFile = args[2];//the file that represents the keyboard
                String pathfile = args[3]; //the file that contains one or more strings to generate a path for
                silentMode(graph, keyfile, strFile, pathfile);
            }
        }else{
            System.out.println("Error in running the file!");
        }
    }

public static void usage_info(){
        System.out.println("This programme requires command line arguments!");
        System.out.println("To enter into interactive mode: ");
        System.out.print("Along the file name pass " + "-i");
        System.out.println(" ");
        System.out.println("To enter into silent mode: ");
        System.out.print("Along the file name pass " + "-s" + " and 3 other commands in order\n +" +
            "1.the file name to load\n 2.the file to load strings from\n 3.file to write to");

}
public static void menu2(){
        System.out.println("Welcome to interactive mode!");
        System.out.println("Please select from the below options");
        System.out.println("(1) Load keyboard file\n" +
                "(2) Node operations \n" +
                "(3) Edge operations \n" +
                "(4) Display graph\n" +
                "(5) Display graph information\n" +
                "(6) Enter string for finding path \n" +
                "(7) Generate paths\n" +
                "(8) Display paths\n" +
                "(9) Save keyboard\n" +
                "(0).Exit");
    System.out.println("");
}

public static void interactive_mode_menu(DSA_Graph graph){

        int selection;
        String label = "";
        Scanner input = new Scanner(System.in);
do{
        menu2();
        System.out.println("Please enter your selection: ");
        selection = input.nextInt();

        switch (selection){
            case 1:
            loadKeyboard(graph);
                break;

            case 2:
                node_operations(graph);
                break;

            case 3:
                edge_operations(graph);
                break;

            case 4:
                //display the graph
                graph.display();
                break;

            case 5:
                //display graph information
                System.out.println("The graph: ");
                graph.display();
                System.out.println("The toal number of vertices are: " + graph.getVertexCount());
                break;

            case 6:
                //enter string for finding paths
                System.out.println("Please enter a string to find path: ");
                label= input.next();

                break;

            case 7:
                //generate paths
                generate_path();
                break;

            case 8:
                break;

            case 9:
                break;

                default:
                break;

        }
}while (selection != 0);

        input.close();
}

public static void silentMode(DSA_Graph graph,String input_file, String file_strings, String outFile){

    String filename = input_file;
    processline(graph,filename);

    writeToFile(graph, outFile);
}

public static void writeToFile(DSA_Graph graph,String filename){
    try{
        PrintWriter pw = new PrintWriter(filename);
        pw.write(graph.display1());
        pw.close();
    }catch(IOException e1) {
        System.out.println("Error in file writing: " + e1.getMessage());
    }
}


public static void loadKeyboard(DSA_Graph graph){
        Scanner input = new Scanner(System.in);
        String filename = " ";

         System.out.println("Please enter the name of the file u want to read: ");
        filename = input.next();
        processline(graph,filename);
       


}

public static void processline( DSA_Graph graph, String pfilename){
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
    } System.out.println("File uploaded successfully");
    System.out.println("Do u want to display the graph as an adjacency list?\n(1).Yes\n(2).No");
    selection = input.nextInt();

    switch (selection){
        case 1:
            System.out.println("The adjacency lits");
            graph.display();
            break;

        case 2:
            System.out.println("Redirecting to the main menu!");
            interactive_mode_menu(graph);
            break;

        default:
            break;
    }

}
public static void node_operations(DSA_Graph graph){
    Scanner input = new Scanner(System.in);

        int selection, loop;
        int i = 0;
        String label = "";
   do {
       System.out.println("Please select from the following node operations: ");

       System.out.println("(1).Find\n(2).Insert\n(3).Delete\n(4).Update\n(5).Exit");
       selection = input.nextInt();
       switch (selection) {
           case 1:
               System.out.println("Please enter vertex to find: ");
               label = input.next();
               if (graph.hasVertex(label) == true) {
                   System.out.println("Vertice found");
               } else {
                   System.out.println("Vertice not found");
               }
               break;
           case 2:
               System.out.println("Please enter vertex to add: ");
               label = input.next();
               graph.addVertex(label);
               System.out.println("Vertice added successfully");


               break;
           case 3:
               //delete a node

               break;
           case 4:
               //update a node

               break;
       }
   }while(selection != 5);

    input.close();
    }

    public static void edge_operations(DSA_Graph graph){
        Scanner input = new Scanner(System.in);

        int selection, loop;
        String label1,label2;
   do {
       System.out.println("Please select from the following edge operations: ");
       System.out.println("(1).Find\n (2).Insert\n (3).Delete\n (4).Update\n(5).Exit");
       selection = input.nextInt();

       switch (selection) {
           case 1:
               System.out.println("Please enter vertex to find: ");
               label1 = input.next();
               if (graph.hasVertex(label1) == true) {
                   System.out.println("Vertice found");
               } else {
                   System.out.println("Vertice not found");
               }
               break;
           case 2:
               System.out.println("Please enter number of vertices to add: ");
               loop = input.nextInt();

               System.out.println("Please enter first vertex to add links: ");
               label1 = input.next();
               System.out.println("Please enter second vertex to add links: ");
               label2 = input.next();
               graph.addEdge(label1, label2);
               break;
           case 3:
               //delete a node
               System.out.println("Please enter vertex 1 to find: ");
               label1 = input.next();
               System.out.println("Please enter vertex 2 to find: ");
               label2 = input.next();
               if ((graph.hasVertex(label1) == false) && (graph.hasVertex(label2) == false)) {
                   System.out.println("Edge is not present");
               } else {
                   //delete the node
               }

               break;
           case 4:
               //update a node

               break;
       }
   }while(selection != 5);

        input.close();
    }
public static void generate_path(){

}
}