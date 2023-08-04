/*
 * Description: Create a library to manipulate digital audio and use that library to create 
 * an audio collage. As in lecture, we will represent sound as an array of real numbers between 
 * –1 and +1, with 44,100 samples per second. You will write a library of functions to produce 
 * audio effects by manipulating such arrays.
 */
public class AudioCollage {
    // Returns a new array that rescales a[] by a multiplicative factor of alpha.
    public static double[] amplify(double[] a, double alpha) {
        double[] dNewSound = new double[a.length];

        for (int i = 0; i < a.length; i++) {
            if (alpha > 1) {
                dNewSound[i] = a[i] * alpha; 
            } else if (0 < alpha && alpha < 1) {
                dNewSound[i] = a[i] / alpha; 
            }
        }

        return dNewSound;
    }

    // Returns a new array that is the reverse of a[].
    public static double[] reverse(double[] a) {
        double[] dNewSound = new double[a.length];
        int iFirstIndex = 0;

        for (int i = a.length - 1; i >= 0; i--) {
            dNewSound[iFirstIndex] = a[i];
            iFirstIndex++; 
        }

        return dNewSound;
    }

    // Returns a new array that is the concatenation of a[] and b[].
    public static double[] merge(double[] a, double[] b) {
        double[] dNewSound = new double[a.length + b.length];

        for (int i = 0; i < a.length; i++) {
            dNewSound[i] = a[i];
        }

        for (int i = 0; i < b.length; i++) {
            dNewSound[a.length + i] = b[i];
        }

        return dNewSound; 
    }

    // Returns a new array that is the sum of a[] and b[],
    // padding the shorter arrays with trailing 0s if necessary.
    public static double[] mix(double[] a, double[] b) {
        int iNewSoundLength = 0;
        if (a.length < b.length) {
            iNewSoundLength = b.length;
        } else {
            iNewSoundLength = a.length;
        }

        double [] dNewSound = new double[iNewSoundLength];
        if (a.length < b.length) {
            for (int i = 0; i < a.length; i++) {  
                dNewSound[i] = a[i] + b[i];
            }     

            for (int i = a.length; i < dNewSound.length; i++) {
                dNewSound[i] = b[i] + 0; 
            }
        } else {
            for (int i = 0; i < b.length; i++) {  
                dNewSound[i] = a[i] + b[i];
            } 

            for (int i = b.length; i < dNewSound.length; i++) {
                dNewSound[i] = a[i] + 0; 
            }
        }

        return dNewSound;
    }
    
    // Returns a new array that changes the speed by the given factor.
    public static double[] changeSpeed(double[] a, double alpha) {
        int iNumSamples = a.length;
        
        int iNewSoundLength = (int) (iNumSamples / alpha);
        double[] dNewSound = new double[iNewSoundLength];

        int iAmplitude = 0; 
        for (int i = 0; i < dNewSound.length; i++) {
            iAmplitude = (int) (i * alpha);
            dNewSound[i] = a[iAmplitude];
        }

        return dNewSound;
    }

    // Creates an audio collage and plays it on standard audio.
    // See below for the requirements.
    public static void main(String[] args) {
        double[] dFirstSound = StdAudio.read("./functions/singer.wav");
        double[] dSecondSound = StdAudio.read("./functions/chimes.wav");
        double dAlpha = StdIn.readDouble();

        StdOut.println("Amplify");
        StdAudio.play(amplify(dFirstSound, dAlpha));
        StdOut.println("Reverse");
        StdAudio.play(reverse(dFirstSound));
        StdOut.println("Merge");
        StdAudio.play(merge(dFirstSound, dSecondSound));
        StdOut.println("Mix");
        StdAudio.play(mix(dFirstSound, dSecondSound ));
        StdOut.println("Change Speed");
        StdAudio.play(changeSpeed(dFirstSound, dAlpha));

    }
}