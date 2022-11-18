package vistas;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.github.lgooddatepicker.components.DateTimePicker;

import javax.swing.SwingConstants;
import java.awt.GridLayout;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class AgendarInstalacionDialog extends JDialog {
	
	
	
	private DateTimePicker dateTimePicker = new DateTimePicker();
	
	
	/**
	 * Create the dialog.
	 */
	public AgendarInstalacionDialog() {
		setTitle("Agendar Instalacion");
		setBounds(100, 100, 605, 341);
		getContentPane().setLayout(new BorderLayout());
		{
			JPanel panelPrincipal = new JPanel();
			getContentPane().add(panelPrincipal, BorderLayout.CENTER);
			panelPrincipal.setLayout(new BorderLayout(0, 0));
			{
				JPanel buttonPane = new JPanel();
				panelPrincipal.add(buttonPane, BorderLayout.SOUTH);
				buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER));
				{
					JButton okButton = new JButton("OK");
					okButton.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							Calendar  fechaSeleccionadaCalendar = new GregorianCalendar();
							LocalDate fechaSeleccionadaUsuario = dateTimePicker.getDatePicker().getDate();
							LocalTime horaSeleccionadaUsuario = dateTimePicker.getTimePicker().getTime();
							fechaSeleccionadaCalendar.set(fechaSeleccionadaUsuario.getYear(), fechaSeleccionadaUsuario.getMonthValue() - 1, 
									fechaSeleccionadaUsuario.getDayOfMonth(), horaSeleccionadaUsuario.getHour() , horaSeleccionadaUsuario.getMinute(), 0);
							System.out.println(fechaSeleccionadaCalendar.getTime());
						}
					});
					okButton.setActionCommand("OK");
					buttonPane.add(okButton);
				}
				{
					JButton cancelButton = new JButton("Cancel");
					cancelButton.setActionCommand("Cancel");
					buttonPane.add(cancelButton);
				}
			}
			{
				JPanel panelCentral = new JPanel();
				panelPrincipal.add(panelCentral, BorderLayout.CENTER);
				panelCentral.setLayout(new GridLayout(2, 2, 0, 0));
				{
					JLabel clienteLabel = new JLabel("Cliente");
					clienteLabel.setHorizontalAlignment(SwingConstants.CENTER);
					clienteLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
					panelCentral.add(clienteLabel);
				}
				{
					JComboBox clientesComboBox = new JComboBox();
					panelCentral.add(clientesComboBox);
				}
				{
					JLabel fechaLabel = new JLabel("Fecha");
					fechaLabel.setHorizontalAlignment(SwingConstants.CENTER);
					fechaLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
					panelCentral.add(fechaLabel);
				}
				{
					JPanel panel = new JPanel();
					panelCentral.add(panel);
					panel.setLayout(new BorderLayout(0, 0));
					{
						this.dateTimePicker = new DateTimePicker();
						panel.add(dateTimePicker);
						dateTimePicker.getDatePicker().setDateToToday();
						dateTimePicker.getTimePicker().setTimeToNow();
					}
				}
			}
		}
	}

}
