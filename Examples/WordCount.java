import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.File;
import java.util.Map;
import java.util.HashMap;


public class WordCount {
	private Map<String, Integer> wordCounts;

	public WordCount(String fileName) throws FileNotFoundException {
		wordCounts = new HashMap<>();
		Scanner sc = new Scanner(new File(fileName));
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
		return wordCounts.keySet(); // default value of instance variable is null
	}

	public static void main(String[] args) throws Exception {
		WordCount wc = new WordCount(args[0]);
		for (String word: wc.words()) {
			System.out.printf("%s: %d%n", word, wc.count(word));
		}
	}
}
//java WordCount i-have-a-dream.txt | wc - 1