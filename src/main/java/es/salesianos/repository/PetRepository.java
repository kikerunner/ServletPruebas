package es.salesianos.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import es.salesianos.connection.AbstractConnection;
import es.salesianos.connection.H2Connection;
import es.salesianos.model.Mascota;
import es.salesianos.model.Persona;

public class PetRepository {

	private static final String jdbcUrl = "jdbc:h2:file:./src/main/resources/test;INIT=RUNSCRIPT FROM 'classpath:scripts/create.sql'";
	AbstractConnection manager = new H2Connection();
	Persona personaendatabase = null;
	

	
	
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
	
	public Persona selectOwnerByPet(String nomMascota){
		Persona personaendatabase = null;
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			preparedStatement = conn
					.prepareStatement("SELECT p.CodPersona, p.nombre, p.apellido FROM Mascotas AS m, Personas as p WHERE p.codPersona = m.codPersona AND m.nomMascota = ?");
			preparedStatement.setString(1, nomMascota);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				personaendatabase = new Persona();
				personaendatabase.setCodPersona(resultSet.getInt(1));
				personaendatabase.setName(resultSet.getString(2));
				personaendatabase.setApellido(resultSet.getString(3));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			manager.close(preparedStatement);
		}

		manager.close(conn);
		return personaendatabase;
	}
	
	public Persona selectOnePet(int CodPersona) {
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
