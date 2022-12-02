package dev.kearls;

import java.io.IOException;
import java.util.List;
import static dev.kearls.Common.getInput;

public class RockPaperScissors {
    enum Move {
        ROCK,
        PAPER,
        SCISSORS
    }


    private static final Integer LOST_SCORE=0;
    private static final Integer DRAW_SCORE=3;
    private static final Integer WIN_SCORE=6;

    // TODO define enums?  A for Rock, B for Paper, and C for Scissors for my opponent
    // X for Rock, Y for Paper, and Z for Scissors
    public int getTotalScore(String filename) throws IOException {
        List<String> lines = getInput(filename);
        int totalScore = 0;
        for (String line : lines) {
            int scoreForThisRound = 0;
            var moves = line.split(" ");
            var opponentsMove = moves[0];
            var myMove = moves[1];

            // The score for a single round is the score for the shape you selected (1 for Rock, 2 for Paper, and 3 for Scissors)
            // plus the score for the outcome of the round (0 if you lost, 3 if the round was a draw, and 6 if you won).
            scoreForThisRound = getScoreForMyMove(scoreForThisRound, myMove);
            var blah = getScoreVsOpponent(opponentsMove, myMove);
            scoreForThisRound += blah;
            //System.out.println("Score for this round is: " + blah);
            totalScore += scoreForThisRound;
        }

        return totalScore;
    }

    private Move mapMove(String value) {  // TODO test this
        Move move = null;
        switch (value) {
            case "A", "X": {
                move = Move.ROCK;
                break;
            }
            case "B", "Y" : {
                move = Move.PAPER;
                break;
            }
            case "C", "Z": {
                move = Move.SCISSORS;
                break;
            }
        }

        return move;
    }

    public int getPart2Score(String filename) throws IOException {
        List<String> lines = getInput(filename);
        int totalScore = 0;
        for (String line : lines) {
            int scoreForThisRound = 0;
            var moves = line.split(" ");
            var opponentsMove = moves[0];
            var outcome = moves[1];

            // The score for a single round is the score for the shape you selected (1 for Rock, 2 for Paper, and 3 for Scissors)
            // plus the score for the outcome of the round (0 if you lost, 3 if the round was a draw, and 6 if you won).
            String myMove="";
            myMove = getMyMove(opponentsMove, outcome);
            scoreForThisRound = getScoreForMyMove(scoreForThisRound, myMove);
            var blah = getScoreVsOpponent(opponentsMove, myMove);
            scoreForThisRound += blah;
            //System.out.println("Score for this round is: " + blah);
            totalScore += scoreForThisRound;
        }

        return totalScore;
    }

    private String getMyMove(String opponentsMove, String outcome) {
        String myMove = "";
        switch (outcome) {
            // X means you need to lose, Y means you need to end the round in a draw, and Z means you need to win.
            // A for Rock, B for Paper, and C for Scissors for my opponent
            // X for Rock, Y for Paper, and Z for Scissors
            // Rock wins against scissors; paper wins against rock; and scissors wins against paper.
            case "X":  // TODO I need to lose
                //scoreForThisRound += 1;
                switch (opponentsMove) {
                    case "A": // rock
                        myMove = "Z";
                        break;
                    case "B": // paper
                        myMove = "X";
                        break;
                    case "C": // scissors
                        myMove = "Y";
                        break;
                }
                break;
            case "Y": // I need to draw
                //scoreForThisRound += 2;
                switch (opponentsMove) {
                    case "A": // rock
                        myMove = "X";
                        break;
                    case "B": // paper
                        myMove = "Y";
                        break;
                    case "C": // scissors
                        myMove = "Z";
                        break;
                }
                break;
            case "Z":  // I need to win
                //scoreForThisRound += 3;
                switch (opponentsMove) {
                    case "A": // rock
                        myMove = "Y";
                        break;
                    case "B": // paper
                        myMove = "Z";
                        break;
                    case "C": // scissors
                        myMove = "X";
                        break;
                }
                break;
            default:
                System.out.println("We should never get here");
        }
        return myMove;
    }

    private static int getScoreForMyMove(int scoreForThisRound, String myMove) {
        switch (myMove) {
            case "X":
                scoreForThisRound += 1;
                break;
            case "Y":
                scoreForThisRound += 2;
                break;
            case "Z":
                scoreForThisRound += 3;
                break;
        }
        return scoreForThisRound;
    }

    public int getScoreVsOpponent(String opponentsMove, String myMove) {
        if ((myMove.equals("X") && opponentsMove.equals("A")) || (myMove.equals("Y") && opponentsMove.equals("B")) || (myMove.equals("Z") && opponentsMove.equals("C"))) {
            return DRAW_SCORE;
            // TODO does this cover all moves?  Could we put it in a map?
        } else if ((myMove.equals("Y") && opponentsMove.equals("A")) || (myMove.equals("Z") && opponentsMove.equals("B")) || (myMove.equals("X") && opponentsMove.equals("C"))){
            return WIN_SCORE;
        } else {
            return LOST_SCORE;
        }
    }
}
