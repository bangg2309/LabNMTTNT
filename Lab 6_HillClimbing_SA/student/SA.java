package student;

public class SA {
    private Node node;
    public SA() {
        this.node = new Node();
        this.node.generateBoard();
    }


    public Node getNode() {
        return node;
    }

    public Node excute(Node initialState){
        Node cur=initialState;
        Node next=null;
        int T=1000;
        while(cur.getH()!=0){
            if(T==0) break;
            next=cur.selectNextRandomCandidate();
            int deltaE= next.getH()-cur.getH();
            if (deltaE<0){
                cur=next;
            }else if(Math.exp(deltaE/1000)>Math.random()){
                cur=next;
            }
            T--;
        }

        return cur;
    }
}