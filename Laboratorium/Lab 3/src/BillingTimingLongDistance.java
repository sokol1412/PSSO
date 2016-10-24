

public class BillingTimingLongDistance extends TimingLongDistance {

	BillingTimingLongDistance(Customer a, Customer b) {
		super(a, b);
	}

	@Override
	public void drop() {
		super.drop();
		((BillingTimingCustomer)getCaller()).addBill(getCallTime(), 10);
	}
}
