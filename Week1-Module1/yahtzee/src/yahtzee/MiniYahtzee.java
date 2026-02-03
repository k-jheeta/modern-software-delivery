package yahtzee;

class MiniYahtzee {

    public static void main(String[] args) {
        score(args[0], args[1], args[2], args[3]);
    }

    public static int score(String nomination, String d1, String d2, String d3) {
        int score = 0;
        int first = Integer.parseInt(d1);
        int second = Integer.parseInt(d2);
        int third = Integer.parseInt(d3);

        int nominationGroupToInt = switch (nomination) {
            case "ones" -> 1;
            case "twos" -> 2;
            case "threes" -> 3;
            default -> 0;
        };

        score = new Nomination().nominations(first, second, third, nominationGroupToInt);

        return score;
    }
}

class Nomination {
    int nominations(int d1, int d2, int d3, int n) {
        int sum = 0;
        if (d1 == n) sum += n;
        if (d2 == n) sum += n;
        if (d3 == n) sum += n;
        return sum;
    }
}