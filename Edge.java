
/**
 * The edge class is for each of the trainlines - the edges - that connect each station
 * Holds a string name of the trainline and two vertices (stations) connected to it
 *
 * @author Louis Pike
 * @version 1
 */
public class Edge
{
    // instance variables - replace the example below with your own
    public Vertex v; //first vertex
    public Vertex w; //next vertex
    public String railName; //name

    /**
     * Constructor for objects of class Edge
     * @param name String 
     * @param v Vertex
     * @param w Vertex
     * Creates edge with trainline name and the two stations (vertices) conntected to it
     */
    public Edge(String name, Vertex v, Vertex w)
    {
        this.railName = name; 
        this.v = v;
        this.w = w;
    }

    /**
     * Returns the name of the train line/ the railName variable of the edge given
     *
     * @param  e Edge
     * @return railName String
     */
    public String getName(Edge e)
    {
        return e.railName;
    }

    /**
     * Returns the vertex v of the edge (returns a station connected to the trainline)
     * @return v Vertex
     */
    public Vertex getFirstVertex(){
        return v;
    }

    /**
     * Returns the vertex w of the edge (returns a station connected to the trainline)
     * @return w Vertex
     */
    public Vertex getSecondVertex(){
        return w;
    }

    /**
     * Removes the vertex (station) input from the edge and changes it to null
     * @param v Vertex
     */
    public void removeVertex(Vertex v){
        if(this.v == v){
            this.v = null;
        } else if (this.w ==v){
            this.w = null;   
        }

    }

}
