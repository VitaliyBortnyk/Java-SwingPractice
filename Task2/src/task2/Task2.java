package task2;

import java.io.IOException;
import java.io.FileWriter;

public class Task2 {

    public static void main(String[] args) {
        int firstSymbol = 33;
        int lastSymbol = 256;
        
        try (FileWriter writer = new FileWriter("result.txt", false))
        {
            while(firstSymbol < lastSymbol)
            {
                char ch = (char) firstSymbol;
                String oct = Integer.toOctalString(firstSymbol);
                String hex = Integer.toHexString(firstSymbol);
                System.out.printf("%03d %3s %5s %4s%n", firstSymbol, ch, oct, hex);
            
                writer.write(firstSymbol +"\t"+ ch +"\t"+ oct +"\t"+ hex +"\n");
                
                firstSymbol++;
            }
            writer.flush();
        }
        catch(IOException  ex)
        {
            System.out.println(ex.getMessage());
        }
    }
    
}