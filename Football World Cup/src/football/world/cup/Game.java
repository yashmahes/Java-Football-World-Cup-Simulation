package football.world.cup;

import java.util.ArrayList;

public class Game {

    private ArrayList<Team> teams = new ArrayList<>();
    public int goalsByTeam1;
    public int goalsByTeam2;
    
    private ArrayList<String> cardsAwarded = new ArrayList<>();

    public Game() {
    }

    public void addTeams(Team t1, Team t2) {
        teams.add(t1);
        teams.add(t2);
    }

    public void playGame() {

        if (teams.get(0).getRanking() > teams.get(1).getRanking()) {
            goalsByTeam1 = RandomGoalsGenerator.numberOfGoals(0);
            goalsByTeam2 = RandomGoalsGenerator.numberOfGoals(teams.get(0).getRanking() - teams.get(1).getRanking());

        } else {
            goalsByTeam2 = RandomGoalsGenerator.numberOfGoals(0);
            goalsByTeam1 = RandomGoalsGenerator.numberOfGoals(teams.get(0).getRanking() - teams.get(1).getRanking());

        }
        if (goalsByTeam1 != 0) {
            int rand1 = (int) (1 + Math.random() * goalsByTeam1);
            teams.get(0).player1.goals += rand1;
            teams.get(0).player2.goals += goalsByTeam1 - rand1;
        }

        if (goalsByTeam2 != 0) {
            int rand2 = (int) (1 + Math.random() * goalsByTeam2);
            teams.get(1).player1.goals += rand2;
            teams.get(1).player2.goals += goalsByTeam2 - rand2;

        }
        
        
        int team1Card = (int) (Math.random()*6);
        if(team1Card == 0)
        {
            cardsAwarded.add(teams.get(0).getName() +" - 1 red card.");
            teams.get(0).red_card_score += 2;
        }
        
        if(team1Card == 1 || team1Card == 2 || team1Card == 3 )
        {
            cardsAwarded.add(teams.get(0).getName() +" - 1 yellow card.");
            teams.get(0).yellow_card_score += 1;
        }
        
        int team2Card = (int) (Math.random()*6);
        if(team2Card == 0)
        {
            cardsAwarded.add(teams.get(1).getName() +" - 1 red card.");
            teams.get(1).red_card_score += 2;
        }
        
        if(team2Card == 1 || team2Card == 2 || team2Card == 3 )
        {
            cardsAwarded.add(teams.get(1).getName() +" - 1 yellow card.");
            teams.get(1).yellow_card_score += 1;
        }
        
        
    }

    public void playPenaltyShootOut() {
        while (goalsByTeam1 == goalsByTeam2) {

            goalsByTeam1 += Math.random() * 6;
            goalsByTeam2 += Math.random() * 6;

        }

    }

    public void displayGameResult() {
        System.out.println("Game result: " + teams.get(0).getName() + " " + goalsByTeam1 + "  vs. " + teams.get(1).getName() + " " + goalsByTeam2);

        System.out.println("Cards awarded: ");
        for(int i=0; i<cardsAwarded.size(); i++)
        {
            System.out.println(cardsAwarded.get(i));
        }
        
        teams.get(0).totalPlayed += 1;
        teams.get(1).totalPlayed += 1;

        teams.get(0).totalGoals += goalsByTeam1;
        teams.get(1).totalGoals += goalsByTeam2;

        if (goalsByTeam1 > goalsByTeam2) {
            teams.get(0).totalGamesWon += 1;
            teams.get(1).totalGamesLost += 1;

            teams.get(0).overall_points += 3;

        }

        if (goalsByTeam1 < goalsByTeam2) {
            teams.get(1).totalGamesWon += 1;
            teams.get(0).totalGamesLost += 1;

            teams.get(1).overall_points += 3;

        }

        if (goalsByTeam1 == goalsByTeam2) {
            teams.get(1).totalGamesDrawn += 1;
            teams.get(0).totalGamesDrawn += 1;

            teams.get(1).overall_points += 1;
            teams.get(0).overall_points += 1;
        }

    }

    public Team getTeam1() {
        return teams.get(0);
    }

    public Team getTeam2() {
        return teams.get(1);
    }

}
