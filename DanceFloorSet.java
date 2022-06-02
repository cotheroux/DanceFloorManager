import java.util.Vector;

/**
 * Represents all dances that can be danced at the same time on a dance floor
 * during a song.
 **/
public class DanceFloorSet
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
}