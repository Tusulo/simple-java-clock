import javax.swing.JLabel;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ClockUpdater implements Runnable{
    JLabel dateLabel;
    JLabel timeLabel;

    boolean running;

    LocalDateTime dateTime;

    public ClockUpdater(JLabel date, JLabel time) {
        this.dateLabel = date;
        this.timeLabel = time;;
        running=true;
    }

    public void stop() {
        running=false;
    }

    public void run(){
        running=true;
        while(running) {
            try {
                dateTime = LocalDateTime.now();
                dateLabel.setText(dateTime.format(DateTimeFormatter.ofPattern("eeee, d MMMM yyyy")));
                timeLabel.setText(dateTime.format(DateTimeFormatter.ofPattern("HH:mm:ss")));
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


}
