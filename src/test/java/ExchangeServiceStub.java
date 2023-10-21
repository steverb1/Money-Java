public class ExchangeServiceStub implements ForConvertingCurrency
{
    public double convert(double amount, CurrencyType sourceCurrency, CurrencyType targetCurency)
    {
        return amount * 2;
    }
}
