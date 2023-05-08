package InterfazGrafica;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class PanelMatriz extends JPanel
{
	private static final Color MAX_COLOR = ControladorVentanas.BACK_COLOR;
    private static final int MAX_R = MAX_COLOR.getRed();
    private static final int MAX_G = MAX_COLOR.getGreen();
    private static final int MAX_B = MAX_COLOR.getBlue();

    private ControladorVentanas controladorVentanas;
    private TableroCalendario board;
    private int rows;
    private int columns;
    private Color backColor;
    private Color textColor;
    private int[] minColorList;

    public PanelMatriz(ControladorVentanas controladorVentanas, Color backColor, Color textColor)
    {
        this.controladorVentanas = controladorVentanas;
        this.board = new TableroCalendario(controladorVentanas.getCoordinadorPMS());
        this.backColor = backColor;
        this.textColor = textColor;

        setBackground(backColor);
        setForeground(textColor);

        int numHabs = board.darNumeroHabitaciones();
        int[] minColorList = {MAX_R/numHabs, MAX_G/numHabs, MAX_B/numHabs};
    }
    
    @Override
	public void paint(Graphics g)
	{
    	super.paint(g);
    	
    	Graphics2D g2d = (Graphics2D) g;
    	int[][] boardMatrix = board.darTablero();
    	rows = boardMatrix.length;
    	columns = boardMatrix[0].length;

    	for (int i=0; i<rows; i++)
    	{
    		for (int j=0; j<columns; j++)
    		{
    			int x = (getWidth() / columns) * j;
    			int y = (getHeight() / rows) * i;
    			int width = getWidth() / columns;
    			int height = getHeight() / rows;
    			
    			Color color = calcularColor(boardMatrix[i][j]);

    			g2d.setColor(color);
    			
    			g2d.fillRect(x, y, width, height);
    			g2d.setColor(textColor);
    			g2d.drawRect(x, y, width, height);
    		}
    	}
	}

	private Color calcularColor(int habsOcupadas)
    {
        int[] colorList = {minColorList[0]*habsOcupadas, minColorList[1]*habsOcupadas, minColorList[2]*habsOcupadas};

        return new Color(colorList[0], colorList[1], colorList[2]);
    }	
}