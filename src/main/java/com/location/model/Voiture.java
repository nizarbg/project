package com.location.model;

public class Voiture
{
    private int _Id;
    public int getId()
    {
        return this._Id;
    }
    public void setId(int value)
    {
        this._Id = value;
    }

    private int _Id_Modele;
    public int getId_Modele()
    {
        return this._Id_Modele;
    }
    public void setId_Modele(int value)
    {
        this._Id_Modele = value;
    }

    private int _Id_Image;
    public int getId_Image()
    {
        return this._Id_Image;
    }
    public void setId_Image(int value)
    {
        this._Id_Image = value;
    }

    private String _matricule;
    public String getmatricule()
    {
        return this._matricule;
    }
    public void setmatricule(String value)
    {
        this._matricule = value;
    }

    private int _kilometrage;
    public int getkilometrage()
    {
        return this._kilometrage;
    }
    public void setkilometrage(int value)
    {
        this._kilometrage = value;
    }

    private String _couleur;
    public String getcouleur()
    {
        return this._couleur;
    }
    public void setcouleur(String value)
    {
        this._couleur = value;
    }

    private float _prixAchat;
    public float getprixAchat()
    {
        return this._prixAchat;
    }
    public void setprixAchat(float value)
    {
        this._prixAchat = value;
    }

    private String _etat;
    public String getetat()
    {
        return this._etat;
    }
    public void setetat(String value)
    {
        this._etat = value;
    }

    private java.sql.Date _dateAjout;
    public java.sql.Date getdateAjout()
    {
        return this._dateAjout;
    }
    public void setdateAjout(java.sql.Date value)
    {
        this._dateAjout = value;
    }

    private java.sql.Date _dateSupp;
    public java.sql.Date getdateSupp()
    {
        return this._dateSupp;
    }
    public void setdateSupp(java.sql.Date value)
    {
        this._dateSupp = value;
    }

    private java.sql.Date _dateMiseajour;
    public java.sql.Date getdateMiseajour()
    {
        return this._dateMiseajour;
    }
    public void setdateMiseajour(java.sql.Date value)
    {
        this._dateMiseajour = value;
    }

    public Voiture()
    {
        super();
    }
    public Voiture(int Id_,int Id_Modele_,int Id_Image_,String matricule_,int kilometrage_,String couleur_,float prixAchat_,String etat_,java.sql.Date dateAjout_,java.sql.Date dateSupp_,java.sql.Date dateMiseajour_)
    {
        this._Id = Id_;
        this._Id_Modele = Id_Modele_;
        this._Id_Image = Id_Image_;
        this._matricule = matricule_;
        this._kilometrage = kilometrage_;
        this._couleur = couleur_;
        this._prixAchat = prixAchat_;
        this._etat = etat_;
        this._dateAjout = dateAjout_;
        this._dateSupp = dateSupp_;
        this._dateMiseajour = dateMiseajour_;
    }
}
