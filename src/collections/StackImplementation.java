package collections;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class StackImplementation<E> implements Serializable,Cloneable,Iterable<E> {
	
	protected int elementCount = 0;
	
	protected Object[] elementdata;
	
	protected int capacityIncrement;
	
	protected transient int modCount = 0;
	
	
	
	public StackImplementation(int intialcapacity, int capacityIncrement){
		if(intialcapacity < 0)
		throw new IllegalArgumentException("Illegal Capacity " + intialcapacity);
		
		this.capacityIncrement = capacityIncrement;
		this.elementdata = new Object[intialcapacity];
		
		
	}
	
	public StackImplementation(int intialcapacity){
		this(intialcapacity,0);
	}
	
	public StackImplementation(){
		this(10);
	}
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	public int size() {
		// TODO Auto-generated method stub
		 return elementCount;
	}

	


	
	public synchronized E push(E item) {
		addElement(item);
		return item;
		
	}
	
	public synchronized E pop() {
		
		E obj = peek();
		removeAt(size() -1);
		
		return obj;
	}
	
	@SuppressWarnings("unchecked")
	public synchronized E peek() {
		int len = size();
		
		if(len < 1) throw new EmptyStackException();
		
		return (E) elementdata[len-1];
		
	}
	
	
	private void addElement(E item){
		modCount++;
		ensurecapacity(elementCount + 1);
		elementdata[elementCount++] = item;
	}
	
	private void ensurecapacity(int mincapacity) {
		
		if(mincapacity - elementdata.length -1 > 0){
			grow(mincapacity);
		}
		
	}
	
	private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;
	private void grow(int mincapacity){
		
		int oldcapacity = elementdata.length-1;
		int newcapacity = oldcapacity + ((capacityIncrement > 0)?capacityIncrement:oldcapacity);
		if(newcapacity - mincapacity < 0) {
			newcapacity = mincapacity;
		} else if(newcapacity - MAX_ARRAY_SIZE > 0){
			newcapacity = MAX_ARRAY_SIZE;
		}
		
		elementdata = Arrays.copyOf(elementdata, newcapacity);
	}
	
	
	private void removeAt(int index){
		
		if(index < 0 ) throw new ArrayIndexOutOfBoundsException();
		modCount++;
		elementCount--;
		elementdata[elementCount] = null;
		
	}

	

	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return new itr();
	}
	
	
	class itr implements Iterator<E> {

		private int cursor;
		private int lastRet = -1;
		private int expectedcount = modCount;
		
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return cursor != elementCount;
		}

		@SuppressWarnings("unchecked")
		@Override
		public E next() {
			// TODO Auto-generated method stub
			checkformodification();
			int i = cursor;
			if (i >= elementCount)
                throw new NoSuchElementException();
			
			cursor = i+1;
			return (E) elementdata[lastRet=i];
		}

		@Override
		public void remove() {
			// TODO Auto-generated method stub
			checkformodification();
			StackImplementation.this.removeAt(lastRet);
			 expectedcount = modCount;
			
		}
		
		private void checkformodification(){
			if(expectedcount != modCount){
				throw new ConcurrentModificationException();
			}
		}
		
	}

}
