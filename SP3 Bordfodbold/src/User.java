import java.io.FileWriter;
import java.io.IOException;

//USER ER TIL SPILLERE OG PUBLIKUM.
public class User {
    public static Team teamChoice;

    //Denne åbner samtlige valgmuligheder for brugeren, og kan også fortælle, hvis brugeren har indtastet forkert.
    public static void userMenu() {
        boolean rerunBoolean;
        do {
            rerunBoolean = false;
            View.showUserMenu();
            Main.input = UI.getUserInput("");
            if (Main.input.equalsIgnoreCase("x")) {
                Main.mainMenu();
            }
            if (Admin.chosenTournament.registrationIsOpen == true) {
                if (Main.input.equals("1")) {
                    createTeam();
                } else if (Main.input.equals("2")) {
                    addPlayerToTeam();
                } else if (Main.input.equals("3")) {
                    removePlayerFromTeam();
                } else if (Main.input.equals("4")) {
                    removeTeam();
                } else if (Main.input.equals("5")) {
                    View.showRegisteredTeams();
                } else {
                    System.out.println("Not a valid answer, please try again \n");
                    rerunBoolean = true;
                }
            } else {
                if (Main.input.equals("1")) {
                    View.showRegisteredTeams();
                } else if (Main.input.equals("2")) {
                    View.showGamePlan();
                } else if (Main.input.equals("3")) {
                    View.showTimeTable();
                } else if (Main.input.equals("4")) {
                    View.showScoreboard();
                }
            }
        } while (rerunBoolean == true);
        userMenu();
    }

    public static void createTeam() {
        //Denne metode opretter et nyt hold, og sprøger brugeren om at indtaste et hold navn og derefter spiller navne.
        teamChoice = new Team(" ");
        System.out.println("You have chosen to create a team \nTo return to the main menu press Q \nWrite team name here: ");
        Main.input = UI.getUserInput("");
        if (Main.input.equalsIgnoreCase("Q")) {
            userMenu();
        } else {
            teamChoice = new Team(Main.input);
            Main.allTeams.add(teamChoice);
            Tournament.winnerTeams.add(teamChoice);
        }

        boolean playersAddBoolean = true;
        do {
            Main.input = UI.getUserInput("To add a new player press 1, To stop adding players press 2");
            if (Main.input.equals("1")) {
                String playerName = UI.getUserInput("Write player name here: ");
                String playerClass = UI.getUserInput("Write player class here: ");
                String playerPhone = UI.getUserInput("Write player phone number here: ");
                teamChoice.addPlayer(playerName, playerClass, playerPhone);
            } else if (Main.input.equals("2")) {
                playersAddBoolean = false;
            }

        } while (playersAddBoolean == true);

        Main.io.saveTeamData(teamChoice);
        userMenu();
    }

    public static void removeTeam() {
        //Todo metoden skal kunne fjerne fra sql databasen.
        //Denne metode tjekker om et hold findes, når brugeren indtaster holdnavnet, hvis det gør kan man fjerne fra arraylisten allTeams fra main.
        boolean rerunBoolean;
        do {
            rerunBoolean = false;
            System.out.println("To return to the main menu press Q \nWrite team name here to remove team: ");
            Main.input = UI.getUserInput("");
            if (Main.input.equalsIgnoreCase("Q")) {
                userMenu();
            } else {
                boolean teamExists = false;
                for (Team team : Main.allTeams) {
                    if (team.getTeamName().equalsIgnoreCase(Main.input)) {
                        teamExists = true;
                    }
                }
                if (teamExists == false) {
                    System.out.println("That team name does not exist");
                    rerunBoolean = true;

                } else if (teamExists == true) {
                    for (Team t : Main.allTeams) {
                        if (t.getTeamName().equalsIgnoreCase(Main.input)) {
                            Main.allTeams.remove(t);
                        }
                    }
                }
            }
        } while (rerunBoolean == true);
        Main.io.saveTeamData(teamChoice);
        userMenu();
    }

    public static void addPlayerToTeam() {
        //Denne metoden tilføjer en spiller til et hold.
        System.out.println("You have chosen to add a player \nTo return to the main menu press Q \nWrite your team name here: ");
        boolean rerunBoolean;
        do {
            rerunBoolean = false;

            Main.input = UI.getUserInput(" ");
            if (Main.input.equalsIgnoreCase("Q")) {
                userMenu();
            }
            boolean teamExists = false;
            Team selectedTeam = new Team("");
            for (Team t : Main.allTeams) {
                if (t.getTeamName().equalsIgnoreCase(Main.input)) {
                    teamExists = true;
                    selectedTeam = t;
                }
            }
            if (teamExists == false) {
                System.out.println("That team name does not exist. Please try again.");
                rerunBoolean = true;

            } else if (teamExists == true) {
                String playerName = UI.getUserInput("Write player name here: ");
                String playerClass = UI.getUserInput("Write player class here: ");
                String playerPhone = UI.getUserInput("Write player phone number here: ");
                selectedTeam.addPlayer(playerName, playerClass, playerPhone);
            }

        } while (rerunBoolean == true);
        Main.io.saveTeamData(teamChoice);
        userMenu();
    }

    public static void removePlayerFromTeam() {
        //Denne metoden kan fjerne en spiller fra et hold.
        System.out.println("You have chosen to remove a player \nTo return to the main menu press Q \nWrite team name you want to remove player from: ");
        boolean rerunBoolean;
        do {
            rerunBoolean = false;

            Main.input = UI.getUserInput(" ");
            if (Main.input.equalsIgnoreCase("Q")) {
                userMenu();
            }
            boolean teamExists = false;
            Team selectedTeam = new Team("");
            for (Team t : Main.allTeams) {
                if (t.getTeamName().equalsIgnoreCase(Main.input)) {
                    teamExists = true;
                    selectedTeam = t;
                }
            }
            if (teamExists == false) {
                System.out.println("That team name does not exist. Please try again.");
                rerunBoolean = true;

            } else if (teamExists == true) {
                String playerNameInput = UI.getUserInput("Write player name here: ");
                for (int i = 0; i < selectedTeam.teamPlayers.size(); i++) {
                    Player p = selectedTeam.teamPlayers.get(i);
                    if (p.playerName.equalsIgnoreCase(playerNameInput)) {
                        selectedTeam.teamPlayers.remove(p);
                        System.out.println(p.playerName + " has now been removed from " + selectedTeam);
                    }
                }
            }

        } while (rerunBoolean == true);
        Main.io.saveTeamData(teamChoice);
        userMenu();
    }
}



