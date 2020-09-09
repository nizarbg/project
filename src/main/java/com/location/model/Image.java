package com.location.model;

public class Image {
        private int _Id;
        public int getId()
        {
            return this._Id;
        }
        public void setId(int value)
        {
            this._Id = value;
        }

        private String _type_image;
        public String gettype_image()
        {
            return this._type_image;
        }
        public void settype_image(String value)
        {
            this._type_image = value;
        }

        private String _photo;
        public String getphoto()
        {
            return this._photo;
        }
        public void setphoto(String value)
        {
            this._photo = value;
        }

        private java.sql.Date _date_Ajout;
        public java.sql.Date getdate_Ajout()
        {
            return this._date_Ajout;
        }
        public void setdate_Ajout(java.sql.Date value)
        {
            this._date_Ajout = value;
        }

        private java.sql.Date _date_supp;
        public java.sql.Date getdate_supp()
        {
            return this._date_supp;
        }
        public void setdate_supp(java.sql.Date value)
        {
            this._date_supp = value;
        }

        private java.sql.Date _date_miseajour;
        public java.sql.Date getdate_miseajour()
        {
            return this._date_miseajour;
        }
        public void setdate_miseajour(java.sql.Date value)
        {
            this._date_miseajour = value;
        }

        public Image()
        {
            super();
        }
        public Image(int Id_,String type_image_,String photo_,java.sql.Date date_Ajout_,java.sql.Date date_supp_,java.sql.Date date_miseajour_)
        {
            this._Id = Id_;
            this._type_image = type_image_;
            this._photo = photo_;
            this._date_Ajout = date_Ajout_;
            this._date_supp = date_supp_;
            this._date_miseajour = date_miseajour_;
        }
    }

