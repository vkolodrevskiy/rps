package rps.model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static java.util.Map.Entry;

/**
 * {@link History} implementation based on {@code String}.
 *
 * @author vkolodrevskiy
 */
public class StringHistory implements History {
    private final StringBuilder contents;
    private static final Comparator<Entry<?, Long>> RANK_BY_VALUE = Comparator
            .comparingLong(Entry::getValue);

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

    @Override
    public Optional<Move> getMostCommonMove() {
        Optional<Entry<Character, Long>> mostCommon = contents.chars().boxed().collect(
                Collectors.groupingBy(
                        c -> ((char) c.intValue()),
                        Collectors.counting())).entrySet().stream()
                .sorted(RANK_BY_VALUE.reversed()).findFirst();

        return mostCommon.map(entry -> Move.valueOfCode(entry.getKey()));
    }

    @Override
    public Integer length() {
        return contents.length();
    }

    @Override
    public Optional<Move> getMarkovChainMostCommonMove(byte patternLength) {
        Optional<Entry<String, Long>> mostCommon = getMarkovChainMatches(patternLength).stream()
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        Collectors.counting())).entrySet().stream()
                .sorted(RANK_BY_VALUE.reversed()).findFirst();

        if (mostCommon.isPresent()) {
            String pattern = mostCommon.get().getKey();
            return Optional.of(Move.valueOfCode(pattern.charAt(pattern.length() - 1)));
        } else {
            return Optional.empty();
        }
    }

    /**
     * Gets list of Markov Chain matches.
     *
     * @param patternLength Markov Chain pattern length.
     * @return {@code List} of matches.
     */
    private List<String> getMarkovChainMatches(byte patternLength) {
        String pattern = getLastMoves(patternLength);

        List<String> allMatches = new ArrayList<>();
        Matcher m = Pattern.compile(pattern + ".").matcher(contents);
        while (m.find()) {
            allMatches.add(m.group());
        }

        return allMatches;
    }

    /**
     * Get last number of moves.
     *
     * @param lastMoves
     * @return
     */
    private String getLastMoves(byte lastMoves) {
        return contents.substring(contents.length() - lastMoves);
    }
}
