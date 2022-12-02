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


    public int getTotalScore(String filename) throws IOException {
        List<String> lines = getInput(filename);
        int totalScore = 0;
        for (String line : lines) {
            int scoreForThisRound = 0;
            var moves = line.split(" ");
            var opponentsMove = mapMove(moves[0]);
            var myMove = mapMove(moves[1]);

            // The score for a single round is the score for the shape you selected (1 for Rock, 2 for Paper, and 3 for Scissors)
            // plus the score for the outcome of the round (0 if you lost, 3 if the round was a draw, and 6 if you won).
            scoreForThisRound = getScoreForMyMove(scoreForThisRound, myMove);
            var blah = getScoreVsOpponent(opponentsMove, myMove);
            scoreForThisRound += blah;
            totalScore += scoreForThisRound;
        }

        return totalScore;
    }

    // A for Rock, B for Paper, and C for Scissors for my opponent
    // X for Rock, Y for Paper, and Z for Scissors
    private Move mapMove(String value) {
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
            var opponentsMove = mapMove(moves[0]);
            var outcome = moves[1];

            // The score for a single round is the score for the shape you selected (1 for Rock, 2 for Paper, and 3 for Scissors)
            // plus the score for the outcome of the round (0 if you lost, 3 if the round was a draw, and 6 if you won).
            var myMove = getMyMove(opponentsMove, outcome);
            scoreForThisRound = getScoreForMyMove(scoreForThisRound, myMove);
            var blah = getScoreVsOpponent(opponentsMove, myMove);
            scoreForThisRound += blah;
            //System.out.println("Score for this round is: " + blah);
            totalScore += scoreForThisRound;
        }

        return totalScore;
    }

    // X means you need to lose, Y means you need to end the round in a draw, and Z means you need to win.
    private Move getMyMove(Move opponentsMove, String outcome) {  // TODO should I map outcome too?
        Move myMove = null;
        switch (outcome) {
            case "X":  // I need to lose
                switch (opponentsMove) {
                    case ROCK: // rock
                        myMove = Move.SCISSORS;
                        break;
                    case PAPER: // paper
                        myMove = Move.ROCK;
                        break;
                    case SCISSORS: // scissors
                        myMove = Move.PAPER;
                        break;
                }
                break;
            case "Y": // I need to draw
                switch (opponentsMove) {
                    case ROCK: // rock
                        myMove = Move.ROCK;
                        break;
                    case PAPER: // paper
                        myMove = Move.PAPER;
                        break;
                    case SCISSORS: // scissors
                        myMove = Move.SCISSORS;
                        break;
                }
                break;
            case "Z":  // I need to win
                switch (opponentsMove) {
                    case ROCK: // rock
                        myMove = Move.PAPER;
                        break;
                    case PAPER: // paper
                        myMove = Move.SCISSORS;
                        break;
                    case SCISSORS: // scissors
                        myMove = Move.ROCK;
                        break;
                }
                break;
            default:
                System.out.println("We should never get here");
        }
        return myMove;
    }

    private static int getScoreForMyMove(int scoreForThisRound, Move myMove) {
        switch (myMove) {
            case ROCK:
                scoreForThisRound += 1;
                break;
            case PAPER:
                scoreForThisRound += 2;
                break;
            case SCISSORS:
                scoreForThisRound += 3;
                break;
        }
        return scoreForThisRound;
    }

    public int getScoreVsOpponent(Move opponentsMove, Move myMove) {
        if (myMove.equals(opponentsMove)) {
            return DRAW_SCORE;
        } else if ((myMove.equals(Move.ROCK) && opponentsMove.equals(Move.SCISSORS))
                || (myMove.equals(Move.PAPER) && (opponentsMove.equals(Move.ROCK)))
                || (myMove.equals(Move.SCISSORS) && opponentsMove.equals(Move.PAPER))) {
            return WIN_SCORE;
        } else {
            return LOST_SCORE;
        }
    }
}
