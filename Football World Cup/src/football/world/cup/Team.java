package football.world.cup;

public class Team {

    private String name;
    private int ranking;
    public Player player1;
    public Player player2;
    public int red_card_score = 0;
    public int yellow_card_score = 0;

    public int totalGamesWon = 0;
    public int totalGamesLost = 0;
    public int totalGamesDrawn = 0;
    public int totalPlayed = 0;
    public int totalGoals = 0;
    public int overall_points = 0;

    public Team() {
    }

    public Team(String name, int ranking, Player player1, Player player2) {
        this.name = name;
        this.ranking = ranking;
        this.player1 = player1;
        this.player2 = player2;
    }

    public int getFairPlayScore()
    {
        return red_card_score + yellow_card_score;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTotalPlayed() {
        return totalPlayed;
    }

    public void setTotalPlayed(int totalPlayed) {
        this.totalPlayed = totalPlayed;
    }

    public int getRanking() {
        return ranking;
    }

    public void setRanking(int ranking) {
        this.ranking = ranking;
    }

    public Player getPlayer1() {
        return player1;
    }

    public void setPlayer1(Player player1) {
        this.player1 = player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public void setPlayer2(Player player2) {
        this.player2 = player2;
    }

    public int getRed_card_score() {
        return red_card_score;
    }

    public void setRed_card_score(int red_card_score) {
        this.red_card_score = red_card_score;
    }

    public int getYellow_card_score() {
        return yellow_card_score;
    }

    public void setYellow_card_score(int yellow_card_score) {
        this.yellow_card_score = yellow_card_score;
    }

    public int getTotalGamesWon() {
        return totalGamesWon;
    }

    public void setTotalGamesWon(int totalGamesWon) {
        this.totalGamesWon = totalGamesWon;
    }

    public int getTotalGamesLost() {
        return totalGamesLost;
    }

    public void setTotalGamesLost(int totalGamesLost) {
        this.totalGamesLost = totalGamesLost;
    }

    public int getTotalGamesDrawn() {
        return totalGamesDrawn;
    }

    public void setTotalGamesDrawn(int totalGamesDrawn) {
        this.totalGamesDrawn = totalGamesDrawn;
    }

    public int getTotalGoals() {
        return totalGoals;
    }

    public void setTotalGoals(int totalGoals) {
        this.totalGoals = totalGoals;
    }

    public int getOverall_points() {
        return overall_points;
    }

    public void setOverall_points(int overall_points) {
        this.overall_points = overall_points;
    }

}
