/**
 * Name: Stack (Interface)
 *
 * Version: 1.0
 *
 */

import java.util.Iterator;
interface Stack<E>{
	public boolean push(E x);
	public boolean pop();
	public E top();
	public boolean empty();
	public boolean full();
	public Iterator<E> iterator();
}