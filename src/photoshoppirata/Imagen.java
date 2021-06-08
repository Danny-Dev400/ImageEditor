package photoshoppirata;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

/**
 * Esta clase tiene todos lo metodos y atributos necesarios para hacer operaciones con imágenes
 * @author Daniel Salazar, Daniela Silva, Paola Jimenez
 * 
 */
public class Imagen {
    
    PhotoshopPirataa potosho;
    
    private XYSeries punticos= new XYSeries("Histograma de escala de Grices");
    private XYSeries punticos2= new XYSeries("Histograma de escala de Grices Log");
    
    /**Obtiene el archivo donde se encuentra la imágen */
    private File Imagen;
    
    /**Buffer de la imágen que se obtiene del archivo, esta varaible contiene el buffer con la imágen original*/
    private BufferedImage original;
    
    /**Buffer de la imágen donde se va a trabajar la nueva imágen a editar*/
    private BufferedImage Editada;
    
    /**Esta variable contiene el ancho de la imágen*/
    private int ancho;
    
    /**Esta variable contiene el alto de la imágen*/
    private int alto;
    
    /**Esta matriz contiene el rgb por pixel de la imágen original*/
    private Color[][] rgbOriginal;
    
    /**Esta matriz guarda los datos de la imágen original convertida en grises*/
    private int[][] grises;
    
    /**Esta matriz guarda los datos de la imágen en la cual se quiere editar*/
    private int[][] grises2;
    
    /**Esta matriz guarda los valores de la imágen en negativo*/
    private int[][] negativo;
    /***/
    private int pixel,r,g,b,rn,gn,bn;
    private Color c,n;
    private int[] arreglo;
    private int[][] matrizFiltro;
    private int[] Ordenar;
    private int[] frecuenciaGrices = new int[256];
    private double[] frecuenciaGricesLog = new double[256];
    private float[] probabilidades = new float[256],probabilidadesAcum = new float[256];
    private int[] nivelGrices = new int[256];
    private int[] gricesEcualizados = new int[256];
    private int PromIntensidad,grisMini,grisMaxi;
    private int sumaMatriz=0;
    
    /**
     * Constructor de la clase Imagen, crea el objeto imágen y llena algunas variables necesarias para otras funciones
     * @param Imagen: recibe como parámetro una variable de tipo File para mandar la imágen a analizar
     * @param original: recibe como parámetro un buffer Image con la ruta de la imágen ya hecha
     */
    public Imagen(File Imagen, BufferedImage original ) {
        this.Imagen = Imagen;
        this.original = original;
        ancho = original.getWidth();
        alto = original.getHeight();
        for(int i=0;i<nivelGrices.length;i++){
            nivelGrices[i] = i;
        }
        PromIntensidad = PromedioIntensidad();
        grisMaxyMin();
    }
    
    /**Retorna el archivo de la imágen
     *@return Imagen: Retorna un tipo de dato File que contiene el archivo de la imágen
     */
    public File getImagen() {
        return Imagen;
    }
    
    /**Retorna el ancho de la imágen
     *@return ancho: Retorna un tipo de dato entero con el ancho de la imágen.
     */
    public int getAncho() {
        return ancho;
    }
    
    /**Retorna el alto de la imágen
     *@return alto: Retorna un tipo de dato entero con el alto de la imágen.
     */
    public int getAlto() {
        return alto;
    }
    
    /**Retorna el BufferImage que contiene la imágen editada.
     *@return Editada: Retorna un tipo de dato Bufferimage que tiene dentro la imágen con la transformación deseada.
     */
    public BufferedImage getEditada() {
        return Editada;
    }
    
    /**Retorna el BufferImage que contiene la imágen Original.
     *@return original: Retorna un tipo de dato Bufferimage que tiene dentro la imagen con la imágen original.
     */
    public BufferedImage getOriginal() {
        return original;
    }
    
    /**Envia el archivo de la imágen a abrir.
     *@param Imagen: Se envía un archivo con tipo de variable File a editar
     */
    public void setImagen(File Imagen) {
        this.Imagen = Imagen;
    }
    
    /**Envia el ancho de la imágen
     *@param ancho: Se envia un dato de tipo int el cual contiene el ancho de la imágen.
     */
    public void setAncho(int ancho) {
        this.ancho = ancho;
    }
    
    /**Envia el alto de la imágen
     *@param alto: Se envía un dato de tipo int el cual contiene el alto de la imágen.
     */
    public void setAlto(int alto) {
        this.alto = alto;
    }
    
    /**Envia el alto de la imágen
     *@return PromIntensidad: Retorna un tipo de dato entero con el valor del nivel de gris promedio.
     */
    public int getPromIntensidad() {
        return PromIntensidad;
    }
    
    /**
     *Convierte la imágen en escala grises y guarda los valores por pixel en escala de grises en la matriz grises
     */
    public void EscalaGrices(){
        rgbOriginal = new Color[ancho][alto];
        grises = new int[ancho][alto];

        for (int x = 0; x < ancho; x++) {
            for (int y = 0; y < alto; y++) {
                pixel = original.getRGB(x, y);
                c = new Color(pixel);
                rgbOriginal[x][y] = c;
                r = c.getRed();
                g = c.getGreen();
                b = c.getBlue();
                grises[x][y] = (int) ((r * 0.3) + (g * 0.59) + (b * 0.11));
            }
        }
        crearImagenGrices(grises);
    }
    
    /**
     *Convierte la imágen en su negativo y guarda los datos en la matriz de enteros negativo
     */
    public void NegativoIMG(){
        rgbOriginal = new Color[ancho][alto];
        negativo = new int[ancho][alto];
        for (int x = 0; x < ancho; x++) {
            for (int y = 0; y < alto; y++) {
                pixel = original.getRGB(x, y);
                c = new Color(pixel);
                rgbOriginal[x][y] = c;
                r = c.getRed();
                g = c.getGreen();
                b = c.getBlue();
                rn = 255 - r;
                gn = 255 - g;
                bn = 255 - b;
                n = new Color(rn, gn, bn);
                negativo[x][y] = n.getRGB();
                //System.out.println(pruebas[x][y]);
            }
        }
        crearImagenColor(negativo);
    }
    
    /**
     *Modifica la imágen y le colaca un filtro bajos a la imágen
     */
    public void filtroPasaBajos(){
        EscalaGrices();
        
        grises2 = new int[ancho][alto];
        int valPromedio=0;
        int tol=5;
        int cont =0;
        for(int i=0+tol;i<ancho-tol;i++){
            for(int j=0+tol;j<alto-tol;j++){
                for(int m=i-tol;m<=i+tol;m++){
                    for(int n=j-tol;n<=j+tol;n++){
                        valPromedio = valPromedio+grises[m][n];
                        cont++;
                    }
                }
                //System.out.println(cont);
                valPromedio=valPromedio/cont;
                grises2[i][j]=valPromedio;
                valPromedio=0;
                cont=0;
            }
        }
        crearImagenGrices(grises2);
    }
    
    /**
     *Modifica la imagen y le colaca un filtro altos a la imagen
     */
    public void filtroPasaAltos(){
        EscalaGrices();
        
        grises2 = new int[ancho][alto];
        int valPromedio=0;
        int tol=1;
        int cont =0;
        for(int i=0+tol;i<ancho-tol;i++){
            for(int j=0+tol;j<alto-tol;j++){
                for(int m=i-tol;m<=i+tol;m++){
                    for(int n=j-tol;n<=j+tol;n++){
                        valPromedio = valPromedio+grises[m][n];
                        cont++;
                    }
                }
                //System.out.println(valPromedio/cont);
                valPromedio=valPromedio/(cont);
                grises2[i][j]=(grises[i][j]- valPromedio)*5;
                if(grises2[i][j]<0){
                    grises2[i][j]=0;
                }
                //System.out.println("Original: "+grises[i][j]+" Resul "+grises2[i][j]+" antes " +valPromedio*9+" despues "+valPromedio);
                valPromedio=0;
                cont=0;
            }
        }
        
        crearImagenGrices(grises2);
        
    }
    
    /**
     *Modifica la imágen y le colaca un filtro High boost teniendo en cuenta el filtro pasa altos
     */
    public void filtroHBPasaAltos(){
        EscalaGrices();
        
        grises2 = new int[ancho][alto];

        int valPromedio=0;
        int tol=1;
        int cont =0;
        int MultiplicadorA=2;
        for(int i=0+tol;i<ancho-tol;i++){
            for(int j=0+tol;j<alto-tol;j++){
                for(int m=i-tol;m<=i+tol;m++){
                    for(int n=j-tol;n<=j+tol;n++){
                        valPromedio = valPromedio+grises[m][n];
                        cont++;
                    }
                }
                //System.out.println(cont);
                valPromedio=valPromedio/cont;
                grises2[i][j]=((MultiplicadorA-1)*grises[i][j]) + (grises[i][j]-valPromedio);
                if(grises2[i][j]<0){
                    grises2[i][j]=0;
                }
                if(grises2[i][j]>255){
                    grises[i][j]=255;
                }
                valPromedio=0;
                cont=0;
            }
        }
        crearImagenGrices(grises2);
    }
    
    /**
     *Modifica la imágen y le colaca un filtro High boost teniendo en cuenta el filtro pasa bajos
     */
    public void filtroHBPasaBajos(){
        
        EscalaGrices();
        
        grises2 = new int[ancho][alto];
        int valPromedio=0;
        int tol=1;
        int cont =0;
        int MultiplicadorA=2;
        for(int i=0+tol;i<ancho-tol;i++){
            for(int j=0+tol;j<alto-tol;j++){
                for(int m=i-tol;m<=i+tol;m++){
                    for(int n=j-tol;n<=j+tol;n++){
                        valPromedio = valPromedio+grises[m][n];
                        cont++;
                    }
                }
                //System.out.println(cont);
                valPromedio=valPromedio/cont;
                grises2[i][j]=(MultiplicadorA*grises[i][j])- valPromedio;
                if(grises2[i][j]<0){
                    grises2[i][j]=0;
                }
                if(grises2[i][j]>255){
                    grises2[i][j]=255;
                }
                valPromedio=0;
                cont=0;
            }
        }
        
        crearImagenGrices(grises2);
    }
    
    /**
     *Modifica la imágen y le colaca un filtro Binomial el cual hace más borrosa la foto. El filtro se puede modificar con la variable interna llamado numPisosPascal
     */
    public void filtroPascal(){
        
        EscalaGrices();
        
        grises2 = new int[ancho][alto];
        int valPromedio=0;
        int numPisosPascal=7;
        TrianguloPascal(numPisosPascal);
        CalcularMatriz(numPisosPascal);
        
        System.out.println(numPisosPascal/2);
        
        int tol=numPisosPascal/2;
        int cont =0;
        int contM=0,contN=0;
        
        for(int i=0+tol;i<ancho-tol;i++){
            for(int j=0+tol;j<alto-tol;j++){
                for(int m=i-tol;m<=i+tol;m++){
                    for(int n=j-tol;n<=j+tol;n++){
                        //System.out.println(matrizFiltro[contM][contN]);
                        valPromedio = (matrizFiltro[contM][contN]*grises[m][n])+valPromedio;
                        cont++;
                        contM++;
                    }
                    contM=0;
                    contN++;
                }
                //System.out.println(cont);
                //System.out.println(cont);
                valPromedio=valPromedio/sumaMatriz;
                grises2[i][j]=valPromedio;
                valPromedio=0;
                cont=0;
                contN=0;
                contM=0;
            }
        }
        
        crearImagenGrices(grises2);

    }
    
    /**
     *Esta función se trabaja en conjunto con el filtro pascal y calcula el triángulo de pascal hasta el piso que se le pasa como parámetro,
     * el resultado del nivel del triángulo de pascal deseado se manda a un arreglo llamado arreglo.
     * @param numPisos: manda un valor de tipo entero para determinar el psio del triangulo de pascal a obtener
     */
    public void TrianguloPascal(int numPisos){
        arreglo=new int[1];
        for(int i=1;i<=numPisos;i++){
            int[] pascal= new int[i];
            for(int j=0;j<i;j++){
                if(j==0 || j==(i-1)){
                    pascal[j]=1;
                }else{
                    pascal[j]=arreglo[j]+arreglo[j-1];
                }
                //System.out.print(pascal[j]);
            }
            arreglo=pascal;
            //System.out.println();
        }
        /*for(int i=0;i<numPisos;i++){
            System.out.println(arreglo[i]);
        }*/
    }
    
    /**
     *Se le pasa como parámetro el tamaño de la matriz a calcular, y lo que hace esta función es obtener una matriz simétrica partiendo de una arreglo.
     * @param dim: indica la dimensión de la matriz que va a generar dado el arreglo de pascal
     */
    public void CalcularMatriz(int dim){
        matrizFiltro = new int[dim+1][dim+1];
        
        for(int i=0;i<dim;i++){
            for(int j=0;j<dim;j++){
                matrizFiltro[i][j]=arreglo[i]*arreglo[j];
                System.out.print(matrizFiltro[i][j]);
            }
            System.out.println();
        }
        
        for(int i=0;i<dim;i++){
            for(int j=0;j<dim;j++){
                sumaMatriz += matrizFiltro[i][j];
            }
            System.out.println();
        }
    }
    
    /**
     *Modifica la imágen y le colaca un filtro máximo para aumentar las regiones claras de la imágen
     */
    public void filtroMaximo(){
        EscalaGrices();
        
        grises2 = new int[ancho][alto];
        int tol=1;
        int cont =0;
        Ordenar=new int[9];
        for(int i=0+tol;i<ancho-tol;i++){
            for(int j=0+tol;j<alto-tol;j++){
                for(int m=i-tol;m<=i+tol;m++){
                    for(int n=j-tol;n<=j+tol;n++){
                        Ordenar[cont]=grises[m][n];
                        cont++;
                    }
                }
                //System.out.println(Ordenar[cont]);
                grises2[i][j]=OrdenarMM(Ordenar,1);
                //System.out.println(cont);
                cont=0;
            }
        }
        crearImagenGrices(grises2);
    }
    
    /**
     *Modifica la imágen y le colaca un filtro mínimo para aumentar las regiones oscuras de la imágen
     */
    public void filtroMinimo(){
        EscalaGrices();
        
        grises2 = new int[ancho][alto];
        int tol=1;
        int cont =0;
        Ordenar=new int[9];
        for(int i=0+tol;i<ancho-tol;i++){
            for(int j=0+tol;j<alto-tol;j++){
                for(int m=i-tol;m<=i+tol;m++){
                    for(int n=j-tol;n<=j+tol;n++){
                        Ordenar[cont]=grises[m][n];
                        cont++;
                    }
                }
                //System.out.println(Ordenar[cont]);
                grises2[i][j]=OrdenarMM(Ordenar,2);
                //System.out.println(cont);
                cont=0;
            }
        }
        crearImagenGrices(grises2);
    }
    
    /**
     *Modifica la imágen y le colaca un filtro mínimo para aumentar las regiones oscuras de la imágen
     *@param orden obtiene el arreglo a ordenar de tipo entero
     * @param op se ingresa la opción de retorno del parámetro, si es 1 devuelve el gris máximo, si es 2 devuelve el mínimo y si es 3 la mediana
     * @return retorna un valor entero y depende de la opción del param op, si es diferente de alguno de estos retorna 100
     */
    public int OrdenarMM(int orden[] , int op){
        int max=0, min=0, mediana=0;
        int aux;
        if(op==1){
            for(int i=0;i<orden.length-1;i++){
                for(int j=0;j<orden.length-1;j++){
                    if(orden[j] > orden[j+1]){
                        aux=orden[j];
                        orden[j] = orden[j+1];
                        orden[j+1] = aux;
                    }
                }
            }
            max=orden[orden.length-1];
            return max;
        }if(op==2){
            for(int i=0;i<orden.length-1;i++){
                for(int j=0;j<orden.length-1;j++){
                    if(orden[j] > orden[j+1]){
                        aux=orden[j];
                        orden[j] = orden[j+1];
                        orden[j+1] = aux;
                    }
                }
            }
            min=orden[0];
            return min;
        }
        if(op==3){
            for(int i=0;i<orden.length-1;i++){
                for(int j=0;j<orden.length-1;j++){
                    if(orden[j] > orden[j+1]){
                        aux=orden[j];
                        orden[j] = orden[j+1];
                        orden[j+1] = aux;
                    }
                }
            }
            mediana=orden[4];
            return mediana;
        }
        return 100;
    }
    
    /**
     *Saca una gráfica con el histograma de la imágen en escala de grises
     */
    public void Histograma(){
        EscalaGrices();

        int frecuencia=0;
        float aux=0;
        for(int n=0;n<nivelGrices.length;n++){
            for(int i=0;i<ancho;i++){
                for(int j=0;j<alto;j++){
                    if(grises[i][j] == nivelGrices[n]){
                        frecuencia++;
                    }
                }
            }

            frecuenciaGrices[n]=frecuencia;
            probabilidades[n]=(float)frecuenciaGrices[n]/(ancho*alto);
            aux+=probabilidades[n];
            probabilidadesAcum[n] = aux;
            float nuevoGris = (float)probabilidadesAcum[n]*255;
            gricesEcualizados[n] =(int)nuevoGris;
            frecuencia=0;
            punticos.add(nivelGrices[n],frecuenciaGrices[n]);
        }
        
        for(int i=0;i<frecuenciaGrices.length;i++){
            System.out.println("El nivel de gris: "+i+" esta "+frecuenciaGrices[i]+ " veces con probabilidad de "+ probabilidades[i] +
                    " acumulado de "+probabilidadesAcum[i] + " nuevo es: " + gricesEcualizados[i]);
        }
        
        XYSeriesCollection dataset=new XYSeriesCollection();// se crea un data set donde estan todos los puntos a graficar
        dataset.addSeries(punticos);
        
        JFreeChart graficaXY= ChartFactory.createXYLineChart(
                "Grafica XY","Eje X","Eje Y",dataset,PlotOrientation.VERTICAL,true,true,false);
        
        XYPlot plot= graficaXY.getXYPlot();
        
        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
        renderer.setSeriesPaint(0, Color.RED);
        renderer.setSeriesStroke(0, new BasicStroke(1.0f));
        plot.setRenderer(renderer);
        
        ChartPanel panel = new ChartPanel(graficaXY);
        
        JFrame ventana = new JFrame("Grafica");
        ventana.setVisible(true);
        ventana.setSize(800, 600);
        ventana.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        ventana.setLocationRelativeTo(null);
        ventana.add(panel);
    }
    
    /**
     *Saca una gráfica con el histograma logaritmico en base 10 de la imágen en escala de grises
     */
    public void HistogramaLogaritmico(){
        EscalaGrices();

        int frecuencia=0;
        for(int n=0;n<nivelGrices.length;n++){
            for(int i=0;i<ancho;i++){
                for(int j=0;j<alto;j++){
                    if(grises[i][j] == nivelGrices[n]){
                        frecuencia++;
                    }
                }
            }
            if(frecuencia==0){
                frecuencia=1;
            }
            frecuenciaGricesLog[n]=Math.log10(frecuencia);
            frecuencia=0;
            punticos2.add(nivelGrices[n],frecuenciaGricesLog[n]);
        }
        
        for(int i=0;i<frecuenciaGrices.length;i++){
            System.out.println("El nivel de gris: "+i+" esta "+frecuenciaGrices[i]+ " veces");
        }
        
        XYSeriesCollection dataset=new XYSeriesCollection();// se crea un data set donde estan todos los puntos a graficar
        dataset.addSeries(punticos2);
        
        JFreeChart graficaXY= ChartFactory.createXYLineChart(
                "Grafica XY","Eje X","Eje Y",dataset,PlotOrientation.VERTICAL,true,true,false);
        
        XYPlot plot= graficaXY.getXYPlot();
        
        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
        renderer.setSeriesPaint(0, Color.RED);
        renderer.setSeriesStroke(0, new BasicStroke(1.0f));
        plot.setRenderer(renderer);
        
        ChartPanel panel = new ChartPanel(graficaXY);
        
        JFrame ventana = new JFrame("Grafica");
        ventana.setVisible(true);
        ventana.setSize(800, 600);
        ventana.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        ventana.setLocationRelativeTo(null);
        ventana.add(panel);
    }
    
    /**
     *Retorna el valor promedio de nivel de gris de la imágen
     *@return retorna un valor de tipo entero con el nivel de gris promedio de la imágen.
     */
    public int PromedioIntensidad(){
        EscalaGrices();
        int sumatoria=0;
        for(int i=0;i<ancho;i++){
            for(int j=0;j<alto;j++){
                sumatoria =  sumatoria+grises[i][j];
            }
        }
        return sumatoria/(ancho*alto);
    }
    
    /**
     *Calcula el nivel de gris mínimo y máximo de la imágen, y los guarda en las variable de la clase grisMini y grisMaxi
     */
    public void grisMaxyMin(){
        EscalaGrices();
        grisMaxi=grises[0][0];
        grisMini = grises[0][0];;
        
        for(int i=0;i<ancho;i++){
            for(int j=0;j<alto;j++){
                if(grisMini>grises[i][j]){
                    grisMini=grises[i][j];
                }
                if(grisMaxi<grises[i][j]){
                    grisMaxi=grises[i][j];
                }
            }
        }
    }
    
    /**
     *Hace el contraste de automático en la imágen
     */
    public void ContrasteAuto(){
        rgbOriginal = new Color[ancho][alto];
        grises = new int[ancho][alto];

        for (int x = 0; x < ancho; x++) {
            for (int y = 0; y < alto; y++) {
                pixel = original.getRGB(x, y);
                c = new Color(pixel);
                rgbOriginal[x][y] = c;
                r = c.getRed();
                g = c.getGreen();
                b = c.getBlue();
                float gris = (int) ((r * 0.3) + (g * 0.59) + (b * 0.11));
                float f1 = gris-grisMini;
                float f2 = grisMaxi-grisMini;
                
                float f=(f1/f2)*255;
                
                grises[x][y] = (int)f;
                //System.out.println(grises[x][y]);
                
                if(grises[x][y]<0){
                    grises[x][y]=0;
                }else if(grises[x][y]>255){
                    grises[x][y]=255;
                }
            }
        }
        crearImagenGrices(grises);
    }
    
    /**
     *Hace la ecualización del histograma mejorando el contraste de la imágen, para que esta funcionalidad sirva correctamente,
     * se debe haber hecho el histograma antes
     */
    public void Ecualizacion(){
        for(int n=0;n<nivelGrices.length;n++){
            for(int i=0;i<ancho;i++){
                for(int j=0;j<alto;j++){
                    if(grises[i][j] == nivelGrices[n]){
                        grises[i][j] = gricesEcualizados[n];
                    }
                }
            }
        }
        crearImagenGrices(grises);
    }
    
    /**
     *Modifica la imágen pasando parámetros de una matriz de filtro personalizada de 3x3 y el divisor que es la suma de todos datos de la matriz
     * @param matriz matriz de tipo float, recibe la matriz personalizada con la cual se va a editar la imágen
     * @param Divisor recibe el divisor por el cual se va a dividir la matriz para sacar el valor de gris
     */
    public void FiltroPersonalizado(float[][] matriz,float Divisor){
        EscalaGrices();
        
        grises2 = new int[ancho][alto];
        float valPromedio=0f;
        int tol=1;
        int cont =0;
        int contM=0,contN=0;
        
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                System.out.println(matriz[i][j] +" "+ Divisor);
            }
        }
        
        for(int i=0+tol;i<ancho-tol;i++){
            for(int j=0+tol;j<alto-tol;j++){
                for(int m=i-tol;m<=i+tol;m++){
                    for(int n=j-tol;n<=j+tol;n++){
                        //System.out.println(matriz[contM][contN]);
                        valPromedio = (matriz[contM][contN]*grises[m][n])+valPromedio;
                        cont++;
                        contM++;
                    }
                    contM=0;
                    contN++;
                }
                //System.out.println(cont);
                //System.out.println(cont);
                valPromedio=valPromedio/Divisor;
                //System.out.println(valPromedio);
                grises2[i][j]=(int)valPromedio;
                
                if(grises2[i][j] < 0){
                    grises2[i][j]=0;
                }else if(grises2[i][j] > 255){
                    grises2[i][j]=255;
                }
                
                valPromedio=0f;
                cont=0;
                contN=0;
                contM=0;
            }
        }
        
        crearImagenGrices(grises2);
    }
    
    /**
     * Este metodo modifica la imagen y coloca un desenfoque gausiano a la imagen
     */
    public void FiltroGaus(){
        
        grises2 = new int[ancho][alto];
        
        
        int tol=5;
        int[][] MatrizComparar = new int[(tol*2)+1][(tol*2)+1];
        int cont =0;
        int contM=0,contN=0;
        
        for(int i=0+tol;i<ancho-tol;i++){
            for(int j=0+tol;j<alto-tol;j++){
                for(int m=i-tol;m<=i+tol;m++){
                    for(int n=j-tol;n<=j+tol;n++){
                        //System.out.println(matrizFiltro[contM][contN]);
                        MatrizComparar[contM][contN] = grises[m][n];
                        cont++;
                        contM++;
                    }
                    contM=0;
                    contN++;
                }
                grises2[i][j]=calcularGrisGaus(MatrizComparar,grises[i][j],tol);
                //System.out.println("grisOriginal: "+grises[i][j]+" grisGaus: "+grises2[i][j]);
                cont=0;
                contN=0;
                contM=0;
            }
        }
        
        crearImagenGrices(grises2);

    }
    
    /**
     * Este metodo calcula el nivel de gris de gasuss dao un nivel de gris
     * @param matriz Manda una matriz de tamaño n impar de tipo entero la cual sirve para sacar la el nuevo gris de gauss
     * @param grisEditar Dato de tipo entero, es el nivel de gris qeu se va a crar la mascara y a editar
     * @param tolerancia La tolerancia que implica el tamaño de la matriz
     * @return Retorna un dato de tipo entero el cual retorna el nuevo nivel de gris editado sacado con la ecuacion de gauss
     */
    public int calcularGrisGaus(int[][] matriz, int grisEditar,int tolerancia){
        int tol=tolerancia;
        float[][] coefgaus = new float[(tol*2)+1][(tol*2)+1];
        int[][] valoresGrisGauss = new int[(tol*2)+1][(tol*2)+1];
        float desv = 1f;
        int sumatoriaGrises=0;
        int sumatoriaGrises2=0;
        int grisGaus = 0;
        
        for(int i=0;i<(tol*2)+1;i++){
            for(int j=0;j<(tol*2)+1;j++){
                float sup = (float) (Math.pow(i-tol,2) + Math.pow(j-tol,2));
                float inf = (float) (2*Math.pow(desv, 2));
                float exp = sup/inf;
                coefgaus[i][j] = (float) Math.pow(Math.E,(exp*-1) );
            }
        }
        
        for(int i=0;i<(tol*2)+1;i++){
            for(int j=0;j<(tol*2)+1;j++){
                float aux= coefgaus[i][j]*grisEditar;
                valoresGrisGauss[i][j] = (int)aux;
                sumatoriaGrises += valoresGrisGauss[i][j];
            }
        }
        
        for(int i=0;i<(tol*2)+1;i++){
            for(int j=0;j<(tol*2)+1;j++){
                sumatoriaGrises2 += valoresGrisGauss[i][j] * matriz[i][j];
            }
        }
        if(sumatoriaGrises>0){
            grisGaus = sumatoriaGrises2/sumatoriaGrises;
        }else{
            grisGaus = 0;
        }
        return grisGaus;
    }
    
    /**
     *Modifica la imágen y le colaca un filtro mediana para reducir el ruido sal y pimienta
     */
    public void filtroMediana(){
        EscalaGrices();
        
        grises2 = new int[ancho][alto];
        int tol=1;
        int cont =0;
        Ordenar=new int[9];
        for(int i=0+tol;i<ancho-tol;i++){
            for(int j=0+tol;j<alto-tol;j++){
                for(int m=i-tol;m<=i+tol;m++){
                    for(int n=j-tol;n<=j+tol;n++){
                        Ordenar[cont]=grises[m][n];
                        cont++;
                    }
                }
                //System.out.println(Ordenar[cont]);
                grises2[i][j]=OrdenarMM(Ordenar,3);
                //System.out.println(cont);
                cont=0;
            }
        }
        crearImagenGrices(grises2);
    }
    
    /**
     *Modifica la imágen y le colaca un filtro moda a la imágen.
     */
    public void filtroModa(){
        EscalaGrices();
        
        grises2 = new int[ancho][alto];
        int[][] MatrizComparar = new int[3][3];
        
        int tol=1;
        int cont =0;
        int contM=0,contN=0;
        
        for(int i=0+tol;i<ancho-tol;i++){
            for(int j=0+tol;j<alto-tol;j++){
                for(int m=i-tol;m<=i+tol;m++){
                    for(int n=j-tol;n<=j+tol;n++){
                        //System.out.println(matrizFiltro[contM][contN]);
                        MatrizComparar[contM][contN] = grises[m][n];
                        cont++;
                        contM++;
                    }
                    contM=0;
                    contN++;
                }
                grises2[i][j]=ObtenerModa(MatrizComparar);
                cont=0;
                contN=0;
                contM=0;
            }
        }
        
        crearImagenGrices(grises2);
        
    }
    
    /**
     * 
     * @param MatrizAnalisis resive una matriz de tipo entero de tamaño 3x3 que calcula cual es la moda de de esa matriz
     * @return Moda: retorna la moda de la matriz como dato de tipo entero
     */
    public int ObtenerModa(int[][] MatrizAnalisis){
        int frecu=0;
        int cont=0,cont2=0;
        int contX=0;
        
        int[] matrizAux = new int[9];
        int[] frecuencia = new int[9];
        
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                matrizAux[cont] = MatrizAnalisis[i][j];
                cont++;
            }
        }
        cont=0;
        for(int a=0;a<matrizAux.length;a++){
            for(int i=0;i<3;i++){
                for(int j=0;j<3;j++){
                    if(MatrizAnalisis[i][j] == matrizAux[contX]){
                        frecu++;
                    }
                }
            }
            frecuencia[contX] = frecu;
            contX++;
            frecu=0;
        }
        
        frecu=0;
        contX=0;
        
        int moda = frecuencia[0];
        
        for(int i=0;i<frecuencia.length;i++){
            if(moda < frecuencia[i]){
                moda=frecuencia[i];
            }
            
        }
        //System.out.println(moda);
        ArrayList<Integer> modasIguales = new ArrayList<Integer>();
        
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(frecuencia[cont2]==moda){
                    modasIguales.add(MatrizAnalisis[i][j]);
                }
                cont2++;
            }
        }
        cont2=0;
        int sumModas = 0;
        
        for(int i=0;i<modasIguales.size();i++){
            sumModas += modasIguales.get(i);
        }
        
        moda= sumModas/modasIguales.size();
        sumModas=0;
        
        //System.out.println(modasIguales.size());
        modasIguales.clear();
        //System.out.println(modasIguales.size());
        //System.out.println(moda);
        return moda;
        
        
    }
    
    /**
     *Crea una imágen en escala de grises pasando un parámetro de la matriz en donde están los valores por pixel de la imágen
     * @param arrayImagen: pasa como parámetro un tipo de dato int[][] como matriz y convierte esa matriz en una imágen y la carga al bufferImage de la variabel Editada
     */
    public void crearImagenGrices(int[][] arrayImagen) {
        Editada = new BufferedImage(ancho, alto,original.getType());
        for (int x = 0; x < ancho; x++) {
            for (int y = 0; y < alto; y++) {
                int newrgb = arrayImagen[x][y] << 16 | arrayImagen[x][y] << 8 | arrayImagen[x][y];
                Editada.setRGB(x, y, new Color(newrgb).getRGB());
            }
        }
    }
    
    /**
     *Crea una imágen a color pasando un parametro de la matriz en donde están los valores rgb por pixel de la imágen
     * @param arrayImagen: pasa como parámetro un tipo de dato int[][] como matriz y convierte esa matriz en una imágen y la carga al bufferImage de la variabel Editada
     */
    public void crearImagenColor(int[][] arrayImagen) {
        Editada = new BufferedImage(ancho, alto, original.getType());
        for (int x = 0; x < ancho; x++) {
            for (int y = 0; y < alto; y++) {
                int newrgb = arrayImagen[x][y] | arrayImagen[x][y] | arrayImagen[x][y];
                Editada.setRGB(x, y, new Color(newrgb).getRGB());
            }
        }
    }
    
            
}
