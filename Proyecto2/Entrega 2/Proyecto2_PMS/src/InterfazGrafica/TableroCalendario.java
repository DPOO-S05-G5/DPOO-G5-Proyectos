package InterfazGrafica;

import modelo.CoordinadorPMS;

public class TableroCalendario 
{
    private int[][] tablero;

    CoordinadorPMS coordinadorPMS;
    public TableroCalendario(CoordinadorPMS coordinadorPMS) 
    {
        this.coordinadorPMS = coordinadorPMS;
        tablero = new int[7][52];
    }

    public int darNumeroHabitaciones()
    {
        return coordinadorPMS.getNumeroHabitaciones();
    }

    public int[][] darTablero()
    {
        return tablero;
    }

    public int darNumeroHabitacionesOcupadas(int  , int semana)
    {
        return 0;
    }

}
