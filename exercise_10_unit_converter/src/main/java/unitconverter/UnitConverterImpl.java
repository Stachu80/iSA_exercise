package unitconverter;

public class UnitConverterImpl implements UnitConverter {
    @Override
    public double celsiusToFahrenheit(double c) {
        return c * 9 / 5.0 + 32;
    }

    @Override
    public double fahrenheitToCelsius(double f) {
        return 5 * (f - 32.0) / 9.0;
    }

    @Override
    public double milesToKilometers(double m) {
        return m / 0.62137;
    }

    @Override
    public double kilometersToMiles(double k) {
        return k * 0.62137;
    }

    @Override
    public double poundsToKilograms(double p) {
        return p * 0.45359237;
    }

    @Override
    public double kilogramsToPounds(double k) {
        return k / 0.45359237;
    }
}
