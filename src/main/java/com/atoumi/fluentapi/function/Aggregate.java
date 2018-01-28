package com.atoumi.fluentapi.function;

import java.util.Collection;

/**
 * @author Created by ahmed.ettoumi@gmail.com
 * @since 27/01/18.
 */
public interface Aggregate<T> {

  T aggregate(Collection<T> item);
}
