public class ThreeSort {
    public static void main(String[] args) {
        int iNumber1 = Integer.parseInt(args[0]);
        int iNumber2 = Integer.parseInt(args[1]);
        int iNumber3 = Integer.parseInt(args[2]);

        System.out.println(Math.min(Math.min(iNumber1, iNumber2), iNumber3));

        System.out.println(Math.min(
            Math.max(
                Math.min(iNumber1, iNumber2), 
                iNumber3
            ),
            Math.max(
                Math.min(iNumber2, iNumber3), 
                iNumber1
            )
        ));
        
        System.out.println(Math.max(Math.max(iNumber1, iNumber2), iNumber3));
    }    
}
