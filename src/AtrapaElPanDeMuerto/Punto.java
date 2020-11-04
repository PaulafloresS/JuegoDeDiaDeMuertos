/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AtrapaElPanDeMuerto;
import java.awt.Graphics;

public class Punto extends Elemento {

	public Punto(String recurso, int x, int y, int xt, int vx, int vy) {
		super(recurso, x, y, xt, vx, vy);
	}

	@Override
	public void dibuja(Graphics g) {
		g.drawImage(imagen,getX(),getY(),getXt(),getXt(),null);
	}
	
	@Override
	public void anima() {
		setX(getX()+getVx());
		setY(getY()+getVy());
		if (getX()<0){
			setVx(-getVx());
		}
		if (getY()<0){
			setVy(-getVy());
		}
		if (getX()>850){
			setVx(-getVx());
		}		
		if (getY()>550){
			setVy(-getVy());
		}
		
	}
	

}