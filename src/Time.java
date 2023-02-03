public class Time {
    //calls javas System.getNanoTime
    public static double timeStarted = System.nanoTime();

    public static double getTime() {
        return System.nanoTime() - timeStarted * 1E-9;
        //converts from nanoseconds to seconds
    }
}
