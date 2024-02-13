import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Random;

public class FortuneTellerFrame extends JFrame {
    private JLabel titleLabel;
    private ImageIcon fortuneTellerImage;
    private JTextArea fortuneDisplayArea;
    private JScrollPane scrollPane;
    private JButton readFortuneButton;
    private JButton quitButton;

    private ArrayList<String> fortunes;
    private int previousIndex = -1;

    public FortuneTellerFrame() {
        super("Fortune Teller");
        initializeFortunes();
        createComponents();
        setupLayout();
        setupActions();
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int screenHeight = screenSize.height;
        int screenWidth = screenSize.width;
        // center frame in screen
        setSize((screenWidth / 4) * 3, (screenHeight / 4) * 3);
        setLocation(screenWidth / 4, screenHeight / 4);

        //setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the frame on screen
        setVisible(true);
    }

    private void initializeFortunes() {
        fortunes = new ArrayList<>();
        fortunes.add("Some days you are the pigeon, some days you are the statue. Today, bring an umbrella.");
        fortunes.add("No snowflake in an avalanche ever feels responsible.");
        fortunes.add("About time I got out of that cookie.");
        fortunes.add("The fortune you seek is in another cookie.");
        fortunes.add("A closed mouth gathers no feet.");
        fortunes.add("A conclusion is simply the place where you got tired of thinking.");
        fortunes.add("A cynic is only a frustrated optimist.");
        fortunes.add("When in anger, sing the alphabet.");
        fortunes.add("If you eat something and nobody sees you eat it, it has no calories.");
        fortunes.add("Come back later… I am sleeping.");
        fortunes.add("Change is inevitable, except for vending machines.");
        fortunes.add("You will be hungry again in one hour.");

    }

    private void createComponents() {
        fortuneTellerImage = new ImageIcon("src/fortuneTeller.png"); // Replace "fortuneteller.jpg" with your image file
        titleLabel = new JLabel("Fortune Teller", fortuneTellerImage, SwingConstants.CENTER);
        titleLabel.setVerticalTextPosition(JLabel.TOP);
        titleLabel.setHorizontalTextPosition(JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 36));

        fortuneDisplayArea = new JTextArea(10, 30);
        fortuneDisplayArea.setEditable(false);
        fortuneDisplayArea.setFont(new Font("Roboto", Font.PLAIN, 20));
        scrollPane = new JScrollPane(fortuneDisplayArea);

        Font inter = new Font("Inter", Font.PLAIN, 16);
        readFortuneButton = new JButton("Read My Fortune!");
        readFortuneButton.setFont(inter);
        quitButton = new JButton("Quit");
        quitButton.setFont(inter);
    }

    private void setupLayout() {
        setLayout(new BorderLayout());

        JPanel topPanel = new JPanel();
        topPanel.add(titleLabel);
        add(topPanel, BorderLayout.NORTH);

        JPanel middlePanel = new JPanel();
        middlePanel.add(scrollPane);
        add(middlePanel, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel();
        bottomPanel.add(readFortuneButton);
        bottomPanel.add(quitButton);
        add(bottomPanel, BorderLayout.SOUTH);
    }

    private void setupActions() {
        readFortuneButton.addActionListener((ActionEvent e) -> {
            String fortune = generateRandomFortune();
            fortuneDisplayArea.append(fortune + "\n");
        });

        quitButton.addActionListener((ActionEvent e) -> {
            System.exit(0);
        });
    }

    private String generateRandomFortune() {
        int index;
        do {
            index = new Random().nextInt(fortunes.size());
        } while (index == previousIndex);
        previousIndex = index;
        return fortunes.get(index);
    }

}
