/* Kristina Saha
UNI ks3401
Programming Project 3 */

import java.util.NoSuchElementException;
import java.util.Scanner; 

public class ExpressionTree {

	private ExpressionNode root;
	private MyStack<ExpressionNode> nodes;

	public ExpressionTree(String postfix) {
		if (postfix == null) {
			throw new NullPointerException("Error Postfix is Null!");
		} else if (postfix.length() == 0) {
			throw new IllegalArgumentException("Error Postfix is Empty!");
		} else {
			this.newExpressionTree(postfix);
		}
	}

	private boolean isOperator(char c) {
		return c == '+' || c == '-' || c == '*' || c == '/';
	}

	/**
	 * helper method for constructor
	 */
	private void newExpressionTree(String postfix) {
		nodes = new MyStack<ExpressionNode>();
		String tempString = "";
		while(!postfix.equals(""))
		{
			String ch;
			int wordEnd = postfix.indexOf(" ");
			if(wordEnd!=-1)
				ch = postfix.substring(0,wordEnd);
			else
				ch = postfix.substring(0,postfix.length());
			if (isOperator(ch.charAt(0))) {
				ExpressionNode rightNode = nodes.pop();
				ExpressionNode leftNode = nodes.pop();
				nodes.push(new ExpressionNode(leftNode, ch, rightNode));
			} else // int
			{
				nodes.push(new ExpressionNode(null, ch, null));
			}
			if(wordEnd!=-1)
				postfix = postfix.substring(wordEnd +1, postfix.length());
			else
				postfix = "";
		}
		root = nodes.pop();
	}

	public int eval() {
		if (root == null) {
			throw new NoSuchElementException("Root is empty. Tree is not yet constructed.");
		} else {
			return eval(root);
		}
	}

	private int eval(ExpressionNode ptr) {
		if (ptr.leftChild == null && ptr.rightChild == null) {
			return Integer.parseInt(ptr.ch);
		} else {
			int result = 0;
			int left = Integer.parseInt(ptr.leftChild.ch);
			int right = Integer.parseInt(ptr.rightChild.ch);
			String operator = ptr.ch;

			switch (operator) {
			case "+":
				result = left + right;
				break;
			case "-":
				result = left - right;
				break;
			case "*":
				result = left * right;
				break;
			case "/":
				result = left / right;
				break;
			default:
				result = left + right;
				break;
			}
			return result;
		}
	}
//*********
	public String postfix() {
		if (root == null) {
			throw new NoSuchElementException("The root is empty, the tree has not yet been constructed.");
		}
		
		return postOrder(root);
	}

	private String postOrder(ExpressionNode node) {
		 if (node != null) 
		 {
			 return ""+ postOrder(node.leftChild) + " " + postOrder(node.rightChild) + " " + node.ch; 
         }
		 else
			 return "";
	}
//************************
	public String prefix() {
		if (root == null) {
			throw new NoSuchElementException("The root is empty, the tree has not yet been constructed.");
		}

		return preOrder(root);
	}

	private String preOrder(ExpressionNode node) {
		  if (node != null) 
		  {
	            return ""+ node.ch + " " + preOrder(node.leftChild) + " " + preOrder(node.rightChild);
	       }
		  else
			  return "";	
	}


//********************
	public String infix() {
		if (root == null) {
			throw new NoSuchElementException("The root is empty, the tree has not yet been constructed.");
		}
		return inOrder(root);
	}

	private String inOrder(ExpressionNode node) {
		if (node != null) {
			 return ""+ "(" + " " + inOrder(node.leftChild) + " " + node.ch + " " + inOrder(node.rightChild) + " " + ")";
        }	
		else
			return "";
	}


	private class ExpressionNode {
		ExpressionNode leftChild;
		String ch;
		int val = -1;
		ExpressionNode rightChild;
		boolean isOperator;

		ExpressionNode(ExpressionNode left, String ch, ExpressionNode right) {
			this.ch = ch;
			leftChild = left;
			rightChild = right;
			try {
				val = Integer.parseInt(ch); // "x"
				isOperator = false;
			} catch (NumberFormatException x) {
				isOperator = true;
			}
		}

	}

}