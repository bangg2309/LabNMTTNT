package k18;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFSGraphSearchAlgo implements ISearchAlgo {

    @Override
    public Node execute(Node tree, String goal) {
        Queue<Node> frontier = new LinkedList<>();
        frontier.add(tree);
        List<Node> explored = new ArrayList<>();
        while (!frontier.isEmpty()) {
            Node leaf = frontier.poll();
            if (leaf.getLabel().equals(goal)) {
                return leaf;
            }
            explored.add(leaf);
            List<Edge> childs = leaf.getChildren();
            for (Edge child : childs) {
                Node node = child.getEnd();
                double cost = child.getWeight();
                if (!frontier.contains(node) && !explored.contains(node)) {
                    frontier.add(node);
                    node.setParent(leaf);
                    node.setPathCost(cost + leaf.getPathCost());
                }
            }
        }
        return null;
    }

    @Override
    public Node execute(Node tree, String start, String goal) {
        Queue<Node> frontier = new LinkedList<>();
        frontier.add(tree);
        boolean started = false;
        List<Node> explored = new ArrayList<>();
        while (!frontier.isEmpty()) {
            Node current = frontier.poll();
            if (current.getLabel().equals(start)) {
                started = true;
                frontier.clear();
                explored.clear();
                current.setParent(null);
            }
            if (current.getLabel().equals(goal) && started) {
                return current;
            }
            explored.add(current);
            List<Node> childs = current.getChildrenNodes();
            for (Node child : childs) {
                if (!frontier.contains(child) && !explored.contains(child)) {
                    frontier.add(child);
                    child.setParent(current);
                }
            }
        }
        return null;
    }
}
