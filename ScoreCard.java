/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package course.project.program;

/**
 *
 * @author pierr
 */
public class ScoreCard {
    int[] score = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    String playerName;
    
    public ScoreCard()
    {
        playerName = "";
        
        for (int i = 0; i < score.length; i++)
        {
            score[i] = 0;
        }
    }
    
    public ScoreCard(String name)
    {
        playerName = name;
        
        for (int i = 0; i < score.length; i++)
        {
            score[i] = 0;
        }
    }
    
    public ScoreCard(String name, int[] scoreArray)
    {
        playerName = name;
        
        for (int i = 0; i < score.length; i++)
        {
            score[i] = scoreArray[i];
        }
    }
    
    public void setScore(int[] scoreArray)
    {
        for (int i = 0; i < score.length; i++)
        {
            score[i] = scoreArray[i];
        }
    }
    
    public void setPlayerName(String name)
    {
        playerName = name;
    }

    public int getScore(int pos)
    {
        return score[pos - 1];
    }
    
    public String getPlayerName()
    {
        return playerName;
    }
    
    public void resetGame()
    {
        for (int i = 0; i < score.length; i++)
        {
            score[i] = 0;
        }
    }
    
    public void enterScore(int pos, int num)
    {
        if (pos > 18 || pos < 1)
            System.out.println("Invalid input. Please enter a hole number between 1 and 18.");
        else
        {
            if (num > 5)
            {
                score[pos - 1] = 5;
                System.out.println("Maximum score is 5. Score set to 5.");
            }
            else if (num < 1)
            {
                score[pos - 1] = 1;
                System.out.println("Minimum score is 1. Score set to 1.");
            }
            else
            {
                score[pos - 1] = num;
            }
        }
    }
    
    public void showScore()
    {
        System.out.print(playerName + ": ");
        
        for (int i : score)
        {
            System.out.print(i + " ");
        }
        System.out.println();
    }
    
    public int totalScore()
    {
        int total = 0;
        
        for (int i : score)
        {
            total += i;
        }
        
        return total;
    }
    
}