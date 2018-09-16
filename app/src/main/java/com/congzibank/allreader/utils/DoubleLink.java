package com.congzibank.allreader.utils;

/**
 * moni java linkedlist
 */
public class DoubleLink<T> {

    private DNode mHead;
    private int count;
    private class DNode<T> {
        public T val;
        public DNode pre;
        public DNode next;

        public DNode(T val, DNode pre, DNode next) {
            this.val = val;
            this.pre = pre;
            this.next = next;
        }
    }


    public DoubleLink() {
        mHead = new DNode(null, null, null);
        count = 0;
        mHead.pre = mHead;
        mHead.next = mHead;
    }

    public int getCount() {
        return count;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    private DNode<T> getNode(int index) {
        if (index < 0 || index > count) {
            return null;
        }
        if(index < count / 2) {
            DNode<T> node = mHead.next;
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
            return node;
        } else {
          DNode<T> preNode = mHead.pre;
          for (int j = count - 1; j > index; j--) {
              preNode = preNode.pre;
          }
            return preNode;
        }
    }

    public T get(int index) {
        return  getNode(index).val;
    }

    public T getFirst() {
        return getNode(0).val;
    }

    public T getLast() {
        return getNode(count - 1).val;
    }

    public void insert(int index, T val) {
        if (count == 0) {
            DNode<T> node = new DNode<>(val, mHead, mHead.next);
            mHead.next.pre = node;
            mHead.next = node;
            count++;
            return;
        }
        DNode<T> inode = getNode(index);
        DNode<T> hnode = new DNode(val, inode.pre, inode);
        inode.pre = hnode;
        inode.pre.next = hnode;
        count++;
        return;
    }

    public void insetFirst(T val) {
        insert(0, val);
    }

    public void appendLast(T val) {
        DNode<T> lastNode = new DNode<>(val, mHead.pre, mHead);
        mHead.pre.next = lastNode;
        mHead.pre = lastNode;
        count++;
    }

    public void del(int index) {
        DNode<T> delNode = getNode(index);
        delNode.pre.next = delNode.next;
        delNode.next.pre = delNode.pre;
        delNode = null;
        count--;
    }
    // 删除第一个节点
    public void deleteFirst() {
        del(0);
    }

    // 删除最后一个节点
    public void deleteLast() {
        del(count - 1);
    }
}
