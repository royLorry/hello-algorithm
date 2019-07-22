public class LRU2 {
    private static class KV {
        private int key;
        private int value;
        private KV next;

        public KV(int key, int value, KV next){
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    private int size = 0;
    private int maxCapacity = 0;
    private KV first;
    private KV last;

    public LRUCache(int capacity) {
        this.maxCapacity = capacity;
    }

    public int get(int key) {

    }

    public void put(int key, int value) {
        KV current = first;
        for (int i = 0; i < this.size; i++) {
            
        }
        // 一次遍历完毕未找到，新建并放到第一位
        if (first == null) {
            KV input = new KV(key, value, null);
            input.next = input;
            first = input;
            last = input;
        } else {
            KV input = new KV(key, value, first);
            last.next = input;
            first = input;
        }
        this.size++;
        if (this.size > this.maxCapacity) {
            first.before.before.next = first;
            first.before = first.before.before;
            this.size--;
        }
    }

}