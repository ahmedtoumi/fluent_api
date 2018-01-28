package com.atoumi.fluentapi.list;

import com.atoumi.fluentapi.function.Aggregate;
import com.atoumi.fluentapi.function.Predicate;
import com.atoumi.fluentapi.function.Transform;

import java.util.List;

/**
 * @author Created by ahmed.ettoumi@gmail.com
 * @since 27/01/18.
 */
public interface FluentList<T> extends List<T> {

  FluentList<T> selectWith(Predicate<T> predicate);

  FluentList<T> transform(Transform<T> transform);

  FluentList<T> distinct();

  FluentList<T> sort();

  T aggregate(Aggregate<T> aggregate);
}
