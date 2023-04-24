package Frontend.Animations.WelcomeAnimation;

public class WelcomeAnimation implements Runnable {
    @Override
    public void run() {
        String[] colors = {"\033[1;36m", "\033[1;33m", "\033[1;35m", "\033[1;32m"};
        String message = "Welcome to the Airline Information System!";
        int duration = 3; // Duration of the animation in seconds
        long startTime = System.currentTimeMillis();

        while (System.currentTimeMillis() - startTime < duration * 1000) {
            for (String color : colors) {
                if (System.currentTimeMillis() - startTime >= duration * 1000) {
                    break;
                }
                System.out.print(color + message + "\033[0m\r");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        // Print the message with the last color after the animation is over
        System.out.println(colors[colors.length - 1] + message + "\033[0m");
    }
}
