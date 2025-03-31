package DAO;

import config.DBConnection;

import models.Alumno;
import models.Direccion;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DireccionDAO {
    private final Connection connection;

    public DireccionDAO() {
        this.connection = DBConnection.getInstance().getConnection();
    }

    public void agregarDireccion(Direccion direccion) {
        String query = "INSERT INTO direcciones (calle, altura, alumno_id) VALUES (?,?,?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, direccion.getCalle());
            stmt.setInt(2, direccion.getAltura());
            stmt.setInt(3, direccion.getIdAlumno());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Direccion> obtenerDirecciones() {
        List<Direccion> direcciones = new ArrayList<>();
        String query = "SELECT * FROM direcciones";
        try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                direcciones.add(new Direccion(rs.getInt("id"),
                        rs.getString("calle"),
                        rs.getInt("altura"),
                        rs.getInt("alumno_id")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return direcciones;
    }

    public void actualizarDireccion(Direccion direccion) {
        String query = "UPDATE direcciones SET calle = ?," +
                "altura = ?," +
                "alumno_id = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, direccion.getCalle());
            stmt.setInt(2, direccion.getAltura());
            stmt.setInt(3,direccion.getIdAlumno());
            stmt.setInt(4, direccion.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void eliminarDireccion(int id) {
        String query = "DELETE FROM direcciones WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public Direccion obtenerDireccionPorId (int id)
    {
        String query = "SELECT * FROM direcciones WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new Direccion(rs.getInt("id"),
                        rs.getString("calle"),
                        rs.getInt("altura"),
                        rs.getInt("alumno_id")
                );
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener direccion: " + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }
}
