import java.util.Scanner;
public class a020{
    public static void main(String[] args){
        Scanner s=new Scanner(System.in);
        int[] n=new int[]{10,11,12,13,14,15,16,17,34,18,19,20,21,22,35,23,24,25,26,27,28,29,32,30,31,33};
        String input=s.next();
        int sum=0;
        int loca=input.charAt(0)-'A';
        sum+=(n[loca]%10*9+n[loca]/10);
        for(int i=1;i<9;i++){
            loca=(input.charAt(i)-'0')*(9-i);
            sum+=loca;
        }
        sum+=input.charAt(9)-'0';
        if(sum%10==0){
            System.out.print("real");
        }
        else{
            System.out.print("fake");
        }
    }
}

//1132