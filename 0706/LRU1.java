public class LUR1 {

    private static class KV {
        private int key;
        private int value;
        private KV before;
        private KV next;

        public KV(int key, int value, KV before, KV next){
            this.key = key;
            this.value = value;
            this.before = before;
            this.next = next;
        }
    }

    private int size = 0;
    private int maxCapacity = 0;
    private KV first;

    public LRUCache(int capacity) {
        this.maxCapacity = capacity;
    }

    public int get(int key) {
        KV current = first;
        for (int i = 0; i < this.size; i++) {
            if (key == current.key) {
                // 找到此key，移动至第一位，并返回值
                if (current != first) {
                    // 断开与前后的连接
                    current.before.next = current.next;
                    current.next.before = current.before;
                    // 移动至第一位
                    current.before = first.before;
                    first.before.next = current;
                    first.before = current;
                    current.next = first;
                    first = current;
                }
                return current.value;
            } else {
                current = current.next;
                continue;
            }
        }
        // 循环结束未找到，返回-1
        return -1;
    }
    
    public void put(int key, int value) {
        KV current = first;
        for (int i = 0; i < this.size; i++) {
            if (key == current.key) {
                // key已存在，更新，不在首位则移动至首位
                current.value = value;
                if (current != first) {
                    // 断开与前后的连接
                    current.before.next = current.next;
                    current.next.before = current.before;
                    // 移动至第一位
                    current.before = first.before;
                    first.before.next = current;
                    first.before = current;
                    current.next = first;
                    first = current;
                }
                return;
            } else {
                current = current.next;
                continue;
            }
        }
        // 一次遍历完毕未找到，新建并放到第一位
        if (first != null) {
            KV newInput = new KV(key, value, first.before, first);
            first.before.next = newInput;
            first.before = newInput;
            first = newInput;
        } else {
            KV newInput = new KV(key, value, null, null);
            newInput.before = newInput;
            newInput.next = newInput;
            first = newInput;
        }
        this.size++;
        if (this.size > this.maxCapacity) {
            first.before.before.next = first;
            first.before = first.before.before;
            this.size--;
        }
    }

}