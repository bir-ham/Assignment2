package assignment2.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RoleDAO extends DataAccessObject {

	// 
	public Role getRole(Long id) {

		ResultSet rs = null;
		PreparedStatement statement = null;
		Connection connection = null;

		try {
			connection = getConnection();
			String sql = "select * from role where id=?";
			statement = connection.prepareStatement(sql);
			statement.setLong(1, id.longValue());
			rs = statement.executeQuery();
			if (!rs.next()) {
				return null;
			}
			return read(rs);

		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			close(rs, statement, connection);
		}
	}
	
	private Role read(ResultSet rs) throws SQLException {

		Long status = new Long(rs.getLong("status"));
		String name = rs.getString("name");
		
		Role role = new Role();
		role.setStatus(status);
		role.setName(name);
	
		return role;
	}
}
