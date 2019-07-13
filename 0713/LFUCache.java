public class LFUCache {

    private class Node {
        public int key;
        public int value;
        public int count;
        public Node preNode;
        public Node nextNode;
        public Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.count = 1;
        }

        public Node() {
            this.key = 0;
            this.value = 0;
            this.count = 0;
        }
    }

    private Node head = new Node();
    private Node tail = new Node();
    Map<Integer, Node> cache;
    final int CAPACITY;

    public LFUCache(int capacity) {
        this.CAPACITY = capacity;
        cache = new HashMap<>(capacity);
        head.nextNode = tail;
        tail.preNode = head;
    }
    
    public int get(int key) {
        Node node = cache.get(key);
        if (node != null) {
            //count++ 并且移动
            node.count++;
            Node insertPositioNode = findInsertPosition(node.count, node);
            remove(node);
            insert(node, insertPositioNode);
            return node.value;
        } else {
            return -1;
        }
    }
    
    public void put(int key, int value) {
        Node node = cache.get(key);
        if (node != null) {
            node.value = value;
            node.count++;
            Node insertPositioNode = findInsertPosition(node.count, node);
            remove(node);
            insert(node, insertPositioNode);
        } else {
            if (CAPACITY == 0) {
                return;
            } else if (cache.size() == CAPACITY) {
                Node least = tail.preNode;
                cache.remove(least.key);
                remove(tail.preNode);
            }
            node = new Node(key, value);
            cache.put(key, node);
            Node insertPositioNode = findInsertPosition(node.count, tail);
            insert(node, insertPositioNode);
        }
    }

    /**
     * 
     * @param count
     *          给操作数为该值的节点找到插入的位置
     * @param start
     *          从何处开始找，新节点从队尾tail开始，更新的节点从原位置开始向前找
     * @return
     */
    private Node findInsertPosition(int count, Node start){
        Node iNode = start.preNode;
        while (iNode != head) {
            if (iNode.count > count) {
                return iNode;
            } else {
                iNode = iNode.preNode;
            }
        }
        return head;
    }

    /**
     * 
     * @param node
     *          待插入的节点
     * @param insertPositioNode
     *          在该位置后插入
     * 
     */
    private void insert(Node node, Node insertPositioNode) {
        insertPositioNode.nextNode.preNode = node;
        node.nextNode = insertPositioNode.nextNode;
        insertPositioNode.nextNode = node;
        node.preNode = insertPositioNode;
    }

    private void remove(Node node){
        Node preNode = node.preNode;
        Node nextNode = node.nextNode;
        preNode.nextNode = nextNode;
        nextNode.preNode = preNode;
    }

}