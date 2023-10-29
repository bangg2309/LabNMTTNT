package lab4.inform.student;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class AStarSearchAlgo implements IInformedSearchAlgo {
    @Override
    public Node execute(Node root, String goal) {
        PriorityQueue<Node> frontier = new PriorityQueue<>(new NodeComparatorByFn());
        List<Node> explored = new ArrayList<>();
        frontier.offer(root);
        while (!frontier.isEmpty()) {
            Node curr = frontier.poll();
            if (curr.getLabel().equals(goal)) {
                return curr;
            }
            explored.add(curr);
            List<Edge> children = curr.getChildren();
            for (Edge child : children) {
                Node end = child.getEnd();
                if (!frontier.contains(child) && !explored.contains(child)) {

                    end.setG(curr.getG() + child.getWeight());
                    end.setParent(curr);
                    frontier.offer(end);
                } else if (frontier.contains(end) &&( end.getG()) > (curr.getG() + child.getWeight())) {
                    end.setG(curr.getG() + child.getWeight());
                    end.setParent(curr);
                }
            }
        }
        return null;
    }

    public boolean isAdmissibleH(Node root, String goal){

        return false;
    }

    @Override
    public Node execute(Node root, String start, String goal) {
        return null;
    }
}
