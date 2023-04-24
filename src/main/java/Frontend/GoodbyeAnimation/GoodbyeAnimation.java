package Frontend.GoodbyeAnimation;

public class GoodbyeAnimation implements Runnable {

    private void printInColor(char text, String colorCode) {
        System.out.print(colorCode + text + "\033[0m");
    }

    @Override
    public void run() {
        String message = "Goodbye!";
        String[] colors = {"\033[1;32m", "\033[1;33m", "\033[1;34m", "\033[1;35m"}; // Different color codes
        int colorIndex = 0;

        for (char c : message.toCharArray()) {
            printInColor(c, colors[colorIndex]);
            colorIndex = (colorIndex + 1) % colors.length; // Cycle through the colors
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println();
    }
}
