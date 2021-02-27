import java.util.Scanner;

public class test 
{
	public static void main(String[] args)
	{
		
		for(int i=1;i<=9;i++) {			
			for(int j=1;j<=9;j++) {
				System.out.println("i = "+i+", j = "+j);	
				System.out.println(i+"*"+j+"="+(i*j));	
			}
			System.out.println();
		}												
		/*
		Scanner scanner = new Scanner(System.in);
		int i = scanner.nextInt();
		int time = 0;
		
		while(i != 1){
			if(i % 2 == 0) {
				i /= 2;			
			}
			else {
				i = 3*i+1;
			}
			time++;
		}
		System.out.println(time);*/
	}
}