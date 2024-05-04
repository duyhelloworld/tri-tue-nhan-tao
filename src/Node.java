public class Node {
    
    String name;
    Integer g;
    final Integer h;
    boolean isGoal;

    public Node(String name, int h, boolean isGoal) {
        this.h = h;
        this.g = 0;
        this.name = name;
        this.isGoal = isGoal;
    }

    @Override
    public boolean equals(Object obj) {
        Node node = (Node) obj;
        return name.equals(node.name) && g == node.g;
    }

    public Integer getF() {
        return g + h;
    }

    @Override
    public String toString() {
        return name +
            " (h=" + h +
            ", g=" + g +
            ", f=" + getF() +
            ", isGoal=" + isGoal +
            ")";
    }
}