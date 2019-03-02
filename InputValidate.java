import java.util.Scanner;
import java.util.ArrayList;

public class Hi{
    
    public Integer inputValidate(ArrayList<Choice> choiceList){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter choice: ");
        String choice = input.next();
        if (choice.equals("exit")){
            return -1;
        }
        else if(Integer(choice) > choiceList.size() || Integer(choice) < 0){
            return -2;
        }
        else{
            return Integer(choice);
        }
    }
}

