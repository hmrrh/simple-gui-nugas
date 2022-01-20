package main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.NumberFormat;
import java.util.Locale;
import java.awt.event.ActionEvent;
import javax.swing.ButtonGroup;
import java.awt.Color;
import java.awt.SystemColor;

public class Tambahan {

	private JFrame frmLanggananBerbayar;
	private JTextField tfNama;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	protected JLabel lbLangganan;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tambahan window = new Tambahan();
					window.frmLanggananBerbayar.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Tambahan() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		frmLanggananBerbayar = new JFrame();
		frmLanggananBerbayar.getContentPane().setBackground(Color.PINK);
		frmLanggananBerbayar.setBackground(Color.LIGHT_GRAY);
		frmLanggananBerbayar.setTitle("Ramadhania Humaira_Form Langganan");
		frmLanggananBerbayar.setBounds(100, 100, 450, 300);
		frmLanggananBerbayar.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLanggananBerbayar.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Nama");
		lblNewLabel.setFont(new Font("Consolas", Font.BOLD, 12));
		lblNewLabel.setBounds(10, 11, 40, 20);
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		frmLanggananBerbayar.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Jenis langganan");
		lblNewLabel_1.setFont(new Font("Consolas", Font.BOLD, 12));
		lblNewLabel_1.setBounds(10, 34, 119, 20);
		frmLanggananBerbayar.getContentPane().add(lblNewLabel_1);

		tfNama = new JTextField();
		tfNama.setFont(new Font("Consolas", Font.BOLD, 12));
		tfNama.setBounds(163, 9, 242, 20);
		frmLanggananBerbayar.getContentPane().add(tfNama);
		tfNama.setColumns(10);

		JRadioButton btn1bulan = new JRadioButton("1 Bulan");
		btn1bulan.setFont(new Font("Consolas", Font.BOLD, 11));
		btn1bulan.setBackground(Color.PINK);
		buttonGroup.add(btn1bulan);
		btn1bulan.setBounds(163, 34, 111, 23);
		frmLanggananBerbayar.getContentPane().add(btn1bulan);

		JRadioButton btn3bulan = new JRadioButton("3 Bulan");
		btn3bulan.setFont(new Font("Consolas", Font.BOLD, 11));
		btn3bulan.setBackground(Color.PINK);
		buttonGroup.add(btn3bulan);
		btn3bulan.setBounds(163, 60, 111, 23);
		frmLanggananBerbayar.getContentPane().add(btn3bulan);

		JRadioButton btn1tahun = new JRadioButton("1 Tahun");
		btn1tahun.setFont(new Font("Consolas", Font.BOLD, 11));
		btn1tahun.setBackground(Color.PINK);
		buttonGroup.add(btn1tahun);
		btn1tahun.setBounds(163, 86, 111, 23);
		frmLanggananBerbayar.getContentPane().add(btn1tahun);

		JCheckBox cbLangganan = new JCheckBox("Saya setuju dan telah membaca ketentuan berlangganan");
		cbLangganan.setFont(new Font("Consolas", Font.BOLD, 12));
		cbLangganan.setBackground(Color.PINK);
		cbLangganan.setBounds(10, 112, 395, 23);
		frmLanggananBerbayar.getContentPane().add(cbLangganan);

		JLabel lblLangganan = new JLabel("");
		lblLangganan.setFont(new Font("Consolas", Font.BOLD, 12));
		lblLangganan.setBounds(32, 173, 373, 14);
		frmLanggananBerbayar.getContentPane().add(lblLangganan);

		JLabel lblBayar = new JLabel("");
		lblBayar.setFont(new Font("Consolas", Font.BOLD, 12));
		lblBayar.setBackground(Color.ORANGE);
		lblBayar.setBounds(32, 198, 373, 14);
		frmLanggananBerbayar.getContentPane().add(lblBayar);
		
		JLabel lblNota = new JLabel("");
		lblNota.setFont(new Font("Consolas", Font.BOLD, 12));
		lblNota.setBounds(94, 225, 242, 14);
		frmLanggananBerbayar.getContentPane().add(lblNota);

		JButton btnLangganan = new JButton("Mulai Berlangganan");
		btnLangganan.setFont(new Font("Consolas", Font.BOLD, 12));
		btnLangganan.setBackground(Color.WHITE);
		btnLangganan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nama;
				double harga = 0;

				lblLangganan.setText("");
				lblBayar.setText("");

				if (!tfNama.getText().isEmpty() && cbLangganan.isSelected() && buttonGroup.getSelection() != null) {

					tfNama.setEnabled(false);
					btn1bulan.setEnabled(false);
					btn3bulan.setEnabled(false);
					btn1tahun.setEnabled(false);
					cbLangganan.setEnabled(false);

					if (btn1bulan.isSelected())
						harga = 150000;
					if (btn3bulan.isSelected())
						harga = 300000;
					if (btn1tahun.isSelected())
						harga = 1500000;

					NumberFormat format = NumberFormat.getCurrencyInstance(new Locale("id", "ID"));
					String currency = format.format(harga);

					lblLangganan.setText("Selamat, " + tfNama.getText() + " telah mulai berlangganan");
					lblBayar.setText("Total yang harus Anda bayar sebesar : " + currency);
					
					
					//cetak nota
					String notaTampil = lblLangganan.getText() + "\n" + lblBayar.getText();
					File outputNota = new File("Nota Berlangganan.txt");
					lblNota.setText("");
					
					try {
						PrintWriter hasil = new PrintWriter(outputNota);

						hasil.println(notaTampil + "\nSegera lunasi pembayaran Anda.");
						hasil.close();

						lblNota.setText("Nota berhasil di cetak");

					} catch (FileNotFoundException e1) {

						e1.printStackTrace();
					}
//					Akhir Code Cetak Nota

				} else {
					lblLangganan.setText("Data yang Anda input belum lengkap");
					lblNota.setText("Nota tidak berhasil di cetak");
				}
				tfNama.setEnabled(false);
			}
		});
		btnLangganan.setBounds(55, 142, 296, 23);
		frmLanggananBerbayar.getContentPane().add(btnLangganan);
		
		

	}
}
