package automat;

public class AkzeptierteZustaende {
    public static boolean istakzeptiert(int i) {
	switch (i) {
	case 1:
	    return true;
	default:
	    break;
	}
	return false;
    }
}
