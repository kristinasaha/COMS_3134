//Kristina Saha UNI ks3401//
// Data Structures , Programming Problem 1//

import java.util.LinkedList;
public class MyStack<AnyType> {
	
	private LinkedList<AnyType> list = new LinkedList<AnyType>(); // new linkedlist

public AnyType pop() {
	return list.remove(list.size()-1); // explains the method for pop. it will remove the last in the list
}

public AnyType peek(){
	return list.getFirst(); // explains the method for peek. it will return  the first in the list
}

public void push(AnyType a){
	list.add(a);     // explains the method for push. it will add a value to the list
}

public boolean isEmpty(){
	return list.isEmpty();  //checks too see if the list is empty
}

public int size() {
	return list.size(); // gets the size of the list
}

}


