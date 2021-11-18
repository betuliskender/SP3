
//Her styres alt det man kan se om turneringen som publikum eller spiller
public class View {

    //Metoden viser admin menu, som giver forskellige valg
    public static String showAdminMenu() {
        String s = "MAIN ADMIN MENU: \nCreate new tournament press 1 \n" +
                "Open for registration press 2 \nClose registration press 3 \n" +
                "Create or edit timetable press 4 \nEdit game plan press 5 \nStart next match press 6" +
                "\nStart next round press 7 \nEnd tournament press 8";
        System.out.println(s);
        return s;
    }

    //Metoden viser en bruger menu, hvis registrationIsOpen er true og ellers viser den en brugermenu uden at kunne oprette hold
    public static String showUserMenu() {
        if (Admin.chosenTournament.registrationIsOpen == true) {
            String s = "MAIN USER MENU: \nCreate team press 1 \nAdd player press 2 \n" +
                    "Remove player press 3 \nRemove team press 4 \nView registered teams press 5 " +
                    "\nReturn to main menu press x";
            System.out.println(s);
            return s;
        } else {
            String s = "MAIN USER MENU: \nShow registered teams 1 \nTo show gameplan press 2 \n" +
                    "To show timetable press 3 \nTo view ScoreBoard press 4 \nReturn to main menu press x";
            System.out.println(s);
            return s;
        }
    }

    //Metoden viser de registrerede hold på nuværende tidspunkt
    public static void showRegisteredTeams() {

        for (Team t : Main.allTeams) {
            System.out.println(t.getTeamName() + ": ");
            for (Player p : t.teamPlayers) {
                System.out.print(p.playerName + ", ");
            }
            System.out.println("\n");
        }
    }

    //todo skal metoden vise hvem, der skal spille mod hinanden
    public static void showGamePlan() {
        for (int i = 0; i < Admin.chosenTournament.gamePlan.size(); i++) {

        }
    }

    //Printer scoreboard ud, placering og point
    public static void showScoreboard() {
        Scoreboard.setScoreboard();
        System.out.println(Scoreboard.printScoreBoard());
    }

    //Todo: lav en metode, der viser spilletidspunkter for holdenes kampe
    public static void showTimeTable() {
        System.out.println();
    }


    //todo: lav en showMatch metode der viser den specifikke kamps resultat
}
