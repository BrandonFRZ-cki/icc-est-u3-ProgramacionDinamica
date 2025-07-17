import java.util.ArrayList;
import java.util.List;

public class MazeSolverCompleteRecursive implements MazeSolver {
    @Override
    public List<Cell> getPath(boolean[][] grid, Cell start, Cell end) {
        List<Cell> path = new ArrayList<>();
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        if (grid == null || grid.length == 0) return path;
        if (findPath(grid, start, end, path, visited)) return path;
        return new ArrayList<>();
    }
    private boolean findPath(boolean[][] grid, Cell start, Cell end, List<Cell> path, boolean[][] visited) {
        int row = start.fila;
        int col = start.columna;

        if (row < 0) return false;
        if (col < 0) return false;
        if (row >= grid.length) return false;
        if (col >= grid[0].length) return false;

        if (!grid[row][col]) return false;
        if (visited[row][col]) return false;
        visited[row][col] = true;
        if (row == end.fila && col == end.columna) {
            path.add(start);
            return true;
        }
        if (findPath(grid, new Cell(row + 1, col), end, path, visited)) {
            path.add(start);
            return true;
        }

        if (findPath(grid, new Cell(row - 1, col), end, path, visited)) {
            path.add(start);
            return true;
        }

        if (findPath(grid, new Cell(row, col + 1), end, path, visited)) {
            path.add(start);
            return true;
        }

        if (findPath(grid, new Cell(row, col - 1), end, path, visited)) {
            path.add(start);
            return true;
        }

        return false;
    }
}
