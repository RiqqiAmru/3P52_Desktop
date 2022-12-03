/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package d_riqqi;

import javax.swing.JOptionPane;

/**
 *
 * @author Riqqi
 */
public class RemidiAlgoritmaMaba {

    public static String diskjam, ketds, pt, kettiket, pts, kettujuan;
    public static float diskonjam = 0.0f, diskon = 0.0f, harga = 0f, jampesan = 0f;
    public static double diskpem = 0.00;
    public static int byr, x, z = 0, rumusharga = 0;
    public static int no_data;

    public static void main(String[] args) {
        no_data = 0;
        String pb = "";
        String karena = "";
        int totaldiskon = 0, totaldiskon2 = 0, totaldiskon3 = 0, totaldiskonsemuanya = 0, hargadiskon3 = 0;
        int administrasi = 7000;
        int totalbayarnya = 0;
        String namatiket[] = null;
        namatiket = new String[8];
        String tujuantiket[] = null;
        tujuantiket = new String[12];
        float hargatiket[];
        hargatiket = new float[8];
        float clockjm[];
        clockjm = new float[8];
        float disktik[];
        disktik = new float[8];
        float dj[];
        dj = new float[8];
        double diskonpembayaran[];
        diskonpembayaran = new double[8];
        int pilih[];
        pilih = new int[8];
        int akhir[];
        akhir = new int[8];
        int admindana[];
        admindana = new int[8];
        x = -1;
        boolean lanjut = true, lewat = true;
        String lapor = "", lagi = "y";
        boolean keluar = true;

        do {
            if (x == 8) {
                JOptionPane.showMessageDialog(null, "DATA SUDAH PENUH");
            } else {
                do {
                    x = x + 1;
                    no_data = no_data + 1;
                    String hasil = "";
                    do {
                        pt = JOptionPane.showInputDialog("Pilih Tiket :"
                                + "\na. TIKET PESAWAT"
                                + "\nb. TIKET KERETA API"
                                + "\nPilih tiket(a/b)");
                    } while (!("a".equals(pt) | "b".equals(pt)));
                    if ("a".equals(pt)) {
                        kettiket = "TIKET PESAWAT";
                    } else if ("b".equals(pt)) {
                        kettiket = "TIKET KERETA API";
                    }

                    namatiket[x] = kettiket;
                    do {
                        pts = JOptionPane.showInputDialog("Pilih tujuan sampai :"
                                + "\na. KOTA SINGAPORE"
                                + "\nb. KOTA JAKARTA"
                                + "\nPilih tujuan(a/b)");
                    } while (!("a".equals(pts) | "b".equals(pts)));
                    if ("a".equals(pts)) {
                        kettujuan = "KOTA SINGAPORE";
                    } else {
                        kettujuan = "KOTA JAKARTA";
                    }
                    tujuantiket[x] = kettujuan;
                    do {
                        try {
                            do {
                                String ht = JOptionPane.showInputDialog("HARGA TIKET");
                                harga = Float.parseFloat(ht);
                                lanjut = false;
                            } while (!(harga >= 100000 & harga <= 1000000));
                        } catch (Exception e) {
                            lanjut = true;
                            JOptionPane.showMessageDialog(null, "ERROR , DATA SALAH INPUT");
                        }
                    } while (lanjut);
                    hargatiket[x] = harga;
                    if (harga <= 500000) {
                        ketds = "GA DAPET DISKON";
                        diskon = 0;
                    } else {
                        ketds = "DAPET DISKON 5%";
                        diskon = 0.05f;
                    }
                    disktik[x] = diskon;
                    do {
                        try {
                            do {
                                String jp = JOptionPane.showInputDialog("JAM PEMBELIAN");
                                jampesan = Float.parseFloat(jp);
                                lewat = false;
                            } while (!(jampesan >= 8 & jampesan <= 24));
                        } catch (Exception e) {
                            lewat = true;
                            JOptionPane.showMessageDialog(null, "ERROR , DATA SALAH INPUT");
                        }
                    } while (lewat);
                    clockjm[x] = jampesan;
                    if (jampesan >= 14) {
                        diskjam = "GA DAPET DISKON TAMBAHAN";
                        diskonjam = 0;
                    } else {
                        diskjam = "DAPET DISKON 2%";
                        diskonjam = 0.02f;
                    }
                    dj[x] = diskonjam;
                    do {
                        String pp = JOptionPane.showInputDialog(" Pilih Pembayaran \n"
                                + "1. Pembayaran via bank BRI/BCA/MANDIRI \n"
                                + "2. Pembayaran via dompet digital DANA/GOPAY/SHOPEEPAY \n"
                                + "3. Pembayaran via cast \n"
                                + "Pilih [1-2]");
                        byr = Integer.parseInt(pp);
                    } while (!(byr >= 1 && byr <= 3));
                    //Percabangan Untuk Pemilihan Tujuan Bus
                    pilih[x] = byr;
                    if (byr == 1) {
                        pb = "PEMBAYARAN VIA BANK BRI/BCA/MANDIRI";
                        diskpem = 0.05;
                        karena = "MENDAPAT DISKON 5% LAGI VIA BANK";
                    } else if (byr == 2) {
                        pb = "PEMBAYARAN VIA DOMPET DIGITAL DANA/GOPAY/SHOPEEPAY";
                        diskpem = 0;
                        karena = "GA DAPET DISKON";
                    } else {
                        pb = "PEMBAYARAN VIA cast";
                        diskpem = 0;
                        karena = "GA DAPET DISKON";
                    }
                    diskonpembayaran[x] = diskpem;
                    totaldiskon = (int) (hargatiket[x] * disktik[x]);
                    totaldiskon2 = (int) (hargatiket[x] * dj[x]);
                    totaldiskon3 = (int) (hargatiket[x] * diskonpembayaran[x]);
                    totaldiskonsemuanya = totaldiskon + totaldiskon2 + totaldiskon3;
                    hargadiskon3 = (int) (hargatiket[x] - totaldiskonsemuanya);
                    akhir[x] = hargadiskon3;
                    hasil += "NO : " + no_data + "\n";
                    hasil += " DATA PEMBELIAN TIKET \n";
                    hasil += " -------------------------------------------------- \n";
                    hasil += " NAMA TIKET = " + namatiket[x] + "\n";
                    hasil += " TEMPAT TUJUAN = " + tujuantiket[x] + "\n";
                    hasil += " HARGA TIKET = " + hargatiket[x] + "\n";
                    hasil += " DISKON PEMBELIAN TIKET = " + ketds + "\n";
                    hasil += " JAM PEMBELIAN = " + clockjm[x] + "\n";
                    hasil += " DISKON JAM PEMBELIAN = " + diskjam + "\n";
                    hasil += " PEMBAYARAN VIA = " + pb + "\n";
                    hasil += " DISKON PEMBAYARAN = " + karena + "\n";
                    hasil += " HARGA SETELAH DISKON = " + akhir[x] + "\n";
                    JOptionPane.showMessageDialog(null, hasil, "DATA PEMBELIAN PELANGGAN", JOptionPane.INFORMATION_MESSAGE);
                    do {
                        lagi = JOptionPane.showInputDialog("INPUT DATA [Y/T] ");
                        if (x == 7) {
                            JOptionPane.showMessageDialog(null, "DATA SUDAH PENUH");
                            lagi = "T";
                        }
                    } while (!(("y".equals(lagi)) | ("Y".equals(lagi)) | ("t".equals(lagi)) | ("T".equals(lagi))));
                } while (("y".equals(lagi)) | ("Y".equals(lagi)));
            }
            keluar = false;
        } while (keluar);
        z = 0;
        harga = 0;
        lapor += "                    HASIL DATA PEMBELIAN TIKET                     \n";
        lapor += " ========================================================================\n";
        lapor += " NO   NAMA PEMBELI      TEMPAT TUJUAN      JUMLAH HARGA       JAM ORDER  \n";
        lapor += " ========================================================================\n";
        for (int y = 0; y <= x; y = y + 1) {
            z = z + 1;
            rumusharga = (int) (harga + akhir[y]);
            lapor += "  " + z + "         " + namatiket[y] + "           " + tujuantiket[y] + "           " + akhir[y] + "           " + clockjm[y] + "\n";
        }
        harga = harga + rumusharga;
        totalbayarnya = (int) (harga + administrasi);
        lapor += " =======================================================================\n";
        lapor += " TOTAL HARGA        = " + harga + " \n";
        lapor += " BIAYA ADMINISTRASI = " + administrasi + " \n";
        lapor += " TOTAL BAYAR        = " + totalbayarnya + "\n";
        lapor += " =======================================================================\n";
        lapor += " karomatulizah 22.240.0089";
        JOptionPane.showMessageDialog(null, lapor, "JUMLAH ITEM DAN HARGA TOTAL", JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }
}
