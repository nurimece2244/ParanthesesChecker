import java.util.Iterator;
import java.util.NoSuchElementException;
/**
 * The class create the stack which represents a last-in-first-out (LIFO) stack of objects
 *  and uses a array and interface iterator.
 * @author Nur Imece
 * @version 1.0
 * @since 2019-21-11
 * @param <Item> repetitive actions by scanning all items.
 */

public class myStack<Item> implements Iterable<Item> {
	/**
	 * a is array of items
	 * n is number of the elements on stack
	 */
	private Item[] a; // array of items
	private int n; // number of elements on stack
	
    /**
    * myStack class constructor
    */
	public myStack() {
	a = (Item[]) new Object[2];
	n = 0;
	}
	
	/**
	 * This method check the stack is empty or not
	 *@return returning (boolean value) true if the size of n = 0
	 */
	
	public boolean isEmpty() { return n == 0; }
	/**
	 * This method gives the size
	 * @return returning integer value result from n
	 */
	public int size() { return n; }
	/**
	 * The method allows you to change the array size which means that there is no fixed array size.
	 * After the create new array capacity,take the value from old array and continue to new value
	 * @param capacity is the hold the arrays element number,size
	 * 
	 */
	private void resize(int capacity) {
	assert capacity >= n;
	Item[] temp = (Item[]) new Object[capacity];
	for (int i = 0; i < n; i++) {
	temp[i] = a[i];
	}
	a = temp;
	}
	/**
	 * This method if the array is not full add the item to stack but if it is, make the array size double.
	 * @param item is the object for push the stack
	 * 
	 */
	
	public void push(Item item) {
	if (n == a.length) {
	resize(2 * a.length); // double size of array if necessary
	System.out.print("\n\n << stack doubled >> \n\n");
	}
	a[n++] = item; // add item
	}
	/**
	 * This method if isEmpty false avoid the item from stack and decreasing size
	 * but it is true show the warning message
	 * If n equals to a array size/4 reducing size to quarter
	 * @return returning item which remove from stack
	 */
	
	public Item pop() {
	if (isEmpty())
	throw new NoSuchElementException("Stack underflow");
	Item item = a[n - 1];
	a[n - 1] = null; // to avoid loitering
	n--;
	// shrink size of array if necessary
	if (n > 0 && n == a.length / 4)
	resize(a.length / 2);
	return item;
	}
	
	/**
	 * This method gives the top of element without removing 
	 * @return returning the top of element
	 */
	public Item peek() {
	if (isEmpty())
	throw new NoSuchElementException("Stack underflow");
	return a[n - 1];
	}
	/**
	 * Returns an iterator over elements of type T.
	 * @return new ReverseArrayIterator() is a class for reverse the array of items
	 */
	public Iterator<Item> iterator() {
	return new ReverseArrayIterator();
	}
	/**
	 * 
	 * @author Nur
	 *
	 */

	private class ReverseArrayIterator implements Iterator<Item> {

	private int i;
    /**
    * Constructor ReverseArrayIterator's class 
    * make the n size of minus one.
    */
	public ReverseArrayIterator() { i = n - 1; }
	/**
	 * Returns true if there are still items.
	 */
	public boolean hasNext() { return i >= 0; }
	/**
	 * Deletes the last item given by the iterator  when requested.
	 */
	public void remove() { throw new UnsupportedOperationException(); }
	/**
	 * Returns the next item if there is still item.
	 */

	public Item next() {
	if (!hasNext())
	throw new NoSuchElementException();
	return a[i--];
	}
	}
	
	
	}