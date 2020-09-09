package com.location.model;

public class Entretient {

        private int _Id;

    public Entretient() {
        super();
    }

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

        private String _nom;
        public String getnom()
        {
            return this._nom;
        }
        public void setnom(String value)
        {
            this._nom = value;
        }

        private String _type_entretient;
        public String gettype_entretient()
        {
            return this._type_entretient;
        }
        public void settype_entretient(String value)
        {
            this._type_entretient = value;
        }

        private java.sql.Date _dateEntre;
        public java.sql.Date getdateEntre()
        {
            return this._dateEntre;
        }
        public void setdateEntre(java.sql.Date value)
        {
            this._dateEntre = value;
        }

        private java.sql.Date _dateSortie;
        public java.sql.Date getdateSortie()
        {
            return this._dateSortie;
        }
        public void setdateSortie(java.sql.Date value)
        {
            this._dateSortie = value;
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


        public Entretient(int Id_,int Id_Voiture_,int Id_Employe_,String nom_,String type_entretient_,java.sql.Date dateEntre_,java.sql.Date dateSortie_,java.sql.Date dateAjout_,java.sql.Date dateSupp_,java.sql.Date dateMiseajour_)
        {
            this._Id = Id_;
            this._Id_Voiture = Id_Voiture_;
            this._Id_Employe = Id_Employe_;
            this._nom = nom_;
            this._type_entretient = type_entretient_;
            this._dateEntre = dateEntre_;
            this._dateSortie = dateSortie_;
            this._dateAjout = dateAjout_;
            this._dateSupp = dateSupp_;
            this._dateMiseajour = dateMiseajour_;
        }
    }

