package Frontend.GoodbyeAnimation;

public class GoodbyeAnimation implements Runnable {

    private void printInColor(char text, String colorCode) {
        System.out.print(colorCode + text + "\033[0m");
    }

    @Override
    public void run() {
        String message = "Goodbye!";
        String color = "\033[1;32m"; // Set the color to green
        for (char c : message.toCharArray()) {
            printInColor(c, color);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println();
    }
}

