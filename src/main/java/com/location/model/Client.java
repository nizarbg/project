package com.location.model;

public class Client {
    private int _Id;
    public int getId()
    {
        return this._Id;
    }
    public void setId(int value)
    {
        this._Id = value;
    }

    private String _nationalite;
    public String getnationalite()
    {
        return this._nationalite;
    }
    public void setnationalite(String value)
    {
        this._nationalite = value;
    }

    private String _profession;
    public String getprofession()
    {
        return this._profession;
    }
    public void setprofession(String value)
    {
        this._profession = value;
    }

    private int _codepostal;
    public int getcodepostal()
    {
        return this._codepostal;
    }
    public void setcodepostal(int value)
    {
        this._codepostal = value;
    }
public Client(){
        super();
}

    public Client(int Id_,String nationalite_,String profession_,int codepostal_)
    {
        this._Id = Id_;
        this._nationalite = nationalite_;
        this._profession = profession_;
        this._codepostal = codepostal_;
    }
}

