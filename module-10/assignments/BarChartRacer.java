import java.util.Arrays;

/**
 *  The {@code BarChartRacer} class represents a program that animates 
 *  bar charts using BarChart.java by Kevin Wayne to draw static bars.
 *
 *  @author Aiden Truong
 *
 */
public class BarChartRacer {
    public static void main(String[] args) {
        final int PAUSE_INTERVAL = 40;

        In file = new In(args[0]);
        int iNumOfVisBars = Integer.parseInt(args[1]);

        String title = file.readLine();
        String xAxis = file.readLine();
        String source = file.readLine();
        BarChart chart = new BarChart(title, xAxis, source);
        int iNumOfRecords = 0;
        String sCaption = "";
        Bar[] bar;
        String[] sRecordValues;
        
        StdDraw.setCanvasSize(1000, 700);
        StdDraw.enableDoubleBuffering();
        
        while (file.hasNextLine()) {
            file.readLine();

            iNumOfRecords = Integer.parseInt(file.readLine());
            bar = new Bar[iNumOfRecords];

            chart.reset();

            for (int i = 0; i < iNumOfRecords; i++) {
                sRecordValues = file.readLine().split(",");
                sCaption = sRecordValues[0];

                bar[i] = new Bar(sRecordValues[1], Integer.parseInt(sRecordValues[3]), sRecordValues[4]);
            }
            
            Arrays.sort(bar);

            for (int i = bar.length - 1; i >= bar.length - iNumOfVisBars && i >= 0; i--) {
                chart.add(bar[i].getName(), bar[i].getValue(), bar[i].getCategory());
            }

            chart.setCaption(sCaption);

            StdDraw.clear();
            chart.draw();
            StdDraw.show();
            StdDraw.pause(PAUSE_INTERVAL);
        }
    }
}