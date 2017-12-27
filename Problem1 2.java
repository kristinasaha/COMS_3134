/* Kristina Saha
UNI ks3401
Programming Project 3 */

public class Problem1 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExpressionTree tree = new ExpressionTree("34 2 - 5 *");
		System.out.println("Tree:");
		System.out.println("Postfix: " + tree.postfix());
		System.out.println("Prefix: " + tree.prefix());
		System.out.println("Infix: " + tree.infix());
		System.out.println("Eval: " + tree.eval());
		
		ExpressionTree Tree1 = new ExpressionTree("3 2 + 5 /");
		System.out.println("Tree1:");
		System.out.println("Postfix: " + Tree1.postfix());
		System.out.println("Prefix: " + Tree1.prefix());
		System.out.println("Infix: " + Tree1.infix());
		System.out.println("Eval: " + Tree1.eval());
		
		ExpressionTree Tree2 = new ExpressionTree("3 2 + 5 / 10 +");
		System.out.println("Tree2:");
		System.out.println("Postfix: " + Tree2.postfix());
		System.out.println("Prefix: " + Tree2.prefix());
		System.out.println("Infix: " + Tree2.infix());
		System.out.println("Eval: " + Tree2.eval());
	}

	}