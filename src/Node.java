public class Node {
    
    String name;
    Integer f;
    final Integer h;
    boolean isGoal;

    public Node(String name, int h, boolean isGoal) {
        this.h = h;
        this.f = 0;
        this.name = name;
        this.isGoal = isGoal;
    }

    @Override
    public boolean equals(Object obj) {
        Node node = (Node) obj;
        return name.equals(node.name) && f == node.f;
    }

    @Override
    public String toString() {
        return name +
            " (h=" + h +
            ", f=" + f +
            ",isGoal=" + isGoal + "" +
            ")";
    }
}