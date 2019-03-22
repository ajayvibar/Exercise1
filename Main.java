import java.util.*;

enum Menu {
               SEARCH("SEARCH"),
               EDIT("EDIT"),
               PRINT("PRINT"),
               RESET("RESET"),
               EXIT("EXIT");
               
               private final String name;
               
               private Menu(String name){
                    this.name = name;
               }
               
               @Override  
               public String toString(){
                    return this.name;
               }
               
               public boolean equals(String choice){
                    return choice.equals(name);
               }
               
               public static boolean search(String input){
                    boolean found = false;
                    
                    input = input.toUpperCase();
                    
                    for (Menu item : values()){
                        if(item.toString().equals(input)){
                            found = true;
                            break;
                        }
                    }
                    if(!found){
                        throw new RuntimeException("Please select among the choices.");
                    }
                    
                    return found;
               }      
}


public class Main{
             
    public static void main(String args[]){
            Exercise1 e1 = new Exercise1(); 
            Scanner sc = new Scanner(System.in);
            String choice;
                        
           do{
                printMenu();
                System.out.print(">>");
                choice = sc.nextLine().toUpperCase();

               try{ 
                    Menu.search(choice);
               }catch(RuntimeException e){
                    continue;
               }
                                
                switch(Menu.valueOf(choice)){
                    case SEARCH: 
                            e1.findCell();
                            System.out.println();
                            break;
                    case EDIT: e1.editCell();
                            System.out.println();
                            break;
                    case PRINT: e1.printMatrix();
                            System.out.println();
                            break;
                    case RESET: e1.generateMatrix();
                            System.out.println();
                            break;
                    case EXIT: System.out.println("Bye");
                            break;
                    
                    default: System.out.println();
                
                }
            
            }while(!(Menu.EXIT.equals(choice)));
           
            
        }
        
    /* prints menu for the program */
    private static void printMenu(){
        System.out.println();
        System.out.println(Menu.SEARCH);
        System.out.println(Menu.EDIT);
        System.out.println(Menu.PRINT);
        System.out.println(Menu.RESET);
        System.out.println(Menu.EXIT);
   }
   
   
}
