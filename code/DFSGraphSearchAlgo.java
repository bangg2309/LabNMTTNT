package k18;

import java.util.*;

public class DFSGraphSearchAlgo implements ISearchAlgo {
    @Override
    public Node execute(Node tree, String goal) {
        Stack<Node> frontier = new Stack<>();
        frontier.add(tree);
        List<Node> explored = new ArrayList<>();
        while (!frontier.isEmpty()) {
            Node leaf = frontier.pop();
            if (leaf.getLabel().equals(goal)) {
                return leaf;
            }
            explored.add(leaf);
            List<Node> childs = leaf.getChildrenNodes();
            int size = childs.size();
            for (int i = size - 1; i>=0; i -- )      {
                if (!frontier.contains(childs.get(i)) && !explored.contains(childs.get(i))) {
                    frontier.add(childs.get(i));
                    childs.get(i).setParent(leaf);
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
        ArrayList<Node> explored = new ArrayList<>();
        while (!frontier.isEmpty()){
            Node current = frontier.pop();
            if (current.getLabel().equals(start)){
                started = true;
                frontier.clear();
                explored.clear();
                current.setParent(null);
            }
            if (current.getLabel().equals(goal) && started){
                return current;
            }

            explored.add(current);
            List<Node> childs = current.getChildrenNodes();
            int size = childs.size();
            for (int i = size - 1; i>=0; i -- )      {
                if (!frontier.contains(childs.get(i)) && !explored.contains(childs.get(i))) {
                    frontier.add(childs.get(i));
                    childs.get(i).setParent(current);
                }
            }
        }
        return null;
    }
}
