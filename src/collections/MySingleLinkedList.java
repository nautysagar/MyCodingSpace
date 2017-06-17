package collections;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import collections.MySingleLinkedList.Entry;

public class MySingleLinkedList<E> implements List<E>{

	int size = 0;
	int modCount = 0;

	Entry<E> first;

	Entry<E> last;

	static class Entry<E>{
		E value;
		Entry<E> next;

		Entry(E v, Entry<E> ne){
			this.value = v;
			this.next = ne;
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
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T[] toArray(T[] a) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean add(E e) {
		linklast(e);
		return true;
	}

	@Override
	public boolean remove(Object o) {
		// TODO Auto-generated method stub
		int index = indexOf(o);
		if (index < 0) return false;
		Entry<E> n = findNode(index);
		unlink(n);
		return true;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(Collection<? extends E> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(int index, Collection<? extends E> c) {
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

	@Override
	public void clear() {
		// TODO Auto-generated method stub

	}

	@Override
	public E get(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E set(int index, E element) {
		checkPositionIndex(index);
		Entry<E> k = findNode(index);
		E old = k.value;
		k.value = element;
		return old;
	}

	@Override
	public void add(int index, E element) {
		checkPositionIndex(index);
		Entry<E> prev = null;
		Entry<E> temp = first;
		Entry<E> node = findNode(index);
		for(int i =0;i<index;i++){
			prev = temp;
			temp = temp.next;
		}
		
		

	}

	@Override
	public E remove(int index) {
		checkPositionIndex(index);
		Entry<E> n = findNode(index);
		return unlink(n);
	}

	@Override
	public int indexOf(Object o) {
		int index = 0;

		if(o == null){
			for(Entry<E> k = first;k != null;k = k.next){
				if(o == k.value) return index;
				index++;
			}
		} else {
			for(Entry<E> k = first;k != null;k = k.next){
				if(o.equals(k.value)) return index;
				index++;
			}
		}


		return -1;
	}

	@Override
	public int lastIndexOf(Object o) {
		int index = 0;

		if(o == null){
			while(first != null) {
				if(o == first.value) index++;
				first = first.next;
			}

		} else {
			while(first != null) {
				if(o.equals(first.value)) index++;
				first = first.next;
			}
		}

		if(index > -1) return index;
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


	void linklast(E e){
		Entry<E> temp = last;
		Entry<E> newNode = new Entry<E>(e,null);
		last = newNode;
		if(temp == null) {
			first = newNode;
		} else {
			temp.next = newNode;
		}

		size++;
		modCount++;

	}
	
	Entry<E> findNode(int index){
			Entry<E> t = first;
			for(int i=0;i<index;i++)
				t = t.next;
			    return t;
		} 
	
	E unlink(Entry<E> node){
		E temp = node.value;
		
		if(node.next == null){
			node = null;
		} else {
			node.value = node.next.value;
			node.next = node.next.next;
		}
		
		return temp;
	}

	private void checkPositionIndex(int index) {
		if (!isPositionIndex(index))
			throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
	}

	private boolean isPositionIndex(int index){
		return index>=0 && index <= size;
	}

	private String outOfBoundsMsg(int index) {
		return "Index: "+index+", Size: "+size;
	}



}
