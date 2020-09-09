package com.location.model;

public class Contrat {

        private int _Id;
        public int getId()
        {
            return this._Id;
        }
        public void setId(int value)
        {
            this._Id = value;
        }

        private int _Id_Reservation;
        public int getId_Reservation()
        {
            return this._Id_Reservation;
        }
        public void setId_Reservation(int value)
        {
            this._Id_Reservation = value;
        }

        private int _numContrat;
        public int getnumContrat()
        {
            return this._numContrat;
        }
        public void setnumContrat(int value)
        {
            this._numContrat = value;
        }

        private float _prixHt;
        public float getprixHt()
        {
            return this._prixHt;
        }
        public void setprixHt(float value)
        {
            this._prixHt = value;
        }

        private float _tva;
        public float gettva()
        {
            return this._tva;
        }
        public void settva(float value)
        {
            this._tva = value;
        }

        private float _prixTT;
        public float getprixTT()
        {
            return this._prixTT;
        }
        public void setprixTT(float value)
        {
            this._prixTT = value;
        }

        private String _modePaiement;
        public String getmodePaiement()
        {
            return this._modePaiement;
        }
        public void setmodePaiement(String value)
        {
            this._modePaiement = value;
        }

        private float _acompte;
        public float getacompte()
        {
            return this._acompte;
        }
        public void setacompte(float value)
        {
            this._acompte = value;
        }

        private int _caution;
        public int getcaution()
        {
            return this._caution;
        }
        public void setcaution(int value)
        {
            this._caution = value;
        }

        private int _dureeRetard;
        public int getdureeRetard()
        {
            return this._dureeRetard;
        }
        public void setdureeRetard(int value)
        {
            this._dureeRetard = value;
        }

        private java.sql.Date _dateProlongation;
        public java.sql.Date getdateProlongation()
        {
            return this._dateProlongation;
        }
        public void setdateProlongation(java.sql.Date value)
        {
            this._dateProlongation = value;
        }

        private java.sql.Date _dateSignature;
        public java.sql.Date getdateSignature()
        {
            return this._dateSignature;
        }
        public void setdateSignature(java.sql.Date value)
        {
            this._dateSignature = value;
        }

        private float _penaliteJour;
        public float getpenaliteJour()
        {
            return this._penaliteJour;
        }
        public void setpenaliteJour(float value)
        {
            this._penaliteJour = value;
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

        public Contrat()
        {
            super();
        }
        public Contrat(int Id_,int Id_Reservation_,int numContrat_,float prixHt_,float tva_,float prixTT_,String modePaiement_,float acompte_,int caution_,int dureeRetard_,java.sql.Date dateProlongation_,java.sql.Date dateSignature_,float penaliteJour_,java.sql.Date dateAjout_,java.sql.Date dateSupp_,java.sql.Date dateMiseajour_)
        {
            this._Id = Id_;
            this._Id_Reservation = Id_Reservation_;
            this._numContrat = numContrat_;
            this._prixHt = prixHt_;
            this._tva = tva_;
            this._prixTT = prixTT_;
            this._modePaiement = modePaiement_;
            this._acompte = acompte_;
            this._caution = caution_;
            this._dureeRetard = dureeRetard_;
            this._dateProlongation = dateProlongation_;
            this._dateSignature = dateSignature_;
            this._penaliteJour = penaliteJour_;
            this._dateAjout = dateAjout_;
            this._dateSupp = dateSupp_;
            this._dateMiseajour = dateMiseajour_;
        }
    }

