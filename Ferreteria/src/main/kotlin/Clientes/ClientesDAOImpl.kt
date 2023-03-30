package Clientes

import Articulos.Articulos
import ConexionBD
import Constantes

class ClientesDAOImpl: ClientesDAO {

    val conexion = ConexionBD(Constantes.url, Constantes.user, Constantes.password)
    override fun getClientes(): ArrayList<Clientes>{
        conexion.conectar()
        var query = "SELECT * FROM clientes"
        var ps = conexion.getPreparedStatement(query)
        var arrClt = ArrayList<Clientes>()

        var st = ps?.executeQuery()
        while (st!!.next()){
            var codigo = st.getString("codigo")
            var nombre = st.getString("nombre")
            var direccion = st.getString("direccion")
            var sexo = st.getString("sexo")
            var dni = st.getString("dni")
            var fecha_alta = st.getString("fecha_alta")
            var telefono = st.getString("telefono")
            var cod_postal = st.getString("cod_postal")
            var cliente = Clientes(codigo, nombre, direccion, sexo, dni, fecha_alta, telefono, cod_postal)
            arrClt.add(cliente)
        }
        ps?.close()
        conexion.desconectar()
        return arrClt
    }

    override fun getClienteByID(id: String): Clientes? {
        conexion.conectar()
        var query = "SELECT * FROM clientes WHERE codigo = ?"
        var ps = conexion.getPreparedStatement(query)
        ps?.setString(1, id)
        var st = ps?.executeQuery()
        var cliente: Clientes ?= null

        if (st!!.next()){
            var codigo = st.getString("codigo")
            var nombre = st.getString("nombre")
            var direccion = st.getString("direccion")
            var sexo = st.getString("sexo")
            var dni = st.getString("dni")
            var fecha_alta = st.getString("fecha_alta")
            var telefono = st.getString("telefono")
            var cod_postal = st.getString("cod_postal")
            cliente = Clientes(codigo, nombre, direccion, sexo, dni, fecha_alta, telefono, cod_postal)
        }
        ps?.close()
        conexion.desconectar()
        return cliente
    }

    override fun insertClientes(articulo: Articulos): Boolean {
        conexion.conectar()
        var query = ""
        var ps = conexion.getPreparedStatement(query)

        ps?.close()
        conexion.desconectar()
        return false
    }

    override fun insertArrClientes(arrArticulo: ArrayList<Articulos>): Boolean {
        conexion.conectar()
        var query = ""
        var ps = conexion.getPreparedStatement(query)

        ps?.close()
        conexion.desconectar()
        return false
    }



}