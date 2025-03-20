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
 * Clase observadora que actualiza la gráfica de proyectos de un coordinador 
 * cuando se detectan cambios en los datos del servicio de proyectos.
 * 
 * Implementa la interfaz {@code Observer} para reaccionar a cambios en los proyectos
 * y reflejar los nuevos datos en una gráfica de barras.
 */
public class GraphicProjectsCoordinatorObserver extends JFrame implements Observer {

    /** Panel donde se renderizará la gráfica de proyectos. */
    private final JPanel jPanelGrafico;

    /** Servicio que gestiona los proyectos y proporciona datos para la gráfica. */
    private final ProjectService projectService;

    /** Coordinador (estudiante) cuyos proyectos se representan en la gráfica. */
    private final Coordinator coordinator;

    /**
     * Constructor de la clase. 
     * Inicializa el observador con la información del coordinador, 
     * el servicio de proyectos y el panel donde se mostrará la gráfica.
     * 
     * @param coordinator    Coordinador cuya gráfica de proyectos se actualizará.
     * @param projectService Servicio encargado de gestionar los proyectos.
     * @param jPanelGrafico  Panel donde se renderizará la gráfica.
     */
    public GraphicProjectsCoordinatorObserver(Coordinator coordinator, ProjectService projectService, JPanel jPanelGrafico) {
        this.coordinator = coordinator;
        this.jPanelGrafico = jPanelGrafico;
        this.projectService = projectService;
        configurarGrafica();
    }

    /**
     * Configura y genera la gráfica de barras con los datos actuales de los proyectos.
     * Los datos se obtienen del servicio de proyectos y se representan según su estado.
     */
    private void configurarGrafica() {
        List<Integer> datos = projectService.dataGraphicCoordinator();

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.setValue(datos.get(0), "Proyectos", "RECIBIDO");
        dataset.setValue(datos.get(1), "Proyectos", "ACEPTADO");
        dataset.setValue(datos.get(2), "Proyectos", "RECHAZADO");
        dataset.setValue(datos.get(3), "Proyectos", "EJECUCIÓN");
        dataset.setValue(datos.get(4), "Proyectos", "CERRADO");
        dataset.setValue(datos.get(5), "Proyectos", "TOTAL");

        initComponents(dataset);
    }

    /**
     * Configura y muestra la gráfica de barras en el panel asociado.
     * Se utiliza la librería JFreeChart para la visualización.
     * 
     * @param dataset Datos para la gráfica, organizados por estado del proyecto.
     */
    private void initComponents(DefaultCategoryDataset dataset) {
        JFreeChart chart = ChartFactory.createBarChart(
                "Cantidad de Proyectos por Estado", // Título de la gráfica
                "Estado", // Etiqueta del eje X
                "Cantidad", // Etiqueta del eje Y
                dataset,
                PlotOrientation.VERTICAL,
                false, // Mostrar leyenda
                true,  // Usar tooltips
                false  // Usar URLs
        );

        // Configuración visual del gráfico
        CategoryPlot plot = chart.getCategoryPlot();
        BarRenderer renderer = (BarRenderer) plot.getRenderer();
        renderer.setSeriesPaint(0, new Color(90, 111, 228)); // Color azul para las barras
        renderer.setBarPainter(new StandardBarPainter());
        plot.setBackgroundPaint(Color.WHITE);
        plot.setOutlineVisible(false);
        chart.getTitle().setFont(new Font("Segoe UI", Font.BOLD, 18));

        // Crear el panel de la gráfica y agregarlo al panel gráfico
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setSize(jPanelGrafico.getWidth(), jPanelGrafico.getHeight());
        jPanelGrafico.add(chartPanel);
    }

    /**
     * Método llamado cuando se detecta una actualización en los datos de los proyectos.
     * Se encarga de limpiar la gráfica actual y regenerarla con los nuevos valores.
     */
    @Override
    public void update() {
        jPanelGrafico.removeAll(); // Limpiar el panel gráfico
        configurarGrafica(); // Volver a generar la gráfica con los datos actualizados
        jPanelGrafico.revalidate(); // Validar los cambios en la interfaz
        jPanelGrafico.repaint(); // Repintar la interfaz gráfica
    }
}