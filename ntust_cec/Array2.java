/**
 * Auto Generated Java Class.
 */
import java.util.Scanner;
public class Array2 {
  
  
  public static void main(String[] args) { 
    
    Scanner Scan = new Scanner(System.in);
    int[][]arr=new int[3][5];
    int id =0;
    
    for(int i = 0; i < arr.length; i++) { 
      for(int j = 0; j < arr[0].length; j++){ 
          
        arr[i][j] = (int)(Math.random()*100)+1;
            System.out.println(arr[i][j]);   
      }
    }

    for(int i=0; i<arr.length;i++){
      id = i+1;
      System.out.print("Number:"+id+1+": \t");
      for(int j=0;j<arr[i].length;j++){
        System.out.print(arr[i][j]+"\t");
}
      System.out.println("");
    
    }
 }
}
    
    
  
