public class UniformRandomNumbers {
    public static void main(String[] args) {
        double dRandomNumber1 = Math.random();
        double dRandomNumber2 = Math.random();
        double dRandomNumber3 = Math.random();
        double dRandomNumber4 = Math.random();
        double dRandomNumber5 = Math.random();

        System.out.println(dRandomNumber1);
        System.out.println(dRandomNumber2);
        System.out.println(dRandomNumber3);
        System.out.println(dRandomNumber4);
        System.out.println(dRandomNumber5);
        System.out.println();

        System.out.println("Average: " + (dRandomNumber1 + dRandomNumber2 + dRandomNumber3 + dRandomNumber4 + dRandomNumber5) / 5);
        
        System.out.println("Minimum: " + 
            Math.min(
                Math.min(
                    Math.min(
                        Math.min(dRandomNumber1, 
                            dRandomNumber2), 
                        dRandomNumber3), 
                    dRandomNumber4), 
                dRandomNumber5)
            );
        
        System.out.println("Maximum: " + 
            Math.max(
                Math.max(
                    Math.max(
                        Math.max(dRandomNumber1, 
                            dRandomNumber2), 
                        dRandomNumber3), 
                    dRandomNumber4), 
                dRandomNumber5)
            );
    }    
}
