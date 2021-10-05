package task5;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Task5 {

    public static void main(String[] args) throws Exception 
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        int size = 6;
        int [][] Array = new int[6][6];
        int count = 0;
        
        for(int i = 0; i < size; i++)
            for(int j = 0; j < size; j++)
            {
                Array[0][j] = 0;
                Array[size - 1][j] = 0;
                Array[i][0] = 0;
                Array[i][size - 1] = 0;
            }
        
        for(int i = 1; i < (size - 1); i++)
            for(int j = 1; j < (size - 1); j++)
            {
                System.out.print("[" + i + "]" + "[" + j + "]: ");
                Array[i][j] = Integer.parseInt(reader.readLine());
            }
        
        for(int i = 0; i < size; i++)
        {
            for(int j = 0; j < size; j++)
                System.out.printf("%2s", Array[i][j]);
            System.out.println();
        }
        
        for(int i = 1; i < (size - 1); i++)
            for(int j = 1; j < (size - 1); j++)
                if(Array[i][j] == 1 && Array[i][j-1] == 0 && Array[i-1][j] == 0 && Array[i-1][j-1] == 0)
                {
                    Array[i][j] = 1; 
                    count += 1;
                }
        System.out.println("Count of rectangle: " + count);
        
    }
    
}
