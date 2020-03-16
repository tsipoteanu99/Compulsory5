package com.company;


// AM CREAT ACEASTA EXCEPTIE CUSTOM PENTRU A TRATA O EXCEPTIE CARE NU A FOST IMPLEMENTATA IMPLICIT, DECI A TREBUIT SA I IMPLEMENTEZ EU PENTRU A SE PRETA PE PROBLEMA MEA, CEA DE A VERIFICA DACA DOCUMENTUL PRIMIT ESTE CATALOG.


public class InvalidCatalogException extends Exception {

    public InvalidCatalogException(Exception ex){
        super("Invalid catalog file.", ex);
    }
}
