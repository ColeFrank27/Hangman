public class SecretPhrase {

    private String phrase = WordProvider.getWord();
    private String knownPart = "";
    private Boolean solved = false;
    private int turn = 1;

    public SecretPhrase() {

        phrase = WordProvider.getWord();

    }

    public String setPhrase() {

        for (int i = 0; i < phrase.length(); i++) {

            knownPart += "_";

        }
        return knownPart;
    }

    public void updateKnown(String guess) {

        for (int i = 0; i < phrase.length(); i++) {

            if (phrase.substring(i, i + 1).equals(guess)) {

                knownPart = knownPart.substring(0, i) + guess + knownPart.substring(i + 1);
            }
        }
    }

    public String getKnownPart() {

        return knownPart;
    }

    public boolean isSolved() {

        if (knownPart.equals(phrase)) {

            solved = true;
        }

        return solved;
    }

    public int pointValueForAccurateGuess() {

        return ((int) (Math.random() * 10 + 1));
    }

    public int scoreGuess(String guess, int pointValue) {

        int correctLetters = 0;
        for (int i = 0; i < phrase.length(); i++) {

            String sub = phrase.substring(i, i + 1);
            if (guess.contains(sub)) {
                correctLetters++;
            }

            if (guess.equals(phrase)) {

                solved = true;
            }

        }
        return pointValue * correctLetters;

    }

    public int getPhraseLength() {

        return phrase.length();
    }

    public void changeTurn() {

        turn++;
    }

    public int getTurn() {

        return turn;

    }

    public String getPhrase() {

        return phrase;

    }

}
