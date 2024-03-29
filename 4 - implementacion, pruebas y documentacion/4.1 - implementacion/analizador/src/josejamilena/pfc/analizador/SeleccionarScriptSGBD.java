//   Copyright 2009 Jose Antonio Jamilena Daza
//
//   Licensed under the Apache License, Version 2.0 (the "License");
//   you may not use this file except in compliance with the License.
//   You may obtain a copy of the License at
//
//       http://www.apache.org/licenses/LICENSE-2.0
//
//   Unless required by applicable law or agreed to in writing, software
//   distributed under the License is distributed on an "AS IS" BASIS,
//   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
//   See the License for the specific language governing permissions and
//   limitations under the License.

package josejamilena.pfc.analizador;

import java.sql.SQLException;
import java.util.List;
import javax.swing.WindowConstants;
import org.jdesktop.application.Action;
import org.jfree.ui.RefineryUtilities;

public class SeleccionarScriptSGBD extends javax.swing.JDialog {

    private List<String> lista = null;
    private String sscript = "";

    public SeleccionarScriptSGBD(java.awt.Frame parent, List<String> lst, String script) {
        super(parent);
        this.setTitle("Seleccione...");
        lista = lst;
        sscript = script;
        initComponents();
        getRootPane().setDefaultButton(closeButton);
    }

    @Action
    public void closeScriptBox() {
        dispose();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        closeButton = new javax.swing.JButton();
        listaScript = new javax.swing.JComboBox();
        cargarGrafica = new javax.swing.JButton();
        icono = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setName("Form"); // NOI18N

        javax.swing.ActionMap actionMap = org.jdesktop.application.Application.getInstance(josejamilena.pfc.analizador.App.class).getContext().getActionMap(SeleccionarScriptSGBD.class, this);
        closeButton.setAction(actionMap.get("closeScriptBox")); // NOI18N
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(josejamilena.pfc.analizador.App.class).getContext().getResourceMap(SeleccionarScriptSGBD.class);
        closeButton.setText(resourceMap.getString("closeButton.text")); // NOI18N
        closeButton.setName("closeButton"); // NOI18N

        listaScript.setToolTipText(resourceMap.getString("listaScript.toolTipText")); // NOI18N
        listaScript.setName("listaScript"); // NOI18N
        for (String i : lista) {
            this.listaScript.addItem(i);
        }

        cargarGrafica.setAction(actionMap.get("cargarGrafica")); // NOI18N
        cargarGrafica.setText(resourceMap.getString("cargarGrafica.text")); // NOI18N
        cargarGrafica.setToolTipText(resourceMap.getString("cargarGrafica.toolTipText")); // NOI18N
        cargarGrafica.setName("cargarGrafica"); // NOI18N

        icono.setIcon(resourceMap.getIcon("icono.icon")); // NOI18N
        icono.setText(resourceMap.getString("icono.text")); // NOI18N
        icono.setName("icono"); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(icono)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(closeButton, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(listaScript, 0, 186, Short.MAX_VALUE)
                    .addComponent(cargarGrafica, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(icono)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addComponent(listaScript, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cargarGrafica)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(closeButton)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    @Action
    public void cargarGrafica() {
        try {
            GraficoPorScript demo = new GraficoPorScript(sscript, (String) listaScript.getSelectedItem());
            demo.pack();
            RefineryUtilities.centerFrameOnScreen(demo);
            demo.setVisible(true);
            demo.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            dispose();
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cargarGrafica;
    private javax.swing.JButton closeButton;
    private javax.swing.JLabel icono;
    private javax.swing.JComboBox listaScript;
    // End of variables declaration//GEN-END:variables
}
