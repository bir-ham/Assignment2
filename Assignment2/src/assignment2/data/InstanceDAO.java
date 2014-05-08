package assignment2.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class InstanceDAO extends DataAccessObject {

	// Retrieves a one of the free tasks from the database and returns a new
	// Instance object.
	public Instance getFreeTask(Long id, String name) {

		ResultSet rs = null;
		PreparedStatement statement = null;
		Connection connection = null;

		try {
			connection = getConnection();
			String sql = "select * from instance where status=? limit 1";
			statement = connection.prepareStatement(sql);
			statement.setLong(1, id.longValue());
			rs = statement.executeQuery();
			if (!rs.next()) {
				return null;
			}
			return read(rs, name);

		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			close(rs, statement, connection);
		}
	}

	// Updates the status field in the database when the task is released by the
	// thread.
	public void updateStatus(Instance role) {

		PreparedStatement statement = null;
		Connection connection = null;

		try {
			connection = getConnection();
			String sql = "update instance set " + "status=? where task=?";
			statement = connection.prepareStatement(sql);
			statement.setLong(1, role.getStatus());
			statement.setString(2, role.getTask());
			statement.execute();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			close(statement, connection);
		}
	}

	// Builds an Instance encapsulation object using result set values as an
	// attribute.
	private Instance read(ResultSet rs, String name) throws SQLException {

		Long status = new Long(rs.getLong("status"));
		String task = rs.getString("task");

		Instance role = new Instance();
		role.setName(name);
		role.setStatus(status);
		role.setTask(task);

		return role;
	}
}
