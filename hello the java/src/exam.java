import java.util.Scanner;

public class exam{	
	public static void main(String[] args){
		Scanner Scan = new Scanner(System.in);
		int[] Code = new int[] {10,11,12,13,14,15,16,17,34,18,19,20,21,22,35,23,24,25,26,27,28,29,32,30,31,33};
		String Type;
		Type = Scan.next();
		Type = Type.toUpperCase();
		int SUM;
		SUM = 0;
		int County;
		County = Type.charAt(0)-'A';
		SUM = (Code[County]%10*9+Code[County]/10);
		for(int i=1;i<9;i++){
			int Number;
			Number = ((Type.charAt(i)-'0')*(9-i));
			SUM += Number;
		}
		SUM += Type.charAt(9)-'0';
		if(SUM%10==0) {
			System.out.print("real");
		}	
		else {
			System.out.print("fake");
		}
	}
}	
