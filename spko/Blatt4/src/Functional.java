import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.LinkedList;
import java.util.concurrent.TimeUnit;

public final class Functional {
    private Functional() { }

    private static final int MIN_LENGTH = 20;

    public static void main(String[] args) throws IOException {
        var input = Path.of(args[0]);
        var lines = new LinkedList<String>();
        long start = System.nanoTime();
        int n = Files.lines(input)
                .filter(line -> !line.isEmpty())
                .map(line -> line.length())
                .filter(line -> line.length() >= MIN_LENGTH)
                //.collect(LinkedList::new, LinkedList::add, LinkedList::addAll)
                .reduce(String::length).sum();

        //int n = totalLineLengths(lines);
        long stop = System.nanoTime();

        System.out.printf("result = %d (%d microsec)%n", n, TimeUnit.NANOSECONDS.toMicros(stop - start));
    }

    // TODO: Klassenmethoden readLines, removeEmptyLines, removeShortLines, totalLineLengths

    private static int totalLineLengths(LinkedList<String> lines) {
        return lines.stream().mapToInt(String::length).sum();
    }
}