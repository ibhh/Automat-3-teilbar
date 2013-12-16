package automat;

public class Verarbeitungsvorgang {
    private int zustand = 0;

    public boolean ZahlDurch3Teilbar(String wort) {

	for (char buchstabe : wort.toCharArray()) {
	    buchstabenVerarbeiten(buchstabe);
	}

	return AkzeptierteZustaende.istakzeptiert(zustand);
    }

    public void buchstabenVerarbeiten(final char buchstabe) {
	switch (zustand) {
	case 0:
	    switch (buchstabe) {
	    case '3':
	    case '6':
	    case '9':
		zustand = 1;
		break;
	    case '2':
	    case '5':
	    case '8':
		zustand = 2;
		break;
	    case '1':
	    case '4':
	    case '7':
		zustand = 3;
		break;
	    default:
		break;
	    }
	    return;
	case 1:
	    switch (buchstabe) {
	    case '0':
	    case '3':
	    case '6':
	    case '9':
		zustand = 1;
		break;
	    case '2':
	    case '5':
	    case '8':
		zustand = 2;
		break;
	    case '1':
	    case '4':
	    case '7':
		zustand = 3;
		break;
	    default:
		break;
	    }
	    return;
	case 2:
	    switch (buchstabe) {
	    case '0':
	    case '3':
	    case '6':
	    case '9':
		zustand = 2;
		break;
	    case '2':
	    case '5':
	    case '8':
		zustand = 3;
		break;
	    case '1':
	    case '4':
	    case '7':
		zustand = 1;
		break;
	    default:
		break;
	    }
	    return;
	case 3:
	    switch (buchstabe) {
	    case '0':
	    case '3':
	    case '6':
	    case '9':
		zustand = 3;
		break;
	    case '2':
	    case '5':
	    case '8':
		zustand = 1;
		break;
	    case '1':
	    case '4':
	    case '7':
		zustand = 2;
		break;
	    default:
		break;
	    }
	    return;
	default:
	    break;
	}
	System.out.println("Fehler!!");
	// Fehler
	zustand = -1;
    }

    public int getZustand() {
	return zustand;
    }

    public boolean istAkzeptiert() {
	return AkzeptierteZustaende.istakzeptiert(zustand);
    }
}
