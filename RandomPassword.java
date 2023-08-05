import java.util.HashMap;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RandomPassword {
    
    public static Scanner keyboard = new Scanner(System.in);
    public static HashMap<String, String> userPass = new HashMap<String, String>();
    public static void main(String[] args){

        
        int choice = 0;

        do{
            System.out.println("Would you like to login or create an account? \n1) Login  \n2) Create an account\n3) Quit");
            choice = keyboard.nextInt();

            switch(choice){
                case 1: logIn(); break;
                case 2: createAccount(); break;
                case 3: break;
                default: System.out.println("Please input valid number");
        }
    }
    while(choice != 3);

    System.out.println(userPass.toString());
    
    } // End of Main

    public static void logIn(){

    }

    public static void createAccount(){
        System.out.println("Please Input valid Username");
        String userName = keyboard.next();
        System.out.println("1) Create own password \n2)Random Password");
        int choice = keyboard.nextInt();
        String passWord = null;
        
        if(choice == 2)
            passWord = generateRandomPassword();
        else
            passWord = keyboard.next();
        
        userPass.put(userName, passWord);
        
    }

    public static void storeToFile(){

    }

    public static void loadFromFile(){

    }

    public static String generateRandomPassword(){
        return "";
    }


}
