import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.number.IsCloseTo.closeTo;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MoneyTests
{
    public static final double TOLERANCE = .000001;
    private ExchangeServiceStub exchangeServiceStub = new ExchangeServiceStub();

    CurrencyConverting mockService = mock(CurrencyConverting.class);

    @Test
    public void Given4UsdAdd2Usd_Returns6Usd()
    {
        MoneyAdder adder = new MoneyAdder(exchangeServiceStub);
        Money sum = adder.add(new Money(4.2, CurrencyType.USD), new Money(2.1, CurrencyType.USD));
        assertThat(sum.amount, is(closeTo(6.3, TOLERANCE)));
        assertThat(sum.currency, is(CurrencyType.USD));
    }
    
    @Test
    public void Given4UsdAdd2Eur_Returns8Usd()
    {
        MoneyAdder adder = new MoneyAdder(exchangeServiceStub);
        Money sum = adder.add(new Money(4, CurrencyType.USD), new Money(2, CurrencyType.EUR));
        assertThat(sum.amount, is(closeTo(8.0, TOLERANCE)));
        assertThat(sum.currency, is(CurrencyType.USD));
    }

    @Test
    public void Given4UsdAdd2Eur_Returns8Usd_UsingMock()
    {
        MoneyAdder adder = new MoneyAdder(mockService);
        when(mockService.convert(2, CurrencyType.EUR, CurrencyType.USD)).thenReturn(4.0);
        Money sum = adder.add(new Money(4, CurrencyType.USD), new Money(2, CurrencyType.EUR));
        assertThat(sum.amount, is(closeTo(8.0, TOLERANCE)));
        assertThat(sum.currency, is(CurrencyType.USD));
    }
}
