import javax.swing.*;
import java.awt.*;
import java.awt.geom.Path2D;

public class ChatGPTFourierSpikes extends JPanel {

    private int n;
    private int numSamples = 500;
    private double[] samples;
    private double[] values;

    public ChatGPTFourierSpikes(int n) {
        this.n = n;
        samples = new double[numSamples];
        values = new double[numSamples];
        calculateValues();
    }

    private void calculateValues() {
        double deltaT = 20.0 / (numSamples - 1);
        for (int i = 0; i < numSamples; i++) {
            samples[i] = -10 + i * deltaT;
            values[i] = calculateFunctionValue(samples[i]);
        }
    }

    private double calculateFunctionValue(double t) {
        double sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += Math.cos(i * t);
        }
        return sum / n;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;
        int width = getWidth();
        int height = getHeight();

        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setBackground(Color.WHITE);
        g2d.clearRect(0, 0, width, height);

        double scaleX = width / 20.0;
        double scaleY = height / 2.0;

        g2d.translate(width / 2, height / 2);

        Path2D path = new Path2D.Double();
        path.moveTo(samples[0] * scaleX, -values[0] * scaleY);

        for (int i = 1; i < numSamples; i++) {
            path.lineTo(samples[i] * scaleX, -values[i] * scaleY);
        }

        g2d.setColor(Color.BLUE);
        g2d.setStroke(new BasicStroke(2));
        g2d.draw(path);
    }

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java FourierSpikes <n>");
            return;
        }

        int n = Integer.parseInt(args[0]);
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Fourier Spikes for n = " + n);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(800, 400);
            frame.add(new ChatGPTFourierSpikes(n));
            frame.setVisible(true);
        });
    }
}
