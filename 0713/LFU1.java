public class LFU1 {

    //*
    static class Node {
        int key;
        int val;
        int freq;
        Node next;
        Node pre;
        void remove() {
            pre.next = next;
            next.pre = pre;
        }
        void insert(Node insertPoint) {
            next = insertPoint;
            pre = insertPoint.pre;
            pre.next = next.pre = this;
        }
    }

    Node head = new Node();
    Map<Integer, Node> keyMap = new HashMap<>();
    List<Node> freqMap = new ArrayList<>();
    int cap;

    public LFUCache(int capacity) {
        cap = capacity;
        head.freq = -1;
        head.pre = head.next = head;
        freqMap.add(null);
    }
    
    public int get(int key) {
        Node n = keyMap.get(key);
        if (n == null) {
            return -1;
        }

        increseFreq(n);
        return n.val;
    }
    
    public void put(int key, int value) {
        Node n = keyMap.get(key);
        if (n == null) {
            if (keyMap.size() < cap) {
                n = new Node();
                n.insert(head);
            } else {
                n = head.pre;
                if (n == head) return;
                keyMap.remove(n.key);
                if (freqMap.get(n.freq) == n) {
                    freqMap.set(n.freq, null);
                }
            }
            n.key = key;
            n.freq = 0;
            keyMap.put(key, n);
        }
        n.val = value;

        increseFreq(n);
    }

    void increseFreq(Node n) {
        if (freqMap.get(n.freq) == n) {
            if (n.freq != n.next.freq) {
                freqMap.set(n.freq, null);
            } else {
                freqMap.set(n.freq, n.next);
            }
        }
        ++n.freq;
        while (freqMap.size() <= n.freq) {
            freqMap.add(null);
        }
        Node start = freqMap.get(n.freq);
        if (start == null) {
            start = freqMap.get(n.freq - 1);
        }
        if (start != null) {
            n.remove();
            n.insert(start);
        }

        freqMap.set(n.freq, n);
    }
    
}