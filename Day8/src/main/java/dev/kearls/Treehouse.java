package dev.kearls;

import java.io.IOException;
import java.util.List;
import static dev.kearls.Common.getInput;

public class Treehouse {
    public int countVisibleTrees(String filename) throws IOException {
        int visible = 0;
        List<String> lines = getInput(filename);
        int rows = lines.size();
        int columns = lines.get(0).length();
        int[][] grid = getGrid(lines, rows, columns);

        // All outside squares are visible - how to calculate this?
        int edges = ((rows + columns) * 2) - 4;
        System.out.println("Grid size: rows " + rows + " columns " + columns + " edges " + edges);

        // look at all interior trees
        for (int row = 1; row < rows - 1; row ++) {
            for (int col = 1; col < columns - 1; col++) {
                if (isTreeVisible(row, col, grid)) {
                    visible++;
                }
            }
        }

        return visible + edges;
    }

    public int getBestScenicScore(String filename) throws IOException {
        int bestScenicScore = Integer.MIN_VALUE;
        List<String> lines = getInput(filename);
        int rows = lines.size();
        int columns = lines.get(0).length();
        int[][] grid = getGrid(lines, rows, columns);

        // Get a scenic score for all interior trees - I don't *think* we need to consider edge tree...
        for (int row = 1; row < rows - 1; row ++) {
            for (int col = 1; col < columns - 1; col++) {
                int scoreForCurrentTree = getTreeScore(row, col, grid);
                //System.out.println("Score for [" + row + ", " + col +"] is " + scoreForCurrentTree);
                if (scoreForCurrentTree > bestScenicScore) {
                    bestScenicScore = scoreForCurrentTree;
                }
            }
        }

        return bestScenicScore;
    }

    public int getTreeScore(int row, int column, int[][]grid) {
        int upScore=0, downScore = 0, leftScore=0, rightScore=0;
        int targetHeight = grid[row][column];
        int height = grid.length;
        int width = grid[0].length;

        for (int r = row-1; r >= 0; r--) {
            upScore++;
            if (grid[r][column] >= targetHeight) {
                break;
            }
        }

        for (int r = row + 1; r < height; r++) {
            downScore++;
            if (grid[r][column] >= targetHeight) {
                break;
            }
        }

        // Left -- are these backwards???
        for (int c = column - 1; c >= 0; c--) {
            leftScore++;
            if (grid[row][c] >= targetHeight) {
                break;
            }
        }

        // Right
        for (int c = column + 1 ; c < width; c++) {
            rightScore++;
            if (grid[row][c] >= targetHeight) {
                break;
            }
        }


        int totalScore = upScore * downScore * leftScore * rightScore;
        //System.out.println("For square [" + row + "," + column + "]: Up: " + upScore + " down: " + downScore + " left: " + leftScore + " right: " + rightScore + " total: " + totalScore );

        return totalScore;
    }

    // This is a brute force solution...we need to be careful about double counting
    public boolean isTreeVisible(int row, int column, int[][] grid) {
        int height = grid.length;
        int width = grid[0].length;

        boolean visibleUp = true;
        boolean visibleDown = true;
        boolean visibleLeft = true;
        boolean visibleRight = true;

        // TODO extract each of these to separate methods
        // We need to look up, down, left, right
        int targetHeight = grid[row][column];
        for (int r = row-1; r >= 0; r--) {
            if (grid[r][column] >= targetHeight) {
                visibleUp = false;
                break;
            }
        }

        for (int r = row + 1; r < height; r++) {
            if (grid[r][column] >= targetHeight) {
                visibleDown = false;
                break;
            }
        }

        // Left -- are these backwards???
        for (int c = column - 1; c >= 0; c--) {
            if (grid[row][c] >= targetHeight) {
                visibleLeft = false;
                break;
            }
        }

        // Right
        for (int c = column + 1 ; c < width; c++) {
            if (grid[row][c] >= targetHeight) {
                visibleRight = false;
                break;
            }
        }

        if (visibleUp || visibleDown || visibleLeft || visibleRight) {
            return true;
        } else {
            return  false;
        }
    }

    private static int[][] getGrid(List<String> lines, int rows, int columns) {
        // This assumes input -s non-zero and all lines are the same length
        var grid = new int[rows][columns];
        for (int row = 0; row < rows; row++) {
            String line = lines.get(row);
            var entries = line.toCharArray();
            int col = 0;
            for (char entry : entries) {
                grid[row][col] = entry - '0';
                col++;
            }
        }
        return grid;
    }
}
