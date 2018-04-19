import java.util.Random;

public class ExchangeService implements CurrencyConverting
{
    public double convert(double amount, CurrencyType sourceCurrency, CurrencyType targetCurency)
    {
        return amount * new Random().nextDouble();
    }
}
