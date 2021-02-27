import java.util.Scanner;

public class pratice
{	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		 
		int[] A = new int[10];
		for(int i=0;i<10;i++){
		    A[i]=scan.nextInt();
		}
		
		for(int j=0;j<10;j++) {
			for(int i=0;i<10-1;i++) {
				if(A[i]>A[i+1]) {
					int t=A[i];
					A[i]=A[i+1];
					A[i+1]=t;
				}	        		
			}
		}
		for(int i=0;i<10;i++){
            System.out.print(A[i]+" ");
		}
	}
}