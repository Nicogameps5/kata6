package software.ulpgc.kata6;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.time.LocalDate;

public class WorkingDaysAdapter {
    public static CalculateWorkingDaysCommand.Input inputOf(HttpServletRequest request){
        return new CalculateWorkingDaysCommand.Input() {
            @Override
            public LocalDate start() {
                String start = request.getParameter("start");
                return LocalDate.parse(start);
            }

            @Override
            public LocalDate end() {
                String end = request.getParameter("end");
                return LocalDate.parse(end);
            }
        };
    }

    public static CalculateWorkingDaysCommand.Output outputOf(HttpServletResponse response){
        return days -> {
            response.getWriter().write(String.valueOf(days));
            response.setStatus(200);
        };
    }
}
