/**
 * 
 */
package behaviour.observer;

/**
 * @author vivekku7
 *
 */
public interface Subject {
	
	void registerObserver(Observer obj);
	
	void removeObserver(Observer obj);
	
	void notifyAllObserver(float interest);
	

}
