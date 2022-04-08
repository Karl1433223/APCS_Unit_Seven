import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

    public class ScrabbleHelper {
        private ArrayList<String> wordList;

        public ScrabbleHelper() throws FileNotFoundException {
            Scanner scan = new Scanner(new File("files/enable.txt"));
            wordList = new ArrayList<>();
            while (scan.hasNext()) {
                String answer  = scan.next();
                wordList.add(answer);
            }
            scan.close();
        }

        public ArrayList<String> getWordList() {
            return wordList;
        }

        public boolean foundWord(String word) {
            int min = 0;
            for (int max = wordList.size(); min <= max; ) {
                int mid = (min + max) / 2;
                if (wordList.get(mid).equals(word))
                    return true;

            } else return false;
        }


        public ArrayList<String> findMatches(String pattern) {
            ArrayList<String> words = new ArrayList<>();
            for (String a : wordList) {
                if (a.indexOf(pattern) != -1) {
                    words.add(a);
                }
            }
            return words;
        }

        public void sortWords(ArrayList<String> word) {
            for (int j = 1; j < word.size(); j++) {
                String match = word.get(j);
                int temp = word.get(j).length();
                int i = j - 1;
                while ((i >= 0) && temp < word.get(i).length()) {
                    word.set(i + 1, word.get(i));
                    i--;
                }
                word.set(i + 1, match);
            }
        }

        public ArrayList<String> possibleCombinations(String Char) {
            ArrayList<String> combination = new ArrayList<>();
            for (String s : wordList) {
                ArrayList<Character> tiles = new ArrayList<>();
                int num = 0;
                int words = num;
                boolean canMakeWord = true;
                for (int i = 0; i < Char.length(); i++) {
                    tiles.add(Char.charAt(i));
                }
                for (int r = 0; r < s.length(); r++) {
                    Character letter = s.charAt(r);
                    if (tiles.contains(letter)) {
                        tiles.remove((Character) letter);
                    } else {
                        num++;

                    }
                }
                if (words == num) {
                    combination.add(s);
                }
            }
            return combination;
        }

        public int getScores(String word) {
            int score = 0;
            int[] scores = new int[]{1, 3, 3, 2, 1, 4, 2, 4, 1, 8, 5, 1, 3, 1, 1, 3, 10, 1, 1, 1, 1, 4, 4, 8, 4, 10};
            for (int i = 0; i < word.length(); i++) {
                char letter = word.charAt(i);
                int num2  = letter - 'a';
                score += scores[num2];
            }
            return score;
        }

    }
