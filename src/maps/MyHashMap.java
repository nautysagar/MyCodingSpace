package maps;

import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class MyHashMap<K,V> implements Map<K,V>,Cloneable, Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2856940407941810512L;

	int size = 0;
	
	static final int DEFAULT_INTIAL_CAPACITY = 1 << 4;

	static final int MAXIMUM_CAPACITY = 1 << 30;
	 
	static final float DEFAULT_LOAD_FACTOR = 0.75f;
	
	static final Entry<?,?>[] EMPTY_TABLE = {};
	
	transient Entry<K,V>[] table = (Entry<K,V>[]) EMPTY_TABLE;
	
	final float loadFactor;
	
	int threshold;
	
	int modCount;
	
	public MyHashMap() {
		this(DEFAULT_INTIAL_CAPACITY,DEFAULT_LOAD_FACTOR);
	}
	
	public MyHashMap(int intialcapacity){
		this(intialcapacity,DEFAULT_LOAD_FACTOR);
	}
	
	public MyHashMap(int initialCapacity,float loadFactor){
		 if (initialCapacity < 0)
	            throw new IllegalArgumentException("Illegal initial capacity: " +
	                                               initialCapacity);
	        if (initialCapacity > MAXIMUM_CAPACITY)
	            initialCapacity = MAXIMUM_CAPACITY;
	        if (loadFactor <= 0 || Float.isNaN(loadFactor))
	            throw new IllegalArgumentException("Illegal load factor: " +
	                                               loadFactor);

	        this.loadFactor = loadFactor;
	        threshold = initialCapacity;
		
		
	}
	
	static class Entry<K,V> implements Map.Entry<K,V>{
		final K key;
		V value;
		int hash;
		Entry<K,V> next;
		 
		 Entry(int h, K k,V v,Entry<K,V> n){
			value = v;
            next = n;
            key = k;
            hash = h;
		 }
		 
		@Override
		public K getKey() {
			// TODO Auto-generated method stub
			return key;
		}

		@Override
		public V getValue() {
			// TODO Auto-generated method stub
			return value;
		}

		@Override
		public V setValue(V newvalue) {
			V oldvalue = value;
			value = newvalue;
			return oldvalue;
			
		}
		
		
		public final int hashCode(){
			 return Objects.hashCode(getKey()) ^ Objects.hashCode(getValue());
		}
		
		public boolean equals(Object o){
			 if (!(o instanceof Map.Entry))
	                return false;
	            Map.Entry e = (Map.Entry)o;
	            Object k1 = getKey();
	            Object k2 = e.getKey();
	            if (k1 == k2 || (k1 != null && k1.equals(k2))) {
	                Object v1 = getValue();
	                Object v2 = e.getValue();
	                if (v1 == v2 || (v1 != null && v1.equals(v2)))
	                    return true;
	            }
	            return false;
			
		}
		 
		public final String toString(){
			 return getKey() + "=" + getValue();
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
	public boolean containsKey(Object key) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsValue(Object value) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public V get(Object key) {
		// TODO Auto-generated method stub
		if(key == null) 
			return getForNullKey();
		
		Entry<K, V> entry = getEntry(key);
		
		return null == entry? null:entry.value;
	}

	
	/* Steps......
	 * 1. check if map is empty
	 * 2. if empty Intiliaze it 
	 * 3. calculate hashcode for key
	 * 4. get the bucket location
	 * 5. iterate if key is present
	 * 6. if present replace the value
	 * 7. Add the entry*/
	
	@Override
	public V put(K key, V value) {
		if(table == EMPTY_TABLE){
			 inflateTable(threshold);
		}
		if(key == null){
			return putforNullkey(value);
		}
		
		int hash = hash(key);
		int i = indexFor(hash, table.length);
		for(Entry<K, V> e = table[i];e != null;e=e.next) {
			Object k;
            if (e.hash == hash && ((k = e.key) == key || key.equals(k))) {
            	V oldvalue = e.getValue();
            	e.value = value;
            	
            	return oldvalue;
            }
		}
		
		addEntry(hash, key, value, i);
		modCount++;
		return null;
	}

	@Override
	public V remove(Object key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void putAll(Map<? extends K, ? extends V> m) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Set<K> keySet() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<V> values() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<java.util.Map.Entry<K, V>> entrySet() {
		// TODO Auto-generated method stub
		return null;
	}
	
	void inflateTable(int toSize) {
		int capacity = roundUpToPowerOf2(toSize);

        threshold = (int) Math.min(capacity * loadFactor, MAXIMUM_CAPACITY + 1);
        table = new Entry[capacity];
	 }
	
	private static int roundUpToPowerOf2(int number) {
        // assert number >= 0 : "number must be non-negative";
        return number >= MAXIMUM_CAPACITY
                ? MAXIMUM_CAPACITY
                : (number > 1) ? Integer.highestOneBit((number - 1) << 1) : 1;
    
	}
	
	private V putforNullkey(V value){
		for (Entry<K,V> e = table[0]; e != null; e = e.next) {
            if (e.key == null) {
                V oldValue = e.value;
                e.value = value;
             //   e.recordAccess(this);
                return oldValue;
            }
        }
        modCount++;
        addEntry(0, null, value, 0);
        return null;
	}
	
	private void addEntry(int hash,K key,V value,int bucketIndex){
		 if ((size >= threshold) && (null != table[bucketIndex])) {
	            resize(2 * table.length);
	            hash = (null != key) ? hash(key) : 0;
	            bucketIndex = indexFor(hash, table.length);
	        }

	        createEntry(hash, key, value, bucketIndex);
	}
	
	void createEntry(int hash, K key, V value, int bucketIndex) {
        Entry<K,V> e = table[bucketIndex];
        table[bucketIndex] = new Entry<>(hash, key, value, e);
        size++;
    }
	
	void resize(int newCapacity) {
        Entry[] oldTable = table;
        int oldCapacity = oldTable.length;
        if (oldCapacity == MAXIMUM_CAPACITY) {
            threshold = Integer.MAX_VALUE;
            return;
        }

        Entry[] newTable = new Entry[newCapacity];
        transfer(newTable, initHashSeedAsNeeded(newCapacity));
        table = newTable;
        threshold = (int)Math.min(newCapacity * loadFactor, MAXIMUM_CAPACITY + 1);
    }
	
	static int indexFor(int hash,int length){
		
		return hash & (length-1);
	}
	
	static int hash(Object k){
		int h = 0;
		
		h ^= k.hashCode();

        // This function ensures that hashCodes that differ only by
        // constant multiples at each bit position have a bounded
        // number of collisions (approximately 8 at default load factor).
        h ^= (h >>> 20) ^ (h >>> 12);
        return h ^ (h >>> 7) ^ (h >>> 4);
		
		
	}
	
	transient int hashSeed = 0;
	final boolean initHashSeedAsNeeded(int capacity) {
//        boolean currentAltHashing = hashSeed != 0;
//        boolean useAltHashing = sun.misc.VM.isBooted() &&
//                (capacity >= Holder.ALTERNATIVE_HASHING_THRESHOLD);
//        boolean switching = currentAltHashing ^ useAltHashing;
//        if (switching) {
//            hashSeed = useAltHashing
//                ? sun.misc.Hashing.randomHashSeed(this)
//                : 0;
//        }
        return true;
    }
	
	void transfer(Entry[] newTable, boolean rehash) {
        int newCapacity = newTable.length;
        for (Entry<K,V> e : table) {
            while(null != e) {
                Entry<K,V> next = e.next;
                if (rehash) {
                    e.hash = null == e.key ? 0 : hash(e.key);
                }
                int i = indexFor(e.hash, newCapacity);
                e.next = newTable[i];
                newTable[i] = e;
                e = next;
            }
        }
    }
	
	
	private V getForNullKey(){
		
		if(size == 0) return null;
		
		for(Entry<K, V> e = table[0];e!=null;e=e.next){
			if (e.key == null)
                return e.value;
        }
        return null;
	}
	
	final Entry<K, V> getEntry(Object key){
		
		if (size == 0) return null;
		int hash = (key == null) ? 0:hash(key);
		for(Entry<K, V> kk = table[indexFor(hash, table.length)];kk !=null;kk = kk.next){
			if(kk.hash == hash && (key == kk.key || (key != null && key.equals(kk.key)))) {
				return kk;
			}
		}
		
		return null;
	}
	
	
	
	
}
