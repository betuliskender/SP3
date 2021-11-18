import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

// FILEREADER KLASSEN IMPLEMENTERER IO INTERFACET OG HAR DERFOR DE SAMME METODER
// DENNE KLASSE GEMMER DATA TIL EN TEKST FIL
public class FileReader implements IO {


    // saveTournamentData metoden gemmer en string af den givne Tournament til en tekst fil
    //todo: Denne metode er ikke bygget endnu
    @Override
    public void saveTournamentData(ArrayList<Tournament> tournaments) {

    }

    // readTournamentData metoden loader en string af Tournament fra en tekst fil
    //todo: Denne metode er ikke bygget endnu
    @Override
    public ArrayList<Tournament> readTournamentData() {
        return null;
    }


    // saveTeamData metoden gemmer en string af den givne Tournament til en tekst fil
    @Override
    public void saveTeamData(Team t) {
        String teamdata = "";

        teamdata += t;


        try {
            FileWriter writer = new FileWriter("src/Teams.txt");
            writer.write(teamdata);
            writer.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    // readTeamData metoden loader en string af Tournament fra en tekst fil
    //todo: Denne metode er ikke bygget endnu
    @Override
    public ArrayList<Team> readTeamData() {
        return null;
    }
}
