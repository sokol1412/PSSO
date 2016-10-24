

public class TimingCustomer extends Customer {

	private long totalCallTime;

	public TimingCustomer(String name, int areacode) {
		super(name, areacode);
	}

	public TimingCall call(TimingCustomer receiver) {
		TimingCall call = new TimingCall(this, receiver);
		addCall(call);
		return call;
	}

	public void addCallTime(long timeToAdd) {
		totalCallTime += timeToAdd;
	}
    public long getTotalCallTime() {
		return totalCallTime;
	}
}
