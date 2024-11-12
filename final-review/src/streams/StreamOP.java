package streams;

import java.util.Optional;
import java.util.stream.Stream;

public class StreamOP {
    public static void main(String[] args) {

        //TODO: guess the op
        Stream<String> stream =  Stream.of("a", "b", "c", "b").filter(element -> element.contains("b"));
        Optional<String> anyElement = stream.findAny();
        System.out.println("anyElement: " + anyElement.get());
        Optional<String> firstElement = stream.findFirst();
        System.out.println("firstElement: " + firstElement.get());
    }
}
