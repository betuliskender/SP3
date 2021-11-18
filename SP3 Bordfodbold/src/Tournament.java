import java.util.ArrayList;

// TOURNAMENT KLASSEN ER SUPERKLASSE TIL ALLE UNDERKATEGORIER AF EN TURNERING (F.EKS GROUP OG KNOCKOUT TOURNAMENT)
public class Tournament {
    public static ArrayList<Team> winnerTeams = new ArrayList<>(); // Arrayliste til der gemmer alle de hold der har vundet den tidligere runde
    public ArrayList<Team[]> gamePlan = new ArrayList<>(); // Arrayliste til at gemme de enkelte kampe
    public static int matchIndex = 0;

    public String tournamentName;
    public String tournamentType;
    public boolean tournamentIsOpen;
    public boolean registrationIsOpen;

    static int counter = 0;
    int id;

    //Tournament constructor
    public Tournament(String tournamentName, String tournamentType, boolean tournamentIsOpen) {
        this.tournamentName = tournamentName;
        this.tournamentType = tournamentType;
        this.tournamentIsOpen = tournamentIsOpen;

        counter++;
        this.id = counter;
    }

    // Tournament overloaded constructor
    public Tournament(String tournamentName, String tournamentType, boolean tournamentIsOpen, boolean registrationIsOpen) {
        this.tournamentName = tournamentName;
        this.tournamentType = tournamentType;
        this.tournamentIsOpen = tournamentIsOpen;
        this.registrationIsOpen = registrationIsOpen;
    }

    //makeGamePlan metoden nedarves til subklasserne hvor den specificeres.
    // Den laver en plan for hvilke hold der skal spille mod hinanden
    public void makeGamePlan() {

    }


    public String getTournamentName() {
        return tournamentName;
    }

    public String getTournamentType() {
        return tournamentType;
    }

    public boolean isTournamentIsOpen() {
        return tournamentIsOpen;
    }

    public boolean isRegistrationIsOpen() {
        return registrationIsOpen;
    }

    public int getId() {
        return id;
    }
}
