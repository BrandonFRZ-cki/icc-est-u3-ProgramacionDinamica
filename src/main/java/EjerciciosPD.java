import java.util.HashMap;
import java.util.Map;

public class EjerciciosPD {
    public long getFibonacci(int n) {
        if (n<=1) return n;
        return getFibonacci(n-1) +getFibonacci(n-2);
    }
    public long getFibonacciPD(int n) {
        Map<Integer,Long> catching = new HashMap<>();
        if(n<=1) return n;
        catching.put(0, 1L);
        return getFibonacciPDHelper(n,catching);

    }
    private long getFibonacciPDHelper(int n,Map<Integer,Long> catching) {
        if (n<=1) return n;
        if(catching.containsKey(n)) return catching.get(n);
        long result = getFibonacciPDHelper(n-1,catching)+getFibonacciPDHelper(n-2,catching);
        catching.put(n,result);
        return result;
    }

}
