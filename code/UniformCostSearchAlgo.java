package k18;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class UniformCostSearchAlgo implements ISearchAlgo {
    @Override
    public Node execute(Node tree, String goal) {
        Queue<Node> frontier = new PriorityQueue<>();
        frontier.add(tree);
        List<Node> explored = new ArrayList<>();
        while (!frontier.isEmpty()){
            Node currentNode = frontier.poll();
            if (currentNode.getLabel().equals(goal)){
                return currentNode;
            }
            explored.add(currentNode);
            List<Edge> childsNode = currentNode.getChildren();
            for (Edge child : childsNode){
                double newPathCost = currentNode.getPathCost() + child.getWeight();
                if (!frontier.contains(child) && !explored.contains(child)){
                    frontier.add(child.getEnd());
                    child.getEnd().setParent(currentNode);
                    child.getEnd().setPathCost(newPathCost);
                }
                else if (child.getEnd().getPathCost() > newPathCost){
                    child.getEnd().setPathCost(newPathCost);
                    child.getEnd().setParent(currentNode);
                }
            }
        }
        return null;
    }

    @Override
    public Node execute(Node tree, String start, String goal) {
        return null;
    }
}
