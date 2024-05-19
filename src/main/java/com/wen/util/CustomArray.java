package com.wen.util;

interface GetItemMethod<T> {
  /**
   * 获取数组第 i 位元素的方法
   */
  T getItem(int i);
}
interface SetItemMethod<T> {
  /**
   * 设置数组第 i 位元素的方法
   */
  void setItem(int i, T value);
}

/**
 * 一个自定义的数组实现。用于一个逻辑上是数组，但实际并不是以数组形式存储的情况
 * @param <T> 数组中元素的类型
 */
public class CustomArray<T extends Comparable<T>> {
  public final int length;
  private final GetItemMethod<T> _getItem;
  private final SetItemMethod<T> _setItem;
  CustomArray( int length, GetItemMethod<T> getItem, SetItemMethod<T> setItem) {
    this.length = length;
    this._getItem = getItem;
    this._setItem = setItem;
  }

  public T getItem(int i) {
    this.indexCheck(i);
    return this._getItem.getItem(i);
  }

  public void setItem(int i, T value) {
    this.indexCheck(i);
    this._setItem.setItem(i, value);
  }

  public void sort() {
    this.sort(0, this.length - 1);
  }
  public void sort(int low, int high) {
    if (low >= high) {
      return;
    }
    int middle = (low + high) / 2;
    this.exchange(low, middle);
    this.quickSort(low, high);
  }

  private void quickSort(int low, int high) {
    if (low >= high) {
      return;
    }
    int left = low, right = high;
    while (left < right) {
      while (left < right && this.getItem(left).compareTo(this.getItem(right)) <= 0) {
        right--;
      }
      if (left < right) {
        this.exchange(left, right);
      }
      while (left < right && this.getItem(left).compareTo(this.getItem(right)) <= 0) {
        left++;
      }
      if (left < right) {
        this.exchange(left, right);
      }
    }

    this.sort(low, left - 1);
    this.sort(right + 1, high);
  }

  private void exchange(int indexA, int indexB) {
    T temp = this.getItem(indexA);
    this.setItem(indexA, this.getItem(indexB));
    this.setItem(indexB, temp);
  }

  private void indexCheck(int index) {
    if (index < 0 || index >= this.length) {
      throw new Error("访问数组元素超过了数组长度");
    }
  }
}
