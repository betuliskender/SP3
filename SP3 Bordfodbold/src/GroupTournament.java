// GROUPTOURNAMENT KLASSEN NEDARVER FRA TOURNAMENT OG HAR DERFOR SAMME CONSTRUCTORER OG METODER
// KLASSEN ER IKKE UDVIDET, DA DEN KUN (I DENNE OMGANG) SKAL VISE PRINCIPPET AF AT TOURNAMENT KAN NEDARVES TIL MANGE SUBKATEGORIER
public class GroupTournament extends Tournament {

    public GroupTournament(String tournamentName, String tournamentType, boolean tournamentIsOpen) {
        super(tournamentName, tournamentType, tournamentIsOpen);
    }

    public GroupTournament(String tournamentName, String tournamentType, boolean tournamentIsOpen, boolean registrationIsOpen) {
        super(tournamentName, tournamentType, tournamentIsOpen, registrationIsOpen);
    }

    @Override
    public void makeGamePlan() {

    }
}
