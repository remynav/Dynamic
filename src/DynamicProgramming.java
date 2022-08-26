
public class DynamicProgramming {


	
    // Every day for the rest of the year, you're going to be given a choice between two jobs to do: 
    // one that is LOW stress, and one that is HIGH stress.  Each job pays out a dollar amount; 
    // *usually* the high stress jobs pay more.  However, after doing a high stress job, you need to 
    // REST for a day.

    // Given a list of all the payouts for all the low stress and high stress jobs, 
    // what is the most amount of money you can get?
    
    // You can assume lowPayouts.length == highPayouts.length
    public static int hiLoStress(int[] lowPayouts, int[] highPayouts) {
    	int[] bestPay= new int[lowPayouts.length+1];
    	bestPay[lowPayouts.length]=0;
    	int goToHigh=0;
    	for(int i=bestPay.length-2; i>=0;i--) {
    		if(i<bestPay.length-4) {
    			 goToHigh= highPayouts[i]+bestPay[i+2];
    		}
    		else {
    			goToHigh=highPayouts[i];
    		}
    		int goToLow = lowPayouts[i]+bestPay[i+1];
    		bestPay[i]= Math.max(goToHigh, goToLow);
    		
    	}
    	return bestPay[0]+1;
    }
    
    
	// You are partaking in a scavenger hunt!
    // You've gotten a secret map to find many of the more difficult
    // items, but they are only available at VERY specific times at
    // specific places.  You have an array, times[], that lists at which
    // MINUTE an item is available, in increasing order.
    // Items in the ScavHunt are worth varying numbers of points.
    // You also have an array, points[], same length as times[],
    // that lists how many points each of the corresponding items is worth.
    // Problem is: to get from one location to the other takes 5 minutes,
    // so if there is an item, for example, available at time 23 and another
    // at time 27, it's just not possible for you to make it to both: you'll
    // have to choose!
    // Write a method that returns the maximum POINTS you can get.
    public static int scavHunt(int[] times, int[] points) {
    	int[] maxPoints= new int[times.length+1];
    	maxPoints[times.length]=0;
    	int goToI=0;
    	for(int i=maxPoints.length-2; i>=0;i--) {
    		goToI= points[i]+points[nextApptIndex(i, times)];
    		int notGoToI = maxPoints[i+1]; 
    		if(nextApptIndex(i, times)!=0) {
    			if(points[i]+ points[nextApptIndex(i, times)-1]> goToI) {
    				goToI= points[i]+ points[nextApptIndex(i, times)-1];
    			}
    		}
    		maxPoints[i]= Math.max(goToI, notGoToI);    		
    	}
    	return maxPoints[0];
	}
    
    public static int nextApptIndex(int currentAppt, int[] times) {
    	int index=0;
    	for(int i= currentAppt; i>0; i-- ) {
    		if(times[currentAppt]-times[i]>=5 ) {
    			index=i;
    		}
    	}
    	return index;
    }
    
    


	/* Uses memoization to calculate the route which grants the most cookies, 
	 * starting at [0][0], only going right or down at each point
	 *  */
    
	public static int dynamicCookies(int[][] cookieGrid) {
		int numRows=cookieGrid.length;
		int numCols= cookieGrid[0].length;
		
		
		int[][] numCookiesStartingFrom= new int[numRows][numCols];
		
		
		for(int r=numRows-1; r>=0 ;r--) { 
			for(int c=numCols-1; c>=0; c--) {
				if(r==numRows-1 && c == numCols-1) {
					numCookiesStartingFrom[r][c]= cookieGrid[r][c];
				}
				else if(cookieGrid[r][c]==-1) {
					numCookiesStartingFrom[r][c]=0;
				}
				else if(r== numRows-1) {
					numCookiesStartingFrom[r][c]= cookieGrid[r][c]+numCookiesStartingFrom[r][c+1];
				}
				else if(c== numCols-1) {
					numCookiesStartingFrom[r][c]= cookieGrid[r][c]+numCookiesStartingFrom[r+1][c];
				}
				else{
					if(numCookiesStartingFrom[r][c+1]>numCookiesStartingFrom[r+1][c]) {
						numCookiesStartingFrom[r][c]= cookieGrid[r][c]+numCookiesStartingFrom[r][c+1];
					}
					else {
						numCookiesStartingFrom[r][c]= cookieGrid[r][c]+numCookiesStartingFrom[r+1][c];
					}
					

				}
			}
			
		}

		return numCookiesStartingFrom[0][0];
	}




}
