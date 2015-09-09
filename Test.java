import java.math.*;

public class Test {

    public static Object test(Object previous) {
        int i = 0;
        Object sum = previous;
        while (i < 1000000) {
            if (sum instanceof Long) {
                sum = (Long) sum + i;
                if ((Long) sum < 0) {
                    // overflow occured
                    sum = BigInteger.valueOf((Long) sum).add(
                            BigInteger.valueOf(i));
                }
            } else {
                sum = ((BigInteger) sum).add(BigInteger.valueOf(i));
            }
            i = i + 1;
        }
        if (sum instanceof Long) {
            sum = ((Long) sum) * 10;
            if ((Long) sum < 0) {
                // overflow occured
                sum = BigInteger.valueOf((Long) sum).multiply(
                        BigInteger.valueOf(10));
            }
        } else {
            sum = ((BigInteger) sum).multiply(BigInteger.valueOf(10));
        }
        return sum;
    }

    public static void main(String[] args) {
        int iteration = 0;
        Object value = 0L;
        while (iteration < 20) {
            long time = System.nanoTime();
            value = test(value);
            long diff = (System.nanoTime() - time);
            iteration = iteration + 1;
            System.out.println("iteration: " + iteration + " time:"
                    + (diff / 1000000) + "ms");
        }
    }
}

