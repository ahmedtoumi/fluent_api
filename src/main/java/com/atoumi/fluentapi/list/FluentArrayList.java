package com.atoumi.fluentapi.list;

import com.atoumi.fluentapi.function.Aggregate;
import com.atoumi.fluentapi.function.Predicate;
import com.atoumi.fluentapi.function.Transform;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Created by ahmed.ettoumi@gmail.com
 * @since 27/01/18.
 */
public class FluentArrayList<T> extends ArrayList<T> implements FluentList<T> {

  public static <T> FluentList<T> fromList(List<T> list) {
    FluentList<T> fluentList = new FluentArrayList<>();
    fluentList.addAll(list);
    return fluentList;
  }

  @Override
  public FluentList<T> selectWith(Predicate<T> predicate) {
    FluentList<T> fluentList = new FluentArrayList<>();

    for (T item : this) {
      if (predicate.matches(item)) {
        fluentList.add(item);
      }
    }
    return fluentList;
  }

  @Override
  public FluentList<T> transform(Transform<T> transform) {
    FluentList<T> fluentList = new FluentArrayList<>();

    for (T item : this) {
      fluentList.add(transform.transform(item));
    }

    return fluentList;
  }

  @Override
  public FluentList<T> distinct() {
    Set<T> set = new HashSet<>(this);

    FluentList<T> fluentList = new FluentArrayList<>();
    fluentList.addAll(set);

    return fluentList;
  }

  @Override
  public FluentList<T> sort() {
    FluentList<Comparable> fluentList = new FluentArrayList<>();
    fluentList.addAll((List<Comparable>) this);

    Collections.sort(fluentList);

    return (FluentList<T>) fluentList;
  }

  @Override
  public T aggregate(Aggregate<T> aggregate) {
    return aggregate.aggregate(this);
  }
}
