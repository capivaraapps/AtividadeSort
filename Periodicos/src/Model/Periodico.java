/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author 144162026
 */
public class Periodico implements Comparable{
    
    private String issn;
    private String titulo;
    private String area;
    private String estrato;

    public Periodico(){}
    public Periodico(String issn, String titulo, String area, String estrato){
        this.issn = issn;
        this.area = area;
        this.titulo = titulo;
        this.estrato = estrato;
    }
    
    public void setIssn(String issn){ this.issn = issn; }
    public void setTitulo(String titulo){ this.titulo = titulo; }
    public void setArea(String area){ this.area = area; }
    public void setEstrato(String estrato){ this.estrato = estrato; }
    public String getIssn(){ return this.issn; }
    public String getTitulo(){ return this.titulo; }
    public String getArea(){ return this.area; }
    public String getEstrato(){ return this.estrato; }
    
    @Override
    public int compareTo(Object arg0) {
        return ((Periodico)arg0).getIssn().compareTo(this.issn);
    }
    
    @Override
    public String toString(){
        return this.issn + ";" + this.titulo + ";" + this.area + ";" + this.estrato;
    }
    
}
