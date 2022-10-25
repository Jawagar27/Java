import java.io.*;

public class Readfile {
    public static int getFileRowCount(String fileName) {
        int count = 0;

        File file = new File(fileName);
        FileInputStream fileStream = null;
        InputStreamReader rdr = null;
        BufferedReader br = null;

        try {
            // "covid_data.csv"
            fileStream = new FileInputStream(fileName);
            rdr = new InputStreamReader(fileStream);
            br = new BufferedReader(rdr);
            while (br.readLine() != null) count++;
        } catch (IOException errorDetails) {
            if (fileStream != null) {
                try {
                    fileStream.close();
                } catch (IOException ex2) {
                }
            }
            System.out.println("Error in fileProcessing: " + errorDetails.getMessage());
        }


        return count; // returning count to get the no of records to display in the menu title
    }
    public static void loadFile(String fileName, int count)
    {
        String myArr;
        DSAHashTable ht = new DSAHashTable(count);

        try
        {
            File file = new File(fileName);
            BufferedReader br = new BufferedReader(new FileReader(file));

            while ((myArr = br.readLine()) != null)
            {
                String[] value = myArr.split(",",-1);
                ht.put(value[1],Integer.parseInt(value[0]));
            }
        } catch (Exception e)
        {
            System.out.println("Error occurred during file handling");
        }

        ht.export();
    }

    public static void main(String[] args) {
        String fileName="RandomNames7000.csv";
        int count=getFileRowCount(fileName);
        loadFile(fileName,count);

    }
}
