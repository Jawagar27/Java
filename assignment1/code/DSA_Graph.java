
import java.util.Iterator;
public class DSA_Graph {
/* Comp 1002 Assignment 1
     * Author - Jawagar Prabaharan
     * Curtin id - 20944793
     * Graphs  code*/

     //self citation - graph code was previously submitted in prac 6
    DSA_LinkedList vertices;
    Object val = null;

    private class DSAGraphVertex
    {
        String label; //label of the vertices
        Object value = null; //to store value of the vertices
        DSA_LinkedList links; //reference to establish links between nodes
        boolean visited; //to mark each node as visited while traversing

        public DSAGraphVertex(String Label, Object Value)
        {   //parameter constructor
            label = Label;
            value = Value;
            links = new DSA_LinkedList();
            visited = false;
        }

        //another parameter constructor that only takes in the label as a parameter
        public DSAGraphVertex(String Label)
        {
            label = Label;
            links = new DSA_LinkedList();
            visited = false;
        }
        //accessor and mutator methods
        public void addLink(DSAGraphVertex inVertex)
        {

            links.insertLast(inVertex);
        }

        public String getLabel()
        {

            return label;
        }

        public Object getValue()
        {

            return value;
        }

        public DSA_LinkedList getAdjacent()
        {

            return links;
        }

        public void setVisited()
        {

            visited = true;
        }

        public void clearVisited()
        {

            visited = false;
        }

        public boolean getVisited()
        {
            return visited;
        }


    }
    //the innerclass for the edges
    private class DSAGraphEdge
    {
        DSAGraphVertex from; //reference variable to set the from vertex
        DSAGraphVertex to; //reference variable to set the to vertex
        String label; //label of the vertex
        Object value = null; //value of the vertex
        boolean directed; //to check if the graph is directed or not

        public DSAGraphEdge(DSAGraphVertex fromVertex, DSAGraphVertex toVertex, String inLabel, Object inValue, boolean inDirected)
        {   //parameter constructor for the edge class
            from = fromVertex;
            to = toVertex;
            label = inLabel;
            value = inValue;
            directed = inDirected;
        }

        public DSAGraphEdge(DSAGraphVertex fromVertex, DSAGraphVertex toVertex, String inLabel, boolean inDirected)
        {

            from = fromVertex;
            to = toVertex;
            label = inLabel;
            directed = inDirected;
        }

        public String getLabel()
        {

            return label;
        }

        public Object getValue()
        {

            return value;
        }

        public DSAGraphVertex getFrom()
        {

            return from;
        }

        public DSAGraphVertex getTo()
        {

            return to;
        }

        public boolean isDirected()
        {

            return directed;
        }


    }

    public DSA_Graph()
    { //parameter constructor
        vertices = new DSA_LinkedList(); //we make vertices an object of the linked list class
    }

    public void addVertex(String Label, Object Value)
    {
        if (hasVertex(Label) == false)
        {
            DSAGraphVertex vertex = new DSAGraphVertex(Label, Value);
            vertices.insertLast(vertex);
        }

        /*this method basically adds a new vertex along with a value in it
        * it passess the value and the label of the vertex as parameters to the
        * constructors and then the vertex is inserted at last of the graph*/
    }

    public void addVertex(String Label)
    {
        if (hasVertex(Label) == false)
        {
            DSAGraphVertex vertex = new DSAGraphVertex(Label);
            vertices.insertLast(vertex);
        }
        /*this method basically adds a new vertex into a graph
         * it passess the label of the vertex as parameter to the
         * constructor and then the vertex is inserted at last of the graph*/
    }

    public boolean hasVertex(String Label)
    {
        boolean present= false;
        DSAGraphVertex tempVertice;
        Iterator vert = vertices.iterator();
        while (vert.hasNext())
        {
            tempVertice= (DSAGraphVertex) vert.next();
            if (tempVertice.getLabel().equals(Label))
            {
                present = true;
            }
        }
        return present;
        /*this module looks into the vertexes by iterating through them and checks for the label that
        * has been passed as a parameter into the method and if it is present then it returns true or
        * it returns false*/
    }

    public Integer getVertexCount()
    {
        Integer count = vertices.getLength();
        return count;
        //this gets the number of vertices in the graph
    }

    public void addEdge(String label1, String label2)
    {
        addVertex(label1);
        addVertex(label2);
        getVertex(label1).addLink(getVertex(label2));

        //this module adds the vertex one and 2 then creates a link between those 2

    }

    public DSAGraphVertex getVertex(String inLabel)
    {
        DSAGraphVertex returnV = null;
        DSAGraphVertex temp;
        Iterator vert = vertices.iterator();
        while(vert.hasNext())
        {
            temp = (DSAGraphVertex) vert.next();
            if (temp.getLabel().equals(inLabel))
            {
                returnV= temp;
            }
        }
        return returnV;
        /*this method gets a label a the parameter and looks for the vertex and returns it*/
    }

    public DSA_LinkedList getAdjacent(String inLabel)
    { //returning the adjacent of the given label
        DSA_LinkedList returnList = null;
        Iterator itVertices = vertices.iterator();
        DSAGraphVertex tempVertice;
        while (itVertices.hasNext())
        {
            tempVertice = (DSAGraphVertex) itVertices.next();
            if (tempVertice.getLabel().equals(inLabel))
            {
                returnList = tempVertice.getAdjacent();
            }
        }
        return returnList;
    }

    public void display()
    {
        System.out.println("Graph being displayed as an adjacency list");
        Iterator vert = vertices.iterator();
        DSAGraphVertex temp;
        DSAGraphVertex tempLink;
        while (vert.hasNext())
        {
            temp = (DSAGraphVertex) vert.next();
            System.out.print("# " +  temp.getLabel());
            Iterator itLinks = temp.getAdjacent().iterator();
            System.out.print(" # ");
            while (itLinks.hasNext())
            {
                tempLink = (DSAGraphVertex) itLinks.next();
                System.out.print(tempLink.getLabel());
                System.out.print(" ");
            }
            System.out.println("");
        }
    }

    public String display1()
    {
        System.out.println("Graph being displayed as an adjacency list");
        Iterator vert = vertices.iterator();
        DSAGraphVertex temp;
        DSAGraphVertex tempLink;

        String x = " ";
        String y = " ";
        String z = " ";
        String line = " ";
        while (vert.hasNext())
        {
            temp = (DSAGraphVertex) vert.next();
          x =  "| " +  temp.getLabel();
            Iterator itLinks = temp.getAdjacent().iterator();
           z =  " | ";
            while (itLinks.hasNext())
            {
                tempLink = (DSAGraphVertex) itLinks.next();
               y =  tempLink.getLabel();

            }
            line = x+ z + y;
        }
        return line;
    }

   /* public void breadthFirstSearch(String inLabel)
    {
        DSAGraphVertex startVertex = getVertex(inLabel);
        Queue bfsqueue = new Queue();
        System.out.println(bfsproc(startVertex, bfsqueue));
    }*/

  /*  private String bfsproc(DSAGraphVertex inVertex, Queue bfsqueue)
    {
        DSAGraphVertex currVertice;
        String result = "";
        String currLabel;

        bfsqueue.enqueue(inVertex.getLabel());

        while (!bfsqueue.isEmpty())
        {
            currLabel = (String) bfsqueue.dequeue();
            currVertice = getVertex(currLabel);
            if (!currVertice.getVisited())
            {
                result = result + currVertice.getLabel();
                currVertice.setVisited();

                Iterator itNeighbours = currVertice.getAdjacent().iterator();

                while (itNeighbours.hasNext())
                {
                    currVertice = (DSAGraphVertex) itNeighbours.next();
                    bfsqueue.enqueue(currVertice.getLabel());
                }
            }
        }

        Iterator itVertices = vertices.iterator();

        while (itVertices.hasNext())
        {
            currVertice = (DSAGraphVertex) itVertices.next();
            currVertice.clearVisited();
        }

        return result;
    }

    public void depthFirstSearch(String inLabel)
    {
        DSAGraphVertex currVertice;
        DSAGraphVertex startVertex = getVertex(inLabel);
        String result = "";
        dfsUtil(startVertex, result);

        Iterator itVertices = vertices.iterator();

        while (itVertices.hasNext())
        {
            currVertice = (DSAGraphVertex) itVertices.next();
            currVertice.clearVisited();
        }
    }

    private void dfsUtil(DSAGraphVertex inVertex, String result)
    {
        DSAGraphVertex current;
        Iterator itVertex = inVertex.getAdjacent().iterator();
        System.out.print(inVertex.getLabel());
        inVertex.setVisited();

        while (itVertex.hasNext())
        {
            current = (DSAGraphVertex) itVertex.next();
            if (!current.getVisited())
            {
                dfsUtil(current, result);
            }
        }
    } */
}