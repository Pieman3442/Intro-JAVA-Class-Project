/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package course.project.program;
    import java.util.Scanner;
    import java.util.ArrayList;
import java.util.InputMismatchException;
/**
 *
 * @author pierr
 */
public class CourseProjectProgram {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    
    Scanner input = new Scanner(System.in);
    
    ScoreCard p1 = new ScoreCard(),
              p2 = new ScoreCard(),
              p3 = new ScoreCard(),
              p4 = new ScoreCard();
    
    ArrayList<ScoreCard> players = new ArrayList<>();
    
    String userInput = "";
    
    do
    {
        System.out.println("Enter one of the following options:\n" +
                           "\"New Player\"\n" +
                           "\"New Game\"\n" +
                           "\"Enter Score\"\n" +
                           "\"Display Winner\"\n" +
                           "\"Exit Game\"");
        userInput = input.nextLine().trim().toLowerCase();
        
        switch(userInput)
        {
            case "new player":
            {
                if (players.size() == 4)
                    System.out.println("Already at max of 4 players. Cannot add more players.");
                else
                {
                    System.out.println("Enter the name of your new player:");
                    String name = input.nextLine();
                    
                    switch (players.size())
                    {
                        case 0:
                        {
                            players.add(p1);
                            p1.setPlayerName(name);
                            break;
                        }
                        case 1:
                        {
                            players.add(p2);
                            p2.setPlayerName(name);
                            break;
                        }
                        case 2:
                        {
                            players.add(p3);
                            p3.setPlayerName(name);
                            break;
                        }
                        case 3:
                        {
                            players.add(p4);
                            p4.setPlayerName(name);
                            break;
                        }
                    }
                }
                break;
            }
            case "new game":
            {
                if (players.size() < 2)
                    System.out.println("Need at least 2 players to start game.");
                else
                {
                    for (ScoreCard p : players)
                    {
                        p.resetGame();
                    }
                }
                break;
            }
            case "enter score":
            {
                if (players.size() < 2)
                    System.out.println("Need at least 2 players to play a game.");
                else
                {
                    try
                    {
                    System.out.println("Player Number:");
                    int playerNum = input.nextInt();
                    
                    System.out.println("Hole Number:");
                    int holeNum = input.nextInt();
                    
                    System.out.println("Score:");
                    int scoreNum = input.nextInt();
                    input.nextLine();
                    
                    if (playerNum >= 1 && playerNum <= players.size())
                    {
                        players.get(playerNum - 1).enterScore(holeNum, scoreNum);
                        
                        for (ScoreCard p : players)
                        {
                            p.showScore();
                        }
                    }
                    else
                        System.out.println("Invalid Input. Please enter a player number between 1 and " + players.size());
                    }
                    catch (InputMismatchException ex)
                    {
                        input.nextLine();
                        System.out.println("Invalid Input. Please enter a number.");
                    }
                }
                break;
            }
            case "display winner":
            {
                if (players.size() < 2)
                    System.out.println("No winner. Need at least 2 players to have a winner.");
                else
                {
                    ScoreCard[] tempPlayers = new ScoreCard[players.size()];

                    for (int i = 0; i < tempPlayers.length; i++)
                    {
                        tempPlayers[i] = players.get(i);
                    }

                    for (int o = 0; o < tempPlayers.length - 1; o++)
                    {
                        for (int i = 0; i < tempPlayers.length - 1; i++)
                        {
                            if (tempPlayers[i].totalScore() > tempPlayers[i + 1].totalScore())
                            {
                                ScoreCard temp = tempPlayers[i];
                                tempPlayers[i] = tempPlayers[i + 1];
                                tempPlayers[i + 1] = temp;
                            }
                        }
                    }

                    int ties = 0;

                    for (int i = 1; i < tempPlayers.length; i++)
                    {
                        if (tempPlayers[0].totalScore() == tempPlayers[i].totalScore())
                            ties++;
                    }

                    String winner = tempPlayers[0].getPlayerName();
                    
                    if (ties != 0)
                    {
                        for (int x = 0; x < ties; x++)
                        {
                            winner += " and " + tempPlayers[x + 1].getPlayerName();
                        }
                        
                        winner += " are currently tied with " + tempPlayers[0].totalScore() + " points!";
                    }
                    else
                    {
                        winner += " is currently winning with " + tempPlayers[0].totalScore() + " points!";
                    }
                    
                    System.out.println(winner);
                }
                break;
            }
            case "exit game":
                break;
            case "exit":
                break;
            default:
            {
                System.out.println("Invalid Input. Please enter one of the available options.");
                break;
            }
        }
    } while (userInput.equals("exit game") == false && userInput.equals("exit") == false);
    
    }
}