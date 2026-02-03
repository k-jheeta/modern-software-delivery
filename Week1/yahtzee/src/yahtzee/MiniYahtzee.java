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

        score = switch (nomination) {
            case "ones" -> new Nomination().nominations(first, second, third, 1);
            case "twos" -> new Nomination().nominations(first, second, third, 2);
            case "threes" -> new Nomination().nominations(first, second, third, 3);
            default -> score;
        };

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