package com.liga_betplay.data;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DatabaseInitializer {

    public static void main(String[] args) {
        DatabaseInitializer initializer = new DatabaseInitializer();
        initializer.createTables();
    }

    public void createTables() {
        Connection connection = null;
        try {
            // Cargar las propiedades desde el archivo db.properties
            Properties props = new Properties();
            InputStream input = getClass().getClassLoader().getResourceAsStream("db.properties");
            
            if (input == null) {
                throw new RuntimeException("No se encontró el archivo db.properties");
            }

            props.load(input);

            String url = props.getProperty("url");
            String user = props.getProperty("user");
            String password = props.getProperty("password");

            // Establecer la conexión a la base de datos
            connection = DriverManager.getConnection(url, user, password);
            Statement statement = connection.createStatement();

            // Crear la base de datos si no existe
            String createDatabaseQuery = "CREATE DATABASE IF NOT EXISTS betplay";
            statement.executeUpdate(createDatabaseQuery);

            // Usar la base de datos
            statement.execute("USE betplay");

            // Crear tablas necesarias
            createEquipoTable(statement);
            createJugadorTable(statement);
            createPartidoTable(statement);
            // createGolTable(statement);
            // createTarjetaTable(statement);
            // createIncidenteTable(statement);
            // createResultadoTable(statement);
            // createLesionTable(statement);
            // createRendimientoTable(statement);
            // createEntrenamientoTable(statement);
            // createActividadTable(statement);
            // createTransferenciaTable(statement);
            // createUsuarioTable(statement);
            // createRolTable(statement);
            // createPermisoTable(statement);
            // createPatrocinadorTable(statement);
            // createComunicacionTable(statement);
            // createEntradaTable(statement);
            // createEstadioTable(statement);

            System.out.println("Tablas creadas exitosamente.");

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private void createEquipoTable(Statement statement) throws SQLException {
        String createTableQuery = "CREATE TABLE IF NOT EXISTS Team (" +
                                  "id INT AUTO_INCREMENT PRIMARY KEY," +
                                  "name VARCHAR(255) NOT NULL," +
                                  "city VARCHAR(255) NOT NULL," +
                                  "stadium VARCHAR(255) NOT NULL," +
                                  "trainer VARCHAR(255) NOT NULL" +
                                  ")";
        statement.executeUpdate(createTableQuery);
    }

    private void createJugadorTable(Statement statement) throws SQLException {
        String createTableQuery = "CREATE TABLE IF NOT EXISTS Jugador (" +
                                  "id INT AUTO_INCREMENT PRIMARY KEY," +
                                  "nombre VARCHAR(255) NOT NULL," +
                                  "edad INT," +
                                  "posicion VARCHAR(100)," +
                                  "nacionalidad VARCHAR(100)," +
                                  "numeroCamiseta INT," +
                                  "equipo_id INT," +
                                  "FOREIGN KEY (equipo_id) REFERENCES Equipo(id)" +
                                  ")";
        statement.executeUpdate(createTableQuery);
    }

    private void createPartidoTable(Statement statement) throws SQLException {
        String createTableQuery = "CREATE TABLE IF NOT EXISTS Partido (" +
                                  "id INT AUTO_INCREMENT PRIMARY KEY," +
                                  "equipoLocal VARCHAR(255) NOT NULL," +
                                  "equipoVisitante VARCHAR(255) NOT NULL," +
                                  "fecha DATE," +
                                  "hora TIME," +
                                  "estadio VARCHAR(255) NOT NULL" +
                                  ")";
        statement.executeUpdate(createTableQuery);
    }
}
