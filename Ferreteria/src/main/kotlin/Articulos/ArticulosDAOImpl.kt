package Articulos

import ConexionBD
import Constantes
import java.sql.PreparedStatement

class ArticulosDAOImpl : ArticulosDAO {

    val conexion = ConexionBD(Constantes.url, Constantes.user, Constantes.password)
    override fun getArticulos(): ArrayList<Articulos> {
        conexion.conectar()

        var query = "SELECT * FROM ARTICULOS"

        var ps = conexion?.getPreparedStatement(query)
        var artcRtn = ArrayList<Articulos>()

        var st = ps?.executeQuery()
        while (st!!.next()) {
            var cod_art = st.getString("cod_art")
            var ref_art = st.getString("ref_art")
            var denomina = st.getString("denomina")
            var precio = st.getFloat("precio")
            var descuento = st.getFloat("descuento")

            var arti = Articulos(cod_art, ref_art, denomina, precio, descuento)
            artcRtn.add(arti)
        }
        ps?.close()
        conexion.desconectar()
        return artcRtn
    }

    override fun getArticuloByID(cod_art: String, ref_art: String): Articulos {
        conexion.conectar()

        var query = "SELECT * FROM ARTICULOS WHERE cod_art= ? and ref_art= ?"

        var ps = conexion?.getPreparedStatement(query)

        ps?.setString(1, cod_art)
        ps?.setString(2, ref_art)
        var artRtn: Articulos? = null

        var st = ps?.executeQuery()
        while (st!!.next()) {
            var cod_art = st.getString("cod_art")
            var ref_art = st.getString("ref_art")
            var denomina = st.getString("denomina")
            var precio = st.getFloat("precio")
            var descuento = st.getFloat("descuento")

            artRtn = Articulos(cod_art, ref_art, denomina, precio, descuento)
        }

        ps?.close()
        conexion.desconectar()
        return artRtn!!
    }

    override fun insertArticulo(articulo: Articulos): Boolean {
        conexion.conectar()

        var query = "insert into articulos values (?, ?, ?, ?, ?)"

        var ps = conexion.getPreparedStatement(query)

        ps?.setString(1,articulo.cod_art)
        ps?.setString(2,articulo.ref_art)
        ps?.setString(3, articulo.denomina)
        ps?.setFloat(4, articulo.precio)
        ps?.setFloat(5, articulo.descuento)
        var st = ps?.executeUpdate()

        ps?.close()
        conexion.desconectar()

        return st == 1
    }

    override fun insertArrArticulo(arrArticulo: ArrayList<Articulos>): Boolean{
        conexion.conectar()
        var arrArt = false

        var query = "insert into articulos values (?, ?, ?, ?, ?)"
        var ps = conexion.getPreparedStatement(query)
        var st: PreparedStatement ?= null

        for (i in arrArticulo){
            ps?.setString(1,i.cod_art)
            ps?.setString(2,i.ref_art)
            ps?.setString(3, i.denomina)
            ps?.setFloat(4, i.precio)
            ps?.setFloat(5, i.descuento)
            var st = ps?.executeUpdate()
        }

        ps?.close()
        conexion.desconectar()

        return true
    }
    override fun modificarArticulo(articulo: Articulos): Boolean {
        conexion.conectar()

        val query = "UPDATE articulos SET denominacion = ? , precio = ? , descuento = ? WHERE cod_art = ? AND cod_ref = ?"

        var ps = conexion.getPreparedStatement(query)
        var st = ps?.executeUpdate()

        ps?.setString(1,articulo.denomina)
        ps?.setFloat(2, articulo.precio)
        ps?.setFloat(3, articulo.descuento)
        ps?.setString(4, articulo.cod_art)
        ps?.setString(5, articulo.ref_art)

        ps?.close()
        conexion.desconectar()

        return st == 1
    }
    override fun `eliminarArticuloByCod-Y-Ref_Art`(cod_art :String, ref_art:String): Boolean {
        conexion.conectar()

        val query = "DELETE FROM articulos WHERE cod_art = ? AND cod_ref = ?"

        var ps = conexion.getPreparedStatement(query)
        var st = ps?.executeUpdate()

        ps?.setString(1,cod_art)
        ps?.setString(2,ref_art)


        ps?.close()
        conexion.desconectar()

        return st == 1
    }
}