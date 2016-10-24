

public class BillingTimingLocal extends TimingLocal {

	BillingTimingLocal(Customer a, Customer b) {
		super(a, b);
	}

	@Override
	public void drop() {
		super.drop();
		((BillingTimingCustomer)getCaller()).addBill(getCallTime(), 3);
	}
}
