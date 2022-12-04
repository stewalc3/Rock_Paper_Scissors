import com.sun.tools.javac.Main;
import java.util.Random;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RockPaperScissorsFrame extends JFrame {
    JPanel MainPanel;
    JPanel StatsPanel;
    JPanel ResultsPanel;
    JPanel ButtonPanel;

    JButton RockButton;
    JButton PaperButton;
    JButton ScissorsButton;
    JButton QuitButton;

    ImageIcon Rock;
    ImageIcon Paper;
    ImageIcon Scissors;

    JTextArea ResultsDisplay;
    JScrollPane Scroller;

    JLabel Title;
    JLabel PlayerWins;
    JLabel ComputerWins;
    JLabel TieGames;
    Random Random = new Random();
    int Ties;
    int PlayerWs;
    int ComputerWs;

    public RockPaperScissorsFrame() throws HeadlessException {
        super("Gaming Gamers play RPS");
        MainPanel = new JPanel();
        StatsPanel();
        ButtonPanel();
        ResultsPanel();
        MainPanel.add(StatsPanel);
        MainPanel.add(ResultsPanel);
        MainPanel.add(ButtonPanel);
        MainPanel.setLayout(new BoxLayout(MainPanel, BoxLayout.PAGE_AXIS));
        add(MainPanel);
    }

    private void ButtonPanel() {
        ButtonPanel = new JPanel();
        QuitButton = new JButton("Quit");
        QuitButton.addActionListener((ActionEvent ae) -> {
            System.exit(0);
        });

        Rock = new ImageIcon("src/rock.png");
        RockButton = new JButton(Rock);
        Scissors = new ImageIcon("src/scissors.png");
        ScissorsButton = new JButton(Scissors);
        Paper = new ImageIcon("src/paper.png");
        PaperButton = new JButton(Paper);
        RockButton.addActionListener(new RockListener());
        ScissorsButton.addActionListener(new ScissorListener());
        PaperButton.addActionListener(new PaperListener());
        ButtonPanel.add(RockButton);
        ButtonPanel.add(ScissorsButton);
        ButtonPanel.add(PaperButton);
        ButtonPanel.add(QuitButton);
    }
    private void StatsPanel() {
        StatsPanel = new JPanel();
        PlayerWins = new JLabel("Player wins: 0");
        ComputerWins = new JLabel("Computer wins: 0");
        TieGames = new JLabel("Tie games: 0");
        StatsPanel.add(PlayerWins);
        StatsPanel.add(ComputerWins);
        StatsPanel.add(TieGames);
    }
    private void ResultsPanel (){
        ResultsPanel = new JPanel();
        ResultsDisplay = new JTextArea(10, 40);
        ResultsDisplay.setEditable(false);
        Scroller = new JScrollPane(ResultsDisplay);
        ResultsPanel.add(Scroller);



    }
    public class RockListener implements ActionListener {
      @Override
       public void actionPerformed(ActionEvent e)
        {
            Gameplay(0);
        }
    }
    public class PaperListener implements ActionListener {
       @Override
        public void actionPerformed(ActionEvent e)
        {
            Gameplay(1);
        }
    }
    public class ScissorListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            Gameplay(2);
        }
    }
    private void Gameplay(int PlayerChoice) {
        int ComputerChoice = Random.nextInt(3);
        if (ComputerChoice == PlayerChoice){
            if (ComputerChoice == 0){
                ResultsDisplay.append("Computer plays: Rock It's a tie!\n");
            }
            else if (ComputerChoice == 1){
                ResultsDisplay.append("Computer plays: Paper It's a tie!\n");
            }
            else{
                ResultsDisplay.append("Computer plays: Scissors It's a tie!\n");
            }
            Ties++;
            TieGames.setText("Ties: " + Ties);
        }
        else if (ComputerChoice == 0 && PlayerChoice == 1){
            ResultsDisplay.append("Computer plays: Rock You win!\n");
            PlayerWs++;
        }
        else if (ComputerChoice == 0 && PlayerChoice == 2){
            ResultsDisplay.append("Computer plays: Rock You lose!\n");
            ComputerWs++;
        }
        else if (ComputerChoice == 1 && PlayerChoice == 0){
            ResultsDisplay.append("Computer plays: Paper You lose!\n");
            ComputerWs++;
        }
        else if (ComputerChoice == 1 && PlayerChoice == 2){
            ResultsDisplay.append("Computer plays: Paper You win!\n");
            PlayerWs++;
        }
        else if (ComputerChoice == 2 && PlayerChoice == 0){
            ResultsDisplay.append("Computer plays: Scissors You win!\n");
            PlayerWs++;
        }
        else if (ComputerChoice == 2 && PlayerChoice == 1){
            ResultsDisplay.append("Computer plays: Scissors You lose!\n");
            ComputerWs++;
        }
        PlayerWins.setText("Player wins: " + PlayerWs);
        ComputerWins.setText("Computer wins: " + ComputerWs);
    }
}
