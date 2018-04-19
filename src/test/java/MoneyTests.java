import org.junit.Test;

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
        double sum = adder.add(4.2, CurrencyType.USD, 2.1, CurrencyType.USD);
        assertThat(sum, is(closeTo(6.3, TOLERANCE)));
    }
    
    @Test
    public void Given4UsdAdd2Eur_Returns8Usd()
    {
        MoneyAdder adder = new MoneyAdder(exchangeServiceStub);
        double sum = adder.add(4.0, CurrencyType.USD, 2, CurrencyType.EUR);
        assertThat(sum, is(closeTo(8.0, TOLERANCE)));
    }

    @Test
    public void Given4UsdAdd2Eur_Returns8Usd_UsingMock()
    {
        MoneyAdder adder = new MoneyAdder(mockService);
        when(mockService.convert(2, CurrencyType.EUR, CurrencyType.USD)).thenReturn(4.0);
        double sum = adder.add(4.0, CurrencyType.USD, 2, CurrencyType.EUR);
        assertThat(sum, is(closeTo(8.0, TOLERANCE)));
    }
}
