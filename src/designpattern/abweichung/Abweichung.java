package designpattern.abweichung;

abstract class Abweichung {
    public double berechneAbweichung(double[] stichproben, int anzahl) {
        double mittelwert;
        double abweichung = 0.0;

        mittelwert = berechneMittelwert(stichproben, anzahl);
        for (int i = 0; i < anzahl; i++) {
            abweichung += Math.abs(stichproben[i] - mittelwert);
        }
        abweichung *= 1 / anzahl;
        return abweichung;
    }

    protected abstract double berechneMittelwert(double[] stichproben, int anzahl);
}
