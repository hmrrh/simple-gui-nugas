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
import java.text.NumberFormat;
import java.util.Locale;
import java.awt.event.ActionEvent;
import javax.swing.ButtonGroup;
import java.awt.Color;
import java.awt.SystemColor;

public class MyGUI {

	private JFrame frmLanggananBerbayar;
	private JTextField tfNama;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	protected JLabel lbLangganan;
	private JTextField tfKupon;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyGUI window = new MyGUI();
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
	public MyGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		frmLanggananBerbayar = new JFrame();
		frmLanggananBerbayar.getContentPane().setBackground(Color.PINK);
		frmLanggananBerbayar.setBackground(Color.LIGHT_GRAY);
		frmLanggananBerbayar.setTitle("Langganan Berbayar");
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
		cbLangganan.setBounds(10, 148, 395, 23);
		frmLanggananBerbayar.getContentPane().add(cbLangganan);

		JLabel lblLangganan = new JLabel("");
		lblLangganan.setFont(new Font("Consolas", Font.BOLD, 12));
		lblLangganan.setBounds(10, 212, 362, 14);
		frmLanggananBerbayar.getContentPane().add(lblLangganan);

		JLabel lblBayar = new JLabel("");
		lblBayar.setFont(new Font("Consolas", Font.BOLD, 12));
		lblBayar.setBackground(Color.ORANGE);
		lblBayar.setBounds(10, 237, 362, 14);
		frmLanggananBerbayar.getContentPane().add(lblBayar);

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
					tfKupon.setEnabled(false);
					cbLangganan.setEnabled(false);

					if (btn1bulan.isSelected())
						harga = 150000;
					if (btn3bulan.isSelected())
						harga = 300000;
					if (btn1tahun.isSelected())
						harga = 1500000;

					// hitung diskon
					String kupon = "DISKON10";
					if (tfKupon.getText().equals(kupon)) {
						harga = harga * 0.9;
					}

					NumberFormat format = NumberFormat.getCurrencyInstance(new Locale("id", "ID"));
					String currency = format.format(harga);

					lblLangganan.setText("Selamat, " + tfNama.getText() + " telah mulai berlangganan");
					lblBayar.setText("Total yang harus Anda bayar sebesar : " + currency);
				}

			}
		});
		btnLangganan.setBounds(63, 178, 296, 23);
		frmLanggananBerbayar.getContentPane().add(btnLangganan);

		JLabel lblDiskon = new JLabel("Input kode diskon : ");
		lblDiskon.setFont(new Font("Consolas", Font.BOLD, 11));
		lblDiskon.setBounds(10, 127, 133, 14);
		frmLanggananBerbayar.getContentPane().add(lblDiskon);

		tfKupon = new JTextField();
		tfKupon.setFont(new Font("Consolas", Font.BOLD, 12));
		tfKupon.setBounds(171, 121, 96, 20);
		frmLanggananBerbayar.getContentPane().add(tfKupon);
		tfKupon.setColumns(10);

	}
}
