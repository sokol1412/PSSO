

public class BillingTimingCustomer extends TimingCustomer {

	
	private long bill;

	public BillingTimingCustomer(String name, int areacode) {
		super(name, areacode);
	}

	public BillingTimingCall call(BillingTimingCustomer receiver) {
		BillingTimingCall call = new BillingTimingCall(this, receiver);
		addCall(call);
		return call;
	}

	public void addBill(long time, long price) {
		bill += time * price;
	}
	
	public long getBill() {
		return bill;
	}
}
