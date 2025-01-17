package software.ulpgc.kata6;

import io.javalin.Javalin;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class WorkingService {
    private final int port;
    private final CommandFactory factory;
    private Javalin app;

    public WorkingService(int port, CommandFactory factory) {
        this.port = port;
        this.factory = factory;
        factory.register("working-date", workingDateBuilder());
        factory.register("working-days", workingDaysBuilder());
    }

    private CommandFactory.Builder workingDaysBuilder() {
        return (request, response) -> new CalculateWorkingDaysCommand(WorkingDaysAdapter.inputOf(request), WorkingDaysAdapter.outputOf(response));
    }

    private CommandFactory.Builder workingDateBuilder() {
        return (request, response) -> new CalculateWorkingDateCommand(WorkingDateAdapter.inputOf(request), WorkingDateAdapter.outputOf(response));
    }

    public void start(){
        app = Javalin.create()
                .get("/working-date", ctx -> execute("working-date", ctx.req(), ctx.res()))
                .get("/working-days", ctx -> execute("working-days", ctx.req(), ctx.res()))
                .start(port);
    }

    public void stop(){
        app.stop();
    }

    private void execute(String s, HttpServletRequest req, HttpServletResponse res) throws IOException{
        factory.with(req, res).build(s).execute();
    }
}
