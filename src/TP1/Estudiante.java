package TP1;

public class Estudiante {
    private String nombre;
    private String apellido;
    private String comision;
    private String email;
    private String direccion;

    public Estudiante(String unNombre, String unApellido, String unaComision, String unEmail, String unaDireccion) {
        this.nombre = unNombre;
        this.apellido = unApellido;
        this.comision = unaComision;
        this.email = unEmail;
        this.direccion = unaDireccion;
    }

    public String getApellido() {
        return this.apellido;
    }

    public void setApellido(String unApellido) {
        this.apellido = unApellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getComision() {
        return comision;
    }

    public void setComision(String comision) {
        this.comision = comision;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String tusDatos(){
            String aux = "";
            aux+= "Nombre: " + this.getNombre() +" "+ this.getApellido() + "\n" +
                    "Comisiòn: " + this.getComision() + "\n" +
                    "Email: " + this.getEmail() + "\n" +
                    "Direccion: " + this.getDireccion() + "\n";
            return aux;
    }


}
