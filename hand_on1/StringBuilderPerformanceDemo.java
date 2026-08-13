public class StringBuilderPerformanceDemo {
    public static void main(String[] args) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            builder.append("Java ").append(i).append(" ");
        }
        System.out.println(builder.toString());

        String concatenated = "";
        for (int i = 0; i < 10; i++) {
            concatenated += "Java " + i + " ";
        }
        System.out.println(concatenated);

        explainWhyStringBuilder();
    }

    public static void explainWhyStringBuilder() {
        // StringBuilder is preferred over String concatenation inside a loop because repeated '+' creates a new String object on every iteration, which wastes memory and slows performance, while StringBuilder appends to the same mutable buffer.
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            sb.append("Week ").append(i + 1).append(" ");
        }
        System.out.println(sb.toString());
    }
}
