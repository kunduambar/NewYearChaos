import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the minimumBribes function below.
    static void minimumBribes(int[] q) {
    	Map<Integer, Integer> currentPos = new HashMap<>();
    	int bribes = 0;
    	List<Integer> initalArr = new ArrayList<>();
    	for(int i =0; i < q.length; i++) {
    		//System.out.println(q[i]);
    		currentPos.put(q[i],i+1);
    		initalArr.add(i+1);
    	}
    	/*for(int i = 1; i <= q.length; i++) {
    		int pos = currentPos.get(i);
    		int change = i - pos;
    		if(change > 0) {
    			if( change > 2) {
        			System.out.println("Too Chaotic");
        			return;
        		}else if(change < 3){
        			bribes+= change;
        		}
    		}
    	}*/
    	
    	for(int i = 1; i <= q.length; i++) {
    		int pos = currentPos.get(i);
    		int localbribes = 0;
    		while(initalArr.get(pos) != i) {
    			int sendBack = initalArr.get(i - 1); 
    			initalArr.set(i - 1, initalArr.get(i));
    			initalArr.set(i, sendBack);
    			if(localbribes > 2) {
    				return;
    			}else {
    				localbribes++;
    			}
    		}
    		bribes = bribes + localbribes;
    		System.out.println("arrangement after bribes: "+ initalArr.toArray().toString());
    	}
    	System.out.println(bribes);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] q = new int[n];

            String[] qItems = scanner.nextLine().split(" ");
            //scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int qItem = Integer.parseInt(qItems[i]);
                q[i] = qItem;
            }

            minimumBribes(q);
        }

        scanner.close();
    }
}
