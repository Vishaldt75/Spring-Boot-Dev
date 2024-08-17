package Streams;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class StreamDemo {
    public static void main(String[] args) {
        List<Players> players=new ArrayList<>();
        players.add(new Players("Player1",23,43));
        players.add(new Players("Player2",21,32));
        players.add(new Players("Player3",22,23));
        players.add(new Players("Player4",20,15));

        //double d1=players.stream().collect(Collectors.averagingDouble(Players::getScore)).doubleValue();
        //List<Players> newList=players.stream().filter(a->a.getName().contains("3")).collect(Collectors.toList());
        //players.stream().mapToInt(a-> a.getAge()).max();
        //List<Integer> newList= players.stream().map(a->a.getAge()).distinct().collect(Collectors.toList());
        //List<Players> newList= players.stream().filter(a-> a.getAge()>21).collect(Collectors.toList());

        //players.stream().filter(a->a.getAge() > 22).collect(Players::getScore, Collections.max());
        //System.out.println(newList);
    }

}
