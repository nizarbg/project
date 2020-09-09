package com.location.model;

public class Piece {

        private int _Id;
        public int getId()
        {
            return this._Id;
        }
        public void setId(int value)
        {
            this._Id = value;
        }

        private int _Id_Voiture;
        public int getId_Voiture()
        {
            return this._Id_Voiture;
        }
        public void setId_Voiture(int value)
        {
            this._Id_Voiture = value;
        }

        private int _Id_Employe;
        public int getId_Employe()
        {
            return this._Id_Employe;
        }
        public void setId_Employe(int value)
        {
            this._Id_Employe = value;
        }

        private String _reference;
        public String getreference()
        {
            return this._reference;
        }
        public void setreference(String value)
        {
            this._reference = value;
        }

        private String _nom;
        public String getnom()
        {
            return this._nom;
        }
        public void setnom(String value)
        {
            this._nom = value;
        }

        private String _marque;
        public String getmarque()
        {
            return this._marque;
        }
        public void setmarque(String value)
        {
            this._marque = value;
        }

        private float _prix;
        public float getprix()
        {
            return this._prix;
        }
        public void setprix(float value)
        {
            this._prix = value;
        }

        private java.sql.Date _dateAchat;
        public java.sql.Date getdateAchat()
        {
            return this._dateAchat;
        }
        public void setdateAchat(java.sql.Date value)
        {
            this._dateAchat = value;
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

        public Piece()
        {
            super();
        }

        public Piece(int Id_,int Id_Voiture_,int Id_Employe_,String reference_,String nom_,String marque_,float prix_,java.sql.Date dateAchat_,java.sql.Date dateAjout_,java.sql.Date dateSupp_,java.sql.Date dateMiseajour_)
        {
            this._Id = Id_;
            this._Id_Voiture = Id_Voiture_;
            this._Id_Employe = Id_Employe_;
            this._reference = reference_;
            this._nom = nom_;
            this._marque = marque_;
            this._prix = prix_;
            this._dateAchat = dateAchat_;
            this._dateAjout = dateAjout_;
            this._dateSupp = dateSupp_;
            this._dateMiseajour = dateMiseajour_;
        }
    }

