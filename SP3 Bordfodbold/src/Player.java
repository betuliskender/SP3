
//her er den enkelte spiller
public class Player {

    String playerName;
    String schoolClassName;
    String phoneNumber;

    //her skabes en specifik spiller til et specifikt hold
    public Player(String playerName, String schoolClassName, String phoneNumber) {
        this.playerName = playerName;
        this.schoolClassName = schoolClassName;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "PLAYER NAME: " + playerName + " - FROM SCHOOL CLASS: " + schoolClassName + "\n";
    }
}




