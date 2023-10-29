package lab4.inform.student;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class GreedyBestFirstSearchAlgo implements IInformedSearchAlgo {

    @Override
    public Node execute(Node root, String goal) {
        PriorityQueue<Node> frontier = new PriorityQueue<>(new NodeComparatorByHn());
        List<Node> explored = new ArrayList<>();
        frontier.add(root);
        while (!frontier.isEmpty()) {
            Node currentNode = frontier.poll();
            if (currentNode.getLabel().equals(goal)) {
                return currentNode;
            }
            explored.add(currentNode);
            List<Node> childrenNodes = currentNode.getChildrenNodes();
            for (Node child : childrenNodes) {
                if (!frontier.contains(child) && !explored.contains(child)) {
                    frontier.add(child);
                }
            }
        }

        return null;
    }

    @Override
    public Node execute(Node root, String start, String goal) {
        return null;
    }


}
