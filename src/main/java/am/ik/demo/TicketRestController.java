package am.ik.demo;

import java.util.Set;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class TicketRestController {
	private final TicketMapper ticketMapper;

	public TicketRestController(TicketMapper ticketMapper) {
		this.ticketMapper = ticketMapper;
	}

	@GetMapping("chooseOne")
	Ticket chooseOne(@RequestParam("excludes") Set<Integer> excludes) {
		return ticketMapper.chooseOne(excludes);
	}
}
