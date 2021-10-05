package task4;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Task4 {

    static boolean IsValid(int number)
    {
        if(number >= -51 && number <= 51)
            return true;
        return false;
    }
    
    static String NegativeInSectors(int [][] Array)
    {
        int endOfTwoSector = 2;
        int endOfFourSector = 4;
        int twoSectorCounter = 0;
        int fourSectorCounter = 0;
        
        for(int i = 0; i < endOfTwoSector; i++)
            for(int j = 0; j < endOfTwoSector; j++)
                if(Array[i][j] < 0)
                    twoSectorCounter++;
        
        for(int i = 0; i < endOfFourSector; i++)
            for(int j = 0; j < endOfFourSector; j++)
                if(Array[i][j] < 0)
                    fourSectorCounter++;
        
        String info = "Negative number in two sector: " + Integer.toString(twoSectorCounter) + 
                "\nNegative number in four sector: " + Integer.toString(fourSectorCounter) + "\n";
        return info;
    }
    
    public static void main(String[] args) throws Exception {
        
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        final int row = 5;
        final int column = 5;
        int [][] Array = new int[5][5];
        
        System.out.print("1 - random\n2 - enter with keyboard\nother - exit\n");
        System.out.print("Enter number: ");
        int menu = Integer.parseInt(reader.readLine());
        
        switch(menu)
        {
            case 1: 
                for(int i = 0; i < row; i++)
                    for(int j = 0; j < column; j++)
                        Array[i][j] = (int) Math.round((Math.random() * 100) - 50);
                break;
                
            case 2:
                for(int i = 0; i < row; i++)
                    for(int j = 0; j < column; j++)
                    {
                        while(true)
                        {
                            System.out.print("[" + (i+1) + "]" + "[" + (j+1) + "]: ");
                            int number = Integer.parseInt(reader.readLine());
                            if(IsValid(number))
                            {
                                Array[i][j] = number;
                                break;
                            }
                            else
                            {
                                System.out.println("Enter number >= 51 and <= 51");
                            }
                        }
                    }
                
            default: break;
        }
        
        for(int i = 0; i < row; i++)
        {
            for(int j = 0; j < column; j++)
                System.out.printf("%5s", Array[i][j]);
            System.out.println();
        }
        
        System.out.print(NegativeInSectors(Array));
    }
    
}
