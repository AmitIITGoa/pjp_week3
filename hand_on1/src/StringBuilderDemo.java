public class StringBuilderDemo {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            sb.append("Value: ").append(i).append(System.lineSeparator());
        }
        System.out.println(sb.toString());

        System.out.println("Performance check:");
        long start = System.nanoTime();
        String message = buildWithConcat();
        long end = System.nanoTime();
        System.out.println("Concatenation time (ns): " + (end - start));

        long startBuilder = System.nanoTime();
        String messageBuilder = buildWithStringBuilder();
        long endBuilder = System.nanoTime();
        System.out.println("StringBuilder time (ns): " + (endBuilder - startBuilder));
        System.out.println(messageBuilder);
    }

    public static String buildWithConcat() {
        String text = "";
        for (int i = 0; i < 1000; i++) {
            text += i + " ";
        }
        return text;
    }

    public static String buildWithStringBuilder() {
        // StringBuilder is preferred over String concatenation inside a loop because concatenation creates a new String object every iteration, which increases memory use and slows execution.
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 1000; i++) {
            sb.append(i).append(' ');
        }
        return sb.toString();
    }
}
