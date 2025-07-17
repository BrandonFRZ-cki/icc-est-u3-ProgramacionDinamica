import java.util.*;

public class MazeSolverRecursivoCompletoBT implements MazeSolver {
    private List<Cell> path;
    private Set<Cell> visited;
    private boolean[][] grid;
    private Cell end;


    public MazeSolverRecursivoCompletoBT() {
        path = new ArrayList<>();
        visited = new LinkedHashSet<>();
    }

    @Override
    public List<Cell> getPath(boolean[][] grid, Cell start, Cell end) {
        path.clear();
        visited.clear();
        this.grid = grid;
        this.end = end;

        if (grid == null || grid.length == 0) return path;
        if (findPath(start)) return path;
        if(findPath(start)){
            System.out.println("CAMINO");
            System.out.println(path);
            System.out.println("Visitados");
            System.out.println(visited);

        }
        return new ArrayList<>();
    }

    private boolean findPath(Cell current) {
        if(!isInMaze(current)) return false;
        if(!isValid(current)) return false;
        visited.add(current);
        path.add(current);

        if(current.equals(end)) return true;

        if(     findPath(new Cell(current.fila, current.columna+1))||
                findPath(new Cell(current.fila+1, current.columna))||
                findPath(new Cell(current.fila, current.columna-1))||
                findPath(new Cell(current.fila-1, current.columna))){
                    return true;
        }
        return false;
    }

    private boolean isValid(Cell current) {
        if(!grid[current.fila][current.columna]||visited.contains(current)) return false;
        return true;
    }

    private boolean isInMaze(Cell current) {
        int row = current.fila;
        int col = current.columna;
        if (row <0 || row >= grid.length || col <0 || col >= grid[0].length) return false;
        return true;
    }
}
