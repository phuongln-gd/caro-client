/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;

/**
 *
 * @author FunG
 */
public class XOButton extends JButton {

    private ImageIcon X;
    private ImageIcon O;
    public Point point;
    public static boolean isXMove = true;
    public int value = 0;

    public XOButton(int x, int y) {
        X = new ImageIcon("assets/image/x3.jpg");
        O = new ImageIcon("assets/image/o3.jpg");
        setHorizontalAlignment(SwingConstants.CENTER);
        setVerticalAlignment(SwingConstants.CENTER);
        this.setIcon(new ImageIcon("assets/image/blank.jpg"));
        this.point = new Point(x, y);
        XOButton _this = this;
        this.addMouseListener(new MouseListener() {

            @Override
            public void mouseReleased(MouseEvent e) {
                // TODO Auto-generated method stub
            }

            @Override
            public void mousePressed(MouseEvent e) {
                // TODO Auto-generated method stub

            }
            // khi nhac chuot ra khoi o
            @Override
            public void mouseExited(MouseEvent e) {
                if (_this.isEnabled()) {
                    _this.setBackground(null);
                    _this.setIcon(new ImageIcon("assets/image/blank.jpg"));
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                if (_this.isEnabled()) {
                    _this.setBackground(Color.GREEN);
                    _this.setIcon(new ImageIcon("assets/image/x3.jpg"));
                }
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                // TODO Auto-generated method stub
            }
        });
    }

    // kiem tra trang thai X hoac O
    public void setState(Boolean isXMove) {
        if (isXMove) {
            // trang thai X
            setIcon(X);
            value = 2;
            XOButton.isXMove = false;
            this.setDisabledIcon(X);
        } else {
            //trang thai O
            setIcon(O);
            value = 1;
            XOButton.isXMove = true;
            this.setDisabledIcon(O);
        }
    }

    public void resetState() {
        value = 0;
        this.setEnabled(true);
        this.setIcon(new ImageIcon("assets/image/blank.jpg"));
        this.setDisabledIcon(new ImageIcon("assets/image/blank.jpg"));
    }
}
