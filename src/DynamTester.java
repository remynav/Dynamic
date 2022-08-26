
public class DynamTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		int[][] cookiesAlongTrail= { {7, 9, 3},
//									{2, 10, 6},
//									{-1, 4, 2}, 
//									{8, 5, 1}};
//		System.out.print(DynamicProgramming.dynamicCookies(cookiesAlongTrail));
		
		int[] times= {5,9,11,12,14,16,17,20,24,25,29,30,33,34,39,41,45,46};
		int[] points= {8,2,8,8,9,1,5,6,5,8,4,7,8,3,1,7,8,8};
		System.out.print(DynamicProgramming.scavHunt(times, points));
		
		
		}
		
		
	}


