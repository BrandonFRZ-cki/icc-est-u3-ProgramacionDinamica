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
    }
}
