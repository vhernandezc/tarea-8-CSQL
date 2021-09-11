/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

/**
 *
 * @author vh367
 */
public class clsAlumno {
    private int codigo;
    private String empleado;
    private int Enero;
    private int Febrero;
    private int Marzo;
    @Override
    public String toString() {
        return "clsAlumno{" + "codigo=" + codigo + ", empleado=" + empleado + ", Enero=" + Enero + ", Febrero=" + Febrero +"Marzo="+Marzo+ '}';
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getEmpleado() {
        return empleado;
    }

    public void setEmpleado(String empleado) {
        this.empleado = empleado;
    }

    public int getEnero() {
        return Enero;
    }

    public void setEnero(int Enero) {
        this.Enero = Enero;
    }

    public int getFebrero() {
        return Febrero;
    }

    public void setFebrero(int Febrero) {
        this.Febrero = Febrero;
    }

    public int getMarzo() {
        return Marzo;
    }

    public void setMarzo(int Marzo) {
        this.Marzo = Marzo;
    }

   
}
