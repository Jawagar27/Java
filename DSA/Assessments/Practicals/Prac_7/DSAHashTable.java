import java.util.Objects;

public class DSAHashTable {
    private DSAHashEntry[] hashArray;
    private Integer count;
    private Integer arrSize;

    public DSAHashTable(Integer tableSize)
    {
        if (!checkPrime(tableSize)) //method to check if the value is a prime number 
        {
            arrSize = nextPrime(tableSize);
        }
        else
        {
            arrSize = tableSize;
        }
        hashArray = new DSAHashEntry[arrSize];
        count = 0;
        for (int i = 0; i < arrSize; i++)
        {
            hashArray[i] = new DSAHashEntry();
        }
    }
//Inserting keys and values
    public void put(String inKey, Integer inValue)
    {

        int location = hash(inKey);
        boolean inserted = false;

        if (getLoadFactor() >= 0.75)
        {
            resize();
        }

        if (Objects.equals(hashArray[location].getKey(), ""))
        {
            hashArray[location] = new DSAHashEntry(inKey, inValue);
            hashArray[location].setState();
            count = count + 1;
        }
        else
        {
            int stepDistance = stepHash(inKey);
            do
            {
                location = location + stepDistance;
                location = location % arrSize;

                if (Objects.equals(hashArray[location].getKey(), ""))
                {
                    inserted = true;
                    hashArray[location] = new DSAHashEntry(inKey, inValue);
                    hashArray[location].setState();
                    count = count + 1;
                }
            } while (!inserted);
        }
    }

    private Integer hash(String inKey)
    {
        char c = inKey.charAt(0);
        return (int) c % arrSize;
    }

    private Integer stepHash(String inKey)
    {
        char c = inKey.charAt(0);
        return 7 - ((int) c % arrSize % 7);
    }

    public DSAHashEntry get(String inKey)
    {
        return find(inKey);
    }
//Removing the key
    public void remove(String inKey)
    {
        DSAHashEntry hashEntry = find(inKey);
        if (!Objects.equals(hashEntry.getKey(), ""))
        {
            hashEntry.setKey("");
            hashEntry.setValue(null);
            count = count - 1;
        }
    }
// Finding the specific key and value by entering the key
    private DSAHashEntry find(String inKey)
    {
        int location = hash(inKey);
        DSAHashEntry returnDSAHashEntry = new DSAHashEntry();

        if (hashArray[location].getKey().equals(inKey))
        {
            returnDSAHashEntry = hashArray[location];
        }
        else
        {
            if (hashArray[location].getState() == 1)
            {
                int stepDistance = stepHash(inKey);
                do
                {
                    location = location + stepDistance;
                    location = location % arrSize;

                    if (hashArray[location].getKey().equals(inKey))
                    {
                        returnDSAHashEntry = hashArray[location];
                    }

                } while (hashArray[location].getState() == 1 || hashArray[location].getKey().equals(inKey));
            }
        }
        return returnDSAHashEntry;
    }

    private Double getLoadFactor()
    {
        Double dCount = Double.valueOf(count);
        Double dArrSize = Double.valueOf(arrSize);
        return ( dCount / dArrSize);
    }
    //displaying the hashtable
    public void export()
    {
        for (int i = 0; i < arrSize; i++)
        {
            System.out.print("|" + i + " | " + hashArray[i].getKey() + "|" + hashArray[i].getValue() + "|" +
                    hashArray[i].getState() + "|");
            System.out.println();
        }
    }

    private void resize()
    {
        Integer oldSize = arrSize;
        Integer oldCount = count;

        while (getLoadFactor() >= 0.75)
        {
            arrSize = nextPrime(arrSize);
        }

        while (getLoadFactor() <= 0.30)
        {
            arrSize = arrSize / 5 * 3;
            arrSize = nextPrime(arrSize);
        }

        DSAHashEntry[] copyTable = hashArray;

        hashArray = new DSAHashEntry[arrSize];
        for (int i = 0; i < arrSize; i++)
        {
            hashArray[i] = new DSAHashEntry();
        }

        count = 0;

        for (int i = 0; i < oldSize; i++)
        {
            if (!Objects.equals(copyTable[i].getKey(), ""))
            {
                put(copyTable[i].getKey(), copyTable[i].getValue());
            }
        }
        count = oldCount;
    }

    private Integer nextPrime(Integer oldSize)
    {
        oldSize++;
        for (int i = 2; i < oldSize; i++)
        {
            if (oldSize % i == 0)
            {
                oldSize++;
                i = 2;
            }
        }

        return oldSize;
    }

    private boolean checkPrime(Integer loopNumber)
    {
        boolean returnBool = false;
        if (loopNumber % 2 != 0)
        {
            for (int i = 3; i * i <= loopNumber; i += 2)
            {
                if (loopNumber % i != 0) {
                    returnBool = true;

                }
            }
        }
        return returnBool;
    }
}
