
    package com.location.model;


    public class Utilisateur
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

        private int _Id_Image;
        public int getId_Image()
        {
            return this._Id_Image;
        }
        public void setId_Image(int value)
        {
            this._Id_Image = value;
        }

        private int _numCin;
        public int getnumCin()
        {
            return this._numCin;
        }
        public void setnumCin(int value)
        {
            this._numCin = value;
        }

        private java.sql.Date _dateCin;
        public java.sql.Date getdateCin()
        {
            return this._dateCin;
        }
        public void setdateCin(java.sql.Date value)
        {
            this._dateCin = value;
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

        private String _prenom;
        public String getprenom()
        {
            return this._prenom;
        }
        public void setprenom(String value)
        {
            this._prenom = value;
        }

        private String _motDePasse;
        public String getmotDePasse()
        {
            return this._motDePasse;
        }
        public void setmotDePasse(String value)
        {
            this._motDePasse = value;
        }

        private int _numTel;
        public int getnumTel()
        {
            return this._numTel;
        }
        public void setnumTel(int value)
        {
            this._numTel = value;
        }

        private String _email;
        public String getemail()
        {
            return this._email;
        }
        public void setemail(String value)
        {
            this._email = value;
        }

        private String _adresse;
        public String getadresse()
        {
            return this._adresse;
        }
        public void setadresse(String value)
        {
            this._adresse = value;
        }

        private int _numPermis;
        public int getnumPermis()
        {
            return this._numPermis;
        }
        public void setnumPermis(int value)
        {
            this._numPermis = value;
        }

        private java.sql.Date _datePermis;
        public java.sql.Date getdatePermis()
        {
            return this._datePermis;
        }
        public void setdatePermis(java.sql.Date value)
        {
            this._datePermis = value;
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

        public Utilisateur()
        {
            super();
        }

        public Utilisateur(int Id_,int Id_Image_,int numCin_,java.sql.Date dateCin_,String nom_,String prenom_,String motDePasse_,int numTel_,String email_,String adresse_,int numPermis_,java.sql.Date datePermis_,java.sql.Date dateAjout_,java.sql.Date dateSupp_,java.sql.Date dateMiseajour_)
        {
            this._Id = Id_;
            this._Id_Image = Id_Image_;
            this._numCin = numCin_;
            this._dateCin = dateCin_;
            this._nom = nom_;
            this._prenom = prenom_;
            this._motDePasse = motDePasse_;
            this._numTel = numTel_;
            this._email = email_;
            this._adresse = adresse_;
            this._numPermis = numPermis_;
            this._datePermis = datePermis_;
            this._dateAjout = dateAjout_;
            this._dateSupp = dateSupp_;
            this._dateMiseajour = dateMiseajour_;
        }
    }