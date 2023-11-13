package student;

public class Test {
    public static void main(String[] args) {
        HillClimbingSearchNQueen al = new HillClimbingSearchNQueen();
        al.executeHillClimbingWithRandomRestart(al.getNode()).displayBoard();
    }
}