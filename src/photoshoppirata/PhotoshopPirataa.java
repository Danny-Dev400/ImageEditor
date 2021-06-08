package photoshoppirata;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import photoshoppirata.Imagen;

public class PhotoshopPirataa extends javax.swing.JFrame {

    static int ancho, tamanoFilasX = 0, tamanoFilasY = 0;
    static int alto;
    static int[] rgbCod2;
    static Color[][] rgbOriginal;
    static Color[][] rgbOriginalN;
    static int[][] rgbCodificado,rgbCodificado2,rgbCod;
    public int[][] rgbCodificadoColor;
    static int[][] pruebas;
    static int[][] grises, grises2;
    static int r, g, b, gris, pixel, rn, bn, gn;
    static Color c, n;
    static BufferedImage original;
    static BufferedImage trabajada;
    
    static List listaFilas = new ArrayList();
    static List listaFilasColor = new ArrayList();
    static List listaCeldas;
    static List listaCeldasColor;
    
    static int[] arreglo;
    static int[][] matrizFiltro;
    
    static Imagen img;
    
    public PhotoshopPirataa() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        SliderBrillo = new javax.swing.JSlider();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jSlider2 = new javax.swing.JSlider();
        jScrollPane1 = new javax.swing.JScrollPane();
        lblImagen = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtVal1 = new javax.swing.JTextField();
        txtVal2 = new javax.swing.JTextField();
        txtVal3 = new javax.swing.JTextField();
        txtVal4 = new javax.swing.JTextField();
        txtVal5 = new javax.swing.JTextField();
        txtVal6 = new javax.swing.JTextField();
        txtVal7 = new javax.swing.JTextField();
        txtVal8 = new javax.swing.JTextField();
        txtVal9 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        sliderGamma = new javax.swing.JSlider();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        JMAbrirImagen = new javax.swing.JMenuItem();
        JMAbrirCodificacion = new javax.swing.JMenuItem();
        JMGuardar = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        JMGrices = new javax.swing.JMenuItem();
        JMNegativo = new javax.swing.JMenuItem();
        JMContrasteAuto = new javax.swing.JMenuItem();
        JMEcualizacion = new javax.swing.JMenuItem();
        JMHistograma1 = new javax.swing.JMenuItem();
        JMHistograma2 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        JMPasaBajos = new javax.swing.JMenuItem();
        JMPasaAltos = new javax.swing.JMenuItem();
        JMHBPasaAltos = new javax.swing.JMenuItem();
        JMHBPasaBajos = new javax.swing.JMenuItem();
        JMBinomial = new javax.swing.JMenuItem();
        JMGausiano = new javax.swing.JMenuItem();
        JMPersonalizado = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        JMFiltroMinimo = new javax.swing.JMenuItem();
        JMFiltroMaximo = new javax.swing.JMenuItem();
        JMFiltroModa = new javax.swing.JMenuItem();
        JMFiltroMediana = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        SliderBrillo.setMaximum(255);
        SliderBrillo.setMinimum(-255);
        SliderBrillo.setValue(0);
        SliderBrillo.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                SliderBrilloStateChanged(evt);
            }
        });

        jLabel2.setText("Brillo");

        jLabel3.setText("Contrate");

        jSlider2.setMaximum(10);
        jSlider2.setMinimum(-10);
        jSlider2.setValue(1);
        jSlider2.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSlider2StateChanged(evt);
            }
        });

        jScrollPane1.setViewportView(lblImagen);

        jLabel1.setText("Valores");

        jLabel4.setText("Matriz Personalizada");

        txtVal1.setText("0");

        txtVal2.setText("0");

        txtVal3.setText("0");

        txtVal4.setText("0");

        txtVal5.setText("1");

        txtVal6.setText("0");

        txtVal7.setText("0");

        txtVal8.setText("0");

        txtVal9.setText("0");

        jLabel5.setText("Gamma");

        sliderGamma.setMaximum(200);
        sliderGamma.setMinimum(50);
        sliderGamma.setMinorTickSpacing(10);
        sliderGamma.setPaintLabels(true);
        sliderGamma.setPaintTicks(true);
        sliderGamma.setSnapToTicks(true);
        sliderGamma.setValue(100);
        sliderGamma.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sliderGammaStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1056, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(26, 26, 26))
                                    .addComponent(SliderBrillo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jSlider2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addGap(84, 84, 84))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(44, 44, 44)
                                .addComponent(jLabel4))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(txtVal4, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtVal5, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtVal6, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(txtVal1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtVal2, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtVal3, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(txtVal7, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtVal8, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtVal9, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(91, 91, 91)
                                .addComponent(jLabel2))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(80, 80, 80)
                                .addComponent(jLabel3))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(sliderGamma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addGap(83, 83, 83))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(SliderBrillo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSlider2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sliderGamma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtVal3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtVal1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtVal2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtVal6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtVal4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtVal5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtVal9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtVal7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtVal8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(295, Short.MAX_VALUE))
            .addComponent(jScrollPane1)
        );

        jMenu1.setText("Abrir");

        JMAbrirImagen.setText("Abrir Imagen");
        JMAbrirImagen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMAbrirImagenActionPerformed(evt);
            }
        });
        jMenu1.add(JMAbrirImagen);

        JMAbrirCodificacion.setText("Abrir Codificacion");
        JMAbrirCodificacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMAbrirCodificacionActionPerformed(evt);
            }
        });
        jMenu1.add(JMAbrirCodificacion);

        JMGuardar.setText("Guardar Imagen");
        JMGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMGuardarActionPerformed(evt);
            }
        });
        jMenu1.add(JMGuardar);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Editar");
        jMenu2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu2ActionPerformed(evt);
            }
        });

        JMGrices.setText("Escala de Grices");
        JMGrices.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMGricesActionPerformed(evt);
            }
        });
        jMenu2.add(JMGrices);

        JMNegativo.setText("Negativo");
        JMNegativo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMNegativoActionPerformed(evt);
            }
        });
        jMenu2.add(JMNegativo);

        JMContrasteAuto.setText("Contraste auto");
        JMContrasteAuto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMContrasteAutoActionPerformed(evt);
            }
        });
        jMenu2.add(JMContrasteAuto);

        JMEcualizacion.setText("Ecualizacion");
        JMEcualizacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMEcualizacionActionPerformed(evt);
            }
        });
        jMenu2.add(JMEcualizacion);

        JMHistograma1.setText("Histograma");
        JMHistograma1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMHistograma1ActionPerformed(evt);
            }
        });
        jMenu2.add(JMHistograma1);

        JMHistograma2.setText("Histograma Logaritmico");
        JMHistograma2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMHistograma2ActionPerformed(evt);
            }
        });
        jMenu2.add(JMHistograma2);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Filtros");

        JMPasaBajos.setText("Pasa Bajos");
        JMPasaBajos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMPasaBajosActionPerformed(evt);
            }
        });
        jMenu3.add(JMPasaBajos);

        JMPasaAltos.setText("Pasa Altos");
        JMPasaAltos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMPasaAltosActionPerformed(evt);
            }
        });
        jMenu3.add(JMPasaAltos);

        JMHBPasaAltos.setText("HB con Pasa Altos");
        JMHBPasaAltos.setToolTipText("");
        JMHBPasaAltos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMHBPasaAltosActionPerformed(evt);
            }
        });
        jMenu3.add(JMHBPasaAltos);

        JMHBPasaBajos.setText("HB con Pasa Bajos");
        JMHBPasaBajos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMHBPasaBajosActionPerformed(evt);
            }
        });
        jMenu3.add(JMHBPasaBajos);

        JMBinomial.setText("Binomial");
        JMBinomial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMBinomialActionPerformed(evt);
            }
        });
        jMenu3.add(JMBinomial);

        JMGausiano.setText("Gaussiano");
        JMGausiano.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMGausianoActionPerformed(evt);
            }
        });
        jMenu3.add(JMGausiano);

        JMPersonalizado.setText("Personalizado");
        JMPersonalizado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMPersonalizadoActionPerformed(evt);
            }
        });
        jMenu3.add(JMPersonalizado);

        jMenuBar1.add(jMenu3);

        jMenu4.setText("Filtros no Lineales");

        JMFiltroMinimo.setText("Minimo");
        JMFiltroMinimo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMFiltroMinimoActionPerformed(evt);
            }
        });
        jMenu4.add(JMFiltroMinimo);

        JMFiltroMaximo.setText("Maximo");
        JMFiltroMaximo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMFiltroMaximoActionPerformed(evt);
            }
        });
        jMenu4.add(JMFiltroMaximo);

        JMFiltroModa.setText("Moda");
        JMFiltroModa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMFiltroModaActionPerformed(evt);
            }
        });
        jMenu4.add(JMFiltroModa);

        JMFiltroMediana.setText("Mediana");
        JMFiltroMediana.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMFiltroMedianaActionPerformed(evt);
            }
        });
        jMenu4.add(JMFiltroMediana);

        jMenuBar1.add(jMenu4);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JMAbrirImagenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMAbrirImagenActionPerformed
        // TODO add your handling code here:
        
        JFileChooser seleccion = new JFileChooser();
        seleccion.setDialogTitle("Seleccione una imagen");
        File imagen;
        String ruta;
        if (seleccion.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            imagen = new File(seleccion.getSelectedFile().toString());
            try {
                original = ImageIO.read(imagen);
                img = new Imagen(imagen,original);
                this.lblImagen.setIcon(new ImageIcon(img.getOriginal()));
            } catch (IOException ex) {
                Logger.getLogger(PhotoshopPirataa.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_JMAbrirImagenActionPerformed

    private void jMenu2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu2ActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_jMenu2ActionPerformed

    private void JMGricesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMGricesActionPerformed
        // TODO add your handling code here:
        img.EscalaGrices();
        this.lblImagen.setIcon(new ImageIcon(img.getEditada()));
    }//GEN-LAST:event_JMGricesActionPerformed

    private void JMNegativoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMNegativoActionPerformed
        // TODO add your handling code here:
        img.NegativoIMG();
        this.lblImagen.setIcon(new ImageIcon(img.getEditada()));
    }//GEN-LAST:event_JMNegativoActionPerformed

    private void JMAbrirCodificacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMAbrirCodificacionActionPerformed
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            String ruta = "Codificacion.xlsx";
            Path rutarelativa = Paths.get(ruta);
            Path rutaAbs = rutarelativa.toAbsolutePath();
            System.out.println(rutaAbs.toString());
            File f = new File(rutaAbs.toString());
            ObtenerDatos(f);
            crearImagenCodificada2(30, 25);
        } catch (IOException ex) {
            Logger.getLogger(PhotoshopPirataa.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_JMAbrirCodificacionActionPerformed

    private void JMPasaBajosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMPasaBajosActionPerformed
        // TODO add your handling code here:
        img.filtroPasaBajos();
        this.lblImagen.setIcon(new ImageIcon(img.getEditada()));
    }//GEN-LAST:event_JMPasaBajosActionPerformed

    private void JMPasaAltosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMPasaAltosActionPerformed
        // TODO add your handling code here:
        img.filtroPasaAltos();
        this.lblImagen.setIcon(new ImageIcon(img.getEditada()));
    }//GEN-LAST:event_JMPasaAltosActionPerformed

    private void JMHBPasaAltosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMHBPasaAltosActionPerformed
        // TODO add your handling code here:
        img.filtroHBPasaAltos();
        this.lblImagen.setIcon(new ImageIcon(img.getEditada()));
    }//GEN-LAST:event_JMHBPasaAltosActionPerformed

    private void JMHBPasaBajosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMHBPasaBajosActionPerformed
        // TODO add your handling code here:
        img.filtroHBPasaBajos();
        this.lblImagen.setIcon(new ImageIcon(img.getEditada()));
    }//GEN-LAST:event_JMHBPasaBajosActionPerformed

    private void JMBinomialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMBinomialActionPerformed
        // TODO add your handling code here:
        img.filtroPascal();
        this.lblImagen.setIcon(new ImageIcon(img.getEditada()));
    }//GEN-LAST:event_JMBinomialActionPerformed

    private void JMFiltroMaximoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMFiltroMaximoActionPerformed
        // TODO add your handling code here:
        img.filtroMaximo();
        this.lblImagen.setIcon(new ImageIcon(img.getEditada()));
    }//GEN-LAST:event_JMFiltroMaximoActionPerformed

    private void JMFiltroMinimoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMFiltroMinimoActionPerformed
        // TODO add your handling code here:
        img.filtroMinimo();
        this.lblImagen.setIcon(new ImageIcon(img.getEditada()));
    }//GEN-LAST:event_JMFiltroMinimoActionPerformed

    private void SliderBrilloStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_SliderBrilloStateChanged
        // TODO add your handling code here:
        rgbOriginal = new Color[img.getAncho()][img.getAlto()];
        grises = new int[img.getAncho()][img.getAlto()];
        


        for (int x = 0; x < img.getAncho(); x++) {
            for (int y = 0; y < img.getAlto(); y++) {
                pixel = original.getRGB(x, y);
                c = new Color(pixel);
                rgbOriginal[x][y] = c;
                r = c.getRed();
                g = c.getGreen();
                b = c.getBlue();
                grises[x][y] = (int) ((r * 0.3) + (g * 0.59) + (b * 0.11))+ this.SliderBrillo.getValue();
                if(grises[x][y]<0){
                    grises[x][y]=0;
                }
                if(grises[x][y]>255){
                    grises[x][y]=255;
                }
                //System.out.println(grises[x][y]);
            }
        }
        img.crearImagenGrices(grises);
        this.lblImagen.setIcon(new ImageIcon(img.getEditada()));
    }//GEN-LAST:event_SliderBrilloStateChanged

    private void JMHistograma1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMHistograma1ActionPerformed
        // TODO add your handling code here:
        img.Histograma();
    }//GEN-LAST:event_JMHistograma1ActionPerformed

    private void JMHistograma2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMHistograma2ActionPerformed
        // TODO add your handling code here:
        img.HistogramaLogaritmico();
    }//GEN-LAST:event_JMHistograma2ActionPerformed

    private void jSlider2StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSlider2StateChanged
        // TODO add your handling code here:
        rgbOriginal = new Color[img.getAncho()][img.getAlto()];
        grises = new int[img.getAncho()][img.getAlto()];
        

        for (int x = 0; x < img.getAncho(); x++) {
            for (int y = 0; y < img.getAlto(); y++) {
                pixel = original.getRGB(x, y);
                c = new Color(pixel);
                rgbOriginal[x][y] = c;
                r = c.getRed();
                g = c.getGreen();
                b = c.getBlue();
                grises[x][y] = (int) ((r * 0.3) + (g * 0.59) + (b * 0.11));
                grises[x][y] = (grises[x][y]-img.getPromIntensidad())* this.jSlider2.getValue()+img.getPromIntensidad();
                if(grises[x][y]<0){
                    grises[x][y]=0;
                }
                if(grises[x][y]>255){
                    grises[x][y]=255;
                }
                //System.out.println(grises[x][y]);
            }
        }
        img.crearImagenGrices(grises);
        this.lblImagen.setIcon(new ImageIcon(img.getEditada()));
    }//GEN-LAST:event_jSlider2StateChanged

    private void JMContrasteAutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMContrasteAutoActionPerformed
        // TODO add your handling code here:
        img.ContrasteAuto();
        this.lblImagen.setIcon(new ImageIcon(img.getEditada()));
    }//GEN-LAST:event_JMContrasteAutoActionPerformed

    private void JMEcualizacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMEcualizacionActionPerformed
        // TODO add your handling code here:
        img.Ecualizacion();
        this.lblImagen.setIcon(new ImageIcon(img.getEditada()));
    }//GEN-LAST:event_JMEcualizacionActionPerformed

    private void sliderGammaStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sliderGammaStateChanged
        // TODO add your handling code here:
        rgbOriginal = new Color[img.getAncho()][img.getAlto()];
        grises = new int[img.getAncho()][img.getAlto()];

        for (int x = 0; x < img.getAncho(); x++) {
            for (int y = 0; y < img.getAlto(); y++) {
                pixel = original.getRGB(x, y);
                c = new Color(pixel);
                rgbOriginal[x][y] = c;
                r = c.getRed();
                g = c.getGreen();
                b = c.getBlue();
                grises[x][y] = (int) ((r * 0.3) + (g * 0.59) + (b * 0.11));
                
                int c =1;
                float gama = (this.sliderGamma.getValue()/100f);
                float valGama = (float)Math.pow(grises[x][y], gama);
                
                //System.out.println(gama +" "+valGama);
                
                grises[x][y] = (int)valGama;
                
                if(grises[x][y]<0){
                    grises[x][y]=0;
                }
                if(grises[x][y]>255){
                    grises[x][y]=255;
                }
            }
        }
        //System.out.println(this.sliderGamma.getValue()/100f);
        img.crearImagenGrices(grises);
        this.lblImagen.setIcon(new ImageIcon(img.getEditada()));
    }//GEN-LAST:event_sliderGammaStateChanged

    private void JMPersonalizadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMPersonalizadoActionPerformed
        // TODO add your handling code here:
        obternetMatriz();
        this.lblImagen.setIcon(new ImageIcon(img.getEditada()));
    }//GEN-LAST:event_JMPersonalizadoActionPerformed

    private void JMFiltroMedianaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMFiltroMedianaActionPerformed
        // TODO add your handling code here:
        img.filtroMediana();
        this.lblImagen.setIcon(new ImageIcon(img.getEditada()));
    }//GEN-LAST:event_JMFiltroMedianaActionPerformed

    private void JMFiltroModaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMFiltroModaActionPerformed
        // TODO add your handling code here:
        int[][] pruebaa = {{1,2,3},{6,6,6},{8,8,8}};
        img.filtroModa();
        this.lblImagen.setIcon(new ImageIcon(img.getEditada()));
    }//GEN-LAST:event_JMFiltroModaActionPerformed

    private void JMGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMGuardarActionPerformed
        // TODO add your handling code here:
        JFileChooser guardar = new JFileChooser();
        guardar.setApproveButtonText("Guardar");
        guardar.showSaveDialog(null);
        File ImgGuardar=new File(guardar.getSelectedFile()+".png");
        try {
            ImageIO.write(img.getEditada(), "png", ImgGuardar);
        } catch (IOException ex) {
            Logger.getLogger(PhotoshopPirataa.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_JMGuardarActionPerformed

    private void JMGausianoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMGausianoActionPerformed
        // TODO add your handling code here:
        /*int[][] prueba = {{20,30,20},{20,10,10},{5,5,5}};
        int as = img.calcularGrisGaus(prueba, 10);
        System.out.println(as);*/
        img.FiltroGaus();
        this.lblImagen.setIcon(new ImageIcon(img.getEditada()));
    }//GEN-LAST:event_JMGausianoActionPerformed
    
    public void obternetMatriz(){
        float val1= Float.parseFloat(this.txtVal1.getText());
        float val2= Float.parseFloat(this.txtVal2.getText());
        float val3= Float.parseFloat(this.txtVal3.getText());
        float val4= Float.parseFloat(this.txtVal4.getText());
        float val5= Float.parseFloat(this.txtVal5.getText());
        float val6= Float.parseFloat(this.txtVal6.getText());
        float val7= Float.parseFloat(this.txtVal7.getText());
        float val8= Float.parseFloat(this.txtVal8.getText());
        float val9= Float.parseFloat(this.txtVal9.getText());
        
        float[][] matrizPersonalizada = {{val1,val2,val3},
                                         {val4,val5,val6},
                                         {val7,val8,val9}};
        
        float suma=0;
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                suma += matrizPersonalizada[i][j];
            }
        }
        img.FiltroPersonalizado(matrizPersonalizada, 1);
        suma=0;
        
    }
    
    public void crearImagenCodificada2(int anchoPixel, int altoPixel){
        int anchoCod = listaCeldas.size() * anchoPixel;
        int altoCod = listaFilas.size() * altoPixel;
        rgbCodificadoColor= new int[anchoCod][altoCod];
        Color cod;

        for (int i = 0; i < listaCeldas.size(); i++) {
            for (int j = 0; j < listaFilas.size(); j++) {
                for (int m = anchoPixel * i; m < anchoPixel * (i + 1); m++) {
                    for (int n = altoPixel * j; n < altoPixel * (j + 1); n++) {
                        rgbCodificadoColor[m][n] = rgbCod2[(rgbCodificado[i][j])-1];
                    }
                }
            }
        }
        
        trabajada = new BufferedImage(anchoCod, altoCod,5);
        
        for(int k=0;k<anchoCod;k++){
            for(int q=0;q<altoCod;q++){
                //System.out.print(rgbCodificadoColor[k][q]);
                int newrgb = rgbCodificadoColor[k][q] | rgbCodificadoColor[k][q] | rgbCodificadoColor[k][q];
                trabajada.setRGB(k, q, new Color(newrgb).getRGB());
            }
            //System.out.println();
        }
        lblImagen.setIcon(new ImageIcon(trabajada));
    }
    
    public void ObtenerDatos(File archivo) throws IOException {
        try {
            FileInputStream entrada = new FileInputStream(archivo);
            XSSFWorkbook libro = new XSSFWorkbook(entrada);
            
            XSSFSheet hoja1 = libro.getSheetAt(0);
            XSSFSheet hoja2 = libro.getSheetAt(1);
            
            Iterator iteradorFilas = hoja1.rowIterator();
            Iterator iteradorFilash2 = hoja2.rowIterator();
            
            while (iteradorFilas.hasNext()) {
                XSSFRow fila = (XSSFRow) iteradorFilas.next();
                Iterator iteradorCeldas = fila.cellIterator();
                listaCeldas = new ArrayList();
                while (iteradorCeldas.hasNext()) {
                    XSSFCell celda = (XSSFCell) iteradorCeldas.next();
                    listaCeldas.add(celda);
                }
                listaFilas.add(listaCeldas);
            }
            
            while (iteradorFilash2.hasNext()) {
                XSSFRow filaColor = (XSSFRow) iteradorFilash2.next();
                Iterator iteradorCeldasColor = filaColor.cellIterator();
                listaCeldasColor = new ArrayList();
                while (iteradorCeldasColor.hasNext()) {
                    XSSFCell celdaColor = (XSSFCell) iteradorCeldasColor.next();
                    listaCeldasColor.add(celdaColor);
                }
                listaFilasColor.add(listaCeldasColor);
            }
        } catch (IOException e) {
        }
        mostrarDatos();
    }
    
    public void mostrarDatos() {

        rgbCodificado = new int[listaCeldas.size()][listaFilas.size()];
        rgbCod = new int[listaCeldasColor.size()][listaFilasColor.size()];
        
        for (int i = 0; i < listaFilas.size(); i++) {
            List celdaTemp = (List) listaFilas.get(i);
            for (int j = 0; j < listaCeldas.size(); j++) {
                XSSFCell celdaObtenida = (XSSFCell) celdaTemp.get(j);
                String mostrar = celdaObtenida.toString();
                double aux = Double.parseDouble(mostrar);
                rgbCodificado[j][i] = (int) aux;
                //System.out.print(" "+rgbCodificado[j][i]+" ");
            }
            //System.out.println();
        }
        
        for (int i = 0; i < listaFilasColor.size(); i++) {
            List celdaTemp2 = (List) listaFilasColor.get(i);
            for (int j = 0; j < listaCeldasColor.size(); j++) {
                XSSFCell celdaObtenidaColor = (XSSFCell) celdaTemp2.get(j);
                String mostrar = celdaObtenidaColor.toString();
                double aux = Double.parseDouble(mostrar);
                rgbCod[j][i] = (int) aux;
                //System.out.print(" "+rgbCod[j][i]+" ");
            }
            //System.out.println();
        }
        
        Color colorArreglo;
        rgbCod2= new int[listaFilasColor.size()];
        for(int i=0;i<listaFilasColor.size();i++){
            colorArreglo=new Color(rgbCod[0][i],rgbCod[1][i],rgbCod[2][i]);
            rgbCod2[i]=colorArreglo.getRGB();
            //System.out.println(rgbCod[0][i]+" "+rgbCod[1][i]+" "+rgbCod[2][i]);
        }
        
        System.out.println(listaCeldasColor.size());

    }

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
            java.util.logging.Logger.getLogger(PhotoshopPirataa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PhotoshopPirataa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PhotoshopPirataa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PhotoshopPirataa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PhotoshopPirataa().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem JMAbrirCodificacion;
    private javax.swing.JMenuItem JMAbrirImagen;
    private javax.swing.JMenuItem JMBinomial;
    private javax.swing.JMenuItem JMContrasteAuto;
    private javax.swing.JMenuItem JMEcualizacion;
    private javax.swing.JMenuItem JMFiltroMaximo;
    private javax.swing.JMenuItem JMFiltroMediana;
    private javax.swing.JMenuItem JMFiltroMinimo;
    private javax.swing.JMenuItem JMFiltroModa;
    private javax.swing.JMenuItem JMGausiano;
    private javax.swing.JMenuItem JMGrices;
    private javax.swing.JMenuItem JMGuardar;
    private javax.swing.JMenuItem JMHBPasaAltos;
    private javax.swing.JMenuItem JMHBPasaBajos;
    private javax.swing.JMenuItem JMHistograma1;
    private javax.swing.JMenuItem JMHistograma2;
    private javax.swing.JMenuItem JMNegativo;
    private javax.swing.JMenuItem JMPasaAltos;
    private javax.swing.JMenuItem JMPasaBajos;
    private javax.swing.JMenuItem JMPersonalizado;
    public javax.swing.JSlider SliderBrillo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JSlider jSlider2;
    private javax.swing.JTextField jTextField1;
    public javax.swing.JLabel lblImagen;
    private javax.swing.JSlider sliderGamma;
    private javax.swing.JTextField txtVal1;
    private javax.swing.JTextField txtVal2;
    private javax.swing.JTextField txtVal3;
    private javax.swing.JTextField txtVal4;
    private javax.swing.JTextField txtVal5;
    private javax.swing.JTextField txtVal6;
    private javax.swing.JTextField txtVal7;
    private javax.swing.JTextField txtVal8;
    private javax.swing.JTextField txtVal9;
    // End of variables declaration//GEN-END:variables
}
