

public class TimingLongDistance extends LongDistance {

	TimingLongDistance(Customer a, Customer b) {
		super(a, b);
	}

	private long startTime;
	private long stopTime;

	@Override
	public void complete() {
		super.complete();
		startTime = System.currentTimeMillis();
	}

	@Override
	public void drop() {
		stopTime = System.currentTimeMillis();
		((TimingCustomer)getCaller()).addCallTime(getCallTime());
		((TimingCustomer)getReceiver()).addCallTime(getCallTime());
		super.drop();
	}

	public long getCallTime() {
		long time = stopTime - startTime;
		return time == 0 ? 0 : time/1000;
	}
}
