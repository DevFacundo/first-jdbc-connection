package models;

public class Direccion {
    private Integer id;
    private String calle;
    private Integer altura;
    private Integer idAlumno;

    public Direccion() {
    }

    public Direccion(Integer id, String calle, Integer altura, Integer idAlumno) {
        this.id = id;
        this.calle = calle;
        this.altura = altura;
        this.idAlumno = idAlumno;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public Integer getAltura() {
        return altura;
    }

    public void setAltura(Integer altura) {
        this.altura = altura;
    }

    public Integer getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(Integer idAlumno) {
        this.idAlumno = idAlumno;
    }

    @Override
    public String toString() {
        return "Direccion{" +
                "id=" + id +
                ", calle='" + calle + '\'' +
                ", altura=" + altura +
                ", idAlumno=" + idAlumno +
                '}';
    }
}
