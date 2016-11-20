package spring.jdbc;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class CountryRowMapper implements RowMapper, Serializable{

	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		Country country = new Country();
		country.setCode(rs.getString("code"));
		country.setName(rs.getString("name"));
		country.setRegion(rs.getString("region"));
		return country;
	}
}
