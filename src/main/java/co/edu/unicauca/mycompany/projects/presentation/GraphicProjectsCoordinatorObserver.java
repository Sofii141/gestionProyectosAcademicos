package co.edu.unicauca.mycompany.projects.presentation;

import co.edu.unicauca.mycompany.projects.domain.entities.Coordinator;
import co.edu.unicauca.mycompany.projects.infra.Observer;
import co.edu.unicauca.mycompany.projects.domain.services.ProjectService;
import java.awt.Color;
import java.awt.Font;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.StandardBarPainter;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 * Clase observadora que actualiza la gráfica de proyectos de un estudiante 
 * cuando se detectan cambios en los datos.
 */
public class GraphicProjectsCoordinatorObserver extends JFrame implements Observer {

    private final JPanel jPanelGrafico; // Panel donde se mostrará la gráfica
    private final ProjectService projectService; // Servicio de proyectos
    private final Coordinator coordinator; // Estudiante asociado a la gráfica


    public GraphicProjectsCoordinatorObserver(Coordinator coordinator, ProjectService projectService, JPanel jPanelGrafico) {
        this.coordinator = coordinator;
        this.jPanelGrafico = jPanelGrafico;
        this.projectService = projectService;
        configurarGrafica();
    }
    

     private void configurarGrafica() {
        List<Integer> datos = projectService.dataGraphicCoordinator();

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.setValue(datos.get(0), "Proyectos", "RECIBIDO");
        dataset.setValue(datos.get(1), "Proyectos", "ACEPTADO");
        dataset.setValue(datos.get(2), "Proyectos", "RECHAZADO");
        dataset.setValue(datos.get(3), "Proyectos", "EJECUCION");
        dataset.setValue(datos.get(4), "Proyectos", "CERRADO");
        dataset.setValue(datos.get(5), "Proyectos", "TOTAL");

        initComponents(dataset);
    }

    /**
     * Método que configura y muestra la gráfica de barras.
     * 
     * @param dataset Datos para la gráfica
     */
     private void initComponents(DefaultCategoryDataset dataset) {
        JFreeChart chart = ChartFactory.createBarChart(
                "Cantidad de Proyectos por Estado",
                "Estado",
                "Cantidad",
                dataset,
                PlotOrientation.VERTICAL,
                false,
                true,
                false
        );

        CategoryPlot plot = chart.getCategoryPlot();
        BarRenderer renderer = (BarRenderer) plot.getRenderer();
        renderer.setSeriesPaint(0, new Color(90, 111, 228)); 
        renderer.setBarPainter(new StandardBarPainter());
        plot.setBackgroundPaint(Color.WHITE);
        plot.setOutlineVisible(false);
        chart.getTitle().setFont(new Font("Segoe UI", Font.BOLD, 18));

        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setSize(jPanelGrafico.getWidth(), jPanelGrafico.getHeight());
        jPanelGrafico.add(chartPanel);
    }

    /**
     * Método llamado cuando se detecta una actualización en los datos.
     * Se encarga de limpiar la gráfica y regenerarla con los nuevos valores.
     */
    @Override
    public void update() {
        // Limpiar el panel gráfico
        jPanelGrafico.removeAll(); 
        
        // Volver a configurar la gráfica con los nuevos datos
        configurarGrafica(); 
        
        // Validar cambios en la interfaz
        jPanelGrafico.revalidate();
        
        // Repintar la interfaz
        jPanelGrafico.repaint();
    }
}
