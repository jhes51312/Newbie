import java.util.Scanner;

public class prac{
	public static void main(String[]args) {
		Scanner Scan = new Scanner(System.in);
		int[] arr = new int[64];
		int i = 0;
		int x;
		while (Scan.hasNext()) {
			x = Scan.nextInt();
			i = 0;
			while(x>0) {
				arr[i]=x%2;	
				x/=2;
				i++;					
			}
			for(int j=i-1;j>=0;j--) {
				System.out.print(arr[j]);
			}	
			System.out.println();
		}		
		Scan.close();
	}
}