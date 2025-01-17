package software.ulpgc.kata6;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Iterator;
import java.util.Set;

public class Calendar {
    private final Set<DayOfWeek> dayOfWeeks = Set.of(DayOfWeek.MONDAY, DayOfWeek.TUESDAY, DayOfWeek.WEDNESDAY, DayOfWeek.THURSDAY, DayOfWeek.FRIDAY);

    public Iterator<LocalDate> from(LocalDate date){
        return new Iterator<LocalDate>() {
            LocalDate current = date;
            @Override
            public boolean hasNext() {
                return true;
            }

            @Override
            public LocalDate next() {
                var next = current.plusDays(1);
                while (!dayOfWeeks.contains(next.getDayOfWeek())){
                    next = next.plusDays(1);
                }
                current = next;
                return next;
            }
        };
    }
}
