
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
* This class check the parentheses are matched or do not matched
* @author Nur Imece
* @version 1.0
* @since 2019-21-11
*/

public class nur_imece {
/**
 * This main method of the application
 * @param args array of string arguments
 * @throws FileNotFoundException indicates that an attempt to open the specified file failed.
 */

	public static void main(String[] args) throws FileNotFoundException {
		
/**
 * create the stack1 from myStack class
 */
		myStack <Character> stack1 = new myStack();
/**
 * read the file from location, use the scanner line by line while has next element is not equal to zero
 */
		File fr = new File("C:/Users/Nur/eclipse-workspace/Ödev/src/Check.java");
		Scanner scanner = new Scanner(fr);
			String s = null;
			//            StringBuilder sb = new StringBuilder();
			while (scanner.hasNext()) {
				//                sb.append(scanner.nextLine()).append("\n");
				s+=scanner.nextLine();

			}
	
			for(int i = 0; i< s.length(); i++) {
/**
 *isEmpty is true for stack1 push the '(','{',')','}'
 */
				if( stack1.isEmpty()) {
					if(s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == ')' || s.charAt(i) == '}') {
						stack1.push(s.charAt(i));
						for(Character x: stack1) {
							System.out.print(x+" ");
						}
						System.out.println(" ");
					}
					
				}
/**
 * isEmpty is false for stack1, check the stack of the top element with the peek.
 * if parentheses matched pop the top the stack element, is not push. 
 */
				else {
		
				if(s.charAt(i) == '(' || s.charAt(i) == '{') {
					
					stack1.push(s.charAt(i));
					for(Character x: stack1) {
						System.out.print(x+" ");
					}
					System.out.println(" ");
				}
	           else if((s.charAt(i) == ')' && stack1.peek() == '(') || (s.charAt(i) == '}' && stack1.peek() == '{')) {
					
					stack1.pop();

				
				}
				else if ((s.charAt(i) == ')' && stack1.peek() != '(') || (s.charAt(i) == '}' && stack1.peek() != '{')){
					
					stack1.push(s.charAt(i));
				}
			
				
			
			}
			}
/**
 * After the loop, if stack has element,its main that parentheses do not matched print the "Parentheses do not match"
 * if the stack is empty print the "Parentheses are correct"
 */
			
			if(stack1.isEmpty()) {
				System.out.println("Parentheses are correct");
			}else {
				System.out.println("Parentheses do not match");
			}
		}
	
}