import java.util.Scanner;

public class newbie 
{
	public static void main(String[] args)
	{
		/*test class
		 * do more practice
		 * 1 = scissors
		 * 2 = stone
		 * 3 = paper
		 * 3 round 2 win
		 */
		String[] nx= {"scissors","stone","paper"};
		String A;
		int B; 
		int A_win,B_win;
		
		A_win = 0;
		B_win = 0;
		
		Scanner scanner = new Scanner(System.in);
		
		while(true){ 
			
			if(A_win >= 2||B_win >= 2)
				break;		
			
			System.out.printf("Please choose>>");
			A = scanner.next();
			B = (int)(Math.random()*3 + 1);
			while(!A.equals(nx[0]) && !A.equals(nx[1]) && !A.equals(nx[2])) {
				System.out.println("Wrong input");//print line
				System.out.printf("Please choose>>");//print function
				A = scanner.next();
			}
			
			if(A.equals(nx[0])&&B == 2) {
				B_win++;
			}
			else if(A.equals(nx[1])&&B ==3) {
				B_win++;
			}
			else if(A.equals(nx[2])&&B ==1){
				B_win++;
			}
			else if(A.equals(nx[0])&&B ==3) {
				A_win++;
			}	
			else if(A.equals(nx[1])&&B ==1) {
				A_win++;
			}	
			else if(A.equals(nx[2])&&B ==2) {
				A_win++;
			}	
			else {
				System.out.println("Tie");
			}
			
			System.out.println("A choose "+ A +" and B choose "+nx[B-1]);
			System.out.println("A win "+A_win+" game, and B win "+B_win+" games.");
														
		}
		if (A_win>=2) {
			System.out.println("A win the game!");
		}
		else {
			System.out.println("B win the game!");
		}
		
	}	
}