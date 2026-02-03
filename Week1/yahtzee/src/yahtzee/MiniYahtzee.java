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
            case "ones" -> new Max().ones(first, second, third, 1);
            case "twos" -> new Max().twos(first, second, third, 2);
            case "threes" -> new Max().threes(first, second, third, 3);
            default -> score;
        };

        return score;
    }
}

class Ones {
    int ones(int d1, int d2, int d3, int ones) {
        int sum = 0;
        if (d1 == ones) sum += ones;
        if (d2 == ones) sum += ones;
        if (d3 == ones) sum += ones;
        return sum;
    }
}

class Twos extends Ones {
    int twos(int d1, int d2, int d3, int twos) {
        int sum = 0;
        if (d1 == twos) sum += twos;
        if (d2 == twos) sum += twos;
        if (d3 == twos) sum += twos;
        return sum;
    }
}

class Max extends Twos {
    int threes(int d1, int d2, int d3, int threes) {
        int s = 0;
        if (d1 == threes) s += threes;
        if (d2 == threes) s += threes;
        if (d3 == threes) s += threes;
        return s;
    }
}