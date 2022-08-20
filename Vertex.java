import java.util.ArrayList;
/**
 * The vertex class is for each station in the graph
 * Holds the station name and an arraylist of each edge it is connected to
 *
 * @author Louis Pike
 * @version 1
 */
public class Vertex
{
    // instance variables - replace the example below with your own
    public String stationName;
    public ArrayList<Edge> edgesConnected;
 
    /**
     * Constructor for objects of class Vertex
     */
    public Vertex(String name)
    {
        this.stationName = name;
        this.edgesConnected = new ArrayList<Edge>();
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public String getName(Vertex v)
    {
        return this.stationName;
    }
    
    public void addEdge(Edge e){
     edgesConnected.add(e);   
    }
    
    public void removeEdge(Edge e){
     edgesConnected.remove(e);
    }
    
    public ArrayList<Edge> returnEdges(){
     return edgesConnected;   
    }
}
