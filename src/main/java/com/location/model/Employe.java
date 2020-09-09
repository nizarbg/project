package com.location.model;

public class Employe  {
        private int _Id;
        public int getId()
        {
            return this._Id;
        }
        public void setId(int value)
        {
            this._Id = value;
        }

        private String _role;
        public String getrole()
        {
            return this._role;
        }
        public void setrole(String value)
        {
            this._role = value;
        }

        private java.sql.Date _dateEmbauch;
        public java.sql.Date getdateEmbauch()
        {
            return this._dateEmbauch;
        }
        public void setdateEmbauch(java.sql.Date value)
        {
            this._dateEmbauch = value;
        }

        private float _salaire;
        public float getsalaire()
        {
            return this._salaire;
        }
        public void setsalaire(float value)
        {
            this._salaire = value;
        }

        public Employe()
        {
            super();
        }
        public Employe(int Id_,String role_,java.sql.Date dateEmbauch_,float salaire_)
        {
            this._Id = Id_;
            this._role = role_;
            this._dateEmbauch = dateEmbauch_;
            this._salaire = salaire_;
        }
    }
