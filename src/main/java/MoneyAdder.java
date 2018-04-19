public class MoneyAdder
{
    CurrencyConverting exchangeService;

    public MoneyAdder(CurrencyConverting currencyConverting)
    {
        this.exchangeService = currencyConverting;
    }

    public Money add(Money money1, Money money2)
    {
        if (money1.currency == money2.currency)
        {
            return new Money(money1.amount + money2.amount, money1.currency);
        }
        return new Money(money1.amount + exchangeService.convert(money2.amount, money2.currency, money1.currency), money1.currency);
    }
}
