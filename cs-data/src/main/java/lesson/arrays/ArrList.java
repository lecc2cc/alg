package lesson.arrays;

import java.util.Arrays;

public class ArrList {

    private static final int DEFAULT_SIZE = 10;
    private int size;
    private int[] elements;

    public ArrList(int capacity) {
        capacity = capacity <= 0 ? DEFAULT_SIZE : capacity;
        elements = new int[capacity];
    }

    /**
     * 表的大小
     *
     * @return int
     */
    public int size() {
        return size;
    }

    /**
     * 是否为空表
     *
     * @return boolean
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 打印输出表
     *
     * @return string
     */
    @Override
    public String toString() {
        StringBuilder b = new StringBuilder();
        b.append("[");
        for (int i = 0; i < size; i++) {
            b.append(elements[i]);

            if (i != size - 1) {
                b.append(", ");
            }
        }
        b.append("]");
        b.append(" @");
        b.append(elements.hashCode());
        return b.toString();
    }

    /**
     * 查询元素第一次出现的下标
     *
     * @param element 查找的元素
     * @return 不存在将返回-1
     */
    public int find(int element) {
        for (int i = 0; i < size; i++) {
            if (element == elements[i]) {
                return i;
            }
        }

        return -1;
    }

    /**
     * 在指定位置添加一个元素
     *
     * @param index   指定的下标
     * @param element 添加的元素
     * @return 如果指定位置越界，将返回-1
     */
    public int add(int index, int element) {
        if (index >= size || index < 0) {
            return -1;
        }

        return insert(index, element);
    }

    /**
     * 末尾添加一个元素
     *
     * @param element 元素
     * @return 返回下标
     */
    public int append(int element) {
        return insert(size, element);
    }

    /**
     * 删除指定的元素
     *
     * @param element 元素
     * @return 返回元素第一次出现在数组中的下标，否则返回-1
     */
    public int delete(int element) {
        int index = find(element);
        if (index == -1) {
            return -1;
        }

        if (index != size - 1) {
            int numMoved = size - index - 1;
            System.arraycopy(elements, index + 1, elements, index, numMoved);
        }
        size--;

        shrink();

        return index;
    }

    /**
     * 获取指定下标的元素
     *
     * @param index 下标
     * @return 下标出界将抛出异常
     */
    public int get(int index) {
        if (index >= size || index < 0) {
            throw new ArrayIndexOutOfBoundsException("size: " + size + " ,index:" + index);
        }

        return elements[index];
    }

    private int insert(int index, int element) {
        // 先扩容
        if (size == elements.length) {
            grow();
        }
        // 整体移动
        int movedNum = size - index;
        if (movedNum > 0) {
            System.arraycopy(elements, index, elements, index + 1, movedNum);
        }
        elements[index] = element;
        size++;

        return index;
    }

    /**
     * 数组扩容2被
     */
    private void grow() {
        int[] newElements = new int[elements.length * 2];
        System.arraycopy(elements, 0, newElements, 0, elements.length);

        elements = newElements;
    }

    /**
     * 数组小于1/4时缩容
     */
    private void shrink() {
        int less = (int) (elements.length * 0.25);


        if (size < less) {
            int[] newElements = new int[less];
            System.arraycopy(elements, 0, newElements, 0, size);

            elements = newElements;
        }
    }

}
