/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend;
//import backend.DBHelper;
import java.util.ArrayList;
import java.sql.*;
import java.text.SimpleDateFormat;
/**
 *
 * @author sirfaratih
 */
public class Peminjaman {

    private int idpeminjaman;
    private Anggota anggota;
    private Buku buku;
    private Pegawai pegawai = new Pegawai();
    private String tanggalPinjam;
    private String tanggalKembali;
    
    public Peminjaman(){
        
    }

    public Peminjaman(Anggota anggota, Buku buku, Pegawai pegawai, String tanggalPinjam, String tanggalKembali) {
        this.anggota = anggota;
        this.buku = buku;
        this.pegawai = pegawai;
        this.tanggalPinjam = tanggalPinjam;
        this.tanggalKembali = tanggalKembali;
    }

    public int getIdpeminjaman() {
        return idpeminjaman;
    }

    public void setIdpeminjaman(int idpeminjaman) {
        this.idpeminjaman = idpeminjaman;
    }

    public Anggota getAnggota() {
        return anggota;
    }

    public void setAnggota(Anggota anggota) {
        this.anggota = anggota;
    }
     public Pegawai getPegawai() {
        return pegawai;
    }

    public void setPegawai(Pegawai pegawai) {
        this.pegawai = pegawai;
    }

    public Buku getBuku() {
        return buku;
    }

    public void setBuku(Buku buku) {
        this.buku = buku;
        
    }

    public String getTanggalPinjam() {
        return tanggalPinjam;
    }

    public void setTanggalPinjam(String tanggalPinjam) {
        this.tanggalPinjam = tanggalPinjam;
    }

    public String getTanggalKembali() {
        return tanggalKembali;
    }

    public void setTanggalKembali(String tanggalKembali) {
        this.tanggalKembali = tanggalKembali;
    }

     public Peminjaman getById(int id) {
        Peminjaman peminjaman = new Peminjaman();
        String query = "SELECT p.*, pg.nama AS namaPegawai, pg.idpegawai "
                + "FROM peminjaman p "
                + "JOIN pegawai pg ON p.idpegawai = pg.idpegawai "
                + "WHERE p.idpeminjaman = '" + id + "'";
        ResultSet rs = DBHelper.selectQuery(query);

        try {
            if (rs.next()) {
                peminjaman.setIdpeminjaman(rs.getInt("idpeminjaman"));
                peminjaman.getAnggota().setIdanggota(rs.getInt("idanggota"));
                peminjaman.getBuku().setIdbuku(rs.getInt("idbuku"));
                peminjaman.setTanggalPinjam(rs.getString("tanggalpinjam"));
                peminjaman.setTanggalKembali(rs.getString("tanggalkembali"));

                // Buat objek Pegawai lengkap
                Pegawai pegawai = new Pegawai();
                pegawai.setidpegawai(rs.getInt("idpegawai"));
                pegawai.setnama(rs.getString("namaPegawai"));
                peminjaman.setPegawai(pegawai);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return peminjaman;
    }

 public ArrayList<Peminjaman> getAll() {
        ArrayList<Peminjaman> listPeminjaman = new ArrayList<>();
        String query = "SELECT p.*, pg.idpegawai, pg.nama AS namaPegawai FROM peminjaman p "
                + "JOIN pegawai pg ON p.idpegawai = pg.idpegawai ORDER BY p.idpeminjaman DESC";

        ResultSet rs = DBHelper.selectQuery(query);

        try {
            while (rs.next()) {
                Peminjaman peminjaman = new Peminjaman();
                peminjaman.setIdpeminjaman(rs.getInt("idpeminjaman"));
                peminjaman.getAnggota().setIdanggota(rs.getInt("idanggota"));
                peminjaman.getBuku().setIdbuku(rs.getInt("idbuku"));
                peminjaman.setTanggalPinjam(rs.getString("tanggalpinjam"));
                peminjaman.setTanggalKembali(rs.getString("tanggalkembali"));

                Pegawai pegawai = new Pegawai();
                pegawai.setidpegawai(rs.getInt("idpegawai"));
                pegawai.setnama(rs.getString("namaPegawai"));
                peminjaman.setPegawai(pegawai);

                listPeminjaman.add(peminjaman);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listPeminjaman;
    }
    public ArrayList<Peminjaman> search(String keyword) {
        ArrayList<Peminjaman> listPeminjaman = new ArrayList<>();
        String query = "SELECT * FROM peminjaman WHERE idanggota LIKE '%" + keyword + "%' OR idbuku LIKE '%" + keyword + "%'";
        ResultSet rs = DBHelper.selectQuery(query);

        try {
            while (rs.next()) {
                Peminjaman peminjaman = new Peminjaman();
                peminjaman.setIdpeminjaman(rs.getInt("idpeminjaman"));
                peminjaman.getAnggota().setIdanggota(rs.getInt("idanggota"));
                peminjaman.getBuku().setIdbuku(rs.getInt("idbuku"));
                peminjaman.setTanggalPinjam(rs.getString("tanggalpinjam"));
                peminjaman.setTanggalKembali(rs.getString("tanggalkembali"));

                listPeminjaman.add(peminjaman);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listPeminjaman;
    }

    public void save() {
        String SQL;
        if (getById(idpeminjaman).getIdpeminjaman() == 0) {
            // Jika data baru
            SQL = "INSERT INTO peminjaman (idanggota, idbuku, idpegawai, tanggalpinjam, tanggalkembali) VALUES ("
                    + "'" + this.getAnggota().getIdanggota() + "', "
                    + "'" + this.getBuku().getIdbuku() + "', "
                    + "'" + this.getPegawai().getidpegawai() + "', "
                    + "'" + this.tanggalPinjam + "', "
                    + (this.tanggalKembali != null ? "'" + this.tanggalKembali + "'" : "NULL") + ")";
            this.idpeminjaman = DBHelper.insertQueryGetId(SQL);
        } else {
            // Jika data sudah ada (update)
            SQL = "UPDATE peminjaman SET "
                    + "idanggota = '" + this.getAnggota().getIdanggota() + "', "
                    + "idbuku = '" + this.getBuku().getIdbuku() + "', "
                    + "idpegawai = '" + this.getPegawai().getidpegawai() + "', "
                    + "tanggalpinjam = '" + this.tanggalPinjam + "', "
                    + "tanggalkembali = " + (this.tanggalKembali != null ? "'" + this.tanggalKembali + "'" : "NULL") + " "
                    + "WHERE idpeminjaman = '" + this.idpeminjaman + "'";
            DBHelper.executeQuery(SQL);
        }
    }

    // Method untuk menghapus data peminjaman
    public void delete() {
        String SQL = "DELETE FROM peminjaman WHERE idpeminjaman = '" + this.idpeminjaman + "'";
        DBHelper.executeQuery(SQL);
    }

    public String getNamaAnggotaById(int idAnggota) {
        String nama = "";
        String query = "SELECT nama FROM anggota WHERE idanggota = " + idAnggota;
        ResultSet rs = DBHelper.selectQuery(query);
        try {
            if (rs.next()) {
                nama = rs.getString("nama");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return nama;
    }

    public String getJudulBukuById(int idBuku) {
        String judul = "";
        String query = "SELECT judul FROM buku WHERE idbuku = " + idBuku;
        ResultSet rs = DBHelper.selectQuery(query);
        try {
            if (rs.next()) {
                judul = rs.getString("judul");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return judul;
    }
    
}