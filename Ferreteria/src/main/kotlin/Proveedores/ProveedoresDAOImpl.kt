package Proveedores

import ConexionBD
import Suministros.Suministros
import testConexion

class ProveedoresDAOImpl : ProveedoresDAO, testConexion() {

    override fun getPremios(): ArrayList<Proveedores> {
        conexion.conectar()

        var arrSm = ArrayList<Proveedores>()
        var query = "SELECT * FROM Proveedores"
        var ps = conexion.getPreparedStatement(query)
        var st = ps?.executeQuery()

        while (st!!.next()) {
            var cif = st.getString("cif")
            var razon_soc = st.getString("razon_soc")
            var direccion = st.getString("direccion")
            var cod_postal = st.getString("cod_postal")

            var sm = Proveedores(cif, razon_soc, direccion, cod_postal)
            arrSm.add(sm)
        }

        ps?.close()
        conexion.desconectar()
        return arrSm
    }

    override fun getPpremioID(id: String): Proveedores? {
        conexion.conectar()

        var premio: Proveedores? = null
        var query = "SELECT * FROM Proveedores where cif = ?"
        var ps = conexion.getPreparedStatement(query)
        ps?.setString(1, id)

        var st = ps?.executeQuery()

        if (st!!.next()) {
            var cif = st.getString("cif")
            var razon_soc = st.getString("razon_soc")
            var direccion = st.getString("direccion")
            var cod_postal = st.getString("cod_postal")

            premio = Proveedores(cif, razon_soc, direccion, cod_postal)
        }

        ps?.close()
        conexion.desconectar()
        return premio
    }

    override fun insertPremios(Proveedores: Proveedores): Boolean {
        conexion.conectar()

        var premio: Proveedores? = null
        var query = "insert into proveedores values (?, ?, ?, ?)"
        var ps = conexion.getPreparedStatement(query)

        ps?.setString(1, Proveedores.cif)
        ps?.setString(2, Proveedores.razon_soc)
        ps?.setString(3, Proveedores.direccion)
        ps?.setString(4, Proveedores.cod_postal)

        var st = ps?.executeUpdate()

        ps?.close()
        conexion.desconectar()
        return true
    }

    override fun insertArrPremios(arrProv: ArrayList<Proveedores>): Boolean {

        var premio: Proveedores? = null
        var query = "insert into proveedores values (?, ?, ?, ?)"
        var ps = conexion.getPreparedStatement(query)
        try {
            for (i in arrProv){
                ps?.setString(1, i.cif)
                ps?.setString(2, i.razon_soc)
                ps?.setString(3, i.direccion)
                ps?.setString(4, i.cod_postal)
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