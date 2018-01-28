package com.atoumi.fluentapi.function;

/**
 * @author Created by ahmed.ettoumi@gmail.com
 * @since 27/01/18.
 */
public interface Transform<T> {

  T transform(T item);
}
