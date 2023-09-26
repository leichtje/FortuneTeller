import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Random;

public class FortuneTellerFrame extends JFrame {

    JPanel mainPnl;
    JPanel iconPnl;
    JPanel displayPnl;
    JPanel controlPnl;

    JLabel iconLbl;
    ImageIcon FTIcon;

    JScrollPane scroller;
    JTextArea fortuneTA;

    JButton quitBtn;
    JButton fortuneBtn;

    ArrayList<String> fortuneL = new ArrayList<>();

    int i = -1;
    int randIndex;


    public FortuneTellerFrame(){
        
        mainPnl = new JPanel();
        mainPnl.setLayout(new BorderLayout());
        setTitle("Fortune Teller");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(mainPnl);
        mainPnl.setBackground(new Color(0,0,130));

        
        createIconPanel();
        mainPnl.add(iconPnl,BorderLayout.NORTH);

        createDisplayPanel();
        mainPnl.add(displayPnl, BorderLayout.CENTER);

        createControlPanel();
        mainPnl.add(controlPnl, BorderLayout.SOUTH);

        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int screenHeight = screenSize.height;
        int screenWidth = screenSize.width;
        setSize(3*(screenWidth / 4), 3*(screenHeight / 4));
        setLocationRelativeTo(null);

    }
    private void createIconPanel() {
        iconPnl = new JPanel();
        FTIcon = new ImageIcon("src/Fortune Teller.jpg");


        Image image = FTIcon.getImage().getScaledInstance(150,150,Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(image);
        iconLbl = new JLabel("Fortune Teller", scaledIcon, JLabel.CENTER);
        iconLbl.setFont(new Font("Monospaced",Font.ITALIC,48));

        iconLbl.setVerticalTextPosition(JLabel.BOTTOM);
        iconLbl.setHorizontalTextPosition(JLabel.CENTER);
        iconLbl.setForeground(new Color(213, 50, 250));

        iconPnl.add(iconLbl);
    }

    private void createDisplayPanel() {
        displayPnl = new JPanel();
        fortuneTA = new JTextArea(12, 36);
        fortuneTA.setEditable(false);
        scroller = new JScrollPane(fortuneTA);
        displayPnl.setFont(new Font("Dialog", Font.PLAIN, 12));
        displayPnl.add(scroller);
    }

    private void createControlPanel() {
        controlPnl = new JPanel();
        controlPnl.setLayout(new GridLayout(1, 2));

        fortuneBtn = new JButton("Read My Fortune!");
        quitBtn = new JButton("Quit");

        controlPnl.add(fortuneBtn);
        controlPnl.add(quitBtn);

        fortuneL.add("Your teacher will tell you to look it up on Google.");
        fortuneL.add("You will get good grades.");
        fortuneL.add("Regret of your decisions, you will question, Padawan");
        fortuneL.add("The lunch will be good for once.");
        fortuneL.add("Bumpers are not your friend.");
        fortuneL.add("UC is only taking your money.");
        fortuneL.add("Your degree is a useless piece of paper.");
        fortuneL.add("The Bengals will fumble.");
        fortuneL.add("Quit college and become a stripper.");
        fortuneL.add("Coding will make you go crazy.");
        fortuneL.add("You are going crazy.");
        fortuneL.add("Trades make more money.");

        fortuneBtn.addActionListener((ActionEvent ae) -> {
            Random rnd = new Random();

            do{
                randIndex = rnd.nextInt(12);
            }while(randIndex == i);
            String fortune = fortuneL.get(randIndex);
            i = randIndex;
            fortuneTA.append("Your fortune: " + fortune + "\n");

        });
        quitBtn.addActionListener((ActionEvent ae) -> System.exit(0));
        controlPnl.setFont(new Font("SansSerif", Font.BOLD, 12));

    }






}
