package com.github.sobornovdev.caravans.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public final class InMemoryInventory implements Inventory {

  private final Map<GoodType, Integer> inventory;

  private InMemoryInventory(Map<GoodType, Integer> inventory) {
    this.inventory = inventory;
  }

  public static Inventory of(Map<GoodType, Integer> inventory) {
    Objects.requireNonNull(inventory);
    for (Map.Entry<GoodType, Integer> entry : inventory.entrySet()) {
      validate(entry.getKey(), entry.getValue());
    }
    return new InMemoryInventory(new HashMap<>(inventory));
  }

  public static Inventory empty() {
    return new InMemoryInventory(new HashMap<>());
  }

  @Override
  public void add(GoodType goodType, int qty) {
    validate(goodType, qty);
    int current = getCount(goodType);
    inventory.put(goodType, current + qty);
  }

  @Override
  public int removeUpTo(GoodType goodType, int qty) {
    validate(goodType, qty);
    int current = getCount(goodType);
    if (current <= qty) {
      inventory.remove(goodType);
    } else {
      inventory.put(goodType, current - qty);
    }
    return Math.min(qty, current);
  }

  @Override
  public int getCount(GoodType goodType) {
    Objects.requireNonNull(goodType, "goodType");
    return inventory.getOrDefault(goodType, 0);
  }

  private static void validate(GoodType good, int qty) {
    Objects.requireNonNull(good, "goodType");
    if (qty <= 0) {
      throw new IllegalArgumentException("Qty must be positive: " + qty);
    }
  }
}
