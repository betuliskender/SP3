import java.util.ArrayList;

//dette er turneringens hold og holdets tilhørende spillere bliver tilføjet her
public class Team {

    private String teamName;
    private int totalScore; // sort this
    private int numberOfGoals;  //sort this
    public ArrayList<Player> teamPlayers = new ArrayList<>();
    static int counter = 0;
    int id;

    //første konstruktor der bruges når et hold oprettes og kun tager et holdnavn ind
    public Team(String teamName) {
        this.teamName = teamName;
    }

    //anden konstruktor, der overloader den forrige når kampene går i gang og holdene nu får mål og point tilføjet
    public Team(String teamName, int totalScore, int numberOfGoals) {
        this.teamName = teamName;
        this.totalScore = totalScore;
        this.numberOfGoals = numberOfGoals;
        counter++;
        this.id = counter;
    }

    //her tilføjes der en specifik spiller til et specifikt hold, spilleren oprettes i Player
    public void addPlayer(String name, String schoolClassName, String phoneNumber) {

        teamPlayers.add(new Player(name, schoolClassName, phoneNumber));
    }

    @Override
    public String toString() {
        String pl = "";
        for (Player p : teamPlayers) {
            pl += p.toString();
        }
        return "TEAM: " + teamName + '\n' +
                "Team Players: \n" + pl;
    }

    public String getTeamName() {
        return teamName;
    }

    public int getNumberOfGoals() {
        return numberOfGoals;
    }

    public int getTotalScore() {
        return totalScore;
    }

    public void setNumberOfGoals(int numberOfGoals) {
        this.numberOfGoals += numberOfGoals;
    }

    public void setTotalScore(int totalScore) {
        this.totalScore += totalScore;
    }

    public int getId() {
        return id;
    }
}
