public class Main {

    public static void main(String[] args) {

        Fraction frac = new Fraction(1, 3);
        Fraction frac2 = new Fraction(1, 6);
        Fraction frac3 = new Fraction(3, 9);
        Fraction res = new Fraction();

        res = frac.additionFracBrut(frac2);
        res.printResultString();
        res.printResult();

        res = frac.additionFracSimplified(frac2);
        res.printResultString();

        frac.isEqualString(frac2);

        frac.printComparaison(frac3);

    }
}
