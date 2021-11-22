/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.GUI;

import bookstore.BLL.CTPNBLL;
import bookstore.BLL.NhaXuatBanBLL;
import bookstore.BLL.PhieuNhapBLL;
import bookstore.BLL.SachBLL;
import bookstore.Entity.CTPN;
import bookstore.Entity.NhaXuatBan;
import bookstore.Entity.PhieuNhap;
import bookstore.Entity.Sach;
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.table.TableModel;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

/**
 *
 * @author HieuNguyen
 */
public class jdNhap extends javax.swing.JDialog {

    frmQLNhap obj = new frmQLNhap();
    private PhieuNhapBLL objpn = new PhieuNhapBLL();
    private CTPNBLL objctpn = new CTPNBLL();
    NhaXuatBanBLL objnxb = new NhaXuatBanBLL();
    ArrayList<NhaXuatBan> lstnxb = new ArrayList<>();
    SachBLL objs = new SachBLL();
    ArrayList<Sach> lsts = new ArrayList<>();
    ArrayList<CTPN> lstCTPN = new ArrayList<>();
    ArrayList<String> lstMaSach = new ArrayList<>();
    boolean isEdit = false;

    /**
     * Creates new form jdNhap
     */
    public jdNhap(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setIconImage(new ImageIcon(getClass().getResource("imgs/library.png")).getImage());
        spnDonGia.setValue(1);
        spnSoLuong.setValue(1);
        binCmbNXB();
        binCmbSach();
        getDate();
    }

    public jdNhap(java.awt.Frame parent, boolean modal, boolean _isEdit) {
        super(parent, modal);
        isEdit = _isEdit;
        setIconImage(new ImageIcon(getClass().getResource("imgs/library.png")).getImage());
        initComponents();
        setDefaultCloseOperation(HIDE_ON_CLOSE);

        btnXacNhan.setText("Sửa Phiếu Nhập");
        lstCTPN.clear();
        for (CTPN i : obj.lstEditctpn) {
            lstCTPN.add(i);
        }
        for (CTPN i : lstCTPN) {
            lstMaSach.add(i.getMaSach());
        }
//        btnXacNhan.setText("Sửa Phiếu Nhập");
        spnDonGia.setValue(1);
        spnSoLuong.setValue(1);
        binCmbNXB();
        binCmbSach();
        getDate();
        lstnxb = objnxb.getAll("", "", "");
        for (NhaXuatBan in : lstnxb) {
            if (in.getMaNXB().equals(obj.idNXB)) {
                obj.idNXB = in.getTenNXB();
                break;
            }
        }
//        for (CTPN i : obj.lstEditctpn) {
//            System.out.println("f_old: " + i.getMaSach());
//        }
        cmbNXB.setSelectedItem(obj.idNXB);
        binData(lstCTPN);
    }

    void getDate() {
        Timer timer = new Timer(500, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                binDate();
            }
        });
        timer.setRepeats(true);
        timer.setCoalesce(true);
        timer.setInitialDelay(0);
        timer.start();
    }

    void binDate() {
        lbLich.setText(DateFormat.getDateTimeInstance().format(new java.util.Date()));
    }

    void binCmbSach() {
        cmbSach.removeAllItems();
        lsts = objs.getAll("", "", "");
        for (Sach i : lsts) {
            cmbSach.addItem(i.getTieuDe());
        }
        cmbSach.setSelectedIndex(-1);
    }

    void binCmbNXB() {
        cmbNXB.removeAllItems();
        lstnxb = objnxb.getAll("", "", "");
        for (NhaXuatBan i : lstnxb) {
            cmbNXB.addItem(i.getTenNXB());
        }
        cmbNXB.setSelectedIndex(-1);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel5 = new javax.swing.JLabel();
        cmbNXB = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbView = new javax.swing.JTable();
        lbLich = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btnThem = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        cmbSach = new javax.swing.JComboBox<>();
        spnSoLuong = new javax.swing.JSpinner();
        jLabel2 = new javax.swing.JLabel();
        spnDonGia = new javax.swing.JSpinner();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnXoa = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnLamLai = new javax.swing.JButton();
        btnSelect = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        btnXacNhan = new javax.swing.JButton();
        btnHuy = new javax.swing.JButton();
        btnXoaAll = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Nhà Xuất Bản");

        cmbNXB.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cmbNXB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        tbView.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbView.setToolTipText("Quản Lý Phiếu Nhập");
        tbView.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbViewMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbView);

        lbLich.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        lbLich.setText("Ngày");

        jPanel1.setBackground(new java.awt.Color(204, 255, 204));

        btnThem.setText("Thêm");
        btnThem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnThemMouseClicked(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Tên Sách");

        cmbSach.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cmbSach.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        spnSoLuong.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        spnSoLuong.setMinimumSize(new java.awt.Dimension(1, 1));
        spnSoLuong.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                spnSoLuongFocusGained(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Số lượng");

        spnDonGia.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Đơn giá");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("VND/ cuốn");

        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnLamLai.setText("Làm Lại");
        btnLamLai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLamLaiActionPerformed(evt);
            }
        });

        btnSelect.setText("Xóa Tất Cả");
        btnSelect.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnSelectMousePressed(evt);
            }
        });
        btnSelect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelectActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(cmbSach, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSelect, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(spnSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(spnDonGia, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4))
                    .addComponent(jLabel3))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(btnThem)
                .addGap(50, 50, 50)
                .addComponent(btnSua)
                .addGap(48, 48, 48)
                .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51)
                .addComponent(btnLamLai, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnLamLai, btnSua, btnThem, btnXoa});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cmbSach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSelect)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(spnSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(spnDonGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThem)
                    .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSua)
                    .addComponent(btnLamLai, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnLamLai, btnSua, btnThem, btnXoa});

        jPanel2.setBackground(new java.awt.Color(204, 204, 255));

        btnXacNhan.setText("Thêm Phiếu Nhập");
        btnXacNhan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXacNhanActionPerformed(evt);
            }
        });

        btnHuy.setText("Hủy Bỏ");
        btnHuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyActionPerformed(evt);
            }
        });

        btnXoaAll.setText("Xóa Tất Cả");
        btnXoaAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaAllActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(0, 14, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnXacNhan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnXoaAll, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnHuy, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnXoaAll, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(btnXacNhan, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnHuy, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbNXB, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbLich)
                .addGap(38, 38, 38))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cmbNXB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbLich))
                .addGap(1, 1, 1)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbViewMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbViewMouseClicked
        // TODO add your handling code here:
        if (tbView.getSelectedRow() == -1) {
            return;
        }
        //        lsts = objs.getAll("", "", "");
        String item = tbView.getValueAt(tbView.getSelectedRow(), 0).toString();
        for (Sach i : lsts) {
            if (item.equals(i.getMaSach())) {
                item = i.getTieuDe();
                break;
            }
        }
        cmbSach.setSelectedItem(item);
        spnDonGia.setValue(Integer.parseInt(tbView.getValueAt(tbView.getSelectedRow(), 2).toString()));
        spnSoLuong.setValue(Integer.parseInt(tbView.getValueAt(tbView.getSelectedRow(), 1).toString()));
    }//GEN-LAST:event_tbViewMouseClicked

    private void btnThemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnThemMouseClicked
        // TODO add your handling code here:

        lsts = objs.getAll("", "", "");
        CTPN data = new CTPN();
        //        System.out.println(lsts.get(cmbSach.getSelectedIndex()).getMaSach());
        try {
            data.setMaSach(lsts.get(cmbSach.getSelectedIndex()).getMaSach());
            for (String i : lstMaSach) {
                if (i.equals(data.getMaSach())) {
                    JOptionPane.showMessageDialog(this, "Sách bạn chọn đã có!");
                    clearText();
                    return;
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Hãy lựa chọn sách!");
            clearText();
            return;
        }
        data.setSoLuong((int) spnSoLuong.getValue());
        if (data.getSoLuong() < 1) {
            JOptionPane.showMessageDialog(this, "Số lượng không hợp lệ!");
            spnSoLuong.setValue(1);
            return;
        }
        data.setDonGia((int) spnDonGia.getValue());
        if (data.getDonGia() < 1) {
            JOptionPane.showMessageDialog(this, "Đơn giá không hợp lệ!");
            spnDonGia.setValue(1);
            return;
        }
        data.setThanhTien(data.getDonGia() * data.getSoLuong());
        lstMaSach.add(data.getMaSach());
        lstCTPN.add(data);
        //        System.out.println(lstCTPN.size() + " " + lstMaSach.size());
        binData(lstCTPN);
        clearText();
    }//GEN-LAST:event_btnThemMouseClicked

    private void spnSoLuongFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_spnSoLuongFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_spnSoLuongFocusGained

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        // TODO add your handling code here:
        int i = tbView.getSelectedRow();
        if (i < 0) {
            JOptionPane.showMessageDialog(this, "Chọn bản ghi cần xóa trước!");
            return;
        }
        String s = tbView.getValueAt(i, 0).toString();
        for (int x = 0; x < lstCTPN.size(); x++) {
            if (lstCTPN.get(x).getMaSach().equals(s)) {
                lstCTPN.remove(x);
                break;
            }
        }
        for (int x = 0; x < lstMaSach.size(); x++) {
            if (lstMaSach.get(x).equals(s)) {
                lstMaSach.remove(x);
                break;
            }
        }
        //        System.out.println(lstCTPN.size() + " " + lstMaSach.size());
        binData(lstCTPN);
        clearText();
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        // TODO add your handling code here:
        int i = tbView.getSelectedRow();
        if (i < 0) {
            JOptionPane.showMessageDialog(this, "Chọn bản ghi cần sửa trước!");
            return;
        }
        lsts = objs.getAll("", "", "");
        try {
            lstCTPN.get(i).setMaSach(lsts.get(cmbSach.getSelectedIndex()).getMaSach());
        } catch (Exception e) {
            e.printStackTrace();
        }
        lstMaSach.remove(tbView.getValueAt(i, 0).toString());
        for (String in : lstMaSach) {
            if (in.equals(lstCTPN.get(i).getMaSach())) {
                JOptionPane.showMessageDialog(this, "Mã sách này đã tồn tại!");
                return;
            }
        }
        lstMaSach.add(lstCTPN.get(i).getMaSach());
        lstCTPN.get(i).setSoLuong((int) spnSoLuong.getValue());
        if (lstCTPN.get(i).getSoLuong() < 1) {
            JOptionPane.showMessageDialog(this, "Số lượng không hợp lệ!");
            spnSoLuong.setValue(1);
            return;
        }
        lstCTPN.get(i).setDonGia((int) spnDonGia.getValue());
        if (lstCTPN.get(i).getDonGia() < 1) {
            JOptionPane.showMessageDialog(this, "Đơn giá không hợp lệ!");
            spnDonGia.setValue(1);
            return;
        }
        lstCTPN.get(i).setThanhTien(lstCTPN.get(i).getDonGia() * lstCTPN.get(i).getSoLuong());
        binData(lstCTPN);
        clearText();
    }//GEN-LAST:event_btnSuaActionPerformed

    void binData(ArrayList<CTPN> lst) {
//        lst = nxbdll.getAll(t,w,o);
        Vector col = new Vector();
        col.add("Mã Sách");
        col.add("Số Lượng");
        col.add("Đơn Giá");
        col.add("Thành Tiền");

        Vector data = new Vector();
        for (CTPN i : lst) {
            Vector row = new Vector();
            row.add(i.getMaSach());
            row.add(i.getSoLuong());
            row.add(i.getDonGia());
            row.add(i.getThanhTien());
            data.add(row);
        }
        DefaultTableModel dtm = new DefaultTableModel(data, col);
        tbView.setModel(dtm);
    }

    void clearText() {
        cmbSach.setSelectedIndex(-1);
        spnDonGia.setValue(1);
        spnSoLuong.setValue(1);
        cmbSach.requestFocus();
    }

    private void btnLamLaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamLaiActionPerformed
        // TODO add your handling code here:
        clearText();
    }//GEN-LAST:event_btnLamLaiActionPerformed

    private void btnSelectMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSelectMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSelectMousePressed

    private void btnSelectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelectActionPerformed
        // TODO add your handling code here:
        new jdSachSelect(this, true).setVisible(true);
        cmbSach.setSelectedItem(jdSachSelect.idSach);
    }//GEN-LAST:event_btnSelectActionPerformed

    private void btnXacNhanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXacNhanActionPerformed
        // TODO add your handling code here:
        if (lstCTPN.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Hóa đơn trống!");
            return;
        } else if (cmbNXB.getSelectedIndex() < 0) {
            JOptionPane.showMessageDialog(this, "Hãy lựa chọn nhà xuất bản!");
            cmbNXB.requestFocus();
            return;
        } else if (isEdit) {
            PhieuNhap dt = new PhieuNhap();
            dt.setMaNXB(lstnxb.get(cmbNXB.getSelectedIndex()).getMaNXB());
            String maPN = obj.lstEditctpn.get(0).getMaPhieuNhap();
            dt.setMaPhieuNhap(maPN);
            int thanhTien = 0;
            for (CTPN i : lstCTPN) {
                thanhTien += i.getThanhTien();
            }
            dt.setThanhTien(thanhTien);
            if (JOptionPane.showConfirmDialog(this, "Sửa phiếu nhập này?", "Thông báo!!!", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                if (objpn.updateData(dt)) {
                    for (CTPN x : lstCTPN) {
                        boolean check = true;
                        x.setMaPhieuNhap(maPN);
                        for (CTPN y : obj.lstEditctpn) {
                            if (x.getMaSach().equals(y.getMaSach())) {
                                check = false;
                                x.setMaCTPN(y.getMaCTPN());
//                                System.out.println(x.getMaCTPN() + " " + x.getMaPhieuNhap() + " " + x.getMaSach() + " " + x.getSoLuong() + " " + x.getDonGia() + " " + x.getThanhTien());
                                objctpn.updateData(x);
                                obj.lstEditctpn.remove(y);
                                break;
                            }
                        }
//                        System.out.println(check);
                        if (check) {
                            //                        System.out.println(obj.getIDCTPN());
                            x.setMaCTPN(obj.getIDCTPN());
                            objctpn.insertData(x);
                        }
                    }
                    for (CTPN y : obj.lstEditctpn) {
                        String id = y.getMaCTPN();
//                        System.out.println("del: " + y.getMaSach());
                        objctpn.deleteData_CTPN(id);
                    }
                    JOptionPane.showMessageDialog(this, "Sửa phiếu nhập thành công!");
                } else {
                    JOptionPane.showMessageDialog(this, "Sửa phiếu nhập thất bại!");
                }
            }

        } else {
            PhieuNhap data = new PhieuNhap();
            String idPN = obj.getIDPN();
            data.setMaPhieuNhap(idPN);
            data.setMaNXB(lstnxb.get(cmbNXB.getSelectedIndex()).getMaNXB());
            //            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy");
            LocalDate now = LocalDate.now();
            data.setNgayNhap(Date.valueOf(now));
            int thanhTien = 0;
            for (CTPN i : lstCTPN) {
                thanhTien += i.getThanhTien();
            }
            data.setThanhTien(thanhTien);
            if (JOptionPane.showConfirmDialog(this, "Tạo phiếu nhập này?", "Thông báo!!!", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                if (objpn.insertData(data)) {
                    for (CTPN i : lstCTPN) {
                        //                    System.out.println(obj.getIDCTPN());
                        i.setMaCTPN(obj.getIDCTPN());
                        i.setMaPhieuNhap(idPN);
                        objctpn.insertData(i);
                    }

                    JOptionPane.showMessageDialog(this, "Tạo phiếu nhập thành công!");
                    int dialogResult = JOptionPane.showConfirmDialog(this, "Bạn muốn in hóa đơn?", "Thông báo", JOptionPane.YES_NO_OPTION);
                    if (dialogResult == JOptionPane.YES_OPTION) {
                        JFileChooser fc = new JFileChooser();
                        int option = fc.showSaveDialog(this);
                        if (option == JFileChooser.APPROVE_OPTION) {
                            String filename = fc.getSelectedFile().getName();
                            String path = fc.getSelectedFile().getParentFile().getPath();
                            int len = filename.length();
                            String ext = "";
                            String file = "";

                            if (len > 4) {
                                ext = filename.substring(len - 4, len);
                            }

                            if (ext.equals(".xls")) {
                                file = path + "\\" + filename;
                            } else {
                                file = path + "\\" + filename + ".xls";
                            }
                            try {
                                toExcel(data, tbView, new File(file));
                                if (JOptionPane.showConfirmDialog(this, "Mở file?", "Xuất file thành công!!!", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                                    File f = new File(file);
                                    try {
                                        Desktop.getDesktop().open(f);
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    }
                                }
                            } catch (IOException ex) {
                                Logger.getLogger(frmSach.class.getName()).log(Level.SEVERE, null, ex);
                                JOptionPane.showMessageDialog(this, "Xuất file không thành công!");
                            }
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Tạo phiếu nhập thất bại!");
                }
            }
        }
        this.setVisible(false);
    }//GEN-LAST:event_btnXacNhanActionPerformed

    public static void toExcel(PhieuNhap px, JTable table, File file) throws IOException {
        String sheetName = "Sheet1";//name of sheet
        HSSFWorkbook wb = new HSSFWorkbook();
        HSSFSheet sheet = wb.createSheet(sheetName);
        TableModel model = table.getModel();
        HSSFRow row = sheet.createRow(0);
        HSSFCell cell = row.createCell(0);
        cell.setCellValue("Mã Phiếu Nhập");
        cell = row.createCell(1);
        cell.setCellValue(px.getMaPhieuNhap());
        cell = row.createCell(3);
        cell.setCellValue("Ngày nhập");
        cell = row.createCell(4);
        cell.setCellValue(px.getNgayNhap().toString());
        row = sheet.createRow(1);
        cell = row.createCell(0);
        cell.setCellValue("Nhà Xuất Bản");
        cell = row.createCell(1);
        cell.setCellValue(px.getMaNXB());

//        Get col name
        row = sheet.createRow(3);
        cell = row.createCell(0);
        cell.setCellValue("STT");
        for (int i = 0; i < model.getColumnCount(); i++) {
            cell = row.createCell(i + 1);
            cell.setCellValue(model.getColumnName(i).toString());
        }
//        iterating r number of rows
        for (int r = 0; r < model.getRowCount(); r++) {
            row = sheet.createRow(r + 4);
            cell = row.createCell(0);
            cell.setCellValue(r + 1);
            //iterating c number of columns
            for (int c = 0; c < model.getColumnCount(); c++) {
                cell = row.createCell(c + 1);
                cell.setCellValue(model.getValueAt(r, c).toString());
            }
        }
        row = sheet.createRow(model.getRowCount() + 4);
        cell = row.createCell(model.getColumnCount() - 1);
        cell.setCellValue("Tổng tiền");
        cell = row.createCell(model.getColumnCount());
        cell.setCellValue(px.getThanhTien());

        FileOutputStream fileOut = new FileOutputStream(file);

        //write this workbook to an Outputstream.
        wb.write(fileOut);
        fileOut.flush();
        fileOut.close();
    }

    private void btnHuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyActionPerformed
        // TODO add your handling code here:
        if (JOptionPane.showConfirmDialog(this, "Bạn muốn hủy thao tác?", "Thông báo!!!", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            this.setVisible(false);
        }
    }//GEN-LAST:event_btnHuyActionPerformed

    private void btnXoaAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaAllActionPerformed
        // TODO add your handling code here:
        lstCTPN.removeAll(lstCTPN);
        lstMaSach.removeAll(lstMaSach);
        binData(lstCTPN);
    }//GEN-LAST:event_btnXoaAllActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(jdNhap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(jdNhap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(jdNhap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(jdNhap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                jdNhap dialog = new jdNhap(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHuy;
    private javax.swing.JButton btnLamLai;
    private javax.swing.JButton btnSelect;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXacNhan;
    private javax.swing.JButton btnXoa;
    private javax.swing.JButton btnXoaAll;
    private javax.swing.JComboBox<String> cmbNXB;
    private javax.swing.JComboBox<String> cmbSach;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbLich;
    private javax.swing.JSpinner spnDonGia;
    private javax.swing.JSpinner spnSoLuong;
    private javax.swing.JTable tbView;
    // End of variables declaration//GEN-END:variables
}