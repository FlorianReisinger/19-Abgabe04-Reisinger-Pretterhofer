package at.fhj.iit;

/**
 * Interface for a queue class.
 * A queue is similar to an Stack, but the difference is,
 * that a queue works with FIFO-Principle and the stack with
 * LIFO-Principle.
 * When you add a element, it will be placed at the end of
 * the queue. So you have the workflow "First in, first out"!
 *
 * @version 1.0.0
 * @author Florian Reisinger, Thomas Pretterhofer
 */
public interface Queue {
	
	/**
	 *  Adds the element obj to the queue. 
	 *  If the addition is successful, the method returns true else false.
	 * @param obj
	 * @return
	 */
	public abstract boolean offer(String obj);

	/**
	 *  Returns the head (first) element and also deletes it. That is, we cannot get it again. 
	 *  If no element exists (when queue is empty), the method returns null.
	 * @return
	 */
	public abstract String poll();
	
	/**
	 * It also returns and deletes the head element like poll(), but with a small difference. 
	 * This method throws NoSuchElementException if the queue is empty. 
	 * 
	 * @return
	 */
	public abstract String remove();
	
	/**
	 *  Returns the head element but it does not delete it. That is, we can get it again. 
	 *  Returns null when the queue is empty. 
	 * @return
	 */
	public abstract String peek();
	
	/**
	 *  It works similar to peek() but with a small difference (returns but does not delete the element). 
	 *  It throws NoSuchElementException when the queue is empty.
	 * @return
	 */
	public abstract String element();
	
}

