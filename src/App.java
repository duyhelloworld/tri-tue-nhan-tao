import java.util.*;

public class App {
    private Queue<Node> MO = new ArrayDeque<>();
    private List<Node> DONG = new LinkedList<>();
    private List<Graph> GRAPH = new LinkedList<>();

    // Hàm logic chính
    private void find() {
        int n = 0;
        while (!MO.isEmpty()) {
            System.out.println("Bước " + ++n); 
            Node s = getmo();
            System.out.println("S = " + s);
            
            List<Node> children = getChild(s);
            for (Node child : children) {
                System.out.println("Distance " + s.name + " -> " + child.name + " : " + getDistance(s, child));
            }
        }
    }

    // Hàm getmo trong ví dụ của cô. ở đây lấy phần tử FIFO
    private Node getmo() {
        if (MO.isEmpty()) {
            return null;
        }
        return MO.poll();
    }

    // Hàm tính khoảng cách giữa 2 node bất kì
    private int getDistance(Node from, Node to) {
        int g = 0;
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