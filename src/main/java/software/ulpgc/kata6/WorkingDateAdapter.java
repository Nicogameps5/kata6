package software.ulpgc.kata6;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.time.LocalDate;

public class WorkingDateAdapter {
    public static CalculateWorkingDateCommand.Input inputOf(HttpServletRequest request){
        return new CalculateWorkingDateCommand.Input() {
            @Override
            public LocalDate start() {
                String start = request.getParameter("start");
                return LocalDate.parse(start);
            }

            @Override
            public int daysWorking() {
                String days = request.getParameter("days");
                return 0;
            }
        };
    }

    public static CalculateWorkingDateCommand.Output outputOf(HttpServletResponse response){
        return date -> {
            response.getWriter().write(date.toString());
            response.setStatus(200);
        };
    }
}
