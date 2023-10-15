package k18;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DepthLimitedSearch {


    public Node execute(Node tree, String goal, int limitedDept) {
        Stack<Node> frontier = new Stack<>();
        List<Node> explored = new ArrayList<>();
        frontier.push(tree);
        while (!frontier.isEmpty()) {
            Node currentNode = frontier.pop();
            if (currentNode.getLabel().equals(goal)) {
                return currentNode;
            } else if (currentNode.getDepth() < limitedDept) {
                List<Node> childrenNodes = currentNode.getChildrenNodes();
                int Nodeslength = childrenNodes.size();

                for (int i = Nodeslength - 1; i >= 0; i--) {
                    Node childNode = childrenNodes.get(i);
                    if (!frontier.contains(childNode) && !explored.contains(childNode)) {
                        frontier.add(childNode);
                        explored.add(childNode);
                        childNode.setParent(currentNode);
                        childNode.setDepth(currentNode.getDepth() + 1);
                    }
                }
            }
        }
        return null;
    }
}
