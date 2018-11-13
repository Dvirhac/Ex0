package myMath;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JFrame;
import de.erichseifert.gral.data.DataTable;
import de.erichseifert.gral.plots.XYPlot;
import de.erichseifert.gral.plots.lines.DefaultLineRenderer2D;
import de.erichseifert.gral.plots.lines.LineRenderer;
import de.erichseifert.gral.plots.points.PointRenderer;
import de.erichseifert.gral.ui.InteractivePanel;

public class LinePlotTest extends JFrame {
	public LinePlotTest() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(600, 400);
		Polynom_able p1 = new Polynom("0.2x^4-1.5x^3+3.0x^2-x-5");
		Polynom_able p= p1.copy();
		Polynom_able d=new Polynom(p1.derivative());


		DataTable data = new DataTable(Double.class, Double.class);
		DataTable dataD = new DataTable(Double.class, Double.class);
		for (double x = -2; x <= 6; x+=0.25) {
			if (d.f(x)>0&& d.f(x)<0.5) {
				double y=p.f(x);
				dataD.add(x,y);
				System.out.println(x +","+ y);
			}
			else {
				double y = p.f(x);
				data.add(x, y);
			}
		}
		XYPlot plot = new XYPlot(data,dataD);
		getContentPane().add(new InteractivePanel(plot));
		LineRenderer lines = new DefaultLineRenderer2D();
		plot.setLineRenderers(data, lines);
		Color color = new Color(0.0f, 0.3f, 1.0f);
		plot.getPointRenderers(data).get(0).setColor(color);
		plot.getLineRenderers(data).get(0).setColor(color);
		plot.getPointRenderers(dataD).get(0).setColor(color.RED);



	public static void main(String[] args) {
		LinePlotTest frame = new LinePlotTest();
		frame.setVisible(true);
	}
}