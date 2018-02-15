package com.example.u4_ejer_de_parcel;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by DIDACT on 15/02/2018.
 */

public class Restaurante implements Parcelable {

    //Atributos
    String nombre;
    String valor;
    String opinion;

    //Constructor

    public Restaurante(String nombre, String valor, String opinion) {
        this.nombre = nombre;
        this.valor = valor;
        this.opinion = opinion;
    }

    public Restaurante (Parcel p){
        readFromParcel(p);

    }

    //CREATOR

    public static final Creator<Restaurante> CREATOR = new Creator<Restaurante>() {
        @Override
        public Restaurante createFromParcel(Parcel in) {
            return new Restaurante(in);
        }

        @Override
        public Restaurante[] newArray(int size) {
            return new Restaurante[size];
        }
    };

    //Getters & Setters

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getOpinion() {
        return opinion;
    }

    public void setOpinion(String opinion) {
        this.opinion = opinion;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

        dest.writeString(this.nombre);
        dest.writeString(this.valor);
        dest.writeString(this.opinion);

    }

    private void readFromParcel (Parcel p){

        this.nombre = p.readString();
        this.valor = p.readString();
        this.opinion = p.readString();
    }
}
