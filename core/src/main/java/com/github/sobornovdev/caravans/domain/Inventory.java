package com.github.sobornovdev.caravans.domain;

public interface Inventory {
  void add(GoodType goodType, int qty);
  int removeUpTo(GoodType goodType, int qty);
  int getCount(GoodType goodType);
}
