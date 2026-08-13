public class SmartCalculator {
    public static void main(String[] args) {
        // Block 1: integer division
        int a = 17, b = 5;
        System.out.println(a / b);
        System.out.println(a % b);
        System.out.println((double) a / b);

        // Block 2: Integer cache
        Integer x = 127;
        Integer y = 127;
        Integer p = 200;
        Integer q = 200;
        System.out.println(x == y);
        System.out.println(p == q);
        System.out.println(p.equals(q));
        // Integer values from -128 to 127 are cached, so line 4 and line 5 produce different results because 127 reuses the same cached object while 200 is outside the cache range and creates separate objects.
    }
}
