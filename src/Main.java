/********************
 * Program Name: Transposition Cipher
 * Author: Varun Gande
 * Date : April 26, 2022
 * Does: This program will allow you to encode transposition ciphers and decode them
 *	     
 ********************/

/********************
 * Class Name: Main
 * Author: Varun Gande
 * Description: The Main class holds the test cases 
 *	     
 ********************/
public class Main {

	public static void main(String[] args) {
		// Test Cases
		String[][] message = encryptTransposition("SECRET MESSAGE DON'T TELL ANYONE THIS IS TOP SECRET NO ONE CAN HEAR ABOUT THIS AND YOU CANT TELL ANYONE WHATS IN THIS");
		showArray(message);
		decryptTransposition(message);
		
		String[][] message4 = encryptTransposition("ONE OF THE EARLIEST KNOWN USES OF TRANSPOSITION CODES WAS DESIGNED BY THE SPARTANS");
		showArray(message4);
		decryptTransposition(message4);

	}
	
	/******************
	 * Function Name: showArray
	 * Description: Prints out a 2d array
	 * Input Parameters: String[][] arr
	 * Return Type: None
	 ******************/
	public static void showArray(String[][] arr) {
		for(int i=0; i < arr.length; i++) { 
			for(int j=0; j < arr.length; j++) {
				System.out.print(arr[i][j] + "\t");
			}
			System.out.println();
			System.out.println();
		}
	}
	
	/******************
	 * Function Name: encryptTransposition
	 * Description: Returns a 2d array with the encrypted message
	 * Input Parameters: String[][] message
	 * Return Type: String[][]
	 ******************/
	public static String[][] encryptTransposition(String message) {
		String[][] encryptedArr;
		int size = 0;
		int charIndex = 0;
		int k;
		
		// Finding minimum size required for the array to store the encrypted message
		while(size*size < message.length()) {
			size++;
		}
		encryptedArr = new String[size][size];
		
		
		try {
			// First Half
			for(int i=0; i < encryptedArr.length; i++) {
				
				// Position of the current row is the position of the current column
				for(int j=i; j >= 0; j--) {
					if(charIndex > message.length()-1) {
						encryptedArr[i-j][j] = "";
					}
					else {
						encryptedArr[i-j][j] = String.valueOf(message.charAt(charIndex));
					}
					
					charIndex++;
				}
			}

			// Second Half
			for(int i=1; i < encryptedArr.length; i++) {
				k = i; 
				
				// Position of the column stops at the position of the row in the associated diagonal
				for(int j=encryptedArr.length-1; j >= i; j--) {
					if(charIndex > message.length()-1) {
						encryptedArr[k][j] = "";
					}
					else {
						encryptedArr[k][j] = String.valueOf(message.charAt(charIndex));
					}
					
					charIndex++;
					k++;
				}
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return encryptedArr;
		
	}
	
	
	public static void decryptTransposition(String[][] arr) {
		String result = "";
		int k;
		try {
			for(int i=0; i < arr.length; i++) {
				
				for(int j=i; j >= 0; j--) {
					result += arr[i-j][j];
				}
			}
			
			for(int i=1; i < arr.length; i++) {
				k = i; 
				
				for(int j=arr.length-1; j >= i; j--) {
					result += arr[k][j];
					k++; 
				}
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
		System.out.println(result);
		System.out.println();
		System.out.println();
	}

}

