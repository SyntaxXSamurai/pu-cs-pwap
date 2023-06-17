public class HelloGoodbyeAdvanced {
    /*
     * Description: The program HelloGoodbye.java takes two names as command-line arguments and prints hello and goodbye messages 
     * (with the names for the hello message in the same order as the command-line arguments and with the names for the goodbye 
     * message in reverse order)
     */
    public static void main(String[] args) {
        // First check that there are 2 arguments
        if (args.length == 2) {
            // Reading in first argument
            String sName1 = args[0];
            String sName2 = args[1];

            // Print Hello Name1 + Name2
            System.out.println("Hello " +  sName1 + " and " + sName2 + ".");

            // Print Goodbye Name2 + Name1
            System.out.println("Goodbye " + sName2 + " and " + sName1 + ".");
        } else {
            System.out.println("\nThe program is expecting 2 names:\n\n" + 
                "\tHelloGoodbye Elex Dylan\n");
        }
    } 
}
