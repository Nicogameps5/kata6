package software.ulpgc.kata6;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Iterator;

public class CalculateWorkingDateCommand implements Command{
    private final Input input;
    private final Output output;

    public CalculateWorkingDateCommand(Input input, Output output) {
        this.input = input;
        this.output = output;
    }

    @Override
    public void execute() throws IOException {
        Iterator<LocalDate> iterator = new Calendar().from(input.start());
        LocalDate end = input.start();
        for (int i = 0; i < input.daysWorking(); i++) {
            end = iterator.next();
        }
        output.end(end);
    }

    public interface Input{
        LocalDate start();
        int daysWorking();
    }

    public interface Output{
        void end(LocalDate date) throws IOException;
    }
}
