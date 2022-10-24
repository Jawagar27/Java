public class Testharness {
    public static void main(String[] args)
    {
        // VARIABLE DECLARATIONS
        int iNumPassed = 0; int iNumTests = 0; int getInt = 0;
        DSA_Graph graph = new DSA_Graph();
        String sTestString;
        Object nodeValue;

        // TEST 1 : ADD EDGE
        try {
            iNumTests++;
            System.out.print("Testing add edge method: ");

            graph.addEdge("0", "1");
            graph.addEdge("0", "2");
            graph.addEdge("1", "2");
            graph.addEdge("2", "0");
            graph.addEdge("2", "3");
            graph.addEdge("3", "1");

            iNumPassed++;
            System.out.println("PASSED\n");

        } catch(Exception e) { System.out.println("FAILED\n"); }

        

        try {
            iNumTests++;
            System.out.print("Testing has vertex method: ");

            if (!graph.hasVertex("1"))
                throw new IllegalArgumentException("FAILED.\n");

            if (!graph.hasVertex("2"))
                throw new IllegalArgumentException("FAILED.\n");

            if (!graph.hasVertex("3"))
                throw new IllegalArgumentException("FAILED.\n");

            if (!graph.hasVertex("1"))
                throw new IllegalArgumentException("FAILED.\n");

            if (!graph.hasVertex("2"))
                throw new IllegalArgumentException("FAILED.\n");

            if (!graph.hasVertex("3"))
                throw new IllegalArgumentException("FAILED.\n");

            if (!graph.hasVertex("1"))
                throw new IllegalArgumentException("FAILED.\n");

            iNumPassed++;
            System.out.println("PASSED\n");
        } catch(Exception e) { System.out.println("FAILED\n"); }



        try {
            iNumTests++;
            System.out.print("Testing get vertex count method method: ");
            getInt = graph.getVertexCount();
            if (getInt != 4)
                throw new IllegalArgumentException("FAILED.\n");
            iNumPassed++;
            System.out.println("PASSED\n");
        } catch(Exception e) { System.out.println("FAILED\n"); }


        try {
            iNumTests++;
            System.out.print("Testing get edge count method: ");
            getInt = graph.getEdgeCount();
            if (getInt != 6)
                throw new IllegalArgumentException("FAILED.\n");
            iNumPassed++;
            System.out.println("PASSED\n");

        } catch(Exception e) { System.out.println("FAILED\n"); }

        try {
            iNumTests++;
            System.out.print("Testing is adjacent method for vertex 1 and 2: ");
            if (!graph.isAdjacent("1", "2"))
                throw new IllegalArgumentException("FAILED.\n");

            System.out.println("PASSED\n");

            System.out.print("Testing is adjacent method for vertex 1 and 3: ");
            if (graph.isAdjacent("1", "3"))
                throw new IllegalArgumentException("FAILED.\n");

            iNumPassed++;
            System.out.println("PASSED\n");

        } catch(Exception e) { System.out.println("FAILED\n"); }

        try {

            iNumTests++;
            System.out.println("Testing display method: \n");
            graph.display();
            iNumPassed++;

        } catch(Exception ignored) { }

        try {
            iNumTests++;
            System.out.println("Testing BFS method from vertex 1: ");
            graph.BFSRec("2");
            System.out.println("\n");
            iNumPassed++;

        } catch(Exception e) { System.out.println("TEST FAILED\n"); }

        try {
            iNumTests++;
            System.out.println("Testing DFS method from vertex 1: ");
            graph.DFSRec("1");
            System.out.println("\n");
            iNumPassed++;

        } catch(Exception e) { System.out.println("FAILED\n"); }


        System.out.print("\nNumber PASSED: " + iNumPassed + "/" + iNumTests);
        System.out.print(" -> " + (int)(double)iNumPassed/iNumTests*100 + "%\n");
        readGraph();
    }
    public static void readGraph(){
        DSA_Graph graph=new DSA_Graph();
        graph=FileReading.processline(graph,"prac6_1.al");
        graph.display();
        System.out.println("============================");
        System.out.println(">>> BREADTH FIRST SEARCH <<<");
        graph.BFSRec("A");
        System.out.println("============================");
        System.out.println(">>> DEPTH FIRST SEARCH <<<");
        graph.DFSRec("A");
    }
}
