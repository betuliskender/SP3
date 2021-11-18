
public class Scoreboard {

    public static Team[] teamsWithTotalScore = new Team[Main.allTeams.size()];

    public static void setScoreboard() {
        //Denne metode sortere arraylisten og rangere dem efter, hvor mange goals holdene har.
        for (int i = 0; i < teamsWithTotalScore.length; i++) {
            Team p = Main.allTeams.get(i);
            teamsWithTotalScore[i] = p;
        }

        int highestAmountOfGoals;
        Team temp;
        for (int a = 0; a < teamsWithTotalScore.length - 1; a++) {
            highestAmountOfGoals = a;

            for (int b = a + 1; b < teamsWithTotalScore.length; b++)
                if (teamsWithTotalScore[b].getNumberOfGoals() > teamsWithTotalScore[highestAmountOfGoals].getNumberOfGoals())
                    highestAmountOfGoals = b;

            temp = teamsWithTotalScore[a];
            teamsWithTotalScore[a] = teamsWithTotalScore[highestAmountOfGoals];
            teamsWithTotalScore[highestAmountOfGoals] = temp;
        }
    }

    public static String printScoreBoard() {
        //Denne metode printer holdnavne ud, sammen med deres points.
        String s = "";
        for (Team t : teamsWithTotalScore) {
            s += t.getTeamName() + ". Total score: " + t.getTotalScore() + ". Total goals: " + t.getNumberOfGoals() + "\n";
        }
        return s;
    }
}
