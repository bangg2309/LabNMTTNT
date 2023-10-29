package lab4.inform.student;

import java.util.Comparator;

public class NodeComparatorByFn implements Comparator<Node> {
    @Override
    public int compare(Node o1, Node o2) {
        Double f1 = o1.getH() + o1.getG();
        Double f2 = o2.getH() + o2.getG();
        int result = f1.compareTo(f2);
        if (result == 0) {
            return o1.getLabel().compareTo(o2.getLabel());
        } else {
            return result;
        }
    }
}
