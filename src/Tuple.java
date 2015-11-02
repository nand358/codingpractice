/**
 * Created with IntelliJ IDEA.
 * User: anatarajan
 * Date: 3/10/14
 * Time: 6:16 PM
 * To change this template use File | Settings | File Templates.
 */
public class Tuple <F,S> {
    public F first;
    public S second;

    public Tuple() {
        first = null;
        second = null;
    }

    /**
     * @param first
     * @param second
     */
    public Tuple(F first, S second) {
        this.first = first;
        this.second = second;
    }
}
