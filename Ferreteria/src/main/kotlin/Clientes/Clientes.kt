package Clientes

class Clientes {
    var codigo = ""
    var nombre = ""
    var direccion = ""
    var sexo = ""
    var dni = ""
    var fecha_alta = ""
    var telefono = ""
    var cod_postal = ""

    constructor(codigo:String, nombre: String, direccion: String, sexo: String, dni: String, fechaAlta: String, telefono: String, codPostal:String){
        this.codigo = codigo
        this.nombre = nombre
        this.direccion = direccion
        this.sexo = sexo
        this.dni = dni
        this.fecha_alta = fechaAlta
        this.telefono = telefono
        this.cod_postal = codPostal
    }

    override fun toString(): String {
        return "Clientes(codigo='$codigo', nombre='$nombre', direccion='$direccion', sexo='$sexo', dni='$dni', fecha_alta='$fecha_alta', telefono='$telefono', cod_postal='$cod_postal')"
    }


}