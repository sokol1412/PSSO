
public class BillingTimingCall extends Call {

	public BillingTimingCall(BillingTimingCustomer caller, BillingTimingCustomer receiver) {
		super(caller, receiver);
		connections.removeAllElements();
		Connection c;
		if (receiver.localTo(caller)) {
			c = new BillingTimingLocal(caller, receiver);
		} else {
			c = new BillingTimingLongDistance(caller, receiver);
		}
		connections.addElement(c);
	}

}
