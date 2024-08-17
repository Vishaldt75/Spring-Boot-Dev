package Streams;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class StreamListMain {
    public static void main(String[] args) {
        List<String> stringList = Arrays.asList("Pen","Paper","Pen","Paper","Pen","Book");
        System.out.println(stringList.stream().collect(Collectors.groupingBy(a->a, Collectors.counting())));
    }
}
