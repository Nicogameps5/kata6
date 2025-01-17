package software.ulpgc.kata6;

import java.io.IOException;
import java.time.DayOfWeek;
import java.time.LocalDate;

public class CalculateWorkingDaysCommand implements Command{
    private final Input input;
    private final Output output;

    public CalculateWorkingDaysCommand(Input input, Output output) {
        this.input = input;
        this.output = output;
    }

    @Override
    public void execute() throws IOException {
        LocalDate current = input.start();
        int daysWorked = 0;
        while (!current.isAfter(input.end())){
            if(current.getDayOfWeek() != DayOfWeek.SATURDAY && current.getDayOfWeek() != DayOfWeek.SUNDAY){
                daysWorked++;
            }
            current = current.plusDays(1);
        }
        output.daysWorked(daysWorked);
    }

    public interface Input{
        LocalDate start();
        LocalDate end();
    }

    public interface Output{
        void daysWorked(int days) throws IOException;
    }
}
