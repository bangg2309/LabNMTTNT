package k18;

import java.sql.SQLOutput;

public class Test {
    public static void main(String[] args) {
        Node nodeS = new Node("S");
        Node nodeA = new Node("A"); Node nodeB = new Node("B");
        Node nodeC = new Node("C"); Node nodeD = new Node("D");
        Node nodeE = new Node("E"); Node nodeF = new Node("F");
        Node nodeG = new Node("G"); Node nodeH = new Node("H");

        nodeS.addEdge(nodeA, 5); nodeS.addEdge(nodeB, 2);
        nodeS.addEdge(nodeC, 4); nodeA.addEdge(nodeD, 9);
        nodeA.addEdge(nodeE, 4); nodeB.addEdge(nodeG, 6);
        nodeC.addEdge(nodeF, 2); nodeD.addEdge(nodeH, 7);
        nodeE.addEdge(nodeG, 6); nodeF.addEdge(nodeG, 1);
        ISearchAlgo algo1 = new BFSGraphSearchAlgo();
        ISearchAlgo algo2 = new DFSGraphSearchAlgo();
        ISearchAlgo algo3 = new BFSTreeSearchAlgo();
        ISearchAlgo algo4 = new DFSTreeSearchAlgo();
        ISearchAlgo algo5 = new UniformCostSearchAlgo();
        DepthLimitedSearch depthLimitedSearch = new DepthLimitedSearch();

//        System.out.println(NodeUtils.printPath(algo1.execute(nodeS, "G")));
//        System.out.println(algo1.execute(nodeS,"G"));
//        System.out.println(NodeUtils.printPath(algo2.execute(nodeS, "G")));
//        System.out.println(NodeUtils.printPath(algo1.execute(nodeS,nodeA.getLabel(),"G")));
//        System.out.println(algo2.execute(nodeS, "B", "G"));
//        System.out.println(NodeUtils.printPath(algo2.execute(nodeS, "C", "G")));
//        System.out.println(NodeUtils.printPath(algo3.execute(nodeS, "G")));
//        System.out.println(NodeUtils.printPath(algo3.execute(nodeS,"A", "G")));
//        System.out.println(NodeUtils.printPath(algo4.execute(nodeS, "G")));
//        System.out.println(NodeUtils.printPath(algo5.execute(nodeS, "E")));
        System.out.println(NodeUtils.printPath(depthLimitedSearch.execute(nodeS,"G",2)));
    }
}
