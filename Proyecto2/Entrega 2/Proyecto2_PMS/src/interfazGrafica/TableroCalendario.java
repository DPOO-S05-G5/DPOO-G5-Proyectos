package interfazGrafica;

import java.time.LocalDate;
import java.time.temporal.TemporalField;
import java.time.temporal.WeekFields;
import java.util.Locale;

import modelo.CoordinadorPMS;

public class TableroCalendario 
{
    private int[][] tablero;

    CoordinadorPMS coordinadorPMS;
    public TableroCalendario(CoordinadorPMS coordinadorPMS) 
    {
        this.coordinadorPMS = coordinadorPMS;
        tablero = new int[7][52];

        for(int i = 0; i < 7; i++)
        {
            for(int j = 0; j < 52; j++)
            {
                tablero[i][j] = 0;
            }
        }

        llenarTablero();
    }

    private void llenarTablero()
    {
        LocalDate fechaInicial = LocalDate.now();
        LocalDate fechaFinal = LocalDate.now().plusDays(364);
        
		for (LocalDate fecha = fechaInicial; fecha.isBefore(fechaFinal.plusDays(1)); fecha = fecha.plusDays(1))
        {
            int semana = (fecha.getDayOfYear()/7);
            if (semana == 52)
            	semana --;
            int dia = fecha.getDayOfWeek().getValue()-1;

            int numeroHabitacionesOcupadas = coordinadorPMS.darNumeroHabitacionesOcupadas(fecha);

            tablero[dia][semana] = numeroHabitacionesOcupadas;
        }
    }

    public int darNumeroHabitaciones()
    {
        return coordinadorPMS.getNumeroHabitaciones();
    }

    public int[][] darTablero()
    {
        return tablero;
    }

}
