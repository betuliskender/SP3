import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class KnockoutTest {

    @Before
    public void setUp() throws Exception {
        Tournament knockout = new Knockout("Giraf Turnering", "knockout", true);
        Admin.chosenTournament = knockout;

        Team testTeam = new Team("De Sejeste");
        testTeam.addPlayer("Malene", "Dat1B", "42752212");
        testTeam.addPlayer("Sofia", "Dat1B", "123455678");
        testTeam.addPlayer("Kristian", "Dat1B","87654321");
        testTeam.addPlayer("Betül","Dat1B","12468123");
         Team testTeam2 = new Team("Flod");
         Team testTeam3 = new Team("Hest");
         Team testTeam4 = new Team("Bøf");
         Main.allTeams.add(testTeam);
         Main.allTeams.add(testTeam2);
         Main.allTeams.add(testTeam3);
         Main.allTeams.add(testTeam4);
         Tournament.winnerTeams.add(testTeam);
         Tournament.winnerTeams.add(testTeam2);
         Tournament.winnerTeams.add(testTeam3);
         Tournament.winnerTeams.add(testTeam4);

    }

    // Vi tester makeGamePlan metoden,
    // for at se om den delegerer holdene rigtigt ud på array's af 2 pladser i Arraylisten
    @Test
    public void makeGamePlanTest() {
        ArrayList<Integer>chosenIndexes = new ArrayList<>();
        Admin.chosenTournament.gamePlan = new ArrayList<Team[]>();
        Team[] matchUp = new Team[2];
        chosenIndexes = new ArrayList<>();

        for (int j = 0; j < Admin.chosenTournament.winnerTeams.size(); j++) {
            boolean continueBoolean = false;
            int randomInteger = 0;

            if (matchUp[0] != null && matchUp[1] != null) {
                matchUp = new Team[2];
            }

//            do {
//                continueBoolean = true;
//                randomInteger = (int) Math.floor(Math.random() * Admin.chosenTournament.winnerTeams.size());
//
//
//                for (int i = 0; i < chosenIndexes.size(); i++) {
//                    if (randomInteger == chosenIndexes.get(i)) {
//                        continueBoolean = false;
//                    }
//                }
//            } while (continueBoolean == false);

            randomInteger = j;

            chosenIndexes.add(randomInteger);
            Team chosenTeam = Admin.chosenTournament.winnerTeams.get(randomInteger);

            if (matchUp[0] != null && matchUp[1] == null) {
                matchUp[1] = chosenTeam;
                Admin.chosenTournament.gamePlan.add(matchUp);
            } else if (matchUp[0] == null && matchUp[1] == null) {
                matchUp[0] = chosenTeam;
            }

        }
//        if (matchUp[1] == null && matchUp[0] != null) {
//            matchUp[1] = defaultTeam;
//            Admin.chosenTournament.gamePlan.add(matchUp);
//        }

        String plads3 = Admin.chosenTournament.gamePlan.get(1)[0].getTeamName();
        assertEquals("Hest", plads3);
    }


    }
