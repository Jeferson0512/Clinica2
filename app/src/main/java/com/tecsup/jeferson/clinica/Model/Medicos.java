package com.tecsup.jeferson.clinica.Model;

/**
 * Created by Usuario on 21/11/2017.
 */

public class Medicos {

    private String id;
    private String nombre;
    private String apellido_paterno;
    private String apellido_materno;
    private String tipo_doc_identidad;
    private String num_doc_identidad;
    private String imagen_perfil;
    private String especialidad;
    private String telefono;
    private String celular;
    private String hora_entrada;
    private String hora_salida;
    private String genero;
    private String usuario_id;

    public Medicos() {
    }

    public Medicos(String id, String nombre, String apellido_paterno, String apellido_materno, String tipo_doc_identidad, String num_doc_identidad,String imagen_perfil,String especialidad, String telefono, String celular, String hora_entrada, String hora_salida, String genero, String usuario_id) {
        this.id = id;
        this.nombre = nombre;
        this.apellido_paterno = apellido_paterno;
        this.apellido_materno = apellido_materno;
        this.tipo_doc_identidad = tipo_doc_identidad;
        this.num_doc_identidad = num_doc_identidad;
        this.imagen_perfil=imagen_perfil;
        this.especialidad=especialidad;
        this.telefono = telefono;
        this.celular = celular;
        this.hora_entrada = hora_entrada;
        this.hora_salida = hora_salida;
        this.genero = genero;
        this.usuario_id = usuario_id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido_paterno() {
        return apellido_paterno;
    }

    public void setApellido_paterno(String apellido_paterno) {
        this.apellido_paterno = apellido_paterno;
    }

    public String getApellido_materno() {
        return apellido_materno;
    }

    public void setApellido_materno(String apellido_materno) {
        this.apellido_materno = apellido_materno;
    }

    public String getTipo_doc_identidad() {
        return tipo_doc_identidad;
    }

    public void setTipo_doc_identidad(String tipo_doc_identidad) {
        this.tipo_doc_identidad = tipo_doc_identidad;
    }

    public String getNum_doc_identidad() {
        return num_doc_identidad;
    }

    public void setNum_doc_identidad(String num_doc_identidad) {
        this.num_doc_identidad = num_doc_identidad;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getHora_entrada() {
        return hora_entrada;
    }

    public void setHora_entrada(String hora_entrada) {
        this.hora_entrada = hora_entrada;
    }

    public String getHora_salida() {
        return hora_salida;
    }

    public void setHora_salida(String hora_salida) {
        this.hora_salida = hora_salida;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getUsuario_id() {
        return usuario_id;
    }

    public void setUsuario_id(String usuario_id) {
        this.usuario_id = usuario_id;
    }

    public String getImagen_perfil() {
        return imagen_perfil;
    }

    public void setImagen_perfil(String imagen_perfil) {
        this.imagen_perfil = imagen_perfil;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    @Override
    public String toString() {
        return "Medicos{" +
                "id='" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellido_paterno='" + apellido_paterno + '\'' +
                ", apellido_materno='" + apellido_materno + '\'' +
                ", tipo_doc_identidad='" + tipo_doc_identidad + '\'' +
                ", num_doc_identidad='" + num_doc_identidad + '\'' +
                ", imagen_perfil='" + imagen_perfil + '\'' +
                ", especialidad='" + especialidad + '\'' +
                ", telefono='" + telefono + '\'' +
                ", celular='" + celular + '\'' +
                ", hora_entrada='" + hora_entrada + '\'' +
                ", hora_salida='" + hora_salida + '\'' +
                ", genero='" + genero + '\'' +
                ", usuario_id='" + usuario_id + '\'' +
                '}';
    }
}
