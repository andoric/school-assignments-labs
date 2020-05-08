package cst8284.junit.lab4;
import java.lang.Math;

public class Counter {

	/*
	 * A Counter object stores a count variable
	 * that is >= 0
	 * The counter  can be incremented or decremented
	 * But the stored value should never be negative
	 * It should wrap to zero when it reaches the max
	 */
	 /**
     * Counter value
     */
    private int count;
    private static int MAX = Integer.MAX_VALUE;

    /**
     *  Counter with count=0
     */
    public Counter() {
        count = 0;
    }

    /**
     * 
     *
     * @param c  Initial value of count
     */
    public Counter(int c) {
    	if (c<0) {
    		c=0;
    	}
        count = c;
    }

    /**
     *  increments counter value
     *
     * @return new counter value
     */
    public int increment() {
    	if (count == MAX){
    		count=0;
    		return count;
    	}
    	return ++count;
   
    }

    /**
     *  decrements counter value
     *
     * @return new counter value
     */
    public int decrement() {
    	if(count == 0 ) {
    		count=1;
    	}
        return --count;
    }

    /**
     * 
     *
     * @return counter value
     */
    public int getCount() {
        return count;
    }

    /**
     * New counter with value equal to the sum of 
     * the 2 counters passed in the parameters
     *
     * @param c counter to add to the current counter
     * @return newly created counter
     */
    public Counter add(Counter c) {
//    	if (this.count==MAX) {
//    		return new Counter(c.count);
//    	}else if (c.count==MAX) {
//    		return new Counter(this.count);
//    	}else 
    	if ((this.count+c.count)<0) {
    		return new Counter(MAX%(this.count+c.count)); 
    		//this math actually loses 2 bits somewhere, I assume this is something to do with
    		//how Java handles max int overflow, but I'm not sure. 
    																
    	}
        return new Counter(this.count + c.count);
    }

    /**
     * New counter with value equal to the subtraction of 
     * the 2 counters passed in the parameters
     *
     * @param c counter to subtract from the current counter
     * @return newly created counter
     */
    public Counter sub(Counter c) {
        return new Counter(this.count - c.count);

    }
    
   
  
    /**
     * Returns a string representation of this counter.
     *
     * @return a string representation of this counter
     */
    public String toString() {
        return "Count is " + count ;
    } 
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Counter && obj != null) {
            Counter cmpObj = (Counter) obj;
            return count==cmpObj.getCount();
        }

        return false;
    }
  

}
