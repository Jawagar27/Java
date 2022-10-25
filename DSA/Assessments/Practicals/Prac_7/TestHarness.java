import java.util.Scanner;

public class TestHarness {
    public static void main(String[] args)
    {
        String key;
        int value;
        Scanner sc=new Scanner(System.in);
        System.out.println("------HASHTABLE TEST HARNESS------");
        System.out.println("");
        System.out.print("Enter the hash table size: ");
        int sz=sc.nextInt();
        DSAHashTable hT = new DSAHashTable(sz);
        System.out.println("");
        System.out.println("-----TESTING INSERTION-----");
        for(int i=0; i<sz;i++){
            System.out.println("");
            System.out.print("Enter Key(STRING): ");
            key=sc.next();
            System.out.println("");
            System.out.print("Enter Value(INTEGER): ");
            value=sc.nextInt();
            hT.put(key,value);
            System.out.println("");
            System.out.println("KEY: "+key+" VALUE: "+value+" INSERTED");
        }
        hT.export();
        System.out.println("-----TESTING RESIZE-----");
        System.out.println("");
        System.out.print("Enter a Key: ");
        key= sc.next();
        System.out.println("");
        System.out.print("Enter a Value: ");
        value= sc.nextInt();
        try{
            hT.put(key, value);
            System.out.println("");
            System.out.println("PASSED! ");
        }catch (Exception e){
            System.out.println("FAILED! ");
        }
        hT.export();
        System.out.println("-----TESTING REMOVE-----");
        System.out.println("");
        System.out.print("Enter a previously entered key to delete: ");
        String rKey= sc.next();
        try{
            System.out.println("");
            System.out.println("Removing "+rKey);
            hT.remove(rKey);
            System.out.println("Remove Completed!");
            hT.export();
        }catch (Exception e){
            System.out.println("FAILED");
        }
       


        System.out.println("All tests successfully completed!");


    }
}
