package de.htwg;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class TimeintervalTimeSpan extends Timeinterval {

    public Uhrzeit uhrzeit1;
    public String ws1;
    public String until;

    public String ws2;
    public Uhrzeit uhrzeit2;

    public final class SameTime extends RuntimeException {
        public SameTime(String from, String to ) {
            super("The first time: " + from + " equals the second time: " + to);
        }
    }
    public final class InvalidTime extends RuntimeException {
        public InvalidTime(String from, String to ) {
            super("The first time: " + from + " is before the second time: " + to);
        }
    }

    private void checkSameTime(String from, String to) {
        from = formatString(from);
        to = formatString(to);
        if(from.equals(to)) {
            throw new SameTime(from, to);
        }
    }

    private void checkInvalidTime(String from, String to) {
        from = formatString(from);
        to = formatString(to);
        if(from.contains("a.m") && to.contains("p.m")) {
            return;
        }
        if(from.contains("p.m") && to.contains("a.m")) {
            throw new InvalidTime(from, to);
        }
        String[] fromArr = from.split("[\\s:]");

        String[] toArr = to.split("[\\s:]");

        if(Integer.parseInt(fromArr[0]) > Integer.parseInt(toArr[0])) {
            throw new InvalidTime(from, to);
        } else if (Integer.parseInt(fromArr[0]) == Integer.parseInt(toArr[0])) {
            if(Integer.parseInt(fromArr[1]) > Integer.parseInt(toArr[1])) {
                throw new InvalidTime(from, to);
            }
        }
    }
    
    private String formatString(String time) {
        if(time.equals("noon") || time.equals("Noon")) {
            time = "12:00 p.m";
        } else if(time.equals("midnight") || time.equals("Midnight")) {
            time = "12:00 a.m";
        } else if(time.contains("a.m.")) {
            time = time.substring(0, time.length() - 1);
        } else if (time.contains("p.m.")) {
            time = time.substring(0, time.length() - 1);
        }
        return time;
    }

    public TimeintervalTimeSpan(Uhrzeit uhrzeit1, String ws1, String until, String ws2, Uhrzeit uhrzeit2) {
        checkSameTime(uhrzeit1.toString(), uhrzeit2.toString());
        checkInvalidTime(uhrzeit1.toString(), uhrzeit2.toString());
        this.uhrzeit1 = uhrzeit1;
        this.ws1 = ws1;
        this.until = until;
        this.ws2 = ws2;
        this.uhrzeit2 = uhrzeit2;
    }

    public Uhrzeit getUhrzeit1() {
        return this.uhrzeit1;
    }

    public Uhrzeit getUhrzeit2() {
        return this.uhrzeit2;
    }

    public void protocol(String name) {
        StringBuilder sb = new StringBuilder();

        LocalDate date = LocalDate.now();
        String dateAsString = date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        sb.append(dateAsString);
        sb.append("\n");

        sb.append(name);
        sb.append(": ");
        String timeinterval = this.toString();
        sb.append(timeinterval);
        sb.append("\n");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("protocol.txt", true))) {
            writer.write(sb.toString());
            writer.newLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public String toString() {
        return "(" + this.uhrzeit1.toString() + this.ws1 + this.until + this.ws2 + uhrzeit2.toString() + ")";
    }

}
