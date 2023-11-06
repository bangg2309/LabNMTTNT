package puzzle_8.student;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class AStarAlgo implements IPuzzleAlgo {
    @Override
    public Node execute(Puzzle model) {
        PriorityQueue<Node> frontier = new PriorityQueue<>(PuzzleUtils.HeuristicComparatorByF);
        List<Node> explored = new ArrayList<>();
        Node init = model.getInitialState();
        frontier.add(init);
        while (!frontier.isEmpty()) {
            Node chosen = frontier.poll();
            if (model.computeH2(chosen) == 0) return chosen;
            else {
                explored.add(chosen);
                List<Node> children = model.getSuccessors(chosen);
                for (Node child : children) {
                    if (!frontier.contains(child) && !explored.contains(child)) {
                        child.setG(chosen.getG() + 1);
                        frontier.add(child);
                    } else {
                        if (frontier.contains(child) && chosen.getF() < child.getF()) {
                            child.setG(chosen.getG() + 1);
                            frontier.add(child);
                        }
                    }
                }
            }
        }
        return null;
    }
}
