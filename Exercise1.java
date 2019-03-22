import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
*   Exercise1
*   >Generate a 2d array where dimensions are given by the user, that consists of
*    strings made up of random ascii chars.
*   >Allow user to: 
*        +regenerate the matrix to dimensions given by the user
*        +Edit a certain entry in the matrix
*        +Search for a substring in the entire matrix
*   
*   @java version: 1.8.0
*   @author: Aron Vibar
*   @date : 11/Feb/2019
*/

public class Exercise1{
    private final static int CELL_LENGTH = 3;
    private final static String ALPHABET = "`1234567890-=qwertyuiop[]\\"
            +" asdfghjkl;'zxcvbnm,./QWERTYUIOPASDFGHJKLZXCVBNM_+{}:\"><?";
    
    private Scanner sc = new Scanner(System.in);
    private String[][] matrix;
    
    public Exercise1(){
        this.sc = sc.useDelimiter("\\n");
        generateMatrix();
        
    }
    
    
    /*get an integer from user */
    public int getInteger(String message){
        int num;
        System.out.print(message);
        
        while(!sc.hasNextInt()){
            System.out.println("You did not enter an Integer");
            System.out.print(message);
            sc.next();
        }//will not stop until user has input an integer
        
        num = sc.nextInt();
        //String dump = sc.nextLine();
        return num;
    } 
    
    /* Generates a string madeup of random characters from the alphabet depending on length */
    private String generateCell(int length){
        Random r = new Random();
        String str = "";
        
        for (int i=0;i<length;i++){
            str = str + ALPHABET.charAt(r.nextInt(ALPHABET.length()));
                  
        }
        
        return str;
    }
   
   /** Generates 2D matrix of cells*/ 
   public void generateMatrix(){
        int rows;
        int cols;
        
        rows = getInteger("Enter row size: ");
        
        if(rows <= 0){
            while(rows <= 0){
                System.out.println("0 or less is invalid.");
                rows = getInteger("Enter row size: ");
            }
        }// rows and, later, columns will not accept 0 and negatives as values
        
        cols = getInteger("Enter column size: ");
        
        if(cols <= 0){
            while(cols <= 0){
                System.out.println("0 or less is invalid.");
                cols = getInteger("Enter column size: ");
            }
        }
        
        this.matrix = new String[rows][cols];
        
        for (int i=0;i<rows;i++){
            for (int j=0;j<cols;j++){
                this.matrix[i][j] = generateCell(CELL_LENGTH);
            }
        }
        
        
   }
   
   /* edits a specified cell in the matrix */
   public void editCell(){
        int row;
        int col;
         
        row = getInteger("Select Row: ");
        if(row >= this.matrix.length || row < 0){
            while(row >= this.matrix.length || row < 0){
                System.out.println("Row should be less than " 
                            + this.matrix.length + " or >= 0.");
                        
                row = getInteger("Select Row: ");
            }
        }
        
        col = getInteger("Select Column: ");
        if(col >= this.matrix[0].length || col < 0){
            while(col >= this.matrix[0].length || col < 0){
                System.out.println("Column should be less than " 
                            + this.matrix.length + " or >= 0.");
                col = getInteger("Select Column: ");
            }
        }
        
        //sc = new Scanner(System.in);
        System.out.print("Replacement String: ");
        this.matrix[row][col] = sc.next();
        
   }
   
   /*lists all found substring given by the user*/
   public void findCell(){
        int count = 0;
        int result = 0;
        int last_index = 0;
        
        
        System.out.print("Search String: ");
        //sc = new Scanner(System.in);
        String temp = sc.next();
        
        
        for (int i=0;i<this.matrix.length;i++){
            for (int j=0;j<this.matrix[0].length;j++){
                if(this.matrix[i][j].contains(temp)){
                    while(last_index != -1){
                        last_index = this.matrix[i][j].indexOf(temp, last_index);
                        
                        if(last_index != -1){
                            count++;
                            result++;
                            last_index++;
                        }
                    }
                    System.out.println(temp + " was found in (" + i + ", "+ j 
                                        +  ") " + count + " times");
                    count = 0;
                    last_index = 0;
                }
            }
            
            
        }
        
        if(result == 0){
            System.out.println(temp + " was not found.");
        }
        
   }
   
   /* prints current 2d matrix */
   public void printMatrix(){
        System.out.println();
        for (int i=0;i<this.matrix.length;i++){
            for (int j=0;j<this.matrix[0].length;j++){
                System.out.print(this.matrix[i][j]  + " | ");
            }
            System.out.println();
        }
        
        System.out.println();
   }
       
}
