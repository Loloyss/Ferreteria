package Compras

import ConexionBD
import Constantes


class ComprasDAOImpl : ComprasDAO {

    var conexion = ConexionBD(Constantes.url, Constantes.user, Constantes.password)
    override fun getCompras(): ArrayList<Compras> {
        conexion.conectar()

        var compra = ArrayList<Compras>()
        var query = "SELECT * FROM COMPRAS"
        var ps = conexion.getPreparedStatement(query)
        var st = ps?.executeQuery()

        while (st!!.next()) {
            var cod_art = st.getString("cod_art")
            var cod_cli = st.getString("cod_cli")
            var referencia = st.getString("referencia")
            var medida = st.getString("medida")
            var fecha = st.getString("fecha")
            var unidades = st.getInt("unidades")
            var com = Compras(cod_art, cod_cli, referencia, medida, fecha, unidades)
            compra.add(com)
        }

        ps?.close()
        conexion.desconectar()
        return compra
    }

    override fun getComprasByID(id: String): Compras? {
        conexion.conectar()

        var compra: Compras ?= null
        var query = "SELECT * FROM COMPRAS"
        var ps = conexion.getPreparedStatement(query)
        var st = ps?.executeQuery()

        if (st!!.next()) {
            var cod_art = st.getString("cod_art")
            var cod_cli = st.getString("cod_cli")
            var referencia = st.getString("referencia")
            var medida = st.getString("medida")
            var fecha = st.getString("fecha")
            var unidades = st.getInt("unidades")
            var compra = Compras(cod_art, cod_cli, referencia, medida, fecha, unidades)
        }

        ps?.close()
        conexion.desconectar()
        return compra
    }

    override fun insertCompras(Compras: Compras): Boolean {
        conexion.conectar()

        var query = "insert into compras values (?, ?, ?, ?, ?, ?)"

        var ps = conexion.getPreparedStatement(query)
        try {

        ps?.setString(1, Compras.cod_cli )
        ps?.setString(2,Compras.cod_art)
        ps?.setString(3, Compras.referencia)
        ps?.setString(4, Compras.medida)
        ps?.setString(5, Compras.fecha)
        ps?.setInt(6, Compras.unidades)
        var st = ps?.executeUpdate()

        }catch (e: Exception){
            println(e)
        }

        ps?.close()
        conexion.desconectar()

        return true
    }

    override fun insertArrCompras(arrArticulo: ArrayList<Compras>): Boolean {
        conexion.conectar()

        var query = "insert into compras values (?, ?, ?, ?, ?, ?)"

        var ps = conexion.getPreparedStatement(query)

        for (i in arrArticulo){
            try {

            ps?.setString(1, i.cod_cli )
            ps?.setString(2,i.cod_art)
            ps?.setString(3, i.referencia)
            ps?.setString(4, i.medida)
            ps?.setString(5, i.fecha)
            ps?.setInt(6, i.unidades)
            var st = ps?.executeUpdate()
            }catch (e: Exception){
                println(e)
            }
        }

        ps?.close()
        conexion.desconectar()

        return true
    }
    override fun eliminarCompraByart(cod_art:String,ref_art:String):Boolean{
        conexion.conectar()

        val query = "DELETE FROM compras WHERE cod_art = ? AND referencia = ?"

        var ps = conexion.getPreparedStatement(query)


        ps?.setString(1,cod_art)
        ps?.setString(2,ref_art)

        var st = ps?.executeUpdate()
        ps?.close()
        conexion.desconectar()

        return st == 1
    }
}