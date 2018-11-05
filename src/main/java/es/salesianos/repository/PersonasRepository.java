package es.salesianos.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import es.salesianos.connection.AbstractConnection;
import es.salesianos.connection.H2Connection;
import es.salesianos.model.Persona;

public class PersonasRepository {

	private static final String jdbcUrl = "jdbc:h2:file:./src/main/resources/test;INIT=RUNSCRIPT FROM 'classpath:scripts/create.sql'";
	AbstractConnection manager = new H2Connection();


	public void insert(Persona persona) {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn
					.prepareStatement("INSERT INTO PERSONAS(nombre,apellido) VALUES (?, ?)");
			preparedStatement.setString(1, persona.getName());
			preparedStatement.setString(2, persona.getApellido());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			manager.close(preparedStatement);
		}

		manager.close(conn);
	}

}
