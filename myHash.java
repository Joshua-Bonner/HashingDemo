import java.util.Arrays;
        
public class myHash {
    String[] array;
    int arraySize;
    
    public static void main(String[] args){
        myHash F = new myHash(30);
        
        String[] elementsAdded = {"0", "11", "22", "13", "4"};
        F.hash1(elementsAdded, F.array);
        F.printTable();
    }
    
    public void hash1(String[] addedStrings, String[] theArray){
        for (int i=0; i<addedStrings.length; i++){
            String newElement = addedStrings[i];
            theArray[Integer.parseInt(newElement)] = newElement;
        }
    }
    
    myHash(int size){
        arraySize = size;
        array = new String[size];
        Arrays.fill(array, "-1");
    }
    
    public void printTable(){
        int increment = 0;
        
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
    }
}
