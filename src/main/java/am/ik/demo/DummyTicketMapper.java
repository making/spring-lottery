package am.ik.demo;

import java.util.*;

import org.springframework.stereotype.Component;

@Component
public class DummyTicketMapper implements TicketMapper {
	Random random = new Random();
	List<Ticket> data = new ArrayList<>();

	public DummyTicketMapper() {
		for (int i = 0; i < 20; i++) {
			Ticket ticket = new Ticket(100 + i, "hello" + i,
					"hello" + i + "@example.com");
			data.add(ticket);
		}
	}

	@Override
	public Ticket chooseOne(Set<Integer> excludes) {
		ArrayList<Ticket> tickets = new ArrayList<>();
		tickets.addAll(data);
		Collections.shuffle(tickets, random);

		for (Ticket ticket : tickets) {
			if (!excludes.contains(ticket.getNumber())) {
				return ticket;
			}
		}
		return null;
	}
}
