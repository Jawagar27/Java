import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.*;
public class trigger {
    
    public static void main(String[] args) {
        DSA_LinkedList list = new DSA_LinkedList();
        Scanner input = new Scanner(System.in);
        int num,x;
    do{    System.out.println("Welcome to the program!");
        System.out.println("Please select one from the provided options:");
        System.out.println("    1.Insert first in a list");
        System.out.println("    2.Insert last in a list");
        System.out.println("    3.Remove first in a list");
        System.out.println("    4.Remove last in a list");
        System.out.println("    5.Display list");
        System.out.println("    6.Write to a serialized file");
        System.out.println("    7.Read from a serialized file");

        num = input.nextInt();

        switch (num) {
            case 1:
                System.out.println("Please enter a value to insert first: ");
                x = input.nextInt();
                list.insertatbeggining(x);
                break;

            case 2:
            System.out.println("Please enter a value to insert last: ");
            x = input.nextInt();
            list.insertatlast(x);
                break;

            case 3:
                list.deletefirst();
                System.out.println("First element removed successfully from the list!");

                break;

            case 4:
                list.deletelast();
                System.out.println("Last element removed successfully from the list!");
                break;

            case 5:
            System.out.println("Displaying list: ");
            list.displaylist();
                break;

             case 6:
            save(list, "test1.bin");
                break;

            case 7:
            read("test1.bin");
                break;
        
            default:
                break;
        }

    }while(num != 0);
    }

    public static void save(DSA_LinkedList list, String filename){

        FileOutputStream fstr;
        ObjectOutputStream Ostr;

        try {
            fstr = new FileOutputStream(filename);
            Ostr = new ObjectOutputStream(fstr);
            Ostr.writeObject(list);

            Ostr.close();
            System.out.println("File saved successfully");
        } catch (Exception e) {
           System.out.println("Error in file writing!");
        }
    }

   
    public static DSA_LinkedList read(String filename){

        FileInputStream fis;
        ObjectInputStream ois;
        DSA_LinkedList list = null;

        try {
            fis = new FileInputStream(filename);
            ois = new ObjectInputStream(fis);
            list = (DSA_LinkedList)ois.readObject();

            ois.close();
        } catch (ClassNotFoundException e) {
            System.out.println("class not found! " + e.getMessage());
        }
        catch(Exception e1){
            System.out.println(e1.getMessage());
        }
        System.out.println("File reading successfully done!");
return list;
    }
}
