/**
 * Auto Generated Java Class.
 */
import java.util.Scanner;
public class Test {
  
  
  public static void main(String[] args) { 
    
    Scanner Scan = new Scanner(System.in);
    System.out.println("Press money");
    
    int b=0;    
    while(b<100000){
      
      int a = Scan.nextInt();
      if(b<100000){
        
      b += a;
      System.out.println("Left how much"+(100000-b));
      
      }
      
      if(b>=100000){
        
      break;
      
      }
      
  }
        System.out.println("Done");
  }  
}
