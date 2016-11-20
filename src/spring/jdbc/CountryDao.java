package spring.jdbc;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.support.DaoSupport;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class CountryDao extends JdbcDaoSupport{
    
    public List<Country> getCountries(){
    	String sql = "SELECT code,name, region FROM WORLD.COUNTRY";
    	List<Country> customers = getJdbcTemplate().query(sql,new CountryRowMapper());
    	return customers;
    }

}
