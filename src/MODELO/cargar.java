/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package MODELO;

import javax.swing.JProgressBar;

/**
 *
 * @author JHON SANCHEZ YEISON NORIEGA ADSI 600128
 */
public class cargar extends Thread {
	JProgressBar progreso;

	public cargar(JProgressBar progreso) {
		super();
		this.progreso = progreso;
	}

	@Override
	public void run() {
		for (int i = 1; i <= 100; i++) {
			progreso.setValue(i);
			// pausa(13);
		}
	}

	public void pausa(int mlSeg) {
		try {
			Thread.sleep(mlSeg);
		} catch (Exception e) {

		}
	}
}
