package am.ik.demo;

public class Ticket {
	private final Integer number;
	private final String name;
	private final String email;

	public Ticket(Integer number, String name, String email) {
		this.number = number;
		this.name = name;
		this.email = email;
	}

	public Integer getNumber() {
		return number;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}
}
