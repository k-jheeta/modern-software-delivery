package yahtzee;

import java.util.ArrayList;

class MiniYahtzee {
    public static void main(String[] args) {
        score(args[0], args[1], args[2], args[3]);
    }

    private static void score(String nomination, String d1,
                              String d2, String d3) {
         ArrayList<Integer> dice = new ArrayList<>();
        dice.add(Integer.parseInt(d1));
        dice.add(Integer.parseInt(d2));
        dice.add(Integer.parseInt(d3));

        int score = new Nomination().nomination(nomination, dice);
        System.out.println("Score: " + score);
    }
}

class Nomination {
    int nominationAsInt(String nomination) {
        switch (nomination) {
            case "ones" -> {
                return 1;
            }
            case "twos" -> {
                return 2;
            }
            case "threes" -> {
                return 3;
            }
        }
        return 0;
    }

    int nomination(String nomination, ArrayList<Integer> dice) {
        int sum = 0;
        int nominationInt = nominationAsInt(nomination);
        for (int die : dice) {
            if (die == nominationInt) {
                sum += nominationInt;
            }
        }
        return sum;
    }
}