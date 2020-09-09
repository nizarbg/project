package com.location.model;

public class Reservation {
        private int _Id;
        public int getId()
        {
            return this._Id;
        }
        public void setId(int value)
        {
            this._Id = value;
        }

        private int _Id_Client;
        public int getId_Client()
        {
            return this._Id_Client;
        }
        public void setId_Client(int value)
        {
            this._Id_Client = value;
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

        private java.sql.Date _dateDebut;
        public java.sql.Date getdateDebut()
        {
            return this._dateDebut;
        }
        public void setdateDebut(java.sql.Date value)
        {
            this._dateDebut = value;
        }

        private String _lieuPrise;
        public String getlieuPrise()
        {
            return this._lieuPrise;
        }
        public void setlieuPrise(String value)
        {
            this._lieuPrise = value;
        }

        private java.sql.Date _dateFin;
        public java.sql.Date getdateFin()
        {
            return this._dateFin;
        }
        public void setdateFin(java.sql.Date value)
        {
            this._dateFin = value;
        }

        private String _lieuRetour;
        public String getlieuRetour()
        {
            return this._lieuRetour;
        }
        public void setlieuRetour(String value)
        {
            this._lieuRetour = value;
        }

        private String _description;
        public String getdescription()
        {
            return this._description;
        }
        public void setdescription(String value)
        {
            this._description = value;
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

        public Reservation()
        {
            super();
        }
        public Reservation(int Id_,int Id_Client_,int Id_Voiture_,int Id_Employe_,java.sql.Date dateDebut_,String lieuPrise_,java.sql.Date dateFin_,String lieuRetour_,String description_,java.sql.Date dateAjout_,java.sql.Date dateSupp_,java.sql.Date dateMiseajour_)
        {
            this._Id = Id_;
            this._Id_Client = Id_Client_;
            this._Id_Voiture = Id_Voiture_;
            this._Id_Employe = Id_Employe_;
            this._dateDebut = dateDebut_;
            this._lieuPrise = lieuPrise_;
            this._dateFin = dateFin_;
            this._lieuRetour = lieuRetour_;
            this._description = description_;
            this._dateAjout = dateAjout_;
            this._dateSupp = dateSupp_;
            this._dateMiseajour = dateMiseajour_;
        }
    }

