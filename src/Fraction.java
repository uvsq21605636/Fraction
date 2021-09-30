public class Fraction {

    private double denumerator;
    private double numerator;

    ////////////CONSTRUCTEURS////////////

    public Fraction() {
        numerator = 0;
        denumerator = 1;
    }

    public Fraction(double denum) {
        numerator = 1;
        denumerator = denum;
    }

    public Fraction(double num, double denum) {
        numerator = num;
        denumerator = denum;
    }

    ////////////GETTERS & SETTERS////////////

    public double getNumerator() {
        return numerator;
    }

    public double getDenumerator() {
        return denumerator;
    }

    public double getResult() {
        return numerator / denumerator;
    }

    public void setNumerator(double num) {
        numerator = num;
    }

    public void setDenumerator(double denum) {
        denumerator = denum;
    }

    ////////////AFFICHAGE////////////

    public void printResult() {
         System.out.println(numerator/denumerator);
    }

    public void printResultString() {
        System.out.println(numerator + "/" + denumerator);
    }

    public void isEqualString(Fraction frac) {
        if (isEgual(frac) == true) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }
    }

    public void printComparaison(Fraction frac) {
        if(this.comparaisonFraction(frac) == 1) {
            System.out.println(this.toString() + " > " + frac.toString());
        } else if(this.comparaisonFraction(frac) == 2) {
            System.out.println(this.toString() + " < " + frac.toString());
        } else {
            System.out.println(this.toString() + " = " + frac.toString());
        }
    }

    ////////////ADDITION////////////

    // Plus grand denominateur commun
    private static long gcm(long a, long b) {
        return b == 0 ? a : gcm(b, a % b);
    }

    public Fraction additionFracBrut(Fraction frac) {
        if(denumerator == frac.getDenumerator()) {
            return new Fraction(frac.getNumerator() + numerator, denumerator);
        } else {
            Fraction res1 = new Fraction(frac.getNumerator() * denumerator, frac.getDenumerator() * denumerator);
            Fraction res2 = new Fraction(numerator * frac.getDenumerator(), denumerator* frac.getDenumerator());
            return new Fraction(res1.getNumerator() + res2.getNumerator(), res1.getDenumerator());
        }
    }

    public Fraction additionFracSimplified(Fraction frac) {
        Fraction res = this.additionFracBrut(frac);
        long gcm = gcm((long)res.getNumerator(), (long)res.getDenumerator());
        return new Fraction(res.getNumerator() / (gcm), res.getDenumerator() / gcm);
    }

    ////////////EGALITE////////////

    public boolean isEgual(Fraction frac) {
        return numerator / denumerator == frac.getNumerator() / frac.getDenumerator() ? false : true;
    }

    ////////////CONVERSION EN STRING////////////

    public String toString() {
        return (numerator + "/" + denumerator);
    }

    ////////////COMPARAISON////////////

    // return 1 if a > b, 2 if a < b, 3 if a = b
    public int comparaisonFraction(Fraction frac) {
        if(this.getResult() > frac.getResult()) {
            return 1;
        } else if (this.getResult() < frac.getResult()) {
            return 2;
        } else {
            return 3;
        }
    }
}