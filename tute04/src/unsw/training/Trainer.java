package unsw.training;

import java.time.LocalDate;
import java.util.List;

/**
 * A trainer that runs in person seminars.
 * 
 * @author Robert Clifton-Everest
 */
public class Trainer {
    private String name;
    private String room;

    private List<Seminar> seminars;

    public List<Seminar> getSeminars() {
        return seminars;
    }

    public LocalDate book(String employee, List<LocalDate> availability) {
        for (Seminar seminar : seminars) {
            if (seminar.book(employee, availability) != null) {
                return seminar.book(employee, availability);
            }
        }
        return null;
    }
}
