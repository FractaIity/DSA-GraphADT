import java.util.ArrayList;
/**
 * Creates the graph 
 * Stores vertices (train stations) and edges (trainlines) in their own arraylists and methods to manipulate the graph in order to add/remove each edge/vertex to create the graph
 * Contains methods on traversing the graph
 * 
 *
 * @author Louis Pike
 * @version 1
 */
public class Graph implements GraphADT
{
    // instance variables - replace the example below with your ow
    ArrayList<Vertex> vertices = null;
    ArrayList<Edge> edges = null;
    /**
     * Constructor for objects of class Graph
     * Creates new arraylists of Vertex and Edge classes and inserts them into vertices and edges
     */
    public Graph() {
        this.vertices = new ArrayList<Vertex>(); //Arraylist of vertices for the stations
        this.edges = new ArrayList<Edge>(); //Arraylist of edges for the trainlines
        //ArrayList<Vertex> vertices = new ArrayList<Vertex>();
        //ArrayList<Edge> edges = new ArrayList<Edge>();
    }

    /**
     * Insert a new vertex with name n into the graph. Return the new vertex object
     * @param stationName String
     * @return the new Vertex
     */
    public Vertex insertVertex(String stationName){
        Vertex newVertex = new Vertex(stationName); // creates a new vertex/station for the graph
        vertices.add(newVertex); //adds new vertex to the vertices arraylist // station to the graph
        return newVertex; //returns the vertex object
    }

    /**
     * Remove the given vertex from the graph. The name of the vertex is returned, or null if the 
     * graph does not contain the vertex.
     * @param v Vertex
     * @return the name of the vertex or null.
     */
    public String removeVertex(Vertex v){
        String s = v.stationName; //assigns the station name of vertex v
        if (vertices.contains(v)){ //contains method checks if v is in the arraylist vertices
            vertices.remove(v); // removes v if found
            for (Edge e: edges){
             e.removeVertex(v);   
            }
            return s; //returns station name
        } else {
            return null; //returns null if not found
        }
    }

    /**
     * Build a new edge with end vertices v and w and name n and insert into the graph. Return the new Edge object.
     * NB: The vertices u and v must already be in the graph.
     * @param v Vertex
     * @param w Vertex
     * @param n String
     * @return the new Edge
     */
    public Edge insertEdge(Vertex v, Vertex w, String trainline){
        Edge e = new Edge(trainline, v, w); //creates new edge with two vertices (stations) and the trainline name
        edges.add(e); //adds e to the edges arraylist
        v.addEdge(e); //calls method in vertex to store edges to a vertex (makes it easier for traversal later)
        w.addEdge(e); //calls method in vertex to store edges to a vertex (makes it easier for traversal later)
        return e; //returns the new edge
    }

    /**
     * Remove the edge e from the graph. The name of the edge is returned (or null if the edge is not
     * in the graph).
     * @param e the edge to be removed
     * @return the name or null if e does not exist
     */
    public String removeEdge(Edge e){
        String s = e.railName; //stores name of e
        //if arraylist edges contains e then it removes e from the edges arraylist, then it removes it from each vertex classes edgesconnected if it also exists
        if (edges.contains(e)) {
            edges.remove(e);
            for (Vertex v : vertices){
                if (v.edgesConnected.contains(e)){
                    v.removeEdge(e);   
                }
            }
            return s; //returns name of e 
        } else {
            return null; //returns null if not found
        }
    }

    /**
     * Return the endpoint vertex of edge e that is 'opposite' its other endpoint vertex v. Return null if e 
     * does not exist or does not have endpoint v
     * @param e Edge
     * @param v Vertex
     * @return a vertex or null
     */
    public Vertex opposite(Edge e, Vertex v){
        //checks if edges contains edge e, then checks if v is at either side and returns the opposite or null if edge e doesn't have a vertex v else null
        if (edges.contains(e)){
            if (e.v == v){
                return e.w;
            }
            else if(e.w == v) {
                return e.v;
            }
            else {
                return null;   
            }
        }
        return null;
    }

    /**
     * Return a collection containing of all of the vertices in the graph.
     * @return a list of vertices
     */
    public ArrayList<Vertex> vertices(){
        //prints name of all stations/vertices
        for (Vertex v : vertices){
         System.out.println(v.stationName);
        }
        return vertices; //returns arraylist vertices
        // wasn't sure if wanted the arraylist or a printed list so included both
    }

    /**
     * Return a collection of all of the edges in the graph.
     * @return a list of edges
     */
    public ArrayList<Edge> edges(){
        //prints name of all train lines/edges
        for (Edge e : edges){
         System.out.println(e.railName);
        }
        return edges; //returns arraylist edges
        // wasn't sure if wanted the arraylist or a printed list so included both
    }

    /**
     * Checks whether two vertices are adjacent (i.e. joined by a single edge) or not.
     * @param v a vertex
     * @param w a vertex
     * @return true if v and we are adjacent and false otherwise.
     * 
     */
    public boolean areAdjacent(Vertex v, Vertex w){
        //checks for each each/train line if it contains the two vertices/stations and returns true if so (meaning they are linked)
        for (Edge e : edges){
            if((e.getFirstVertex() == v && e.getSecondVertex() == w || e.getFirstVertex() == w && e.getSecondVertex() == v)){
                return true;
            }
        }
        //false if not linked
        return false;
    }

    /**
     * Finds and returns the set of edges that are incident to a given vertex.
     * @param v the vertex
     * @return a list of edges
     */
    public ArrayList<Edge> incidentEdges(Vertex v){
        //calls the method in the vertex class to check all the edges connected to a vertex and prints the name
        for (Edge e : v.returnEdges()){
         System.out.println(e.railName);   
        }
        return v.returnEdges(); //calls upon the method in the vertex class that returns the arraylist of each edge connected to the vertex
        //wasn't sure if wanted a printed list or the arraylist so included both
    }

    /**
     * Rename vertex v as n; returns the old vertex name
     * @param v a vertex
     * @param n the new name
     * @return the old edge name
     */
    public String rename(Vertex v, String n){
        String old = v.stationName; //stores old station name in old
        v.stationName = n; //changes the station name to the new string 
        return old; //returns old station name
    }

    /**
     * Rename edge e as n; returns the old edge name
     * @param e an edge
     * @param n the new name
     * @return the old edge name
     */
    public String rename(Edge e, String n){
        String old = e.railName; //stores old train line name in old
        e.railName = n; //changes the train line name to the new string
        return old; // returns old train line name
    }

    /**
     * Performs a breadth-first traversal of the rail network
     */

    public void bftraverse(Vertex v){
        ArrayList<Vertex> BFT = new ArrayList<Vertex>();
        boolean checked = false;
   
    }
}
