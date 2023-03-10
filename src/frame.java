import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class frame extends JFrame {
    Calendar calendar;
    SimpleDateFormat timeFormat;
    SimpleDateFormat dayFormat;
    SimpleDateFormat dateFormat;
    JLabel timeLabel;
    JLabel dayLabel;
    JLabel dateLabel;
    String time;
    String day;
    String date;
    frame() throws Exception{
        StringBuffer br = new StringBuffer();
        br.append("<html>" +
                "<body style='text-align:center;'>");

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("My Digital Clock");
        this.setLayout(new FlowLayout());
        this.setSize(480,350);
        //this.setResizable(false);
        String text;
        String linebreak;
        text = "<html> <body style='text-align:center;'> Hey, I'm your Digital Clock.<br>Here's your date and time, Enjoy !! <br><br></body> </html>";
        linebreak = "<html> <body style='text-align:center;'> <br><br><br> </body> </html>";

        JLabel displayLabel;
        displayLabel = new JLabel();
        displayLabel.setFont(new Font("Verdana",Font.PLAIN,20));
        displayLabel.setHorizontalAlignment(JLabel.CENTER);
        displayLabel.setText(text);
        displayLabel.setBounds(50,10,380,100);

        JLabel linesbreak;
        linesbreak = new JLabel();
        linesbreak.setFont(new Font("Verdana",Font.PLAIN,20));
        linesbreak.setHorizontalAlignment(JLabel.CENTER);
        linesbreak.setText(linebreak);
        linesbreak.setBounds(50,10,380,100);

        timeFormat = new SimpleDateFormat("hh:mm:ss a");
        dayFormat = new SimpleDateFormat("EEEE");
        dateFormat = new SimpleDateFormat("MMMMM dd,yyyy");

        timeLabel = new JLabel();
        timeLabel.setFont(new Font("Verdana",Font.PLAIN,50));
        timeLabel.setForeground(new Color(0x2592F0));
        timeLabel.setHorizontalAlignment(JLabel.CENTER);
        //timeLabel.setBackground(Color.black);
        timeLabel.setOpaque(true);
        timeLabel.setBounds(50,75,380,100);

        dayLabel = new JLabel();
        dayLabel.setFont(new Font("Ink Free",Font.PLAIN,40));
        dayLabel.setHorizontalAlignment(JLabel.CENTER);
        dayLabel.setBounds(50,150,380,100);

        dateLabel = new JLabel();
        dateLabel.setFont(new Font("Ink Free",Font.PLAIN,30));
        dateLabel.setHorizontalAlignment(JLabel.CENTER);
        dateLabel.setBounds(50,210,380,100);

        this.add(displayLabel);
        this.add(linesbreak);
        this.add(timeLabel);
        this.add(linesbreak);
        this.add(dayLabel);
        this.add(linesbreak);
        this.add(dateLabel);
        this.setLayout(null);
        this.setVisible(true);
        setTime();
        br.append("</body>" + "</html>");
    }
    public void setTime() {
        while(true){

            time = timeFormat.format(Calendar.getInstance().getTime());
            timeLabel.setText(time);

            day = dayFormat.format(Calendar.getInstance().getTime());
            dayLabel.setText(day);

            date = dateFormat.format(Calendar.getInstance().getTime());
            dateLabel.setText(date);

            try{
                Thread.sleep(1000);
            } catch (InterruptedException e){
                e.printStackTrace();
            }

        }
    }
}
