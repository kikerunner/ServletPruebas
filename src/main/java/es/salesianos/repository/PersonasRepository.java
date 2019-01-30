package es.salesianos.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import es.salesianos.connection.AbstractConnection;
import es.salesianos.connection.H2Connection;
import es.salesianos.model.Mascota;
import es.salesianos.model.Persona;

@Repository
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
	
	public void insertPet(Mascota mascota) {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn
					.prepareStatement("INSERT INTO MASCOTAS(nomMascota,CodPersona) VALUES (?, ?)");
			preparedStatement.setString(1, mascota.getNomMascota());
			preparedStatement.setInt(2, mascota.getCodPersona());
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
			for (Persona persona : personas) {
				
				preparedStatement = conn.prepareStatement(
						"SELECT * FROM MASCOTAS where codPersona="+persona.getCodPersona());
				resultSet = preparedStatement.executeQuery();
				while (resultSet.next()) {
					Mascota pet = new Mascota();
					pet.setNomMascota(resultSet.getString(1));
					pet.setCodPersona(resultSet.getInt(2));
					persona.getMascotas().add(pet);
				}
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
	
	public Persona selectOnePerson(int CodPersona) {
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
	
	public void updatePerson(Persona persona) {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn
					.prepareStatement("UPDATE Personas SET nombre = ?, apellido = ? WHERE CodPersona = ?");
			preparedStatement.setString(1, persona.getName());
			preparedStatement.setString(2, persona.getApellido());
			preparedStatement.setInt(3, persona.getCodPersona());
			
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			manager.close(preparedStatement);
			manager.close(conn);
		}
		
	}
	
	public void borrarPersona(Persona persona) {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		PreparedStatement preparedStatement2 = null;
		try {
			preparedStatement = conn
					.prepareStatement("DELETE FROM PERSONAS WHERE CodPersona = ?");	
			preparedStatement.setInt(1, persona.getCodPersona());
			
			preparedStatement2 = conn
					.prepareStatement("DELETE FROM MASCOTAS WHERE CodPersona = ?");	
			preparedStatement2.setInt(1, persona.getCodPersona());
			
			preparedStatement2.executeUpdate();
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			manager.close(preparedStatement2);
			manager.close(preparedStatement);
			manager.close(conn);
		}
	}
	
}
