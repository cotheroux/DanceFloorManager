/**
 * Represents a single dance.
 **/
public class Dance
{
    protected String name;
    protected String lp;
    protected int level;
    
    public Dance(String name)
    {
        this.name = name;
    }
    
    public String toString()
    {
        return this.name;
    }
}