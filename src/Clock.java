import javax.swing.*;
import java.awt.*;
import java.util.Scanner;

public class Clock {
    static ClockUpdater clockUpdater;
    static JFrame frame;
    static JLabel dateLabel;
    static JLabel timeLabel;
    public static void main(String... args){
        createAndLaunchWindow();
        beginUpdatingClock();
        waitForUserInputToExit();
    }

    private static void createAndLaunchWindow() {
        frame = new JFrame("Clock");
        frame.setMinimumSize(new Dimension(250, 90));
        frame.setMaximumSize(new Dimension(250, 90));
        frame.setPreferredSize(new Dimension(250, 90));
        frame.setResizable(false);
        frame.setLayout(new GridLayout(2,1));
        frame.setAlwaysOnTop( true );
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        dateLabel = new JLabel("Date", SwingConstants.CENTER);
        timeLabel = new JLabel("Time", SwingConstants.CENTER);
        frame.getContentPane().add(dateLabel);
        frame.getContentPane().add(timeLabel);

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private static void beginUpdatingClock() {
        clockUpdater = new ClockUpdater(dateLabel,timeLabel);
        Thread updateClockThread = new Thread(clockUpdater);
        updateClockThread.start();
    }

    private static void waitForUserInputToExit() {
        Scanner in = new Scanner(System.in);
        while(!in.hasNext()){

        }
        clockUpdater.stop();
        System.exit(0);
    }

}
