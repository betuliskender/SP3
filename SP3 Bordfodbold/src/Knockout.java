import java.lang.reflect.Array;
import java.util.ArrayList;

// Knockout klassen nedarver fra Tournament og har derfor samme constructere og metoder.
public class Knockout extends Tournament {
    ArrayList<Integer> chosenIndexes;
    Team defaultTeam = new Team("No Team");

    public Knockout(String tournamentName, String tournamentType, boolean tournamentIsOpen) {
        super(tournamentName, tournamentType, tournamentIsOpen);
    }

    public Knockout(String tournamentName, String tournamentType, boolean tournamentIsOpen, boolean registrationIsOpen) {
        super(tournamentName, tournamentType, tournamentIsOpen, registrationIsOpen);
    }


    // Den overridede makeGamePlan metode laver en knockout "bracket".
    // Den randomizer hvilke hold der spiller mod hinanden
    @Override
    public void makeGamePlan() {

        Admin.chosenTournament.gamePlan = new ArrayList<Team[]>();
        Team[] matchUp = new Team[2];
        chosenIndexes = new ArrayList<>();

        for (int j = 0; j < Admin.chosenTournament.winnerTeams.size(); j++) {
            boolean continueBoolean = false;
            int randomInteger = 0;

            if (matchUp[0] != null && matchUp[1] != null) {
                matchUp = new Team[2];
            }

             do {
                continueBoolean = true;
                randomInteger = (int) Math.floor(Math.random() * Admin.chosenTournament.winnerTeams.size());


                for (int i = 0; i < chosenIndexes.size(); i++) {
                    if (randomInteger == chosenIndexes.get(i)) {
                        continueBoolean = false;
                    }
                }
            } while (continueBoolean == false);


            chosenIndexes.add(randomInteger);
            Team chosenTeam = Admin.chosenTournament.winnerTeams.get(randomInteger);

            if (matchUp[0] != null && matchUp[1] == null) {
                matchUp[1] = chosenTeam;
                Admin.chosenTournament.gamePlan.add(matchUp);
            } else if (matchUp[0] == null && matchUp[1] == null) {
                matchUp[0] = chosenTeam;
            }

        }
        if (matchUp[1] == null && matchUp[0] != null) {
            matchUp[1] = defaultTeam;
            Admin.chosenTournament.gamePlan.add(matchUp);
        }

    }




}

