public class MoneyAdder
{
    CurrencyConverting exchangeService;

    public MoneyAdder(CurrencyConverting currencyConverting)
    {
        this.exchangeService = currencyConverting;
    }

    public double add(double value1, CurrencyType currency1, double value2, CurrencyType currency2)
    {
        if (currency1 == currency2)
        {
            return value1 + value2;
        }
        return value1 + exchangeService.convert(value2, currency2, currency1);
    }
}
