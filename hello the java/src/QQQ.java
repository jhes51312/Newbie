import java.util.Scanner;

 public class QQQ
{
 public static void main(String[] args)
 {
  Scanner scanner = new Scanner(System.in);
 

    while(true)
    {

     int i = 0;

      long a = scanner.nextLong();

      if(a == 0) 
      {
       System.out.println(a);

      }

      else
      {


       while(a > 0)
       {

        long c = a;

        a = a / 2;

        c %= 2;

        System.out.print(c);

        i = i + 1; 


       }
       System.out.println();

      }
    }
 }
}