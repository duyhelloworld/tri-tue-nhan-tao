public class Node {
    String name;
    int h;
    boolean isGoal;

    public Node(String name, int h, boolean isGoal) {
        this.h = h;
        this.name = name;
        this.isGoal = isGoal;
    }

    @Override
    public boolean equals(Object obj) {
        return name.equals(((Node) obj).name);
    }

    @Override
    public String toString() {
        return "{" +
            " name='" + name + "'" +
            ", h='" + h + "'" +
            ", isGoal='" + isGoal + "'" +
            "}";
    }
}