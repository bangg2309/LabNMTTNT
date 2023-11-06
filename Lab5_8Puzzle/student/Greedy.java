package puzzle_8.student;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Greedy implements IPuzzleAlgo {
    @Override
    public Node execute(Puzzle model) {
        Queue<Node> frontier = new PriorityQueue<>(PuzzleUtils.HeuristicComparatorByH);
        List<Node> explored = new ArrayList<>();
        frontier.add(model.getInitialState());
        while (!frontier.isEmpty()) {
            Node curr = frontier.poll();
            if (curr.getH() == 0) return curr;
            else {
                explored.add(curr);
                List<Node> children = model.getSuccessors(curr);
                for (Node child : children) {
                    if (!frontier.contains(child) && !explored.contains(child)) {
                        frontier.add(child);
                        child.setG(curr.getG() + 1);
                    }
                }
            }
        }
        return null;
    }
}
