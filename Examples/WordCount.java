import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.File;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.Comparator;
import java.util.TreeSet;

public class WordCount {
	private Map<String, Integer> wordCounts;

	private class RankComparator implements Comparator<String> {
		public int compare(String w1, String w2) {
			return wordCounts.get(w1) - wordCounts.get(w2);
		}
	}

	public WordCount(String fileName) throws FileNotFoundException {
		Scanner sc = new Scanner(new File(fileName));
		// wordCounts = new HashMap<>();
		wordCounts = new HashMap<>();
		while (sc.hasNext()) {
			// System.out.println(sc.next());
			String word = sc.next();
			if (wordCounts.keySet().contains(word)) {
				int curCount = wordCounts.get(word);
				wordCounts.put(word, curCount + 1);
			} else {
				wordCounts.put(word, 1);
			}
		}
	}

	public int count(String word) {
		return wordCounts.get(word);
	}

	public Set<String> words() {
		Set<String> words = new TreeSet<>(new RankComparator());
		words.addAll(wordCounts.keySet());
		// return wordCounts.keySet(); // default value of instance variable is null
		return words;
	}

	public static void main(String[] args) throws Exception {
		WordCount wc = new WordCount(args[0]);
		for (String word: wc.words()) {
			System.out.printf("%s: %d%n", word, wc.count(word));
		}
	}
}
//java WordCount i-have-a-dream.txt | wc - 1