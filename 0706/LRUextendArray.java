import java.util.LinkedHashMap;

public class LRUextendArray {

    private LinkedHashMap linkedHashMap;

    public LRUCache(int capacity) {
        linkedHashMap = new LinkedHashMap<>(capacity);
    }
    
    public int get(int key) {
        if (linkedHashMap.containsKey(key)) {
            int value = linkedHashMap.get(key);
            // 获取值并移动至链表首位
        } else {
            return -1;
        }
    }
    
    public void put(int key, int value) {
        // 判断存在
        // 不存则新增,新增时判断是否超过长度,超过则将链表尾部删除
    }
}