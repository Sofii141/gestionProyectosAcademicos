package co.edu.unicauca.mycompany.projects.presentation;

import co.edu.unicauca.mycompany.projects.domain.entities.Student;
import co.edu.unicauca.mycompany.projects.domain.services.Observer;
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

public class GraphicProjectsObserver  extends JFrame implements  Observer {

    private final JPanel jPanelGrafico;
    private final ProjectService projectService;
    private final Student student;

    public GraphicProjectsObserver(Student student,ProjectService projectService, JPanel jPanelGrafico) {
        this.student = student;
        this.jPanelGrafico = jPanelGrafico;
        this.projectService = projectService;
        configurarGrafica();    
    }

    private void configurarGrafica() {
        List<Integer> datos = projectService.dataGraphicStudent(student.getUserId());
        
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.setValue(datos.get(0), "Proyectos", "Total");         
        dataset.setValue(datos.get(1), "Proyectos", "Postulados");     
        dataset.setValue(datos.get(2), "Proyectos", "Asignados");      
        
        initComponents(dataset);
    }
    
    private void initComponents(DefaultCategoryDataset dataset){
        JFreeChart chart = ChartFactory.createBarChart(
                "Cantidad de Proyectos",  
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

    @Override
    public void update() {
        jPanelGrafico.removeAll();  
        configurarGrafica();
        jPanelGrafico.revalidate(); 
        jPanelGrafico.repaint();    
    }
    
    
}
