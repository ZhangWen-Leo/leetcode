package com.wen.util;

import java.util.ArrayList;
import java.util.Collections;

public class WenArrays {
  public static <T> ArrayList<T> toArrayList(T[] array) {
    ArrayList<T> result = new ArrayList<>(array.length);
    Collections.addAll(result, array);
    return result;
  }

}
