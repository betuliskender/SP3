import java.util.ArrayList;

// IO INTERFACET KREERE DE METODER DER BRUGES TIL AT GEMME OG LOADE TIL/FRA HENHOLDSVIST DATABASE OG TEKST FIL
public interface IO {
    void saveTournamentData(ArrayList<Tournament> tournaments);

    ArrayList<Tournament> readTournamentData();

    void saveTeamData(Team t);

    ArrayList<Team> readTeamData();

}
