import java.util.*;
public class LinkedList<T> {
	
	private int size = 0;
	//Starting of the node
	private Node<T> head = null;
	//Ending of the node
	private Node<T> tail = null;
	
	//Internal node class to represent data
	private static class Node<T>{
			private T data;
			//It creates an internal node
			//Necessary
			private Node<T> prev, next;
			
			//Node constructor
			//when we create new constructor, we initialize
			public Node(T data, Node<T> prev,Node<T> next){
				this.data = data;
				this.prev = prev;
				this.next = next;
			}
	}
	
	public void displayList(){
		if(!isEmpty()){
			Node<T> trav = head;
			System.out.println("Displaying the list");
			while(trav!=null){
				System.out.print(trav.data+" ");
				trav = trav.next;
			}
			System.out.println();
		}
		
	}
	
	//Empty this linked list, O(n)
	public void clear() {
		//Store the memory of the head to traverse along
		//It does not change the head value
		Node<T> trav = head;
		
		while(trav!=null){
			//Storee the next memory and erase everything
			Node<T> next = trav.next;
			trav.prev = trav.next = null;
			trav.data = null;
			trav = next;
		}
		head = tail = trav = null;
		size = 0;
	}
	
	//Return the size of this linked list
	public int size(){
		return size;
	}
	
	//Return if the list is empty
	public boolean isEmpty(){
		return size() ==0;
	}
	
	//Add an element to the tail of the linked list, 0(1)
	public void add(T elem){
		addLast(elem);
	}
	
	public void addLast(T elem){
		System.out.println("Inserting "+elem+" at last");
		//if it is the first insertion or at the first
		if(isEmpty()){
			head = tail = new Node<T>(elem,null,null);
		}else{
			//insert at the tail of the node
			tail.next = new Node<T>(elem,tail,null);
			tail = tail.next;
		}
		size++;
	}
	
	//add at the beginning, 0(1)
	public void addFirst(T elem){
		System.out.println("Inserting "+elem+" at first");
		if(isEmpty()){
			head = tail = new Node<T>(elem,null,null);
		}else{
			head.prev = new Node<T>(elem,null,head);
			head = head.prev;
		}
		size++;
	}
	
	public T removeFirst(){
		if(isEmpty()) throw new RuntimeException("Emtpy list");
		
		System.out.println("Removing at first");
		//store the data to return
		T data = head.data;
		head = head.next;
		--size;
		
		//if the list is empty, set the tail to null
		if(isEmpty())  tail = null;
		//Do a memory cleanup of the previous node
		else head.prev = null;
		
		return data;
		
		
	}
	
	public T removeLast(){
		if(isEmpty()) throw new RuntimeException("Emtpy list");
		
		System.out.println("Removing at last");
		T data = tail.data;
		tail = tail.prev;
		--size;
		
		//if the list is empty,set the head to null
		if(isEmpty())  head = null;
		//Do a memory clean of the node that was just removed
		else tail.next = null;
		
		return data;
		
	}
	public int indexOf(Object obj){
		int index = 0;
		Node<T> trav = head;
		
		if(obj==null){
			while(trav!=null){
				
				if(trav.data ==null){
					return index;
				}
				index++;
				trav = trav.next;
			}
		}else{
			while(trav!=null){
				if(obj.equals(trav.data)){
					return index;
				}
				index++;
				trav = trav.next;
			}
		}
		return -1;
	}
	
	//check if the value is contained whithin the linked list
	public boolean contains(Object obj){
		return indexOf(obj) !=-1;
	}
	public static void main(String[] args){
		
		LinkedList<Integer> list = new LinkedList<Integer>();
		
		list.addFirst(23);
		list.displayList();
		list.addLast(4);
		list.displayList();
		list.addLast(9);
		list.displayList();
		list.addFirst(10);
		list.displayList();
		list.removeFirst();
		list.displayList();
		list.removeLast();
		list.displayList();
		
	}
}
