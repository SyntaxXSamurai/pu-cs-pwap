/*
 * Description: The program Histogram.java uses a static method histogram() that 
 * takes an int array a[] and an integer m as arguments and returns an array of 
 * length m whose ith element is the number of times the integer i appeared in a[]. 
 * Assuming the values in a[] are all between 0 and m-1, the sum of the values in the 
 * returned array should equal a.length.
 */
public class Histogram {
   public static int[] calculateHistogram(int[] a, int iM) {
      int[] iReturnArray = new int[iM];
      
      for (int i = 0; i < a.length; i++) {
         iReturnArray[a[i]]++;
      }

      return iReturnArray;
   }
   public static void main(String[] args) {
      int iM = Integer.parseInt(args[0]);
      int[] a = {0, 1, 2, 3, 4, 5, 6, 5, 4, 3, 2, 1, 0};

      int[] iReturnArray = calculateHistogram(a, iM);
      
      // System.out.println(a.length);
      for (int i = 0; i < a.length; i++) {
         System.out.print(a[i] + " ");
      }
      System.out.println();
      
      // System.out.println(iReturnArray.length);
      int iArraySum = 0;
      for (int i = 0; i < iReturnArray.length; i++) {
         System.out.println("Index = " + i + ", Frequence = " + iReturnArray[i]);
         iArraySum += iReturnArray[i];
      }
      System.out.println();
      
      // System.out.println(iArraySum);
   }
}
