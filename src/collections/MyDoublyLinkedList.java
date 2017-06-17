package collections;


import java.util.Collection;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class MyDoublyLinkedList<E> implements List<E>, Deque<E>, Cloneable, java.io.Serializable{
	
	
	/**
	 * 
	 */
	 private static final long serialVersionUID = 876323262645176354L;

	transient int size = 0;
	
	transient int modCount = 0;
	
	Node<E> first;
	
	transient Node<E> last;
	
	public MyDoublyLinkedList(){}
	
	public MyDoublyLinkedList(Collection<? extends E> c){
		this();
		addAll(c);
	}
	
	static class Node<E> {
		E value;
		Node<E> right;
		Node<E> left;
		
		Node(Node<E> prev, Node<E> next, E item){
			this.value = item;
			this.right = next;
			this.left = prev;
		}
	}



	@Override
	public int size() {
		return size;
	}



	@Override
	public boolean isEmpty() {
		return size == 0;
	}



	@Override
	public boolean contains(Object o) {
		return indexOf(o) != 0;
	
	}



	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] toArray() {
		Object[] kk = new Object[size];
		int i = 0;
		for(Node<E> k = first;k != null;k = k.right){
			kk[i++] = k.value;
		}
		return kk;
	}

	@Override
	public boolean remove(Object o) {
		    int index = indexOf(o);
		    if (index == -1) return false;
			Node<E> kk = findNode(index);
			unlink(kk);
			
		return true;
	}


	@Override
	public boolean addAll(int index, Collection<? extends E> c) {
		checkPositionIndex(index);
		Object[] k = c.toArray();
		if(k.length == 0) return false;
		
		Node<E> prev,next;
		if(size == index){
			next = null;
			prev = last;
		} else {
			next = findNode(index);
			prev = next.left;
		}
		
		
		for(Object o : k){
			@SuppressWarnings("unchecked")
			E r = (E) o;
			Node<E> newNode = new Node<E>(prev,null,r);
			
			if(prev == null) {
				first = newNode;
			} else {
				prev.right = newNode;
			}
			prev = newNode;
		}	
			
		if(next == null){
			last = prev;
		} else {
			next.left = prev;
			prev.right = next;
			
		}
		
		size += k.length;
        modCount++;
		return true;
	}


	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public E get(int index) {
		checkPositionIndex(index);
		return findNode(index).value;
	}

	@Override
	public E set(int index, E element) {
		checkPositionIndex(index);
		E vv = findNode(index).value;
		findNode(index).value = element;
		return vv;
	}



	@Override
	public void add(int index, E element) {
		checkPositionIndex(index);
		if(index == size){
			linkLast(element);
		} else {
			linkbefore(element,findNode(index));
		}
		
		
	}



	@Override
	public E remove(int index) {
		checkPositionIndex(index);
		return unlink(findNode(index));
	}



	@Override
	public int indexOf(Object o) {
		// TODO Auto-generated method stub
		int index = 0;
		
		if(o == null){
			for(Node<E> k = first;k != null;k = k.right){
				if(k.value == o) 
					return index;
				index++;
			}
		} else {
			for(Node<E> k = first;k != null;k = k.right){
				if(o.equals(k.value)) 
					return index;
				index++;
			}
		}
		
		return -1;
	}



	@Override
	public int lastIndexOf(Object o) {
		int index = size;
		
		if(o == null){
			for(Node<E> k = last;k != null;k = k.left){
				if(k.value == o) 
					return index;
				index++;
			}
		} else {
			for(Node<E> k = last;k != null;k = k.left){
				if(o.equals(k.value)) 
					return index;
				index++;
			}
		}
		
		return -1;
	}



	@Override
	public ListIterator<E> listIterator() {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public ListIterator<E> listIterator(int index) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public List<E> subList(int fromIndex, int toIndex) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

	@Override
	public boolean addAll(Collection<? extends E> c) {
		// TODO Auto-generated method stub
		return addAll(size,c);
		
	}

	

	@Override
	public void addFirst(E e) {
		linkfirst(e);
		
	}

	@Override
	public void addLast(E e) {
		linkLast(e);
	}

	@Override
	public boolean offerFirst(E e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean offerLast(E e) {
		// TODO Auto-generated method stub
		return false;
	}

	

	@Override
	public boolean removeFirstOccurrence(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeLastOccurrence(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean add(E e) {
		// TODO Auto-generated method stub
		linkLast(e);
		return true;
	}

	@Override
	public boolean offer(E e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public E removeFirst() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E removeLast() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E pollFirst() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E pollLast() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E getFirst() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E getLast() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E peekFirst() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E peekLast() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E remove() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E poll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E element() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E peek() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void push(E e) {
		addFirst(e);
		
	}

	@Override
	public E pop() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<E> descendingIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T[] toArray(T[] a) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	
    void linkfirst(E e){
	   
	   Node<E> f = first;
	   Node<E> newNode = new Node<E>(null,f,e);
	   first = newNode;
	   
	   if(f == null) {
	   last = newNode;
	   } else {
		   f.left = first;
	   }
	   size++;
	   modCount++;
   }
	
	

	void linkLast(E e){
		final Node<E> l = last;
		final Node<E> nn = new Node<E>(l,null,e);
		last = nn;
		if(l != null){
		    l.right = nn;	
		} else {
			first = nn;
		}
		
		size++;
		modCount++;
	}
	
	void linkbefore(E e, Node<E> n){
		Node<E> prev = n.left;
		Node<E> newNode = new Node<E>(prev,n,e);
		n.left = newNode;
		if(prev != null) prev.right = newNode;
		else first = newNode;
		
		size++;
		modCount++;
		
		
	}
	
	E unlink(Node<E> kk){
		E item = kk.value;
		if(kk.left == null){
			first = kk.right;
		} else {
			kk.left.right = kk.right;
			kk.right.left = kk.left;
		}
		
		if(kk.right == null) {
			last = kk.left;
		} else {
			kk.right.left = kk.left;
			kk.left.right = kk.right;
		}
		
	size--;	
	modCount++;
	return item;
	
	}
	

	 private void checkPositionIndex(int index) {
	        if (!isPositionIndex(index))
	            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
	    }
	 
	 private boolean isPositionIndex(int index){
		 return index>=0 && index < size;
	 }
	
	 private String outOfBoundsMsg(int index) {
	        return "Index: "+index+", Size: "+size;
	    }
	 
	 Node<E> findNode(int index) {
		 if(index < (size >> 1)){
			 Node<E> x = first;
			 for(int i =0; i< index; i++)
				 x = x.right;
				 return x;
			 } else {
			 Node<E> x = last;
			 for(int i =size-1;i> index; i--)
				 x = x.left;
			 return x;
			 
			 }	 
		 
	 }

}
