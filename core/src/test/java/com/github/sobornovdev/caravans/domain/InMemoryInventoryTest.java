package com.github.sobornovdev.caravans.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


final class InMemoryInventoryTest {

  private Inventory inv;

  @BeforeEach
  void setUp() {
    Map<GoodType, Integer> map = new HashMap<>();
    map.put(GoodType.MILK, 3);
    inv = InMemoryInventory.of(map);
  }

  @Test
  void addShouldIncrementQty() {
    inv.add(GoodType.MILK, 3);

    assertEquals(6, inv.getCount(GoodType.MILK));
  }

  @Test
  void removeShouldDecreaseQty() {
    int count = inv.removeUpTo(GoodType.MILK, 2);

    assertEquals(1, inv.getCount(GoodType.MILK));
    assertEquals(2, count);
  }

  @Test
  void removeShouldDecreaseQtyUpToZero() {
    int count = inv.removeUpTo(GoodType.MILK, 5);

    assertEquals(0, inv.getCount(GoodType.MILK));
    assertEquals(3, count);
  }

  @Test
  void addNullGoodShouldThrowNPE() {
    Inventory inv = InMemoryInventory.empty();

    assertThrows(NullPointerException.class, () -> inv.add(null, 5));
  }

  @Test
  void getCountNullShouldThrowNPE() {
    assertThrows(NullPointerException.class, () -> inv.getCount(null));
  }

  @Test
  void getCountEmptyShouldReturnZero() {
    Inventory inv = InMemoryInventory.empty();

    assertEquals(0, inv.getCount(GoodType.MILK));
  }

  @Test
  void factoryWithNullKeyShouldThrowNPE() {
    Map<GoodType, Integer> nullMap = new HashMap<>();
    nullMap.put(null, 3);

    assertThrows(NullPointerException.class, () -> InMemoryInventory.of(nullMap));
  }

  @Test
  void factoryWithNegativeQtyShouldThrowIllegalArgument() {
    Map<GoodType, Integer> nonPositiveMap = new HashMap<>();
    nonPositiveMap.put(GoodType.MILK, -3);

    assertThrows(IllegalArgumentException.class, () -> InMemoryInventory.of(nonPositiveMap));
  }

  @Test
  void nonPositiveQtyShouldThrowIllegalArgument() {
    Inventory inv = InMemoryInventory.empty();

    assertThrows(IllegalArgumentException.class, () -> inv.add(GoodType.MILK, -3));
  }
}
