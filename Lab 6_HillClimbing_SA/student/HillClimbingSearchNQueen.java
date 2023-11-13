package student;

public class HillClimbingSearchNQueen {
    private Node node;
    int stepClimbed = 0;
    int stepClimbedAfterRandomRestart = 0;
    int randomRestarts = 0;

    public HillClimbingSearchNQueen() {
        this.node = new Node();
        this.node.generateBoard();
    }


    public Node getNode() {
        return node;
    }

    public Node execute(Node initialState) {
        Node curr = initialState;
        Node neighbor = null;
        while (true) {
            neighbor = curr.getBestGenerate();
            if (neighbor.getH() < curr.getH()) curr = neighbor;
            else return curr;
        }


    }

    public Node executeHillClimbingWithRandomRestart(Node initialState) {
        Node curr = initialState;
        Node neighbor = null;
        while (true) {
            if (curr.getH() == 0) {
                System.out.println(stepClimbed);
                System.out.println(randomRestarts);
                System.out.println(stepClimbedAfterRandomRestart);
                return curr;
            }
            neighbor = curr.getBestGenerate();
            if (neighbor.getH() < curr.getH()) {
                curr = new Node(neighbor);
                stepClimbed++;
                stepClimbedAfterRandomRestart++;
            } else {
                curr.generateBoard();
                stepClimbedAfterRandomRestart = 0;
                randomRestarts++;
            }
        }
    }


}