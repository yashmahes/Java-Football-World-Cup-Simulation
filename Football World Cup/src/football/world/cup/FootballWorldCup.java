package football.world.cup;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FootballWorldCup {

    public static String getSpace(String name) {
        int len = 11 - name.length();

        String spaces = "";
        for (int i = 0; i < len; i++) {
            spaces += " ";
        }

        return spaces;

    }

    // to read a file
    public static List<String> readFile(String filename) {

        List<String> records = new ArrayList<>();
        try {
            try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    records.add(line);

                }
            }
            return records;
        } catch (IOException e) {
            System.err.format("Exception occurred trying to read '%s'.", filename);
            return null;
        }

    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        List<String> details = readFile("teams.txt");

        ArrayList<Team> teams = new ArrayList<>();
        Team winnerTeam = new Team();

        for (int i = 0; i < 4; i++) {
            String[] split = details.get(i).split(" ");
            String name = split[0].trim();
            int ranking = Integer.parseInt(split[1].trim());

            Team t = new Team();
            t.setName(name);
            t.setRanking(ranking);

            System.out.println("Please enter the names of two players in " + name + " team who will be the goal scorers.");

            String p1Name = sc.next();
            String p2Name = sc.next();

            Player pl = new Player(p1Name, 0);
            Player p2 = new Player(p2Name, 0);

            t.setPlayer1(pl);
            t.setPlayer2(p2);

            teams.add(t);

        }

        boolean isPreliminaryPlayed = false;
        while (true) {
            String choice = Menu.display();
            choice = choice.trim();
            if (choice.equals("X")) {
                System.out.println("Bye!!");
                break;
            } else if (choice.equals("A")) {
                System.out.println("Preliminary stage ");
                isPreliminaryPlayed = true;

                Game game1 = new Game();
                game1.addTeams(teams.get(0), teams.get(1));
                game1.playGame();
                game1.displayGameResult();

                Team team1 = game1.getTeam1();
                Team team2 = game1.getTeam2();

                teams.set(0, team1);
                teams.set(1, team2);

                Game game2 = new Game();
                game2.addTeams(teams.get(1), teams.get(2));
                game2.playGame();
                game2.displayGameResult();

                team1 = game2.getTeam1();
                team2 = game2.getTeam2();

                teams.set(1, team1);
                teams.set(2, team2);

                Game game3 = new Game();
                game3.addTeams(teams.get(2), teams.get(3));
                game3.playGame();
                game3.displayGameResult();

                team1 = game3.getTeam1();
                team2 = game3.getTeam2();

                teams.set(2, team1);
                teams.set(3, team2);

                Game game4 = new Game();
                game4.addTeams(teams.get(3), teams.get(0));
                game4.playGame();
                game4.displayGameResult();

                team1 = game4.getTeam1();
                team2 = game4.getTeam2();

                teams.set(3, team1);
                teams.set(0, team2);

                Game game5 = new Game();
                game5.addTeams(teams.get(1), teams.get(3));
                game5.playGame();
                game5.displayGameResult();

                team1 = game5.getTeam1();
                team2 = game5.getTeam2();

                teams.set(1, team1);
                teams.set(3, team2);

                Game game6 = new Game();
                game6.addTeams(teams.get(0), teams.get(2));
                game6.playGame();
                game6.displayGameResult();

                team1 = game6.getTeam1();
                team2 = game6.getTeam2();

                teams.set(0, team1);
                teams.set(2, team2);

                for (int i = 0; i < teams.size() - 1; i++) {
                    for (int j = i + 1; j < teams.size(); j++) {
                        if (teams.get(i).getOverall_points() < teams.get(j).getOverall_points()) {
                            team1 = teams.get(i);
                            team2 = teams.get(j);
                            teams.set(j, team1);

                            teams.set(i, team2);
                        } else if (teams.get(i).getOverall_points() == teams.get(j).getOverall_points()) {
                            if (teams.get(i).totalGoals < teams.get(j).totalGoals) {
                                team1 = teams.get(i);
                                team2 = teams.get(j);
                                teams.set(j, team1);

                                teams.set(i, team2);
                            }
                        }

                    }
                }

                System.out.println("Team    Played   Won   Lost Drawn   Goals   Points  Fair Play Score");

                for (int i = 0; i < teams.size(); i++) {
                    Team t = teams.get(i);
                    System.out.println("" + t.getName() + getSpace(t.getName()) + t.getTotalPlayed() + "       " + t.getTotalGamesWon() + "     "
                            + t.getTotalGamesLost() + "     " + t.getTotalGamesDrawn() + "      " + t.getTotalGoals() + "       " + t.getOverall_points()
                            + "         " + (t.getRed_card_score() + t.getYellow_card_score())
                    );

                }

            } else if (choice.equals("B")) {
                if (!isPreliminaryPlayed) {
                    System.out.println("Preliminary stage has not been played, so final stage can's be played");
                    continue;

                }

                System.out.println("Final ");

                Game game1 = new Game();
                game1.addTeams(teams.get(0), teams.get(1));
                game1.playGame();
                game1.playPenaltyShootOut();
                game1.displayGameResult();

                Team team1 = game1.getTeam1();
                Team team2 = game1.getTeam2();

                if (game1.goalsByTeam1 > game1.goalsByTeam2) {
                    teams.set(0, team1);
                    teams.set(1, team2);
                    winnerTeam = teams.get(0);
                } else {
                    teams.set(0, team2);
                    teams.set(1, team1);
                    winnerTeam = teams.get(1);
                }

            } else if (choice.equals("C")) {
                System.out.println("Team    Played   Won   Lost Drawn   Goals   Points  Fair Play Score");

                for (int i = 0; i < teams.size(); i++) {
                    Team t = teams.get(i);
                    System.out.println("" + t.getName() + getSpace(t.getName()) + t.getTotalPlayed() + "       " + t.getTotalGamesWon() + "     "
                            + t.getTotalGamesLost() + "     " + t.getTotalGamesDrawn() + "      " + t.getTotalGoals() + "       " + t.getOverall_points()
                            + "         " + (t.getRed_card_score() + t.getYellow_card_score())
                    );

                }

            } else if (choice.equals("D")) {
                for (int i = 0; i < teams.size(); i++) {
                    Player p1 = teams.get(i).getPlayer1();
                    Player p2 = teams.get(i).getPlayer2();

                    System.out.println(p1.getName() + "(" + teams.get(i).getName() + ") - " + p1.getGoals());
                    System.out.println(p2.getName() + "(" + teams.get(i).getName() + ") - " + p2.getGoals());

                }
            } else if (choice.equals("E")) {
                System.out.println("Football World Cup Winner: " + winnerTeam.getName());
                
                System.out.println("Golden Boot Award: ");
                int maxGoals = 0;
                for(int i=0; i<teams.size(); i++)
                {
                    Player p1 = teams.get(i).getPlayer1();
                    if(p1.getGoals() > maxGoals)
                        maxGoals = p1.getGoals();
                    
                    Player p2 = teams.get(i).getPlayer2();
                    if(p2.getGoals() > maxGoals)
                        maxGoals = p2.getGoals();
                    
                }
                
                
                for(int i=0; i<teams.size(); i++)
                {
                    Player p1 = teams.get(i).getPlayer1();
                    if(p1.getGoals() == maxGoals)
                        System.out.println(p1.getName() + " from " + teams.get(i).getName());
                    
                    Player p2 = teams.get(i).getPlayer2();
                    if(p2.getGoals() == maxGoals)
                       System.out.println(p2.getName() + " from " + teams.get(i).getName());
                    
                    
                }
                
                
                
                
                
                System.out.println("Fair Play Award: ");
                int fair_play_score = 1000;
                for(int i=0; i<teams.size(); i++)
                {
                    if(teams.get(i).getFairPlayScore() < fair_play_score)
                          fair_play_score = teams.get(i).getFairPlayScore();
                    
                
                }
                
                for(int i=0; i<teams.size(); i++)
                {
                    if(teams.get(i).getFairPlayScore() == fair_play_score)
                          System.out.println(teams.get(i).getName());
                    
                
                }
                
                
                
            }
            
            
            else {
                System.out.println("Invalid choice. Please try again.");
            }

        }

    }

}
