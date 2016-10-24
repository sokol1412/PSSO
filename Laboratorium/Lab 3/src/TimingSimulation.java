

public class TimingSimulation extends AbstractSimulation {

	public static void main(String[] args) {
		simulation = new TimingSimulation();
		simulation.run();
	}

	protected void report(TimingCustomer c) {
		System.out.println(c + " has been connected for " + c.getTotalCallTime() + " seconds");
	}

	public void run() {
		TimingCustomer jim = new TimingCustomer("Jim", 650);
		TimingCustomer mik = new TimingCustomer("Mik", 650);
		TimingCustomer crista = new TimingCustomer("Crista", 415);

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

		report(jim);
		report(crista);
		report(mik);

	}

	@Override
	protected void report(Customer c) {
	}
}
