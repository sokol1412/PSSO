

public class BillingTimingSimulation extends TimingSimulation {

	public static void main(String[] args) {
		simulation = new BillingTimingSimulation();
		simulation.run();
	}

	protected void report(BillingTimingCustomer c) {
		System.out.println(c + " has been connected for " + c.getTotalCallTime() + " seconds and has a bill of " + c.getBill());
	}

	public void run() {
		BillingTimingCustomer jim = new BillingTimingCustomer("Jim", 650);
		BillingTimingCustomer mik = new BillingTimingCustomer("Mik", 650);
		BillingTimingCustomer crista = new BillingTimingCustomer("Crista", 415);

		say("jim calls mik...");
		Call c1 = jim.call(mik);
		wait(1);
		say("mik accepts...");
		mik.pickup(c1);
		wait(4);
		say("jim hangs up...");
		jim.hangup(c1);

		say("jim calls crista...");
		Call c2 = jim.call(crista);
		say("crista accepts...");
		crista.pickup(c2);
		wait(2);
		say("crista hangs up...");
		crista.hangup(c2);
		
		say("crista calls jim...");
		Call c3 = crista.call(jim);
		say("jim accepts...");
		jim.pickup(c3);
		wait(7);
		say("jim hangs up...");
		jim.hangup(c3);

		report(jim);
		report(crista);
		report(mik);

	}

	@Override
	protected void report(Customer c) {
	}
}
