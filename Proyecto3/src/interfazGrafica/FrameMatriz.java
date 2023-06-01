package interfazGrafica;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

public class FrameMatriz extends JFrame
{

	private static final Color MAX_COLOR = ControladorVentanasPMS.TEXT_COLOR;
    private static final int MAX_R = MAX_COLOR.getRed();
    private static final int MAX_G = MAX_COLOR.getGreen();
    private static final int MAX_B = MAX_COLOR.getBlue();

    private ControladorVentanasPMS controladorVentanas;
    private TableroCalendario board;
    private int rows;
    private int columns;
    private Color backColor;
    private Color textColor;
    private int[] minColorList;

    public FrameMatriz(ControladorVentanasPMS controladorVentanas, Color backColor, Color textColor)
    {
        this.controladorVentanas = controladorVentanas;
        this.board = new TableroCalendario(controladorVentanas.getCoordinadorPMS());
        this.backColor = backColor;
        this.textColor = textColor;

        int numHabs = board.darNumeroHabitaciones();
        System.out.println("Total habs: " + numHabs);
        this.minColorList = new int[3];
        minColorList[0] = MAX_R/numHabs;
        minColorList[1] = MAX_G/numHabs;
        minColorList[2] = MAX_B/numHabs;

        crearTablero(); 
    }
    
    private void crearTablero()
    {
        int[][] tablero = board.darTablero();
        rows = tablero.length;
        columns = tablero[0].length;

        setLayout(new GridLayout(rows + 1, columns + 1));

        String[] diasDeLaSemana = { "Lun", "Mar", "Mie", "Jue", "Vie", "Sab", "Dom"};
        
        for (int row = 0; row < rows; row++) 
        {
            JLabel diaDeLaSemanaLabel = new JLabel(diasDeLaSemana[row], SwingConstants.CENTER);
            add(diaDeLaSemanaLabel);
            
            for (int column = 0; column < columns; column++)
            {
                JPanel cellPanel = new JPanel();
                Border borde = BorderFactory.createLineBorder(Color.WHITE);
                cellPanel.setBackground(calcularColor(tablero[row][column]));
                cellPanel.setBorder(borde);
                add(cellPanel);
            }
        }

        String[] meses = { "Ene", "Feb", "Mar", "Abr", "May", "Jun",
                            "Jul", "Ago", "Sep", "Oct", "Nov", "Dic" };
        int indiceMes = 0;
        double contador = 0.0;
        for (int column = 0; column < columns; column++) 
        {
            if ((contador % 4.5 == 0) && (indiceMes < 12)) 
            {
                JLabel mesLabel = new JLabel(meses[indiceMes], SwingConstants.CENTER);
                add(mesLabel);
                indiceMes++;
            } 
            else 
            {
                JLabel blankLabel = new JLabel("");
                add(blankLabel);
            }
            contador += 0.75;
        }

        JLabel blankLabel = new JLabel("");
        add(blankLabel);
    }

	private Color calcularColor(int habsOcupadas)
    {
        habsOcupadas = 3;
        int[] colorList = {minColorList[0]*habsOcupadas, minColorList[1]*habsOcupadas, minColorList[2]*habsOcupadas};
        return new Color(colorList[0], colorList[1], colorList[2]);
    }	
}