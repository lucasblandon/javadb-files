/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo;

/**
 *
 * @author Lucas
 */
public class variables {
    String TipoProducto;
    String Producto;
    String NombreProducto;
    String  Saldo;


    public variables(String TipoProducto, String Producto, String NombreProducto, String Saldo ) {
        this.TipoProducto = TipoProducto;
        this.Producto = Producto;
        this.NombreProducto = NombreProducto;
        this.Saldo = Saldo;
    }

    public String getTipoProducto() {
        return TipoProducto;
    }

    public void setTipoProducto(String TipoProducto) {
        this.TipoProducto= TipoProducto;
    }
    
       public String getProducto() {
        return Producto;
    }

    public void setProducto(String Producto) {
        this.Producto= Producto;
    }
    
      public String getNombreProducto() {
        return NombreProducto;
    }

    public void setNombreProducto(String NombreProducto) {
        this.NombreProducto= NombreProducto;
    }

    public String getSaldo() {
        return Saldo;
    }

    public void setSaldo(String Saldo) {
        this.Saldo= Saldo;
    }
   
    
}
