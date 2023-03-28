package Poblaciones

import ConexionBD
import Constantes
import Medidas.Medidas

class PoblacionesDAOImpl: PoblacionesDAO {

    val conexion = ConexionBD(Constantes.url, Constantes.user, Constantes.password)
    override fun getPoblaciones(): ArrayList<Poblaciones> {

        conexion.conectar()

        var arrPbl = ArrayList<Poblaciones>()
        var query = "SELECT * FROM Poblaciones"
        var ps = conexion.getPreparedStatement(query)
        var st = ps?.executeQuery()

        while (st!!.next()) {
            var cod_postal = st.getString("cod_postal")
            var poblacion = st.getString("poblacion")
            var provincia = st.getString("provincia")
            var pblt = Poblaciones(cod_postal, poblacion, provincia)

            arrPbl.add(pblt)
        }

        ps?.close()
        conexion.desconectar()

        return arrPbl
    }

    override fun getPoblacioneyID(id: String): Poblaciones? {

        var pbl: Poblaciones ?= null
        conexion.conectar()

        var query = "SELECT * FROM Poblaciones where cod_postal = ?"
        var ps = conexion.getPreparedStatement(query)
        var st = ps?.executeQuery()

        ps?.setString(1, id)

        if (st!!.next()) {
            var cod_postal = st.getString("cod_postal")
            var poblacion = st.getString("poblacion")
            var provincia = st.getString("provincia")
            var pblt = Poblaciones(cod_postal, poblacion, provincia)
        }

        ps?.close()
        conexion.desconectar()

        return pbl
    }

    override fun insertPoblaciones(Poblaciones: Poblaciones): Boolean {
        conexion.conectar()

        var query = "insert into compras values (?, ?, ?, ?)"

        var ps = conexion.getPreparedStatement(query)

        try {
            ps?.setString(1, Poblaciones.cod_postal)
            ps?.setString(2,Poblaciones.poblacion)
            ps?.setString(3, Poblaciones.provincia)
            var st = ps?.executeUpdate()

        }catch (e: Exception){
            println(e)
        }

        ps?.close()
        conexion.desconectar()

        return true
    }

    override fun insertArr(arrCompras: ArrayList<Poblaciones>): Boolean {

        return false
    }
}