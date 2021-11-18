// DENNE OPGAVE ER LAVET AF MALENE, BETUL, KRISTIAN OG SOFIA FRA DAT1B

import java.util.ArrayList;

// MAIN KLASSEN INDEHOLDER DE HELT OVERORDNEDE ARRAYLISTER, DATAHENTNING OG KØRER MAINMENUEN
public class Main {

    public static String input = "";

    enum Datasource {
        DATABASE,
        CSVFILE
    }

    //private static Datasource datapath = Datasource.CSVFILE;
    private static Datasource datapath = null;

    public static ArrayList<Tournament> allTournaments = new ArrayList<>();
    public static ArrayList<Team> allTeams = new ArrayList<>();
    public static IO io;

    public static void main(String[] args) {

        //todo: skriv kode der gør at man let kan skifte mellem den ene og den anden persistens-metode
        //her gives der mulighed for at gemme og læse både fra fil og database
        if (datapath == Datasource.CSVFILE) {
            io = new FileReader();
        } else {
            io = new DBConnector();
        }

        // Data bliver hentet
        allTournaments = io.readTournamentData();
        allTeams = io.readTeamData();

        mainMenu();
    }

    //kalder det første menuvalg - om man er turneringsformanden eller spiller/publikum
    public static void mainMenu() {
        boolean rerunBoolean;
        do {
            rerunBoolean = false;
            input = UI.getUserInput("Are you a User or an Admin?: \n").toLowerCase();
            if (input.equals("admin")) {
                Admin.adminMainMenu();
            } else if (input.equals("user")) {
                User.userMenu();
            } else {
                System.out.println("Something went wrong. Please try again");
                rerunBoolean = true;
            }

        } while (rerunBoolean == true);

    }

}
