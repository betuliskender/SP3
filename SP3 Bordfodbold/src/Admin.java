
//denne klasse er for admin, som er det individ der skaber og styrer turneringen
public class Admin {
    public static Tournament chosenTournament;

    //denne metode åbner samtlige valgmuligheder for admin
    public static void adminMainMenu() {
        boolean rerunBoolean;
        do {
            rerunBoolean = false;
            View.showAdminMenu();

            //todo: i et andet liv skal der også være et menuvalg hvor man kan se alle tidligere turneringer
            Main.input = UI.getUserInput("");
            if (Main.input.equalsIgnoreCase("x")) {
                Main.mainMenu();
            } else if (Main.input.equals("1")) {
                createTournament();
            } else if (Main.input.equals("2")) {
                openRegistration();
            } else if (Main.input.equals("3")) {
                closeRegistration();
            } else if (Main.input.equals("4")) {
                setTimetable();
            } else if (Main.input.equals("5")) {
                editGamePlan();
            } else if (Main.input.equals("6")) {
                startMatch();
            } else if (Main.input.equals("7")) {
                setNewRound();
            } else if (Main.input.equals("8")) {
                closeTournament();
            } else {
                System.out.println("Not a valid answer, please try again \n");
                rerunBoolean = true;
            }
        } while (rerunBoolean == true);
    }

    //her skabes turneringen, hvilket er første skridt til at åbne op for alle de resterende dele af programmet, turneringen skal navngives og derefter skal der vælges turneringstype
    public static void createTournament() {
        boolean rerunBoolean;
        do {
            rerunBoolean = false;
            System.out.println("You have chosen to create a new tournament \nTo return to the main menu press Q \n\nWrite tournament name here: ");
            String nameInput = UI.getUserInput("");
            String tournamentTypeInput = UI.getUserInput("To create a Knockout Tournament write knockout \nTo create a Group Tournament write group\n");
            if (Main.input.equalsIgnoreCase("Q")) {
                adminMainMenu();
            } else if (tournamentTypeInput.equalsIgnoreCase("knockout")) {
                chosenTournament = new Knockout(nameInput, tournamentTypeInput, true);
            } else if (tournamentTypeInput.equalsIgnoreCase("group")) {
                chosenTournament = new GroupTournament(nameInput, tournamentTypeInput, true);
            } else {
                System.out.println("Not a valid answer, please try again \n");
                rerunBoolean = true;
            }
        }
        while (rerunBoolean == true);

        Main.allTournaments.add(chosenTournament);
        Main.io.saveTournamentData(Main.allTournaments);
        adminMainMenu();
    }

    //her kan admin åbne for registrering så spillerne kan oprette sig som hold
    public static void openRegistration() {
        boolean rerunBoolean;
        do {
            rerunBoolean = false;
            System.out.println("You have chosen to open for registration \nTo return to the main menu press Q " +
                    "\nTo open the registration press 1");
            Main.input = UI.getUserInput("");
            if (Main.input.equalsIgnoreCase("Q")) {
                adminMainMenu();
            } else if (Main.input.equalsIgnoreCase("1")) {
                chosenTournament.registrationIsOpen = true;
            } else {
                System.out.println("Not a valid answer, please try again \n");
                rerunBoolean = true;
            }
        }
        while (rerunBoolean == true);
        Main.io.saveTournamentData(Main.allTournaments);
        adminMainMenu();
    }

    //her kan admin lukke for registrering, users får derefter ikke adgang til den del af menuen længere og kan fremover kun view ikke edit
    public static void closeRegistration() {
        boolean rerunBoolean;
        do {
            rerunBoolean = false;
            System.out.println("You have chosen to close the registration \nTo return to the main menu press Q " +
                    "\nTo close the registration press 1");
            Main.input = UI.getUserInput("");
            if (Main.input.equalsIgnoreCase("Q")) {
                adminMainMenu();
            } else if (Main.input.equalsIgnoreCase("1")) {
                chosenTournament.registrationIsOpen = false;
                chosenTournament.makeGamePlan();
            } else {
                System.out.println("Not a valid answer, please try again \n");
                rerunBoolean = true;
            }
        }
        while (rerunBoolean == true);
        Main.io.saveTournamentData(Main.allTournaments);
        adminMainMenu();
    }

    //denne metode skaber gamePlan for det næste sæt kampe der skal spilles (1/8-finale, kvartfinale, semifinale, finale)
    public static void setNewRound() {
        System.out.println("You have chosen to start a new round. To start the round press 1");
        String input = UI.getUserInput("");
        if (input.equals("1")) {
            Tournament.matchIndex = 0;
            chosenTournament.makeGamePlan();
        }
        adminMainMenu();


    }

    //todo: denne metode mangler at blive bygget
    //metoden giver admin adgang til at kunne redigere i timetable (dag, dato, tidspunkt) efter at den er autogenereret af en create timetable metode der endnu ikke eksisterer
    public static void setTimetable() {
        System.out.println("You have chosen to create or edit the timetable \nTo return to the main menu press Q");
        Main.input = UI.getUserInput("");
        if (Main.input.equalsIgnoreCase("Q")) {
            adminMainMenu();
        }

        adminMainMenu();
    }

    //todo: denne metode mangler at blive bygget
    //metoden giver admin adgang til at kunne redigere i gamePlan (hvem spiller mod hvem) efter at den er autogenereret af makeGamePlan i Tournament
    public static void editGamePlan() {
        System.out.println("You have chosen to edit the game plan \nTo return to the main menu press Q");
        Main.input = UI.getUserInput("");
        if (Main.input.equalsIgnoreCase("Q")) {
            adminMainMenu();
        }

        adminMainMenu();
    }

    //denne metode lader admin starte en specifik kamp, hvilket vil sige at runMatch bliver aktiveret
    public static void startMatch() {
        boolean rerunBoolean;
        do {
            rerunBoolean = false;
            System.out.println("You have chosen to start the next match \nTo return to the main menu press Q \nPress 1 to start the match ");
            Main.input = UI.getUserInput("");
            if (Main.input.equalsIgnoreCase("Q")) {
                adminMainMenu();
            } else if (Main.input.equals("1")) {
                Match newMatch = new Match(Admin.chosenTournament.gamePlan.get(Tournament.matchIndex));
                newMatch.runMatch();
            } else {
                System.out.println("Not a valid answer, please try again \n");
                rerunBoolean = true;
            }
        } while (rerunBoolean == true);
        adminMainMenu();
    }

    //denne metode afslutter hele turneringen
    public static void closeTournament() {
        boolean rerunBoolean;
        do {
            rerunBoolean = false;
            System.out.println("You have chosen to end the tournament and you will loose all the existing information if you choose to continue" +
                    "\nIf you are completely sure write exit" +
                    "\nIf you wish to return to the main menu press q");
            Main.input = UI.getUserInput("");
            if (Main.input.equalsIgnoreCase("Q")) {
                adminMainMenu();
            } else if (Main.input.equalsIgnoreCase("exit")) {
                System.out.println("Thanks for playing");

            } else {
                System.out.println("Not a valid answer, please try again \n");
                rerunBoolean = true;
            }
        }
        while (rerunBoolean == true);
        System.out.println("PROGRAM SHUTTING DOWN");
    }
}



