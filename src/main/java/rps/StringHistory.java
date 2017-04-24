package rps;

import rps.model.Move;

import java.util.Comparator;
import java.util.stream.Collectors;

import static java.util.Map.Entry;

/**
 * {@link History} implementation based on {@code String}.
 *
 * @author vkolodrevskiy
 */
public class StringHistory implements History {
    private StringBuilder contents;

    public StringHistory() {
        this.contents = new StringBuilder();
    }

    public StringHistory(String history) {
        this.contents = new StringBuilder(history);
    }

    @Override
    public void add(Move move) {
        contents.append(move.code());
    }

    private String getAsString() {
        return contents.toString();
    }

    public Move getMostCommonMove() {
        if (contents.length() == 0) {
            throw new RuntimeException("History is empty.");
        }
        Comparator<Entry<?, Long>> RANK_BY_VALUE = Comparator
                .comparingLong(Entry::getValue);
        Entry<Character, Long> mostCommon = contents.chars().boxed().collect(
                Collectors.groupingBy(
                        c -> ((char) c.intValue()),
                        Collectors.counting())).entrySet().stream()
                .sorted(RANK_BY_VALUE.reversed()).findFirst().get();

        return Move.valueOfCode(mostCommon.getKey());
    }
}
