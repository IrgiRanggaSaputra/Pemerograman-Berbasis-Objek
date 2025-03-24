package com.mycompany.bengkel;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BengkelOperations {
    private Connection connection;
    
    public BengkelOperations() throws SQLException{
        connection = DatabaseConnection.getConnection();
    }
    
    //Membuat
    public void tambahServis(Bengkel bengkel){
        String query = "INSERT INTO bengkel (nama, layanan) VALUES (?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)){
            stmt.setString(1, bengkel.getNama());
            stmt.setString(2, bengkel.getLayanan());
            stmt.execute();
            System.out.println("Servis Bengkel Ditambahkan!!");
        }catch (SQLException e){
            e.printStackTrace();
    }
}
    
    //Membaca
    public List<Bengkel> getServis(){
        List<Bengkel> services = new ArrayList<>();
        String query = "SELECT * FROM bengkel";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)){
            
            while (rs.next()){
                services.add(new Bengkel(
                        rs.getInt("id"),
                        rs.getString("nama"),
                        rs.getString("layanan"),
                        rs.getBoolean("is_selesai"),
                        rs.getString("tanggal_masuk")));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }return services;
    }
    public void updateServis(int id, String namaBaru, String layananBaru) {
        String query = "UPDATE bengkel SET nama = ?, layanan = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, namaBaru);
            stmt.setString(2, layananBaru);
            stmt.setInt(3, id);
            stmt.executeUpdate();
            System.out.println("Data servis diperbarui!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void hapusServis(int id) {
        String query = "DELETE FROM bengkel WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Servis dihapus!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
     public void tandaiSelesai(int id) {
        String query = "UPDATE bengkel SET is_selesai = TRUE WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Servis selesai!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
