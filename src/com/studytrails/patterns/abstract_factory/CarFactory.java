package com.studytrails.patterns.abstract_factory;

public abstract class CarFactory
{
   public abstract Insurance getInsurance(String name);
   public abstract Maintenance getMaintenance(String name);
   public abstract Car getCar(String name);
   
}
