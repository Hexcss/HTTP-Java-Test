package Frontend.Animations.Loader;

public class Loader implements Runnable {
    private boolean loading = true;

    public void stopLoading() {
        this.loading = false;
    }

    private void printInColor(String text, String colorCode) {
        System.out.print(colorCode + text + "\033[0m");
    }

    @Override
    public void run() {
        String[] spinner = new String[]{"-", "\\", "|", "/"};
        int i = 0;
        String color = "\033[1;34m"; // Set the color to blue
        while (loading) {
            printInColor("\rPreparing flight data... " + spinner[i % spinner.length], color);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            i++;
        }
    }
}
