package software.ulpgc.kata6;

public class Main {
    public static void main(String[] args) {
        CommandFactory commandFactory = new CommandFactory();
        new WorkingService(7070, commandFactory).start();
    }
}
