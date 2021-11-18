import java.sql.*;
import java.util.ArrayList;

// DBCONNECTOR KLASSEN IMPLEMENTERER IO INTERFACET OG HAR DERFOR DE SAMME METODER
// DENNE KLASSE GEMMER DATA TIL EN MYSQL DATABASE
public class DBConnector implements IO {

    static final String DB_URL = "jdbc:mysql://localhost/BordfodboldSQL";

    static final String USER = "root";
    static final String PASS = "enkode";

    // saveTournamentData metoden gemmer en Arrayliste af alle tournament til en database
    @Override
    public void saveTournamentData(ArrayList<Tournament> tournaments) {
        Connection conn = null;
        String sql = "INSERT INTO Tournament(ID, tournamentName, tournamentType, tournamentIsOpen, registrationIsOpen) "
                + "VALUES (?,?,?,?,?) ON DUPLICATE KEY UPDATE tournamentIsOpen=?, registrationIsOpen=?";
        try {
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            for (int i = 0; i < tournaments.size(); i++) {

                Tournament t = tournaments.get(i);

                pstmt.setInt(1, t.getId());
                pstmt.setString(2, t.getTournamentName());
                pstmt.setString(3, t.getTournamentType());
                pstmt.setBoolean(4, t.isTournamentIsOpen());
                pstmt.setBoolean(5, t.isRegistrationIsOpen());


                pstmt.setBoolean(6, t.isTournamentIsOpen());
                pstmt.setBoolean(7, t.isRegistrationIsOpen());

                pstmt.addBatch();

            }

            pstmt.executeBatch();


        } catch (SQLException e) {

            e.printStackTrace();


        }

    }

    //readTournamentData metoden returner en Arrayliste af al den team data der findes i databasen
    @Override
    public ArrayList<Tournament> readTournamentData() {
        ArrayList<Tournament> tournaments = new ArrayList<>();
        Connection conn = null;
        Statement stmt = null;
        try {
            //STEP 2: Register JDBC driver
            // Class.forName("com.mysql.jdbc.Driver");

            //STEP 3: Open a connection
            //System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            //STEP 4: Execute a query
            //System.out.println("Creating statement...");
            stmt = conn.createStatement();

            String sql = "SELECT * FROM Tournament";
            ResultSet rs = stmt.executeQuery(sql);

            //STEP 5: Extract data from result set
            while (rs.next()) {
                //Retrieve by column name
                int id = rs.getInt("ID");
                String tournamentName = rs.getString("tournamentName");
                String tournamentType = rs.getString("tournamentType");
                boolean tournamentIsOpen = rs.getBoolean("tournamentIsOpen");
                boolean registrationIsOpen = rs.getBoolean("registrationIsOpen");

                Tournament t = new Tournament(tournamentName, tournamentType, tournamentIsOpen, registrationIsOpen);
                tournaments.add(t);
            }
            //STEP 6: Clean-up environment
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            //finally block used to close resources
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException se2) {
            }// nothing we can do
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }//end finally try
        }//end try
        //todo: I et andet liv vil man kunne vælge hvilken "tournament" man gerne vil loade.
        Admin.chosenTournament = tournaments.get(0);
        return tournaments;
    }

    // saveTeamData metoden gemmer det enkelte team til en database med alle teams
    @Override
    public void saveTeamData(Team t) {
        Connection conn = null;
        String sql = "INSERT INTO Team(ID, teamName, totalScore, numberOfGoals) "
                + "VALUES (?,?,?,?) ON DUPLICATE KEY UPDATE totalScore=?, numberOfGoals=?";
        try {
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            //for(int i = 0; i <  teamArrayList.size(); i++){


            pstmt.setInt(1, t.getId());
            pstmt.setString(2, t.getTeamName());
            pstmt.setInt(3, t.getTotalScore());
            pstmt.setInt(4, t.getNumberOfGoals());


            pstmt.setInt(5, t.getTotalScore());
            pstmt.setInt(6, t.getNumberOfGoals());

            pstmt.addBatch();

            // }

            pstmt.executeBatch();


        } catch (SQLException e) {

            e.printStackTrace();


        }


    }

    //readTeamData metoden returner en Arrayliste af al den team data der findes i databasen
    @Override
    public ArrayList<Team> readTeamData() {
        ArrayList<Team> teamList = new ArrayList<>();
        Connection conn = null;
        Statement stmt = null;
        try {
            //STEP 2: Register JDBC driver
            // Class.forName("com.mysql.jdbc.Driver");

            //STEP 3: Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            //STEP 4: Execute a query
            System.out.println("Creating statement...");
            stmt = conn.createStatement();

            String sql = "SELECT * FROM Team";
            ResultSet rs = stmt.executeQuery(sql);

            //STEP 5: Extract data from result set
            while (rs.next()) {
                //Retrieve by column name
                int id = rs.getInt("ID");
                String teamName = rs.getString("teamName");

                int totalScore = rs.getInt("totalScore");
                int numberOfGoals = rs.getInt("numberOfGoals");

                Team t = new Team(teamName, totalScore, numberOfGoals);
                teamList.add(t);
            }
            //STEP 6: Clean-up environment
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            //finally block used to close resources
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException se2) {
            }// nothing we can do
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }//end finally try
        }//end try
        return teamList;
    }

}
