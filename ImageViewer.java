import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;

public class ImageViewer {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ImageViewer().createImageViewer());
    }

    public void createImageViewer() {
        JFrame frame = new JFrame("Image Viewer");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        JLabel imageLabel = new JLabel("", JLabel.CENTER);
        JButton btnOpen = new JButton("Open Image");

        frame.setLayout(new BorderLayout());
        frame.add(btnOpen, BorderLayout.NORTH);
        frame.add(new JScrollPane(imageLabel), BorderLayout.CENTER);

        btnOpen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
                int result = fileChooser.showOpenDialog(frame);

                if (result == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    ImageIcon imageIcon = new ImageIcon(selectedFile.getAbsolutePath());
                    Image image = imageIcon.getImage().getScaledInstance(
                            imageLabel.getWidth(), imageLabel.getHeight(), Image.SCALE_SMOOTH);
                    imageLabel.setIcon(new ImageIcon(image));
                }
            }
        });

        frame.setVisible(true);
    }
}
