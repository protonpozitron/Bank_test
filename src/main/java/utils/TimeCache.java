package utils;

import java.util.HashMap;
import java.util.Map;

public class TimeCache {
    private Map<String, LinkedNode> cache;
    private int cap;
    private int size;
    private LinkedNode head, tail;

    public TimeCache(int cap) {
        this.cap = cap;
        cache = new HashMap<>(cap);
        head = new LinkedNode();
        tail = new LinkedNode();
        head.next = tail;
        tail.prev = head;
    }

    public String get(String key) {
        LinkedNode elem = cache.get(key);
        if (elem == null) return "Такой элемент не сохранен в кэше.";
        removeCache(elem);
        modeTohead(elem);

        return elem.value;
    }

    public void put(String key, String value) {
        LinkedNode node = cache.get(key);
        if (node != null) {
            node.value = value;
            removeCache(node);
            modeTohead(node);
        } else {
            node = new LinkedNode();
            node.value = value;
            node.key = key;
            cache.put(key, node);
            modeTohead(node);
            size++;
            if (size > cap) {
                cache.remove(tail.prev.key);
                removeCache(tail.prev);
                size--;
            }
        }
    }

    private void modeTohead(LinkedNode node) {
        LinkedNode temp = head.next;
        head.next = node;
        node.prev = head;
        node.next = temp;

        temp.prev = node;


    }

    private void removeCache(LinkedNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private class LinkedNode {
        String value;
        String key;
        LinkedNode prev;
        LinkedNode next;
    }
}
