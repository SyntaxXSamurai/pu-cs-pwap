import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class HelloWorldGUI {
    public static void main(String[] args) {
        // Create the JFrame
        JFrame frame = new JFrame("Hello, World GUI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create the "Hello, World!" message
        JOptionPane.showMessageDialog(frame, "Hello, World!");

        // Create the button
        JButton closeButton = new JButton("Close");
        closeButton.addActionListener(e -> System.exit(0));

        // Add the button to the frame
        frame.getContentPane().add(closeButton);
        frame.setSize(300, 200);
        frame.setVisible(true);
    }
}

