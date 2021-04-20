package sql;

import java.awt.image.BufferedImage;

import com.sun.prism.Image;

public class Imagen {

	Image imagen;
    String nombre;
    BufferedImage img;
 
    public void setImagen(Image imagen) {
        this.imagen = imagen;
    }
 
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
 
    public Image getImagen() {
        return imagen;
    }
 
    public String getNombre() {
        return nombre;
    }

	public void setImagenB(BufferedImage img) {
		// TODO Auto-generated method stub
		this.img = img;
	}
}
