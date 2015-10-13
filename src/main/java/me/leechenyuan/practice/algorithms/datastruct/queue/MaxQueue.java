package me.leechenyuan.practice.algorithms.datastruct.queue;

/**
 * * Created by lee chenyuan on 2015/10/11.
 */
public interface MaxQueue<T extends  Comparable<T>> {
    public void insert(T t); //������ݽṹ���Զ�̬���ݣ�insert����void�ȷ���boolean��
    public T getMax();
    public T deleteMax();
    public boolean isEmpty();
    public int size();
}
