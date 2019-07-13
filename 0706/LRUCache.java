import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    private class Node {
        public int key;
        public int value;
        public Node preNode;
        public Node nextNode;
        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }

        public Node() {
            this.key = 0;
            this.value = 0;
        }
    }

    private Node head = new Node();
    private Node tail = new Node();
    Map<Integer, Node> cache;
    final int CAPACITY;

    public LRUCache(int capacity) {
        this.CAPACITY = capacity;
        cache = new HashMap<>(capacity);
        head.nextNode = tail;
        tail.preNode = head;
    }

    public int get(int key) {
        Node node = cache.get(key);
        if (node != null) {
            update(node);
            return node.value;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        Node node = cache.get(key);
        if (node != null) {
            node.value = value;
            update(node);
        } else {
            node = new Node(key, value);

            if (cache.size() == CAPACITY) {
                Node eldest = head.nextNode;
                cache.remove(eldest.key);
                remove(head.nextNode);
            }

            cache.put(key, node);
            add(node);
        }
    }

    private void update(Node node) {
        remove(node);
        add(node);
    }

    private void remove(Node node) {
        Node preNode = node.preNode;
        Node nextNode = node.nextNode;
        preNode.nextNode = nextNode;
        nextNode.preNode = preNode;
    }

    private void add(Node node) {
        Node preNode = tail.preNode;
        preNode.nextNode = node;
        node.preNode = preNode;
        node.nextNode = tail;
        tail.preNode = node;
    }
}