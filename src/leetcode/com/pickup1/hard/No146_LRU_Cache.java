package leetcode.com.pickup1.hard;

/**
 * Created by tclresearchamerica on 7/6/16.
 * ****************************************************
 * Location:
 * https://leetcode.com/problems/lru-cache/
 * ****************************************************
 * Description:
 * Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following
 * operations: get and set.
 * <p>
 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 * set(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity,
 * it should invalidate the least recently used item before inserting a new item.
 * ****************************************************
 * Thoughts:
 * 想不起来这个思路了,感觉就在脑海中.还是先从数据结构入手,HashSet,List,HashMap, 再加上单向链表,双向链表
 * 根据Key-Value pair判断,需要HashMap,因为需要在超出capacity的时候,进行删除,那么就需要另一个数据结构,协助完成工作,
 * 所以永久层就是HashMap,控制层
 * --->
 * 看了第一遍的答案后,才发现自己忘记考虑链表了,用双向链表
 * ****************************************************
 * ****************************************************
 * ****************************************************
 * ****************************************************
 * ****************************************************
 * ****************************************************
 */
public class No146_LRU_Cache {
}

class LRUCache {

    public LRUCache(int capacity) {

    }

    public int get(int key) {
        return 1;
    }

    public void set(int key, int value) {

    }
}