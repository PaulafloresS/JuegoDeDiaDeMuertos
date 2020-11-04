/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AtrapaElPanDeMuerto;
import java.awt.Graphics;

import javax.swing.ImageIcon;

public class Jugador extends Elemento {

	private boolean invulnerable;
	
	public Jugador(String recurso,int x, int y,int tx, int vx, int vy) {
		super(recurso, x, y, tx, vx, vy);
		invulnerable=false;
	}

	@Override
	public void dibuja(Graphics g) {
		if (isCrashed()){
			imagen = new ImageIcon(this.getClass().getResource("mort.png")).getImage();
			g.drawImage(imagen,getX(),getY(),getXt(),getXt(),null);
		}else{
			if(isInvulnerable()){
				imagen = new ImageIcon(this.getClass().getResource("calavera-inv.png")).getImage();
				g.drawImage(imagen,getX(),getY(),getXt(),getXt(),null);
			}else{
				imagen = new ImageIcon(this.getClass().getResource("calavera.png")).getImage();
				g.drawImage(imagen,getX(),getY(),getXt(),getXt(),null);
			}
		}
	}

	public boolean isInvulnerable() {
		return invulnerable;
	}
	
	@Override
	public void anima() {
		setX(getX()+getVx());
		setY(getY()+getVy());
		if (getX()<0 || getY()<0 || getX()>850 || getY()>850){
			if(isInvulnerable()){
				if(getX()<0){
					setX(850);
				}
				if(getX()>850){
					setX(0);
				}
				if(getY()<0){
					setY(550);
				}
				if(getY()>550){
					setY(0);
				}
			}else{
				setCrashed(true);
			}
		}
	}

	public void setInvulnerable(boolean invulnerable) {
		this.invulnerable = invulnerable;
	}

}

