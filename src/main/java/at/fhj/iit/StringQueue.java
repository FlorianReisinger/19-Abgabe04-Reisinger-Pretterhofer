package at.fhj.iit;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.ArrayList;

/**
 * Queue Implementation of <code>Queue</code> Interface.
 * Supports String Values and can be initialized with a maximum number
 * of items. Elements will be added at the end of the queue.If you
 * poll an element, this element will be the oldest one in the queue.
 *
 * @author Florian Reisinger und Thomas Pretterhofer
 * @version 1.0
 * @see Queue
 */
public class StringQueue implements Queue {

    private static final Logger logger = LogManager.getLogger(StringQueue.class);

    /**
     * Stores the string values of this queue
     */
    private List<String> elements = new ArrayList<>();

    /**
     * Defines the maximum size of the queue for the default constructor.
     */
    private int maxSize = 5;

    /**
     * Default Constructor.
     * Constructs a queue with a maximum of 5 Elements.
     */
    public StringQueue() {
        logger.info("StringQueue(): Default constructor with default maxSize " + maxSize);
    }

    /**
     * Constructor that initialize the queue and delimit the
     * maximum size.
     *
     * @param maxSize the maxium size of the queue
     */
    public StringQueue(int maxSize) {
        logger.info("StringQueue(): Constructor with maxSize " + maxSize);
        if (maxSize <= 0) {
            logger.error("throw IllegalArgumentException(Size of StringQueue must be greater than 0!)");
            throw new IllegalArgumentException("Size of StringQueue must be greater than 0!");
        } else {
            this.maxSize = maxSize;

        }
    }

    /**
     * The function "offer" adds a String, which is
     * given as an parameter. If the queue size
     * is smaller then the maximum size, then the
     * String will be added and the function returns
     * "true". Otherwise the String won't be added
     * and the function returns "false".
     *
     * @param obj the String-parameter which will
     *            be added to the queue of this
     *            instance.
     * @return The return value is a boolean,
     * if the functions succeded or not.
     */
    @Override
    public boolean offer(String obj) {
        logger.info("Method offer() called.");
        if (elements.size() != maxSize) {
            elements.add(obj);
        } else {
            return false;
        }
        return true;
    }

    /**
     * The function "poll" picks the String from
     * the head of the queue, saves it to a
     * String variable, deletes the String in the
     * queue and returns the deleted String.
     *
     * @return The function returns a String
     * from the Head of the queue.
     */
    @Override
    public String poll() {
        logger.info("Method poll() called.");
        String element = peek();

        if (elements.size() > 0) {
            elements.remove(0);
        }

        return element;
    }

    /**
     * The function calls the function "poll()"
     * which removes the String from the head
     * from the queue. Additionally this
     * function checks if the element is null,
     * which means the queue is empty.
     *
     * @return The function returns a String
     * from the Head of the queue.
     */
    @Override
    public String remove() {
        logger.info("Method remove() called.");
        String element = poll();
        if (element == null) {
            logger.error("throw NoSuchElementException (No file in the queue)");
            throw new NoSuchElementException("there's no element any more");
        }

        return element;
    }

    /**
     * The function "peek" picks the String from
     * the head of the queue, checks before if the
     * queue has an element or not.
     *
     * @return The function returns a String
     * from the Head of the queue or null,
     * if the queue is empty.
     */
    @Override
    public String peek() {
        logger.info("Method peek() called.");
        String element;

        if (elements.size() > 0) {
            element = elements.get(0);
        } else {
            element = null;
        }

        return element;
    }

    /**
     * The function "element" calls the
     * function "peek" which returns an
     * element or null.
     *
     * @return The function returns a String
     * from the head of the queue or an
     * exception if the queue is empty
     */
    @Override
    public String element() {
        logger.info("Method element() called.");
        String element = peek();
        if (element == null) {
            logger.error("throw NoSuchElementException, if there is no " +
                    "element in the queue anymore");

            throw new NoSuchElementException("there's no element any more");
        }
        return element;
    }

}