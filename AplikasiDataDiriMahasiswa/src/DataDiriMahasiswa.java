import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DataDiriMahasiswa extends JFrame {
    // Komponen GUI
    private JLabel lblNIM, lblNama, lblJenisKelamin, lblAlamat, lblJurusan, lblAgama;
    private JTextField tfNIM, tfNama, tfAlamat;
    private JRadioButton rbLakiLaki, rbPerempuan;
    private ButtonGroup bgJenisKelamin;
    private JComboBox<String> cbJurusan, cbAgama;
    private JButton btnSimpan;
    
    public DataDiriMahasiswa() {
        super("Form Data Diri Mahasiswa");
        
        // Set layout menggunakan GridBagLayout
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        
        // Inisialisasi komponen
        lblNIM = new JLabel("NIM:");
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(lblNIM, gbc);
        
        tfNIM = new JTextField(20);
        gbc.gridx = 1;
        gbc.gridy = 0;
        add(tfNIM, gbc);
        
        lblNama = new JLabel("Nama:");
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(lblNama, gbc);
        
        tfNama = new JTextField(20);
        gbc.gridx = 1;
        gbc.gridy = 1;
        add(tfNama, gbc);
        
        lblJenisKelamin = new JLabel("Jenis Kelamin:");
        gbc.gridx = 0;
        gbc.gridy = 2;
        add(lblJenisKelamin, gbc);
        
        rbLakiLaki = new JRadioButton("Laki-Laki");
        rbPerempuan = new JRadioButton("Perempuan");
        bgJenisKelamin = new ButtonGroup();
        bgJenisKelamin.add(rbLakiLaki);
        bgJenisKelamin.add(rbPerempuan);
        JPanel panelJenisKelamin = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelJenisKelamin.add(rbLakiLaki);
        panelJenisKelamin.add(rbPerempuan);
        gbc.gridx = 1;
        gbc.gridy = 2;
        add(panelJenisKelamin, gbc);
        
        lblAlamat = new JLabel("Alamat:");
        gbc.gridx = 0;
        gbc.gridy = 3;
        add(lblAlamat, gbc);
        
        tfAlamat = new JTextField(20);
        gbc.gridx = 1;
        gbc.gridy = 3;
        add(tfAlamat, gbc);
        
        lblJurusan = new JLabel("Jurusan:");
        gbc.gridx = 0;
        gbc.gridy = 4;
        add(lblJurusan, gbc);
        
        String[] jurusanOptions = {"Teknik Informatika", "Sistem Informasi", "Manajemen Informatika"};
        cbJurusan = new JComboBox<>(jurusanOptions);
        gbc.gridx = 1;
        gbc.gridy = 4;
        add(cbJurusan, gbc);
        
        lblAgama = new JLabel("Agama:");
        gbc.gridx = 0;
        gbc.gridy = 5;
        add(lblAgama, gbc);
        
        String[] agamaOptions = {"Islam", "Kristen", "Katolik", "Hindu", "Buddha", "Konghucu"};
        cbAgama = new JComboBox<>(agamaOptions);
        gbc.gridx = 1;
        gbc.gridy = 5;
        add(cbAgama, gbc);
        
        btnSimpan = new JButton("Simpan");
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        add(btnSimpan, gbc);
        
        // Tambahkan action listener untuk tombol simpan
        btnSimpan.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                simpanData();
            }
        });
        
        // Set ukuran frame
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Agar muncul di tengah layar
        setVisible(true);
    }
    
    // Method untuk menyimpan data
    private void simpanData() {
        String nim = tfNIM.getText();
        String nama = tfNama.getText();
        String jenisKelamin = rbLakiLaki.isSelected() ? "Laki-Laki" : "Perempuan";
        String alamat = tfAlamat.getText();
        String jurusan = (String) cbJurusan.getSelectedItem();
        String agama = (String) cbAgama.getSelectedItem();
        
        // Lakukan penyimpanan data di sini (bisa ke database, file, dll)
        
        // Tampilkan pesan konfirmasi
        JOptionPane.showMessageDialog(this, "Data berhasil disimpan:\nNIM: " + nim + "\nNama: " + nama + "\nJenis Kelamin: " + jenisKelamin + "\nAlamat: " + alamat + "\nJurusan: " + jurusan + "\nAgama: " + agama);
        
        // Kosongkan field setelah disimpan
        tfNIM.setText("");
        tfNama.setText("");
        bgJenisKelamin.clearSelection();
        tfAlamat.setText("");
        cbJurusan.setSelectedIndex(0);
        cbAgama.setSelectedIndex(0);
    }
    
    public static void main(String[] args) {
        new DataDiriMahasiswa();
    }
}