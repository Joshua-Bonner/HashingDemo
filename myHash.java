import java.util.Arrays;
        
public class myHash {
    String[] array;
    int arraySize;
    
    // Driver
    public static void main(String[] args){
        myHash Hash = new myHash(30);
        
        // Simple Hash
        //String[] elementsAdded = {"0", "11", "22", "13", "4"};
        //Hash.SimpleHash(elementsAdded, Hash.array);
        
        // Linear Hash
        String[] elementsAdded = {"123", "234", "345", "456", "567", "678",
                                  "789",  "23", "134", "216", "433", "312",
                                  "687", "998", "321", "111", "222", "937",
                                   "65", "533", "787", "864", "552", "885",
                                  "227", "754", "878", "666", "444",  "72"};
        Hash.LinearHash(elementsAdded, Hash.array);
        
        // Print Hash Table
        Hash.printTable();
    }
    
    // Simple hash function
    public void SimpleHash(String[] addedStrings, String[] theArray){
        for (int i=0; i<addedStrings.length; i++){
            String newElement = addedStrings[i];
            theArray[Integer.parseInt(newElement)] = newElement;
        }
    }
    
    // Linear hash function
    public void LinearHash(String[] addedStrings, String[] theArray){
        for (int i=0; i<addedStrings.length; i++){
            String newElement = addedStrings[i];
            int arrayIndex = Integer.parseInt(newElement)%29;
            while (theArray[arrayIndex] != "-1"){
                ++arrayIndex;
                System.out.println("Collision Detected in Index: " + (arrayIndex-1) +
                        " Trying " + arrayIndex + " Instead"); 
                arrayIndex %= arraySize;
            }
            theArray[arrayIndex] = newElement;
        }
    }
    
    myHash(int size){
        arraySize = size;
        array = new String[size];
        Arrays.fill(array, "-1");
    }
    
    public void printTable(){
        int increment = 0;
        
        System.out.println();
        System.out.println("HASH TABLE : ");
        for (int i=0; i<3; i++){
            increment += 10;
            
            for (int j=0; j<71; j++)
                System.out.print("-");
            System.out.println();
            
            for (int n=increment-10; n<increment; n++) 
                System.out.format("| %3s " + " ", n);
            System.out.println("|");
            
            for (int j=0; j<71; j++) 
                System.out.print("-");
            System.out.println();
            
            for (int n=increment-10; n<increment; n++){
                if (array[n].equals("-1")) System.out.print("|      ");
                else System.out.print(String.format("| %3s " + " ", array[n]));
            }
            System.out.println("|");
            
            for (int j=0; j<71; j++) 
                System.out.print("-");
            System.out.println();
        }
        System.out.println();
    }
}
