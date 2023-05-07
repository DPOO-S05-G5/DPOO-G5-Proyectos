package InterfazGrafica;

import java.awt.Color;

public abstract class InterfazGrafica
{
    private ControladorVentanas padre;
	private Color backColor;
	private Color textColor;
	private Color buttonColor;

    public InterfazGrafica(ControladorVentanas ventanaPrincipal, Color backColor, Color textColor, Color buttonColor)
    {
        padre = ventanaPrincipal;
        this.backColor = backColor;
        this.textColor = textColor;
        this.buttonColor = buttonColor;

    }
    
}
