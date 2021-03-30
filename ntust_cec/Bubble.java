/**
 * Auto Generated Java Class.
 */
import java.util.Scanner;
public class Bubble {
  
  
  public static void main(String[] args) { 
    
    Scanner S = new Scanner(System.in);
    int a []=new int[10];
    //int a []={20,30,50,10,70,40,90,0,80,100};
   for(int i=0;i<10;i++){
    a[i] = S.nextInt();
    }
   int temp;
    
    for(int i=0;i<a.length;i++){
      for(int j=i+1;j<a.length;j++){
        if(a[i]<a[j]){
          temp = a[i];
          a[i] = a[j];
          a[j] = temp;
        }
      }
      
      System.out.print("no."+i+" round ");
      for(int x=0;x<a.length;x++){
        System.out.print(a[x]+" ");
      }
      
      System.out.println();
    }
  }
}

    
    
    

  

