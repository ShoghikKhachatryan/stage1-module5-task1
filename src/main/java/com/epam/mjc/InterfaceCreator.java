package com.epam.mjc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class InterfaceCreator {

    public Predicate<List<String>> isValuesStartWithUpperCase() {
        return x -> {
          for (String item : x) {
              if (item.compareTo(item.toUpperCase()) != 0) {
                return false;
              }
          }

          return true;
        };
    }

    public Consumer<List<Integer>> addEvenValuesAtTheEnd() {
        return x -> {
            int length = x.size();
            for (int i = 0; i < length; i++) {
                int item = x.get(i);
                if ( item % 2 == 0) {
                    x.add(item);
                }
            }
        };
    }

    public Supplier<List<String>> filterCollection(List<String> values) {
        return  () -> {
            List<String> result = new ArrayList<>();

            for (String item : values) {
                String[] words = item.split(" ");

                String lastWord = words[words.length - 1];

                if (words.length < 4) {
                    continue;
                }

                if (words[0].charAt(0) > 90 || words[0].charAt(0) < 65) {
                    continue;
                }


                if ((lastWord.charAt(lastWord.length() - 1)) != '.') {
                    continue;
                }

                result.add(item);
            }

            return result;
        };
    }

    public Function<List<String>, Map<String, Integer>> stringSize() {
        return x -> {
            Map<String, Integer> result = new HashMap<>();
            for (String item : x) {
                result.put(item, item.length());
            }
            return result;
        };
    }

    public BiFunction<List<Integer>, List<Integer>, List<Integer>> concatList() {
        return (list1, list2) -> {
            List<Integer> result = new ArrayList<>();

            result.addAll(list1);
            result.addAll(list2);

            return result;
        };
    }
}
