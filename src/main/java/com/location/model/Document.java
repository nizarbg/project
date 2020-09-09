package com.location.model;

public class Document {

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

        private String _type_document;
        public String gettype_document()
        {
            return this._type_document;
        }
        public void settype_document(String value)
        {
            this._type_document = value;
        }

        private java.sql.Date _Date_document;
        public java.sql.Date getDate_document()
        {
            return this._Date_document;
        }
        public void setDate_document(java.sql.Date value)
        {
            this._Date_document = value;
        }

        private java.sql.Date _date_ajout;
        public java.sql.Date getdate_ajout()
        {
            return this._date_ajout;
        }
        public void setdate_ajout(java.sql.Date value)
        {
            this._date_ajout = value;
        }

        private java.sql.Date _Date_supp;
        public java.sql.Date getDate_supp()
        {
            return this._Date_supp;
        }
        public void setDate_supp(java.sql.Date value)
        {
            this._Date_supp = value;
        }

        private java.sql.Date _Date_miseajour;
        public java.sql.Date getDate_miseajour()
        {
            return this._Date_miseajour;
        }
        public void setDate_miseajour(java.sql.Date value)
        {
            this._Date_miseajour = value;
        }

        public Document()
        {
            super();
        }
        public Document(int Id_,int Id_Voiture_,String type_document_,java.sql.Date Date_document_,java.sql.Date date_ajout_,java.sql.Date Date_supp_,java.sql.Date Date_miseajour_)
        {
            this._Id = Id_;
            this._Id_Voiture = Id_Voiture_;
            this._type_document = type_document_;
            this._Date_document = Date_document_;
            this._date_ajout = date_ajout_;
            this._Date_supp = Date_supp_;
            this._Date_miseajour = Date_miseajour_;
        }
    }
