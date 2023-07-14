package Utils;

public class UtilsClass {

    public static int generateRandomID(int min, int max)
    {
        int id = (int) (Math.random()*(max - min) + min);
        return id;
    }
}
