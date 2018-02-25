package datos_multiplos;

public enum miUtilidades {
    PRECIO_PROTEC("PRECIO_PROTEC",1.15),
    PRECIO_MIN("PRECIO_MIN",1.17),
    PRECIO_PROM("PRECIO_PROM",1.20),
    PRECIO_MAX("PRECIO_MAX",1.25);
    //PRECIO_PV_GRAL("PRECIO_PV_GRAL",0.1);
    
    private final String nombre; //Color de la madera
    private final double porcentaje; //Peso específico de la madera
 
    miUtilidades (String nombre, double porcentaje) { 
        this.nombre = nombre;
        this.porcentaje = porcentaje;
    }
    
    public String getNombre() { return nombre; }
    public double getProcentaje() { return porcentaje; }
    
}
