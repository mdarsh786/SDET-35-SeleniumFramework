package Genric_Utility;

import java.util.Random;
import java.util.stream.IntStream;

public class Java_Utility {
	
	public int getRandom() {
		
		/**
		 * @author Arshad
		 * It used for generate the random number
		 */
		Random random = new Random();
		int ran = random.nextInt(100);
		return ran;
		
	}

}
