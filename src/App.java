import java.util.*;

public class App {
    private List<Node> MO = new LinkedList<>();
    private List<Node> DONG = new LinkedList<>();
    private List<Graph> GRAPH = new LinkedList<>();

    // Hàm logic chính
    private void find() {
        int n = 0;
        while (!MO.isEmpty()) {
            System.out.println("Bước " + ++n); 
            Node s = getmo();
            DONG.add(s);
            // System.out.println("S = " + s);
            if (s.isGoal) {
                System.out.println("Tìm kiếm thành công : " + s);
                System.out.println("MO = " + MO);
                System.out.println("DONG = " + DONG);
                return;
            }

            List<Node> children = getChild(s);
            if (!children.isEmpty()) {
                for (Node child : children) {
                    // System.out.println("Distance " + s.name + " -> " + child.name + " : " + getDistance(s, child));
                    int dis = getDistance(child, s);
                    int f = dis + child.h;
                    if (!MO.contains(child) && !DONG.contains(child)) {
                        updateF(child, f);
                    } 
                }
            }
        }
    }

    // Hàm getmo. ở đây lấy phần tử có số f nhỏ nhất
    private Node getmo() {
        if (MO.isEmpty()) {
            return null;
        }
        Node res = MO.get(0);
        for (Node node : MO) {
            if (node.f < res.f) {
                res = node;
            }
        }
        return res;
    }

    private void updateF(Node node, int f) {
        for (Node mo : MO) {
            if (mo.equals(node)) {
                mo.f = f;
            }
        }
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
        app.init();
        // System.out.println(app.MO);
        app.find();
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
        MO.addAll(List.of(a, b, c, d, e, f, g, h));

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