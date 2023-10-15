package k18;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFSTreeSearchAlgo implements ISearchAlgo {
    @Override
    public Node execute(Node tree, String goal) {
        Queue<Node> frontier = new LinkedList<>();
        frontier.add(tree);
        while (!frontier.isEmpty()){
            Node current = frontier.poll();
            if (current.getLabel().equals(goal)){
                return current;
            }
            List<Node> childrenNodes = current.getChildrenNodes();
            for (Node childNode : childrenNodes) {
                if (frontier.contains(childNode)) {
                    Node nodeNew = childNode.clone();
                    nodeNew.setParent(current);
                    frontier.add(nodeNew);
                }
               else {
                    frontier.add(childNode);
                    childNode.setParent(current);
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
        while (!frontier.isEmpty()){
            Node current = frontier.poll();

            if (current.getLabel().equals(start)){
                started = true;
                frontier.clear();
            }
            if (current.getLabel().equals(goal) && started){
                return current;
            }

            List<Node> childsNode = new ArrayList<>();
            for (Node child : childsNode){

                if (frontier.contains(child)){
                    Node nodeNew = child.clone();
                    nodeNew.setParent(current);
                    frontier.add(nodeNew);
                }
                else {
                    child.setParent(current);
                    frontier.add(child);
                }
            }
        }

        return null;
    }
}
