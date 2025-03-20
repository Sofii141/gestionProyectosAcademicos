package co.edu.unicauca.mycompany.projects.presentation;

import co.edu.unicauca.mycompany.projects.domain.entities.Student;
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
 * cuando se detectan cambios en los datos asociados a sus proyectos.
 * 
 * Implementa la interfaz {@code Observer} para reaccionar a cambios en los proyectos
 * y actualizar la visualización en una gráfica de barras.
 */
public class GraphicProjectsObserver extends JFrame implements Observer {

    /** Panel donde se mostrará la gráfica de proyectos. */
    private final JPanel jPanelGrafico;

    /** Servicio que gestiona los proyectos y proporciona datos para la gráfica. */
    private final ProjectService projectService;

    /** Estudiante cuyos proyectos se representan en la gráfica. */
    private final Student student;

    /**
     * Constructor de la clase. 
     * Inicializa el observador con la información del estudiante, 
     * el servicio de proyectos y el panel donde se mostrará la gráfica.
     * 
     * @param student Estudiante asociado a la gráfica.
     * @param projectService Servicio encargado de gestionar los proyectos.
     * @param jPanelGrafico Panel donde se renderizará la gráfica.
     */
    public GraphicProjectsObserver(Student student, ProjectService projectService, JPanel jPanelGrafico) {
        this.student = student;
        this.jPanelGrafico = jPanelGrafico;
        this.projectService = projectService;
        configurarGrafica();
    }

    /**
     * Obtiene los datos del estudiante y configura la gráfica.
     * Los datos representan el total de proyectos, postulaciones y asignaciones.
     */
    private void configurarGrafica() {
        List<Integer> datos = projectService.dataGraphicStudent(student.getUserId());

        // Crear conjunto de datos para la gráfica
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.setValue(datos.get(0), "Proyectos", "Total");       // Total de proyectos
        dataset.setValue(datos.get(1), "Proyectos", "Postulados");  // Proyectos en los que se ha postulado
        dataset.setValue(datos.get(2), "Proyectos", "Asignados");   // Proyectos asignados

        // Inicializar los componentes de la gráfica
        initComponents(dataset);
    }

    /**
     * Configura y muestra la gráfica de barras en el panel asociado.
     * Se utiliza la librería JFreeChart para la visualización.
     * 
     * @param dataset Datos para la gráfica, organizados por estado del proyecto.
     */
    private void initComponents(DefaultCategoryDataset dataset) {
        // Crear la gráfica de barras
        JFreeChart chart = ChartFactory.createBarChart(
                "Proyectos",              // Título del gráfico
                "Estado",                 // Etiqueta del eje X
                "Cantidad",               // Etiqueta del eje Y
                dataset,                   // Datos de la gráfica
                PlotOrientation.VERTICAL,  // Orientación de la gráfica
                false,  // No mostrar leyenda
                true,   // Usar tooltips
                false   // No usar URLs
        );

        // Configuración del diseño de la gráfica
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
