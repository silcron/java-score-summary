import java.util.Locale;

public class ScoreSummary {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.err.println("Usage: java ScoreSummary 85 90 55");
            System.exit(1);
        }

        int[] scores = new int[args.length];
        try {
            for (int i = 0; i < args.length; i++) {
                scores[i] = Integer.parseInt(args[i]);
                if (scores[i] < 0 || scores[i] > 100) {
                    throw new IllegalArgumentException();
                }
            }
        } catch (IllegalArgumentException e) {
            System.err.println("Enter integer scores between 0 and 100.");
            System.exit(1);
        }

        long total = 0;
        int highest = scores[0];
        int lowest = scores[0];
        int passed = 0;

        for (int score : scores) {
            total += score;
            highest = Math.max(highest, score);
            lowest = Math.min(lowest, score);
            if (score >= 60) {
                passed++;
            }
        }

        double average = (double) total / scores.length;
        System.out.println("Count: " + scores.length);
        System.out.printf(Locale.ROOT, "Average: %.2f%n", average);
        System.out.println("Highest: " + highest);
        System.out.println("Lowest: " + lowest);
        System.out.println("Passed (60+): " + passed);
    }
}
