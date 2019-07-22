import java.util.LinkedHashMap;

public class LRU {

    private LinkedHashMap linkedHashMap;
    private int maxCapacity;

    public LRUCache(int capacity) {
        this.linkedHashMap = new LinkedHashMap<>(capacity,0.75f,true);
        this.maxCapacity = capacity;
    }
    
    public int get(int key) {
        if (linkedHashMap.containsKey(key)) {
            // LinkedHashMap会自动将最新访问的值移动值链表尾部
            int value = linkedHashMap.get(key);
        } else {
            return -1;
        }
    }
    
    public void put(int key, int value) {
        // 判断存在
        // 不存则新增,新增时判断是否超过长度,超过则将链表尾部删除
    }
}