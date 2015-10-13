package me.leechenyuan.practice.algorithms.datastruct.queue;

import java.util.Arrays;

/**
 * * Created by lee chenyuan on 2015/10/11.
 */
public class MaxHeap<T extends Comparable<T> > implements MaxQueue<T>{
    final static int HEAD_INDEX = 1 ;
    final static int DEFAULT_INTI_SIZE  = 16 ;
    T [] heapArray;
    int tailf  = 1 ; //���һ��Ԫ�ص�����+1 ,�൱�ڷ�Χ����� end

//    public MaxHeap(T [] arr,int size){
//        heapArray =(T [])new  Comparable<T> [currentSize]; //TODO ��仰Ϊʲô���У�
//        heapArray =(T [])new  Comparable [size];
//    }

    public MaxHeap(){
        heapArray = (T [])new  Comparable [DEFAULT_INTI_SIZE];
    }
    public MaxHeap(int size){
//        heapArray =(T [])new  Comparable [size]; // �������� heapArray[0] �Ǳ���λ��...
        heapArray =(T [])new  Comparable [size + 1];
    }
    @Override
    public void insert(T t) {
        if(tailf >= heapArray.length){
            // ��������
            heapArray = Arrays.copyOf(heapArray,heapArray.length * 2);
        }
        heapArray[tailf++] = t ;

        swim(tailf - 1 );
    }

    @Override
    public T getMax() {
        return heapArray[HEAD_INDEX];
    }

    @Override
    public T deleteMax() {
        T max = heapArray[HEAD_INDEX];
        /**
         *  TODO Ϊʲô������Ԫ�طŵ��ѵĶ�����Ȼ�����³� ��
         */
        swap(tailf - 1,HEAD_INDEX);
//        sink(HEAD_INDEX);  ��һ�б����� tailf -- ����
//        tailf -- ; // ������©�����.....
        tailf -- ; // ������©�����.....
        sink(HEAD_INDEX);
        return max;
    }

    @Override
    public boolean isEmpty() {
        return tailf == 1;
    }

    @Override
    public int size() {
        return tailf - 1;
    }

    /**
     * ��Ԫ���ϸ�
     * ����ʵ��������Ҫ!!!
      * @param index
     */
    private void swim(int index){
        int parennt = index /2 ;
        while(index > HEAD_INDEX && lessThan(parennt,index)){
            swap(index,parennt);
            index = parennt ;
            parennt = parennt / 2 ;
        }
    }
    /**
     * ��Ԫ���³�
     * ��������Ū�����ĵط�
     *      �� ������ô֪���������Ԫ���м�����Ԫ�أ�
     *      �� �����������Ԫ�أ����ǵ��׺��ĸ����н��� �� ��������ʲô��
     *
     * @param index
     */
    private void sink(int index){
        int childIndex ;
        while (hasChild(index)){
            childIndex = index << 1;
            if( ((childIndex+1) < tailf) && lessThan(childIndex,childIndex+1)){
                childIndex ++ ;
            }
            if(!lessThan(index,childIndex)){
                break;
            }
            swap(index,childIndex);
            index = childIndex ;
        }
    }
//        int childIndex = index << 1;
//        while(hasChild(index) && lessThan(index,childIndex) ){ // �к��ӣ�����С�ں��ӵ�����²��³�
//            swap(index,childIndex);
//
//            index = childIndex ;
//            childIndex = index << 1; //TODO Ϊʲôÿ�ζ�ֻ���� index*2���child��������index*2+1�����child ?
//        }
//    }

    private boolean hasChild(int index){
//        return currentSize >= (index << 1); ���� >= ���� >
        return tailf > (index << 1);
    }

    private boolean lessThan(int aIndex,int bIndex){
        return heapArray[aIndex].compareTo(heapArray[bIndex]) < 0;
    }

    private void swap(int aIndex,int bIndex){
        T tmp = heapArray[aIndex];
        heapArray[aIndex] = heapArray[bIndex];
        heapArray[bIndex] = tmp ;
    }



}
