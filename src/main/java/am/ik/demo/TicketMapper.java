package am.ik.demo;

import java.util.Set;

public interface TicketMapper {
    Ticket chooseOne(Set<Integer> excludes);
}
