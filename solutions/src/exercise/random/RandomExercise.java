package exercise.random;

import java.util.ArrayList;
import java.util.Random;

public class RandomExercise {

	public static void main(String[] args) {
		randomNumber(4);
	}
	
	private static void randomNumber(int n){
        ArrayList<Integer> list = new ArrayList<Integer>(n);
        for(int i = 1; i <= n; i++) {
            list.add(i);
        }
        
        int half = 0;
        
        Random random = new Random();
        while(list.size() > 0) {
        	half++;
            int index = random.nextInt(list.size());            
            System.out.println(list.remove(index));
            if(half == n/2)
            	System.out.println("============");
           
        }
	}
	
	

}
