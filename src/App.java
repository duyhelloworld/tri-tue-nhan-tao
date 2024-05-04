import java.util.*;

public class App {
    private List<Node> MO = new LinkedList<>();
    private List<Node> DONG = new LinkedList<>();
    private List<Graph> GRAPH = new LinkedList<>();
    private List<Node> NODE = new LinkedList<>();

    // Hàm logic chính
    private void find(Node root) {
        int n = 0;
        MO.add(root);
        while (!MO.isEmpty()) {
            System.out.println("Bước " + ++n); 
            Node s = getmo();
            DONG.add(s);
            System.out.println("S = " + s);

            if (s.isGoal) {
                System.out.println("Tìm kiếm thành công : " + s);
                System.out.println("MO = " + MO);
                System.out.println("DONG = " + DONG);
                return;
            }

            List<Node> children = getChild(s);
            if (!children.isEmpty()) {
                for (Node child : children) {
                    System.out.print("Child : " + child);
                    int disChildS = getDistance(child, s);
                    int disRootS = getDistance(root, s);
                    int f = disChildS + child.h + disRootS;
                    child.f = f;
                    if (!MO.contains(child) && !DONG.contains(child)) {
                        System.out.println("Add new node to MO : " + child);
                        MO.add(child);
                    }
                    for (Node node : MO) {
                        if (node.equals(child) && node.f > child.f) {
                            System.out.println("Update f of " + node);
                            MO.remove(node);
                            MO.add(child);
                        }
                    }
                    System.out.println("Distance S(" + s.name + ") -> Child(" + child.name + ") : " + disChildS);
                    System.out.println("Distance Root(" + root.name + ") -> S(" + s.name + ") : " + disRootS);
                    System.out.println("\tf = " + f + "\n");
                }
            }
        }
    }

    private void sortMo() {
        if (MO.isEmpty()) {
            System.out.println("MO trống");
            return;
        }
        MO.sort((n1, n2) -> n1.f.compareTo(n2.f));
    }

    // Hàm getmo. ở đây lấy phần tử có số f nhỏ nhất
    private Node getmo() {
        if (MO.isEmpty()) {
            return null;
        }
        sortMo();
        int index = 0;
        Node result = MO.get(index);
        while (DONG.contains(result)) {
            result = MO.get(index++);
        }
        return result;
    }

    // Hàm tính khoảng cách giữa 2 node bất kì
    private int getDistance(Node from, Node to) {
        int g = 0;
        if (from.equals(to)) {
            return 0;
        }
        for (Graph graph : GRAPH) {
            if (from.equals(graph.node1)) {
                if (to.equals(graph.node2)) {
                    return graph.distance;
                }
                return graph.distance + getDistance(graph.node2, to);
            } else if (from.equals(graph.node2)) {
                if (to.equals(graph.node1)) {
                    return graph.distance;
                }
            }
        }
        return g;
    }

    // Hàm tìm các con của node
    private List<Node> getChild(Node node) {
        List<Node> response = new LinkedList<>();
        for (Graph distance : GRAPH) {
            if (distance.node1.equals(node)) {
                response.add(distance.node2);
            }
            if (distance.node2.equals(node)) {
                response.add(distance.node1);
            }
        }
        return response;
    }

    // Main 
    public static void main(String[] args) {
        App app = new App();
        Node root = app.init();
        // System.out.println(app.MO);
        app.find(root);
    }

    // Bộ dữ liệu mẫu
    private Node init() {
        Node a = new Node("A", 14, false);
        Node b = new Node("B", 10, false);
        Node c = new Node("C", 10, false);
        Node d = new Node("D", 5, false);
        Node e = new Node("E", 5, false);
        Node f = new Node("F", 4, false);
        Node g = new Node("G", 4, false);
        Node h = new Node("H", 0, true);
        NODE.addAll(List.of(a, b, c, d, e, f, g, h));

        GRAPH.add(new Graph(a, b, 5));
        GRAPH.add(new Graph(a, d, 7));
        GRAPH.add(new Graph(a, c, 3));
        GRAPH.add(new Graph(c, d, 2));
        GRAPH.add(new Graph(c, e, 4));
        GRAPH.add(new Graph(d, e, 6));
        GRAPH.add(new Graph(e, g, 5));
        GRAPH.add(new Graph(b, f, 7));
        GRAPH.add(new Graph(b, h, 12));
        GRAPH.add(new Graph(e, f, 3)); 
        GRAPH.add(new Graph(f, g, 2));
        GRAPH.add(new Graph(h, g, 3));

        // return root
        return a;
    }
}