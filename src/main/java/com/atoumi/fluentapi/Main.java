package com.atoumi.fluentapi;

import com.atoumi.fluentapi.function.Aggregate;
import com.atoumi.fluentapi.function.Predicate;
import com.atoumi.fluentapi.function.Transform;
import com.atoumi.fluentapi.list.FluentArrayList;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;


public class Main {

  public static void main(String[] args) {
    List<Integer> resultNumbersList = FluentArrayList.fromList(getNumbers())
                                                     .selectWith(isDividedBy(2))
                                                     .distinct()
                                                     .transform(multiplyBy(2))
                                                     .selectWith(isDividedBy(10))
                                                     .sort();
    for (Integer number : resultNumbersList) {
      System.out.println("Number: " + number);
    }
    //    Number: 20
    //    Number: 80
    //    Number: 180

    Integer sum = FluentArrayList.fromList(getNumbers())
                                 .selectWith(isDividedBy(2))
                                 .transform(multiplyBy(2))
                                 .aggregate(sum());

    System.out.print("Sum= " + sum);
    //    Sum= 500
  }

  private static Transform<Integer> multiplyBy(final int number) {
    return new Transform<Integer>() {
      @Override
      public Integer transform(Integer item) {
        return item * number;
      }
    };
  }

  private static Predicate<Integer> isDividedBy(final int number) {
    return new Predicate<Integer>() {
      @Override
      public boolean matches(Integer item) {
        return item % number == 0;
      }
    };
  }

  private static Aggregate<Integer> sum() {
    return new Aggregate<Integer>() {
      @Override
      public Integer aggregate(Collection<Integer> numbers) {
        int sum = 0;
        for (Integer number : numbers) {
          sum += number;
        }
        return sum;
      }
    };
  }

  private static List<Integer> getNumbers() {
    Integer[] numbers = {1, 10, 42, 9, 12, 15, 16, 90, 73, 40, 40};
    return Arrays.asList(numbers);
  }

}

