import java.util.Arrays;
import java.util.List;

public class App {
    public static void main(String[] args) {
        //runEjerciciosPD();
        runMaze();
    }

    public static void runEjerciciosPD() {
        EjerciciosPD ejerciciosPD = new EjerciciosPD();
        long startTime = System.nanoTime();
        long resultado = ejerciciosPD.getFibonacci(50);
        long endTime = System.nanoTime();

        long duration = endTime - startTime;
        System.out.println("Recursivo:\nFibonacci de 5: " + resultado + " en tiempo: " + duration);

        startTime = System.nanoTime();
        resultado = ejerciciosPD.getFibonacciPD(50);
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println("Catching:\nFibonacci de 5: " + resultado + " en tiempo: " + duration);
    }
    public static void runMaze(){
        boolean[][] predefinedMaze = {
                 {true, true , true,true}
                ,{false, true , true,true}
                ,{true, true , false,false}
                ,{true, true , true,true}
        };
        Maze maze = new Maze(predefinedMaze);
        System.out.println("\n========== Laberinto:\n");
        maze.printMaze();

        Cell start = new Cell(0,0);
        Cell end = new Cell(3,3);

        List<MazeSolver> solvers= Arrays.asList(
                new MazeSolverRecursive(),
                new MazeSolverCompleteRecursive()
        );
        MazeSolver solver = solvers.get(0);
        List<Cell> path ;
        path = solver.getPath(maze.getGrid(),start,end);

        System.out.println("\nCamino Encontrado:\n - Recursivo derecha / Abajo ");
        System.out.println(path);

        System.out.println("\nCamino Encontrado:\n - Recursivo Completo");
        MazeSolver solverComplete = solvers.get(1);
        path = solverComplete.getPath(maze.getGrid(),start,end);
        System.out.println(path);

    }
}
