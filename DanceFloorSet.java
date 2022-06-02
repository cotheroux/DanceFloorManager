import java.util.Iterator;
import java.util.Vector;

/**
 * Represents all dances that can be danced at the same time on a dance floor
 * during a song.
 **/
public class DanceFloorSet //implements Iterable<Dance>
{
    protected Vector<Dance> dances;
    
    public DanceFloorSet()
    {
        dances = new Vector<Dance>();
    }
    
    public Dance get(int index)
    {
        return dances.get(index);
    }
    
    public void add(Dance d)
    {
        dances.add(d);
    }
    
    //-------------------------------------------------------------------------
    /**
     * Returns the number of dances in this set.
     **/
    public int size()
    {
        return dances.size();
    }
    
    //-------------------------------------------------------------------------
    /**
     * @see https://www.geeksforgeeks.org/java-implementing-iterator-and-iterable-interface/
     **/
    /*public Iterator<Dance> iterator()
    {
        return new DanceFloorSetIterator<Dance>(this);
    }

    private class DanceFloorSetIterator<Dance> implements Iterator<Dance>
    {
        /**
         * Constructor
         ** /
        public DanceFloorSetIterator<Dance>(DanceFloorSet obj)
        {
            
        }
        
        // Check if next element exists.
        public boolean hasNext()
        {
        }
        
        // Moves the cursor/iterator to next element.
        public Dance next()
        {
        }
        
        // Used to remove an element. Implement only if needed
        public void remove()
        {
            // default throws UnsupportedOperationException.
        }
    }*/
}
