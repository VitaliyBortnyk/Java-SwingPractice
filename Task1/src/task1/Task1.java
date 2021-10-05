package task1;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Task1 {

    static double mabs(double x){ return (x < 0)? -x : x; }
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        System.out.print("Enter number: ");
        double num = Double.parseDouble(reader.readLine());
        System.out.print("Enter degree: ");
        int rootDegree = Integer.parseInt(reader.readLine());
        
        double eps = 0.0001;
        double root = num / rootDegree;
        double rn = num;
	int count = 0;
        
        while(mabs(root - rn) >= eps)
        {
	    rn = num;
            for(int i = 1; i < rootDegree; i++){
		rn = rn / root;
            }
            root = 0.5 * ( rn + root);
            count++;
	}
        
        System.out.println("Root: " + Double.toString(root));
        System.out.println("Number of iteration: " + Integer.toString(count));
    }
}
        