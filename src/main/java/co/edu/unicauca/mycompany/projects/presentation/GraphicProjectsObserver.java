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
 * cuando se detectan cambios en los datos.
 */
public class GraphicProjectsObserver extends JFrame implements Observer {

    private final JPanel jPanelGrafico; // Panel donde se mostrará la gráfica
    private final ProjectService projectService; // Servicio de proyectos
    private final Student student; // Estudiante asociado a la gráfica

    /**
     * Constructor de la clase.
     * 
     * @param student Estudiante asociado a la gráfica
     * @param projectService Servicio que gestiona los proyectos
     * @param jPanelGrafico Panel donde se mostrará la gráfica
     */
    public GraphicProjectsObserver(Student student, ProjectService projectService, JPanel jPanelGrafico) {
        this.student = student;
        this.jPanelGrafico = jPanelGrafico;
        this.projectService = projectService;
        configurarGrafica();
    }

    /**
     * Método que obtiene los datos del estudiante y configura la gráfica.
     */
    private void configurarGrafica() {
        List<Integer> datos = projectService.dataGraphicStudent(student.getUserId());

        // Crear conjunto de datos para la gráfica
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.setValue(datos.get(0), "Proyectos", "Total");       // Total de proyectos
        dataset.setValue(datos.get(1), "Proyectos", "Postulados");  // Proyectos en los que se ha postulado
        dataset.setValue(datos.get(2), "Proyectos", "Asignados");   // Proyectos asignados

        // Inicializar componentes de la gráfica
        initComponents(dataset);
    }

    /**
     * Método que configura y muestra la gráfica de barras.
     * 
     * @param dataset Datos para la gráfica
     */
    private void initComponents(DefaultCategoryDataset dataset) {
        // Crear la gráfica de barras
        JFreeChart chart = ChartFactory.createBarChart(
                "Proyectos",   // Título del gráfico
                "Estado",                 // Etiqueta del eje X
                "Cantidad",               // Etiqueta del eje Y
                dataset,                   // Datos de la gráfica
                PlotOrientation.VERTICAL,  // Orientación de la gráfica
                false,  // Incluir leyenda
                true,   // Usar tooltips
                false   // No usar URLs
        );

        // Configuración del diseño de la gráfica
        CategoryPlot plot = chart.getCategoryPlot();
        BarRenderer renderer = (BarRenderer) plot.getRenderer();
        renderer.setSeriesPaint(0, new Color(90, 111, 228)); 
        renderer.setBarPainter(new StandardBarPainter()); 
        plot.setBackgroundPaint(Color.WHITE); 
        plot.setOutlineVisible(false); 
        chart.getTitle().setFont(new Font("Segoe UI", Font.BOLD, 18));

        // Crear el panel de la gráfica y agregarlo al panel de la interfaz
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
