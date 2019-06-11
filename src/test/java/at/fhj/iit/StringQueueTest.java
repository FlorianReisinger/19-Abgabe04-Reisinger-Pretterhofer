package at.fhj.iit;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import java.util.NoSuchElementException;

/**
 * JUnit Tests for the StringQueue class.
 * @author Florian Reisinger und Thomas Pretterhofer
 * @version 1.0
 */
public class StringQueueTest {
    public StringQueue qMin, qBig, defCon, tooLow1, tooLow2;

    //to test absolute minimum
    private int maxSize1 = 1;

    //to test with a big size
    private int maxSize2 = 99;

    /**
     * Constructs instances of the StringQueue class.
     * @throws Exception
     */
    @Before
    public void setup() throws Exception {
        qMin = new StringQueue(maxSize1);
        qBig = new StringQueue(maxSize2);
    }

    //---------- Tests with default constructor ----------

    /**
     * This tests the maxSize of the default constructor.
     * The default maxSize is 5.
     * 5 elements will be added to the queue. Return value must be true.
     * A 6th element will be added which must return false.
     */
    @Test
    public void testDefaultConstructorMaxSize() {
        defCon = new StringQueue();

        for (int i = 0; i < 5; i++) {
            assertTrue(defCon.offer(Integer.toString(i)));
        }
        assertFalse(defCon.offer("Overflow"));
    }


    //---------- Tests with constructor ----------

    /**
     * The size of the queue must be greater than 0.
     * Tries to construct an instance with size 0;
     * Must throw IllegalArgumentException.
     * @throws Exception
     */
    @Test(expected = IllegalArgumentException.class)
    public void testMaxSizeTooLow1() throws Exception {
        tooLow1 = new StringQueue(0);
    }

    /**
     * The size of the queue must be greater than 0.
     * Tries to construct an instance with size -1;
     * Must throw IllegalArgumentException.
     * @throws Exception
     */
    @Test(expected = IllegalArgumentException.class)
    public void testMaxSizeTooLow2() throws Exception {
        tooLow2 = new StringQueue(-1);

    }

    //======================= Test the absolute minimum size (maxSize1 = 1) =======================

    //---------- Tests with offer() ----------

    /**
     * Tries to add more items to the queue as the maximum size of the queue is.
     * Checks the return value if each method call.
     * The last method call must return false,
     * all other must return true.
     */
    @Test
    public void testOfferMaxSize() {

        for (int i = 0; i < maxSize1; i++) {
            assertTrue(qMin.offer(Integer.toString(i)));
        }
        assertFalse(qMin.offer("Overflow"));
    }

    //---------- Tests with poll() ----------

    /**
     * Tries to poll an element from an empty queue.
     * This element must be null.
     */
    @Test
    public void testPollIsNull() {
        assertTrue(qMin.poll() == null);
    }


    /**
     * A teststring is added to the queue.
     * The result of poll must be the teststring.
     * The result of the poll of an empty queue must be null.
     */
    @Test
    public void testOneStringWithPoll1() {
        final String testString = "TestString!?12315_-*!§";
        qMin.offer(testString);
        assertTrue(qMin.poll() == testString);
        assertTrue(qMin.poll() == null);
    }

    /**
     * A teststring is added to the queue.
     * The result of poll must be the teststring.
     * The result of the poll of an empty queue must be null.
     */
    @Test
    public void testOneStringWithPoll2() {
        final String testString = "Houston, we have a problem!";
        qMin.offer(testString);
        assertTrue(qMin.poll() == testString);
        assertTrue(qMin.poll() == null);
    }


    /**
     * Puts a sequence of numbers in the queue, then polls all the elements.
     * Sequence must be the same.
     * One more element is polled than putted. This element must be null.
     */
    @Test
    public void testSequencePollWithNumbers1() {
        for (int i = 0; i < maxSize1; i++) {
            assertTrue(qMin.offer(Integer.toString(i)));
        }

        for (int i = 0; i < maxSize1; i++) {
            assertTrue(qMin.poll().equals(Integer.toString(i)));
        }

        assertTrue(qMin.poll() == null);
    }

    /**
     * Puts a sequence of numbers in the queue, then polls all the elements.
     * Sequence must be the same.
     * One more element is polled than putted. This element must be null.
     */
    @Test
    public void testSequencePollWithNumbers2() {
        for (int i = maxSize1; i > 0; i--) {
            assertTrue(qMin.offer(Integer.toString(i)));
        }

        for (int i = maxSize1; i > 0; i--) {
            assertTrue(qMin.poll().equals(Integer.toString(i)));
        }

        assertTrue(qMin.poll() == null);
    }

    /**
     * Adds a combination of strings and numbers to the queue.
     * poll() must return the combination of strings and numbers in the same sequence.
     * One more element is polled than putted. This element must be null.
     */
    @Test
    public void testSequencePollWithStrings() {
        final String[] testStrings = {"May the source be with you!", "So much to code, so little time :-)", " ", "!§$%&/()=?[]{}", "Kill Bill Vol. 2", "63458tr!z7h49_", "pulp", "FICTION"};
        int arrayIndex = 0;

        for (int i = 0; i < maxSize1; i++) {

            assertTrue(qMin.offer(testStrings[arrayIndex] + i));

            if (arrayIndex + 1 >= testStrings.length) {
                arrayIndex = 0;
            } else
                arrayIndex++;
        }

        arrayIndex = 0;
        for (int i = 0; i < maxSize1; i++) {

            assertTrue(qMin.poll().equals(testStrings[arrayIndex] + i));

            if (arrayIndex + 1 >= testStrings.length) {
                arrayIndex = 0;
            } else
                arrayIndex++;
        }
        assertTrue(qMin.poll() == null);
    }

    //---------- Tests with remove() ----------

    /**
     * Tries to remove an element from an empty queue. Must throw
     * NoSuchElementException.
     *
     * @throws NoSuchElementException
     */
    @Test(expected = NoSuchElementException.class)
    public void testRemoveFromEmptyQueue() {
        qMin.remove();
    }

    /**
     * A teststring is added to the queue.
     * The result of remove must be the teststring.
     * The result of the remove of an empty queue must be an exception.
     */
    @Test(expected = NoSuchElementException.class)
    public void testOneStringWithRemove() {
        final String testString = "bla bla bla & bla 1234";
        qMin.offer(testString);
        assertTrue(qMin.remove().equals(testString));
        qMin.remove();
    }

    /**
     * A teststring is added to the queue.
     * The result of remove must be the teststring.
     * The result of the remove of an empty queue must be an exception.
     */
    @Test(expected = NoSuchElementException.class)
    public void testOneStringWithRemove2() {
        final String testString = "Oh behave, baby!";
        assertTrue(qMin.remove().equals(testString));
        qMin.remove();
    }

    /**
     * Puts a sequence of numbers in the queue, then removes all the elements.
     * Sequence must be the same.
     * One more element is removed than putted. This element must throw an exception.
     */
    @Test(expected = NoSuchElementException.class)
    public void testSequenceRemoveWithNumbers1() {
        for (int i = 0; i < maxSize1; i++) {
            assertTrue(qMin.offer(Integer.toString(i)));
        }

        for (int i = 0; i < maxSize1; i++) {
            assertTrue(qMin.remove().equals(Integer.toString(i)));
        }

        qMin.remove();
    }

    /**
     * Puts a sequence of numbers in the queue, then removes all the elements.
     * Sequence must be the same.
     * One more element is removed than putted. This element must throw an exception.
     */
    @Test(expected = NoSuchElementException.class)
    public void testSequenceRemoveWithNumbers2() {
        for (int i = maxSize1; i > 0; i--) {
            assertTrue(qMin.offer(Integer.toString(i)));
        }

        for (int i = maxSize1; i > 0; i--) {
            assertTrue(qMin.remove().equals(Integer.toString(i)));
        }

        qMin.remove();
    }

    /**
     * Adds a combination of strings and numbers to the queue.
     * remove() must return the combination of strings and numbers in the same sequence.
     * One more element is removed than putted. This element must throw an exception.
     */
    @Test(expected = NoSuchElementException.class)
    public void testSequenceRemoveWithStrings() {
        final String[] testStrings = {"I'll be back!", "Talk to the hand!", "I need your clothes, your boots and your motorcycle!", "Hast la vista, Baby!"};
        int arrayIndex = 0;

        for (int i = 0; i < maxSize1; i++) {

            assertTrue(qMin.offer(i + testStrings[arrayIndex]));

            if (arrayIndex + 1 >= testStrings.length) {
                arrayIndex = 0;
            } else
                arrayIndex++;
        }

        arrayIndex = 0;
        for (int i = 0; i < maxSize1; i++) {

            assertTrue(qMin.remove().equals(i + testStrings[arrayIndex]));

            if (arrayIndex + 1 >= testStrings.length) {
                arrayIndex = 0;
            } else
                arrayIndex++;
        }
        qMin.remove();
    }

    //---------- Tests with peek() ----------

    /**
     * Tries to peek into an empty queue.
     * This element must be null.
     */
    @Test
    public void testPeekIsNull() {
        assertTrue(qMin.peek() == null);
    }

    /**
     * A teststring is added to the queue.
     * The result of peek() must be the teststring.
     */
    @Test
    public void testOneStringWithPeek1() {
        final String testString = "Who is Zed? Zed`s dead, baby!";
        qMin.offer(testString);
        assertTrue(qMin.peek() == testString);
    }

    /**
     * A teststring is added to the queue.
     * The result of peek() must be the teststring.
     */
    @Test
    public void testOneStringWithPeek2() {
        final String testString = "E.T. nach Hause telefonieren!";
        qMin.offer(testString);
        assertTrue(qMin.peek() == testString);
    }

    /**
     * Adds a combination of strings and numbers to the queue.
     * peek() must show the very first element.
     */
    @Test
    public void testSeveralStringsWithPeek() {
        final String[] testStrings = {"Ein Big Mac ist ein Big Mac, aber die nennen ihn Le Big Macke!", "Ich bin Mr. Wolf. Ich löse Probleme.", "Hamburger! Der Grundstein eines jeden nahrhaften Frühstücks!"};
        int arrayIndex = 0;

        for (int i = 0; i < maxSize1; i++) {

            assertTrue(qMin.offer(testStrings[arrayIndex] + i));

            if (arrayIndex + 1 >= testStrings.length) {
                arrayIndex = 0;
            } else
                arrayIndex++;
        }

        assertTrue(qMin.peek().equals(testStrings[0] + "0"));
    }

    //---------- Tests with element() ----------

    /**
     * Uses element() on an empty queue, must throw exception.
     *
     * @throws NoSuchElementException
     */
    @Test(expected = NoSuchElementException.class)
    public void testElementIsNull() {
        qMin.element();
    }

    /**
     * A teststring is added to the queue.
     * The result of element() must be the teststring.
     */
    @Test
    public void testOneStringWithElement1() {
        final String testString = "Who is Zed? Zed`s dead, baby!";
        qMin.offer(testString);
        assertTrue(qMin.element().equals(testString));
    }

    /**
     * A teststring is added to the queue.
     * The result of element() must be the teststring.
     */
    @Test
    public void testOneStringWithElement2() {
        final String testString = "Möge die Macht mit dir sein!";
        qMin.offer(testString);
        assertTrue(qMin.element().equals(testString));
    }

    /**
     * Adds a combination of strings and numbers to the queue.
     * element() must show the very first element.
     */
    @Test
    public void testSeveralStringsWithElement() {
        final String[] testStrings = {"Ein Big Mac ist ein Big Mac, aber die nennen ihn Le Big Macke!", "Ich bin Mr. Wolf. Ich löse Probleme.", "Hamburger! Der Grundstein eines jeden nahrhaften Frühstücks!"};
        int arrayIndex = 0;

        for (int i = 0; i < maxSize1; i++) {

            assertTrue(qMin.offer(testStrings[arrayIndex] + i));

            if (arrayIndex + 1 >= testStrings.length) {
                arrayIndex = 0;
            } else
                arrayIndex++;
        }

        assertTrue(qMin.element().equals(testStrings[0] + "0"));
    }


    //======================= Test with a big size (maxSize2 = 99) =======================

    //---------- Tests with offer() ----------

    /**
     * Tries to add more items to the queue as the maximum size of the queue is.
     * Checks the return value if each method call.
     * The last method call must return false,
     * all other must return true.
     */
    @Test
    public void testOfferMaxSizeBig() {

        for (int i = 0; i < maxSize2; i++) {
            assertTrue(qBig.offer(Integer.toString(i)));
        }
        assertFalse(qBig.offer("Overflow"));
    }

    //---------- Tests with poll() ----------

    /**
     * Tries to poll an element from an empty queue.
     * This element must be null.
     */
    @Test
    public void testPollIsNullBig() {
        assertTrue(qBig.poll() == null);
    }


    /**
     * A teststring is added to the queue.
     * The result of poll must be the teststring.
     * The result of the poll of an empty queue must be null.
     */
    @Test
    public void testOneStringWithPoll1Big() {
        final String testString = "TestString!?12315_-*!§";
        qBig.offer(testString);
        assertTrue(qBig.poll() == testString);
        assertTrue(qBig.poll() == null);
    }

    /**
     * A teststring is added to the queue.
     * The result of poll must be the teststring.
     * The result of the poll of an empty queue must be null.
     */
    @Test
    public void testOneStringWithPoll2Big() {
        final String testString = "Houston, we have a problem!";
        qBig.offer(testString);
        assertTrue(qBig.poll() == testString);
        assertTrue(qBig.poll() == null);
    }


    /**
     * Puts a sequence of numbers in the queue, then polls all the elements.
     * Sequence must be the same.
     * One more element is polled than putted. This element must be null.
     */
    @Test
    public void testSequencePollWithNumbers1Big() {
        for (int i = 0; i < maxSize2; i++) {
            assertTrue(qBig.offer(Integer.toString(i)));
        }

        for (int i = 0; i < maxSize2; i++) {
            assertTrue(qBig.poll().equals(Integer.toString(i)));
        }

        assertTrue(qBig.poll() == null);
    }

    /**
     * Puts a sequence of numbers in the queue, then polls all the elements.
     * Sequence must be the same.
     * One more element is polled than putted. This element must be null.
     */
    @Test
    public void testSequencePollWithNumbers2Big() {
        for (int i = maxSize2; i > 0; i--) {
            assertTrue(qBig.offer(Integer.toString(i)));
        }

        for (int i = maxSize2; i > 0; i--) {
            assertTrue(qBig.poll().equals(Integer.toString(i)));
        }

        assertTrue(qBig.poll() == null);
    }

    /**
     * Adds a combination of strings and numbers to the queue.
     * poll() must return the combination of strings and numbers in the same sequence.
     * One more element is polled than putted. This element must be null.
     */
    @Test
    public void testSequencePollWithStringsBig() {
        final String[] testStrings = {"May the source be with you!", "So much to code, so little time :-)", " ", "!§$%&/()=?[]{}", "Kill Bill Vol. 2", "63458tr!z7h49_", "pulp", "FICTION"};
        int arrayIndex = 0;

        for (int i = 0; i < maxSize2; i++) {

            assertTrue(qBig.offer(testStrings[arrayIndex] + i));

            if (arrayIndex + 1 >= testStrings.length) {
                arrayIndex = 0;
            } else
                arrayIndex++;
        }

        arrayIndex = 0;
        for (int i = 0; i < maxSize2; i++) {

            assertTrue(qBig.poll().equals(testStrings[arrayIndex] + i));

            if (arrayIndex + 1 >= testStrings.length) {
                arrayIndex = 0;
            } else
                arrayIndex++;
        }
        assertTrue(qBig.poll() == null);
    }

    //---------- Tests with remove() ----------

    /**
     * Tries to remove an element from an empty queue. Must throw
     * NoSuchElementException.
     *
     * @throws NoSuchElementException
     */
    @Test(expected = NoSuchElementException.class)
    public void testRemoveFromEmptyQueueBig() {
        qBig.remove();
    }

    /**
     * A teststring is added to the queue.
     * The result of remove must be the teststring.
     * The result of the remove of an empty queue must be an exception.
     */
    @Test(expected = NoSuchElementException.class)
    public void testOneStringWithRemoveBig() {
        final String testString = "bla bla bla & bla 1234";
        qBig.offer(testString);
        assertTrue(qBig.remove().equals(testString));
        qBig.remove();
    }

    /**
     * A teststring is added to the queue.
     * The result of remove must be the teststring.
     * The result of the remove of an empty queue must be an exception.
     */
    @Test(expected = NoSuchElementException.class)
    public void testOneStringWithRemove2Big() {
        final String testString = "Oh behave, baby!";
        assertTrue(qBig.remove().equals(testString));
        qBig.remove();
    }

    /**
     * Puts a sequence of numbers in the queue, then removes all the elements.
     * Sequence must be the same.
     * One more element is removed than putted. This element must throw an exception.
     */
    @Test(expected = NoSuchElementException.class)
    public void testSequenceRemoveWithNumbers1Big() {
        for (int i = 0; i < maxSize2; i++) {
            assertTrue(qBig.offer(Integer.toString(i)));
        }

        for (int i = 0; i < maxSize2; i++) {
            assertTrue(qBig.remove().equals(Integer.toString(i)));
        }

        qBig.remove();
    }

    /**
     * Puts a sequence of numbers in the queue, then removes all the elements.
     * Sequence must be the same.
     * One more element is removed than putted. This element must throw an exception.
     */
    @Test(expected = NoSuchElementException.class)
    public void testSequenceRemoveWithNumbers2Big() {
        for (int i = maxSize2; i > 0; i--) {
            assertTrue(qBig.offer(Integer.toString(i)));
        }

        for (int i = maxSize2; i > 0; i--) {
            assertTrue(qBig.remove().equals(Integer.toString(i)));
        }

        qBig.remove();
    }

    /**
     * Adds a combination of strings and numbers to the queue.
     * remove() must return the combination of strings and numbers in the same sequence.
     * One more element is removed than putted. This element must throw an exception.
     */
    @Test(expected = NoSuchElementException.class)
    public void testSequenceRemoveWithStringsBig() {
        final String[] testStrings = {"I'll be back!", "Talk to the hand!", "I need your clothes, your boots and your motorcycle!", "Hast la vista, Baby!"};
        int arrayIndex = 0;

        for (int i = 0; i < maxSize2; i++) {

            assertTrue(qBig.offer(i + testStrings[arrayIndex]));

            if (arrayIndex + 1 >= testStrings.length) {
                arrayIndex = 0;
            } else
                arrayIndex++;
        }

        arrayIndex = 0;
        for (int i = 0; i < maxSize2; i++) {

            assertTrue(qBig.remove().equals(i + testStrings[arrayIndex]));

            if (arrayIndex + 1 >= testStrings.length) {
                arrayIndex = 0;
            } else
                arrayIndex++;
        }
        qBig.remove();
    }

    //---------- Tests with peek() ----------

    /**
     * Tries to peek into an empty queue.
     * This element must be null.
     */
    @Test
    public void testPeekIsNullBig() {
        assertTrue(qBig.peek() == null);
    }

    /**
     * A teststring is added to the queue.
     * The result of peek() must be the teststring.
     */
    @Test
    public void testOneStringWithPeek1Big() {
        final String testString = "Who is Zed? Zed`s dead, baby!";
        qBig.offer(testString);
        assertTrue(qBig.peek() == testString);
    }

    /**
     * A teststring is added to the queue.
     * The result of peek() must be the teststring.
     */
    @Test
    public void testOneStringWithPeek2Big() {
        final String testString = "E.T. nach Hause telefonieren!";
        qBig.offer(testString);
        assertTrue(qBig.peek() == testString);
    }

    /**
     * Adds a combination of strings and numbers to the queue.
     * peek() must show the very first element.
     */
    @Test
    public void testSeveralStringsWithPeekBig() {
        final String[] testStrings = {"Ein Big Mac ist ein Big Mac, aber die nennen ihn Le Big Macke!", "Ich bin Mr. Wolf. Ich löse Probleme.", "Hamburger! Der Grundstein eines jeden nahrhaften Frühstücks!"};
        int arrayIndex = 0;

        for (int i = 0; i < maxSize2; i++) {

            assertTrue(qBig.offer(testStrings[arrayIndex] + i));

            if (arrayIndex + 1 >= testStrings.length) {
                arrayIndex = 0;
            } else
                arrayIndex++;
        }

        assertTrue(qBig.peek().equals(testStrings[0] + "0"));
    }

    //---------- Tests with element() ----------

    /**
     * Uses element() on an empty queue, must throw exception.
     *
     * @throws NoSuchElementException
     */
    @Test(expected = NoSuchElementException.class)
    public void testElementIsNullBig() {
        qBig.element();
    }

    /**
     * A teststring is added to the queue.
     * The result of element() must be the teststring.
     */
    @Test
    public void testOneStringWithElement1Big() {
        final String testString = "Who is Zed? Zed`s dead, baby!";
        qBig.offer(testString);
        assertTrue(qBig.element().equals(testString));
    }

    /**
     * A teststring is added to the queue.
     * The result of element() must be the teststring.
     */
    @Test
    public void testOneStringWithElement2Big() {
        final String testString = "Möge die Macht mit dir sein!";
        qBig.offer(testString);
        assertTrue(qBig.element().equals(testString));
    }

    /**
     * Adds a combination of strings and numbers to the queue.
     * element() must show the very first element.
     */
    @Test
    public void testSeveralStringsWithElementBig() {
        final String[] testStrings = {"Ein Big Mac ist ein Big Mac, aber die nennen ihn Le Big Macke!", "Ich bin Mr. Wolf. Ich löse Probleme.", "Hamburger! Der Grundstein eines jeden nahrhaften Frühstücks!"};
        int arrayIndex = 0;

        for (int i = 0; i < maxSize2; i++) {

            assertTrue(qBig.offer(testStrings[arrayIndex] + i));

            if (arrayIndex + 1 >= testStrings.length) {
                arrayIndex = 0;
            } else
                arrayIndex++;
        }

        assertTrue(qBig.element().equals(testStrings[0] + "0"));
    }

}
