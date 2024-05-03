public class Node {
    
    String name;
    int h, f;
    boolean isGoal;

    public Node(String name, int h, boolean isGoal) {
        this.h = h;
        this.f = 0;
        this.name = name;
        this.isGoal = isGoal;
    }

    @Override
    public boolean equals(Object obj) {
        return name.equals(((Node) obj).name);
    }

    @Override
    public String toString() {
        return "Node " + name +
            " (h=" + h +
            ",isGoal=" + isGoal + "" +
            ")\n";
    }
}