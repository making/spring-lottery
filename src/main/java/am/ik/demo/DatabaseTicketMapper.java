package am.ik.demo;

import java.util.Collections;
import java.util.Set;

import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

@Component
@Primary
public class DatabaseTicketMapper implements TicketMapper {
	final NamedParameterJdbcTemplate jdbcTemplate;

	public DatabaseTicketMapper(NamedParameterJdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public Ticket chooseOne(Set<Integer> excludes) {
		return jdbcTemplate.queryForObject(
				"SELECT number, name, email FROM lottery WHERE number NOT IN (:excludes) ORDER BY rand() LIMIT 1",
				Collections.singletonMap("excludes",
						excludes.isEmpty() ? Collections.singleton(0) : excludes),
				(rs, i) -> new Ticket(rs.getInt("number"), rs.getString("name"),
						rs.getString("email")));
	}
}
