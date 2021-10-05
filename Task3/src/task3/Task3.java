package task3;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Task3 {

    static boolean IsSimple(int number)
        {
            for(int i = 2; i*i <= number; i++)
            {
                if(number % i == 0) return false;
            }
            return true;
        }
    
    public static void main(String[] args) throws IOException 
    {
        
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        System.out.print("Enter number: ");
        int num = Integer.parseInt(reader.readLine());
        if(IsSimple(num))
        {
          System.out.println("Number " + String.format("%10s", num).replace(' ', '#') + "  is simple");
        }
        else
          System.out.println("Number is not simple");
    }    
}
