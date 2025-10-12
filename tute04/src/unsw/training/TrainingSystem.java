package unsw.training;

import java.time.LocalDate;
import java.util.List;

public class TrainingSystem {
    private List<Trainer> trainers;

    public LocalDate bookTraining(String employee, List<LocalDate> availability) {
        for (Trainer trainer : trainers) {
            if (trainer.book(employee, availability) != null) {
                return trainer.book(employee, availability);
            }
        }
        return null;
    }
}
