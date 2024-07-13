package ovs;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JProgressBar;
import javax.swing.ImageIcon;
import javax.swing.plaf.basic.BasicProgressBarUI;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.Rectangle;

public class splash extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    public JProgressBar progressBar;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    splash frame = new splash();
                    frame.setVisible(true);
                    frame.runProgressBar();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public splash() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 682, 364);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(255, 255, 255));
        panel.setBounds(0, 0, 666, 325);
        contentPane.add(panel);
        panel.setLayout(null);

        JLabel lblNewLabel = new JLabel("Loading");
        lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
        lblNewLabel.setBackground(new Color(255, 255, 255));
        lblNewLabel.setBounds(298, 193, 69, 39);
        panel.add(lblNewLabel);

        progressBar = new JProgressBar();
        progressBar.setBounds(126, 236, 413, 33);
        progressBar.setStringPainted(true);
        progressBar.setForeground(Color.RED); // Set progress bar color to red
        progressBar.setUI(new RedProgressBarUI()); // Use custom UI to paint text in red
        panel.add(progressBar);

        JLabel lblNewLabel_1 = new JLabel("");
        lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\moham\\Downloads\\outl.gif"));
        lblNewLabel_1.setBounds(236, 107, 193, 75);
        panel.add(lblNewLabel_1);
    }

    public void runProgressBar() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    for (int i = 0; i <= 100; i++) {
                        Thread.sleep(50); // Simulate loading time
                        final int progress = i;
                        EventQueue.invokeLater(new Runnable() {
                            public void run() {
                                updateProgress(progress);
                            }
                        });
                    }
                    adminuser au = new adminuser();
                    au.setVisible(true);
                    dispose();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public void updateProgress(int value) {
        if (progressBar != null) {
            progressBar.setValue(value); // Update progress bar value
        } else {
            System.out.println("Progress bar is null!"); // Optional: Debug message
        }
    }

    class RedProgressBarUI extends BasicProgressBarUI {
        @Override
        protected void paintString(Graphics g, int x, int y, int width, int height, int amountFull, Insets b) {
            Graphics2D g2 = (Graphics2D) g;
            g2.setColor(Color.RED); 
            String progressText = progressBar.getString();
            Rectangle textRect = new Rectangle(x, y, width, height);
            g2.drawString(progressText, textRect.x + (textRect.width - g2.getFontMetrics().stringWidth(progressText)) / 2,
                    textRect.y + ((textRect.height - g2.getFontMetrics().getHeight()) / 2) + g2.getFontMetrics().getAscent());
        }
    }
}
