public class HelloGoodbye {
    /*
     * Description: The program HelloGoodbye.java takes two names as command-line arguments and prints hello and goodbye messages 
     * (with the names for the hello message in the same order as the command-line arguments and with the names for the goodbye 
     * message in reverse order)
     */
    public static void main(String[] args) {
        // Reading in first argument
        String sName1 = args[0];
        String sName2 = args[1];

        // Print Hello Name1 + Name2
        System.out.println("Hello " +  sName1 + " and " + sName2 + ".");

        // Print Goodbye Name2 + Name1
        System.out.println("Goodbye " + sName2 + " and " + sName1 + ".");
    } 
}
