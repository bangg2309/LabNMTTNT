package k18;

import java.util.List;
import java.util.Stack;

public class DFSTreeSearchAlgo implements ISearchAlgo{

    @Override
    public Node execute(Node tree, String goal) {
        Stack<Node> frontier = new Stack<>();
        frontier.add(tree);
        while (!frontier.isEmpty()) {
            Node leaf = frontier.pop();
            if (leaf.getLabel().equals(goal)) {
                return leaf;
            }
            List<Node> childs = leaf.getChildrenNodes();
            int size = childs.size();
            for (int i = size - 1; i>=0; i -- ) {
                Node childNode = childs.get(i);
                if (frontier.contains(childNode)){
                    Node newNode = childNode.clone();
                    frontier.add(newNode);
                    newNode.setParent(leaf);
                }
                else {
                    frontier.add(childNode);
                    childNode.setParent(leaf);
                }
            }
        }
        return null;
    }

    @Override
    public Node execute(Node tree, String start, String goal) {
        Stack<Node> frontier = new Stack<>();
        frontier.add(tree);
        boolean started = false;
        while (!frontier.isEmpty()) {
            Node leaf = frontier.pop();
            if (leaf.getLabel().equals(start)){
                frontier.clear();
                started = true;
            }

            if (leaf.getLabel().equals(goal) && started) {
                return leaf;
            }
            List<Node> childs = leaf.getChildrenNodes();
            int size = childs.size();
            for (int i = size - 1; i>=0; i -- ) {
                Node childNode = childs.get(i);
                if (frontier.contains(childNode)){
                    Node newNode = childNode.clone();
                    frontier.add(newNode);
                    newNode.setParent(leaf);
                }
                else {
                    frontier.add(childNode);
                    childNode.setParent(leaf);
                }
            }
        }
        return null;
    }
}
