package Suministros

import ConexionBD
import Proveedores.Proveedores


class SuministrosDAOImpl : SuministrosDAO {
    val conexion = ConexionBD(Constantes.url, Constantes.user, Constantes.password)
    override fun getSuministros(): ArrayList<Suministros> {
        conexion.conectar()

        var arrSm = ArrayList<Suministros>()
        var query = "SELECT * FROM premios"
        var ps = conexion.getPreparedStatement(query)
        var st = ps?.executeQuery()

        while (st!!.next()) {
            var cif_pro = st.getString("cif_pro")
            var cod_art = st.getString("cod_art")
            var referencia = st.getString("referencia")
            var medida = st.getString("medida")
            var fecha = st.getString("fecha")
            var unidades = st.getInt("unidades")
            var precio = st.getInt("precio")
            var sm = Suministros(cif_pro, cod_art, referencia, medida, fecha, unidades, precio)
            arrSm.add(sm)
        }

        ps?.close()
        conexion.desconectar()
        return arrSm
    }

    override fun getSuministrosID(id: String): Suministros? {

        conexion.conectar()

        var sm: Suministros ?= null
        var query = "SELECT * FROM suminsitros where cif_pro = ?"
        var ps = conexion.getPreparedStatement(query)
        ps?.setString(1,id)
        var st = ps?.executeQuery()

        if (st!!.next()) {
            var cif_pro = st.getString("cif_pro")
            var cod_art = st.getString("cod_art")
            var referencia = st.getString("referencia")
            var medida = st.getString("medida")
            var fecha = st.getString("fecha")
            var unidades = st.getInt("unidades")
            var precio = st.getInt("precio")
            sm = Suministros(cif_pro, cod_art, referencia, medida, fecha, unidades, precio)
        }

        ps?.close()
        conexion.desconectar()
        return sm
    }

    override fun insertSuministros(Suministros: Suministros): Boolean {
        return false
    }

    override fun insertArrSuministros(arrSum: ArrayList<Suministros>): Boolean {
        var premio: Proveedores? = null
        var query = "insert into proveedores values (?, ?, ?, ?, ?, ?, ?)"
        var ps = conexion.getPreparedStatement(query)
        try {
            for (i in arrSum){
                ps?.setString(1, i.cif_pro)
                ps?.setString(2, i.cod_art)
                ps?.setString(3, i.referencia)
                ps?.setString(4, i.fecha)
                ps?.setString(5, i.fecha)
                ps?.setInt(6, i.unidades)
                ps?.setInt(7, i.precio)
                var st = ps?.executeUpdate()
            }
        }catch (e: Exception){
            println(e)
        }

        ps?.close()
        conexion.desconectar()

        return true
    }

}