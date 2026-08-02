import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ParallelLetterFrequency {
    private List<String> texts;

    public ParallelLetterFrequency(List<String> texts) {
        this.texts = texts;
    }

    public Map<Character, Integer> count() {
        Map<Character, Integer> frequencyMap = new ConcurrentHashMap<>();

        texts.parallelStream().forEach(text -> {
            for (char c : text.toCharArray()) {
                if (Character.isLetter(c)) {
                    char lowerC = Character.toLowerCase(c);
                    frequencyMap.merge(lowerC, 1, Integer::sum);
                }
            }
        });

        return frequencyMap;
    }
}