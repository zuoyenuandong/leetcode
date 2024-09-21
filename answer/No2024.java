import java.util.ArrayList;
import java.util.List;

public class No2024 {

    public static void main(String[] args) {

        String answerKey = "TTFTTFTT";
        Integer key  = 1;
        System.out.println(maxConsecutiveAnswers(answerKey, key));
    }

    public static int maxConsecutiveAnswers(String answerKey, int k) {
        List<Integer> firstCycle = new ArrayList<>();

        int length = 1;
        if (answerKey.length() == 1) {
            return 1;
        }
        for (int i = 1; i < answerKey.length(); i++) {
            if (answerKey.charAt(i) == answerKey.charAt(i - 1)) {
                length++;
                if (i == answerKey.length() -1) {
                    firstCycle.add(length);
                }
            } else {
                firstCycle.add(length);
                length = 1;
            }
        }
        List<Integer> secondCycle = new ArrayList<>();

        if (firstCycle.size() == 1) {
            return firstCycle.size();
        }

        for (int i = 1; i < firstCycle.size() - 1; i+=2) {
            int secondLength = firstCycle.get(i);

        }
        return 1;
    }
}
