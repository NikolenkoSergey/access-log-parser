package OOP_8.Birds;

public class BirdMarket {

    public static void birdSong(Birdable... objects) {
        for (Birdable obj : objects) {
            obj.sing();
        }
    }
}
