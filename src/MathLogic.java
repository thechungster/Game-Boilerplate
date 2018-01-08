import java.util.Random;

public class MathLogic {
    private Random r;

    public MathLogic() {
        r = new Random(System.currentTimeMillis());
    }

    public float findVelocity(float xVel, float speed) {
        return (float)Math.sqrt(speed*speed - xVel*xVel);
    }

    public float randomFloat(float bound) {
        float f = r.nextFloat();
        if(isNegative()) {
            return f * -1 * bound;
        }
        return f * bound;
    }

    public boolean isNegative() {
         return ((int) (r.nextFloat() * 100) % 2) == 0;
    }
}
