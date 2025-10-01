public class Luke {
    public static final String GREETING = """
            ____________________________________________________________
             Hello! I'm Luke
             What can I do for you?
            ____________________________________________________________
            """;
    public static final String EXIT_RESPONSE = """
            ____________________________________________________________
            Bye Bye
            ____________________________________________________________
            """;

    public static void main(String[] args) {
        System.out.println(GREETING);

        List list1 = new List();
        FileHandler fileHandler = new FileHandler(list1);
        new Parser(list1, fileHandler);

        System.out.println(EXIT_RESPONSE);
    }
}
