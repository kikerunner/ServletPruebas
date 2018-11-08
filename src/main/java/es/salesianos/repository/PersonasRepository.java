package es.salesianos.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
	
	public List<Persona>searchAll() {
		List<Persona> personas = new ArrayList<Persona>();
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			preparedStatement = conn
					.prepareStatement("SELECT * FROM Personas");
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				Persona personaInDatabase = new Persona();
				personaInDatabase.setCodPersona(resultSet.getInt(1));
				personaInDatabase.setName(resultSet.getString(2));
				personaInDatabase.setApellido(resultSet.getString(3));
				
				personas.add(personaInDatabase);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			manager.close(preparedStatement);
		}

		manager.close(conn);
		return personas;
		
	}
	
	public Persona selectOnePerson(Integer CodPersona) {
		Persona personaInDatabase = null;
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			preparedStatement = conn
					.prepareStatement("SELECT * FROM Personas WHERE CodPersona = ?");
			preparedStatement.setInt(1, CodPersona);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				personaInDatabase = new Persona();
				personaInDatabase.setCodPersona(resultSet.getInt(1));
				personaInDatabase.setName(resultSet.getString(2));
				personaInDatabase.setApellido(resultSet.getString(3));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			manager.close(preparedStatement);
		}

		manager.close(conn);
		return personaInDatabase;
	}
	
}
