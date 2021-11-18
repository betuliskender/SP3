
// MATCH KLASSEN REPRÆSENTERER DEN ENKELTE KAMP MELLEM TO HOLD

public class Match {
    int numberOfGoalsTeam1 = 0;
    int numberOfGoalsTeam2 = 0;
    Team[] matchUp;
    Team team1;
    Team team2;

    // Match constructor tager et Team array ind som parameter. Dette array har 2 pladser.
    public Match(Team[] matchUp) {
        this.matchUp = matchUp;

        team1 = this.matchUp[0];
        team2 = this.matchUp[1];
    }

    // runMatch metoden kører en "live" match, hvor admin kan sidde og give de enkelte hold målscoringer
    // imens det sker, alt efter hvem der scorer
    public void runMatch() {
        boolean matchIsOn = true;


        System.out.println("The game between " + team1.getTeamName() + " and " + team2.getTeamName() + " is now on!");
        System.out.println("Press e to end the game");
        System.out.println("Press 1 if " + team1.getTeamName() + " scores. Press 2 if " + team2.getTeamName() + " scores.");

        do {
            String matchInput = UI.getUserInput("");
            if (matchInput.equalsIgnoreCase("e")) {
                matchIsOn = false;
                Tournament.matchIndex += 1;
                System.out.println("The match has ended. Now calculating results.");
                calculateResult();
            } else if (matchInput.equalsIgnoreCase("1")) {
                numberOfGoalsTeam1 += 1;
                System.out.println(team1.getTeamName() + " now has " + numberOfGoalsTeam1);

            } else if (matchInput.equalsIgnoreCase("2")) {
                numberOfGoalsTeam2 += 1;
                System.out.println(team2.getTeamName() + " now has " + numberOfGoalsTeam2);
            } else {
                System.out.println("That did not make sense. Please try again");
            }

        } while (matchIsOn == true);
    }

    // calculateResult udregner (efter den enkelte kamp er slut) hvilket hold der har henholdsvist vundet og tabt.
    // Den lægger også målscore og point til de enkelte hold's målscore og point.
    public void calculateResult() {
        Team winnerTeam;
        Team loserTeam;

        team1.setNumberOfGoals(numberOfGoalsTeam1);
        team2.setNumberOfGoals(numberOfGoalsTeam2);

        if (numberOfGoalsTeam1 > numberOfGoalsTeam2) {
            winnerTeam = team1;
            loserTeam = team2;
        } else {
            winnerTeam = team2;
            loserTeam = team1;
        }
        winnerTeam.setTotalScore(2);

        Admin.chosenTournament.winnerTeams.remove(loserTeam);
        for (int i = 0; i < Admin.chosenTournament.winnerTeams.size(); i++) {
            if (Admin.chosenTournament.winnerTeams.get(i) == loserTeam) {
                Admin.chosenTournament.winnerTeams.remove(i);
            }
        }


    }

}
