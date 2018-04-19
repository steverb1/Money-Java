public class ExchangeServiceStub implements CurrencyConverting
{
    public double convert(double amount, CurrencyType sourceCurrency, CurrencyType targetCurency)
    {
        return amount * 2;
    }
}
