package com.location.model;

public class Modele {
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

        private String _carburant;
        public String getcarburant()
        {
            return this._carburant;
        }
        public void setcarburant(String value)
        {
            this._carburant = value;
        }

        private float _puissance;
        public float getpuissance()
        {
            return this._puissance;
        }
        public void setpuissance(float value)
        {
            this._puissance = value;
        }

        private int _nbPortes;
        public int getnbPortes()
        {
            return this._nbPortes;
        }
        public void setnbPortes(int value)
        {
            this._nbPortes = value;
        }

        private int _nbPlaces;
        public int getnbPlaces()
        {
            return this._nbPlaces;
        }
        public void setnbPlaces(int value)
        {
            this._nbPlaces = value;
        }

        private float _prixLocation;
        public float getprixLocation()
        {
            return this._prixLocation;
        }
        public void setprixLocation(float value)
        {
            this._prixLocation = value;
        }

        private String _boite;
        public String getboite()
        {
            return this._boite;
        }
        public void setboite(String value)
        {
            this._boite = value;
        }

        private float _cylindre;
        public float getcylindre()
        {
            return this._cylindre;
        }
        public void setcylindre(float value)
        {
            this._cylindre = value;
        }

        private int _nbcylindres;
        public int getnbcylindres()
        {
            return this._nbcylindres;
        }
        public void setnbcylindres(int value)
        {
            this._nbcylindres = value;
        }

        private String _transmission;
        public String gettransmission()
        {
            return this._transmission;
        }
        public void settransmission(String value)
        {
            this._transmission = value;
        }

        private int _dateSortie;
        public int getdateSortie()
        {
            return this._dateSortie;
        }
        public void setdateSortie(int value)
        {
            this._dateSortie = value;
        }

        public Modele()
        {
            super();
        }
        public Modele(int Id_,int Id_Image_,String nom_,String marque_,String carburant_,float puissance_,int nbPortes_,int nbPlaces_,float prixLocation_,String boite_,float cylindre_,int nbcylindres_,String transmission_,int dateSortie_)
        {
            this._Id = Id_;
            this._Id_Image = Id_Image_;
            this._nom = nom_;
            this._marque = marque_;
            this._carburant = carburant_;
            this._puissance = puissance_;
            this._nbPortes = nbPortes_;
            this._nbPlaces = nbPlaces_;
            this._prixLocation = prixLocation_;
            this._boite = boite_;
            this._cylindre = cylindre_;
            this._nbcylindres = nbcylindres_;
            this._transmission = transmission_;
            this._dateSortie = dateSortie_;
        }
    }

